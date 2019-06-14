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

title: Windows Phone 8 平台指南
---

# Windows Phone 8 平台指南

本指南介绍如何设置您的 SDK 开发环境部署科尔多瓦的 Windows Phone 设备的应用程式。 它侧重于 Windows Phone 8，但提供如何支援 Windows Phone 7 的附加详细资讯。

该示例演示如何使用任一特定的 Windows Phone 外壳程式工具来生成和生成的应用程式，或者跨平台科尔多瓦 CLI 讨论在命令列介面。 （见的概述的这些发展工作流比较）。此部分还显示了如何打开科尔多瓦的应用程式，以便您可以在 Visual Studio 中修改他们。 无论你采取哪种方法，您需要安装 Windows Phone SDK，如下所述。

见到 Windows Phone 平台特定的详细资讯如下：

*   [Windows Phone 8 外挂程式](plugin.html)
*   [升级 Windows Phone 8](upgrade.html)

对于 Windows Phone 8 平台，科尔多瓦 web 视图依赖于互联网资源管理器中 10 作为自己的渲染引擎，因此作为一个实际问题你可以使用 IE10 的功能强大的调试器来测试并不调用科尔多瓦 Api 的任何 web 内容。 Windows Phone 开发者博客如何支援 IE10 和可比较的 WebKit 浏览器提供[有益的指导][1]。

 [1]: http://blogs.windows.com/windows_phone/b/wpdev/archive/2012/11/15/adapting-your-webkit-optimized-site-for-internet-explorer-10.aspx

## 要求和支援

您需要以下各项：

*   64 位版本的 Windows 8 Pro，安装盘或*ISO*磁片影像档。 评估版是[Microsoft 开发人员网路][2]上可用。 Pro 版有必要运行设备模拟程式。

*   [Windows Phone SDK][3].

*   要通过命令列与 Windows Phone 8.0 SDK 部署，必须安装[Visual Studio 2012 更新 2][4] 。

 [2]: http://msdn.microsoft.com/en-US/evalcenter/jj554510
 [3]: http://www.microsoft.com/en-us/download/details.aspx?id=35471
 [4]: https://support.microsoft.com/en-us/kb/2797912

为了开发科尔多瓦的 Windows Phone 设备的应用程式，您可以使用运行 Windows 的电脑，但你也可能发展的 mac，通过运行一个虚拟机器环境或者通过使用新兵训练营双启动 Windows 的分区。 请查阅这些资源以设置在 Mac 上所需的 Windows 开发环境：

*   **VMWare 融合**： 要设置了 Windows 8 的虚拟机器，按照[Microsoft 开发人员网路][5]，所提供的说明，然后请参阅配置 VMWare 融合的虚拟环境运行 SDK 捆绑的模拟器的准备工作资讯。

*   **桌面的相似之处**： 若要设置 Windows 8 虚拟机器，按照[Microsoft 开发人员网路][6]，所提供的说明，然后请参阅配置平行桌面虚拟环境运行 SDK 捆绑的模拟器的准备工作资讯。

 [5]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945426
 [6]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945424

