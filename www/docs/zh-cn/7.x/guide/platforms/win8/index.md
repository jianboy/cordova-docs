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

title: Windows 平台指南
toc_title: Windows
---

# Windows 平台指南

本指南介绍如何设置您的 SDK 开发环境来构建和部署应用程式Cordova为 Windows 8、 Windows 8.1、 Windows Phone 8.1 和 Windows 10 通用应用程式平台。 它演示如何使用 shell 工具来生成和生成应用程式，或跨平台Cordova CLI 讨论了在命令列介面。 (见比较这些发展选项的概述)。本节还演示了如何修改Cordova在 Visual Studio 中的应用程式。 无论你采取哪种方法，您需要安装 Visual Studio SDK，如下所述。

有关如何升级现有的 Windows 8 Cordova专案的资讯，请参阅升级 Windows 8。

视窗电话 8 （wp8） 住宿作为一个独立的平台，有关详细资讯，请参阅 Windows Phone 8 平台指南。

在 Windows 上运行的Cordova WebViews 依赖互联网资源管理器中 10 （Windows 8.0） 和互联网资源管理器中 11 （Windows 8.1 和 Windows Phone 8.1） 作为他们的渲染引擎，因此作为一个实际问题你可以使用 IE 的功能强大的调试器来测试并不调用Cordova Api 的任何 web 内容。 Windows Phone 开发者博客上可比的 WebKit 浏览器支援 IE 如何提供[有益的指导][1]。

 [1]: http://blogs.windows.com/windows_phone/b/wpdev/archive/2012/11/15/adapting-your-webkit-optimized-site-for-internet-explorer-10.aspx

## 要求和支援

若要开发 Windows 平台的应用程式需要：

*   最低 4 gb 的 RAM 的 Windows 8.1，32 或 64 位机器 （*家里*、*临*，或*企业*版）。

*   Windows 8.0、 8.1 或 10、 32 或 64 位*回家*，*临*，或*企业*版，以及[Visual Studio 2012 速成版][2]或视觉工作室 2013 年。 视觉工作室 2015年是不能够构建 Windows 8.0 的应用程式。

 [2]: http://www.visualstudio.com/downloads

为 Windows 8.0 和 8.1 (包括 Windows Phone 8.1) 开发的应用程式:

*   Windows 8.1 或 Windows 10、 32 或 64 位*回家*，*临*，或*企业*版，以及[Visual Studio 2013 速成版][2]或更高。 Windows 8.1 企业评估版是可从[Microsoft 开发人员网路][3].

*   为 Windows Phone 模拟器，Windows 8.1 (64) 专业版或更高，和一个处理器，支援[用户端 HYPER-V 和第二级别位址翻译 (板)][4]。 Windows 8.1 企业评估版是可从[Microsoft 开发人员网路][3].

*   [Windows 视觉工作室 2013 年][5](明示或更高)。

 [3]: http://msdn.microsoft.com/en-US/evalcenter/jj554510
 [4]: https://msdn.microsoft.com/en-us/library/windows/apps/ff626524(v=vs.105).aspx#hyperv
 [5]: http://www.visualstudio.com/downloads/download-visual-studio-vs#d-express-windows-8

为 Windows 10 开发的应用程式:

*   Windows 8.1 或 Windows 10 技术预览 2，32 位或 64 位，以及[视觉工作室 2015 RC][6]或更高。

 [6]: http://www.visualstudio.com/preview

应用程式相容性是由应用程式针对作业系统决定的。 应用程式是主动相容但不是厚此薄彼-相容，所以针对 Windows 8.1 应用程式不能运行在 8.0，但为 8.0 建造一个应用程式可以运行在 8.1。

按照说明在[windowsstore.com][7]提交到 Windows 应用商店应用程式。

 [7]: http://www.windowsstore.com/

为 Windows 开发Cordova的应用程式，您可以使用 pc 机运行 Windows，但你也可能发展在 Mac 上运行的虚拟机器环境或到双启动 Windows 8.1 分区使用新兵训练营。 请查阅这些资源来设置在 Mac 上所需的 Windows 开发环境:

*   [VMWare Fusion][8]

*   [Parallels Desktop][9]

*   [Boot Camp][10]

 [8]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945426
 [9]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945424
 [10]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945423

## 使用Cordova外壳工具

如果你想要将与 SDK 一起使用Cordova的 Windows 居中外壳工具，你有两个基本选择：

*   他们从本地访问生成的 CLI 的专案代码。他们是在`平台/windows/`目录后添加`windows`平台如下所述。

*   从单独的分发在[cordova.apache.org][11]下载它们。 Cordova分布包含单独的档案，为每个平台。 一定要扩大相应的存档，`Cordova windows`在这种情况下，在一个空的目录内。 有关批次处理实用程式可用`包/bin`目录中。 (参阅**自述**档，如果需要更详细的说明)。

 [11]: https://www.apache.org/dist/cordova/platforms/

这些外壳工具允许您创建、 构建和运行 Windows 应用程式。 附加的命令列介面，可以跨所有平台的外挂程式功能的资讯，请参阅使用 Plugman 管理外挂程式。

## 安装 SDK

安装任何版本的[Visual Studio][2]匹配要求上面列出的版本。

![][12]

 [12]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_installSDK.png

为 Windows 10，Visual Studio 安装程式没有安装工具来构建通用的 Windows 应用程式的选项。 你必须确保，此选项是在安装时选择安装所需的 SDK。

## 创建一个新专案

