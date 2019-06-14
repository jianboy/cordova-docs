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

title: 黑莓手机的外挂程式
---

# 黑莓手机的外挂程式

本指南介绍了如何开发回声外挂程式在黑莓手机上。 外挂程式开发指南提供广泛概述，你应该已经是熟悉的和本指南捡起它的留下。 此外，下载[Cordova黑莓手机存储库][1].

 [1]: https://git-wip-us.apache.org/repos/asf?p=cordova-blackberry-webworks.git;a=summary

`Cordova-BlackBerry`专案允许您将部署到黑莓火炬、 加粗和操作手册等。 Playbook 使用不同的代码基比其他黑莓手持设备，您需要为其重复你的发展努力。 本指南著重于手持设备，而不是平板电脑。 （在将来，本指南应包括这两个平台）。

Echo 外挂程式基本上是返回使用者不管消息提供给 `window.echo` 函数：

    window.echo = function(str, callback) {
        cordova.exec(callback, function(err) {
            callback('Nothing to echo.');
        }, "Echo", "echo", [str]);
    };
    

## 修改 plugins.xml

您的专案的 `www/plugins.xml` 目录中包含的所有必要引用到Cordova专案的外挂程式。 添加一个额外的引用，这样，当 `cordova.exec` 是Cordova叫，知道如何映射 `Echo` 参数的 `cordova.exec` 到 `Echo` 我们想要写本机的类：

    <feature name="Echo">
        <param name="blackberry-package" value="org.apache.cordova.echo.Echo" />
    </feature>
    

## 添加 Echo.java

如果您注意到结构的值属性，您将看到已定义的路径，导致回声外挂程式。 在Cordova黑莓 WebWorks 回购的根目录中，查找名为的目录 `framework` 。 此目录包含所有的原始程式码在黑莓手机上本机运行。 导航到 `framework/ext/src/org/apache/cordova` 。 此时，您将看到所有的外挂程式目录，所是的原始程式码。 因此，添加目录回显到 `framework/ext/src/org/apache/cordova/echo` ，并创建一个档称为 `Echo.java` 在`framework/ext/src/org/apache/cordova/echo/Echo.java`.

## 书写 Echo.java

在编写外挂程式背后的基本思想是，创建一个扩展外挂程式类的类调用的方法 `execute` 返回 `PluginResult` 类。 任何调用 `cordova.exec` 将传递给要在类中，以及参数内执行的操作中。 在这种情况下，"回声"是我们想要执行的类中"回声"和 [乙方] 的行动是我们在中传递的参数。

    package org.apache.cordova.echo;
    
    import org.apache.cordova.api.Plugin;
    import org.apache.cordova.api.PluginResult;
    import org.apache.cordova.json4j.JSONArray;
    import org.apache.cordova.json4j.JSONException;
    import org.apache.cordova.json4j.JSONObject;
    /**
     * A simple plugin to demonstrate how to build a plugin for BlackBerry
     * Basically echos back the msg that a user calls to this plugin
     */
    public final class Echo extends Plugin {
    
        public static final String echo = "echo";
    
        public PluginResult execute(String action, JSONArray args, String callbackId) {
            PluginResult result = new PluginResult(PluginResult.Status.INVALID_ACTION, "Echo: Invalid action:" + action);
            if(action.equals(echo)){
                try {
                    String theMsg = args.getString(0);
                    if(theMsg!= null || theMsg.length()>0){
                        result = new PluginResult(PluginResult.Status.OK, theMsg);
                    }else{
                        result = new PluginResult(PluginResult.Status.ERROR, "Nothing to echo.");
                    }
                } catch (JSONException e) {
                    result = new PluginResult(PluginResult.Status.JSON_EXCEPTION, e.getMessage());
                }
            }
    
            return result;
        }
    
    }
    

所以如果我们看看上面的代码，我们可以看到在 execute 方法中，我们第一次寻找行动来。 Echo 外挂程式，只有一种操作， `echo` ，因此，我们将只检查的。 如果我们的外挂程式有更多的行动，它是简单的添加更多条件的测试，以检查这些操作。

然后我们拿进来从参数 args 参数由提供的消息。 我们可以抓住的只在做第一个参数`String theMsg = args.getString(0);`.

我们将做一些错误检查和邮件看起来很好，如果我们将具现化新的 PluginResult 与好的状态： `PluginResult.Status.OK` ，并返回该邮件： `theMsg` 。 在此之后，我们返回的结果，要传递回给 JavaScript 可以在回档中成功发射。 如果事情失败，我们可以返回各种状态异常，像 `PluginResult.Status.ERROR` ， `PluginResult.Status.JSON_EXCEPTION` ，或 `PluginResult.Status.INVALID_ACTION` 。 当传递回来时，这些类型的结果火中 JavaScript 的失败回档。

## 更新您的专案 www 目录中.jar

添加的 `Echo.java` 需要更新您的专案中。 若要生成 `.jar` 档，定位到黑莓 WebWorks 回购根目录下并运行 `ant` 命令：

    ant update -Dproject.path="~/path_to_my_project"
    

这将生成新的 `.jar` 档在 `build/ext` 目录。复制 `build/ext/cordova.jar` 档到您 `project/www/ext` 目录。

如果一切顺利，允许您在黑莓手机中使用 Echo 外挂程式。