<!--
- __VirtualBox__: To set up the Windows 8 virtual machine, follow the
  installation instructions provided by the [Microsoft Developer
  Network](http://msdn.microsoft.com/en-US/library/windows/apps/jj945425).

  2DO: virtualBox doesn't work yet; any extra config info?
-->

*   **新兵训练营**： 要设置了 Windows 8 的分区，请按照操作[Microsoft 开发人员网路][7]所提供的安装说明.

 [7]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945423

如果您在 PC 上开发，其处理器必须支援虚拟化 （英特尔*VT-x* ） 和[第二级别位址翻译 （板式）][8]。 请查阅[英特尔的支援的处理器的清单][9]。 虚拟化是通常预设禁用的所以您需要在您的 BIOS 设置中启用它。 PC 应该有至少 6.5 GB 的可用硬碟空间和 4 GB 的 RAM。

 [8]: http://en.wikipedia.org/wiki/Second_Level_Address_Translation
 [9]: http://ark.intel.com/Products/VirtualizationTechnology

## 使用科尔多瓦外壳工具

如果您想要使用科尔多瓦的 Windows Phone 居中外壳工具与 SDK 一起，你有两个基本选项：

*   本地访问它们生成的 CLI 的专案代码中。他们是可用在 `platforms/wp8/cordova` 目录在您添加后 `wp8` 平台如下所述。

*   从单独的分发在[cordova.apache.org][10]下载它们。 科尔多瓦分布包含单独的档案，为每个平台。 一定要展开相应的存档， `cordova-wp8\wp8` 在这种情况下，在一个空的目录内。 有关批次处理实用程式可用在顶级 `bin` 目录。 (参阅**自述**档，如果有必要作更详细的指示）。

 [10]: http://cordova.apache.org

这些外壳工具允许您创建、 构建和运行 Windows Phone 应用程式。 额外的命令列介面，可以跨所有平台的外挂程式功能的资讯，请参阅使用 Plugman 到管理外挂程式。 指导如何开发外挂程式和 Windows Phone 8 外挂程式特定于 Windows Phone 平台的详细资讯，请参阅应用程式外挂程式。

## 安装 SDK

从[dev.windowsphone.com][11]的**下载**区域安装最新版本的 Windows Phone SDK。 你也可以安装更多最近的模拟程式更新程式封装。

 [11]: https://dev.windowsphone.com/en-us/downloadsdk

![][12]

 [12]: {{ site.baseurl }}/static/img/guide/platforms/wp8/wp8_downloadSDK.png

## 创建一个新专案

在这一点上，要创建一个新的专案你可以选择之间跨平台 CLI 工具的命令列介面或的一组特定的 Windows Phone 壳工具中所述。 在原始程式码目录中，这里是从 CLI 的方法：

        > cordova create hello com.example.hello HelloWorld
        > cd hello
        > cordova platform add wp8
    

下面是相应的低级别 shell 工具方法：

        C:\path\to\cordova-wp8\bin\create.bat C:\path\to\new\hello com.example.hello HelloWorld
    

## 生成专案

如果您在开发中使用 CLI，专案目录的顶级 `www` 目录中包含的原始程式码档。运行任一内要重新生成应用程式的专案目录：

        > cordova build
        > cordova build wp8   # do not rebuild other platforms
    

如果您使用特定的 Windows Phone 外壳工具在发展中，还有不同的做法。 一旦您生成专案时，预设的应用程式的源是可用在 `projects\wp8\www` 子目录。 随后命令都可用在 `cordova` 子目录中同一级别的。

`build`命令清除专案档案并重新生成应用程式。第一个示例将生成调试资讯，和第二个标志发布的应用程式：

        C:\path\to\project\cordova\build.bat --debug        
        C:\path\to\project\cordova\build.bat --release
    

`clean`命令可以说明冲洗中准备的下一个目录 `build` ：

        C:\path\to\project\cordova\clean.bat
    

## 部署到模拟程式

在这一点上，您可以使用 `cordova` 实用程式 CLI 应用程式部署到模拟程式从命令列：

        > cordova emulate wp8
    

否则使用备用壳介面：

        C:\path\to\project\cordova\run
    

预设情况下， `run` 脚本调用的模拟器的标志，并为其接受附加生成标志， `--debug` 提供的预设值：

        C:\path\to\project\cordova\run --emulator --debug
        C:\path\to\project\cordova\run --emulator --release
        C:\path\to\project\cordova\run --emulator --nobuild
    

在启动模拟器设备图像与安装的应用程式。 从主画面，导航到要启动**HelloWorld**应用程式的应用程式面板。这显示了应用程式启动与它闪屏，其次是它的主介面：

![][13]

 [13]: {{ site.baseurl }}/static/img/guide/platforms/wp8/wp8_emulator.png

设备的萤幕顶部右边模拟程式的基本控制项允许您以纵向和横向方向之间切换。 **>**按钮将打开更多的控制项，使您可以测试更复杂的取向和手势：

![][14]

 [14]: {{ site.baseurl }}/static/img/guide/platforms/wp8/wp8_emulator_orient.png

这些先进的控制项还允许您修改该设备的位置或类比的运动序列：

![][15]

 [15]: {{ site.baseurl }}/static/img/guide/platforms/wp8/wp8_emulator_loc.png

## 将部署到设备

在测试之前您设备上的应用程式，必须注册该设备。 有关如何部署和测试 Windows Phone 8 上的详细资讯，请参考[微软的文档][16]。 此外，还要确保手机连接到电脑，和萤幕处于解锁状态。

 [16]: http://msdn.microsoft.com/en-us/library/windowsphone/develop/ff402565.aspx

然后运行下面的 CLI 命令，要在设备上运行的应用程式：

    > cordova run wp8
    

它对应于此较低级别 shell 命令：

    C:\path\to\project\cordova\run --device
    

或者，如果你工作在 Visual Studio 中， **Windows Phone 设备**从功能表中选择下拉在顶部，然后按绿色**播放**按钮附近，否则键入**F5**.

## 修改在 SDK 中的专案

一旦你建立科尔多瓦的应用程式，如上文所述，您可以使用 SDK 打开它。 各种 `build` 命令会生成一个 Visual Studio 解决方案 (*.sln*) 档。 打开要修改在 Visual Studio 专案的档。 基于 web 的原始程式码，该代码是在专案内可用 `www` 目录。 以及其他工具 SDK 提供，下面的功能表控制项使您可以启动该应用程式在 Windows Phone 模拟器中：

![][17]

 [17]: {{ site.baseurl }}/static/img/guide/platforms/wp8/wp8_vs.png

如何在您的工作流中使用科尔多瓦的命令列工具或 SDK 的建议咨询的概述。 科尔多瓦 CLI 依赖于跨平台原始程式码通常会覆盖使用 SDK 的特定于平台的档。 如果你想要在 SDK 内工作，使用较低级别外壳工具作为 CLI 的替代方法。
