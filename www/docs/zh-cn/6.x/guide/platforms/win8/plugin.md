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

title: Windows 外挂程式
toc_title: Windows
---

# Windows 外挂程式

此部分提供了如何在 Windows 应用商店应用程式中实现一个使用的外挂程式的详细资讯。之前读这篇文章，请参阅应用程式外挂程式外挂程式的结构和其共同的 JavaScript 介面的概述。 这一节继续显示示例*回声*外挂程式从Cordova web 视图的本机平台和背部进行通信。

很重要的是要注意 Windows 支援直接在 JAVAscript 中，这意味著发展中国家的 '本土' 的部分，只需要在特殊情况下发展。

## 在 JavaScript 中创建一个 Windows 外挂程式

这些指令是要创建一个纯 JavaScript 外挂程式。理解这一点对于理解如何添加本机/托管位至关重要。

Windows Cordova外挂程式是本质上是一个薄包装周围现有 WinJS 提供的功能，但假设你会想要定义为多个设备你 JS 通用介面，你通常会提供 API 的 1 JS 档。

    // inside file echoplugin.js
    var EchoPlugin = {
        // the echo function calls successCallback with the provided text in strInput
        // if strInput is empty, it will call the errorCallback
        echo:function(successCallback, errorCallback, strInput) {
            cordova.exec(successCallback,errorCallback,"EchoPlugin","echo",[strInput]);
        }
    }
    

## 在 Windows 上的里面Cordova exec。

Cordova.exec 函数以不同的方式定义的每个平台上，这是因为每个平台都有它自己的应用 js 代码和本机包装代码之间进行通信的方式。 但在 Windows 中，有没有本地的包装，所以 exec 调用有一致性。 就像你可以直接在 EchoPlugin.echo，你 js 只有外挂程式工作：

    // inside file echoplugin.js ( this is what NOT to do if you want to reuse the JS API cross platform )
    var EchoPlugin = {
        echo:function(successCallback,errorCallback,strInput) {
            if(!strInput || !strInput.length) {
                errorCallback("Error, something was wrong with the input string. =>" + strInput);
            }
            else {
                successCallback(strInput + "echo");
            }
        }
    }
    

这将可能会做工精细，但是它意味著您将需要为不同的平台，不同版本的 echoPlugin.js，可能你可以在你的实现中有不一致的问题。 作为最佳实践，我们决定模仿 cordova.exec 上窗户，里面的本机 API，所以我们可以运行相同的 JS 代码，并不需要重写一遍为平台，和也利用检查，任何参数或其他常见的代码，由开发人员在其他平台上工作的人员提供。

## Cordova exec 代理

在 Windows 上，Cordova提供一个代理，您可以使用来注册一个物件，它将处理所有的 cordova.exec 调用的 API。

例如如果你想要为加速度感应器 API 提供实现，你会这样做：