在这一点上，要创建一个新的专案你可以选择之间跨平台 CLI 工具的命令列介面或一组特定的 Windows 外壳工具所述。 下面的 CLI 方法生成新的`你好`专案目录中命名*HelloWorld*应用程式:

        > cordova create hello com.example.hello HelloWorld
        > cd hello
        > cordova platform add windows
    

下面是相应的较低级别壳工具方法:

        C:\path\to\cordova-windows\package\bin\create.bat C:\path\to\new\hello com.example.hello HelloWorld
    

本专案的目标 Windows 8.1 作为预设的目标作业系统。 你可以选择目标 8.0 或 10.0 (见下文的"配置目标 Windows 版本") 为所有的生成，或你在每次生成目标特定于特定的版本。

## 生成专案

如果您使用 CLI 在发展中，专案目录的顶级 `www` 目录中包含的原始程式码档。运行任一专案目录重新生成该应用程式中:

        > cordova build
        > cordova build windows              # do not rebuild other platforms
        > cordova build windows   --debug    # generates debugging information
        > cordova build windows   --release  # signs the apps for release
    

下面是相应的较低级别壳工具方法:

        C:\path\to\project\cordova\build.bat --debug        
        C:\path\to\project\cordova\build.bat --release
    

`clean`命令可以说明搜捕中准备的下一个目录 `build` :

        C:\path\to\project\cordova\clean.bat 
    

## 配置目标 Windows 版本

由预设的`生成`命令将生成两个包: Windows 8.0 和 Windows Phone 8.1。 升级到版本 8.1 以下配置设置必须添加到设定档 (`config.xml`的 Windows 套装程式).

        <preference name="windows-target-version" value="8.1" />
    

一旦你添加此设置`生成`命令将开始生产 Windows 8.1 和 Windows Phone 8.1 包。

### --appx 参数

您可能会决定你想要建立的针对特定作业系统的应用程式的特定版本 (例如，您可能有设置您想要针对 Windows 10，但您想要构建 Windows Phone 8.1)。 要做到这一点，你可以使用`--appx`参数:

        > cordova build windows -- --appx=8.1-phone
    

生成系统将忽略 config.xml 目标 Windows 版本中设置的偏好，并严格为 Windows Phone 8.1 生成套装软体。

`--appx`国旗有效值为`8.1-win`、 `8.1-phone`和`uap`(对于 Windows 10 通用应用程式)。 这些选项也适用于`cordova run`命令。

### 目标 Windows 版本的注意事项

Windows 10 Cordova的应用程式 (和一般的 HTML 应用程式) 支援一种新的"远端"模式。 这种模式使应用程式更多的自由与尊重使用 DOM 操作和常见的 web 模式，例如使用内联脚本，但如此通过减少的功能集时提交给公共 Windows 应用商店，可使用您的应用程式。 有关 Windows 10 和远端模式的详细资讯，请查看[Cordova为 Windows 10][13]文档。

 [13]: win10-support.md.html

使用远端模式时，开发人员被鼓励申请内容安全政策 (CSP) 到他们的应用程式，以防止脚本注入攻击。

## 部署应用程式

要部署 Windows 套装程式:

        > cordova run windows -- --win  # explicitly specify Windows as deployment target
        > cordova run windows # `run` uses Windows package by default
    

要将 Windows Phone 包部署:

        > cordova run windows -- --phone  # deploy app to Windows Phone 8.1 emulator
        > cordova run windows --device -- --phone  # deploy app to connected device
    

可以使用**cordova run windows --list**来查看所有可用的目标和**cordova run windows --target=target_name \-- -|-phone**，在特定的设备或模拟器上运行的应用程式 （例如，`cordova run windows --target="Emulator 8.1 720P 4.7 inch" -- --phone`).

您还可以使用**Cordova运行 — — 说明**查看附加的生成和运行选项。

## 在 SDK 中打开的专案和部署应用程式

一旦你建立Cordova应用程式，如上文所述，可以在 Visual Studio 打开它。 各种`生成`命令生成一个 Visual Studio 解决方案 (*.sln*) 档。 档资源管理器来修改在 Visual Studio 专案中打开的档:

![][14]

 [14]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_openSLN.png

`CordovaApp`元件显示解决方案中, 和其`www`目录包含基于 web 的原始程式码，包括`index.html`主页:

![][15]

 [15]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk.png

Visual Studio 主功能表下面的控制项允许您测试或部署应用程式:

![][16]

 [16]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_deploy.png

选择**本地电脑**，请按绿色箭头运行 Visual Studio 在同一机器上安装的应用程式。一旦你这样做，应用程式将出现在 Windows 8 应用程式清单:

![][17]

 [17]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_runApp.png

每次您重新生成应用程式，在介面中可用的版本被刷新。

一旦可用应用程式清单中，按住**CTRL**键，同时选择该应用程式允许您用别针把它到主画面:

![][18]

 [18]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_runHome.png

请注意，是否你打开的应用程式在虚拟机器环境中，您可能需要按一下在角落里或两侧的窗户，切换应用程式或访问附加功能:

![][19]

 [19]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_run.png

或者，选择**模拟器**部署选项以查看该应用程式，就好像它在平板设备上运行:

![][20]

 [20]: {{ site.baseurl }}/static/img/guide/platforms/win8/win8_sdk_sim.png

与不同的桌面部署，此选项允许您类比平板电脑的定位，位置，和改变其网路设置。

**注**: 有关如何在您的工作流中使用Cordova的命令列工具或 SDK 建议查阅概述。 Cordova CLI 依赖于跨平台原始程式码通常覆盖 SDK 所使用的特定于平台的档。 如果你想要使用 SDK 来修改专案，使用较低级别外壳工具作为 CLI 的替代方法。
