---
license: >
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.

title: Android 外挂程式
toc_title: Android
---

# Android 外挂程式

此部分提供了如何在 Android 平台上实现本机外挂程式代码的详细资讯。 之前读这篇文章，请参阅应用程式外挂程式外挂程式的结构和其共同的 JavaScript 介面的概述。 这一节继续表明通信从科尔多瓦 web 视图的本机平台和后面的示例*回声*外挂程式。 另一个示例，请参阅还在[CordovaPlugin.java][1]的评论.

 [1]: https://github.com/apache/cordova-android/blob/master/framework/src/org/apache/cordova/CordovaPlugin.java

Android 外挂程式基于科尔多瓦-Android，Android 的 web 视图包括与附加到它上面的钩子。 外挂程式被表示为类映射的 `config.xml` 档。 外挂程式包括至少一个扩展的 JAVA 类的 `CordovaPlugin` 类，重写的一个其 `execute` 方法。 作为最佳实践，该外挂程式还应处理 `[pause](../../../cordova/events/events.pause.html)` 和 `[resume](../../../cordova/events/events.resume.html)` 事件，以及任何外挂程式之间传递的消息。 外挂程式需要长时间运行的请求，后台活动媒体重播、 听众或内部状态等应执行 `onReset()` ，以及方法。 它执行时 `WebView` 定位到新的一页或刷新，重新载入 JavaScript。

## 外挂程式类映射

外挂程式的 JavaScript 介面使用 `cordova.exec` 方法，如下所示：

        exec （< successFunction > < failFunction >、 < 服务 >、 < 行动 > [< args >]) ；
    

这封送请求从 web 视图到 Android 的本机对岸，有效地调用 `action` 方法 `service` 具有额外的参数中传递的类 `args` 阵列。

是否您分发外挂程式作为 JAVA 档或作为它自己的一个*jar*档，必须在科尔多瓦 Android 应用程式中指定外挂程式 `res/xml/config.xml` 档。 有关如何使用的详细资讯，请参阅应用程式外挂程式 `plugin.xml` 档，把这个注射 `feature` 元素：

        <feature name="<service_name>">
            <param name="android-package" value="<full_name_including_namespace>" />
        </feature>
    

服务名称匹配在 JavaScript 中使用 `exec` 调用。 值是 JAVA 类的完全限定命名空间识别码。 否则为该外挂程式可能会编译，但仍不能使用到科尔多瓦。

## 外挂程式初始化和存留期

外挂程式物件的一个实例创建为生活的每个 `WebView` 。 外挂程式不会具现化之前他们第一次引用通过调用从 JavaScript，除非 `<param>` 与 `onload` `name` 属性设置为 `"true"` 的 `config.xml` 。 例如：

    <feature name="Echo">
        <param name="android-package" value="<full_name_including_namespace>" />
        <param name="onload" value="true" />
    </feature>
    

外挂程式应使用 `initialize` 方法为他们的创业逻辑。

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here
    }
    

## 编写一个 Android JAVA 外挂程式

JavaScript 调用触发外挂程式请求到本机的一边，和相应的 JAVA 外挂程式映射正确地在 `config.xml` 档中，但最后的 Android JAVA 外挂程式类看起来不会像什么？ 无论派往与 JavaScript 的外挂程式 `exec` 函数传递到外挂程式类的 `execute` 方法。 大多数 `execute` 实现看起来像这样：

        @Override 公共 boolean 类型的值执行 CallbackCoNtext callbackCoNtext JSONArray args 字串操作） 将引发 JSONException {如果 ("beep".equals(action)) {this.beep(args.getLong(0));callbackCoNtext.success() ；则返回 true ；} 返回 false ；/ / 返回 false 结果的"MethodNotFound"错误。
        }
    

JavaScript `exec` 函数的 `action` 参数对应于一个类的私有类方法派遣了可选参数。

当捕获异常，并返回错误，重要的是为了明确起见，错误返回给 JavaScript 匹配 JAVA 异常名称尽可能多。

## 执行绪

