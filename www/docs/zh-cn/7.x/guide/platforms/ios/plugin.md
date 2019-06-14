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

title: iOS 外挂程式
toc_title: iOS
---

# iOS 外挂程式

此部分提供了如何在 iOS 平台上实现本机外挂程式代码的详细资讯。 之前读这篇文章，请参阅应用程式外挂程式外挂程式的结构和其共同的 JavaScript 介面的概述。 这一节继续表明通信从科尔多瓦 web 视图的本机平台和后面的示例*回声*外挂程式。

IOS 外挂程式作为扩展目标 C 类实现 `CDVPlugin` 类。 对于 JavaScript 的 `exec` 方法的 `service` 参数将映射到一个目标 C 类，每个外挂程式必须注册为 `<feature>` 标记命名的应用程式目录中 `config.xml` 档。

## 外挂程式类映射

一个外挂程式的 JavaScript 部分使用 `cordova.exec` 方法，如下所示：

        exec(<successFunction>, <failFunction>, <service>, <action>, [<args>]);
    

这封送一个请求从 `UIWebView` 到 iOS 本机一侧，有效地调用 `action` 方法在 `service` 类，传入的参数中的 `args` 阵列。

指定作为外挂程式 `<feature>` 科尔多瓦 iOS 应用程式专案中的标记 `config.xml` 档，使用 `plugin.xml` 档来自动应用程式外挂程式中所述注入此标记：

        <feature name="LocalStorage">
            <param name="ios-package" value="CDVLocalStorage" />
        </feature>
    

该功能的 `name` 属性应匹配您所指定的作为 JavaScript `exec` 调用的 `service` 参数。 `value`属性应与外挂程式的目标 C 类的名称相匹配。 `<param>`元素的 `name` 应始终是 `ios-package` 。 如果你不遵守这些准则，该外挂程式可能会编译，但科尔多瓦可能仍然不能够访问它。

## 外挂程式初始化和存留期

外挂程式物件的一个实例创建为生活的每个 `UIWebView` 。 首先从 JavaScript 的调用的引用时，通常被具现化外挂程式。 否则他们可以通过设置具现化 `param` 命名为 `onload` 到 `true` 在 `config.xml` 档：

        <feature name="Echo">
            <param name="ios-package" value="Echo" />
            <param name="onload" value="true" />
        </feature>
    

有*没有*指定外挂程式的初始值设定项。相反，应使用外挂程式 `pluginInitialize` 为其启动逻辑方法。

外挂程式需要长时间运行的请求，如媒体重播、 听众，保持内部状态应执行的背景活动 `onReset` 方法来清理这些活动。 在方法运行时 `UIWebView` 定位到新的一页或刷新，重新载入 JavaScript。

## 写作 iOS 科尔多瓦外挂程式

JavaScript 调用触发外挂程式请求到本机的一边，和相应的 iOS 目标 C 外挂程式映射正确地在 `config.xml` 档中，但最后 iOS 目标 C 外挂程式类看起来像什么？ 无论派往与 JavaScript 的外挂程式 `exec` 函数传递到相应的外挂程式类的 `action` 方法。 外挂程式的方法有此签名：

        - (void)myMethod:(CDVInvokedUrlCommand*)command
        {
            CDVPluginResult* pluginResult = nil;
            NSString* myarg = [command.arguments objectAtIndex:0];
    
            if (myarg != nil) {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
            } else {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Arg was null"];
            }
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }
    

有关更多详细资讯，请参见 `[CDVInvokedUrlCommand.h](https://github.com/apache/cordova-ios/blob/master/CordovaLib/Classes/CDVInvokedUrlCommand.h)` ， `[CDVPluginResult.h](https://github.com/apache/cordova-ios/blob/master/CordovaLib/Classes/CDVPluginResult.h)` ，和`[CDVCommandDelegate.h](https://github.com/apache/cordova-ios/blob/master/CordovaLib/Classes/CDVCommandDelegate.h)`.

## iOS CDVPluginResult 讯息类型

您可以使用 `CDVPluginResult` 来返回结果的多种类型回 JavaScript 回呼函数，使用类的方法，它们遵循这种模式：

        + (CDVPluginResult*)resultWithStatus:(CDVCommandStatus)statusOrdinal messageAs...
    

您可以创建 `String` ， `Int` ， `Double` ， `Bool` ， `Array` ， `Dictionary` ， `ArrayBuffer` ，和 `Multipart` 类型。 你可以也离开了任何参数来发送状态，或返回错误，或甚至选择不发送任何外挂程式的结果，在这种情况下既不回拨火。

请注意以下复杂的传回值为：

