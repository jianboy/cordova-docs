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

title: Android 平台指南
toc_title: Android
---

# Android 平台指南

本指南演示如何设置您的 SDK 环境部署科尔多瓦的 Android 设备的应用程式以及如何在您的开发工作流中 （可选） 使用 Android 居中的命令列工具。 您需要安装 Android SDK 无论是否你想要使用这些平台为中心的外壳工具或跨平台 Cordova CLI 的发展。 两条发展路径的比较，请参见概述。 CLI 的详细资讯，请参阅命令列介面。

## 要求和支援

科尔多瓦安卓系统要求可以在 OS X、 Linux 或 Windows 作业系统安装 Android SDK。 请参阅 Android SDK[的系统要求][1].

 [1]: http://developer.android.com/sdk/index.html#Requirements

科尔多瓦支援 Android 4.0.x (入手 Android API 级别 14） 和更高。 作为一般规则，Android 版本成为受科尔多瓦作为他们低于 5%的谷歌的[分布的仪表板][2]。 Android 版本早于 API 级别 10，和 3.x 版本 （蜂窝，API 级别 11 13） 显著低于那 5%的门槛。

 [2]: http://developer.android.com/about/dashboards/index.html

## 安装科尔多瓦壳工具

如果您想要使用科尔多瓦的 Android 居中外壳工具与 SDK 一起，从[cordova.apache.org][3]下载科尔多瓦。 如果您计划使用所述的命令列介面的跨平台 CLI 工具，否则忽略此节。

 [3]: http://cordova.apache.org

科尔多瓦下载包含单独的档案，为每个平台。 一定要展开相应的存档， `android` 在这种情况下，在一个空的目录内。 有关 executible 实用程式可用在顶级 `bin` 目录。 (参阅**自述**档，如果有必要作更详细的指示）。

这些外壳工具允许您创建、 构建和运行 Android 应用程式。 额外的命令列介面，可以跨所有平台的外挂程式功能的资讯，请参阅使用 Plugman 到管理外挂程式。 有关如何开发外挂程式的详细资讯，请参阅应用程式外挂程式。

## 安装 JAVA 开发工具箱 （JDK）

安装[JAVA 开发工具箱 （JDK） 7][4]或更高版本。

 [4]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html

在 Windows 上安装时您还需要设置`JAVA_HOME`环境变数根据 JDK 安装路径 （例如，C:\Program Files\JAVA\jdk1.7.0_75）。

## 安装 Android SDK

安装[独立的 Android SDK 工具][5]或[Android 的工作室][6]。 如果您计划开发新科尔多瓦为 Android 外挂程式或使用本机工具来运行和调试 Android 平台`Android 工作室`水墨画之发展。 否则， `Android 独立 SDK 工具`就足以构建和部署 Android 应用程式。

 [5]: http://developer.android.com/sdk/installing/index.html?pkg=tools
 [6]: http://developer.android.com/sdk/installing/index.html?pkg=studio

详细的安装说明，请参见上面的安装连结的一部分。

科尔多瓦的命令列工具来工作，或者基于他们的 CLI，您需要在您的`路径`中包括 SDK 的`工具`和`平台工具`目录。 在 Mac 或 Linux 上，你可以使用一个文字编辑器来创建或修改`~/.bash_profile`档，添加行，如下，根据 SDK 安装的位置:

        export PATH=${PATH}:/Development/android-sdk/platform-tools:/Development/android-sdk/tools


这条线在`~/.bash_profile`公开这些工具在新打开的终端视窗。 如果您的终端视窗已经打开在 OSX，或避免在 Linux 上的登出/登录，运行此工具以使他们在当前的终端视窗中可用：

        $ source ~/.bash_profile


若要修改`PATH`在窗户上的环境：

1.  在桌面的左下角的**开始**功能表上按一下，在**电脑**上，按右键，然后选择**属性**.

2.  在左边的列中选择**高级系统设置**。

3.  在结果对话方块中，按下**环境变数**.

4.  选择**PATH**变数，然后按**编辑**.

5.  追加到以下 `PATH` 基于在安装 SDK，例如：

        ;C:\Development\android-sdk\platform-tools;C:\Development\android-sdk\tools


6.  将值保存并关闭这两个对话方块。

## 安装 SDK 套装程式

打开 Android SDK 管理器 （例如，通过终端： `android`） 并安装：

1.  Android 5.1.1 （API 22） 平台 SDK
2.  Android SDK 生成工具版本 19.1.0 或更高版本
3.  Android 支援存储库 （额外）

有关更多详细资讯，请参阅[安装 SDK 包][7]。

 [7]: http://developer.android.com/sdk/installing/adding-packages.html

## 配置模拟器

预设情况下，android sdk 并不提供任何预设模拟程式实例。 您可以创建一个新的通过在命令列上运行`android` 。 新闻**工具 → 管理 AVDs** （Android 的虚拟装置），然后从**装置定义**在随后出现的对话方块中选择任何项：

![][8]

 [8]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_device.png

按**创建 AVD**，（可选） 修改该名称，然后按**确定**以接受这些更改：

![][9]

 [9]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_newAVD.png

AVD 然后出现在**虚拟的 Android 设备**清单中：

![][10]

 [10]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_avds.png

若要打开模拟器作为单独的应用程式，请选择 AVD，然后按**开始**。它推出一样在设备上，使用其他控制项可用的硬体按钮:

![][11]

 [11]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_emulator.png

为获得更快的体验，你可以使用`虚拟机器加速`以提高执行速度。 许多现代的 Cpu 提供扩展外挂程式，以更有效地执行虚拟机器。 尝试使用这种类型的加速度之前，您需要确定是否您当前的开发系统 CPU 支援一种以下的虚拟化技术：

*   **英特尔虚拟化技术**(VT-x，vmx) →[英特尔 VT-x 支援的处理器清单][12]
*   **AMD 虚拟化**（AMD-V，支援向量机），只支援 Linux （自 2006 年 5 月以来所有 Cpu AMD 都包括 AMD-V，闪龙除外）。

 [12]: http://ark.intel.com/products/virtualizationtechnology

另一种方法来找出是否您的英特尔处理器支援 VT x 技术、 它是由执行`英特尔处理器识别实用程式`、 `Windows`为您可以从英特尔[下载中心][13]，下载它或您可以使用[booteable 实用程式][14]，它是`独立于作业系统`.

 [13]: https://downloadcenter.intel.com/Detail_Desc.aspx?ProductID=1881&DwnldID=7838
 [14]: https://downloadcenter.intel.com/Detail_Desc.aspx?ProductID=1881&DwnldID=7840&lang=eng

后安装和执行的`英特尔处理器识别实用程式`在 Windows 中，你会得到下面的视窗，以检查是否您的 CPU 支援虚拟化技术：

![][15]

 [15]: {{ site.baseurl }}/static/img/guide/platforms/android/intel_pid_util_620px.png

为了加快模拟程式，您需要下载并安装一个或多个`Intel x86 原子`系统映射，以及`英特尔硬体加速执行经理 (HAXM)`.

打开你的 Android SDK 经理，并选择`Intel x86 原子`系统的形象，为任何一个你想要测试的版本。 然后转到`临时演员`和选择`Intel x86 模拟器加速器 （HAXM）`，并安装这些套装软体：

![][16]

 [16]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_man_intel_image_haxm.png

下载后，运行英特尔安装程式时，这是你 Android SDK 在`临时演员/英特尔/Hardware_Accelerated_Execution_Manager`中可用。 **注意**：`如果您有任何问题，安装套装软体，你可以找到更多的资讯和一步一步指导检查这` [篇文章英特尔][17].

 [17]: http://software.intel.com/en-us/android/articles/speeding-up-the-android-emulator-on-intel-architecture

1.  安装一个或多个`Intel x86 原子`系统映射，以及`英特尔硬体加速执行管理器`，可根据**临时演员**.

2.  运行英特尔安装程式时，这是你 Android SDK 在`临时演员/英特尔/Hardware_Accelerated_Execution_Manager`中可用.

3.  目标设置为英特尔图像创建新的 AVD。

4.  当启动模拟程式，确保有没有错误讯息，指示载入 HAX 模组失败。

## 创建一个新的专案

在这一点上，要创建一个新的专案你可以选择之间跨平台 CLI 工具的命令列介面或一组特定于 Android 的 shell 工具中所述。 从在原始程式码目录中，这里是 CLI 的方法：

        $ cordova create hello com.example.hello HelloWorld
        $ cd hello
        $ cordova platform add android
        $ cordova prepare              # or "cordova build"


这里是 Unix 和 Windows 的相应较低级别 shell 工具方法：

        $ /path/to/cordova-android/bin/create /path/to/new/hello com.example.hello HelloWorld
        C:\path\to\cordova-android\bin\create.bat C:\path\to\new\hello com.example.hello HelloWorld


## 生成专案

如果您在开发中使用 CLI，专案目录顶级`www`目录中包含的原始程式码档。运行任何这些专案目录重新生成该应用程式中：

        $ cordova build                   # build all platforms that were added
        $ cordova build android           # build debug for only Android
        $ cordova build android --debug   # build debug for only Android
        $ cordova build android --release # build release for only Android


如果使用的特定于 Android 的 shell 工具在发展中，还有一个不同的方法。 一旦您生成专案时，预设的应用程式的来源是可用的`资产/www`子目录中。 后续的命令，可在其`科尔多瓦`子目录。

`build`命令清理专案档案并重新生成应用程式。这里是 Mac 和 Windows 的语法。 第一次两个示例生成调试资讯，和第二个构建版本的应用程式：

        $ /path/to/project/cordova/build --debug
        C:\path\to\project\cordova\build.bat --debug

        $ /path/to/project/cordova/build --release
        C:\path\to\project\cordova\build.bat --release


## 部署应用程式

`科尔多瓦`CLI 实用程式可用于应用程式部署到模拟器或设备从命令列：

        $ cordova emulate android       #to deploy the app on a default android emulator
        $ cordova run android --device  #to deploy the app on a connected device


否则，请使用备用壳介面：

        $ /path/to/project/cordova/run --emulator
        $ /path/to/project/cordova/run --device


您可以使用**cordova run android --list**看到所有可用的目标和**cordova run android --target=target_name**在一个特定的设备或模拟器上运行应用程式 （例如，`cordova run android --target="Nexus4_emulator"`).

您还可以使用**cordova run --help**查看附加的生成和运行选项。

这将应用程式推送至主画面，启动它：

![][18]

 [18]: {{ site.baseurl }}/static/img/guide/platforms/android/emulator2x.png

当您`run`该应用程式，您还`build`它。 您可以附加额外`--debug`， `--release`，和`--nobuild`标志来控制它如何构建的或甚至是否重建是必需的：

        $ /path/to/project/cordova/run --emulator --nobuild


## 其他命令

下列生成详细的日志，该应用程式的运行时：

        $ /path/to/project/cordova/log
        C:\path\to\project\cordova\log.bat


以下清理的专案档案：

        $ /path/to/project/cordova/clean
        C:\path\to\project\cordova\clean.bat


## 在 SDK 中打开一个新专案

一旦 android 平台添加到专案中，你可以打开它从[Android Studio][6]内：

1.  推出**Android 工作室**中的应用。

2.  选择**导入专案 （Eclipse ADT，Gradle 等）**.

    ![][19]

3.  选择存储 （`你/专案/platforms/android` android 平台的位置).

    ![][20]

4.  `Gradle Sync`问题你可以干脆的回答**是**.

 [19]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_import_project.png
 [20]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_import_select_location.png

你现在有所有的和可以从生成并运行该应用程式直接`Android 工作室`.

![][21]

 [21]: {{ site.baseurl }}/static/img/guide/platforms/android/asdk_import_done.png

请参阅[Android 工作室概述][22][生成并运行从 Android 工作室][23]为更多的细节。

 [22]: http://developer.android.com/tools/studio/index.html
 [23]: http://developer.android.com/tools/building/building-studio.html
