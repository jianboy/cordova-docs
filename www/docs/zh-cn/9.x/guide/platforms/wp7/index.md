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

title: Windows Phone 7 平台指南
---

# Windows Phone 7 平台指南

本指南介绍如何设置您的 SDK 开发环境部署Cordova的 Windows Phone 7 设备的应用程式。 应用程式也使用相同的 Api，但 7 缺乏的一些 IE10 的高级功能上 Windows Phone 8 可用的版本的 Windows Phone 8 设备上运行。 Windows Phone 8 应用程式*不*在 Windows Phone 7 设备上运行。

适用于这两个版本的更多详细的平台特定资讯如下所示：

*   [升级 Windows Phone](../wp8/upgrading.html)
*   Windows Phone 外挂程式
*   [Windows Phone 的命令列工具](../wp8/tools.html)

上面的命令列工具请参阅Cordova 3.0 以前的版本。关于当前介面的资讯，请参阅命令列介面。

## 系统要求

使用 Windows 7 或 Windows 8 (Pro) 或 Windows Vista sp2。需要的 SDK 的 Windows 64 位版本 (x64)。Pro 版被推荐运行的设备模拟程式。

注册和支付为[Windows Phone 开发中心][1]帐户，如果你想要在实际设备上安装应用程式或将其提交给市场的地方。

 [1]: http://dev.windowsphone.com/en-us/publish

**注意**： 在虚拟机器中运行 SDK 可能提出了挑战。阅读[在 Mac 上的 Windows Phone][2]开发解决方案的见解。

 [2]: http://aka.ms/BuildaWP8apponaMac

## 安装 SDK 和Cordova

下载并安装[Windows Phone SDK][3].

 [3]: http://www.microsoft.com/download/en/details.aspx?displaylang=en&id=27570/

下载并解压缩[Cordova][4]的最新副本。 您需要工作 `lib\windows-phone-8\wp7` 子目录中， `lib\windows-phone-8\wp8` 包含Cordova的视窗电话 8 版本。

 [4]: http://phonegap.com/download

复制 `CordovaWP7_x_x_x.zip` 档到 `\My Documents\Visual
Studio 2012\Templates\ProjectTemplates\` 目录。

## 建筑范本

**注意**: 如果跳过这一步 `lib\windows-phone` 的目录已经包含 `CordovaWP7_x_x_x.zip` 档。

为了简化开发过程，Cordova，将捆绑一个脚本来生成 Visual Studio 范本。 这些允许您迅速生成Cordova的应用程式，如果有必要，您可以修改它们。 以下步骤显示如何生成它。

### 运行该批次档来创建和安装范本

根的回购协定包含 `createTemplates.bat` 档。 按两下此档将生成两个 `.zip` 档： `CordovaWP7_x_x_x.zip` 和 `CordovaWP8_x_x_x.zip` ，其中*x.x.x*是的当前版本号。 若要使用这些档很容易在 Visual Studio 中的，复制它们到 `My Documents\Visual Studio
2012\Templates\ProjectTemplates\` 子目录。 然后，可以创建新的**Apache Cordova Windows Phone_ 应用程式从 Visual Studio __File → 新专案**功能表。

如果您从命令列运行该批次档，还可以调用同一个参数，以便自动安装：

        > createTemplates.bat-安装
    

## 设立了一个新的专案

*   打开 Visual Studio 表示为 Windows Phone 和选择**新的专案**.

*   选择**CordovaWP7**。版本编号显示在范本描述。

*   为该专案的名称，并选择**确定**.

## 审查的专案结构

`www`目录功能 `html` ， `js` ，和 `css` 子目录和任何其他资源要求您的应用程式。 任何附加内容需要的 Visual Studio 专案的一部分，必须将它设置为内容。

下面的示例结构表示一个 2.3.0 专案，但可能已安装的版本而异：

![][5]

 [5]: {{ site.baseurl }}/static/img/guide/platforms/wp8/projectStructure.png

## 为该设备生成专案

在测试之前您的设备上的应用程式，必须注册该设备。 有关如何部署和测试 Windows Phone 7 上的详细资讯，请参考[微软的文档][6]。 这些都是基本的步骤：

 [6]: http://msdn.microsoft.com/en-us/library/windowsphone/develop/ff402565(v=vs.105).aspx

*   请确保您的电话连接，并且萤幕处于解锁状态。

*   在 Visual Studio 中，从顶部的下拉式功能表中选择**设备**。

*   按主要的下拉式功能表中，若要启动调试，旁边的绿色**播放**按钮，否则键入**F5**.

![][7]

 [7]: {{ site.baseurl }}/static/img/guide/platforms/wp7/wpd.png

此时，你完了。
