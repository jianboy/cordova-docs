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

title: 外挂程式开发指南
toc_title: Create a plugin
---

# 外挂程式开发指南

*外挂程式*是代码的一个套装软体，注入，允许在其中应用程式呈现与在其上运行的本机平台进行通信的Cordova web 视图。 外挂程式提供对基于 web 的应用程式通常不可用的设备和平台功能的访问。 Cordova API 的所有主要功能作为外挂程式，实现和许多其他的可用条码扫描器、 NFC 通信等功能的启用或定制日历的介面。 有可用外挂程式[注册表][1]。

 [1]: http://plugins.cordova.io

外挂程式包括一个单一的 JavaScript 介面和相应的本机代码库，每个受支援的平台。 本质上这隐藏在一个共同的 JavaScript 介面背后各种本机代码实现。

这一节步骤通过一个简单的*echo*外挂程式，将一个字串从 JavaScript 传递到本机平台又回来，一个人，你可以使用作为一种模式，建立更为复杂的功能。 本节讨论的基本外挂程式结构和面向外部的 JavaScript 介面。 对于每个相应的本机介面，看到这一节的结尾处的清单。

除了这些指令，当准备写一个外挂程式，最好去看一下[现有的外挂程式][2]为指导。

 [2]: http://cordova.apache.org/#contribute

## 建设一个外挂程式

应用程式开发人员使用 CLI 的 `plugin add` 命令 （讨论中的命令列介面），适用于一个专案的一个外挂程式。 该命令的参数是一个包含外挂程式代码的*git*存储库的 URL。 此示例实现Cordova的设备 API：

        $ cordova plugin add https://git-wip-us.apache.org/repos/asf/cordova-plugin-device.git
    

外挂程式存储库必须功能顶级 `plugin.xml` 清单档。 有很多方法来配置这个档的可用外挂程式规范中的详细资讯。 此缩写的版本的 `Device` 外挂程式提供了一个简单的例子，使用作为一种模式：

        <?xml version="1.0" encoding="UTF-8"?>
        <plugin xmlns="http://apache.org/cordova/ns/plugins/1.0"
                id="cordova-plugin-device" version="0.2.3">
            <name>Device</name>
            <description>Cordova Device Plugin</description>
            <license>Apache 2.0</license>
            <keywords>cordova,device</keywords>
            <js-module src="www/device.js" name="device">
                <clobbers target="device" />
            </js-module>
            <platform name="ios">
                <config-file target="config.xml" parent="/*">
                    <feature name="Device">
                        <param name="ios-package" value="CDVDevice"/>
                    </feature>
                </config-file>
                <header-file src="src/ios/CDVDevice.h" />
                <source-file src="src/ios/CDVDevice.m" />
            </platform>
        </plugin>
    

顶级 `plugin` 标记的 `id` 属性使用相同的反向域格式添加到他们的应用程式所识别的外挂程式包。 `js-module`标记指定的常见的 JavaScript 介面的路径。 `platform`标记为指定一组相应的本机代码， `ios` 在这种情况下的平台。 `config-file`标记封装 `feature` 标记，注入特定于平台的 `config.xml` 档，让这个平台认识到额外的代码库。 `header-file`和 `source-file` 标签指定库的元件档的路径。

## 验证外挂程式

您可以使用 `plugman` 实用程式来检查是否该外挂程式正确安装每个平台。 安装 `plugman` 与[节点][3]下面的命令：

 [3]: http://nodejs.org/

        $ npm install -g plugman
    

你需要有效的应用程式的原始目录中，如顶级 `www` 目录包含在预设 CLI 生成专案中所述的命令列介面。 请确保应用程式的 `index.html` 的主页引用名称的外挂程式的 JavaScript 介面，好像它是相同的原始目录中：

        <script src="myplugin.js"></script>
    

然后运行以下命令来测试是否能正常载入的 iOS 的依赖关系：

         $ plugman install --platform ios --project /path/to/my/project/www --plugin /path/to/my/plugin
    

有关的详细资讯 `plugman` 选项，请参阅使用 Plugman 管理外挂程式。 有关如何实际*调试*外挂程式的资讯，请参阅此页面的底部列出的每个平台的本机介面。