*   `messageAsArrayBuffer`预计 `NSData*` 并将转换为 `ArrayBuffer` 在 JavaScript 回档。 同样，任何 `ArrayBuffer` JavaScript 发送到一个外挂程式都将转换为`NSData*`.

*   `messageAsMultipart`预计， `NSArray*` 包含任何其他支援类型，并将发送整个阵列作为 `arguments` 给您的 JavaScript 回档。 这种方式，所有参数在序列化或反序列化作为必要的所以它是能够安全返回 `NSData*` 作为多部分，但不是 `Array` /`Dictionary`.

## 回声 iOS 外挂程式示例

若要匹配的 JavaScript 介面*回波*特征描述的应用程式外挂程式，使用 `plugin.xml` 来注入 `feature` 到本地平台规范 `config.xml` 档：

        <platform name="ios">
            <config-file target="config.xml" parent="/*">
                <feature name="Echo">
                    <param name="ios-package" value="Echo" />
                </feature>
            </config-file>
        </platform>
    

然后我们将添加以下 `Echo.h` 和 `Echo.m` 档到 `Plugins` 内科尔多瓦 iOS 应用程式目录的资料夹：

        /********* Echo.h Cordova Plugin Header *******/
    
        #import <Cordova/CDV.h>
    
        @interface Echo : CDVPlugin
    
        - (void)echo:(CDVInvokedUrlCommand*)command;
    
        @end
    
        /********* Echo.m Cordova Plugin Implementation *******/
    
        #import "Echo.h"
        #import <Cordova/CDV.h>
    
        @implementation Echo
    
        - (void)echo:(CDVInvokedUrlCommand*)command
        {
            CDVPluginResult* pluginResult = nil;
            NSString* echo = [command.arguments objectAtIndex:0];
    
            if (echo != nil && [echo length] > 0) {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
            } else {
                pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
            }
    
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }
    
        @end
    

在档的顶部必要的进口商品扩展从类 `CDVPlugin` 。 在这种情况下，该外挂程式只支援单个 `echo` 行动。 它获取 echo 字串通过调用 `objectAtIndex` 方法获取的第一个参数 `arguments` 对应于参数的阵列通过 JavaScript 在 `exec()` 函数。

它会检查该参数，以确保它不是 `nil` 或空字串，返回 `PluginResult` 与 `ERROR` 如果是这样的状态。 如果该参数通过检查，它返回 `PluginResult` 与 `OK` 状态，在原始中传递 `echo` 的字串。 最后，它将发送结果到 `self.commandDelegate` ，其中执行 `exec` 方法的成功或失败回档 JavaScript 一边。 如果成功回档被调用，它将通过在 `echo` 参数。

## iOS 一体化

`CDVPlugin`类功能其他你的外挂程式可以重写的方法。 例如，您可以捕获 `[pause](../../../cordova/events/events.pause.html)` ， `[resume](../../../cordova/events/events.resume.html)` ，应用程式终止和 `handleOpenURL` 事件。 请参见[CDVPlugin.h][1]和[CDVPlugin.m][2]类的指导。

 [1]: https://github.com/apache/cordova-ios/blob/master/CordovaLib/Classes/CDVPlugin.h
 [2]: https://github.com/apache/cordova-ios/blob/master/CordovaLib/Classes/CDVPlugin.m

## 执行绪

外挂程式方法通常在主介面相同的执行绪中执行。 如果你的外挂程式需要大量的处理，或者需要一个阻塞调用，则应使用后台执行绪。 例如：

        - (void)myPluginMethod:(CDVInvokedUrlCommand*)command
        {
            // Check command.arguments here.
            [self.commandDelegate runInBackground:^{
                NSString* payload = nil;
                // Some blocking logic...
                CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:payload];
                // The sendPluginResult method is thread-safe.
                [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
            }];
        }
    

## 调试 iOS 外挂程式

若要调试的目标 C 一边，你需要 Xcode 的内置调试器。 对于 JavaScript，在 iOS 5.0 或更高版本上你可以使用 [Weinre、 Apache 科尔多瓦专案][3] 或 [iWebInspector、 一个协力厂商实用程式][4]。 Ios 8，您可以附加 Safari 8.0 8 模拟器在 iOS 中运行的应用程式。

 [3]: https://github.com/apache/cordova-weinre
 [4]: http://www.iwebinspector.com/

## 常见的陷阱

*   别忘了添加到您的脚本映射 `config.xml` 。如果你忘记了，是在 Xcode 主控台中记录错误。

*   别忘了添加任何主机，您在白名单中，连接到域白名单指南中所述。如果你忘记了，是在 Xcode 主控台中记录错误。