外挂程式的 JavaScript 并*不*在主执行绪中运行 `WebView` 介面 ； 相反，它会运行 `WebCore` 执行绪，一样 `execute` 方法。 如果您需要与使用者介面进行交互，则应使用以下变化：

        @Override
        public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
            if ("beep".equals(action)) {
                final long duration = args.getLong(0);
                cordova.getActivity().runOnUiThread(new Runnable() {
                    public void run() {
                        ...
                        callbackContext.success(); // Thread-safe.
                    }
                });
                return true;
            }
            return false;
        }
    

使用以下如果你不需要在主介面上运行的执行绪，但不是想阻止 `WebCore` 执行绪或者：

        @Override
        public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
            if ("beep".equals(action)) {
                final long duration = args.getLong(0);
                cordova.getThreadPool().execute(new Runnable() {
                    public void run() {
                        ...
                        callbackContext.success(); // Thread-safe.
                    }
                });
                return true;
            }
            return false;
        }
    

## 回声 Android 外挂程式示例

若要匹配的 JavaScript 介面*回波*特征描述的应用程式外挂程式，使用 `plugin.xml` 来注入 `feature` 到本地平台规范 `config.xml` 档：

        <platform name="android">
            <config-file target="config.xml" parent="/*">
                <feature name="Echo">
                    <param name="android-package" value="org.apache.cordova.plugin.Echo"/>
                </feature>
            </config-file>
        </platform>
    

然后添加以下到 `src/org/apache/cordova/plugin/Echo.java` 档：

        package org.apache.cordova.plugin;
    
        import org.apache.cordova.CordovaPlugin;
        import org.apache.cordova.CallbackContext;
    
        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;
    
        /**
         * This class echoes a string called from JavaScript.
         */
        public class Echo extends CordovaPlugin {
    
            @Override
            public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
                if (action.equals("echo")) {
                    String message = args.getString(0);
                    this.echo(message, callbackContext);
                    return true;
                }
                return false;
            }
    
            private void echo(String message, CallbackContext callbackContext) {
                if (message != null && message.length() > 0) {
                    callbackContext.success(message);
                } else {
                    callbackContext.error("Expected one non-empty string argument.");
                }
            }
        }
    

必要的进口商品在档的顶部延伸中的类 `CordovaPlugin` ，其 `execute()` 方法，它将覆盖从其接收邮件 `exec()` 。 `execute()`方法第一次测试的值 `action` ，在这种情况下有有效期的只有一个 `echo` 的值。 任何其他行动返回 `false` ，并导致 `INVALID_ACTION` 错误，会转换为调用的 JavaScript 一边错误回档。

下一步，该方法检索 echo 字串使用 `args` 物件的 `getString` 方法，指定的第一个参数传递给该方法。 值传递给一个私人后 `echo` 的方法，它是参数检查，以确保它不是 `null` 或空字串，这种情况下的 `callbackContext.error()` 调用 JavaScript 的错误回档。 如果通过各种检查， `callbackContext.success()` 将传递原始 `message` 回 JavaScript 的成功回档作为参数的字串。

## Android 系统集成

Android 功能 `Intent` 允许进程互相沟通的系统。 外挂程式可以访问 `CordovaInterface` 物件，可以访问 Android `Activity` ，运行应用程式。 这是 `Context` 启动新的 android 系统所需 `Intent` 。 `CordovaInterface`允许外挂程式启动 `Activity` 一个结果，并设置回档外挂程式时 `Intent` 返回到应用程式。

到科尔多瓦 2.0 外挂程式可以不再直接存取 `Context` ，和遗产 `ctx` 成员已被否决。 所有 `ctx` 的方法上存在 `Context` ，所以这两个 `getContext()` 和 `getActivity()` 可以返回所需的物件。

## 调试 Android 外挂程式

Eclipse 允许您调试外挂程式作为 JAVA 原始程式码包含在专案中。 只有最新版本的 Android 开发者工具允许您将原始程式码附加到*JAR*的依赖关系，所以此功能尚不完全支援。