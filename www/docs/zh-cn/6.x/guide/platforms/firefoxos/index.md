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

title: 火狐浏览器作业系统平台指南
---

# 火狐浏览器作业系统平台指南

本指南介绍了如何设置您的开发环境创建Cordova应用程式为火狐 OS 的设备，然后测试和发布这些应用程式。

## 要求和支援

火狐浏览器作业系统的应用程式，基本上只是为 web 应用程式，加上一个 manifest.webapp 档，定义了有关应用程式的中继资料，并允许它在火狐浏览器作业系统的设备上安装。 可以使用任何Cordova支援的平台。要找出有关构建 web 应用程式的详细资讯，请咨询上[国语][1]的[App 中心][2].

 [1]: https://developer.mozilla.org/en-US/
 [2]: https://developer.mozilla.org/en-US/Apps

## 安装和环境设置

第一次安装[Node.js][3]，然后安装Cordova包就像这样：

 [3]: http://nodejs.org/

    $ npm install -g cordova
    

接下来，创建一个示例Cordova应用程式，然后导航到新创建的目录：

    $ cordova create test-app
    $ cd test-app
    

火狐浏览器作业系统作为受支援的平台添加到在以下应用程式：

    $ cordova platform add firefoxos
    

这将创建一个火狐浏览器操作系统应用程式平台/firefoxos/www 目录，目前看起来都一样除了，它已在 www 目录的火狐浏览器的清单档 (manifest.webapp) 中。

## 开发您的应用程式

此时你准备好去 — — 测试-app/www 里面的代码更改为任何你想要您的应用程式会。 你可以向应用程式，例如使用"Cordova外挂程式添加"，添加[支援的外挂程式]()：

    cordova plugin add cordova-plugin-device
    cordova plugin add cordova-plugin-vibration
    

当编写应用程式代码时，将您的更改部署到您已经添加到您的专案与火狐浏览器操作系统应用程式

    $ cordova prepare firefoxos
    

若要创建一个打包的应用程式之一可以邮编平台/firefoxos/www 目录。简单地也可以生成使用

    $ cordova build firefoxos
    

火狐浏览器作业系统封装的应用程式将在 platforms/firefoxos/build/package.zip 建成

## 测试和调试

可以使用火狐浏览器作业系统 [Web IDE][4] 测试应用程式.

 [4]: https://developer.mozilla.org/en-US/docs/Tools/WebIDE

当您已连接到您的测试设备/模拟器 Web IDE 时，请选择"打开打包应用程式"选项，然后确保您指向测试-app/platforms/firefoxos/www/目录要在 Manager 介面中包含该应用程式。

在这里你可以在你测试设备/模拟器 （与"播放"按钮） 上安装应用程式。使用"暂停"按钮，然后可以调试应用程式并编辑它的代码生活。

注意： 要发布您的应用程式在尝试之前你应该考虑验证它可以使用 [应用程式验证程式][5].

 [5]: https://marketplace.firefox.com/developers/validator

## 发布您的应用程式对火狐浏览器市场

您可以提交您的应用程式到火狐浏览器市场的需求，或发布它自己。 [火狐浏览器市场区][6] 拜访 MDN 来了解更多有关如何做到这一点 ；[应用程式发布选项][7] 是最佳的地方开始。

 [6]: https://developer.mozilla.org/en-US/Marketplace
 [7]: https://developer.mozilla.org/en-US/Marketplace/Publishing/Publish_options