## JavaScript 介面

JavaScript 提供了面向前面的介面，使外挂程式的也许最重要的部分。 您可以结构你的外挂程式的 JavaScript，然而你喜欢，但是你需要调用 `cordova.exec` 来交流的本机平台，使用下面的语法：

        cordova.exec(function(winParam) {},
                     function(error) {},
                     "service",
                     "action",
                     ["firstArgument", "secondArgument", 42, false]);
    

这里是每个参数的工作原理：

*   `function(winParam) {}`： 成功回呼函数。假设您 `exec` 调用成功完成，以及任何您传递给它的参数执行此函数。

*   `function(error) {}`： 错误回呼函数。如果该操作未成功完成，此函数执行带有可选错误参数。

*   `"service"`： 要调用的本机一边的服务名称。这对应于本机类，为其更多的资料，可在下面列出的本机指南。

*   `"action"`： 要调用的本机一边的操作名称。这通常对应于本机类的方法。请参阅下面列出的本机指南。

*   `[/* arguments */]`： 要传递到本机环境中的参数阵列。

## 示例 JavaScript

此示例演示实现外挂程式的 JavaScript 介面的一种方法：

        window.echo = function(str, callback) {
            cordova.exec(callback, function(err) {
                callback('Nothing to echo.');
            }, "Echo", "echo", [str]);
        };
    

在此示例中，该外挂程式的重视本身对 `window` 物件作为 `echo` 功能，外挂程式使用者会调用，如下所示：

        window.echo("echome", function(echoValue) {
            alert(echoValue == "echome"); // should alert true.
        });
    

看看的最后三个参数的 `cordova.exec` 函数。 第一次调用 `Echo` *的服务*，一个类名称。 第二个请求 `echo` *行动*，该类中的方法。 第三个是一个阵列，包含 echo 字串，该字串参数的 `window.echo` 函数的第一个参数。

成功回档传递到 `exec` 是简单的回呼函数的引用 `window.echo` 花。 如果本机平台触发错误回档，它只是调用的成功回呼函数，并传递一个预设字串。

## 本地介面

一旦你为你的外挂程式定义 JavaScript，你需要补充与至少一个本机实现。 下面，列出每个平台的详细资讯和每个生成回声外挂程式上面的简单示例：

*   [亚马逊火 OS 外挂程式](../../platforms/amazonfireos/plugin.html)
*   [Android 外挂程式](../../platforms/android/plugin.html)
*   [iOS 外挂程式](../../platforms/ios/plugin.html)
*   [黑莓 10 外挂程式](../../platforms/blackberry10/plugin.html)
*   [Windows Phone 8 外挂程式](../../platforms/wp8/plugin.html)
*   [Windows 外挂程式](../../platforms/win8/plugin.html)

Tizen 平台不支援外挂程式。

## 发布外挂程式

一旦你开发你的外挂程式，你可能想要发布并与社区分享它。 你可以将你的外挂程式发布到任何`npmjs`-基于注册表，但推荐的一种[NPM 注册表][4]。 请阅读我们的[新公共管理指南 》 的发布外挂程式][5].

 [4]: https://www.npmjs.com
 [5]: http://plugins.cordova.io/npm/developers.html

**注**:[Cordova外挂程式注册表][6]移动到唯读状态。 `publish`/`unpublish`命令删除从`plugman`，所以你需要使用相应的`新公共管理`命令。

 [6]: https://plugins.cordova.io

其他开发人员可以安装你的外挂程式使用`plugman`或Cordova CLI 自动。 (每个发展路径的详细资讯，请参阅使用 Plugman 管理外挂程式和命令列介面。)

要将一个外挂程式发布到故宫注册表你需要按照以下的步骤:

*   创建你的外挂程式的`package.json`档:
    
        $ plugman createpackagejson /path/to/your/plugin
        

*   发布:
    
        $ npm adduser # that is if you don't have an account yet
        $ npm publish /path/to/your/plugin
        

就是这个!

运行`plugman --help`列出其他可用的基于注册表的命令。