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

title: Windows Phone 8 外挂程式
toc_title: WP8
---

# Windows Phone 8 外挂程式

此部分提供了如何在 Windows Phone 平台上实现本机外挂程式代码的详细资讯。 之前读这篇文章，请参阅外挂程式开发指南外挂程式的结构和其共同的 JavaScript 介面的概述。 这一节继续表明通信从Cordova web 视图的本机平台和后面的示例*回声*外挂程式。

在 Windows Phone 上的Cordova编写外挂程式需要Cordova的体系结构的一个基本的了解。 Cordova WP8 组成的 `WebBrowser` ，承载应用程式的 JavaScript 代码和管理本机 API 呼叫。 您可以扩展 C# `BaseCommand` 类 （ `WPCordovaClassLib.Cordova.Commands.BaseCommand` ），其中附带了大部分的你需要的功能：

1.  选择您的专案，并按一下滑鼠右键，选择**添加 → 新专案......**如果您愿意，您可以添加它到 `Plugins` 资料夹。

2.  选择**类**和命名为 `Echo.cs` 。 这类名称必须*完全*匹配你叫什么指定的服务作为 `cordova.exec()` 的 JavaScript 一边打电话。

3.  包括基类，这些类执行：
    
        使用 WPCordovaClassLib.Cordova ；使用 WPCordovaClassLib.Cordova.Commands ；使用 WPCordovaClassLib.Cordova.JSON ；
        

4.  扩展您的类从 `BaseCommand` ：
    
        公共类回声: BaseCommand {/ /......}
        

5.  添加 `echo` 可从 JavaScript 调用的方法：
    
        公共类回声: BaseCommand {公共 void 回声 （字串选项） {/ / JS 可调用外挂程式的所有方法必须都有此签名 ！
                / / 公共返回 void，1 参数是一个字串}}
        

请参阅可用的外挂程式来重写方法的[BaseCommand.cs][1]类。 例如，该外挂程式可以捕获 '暂停' 和 '恢复' 事件。

 [1]: https://github.com/apache/cordova-wp8/blob/master/wp8/template/cordovalib/Commands/BaseCommand.cs

## 命名空间

不合格的命令的预设命名空间为：

        namespace Cordova.Extension.Commands
        {
            // ...
        }
    

如果你想要指定您自己的命名空间，则需要完全限定打电话到 `cordova.exec` 。例如，如果您想要定义您的类 C# 像这样：

        namespace com.mydomain.cordovaExtensions
        {
            public class Echo : BaseCommand
            {
                // ...
            }
        }
    

JavaScript 会需要调用 `exec` 像这样：

        cordova.exec (赢、 失败，"com.mydomain.cordovaExtensions.Echo"，......);
    

## 解释在 C 中的参数

中讨论的示例中应用程式外挂程式，你的外挂程式接收的资料是一个字串，但如果你想要传递的字串阵列吗？ 假设 JavaScript `cordova.exec` 调用指定像这样：

        cordova.exec （赢了，失败了，"回声"、"回声"、 ["输入的字串"]） ；
    

值 `options` 的字串传递给 `Echo.echo` 方法是 JSON：

        "[\"input string\"]"
    

所有 JavaScript `exec` 参数被传递到 C# 中之前, 是 JSON 编码和所以需要解码：

        string optVal = JsonHelper.Deserialize<string[]>(options)[0];
        // optVal now has the value of "input string"
    

## 通过结果从 C# 对 JavaScript

`BaseCommand`类提供的方法将资料传递到 JavaScript 回档处理常式。如果你只是想要信号没有附带结果的成功，你可以简单地调用：

        DispatchCommandResult();
        // calls back with an empty plugin result, considered a success callback
    

若要传递回来的资料，你需要调用 `DispatchCommandResult` 以不同的方式：

        DispatchCommandResult (新 PluginResult （PluginResult.Status.OK，"一切都按计划，这是一个传递给成功处理的结果"）） ；
    

使用一个已编码的 JSON 字串的结构化的物件资料传递回 JavaScript：

        DispatchCommandResult(new PluginResult(PluginResult.Status.OK, "{result:\"super awesome!\"}"));
    

要发出错误的信号，请致电 `DispatchCommandResult` 与 `PluginResult` 物件，其状态是 `ERROR` ：

        DispatchCommandResult (新 PluginResult （PluginResult.Status.ERROR，"回波信号错误"）） ；
    

## 处理序列化错误

您的论点，在解释时 `try` / `catch` 块可说明遮罩掉坏的输入。这种模式将出现在整个Cordova C# 代码：

        string optVal = null;
    
        try
        {
            optVal = JsonHelper.Deserialize<string[]>(options)[0];
        }
        catch(Exception)
        {
            // simply catch the exception, we handle null values and exceptions together
        }
    
        if (optVal == null)
        {
            DispatchCommandResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        }
        else
        {
            // ... continue on to do our work
        }
    

## 外挂程式使用寿命

外挂程式需要长时间运行的请求，如媒体重播、 听众，保持内部状态应执行的背景活动 `onReset` 方法来清理这些活动。 当 CordovaView webbrowser 控制项导航到新的一页或刷新，重新载入 JavaScript 运行方法。

        // defined in WPCordovaClassLib.Cordova.Commands.BaseCommand
        public virtual void OnReset() { }
    

## 外挂程式 XML

下面演示如何使用 `plugin.xml` 档来指定外挂程式的原始程式码档在 Windows Phone 平台上。 请参阅应用程式外挂程式概述和外挂程式规范有关可用选项的详细资讯。

*   `<source-file>`元素定义了所有外挂程式资源如*.cs*， *.xaml*， *.xaml.cs*，图像资产和*.dll*档的。

*   `<config-file>`元素定义元素注入到一个设定档。此示例将外挂程式添加到该平台的 `config.xml` 档：
    
        <config-file target="config.xml" parent="/*">
            <feature name="PluginName">
                <param name="wp-package" value="PluginName"/>
            </feature>
        </config-file>
        
    
    本示例将添加到连络人功能 `WMAppManifest.xml` 档：
    
        <config-file target="Properties/WMAppManifest.xml" parent="/Deployment/App/Capabilities">
            <Capability Name="ID_CAP_CONTACTS" />
        </config-file>
        

## 调试外挂程式

使用 Visual Studio 调试器来调试外挂程式的 C# 元件。您可以在您的类所公开的方法中的任何设置一个中断点。

JavaScript 更难在 Windows Phone 上进行调试。您需要使用 `console.log` 来输出外挂程式的状态，或告知自己的错误。

## 常见的陷阱

*   要小心不要将从 JavaScript 的参数传递给本机方面难以作为 JSON 反序列化的。 大多数设备平台期望的参数传递给 `cordova.exec()` 必须是一个阵列，如下所示：
    
        cordova.exec (胜利、 失败，"ServiceName"、"方法名称"["这是一个字串"、 54，{文字： '麻烦'}]) ；
        
    
    这可能会导致对 C# 进行解码一个过于复杂的字串值：
    
        "[\"this is a string\", 54, { literal:'trouble' }]"
        
    
    相反，考虑将*所有*参数都转换为字串之前调用 `exec()` ，和每个单独解码：
    
        cordova.exec(win, fail, "ServiceName", "MethodName", ["this is a string", "54", "{literal:'trouble'}"]);
        string[] optValues = JsonHelper.Deserialize<string[]>(options);
        

*   通常，最好要在调用之前检查参数，在 JavaScript 中的 `exec()` 。 这样做允许您重新使用更多的代码和各种本机实现拉从外挂程式的不必要的功能。