cordova.commandProxy.add ("加速度"{开始： function() {/ / 你代码在这里......}/ /......，其余的在这里的 API}） ；

所以在我们的例子中，我们将假设中 echoplugin.js 的代码处理跨平台相关，JavaScript，和我们可以只编写 Windows 的代理

    // in file echopluginProxy.js
    cordova.commandProxy.add("EchoPlugin",{
        echo:function(successCallback,errorCallback,strInput) {
            if(!strInput || !strInput.length) {
                errorCallback("Error, something was wrong with the input string. =>" + strInput);
            }
            else {
                successCallback(strInput + "echo");
            }
        }
    });
    

外挂程式定义

如果我们希望我们的外挂程式的使用者能够轻松地安装我们的外挂程式，我们需要定义根据 PlugMan 是如何定义的外挂程式。 更多关于这在[外挂程式规范][1]

 [1]: plugin_ref_spec.md.html#Plugin%20Specification

    <?xml version="1.0" encoding="UTF-8"?>
    <plugin xmlns="http://apache.org/cordova/ns/plugins/1.0"
        id="com.risingj.echoplugin"
        version="0.1.0">
    
        <js-module src="www/echoplugin.js" name="echoplugin">
            <clobbers target="window.echoplugin" />
        </js-module>
    
        <!-- windows -->
        <platform name="windows">
            <js-module src="src/windows/echopluginProxy.js" name="EchoProxy">
                <merges target="" />
            </js-module>
        </platform>
    
        <!-- other platforms -->
    
    </plugin>
    

这给了我们 Windows JavaScript 外挂程式，使用一个通用的档 （echoplugin.js） 和使用代理伺服器提供实施 （echopluginProxy.js） 的 Windows 只有部分工作。 我们怎么做将本机/托管代码添加到这？ 好吧我们要开始相同，唯一的区别将在 echopluginProxy 方法中我们做里面。

# WinJS 如何访问本机/托管代码

在 Windows 中，WinJS 编写的应用程式都能够与本机代码进行交互，这间的 op 是供 Windows 运行时元件。 细节很多，和本指南只会掩盖基本知识。 Microsoft 提供了更多的资讯[在这里][2].

 [2]: http://msdn.microsoft.com/en-us/library/windows/apps/hh441569.aspx

当您创建您的 Windows 运行时元件，任何类被定义为 '公共 ref 类密封' 被认为是 '可启动班'，将可从 JavaScript 调用。

    // in your header file .h
    namespace EchoRuntimeComponent
    {
        public ref class EchoPluginRT sealed 
        {
            public:
            static Platform::String^ Echo(Platform::String^ input);
        }
    }
    
    // in the implementation file .cpp
    using namespace EchoRuntimeComponent;
    using namespace Platform;
    
    Platform::String^ EchoPluginRT::Echo(Platform::String^ input)
    {
        if(input->IsEmpty()) 
        {
            return "Error: input string is empty.";
        }
        else
        {
            return input->ToString() + "echo";
        }
    }
    

现在为了让我们来调用本机代码，我们使用的命名空间、 类名和 lowerCamelCase 我们正在调用的方法。

var res = EchoRuntimeComponent.EchoPluginRT.echo("boom") ；我们将这移动到我们的 echopluginProxy.js 档，得到这个：

    // in file echopluginProxy.js
    cordova.commandProxy.add("EchoPlugin",{
        echo:function(successCallback,errorCallback,strInput) {
            var res = EchoRuntimeComponent.EchoPluginRT.echo(strInput);
            if(res.indexOf("Error") == 0) {
                errorCallback(res);
            }
            else {
                successCallback(res);
            }
        }
    });
    

就是这样，我们在 Apache Cordova Windows 中有使用端到端 c + + 支援 js 调用外挂程式 ！

# 技术的一些注意事项：

*   回档通常是非同步所以马上调用回档可能预计不会由调用方。 在实践中，如果电话不是非同步，你应该至少使用 javascript 超时强制被称为非同步回档。
*   可启动的类可以做各种各样的太棒了，像在调度，非同步回档，通过您自己的物件类型、 阵列、 集合、 重载的方法和更多的事件。 我建议你做你的家庭作业。
*   如果你坚持共同的 Windows Phone 8.0 和 Windows SDK API 呼叫，你将能够在 Windows Phone 8.0 Apache Cordova外挂程式中使用相同的运行时元件 （本机或托管的位）。 ~ 敬请期待这一职务。

# 定义你的外挂程式

现在，我们有一个工作的外挂程式，我们需要重新审视从早些时候的外挂程式定义，所以我们可以将其发布。 我们现在可以作为一种框架添加运行时元件。 注意 WindowsRuntimeComponent 的输出类型可以是.winmd 或.dll

    <?xml version="1.0" encoding="UTF-8"?>
    <plugin xmlns="http://apache.org/cordova/ns/plugins/1.0"
        id="com.risingj.echoplugin"
        version="0.2.0">
    
        <js-module src="www/echoplugin.js" name="echoplugin">
            <clobbers target="window.echoplugin" />
        </js-module>
    
        <!-- windows -->
        <platform name="windows">
            <js-module src="src/windows/echopluginProxy.js" name="EchoProxy">
                <merges target="" />
            </js-module>
            <framework src="src/windows/EchoRuntimeComponent.winmd" custom="true"/>
        </platform>
    
        <!-- other platforms -->
    
    </plugin>
    

就是这样，你现在有一个可分发的外挂程式，你可以与世界分享 ！ 要注意，将框架添加到 Windows Cordova专案支援最近才加入，所以您将需要确保模具当前你Cordova的一件事。 Cordova cli 和Cordova plugman 支援添加删除本机支援的外挂程式。

> cordova plugin add com.risingj.echoplugin

或

> plugman install --platform windows --plugin com.risingj.echoplugin --project .

https://github.com/purplecabbage/cordova-runtimecomp-echoplug