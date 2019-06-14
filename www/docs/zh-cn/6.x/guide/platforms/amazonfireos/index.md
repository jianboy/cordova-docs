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

title: 亚马逊火 OS 平台指南
---

# 亚马逊火 OS 平台指南

本指南介绍如何设置您的 SDK 开发环境部署亚马逊火 OS 的设备，如 Kindle 火 HDX 科尔多瓦应用软体。

请参阅下列特定于平台的详细资讯：

*   [亚马逊火 OS 配置](config.html)
*   [亚马逊火 OS WebViews](webview.html)
*   [亚马逊火 OS 外挂程式](plugin.html)

## 简介

通过针对亚马逊火 OS 平台，科尔多瓦开发人员可以创建利用先进的 web 引擎集成的 Kindle 消防设备的混合 web 应用程式。 亚马逊 web 视图 API (AWV) 是独有的火 OS 铬派生的 web 运行时。 为 web 视图使用的 Android 设备附带的投递更换，AWV 使成为可能，更好地执行功能更强大的混合 web 应用程式通过创建为一个更快的 JavaScript 引擎 (V8)、 远端侦错和 Kindle 消防设备包括加速 2D 画布的硬体优化提供支援和不支援的 Android 的 HTML5 功能的访问内置的 web 视图如: CSS 除垢，表单验证，getUserMedia，IndexedDB、 网路工作者、 WebSockets 和 WebGL。

关于亚马逊 web 视图 API 的详细资讯，请参阅亚马逊开发人员门户[HTML5 混合应用程式页][1]。 有关获取开始和其他的问题支援问题，请参见亚马逊开发人员门户[论坛-HTML5 混合应用程式][2].

 [1]: https://developer.amazon.com/public/solutions/platforms/android-fireos/docs/building-and-testing-your-hybrid-app
 [2]: http://forums.developer.amazon.com/forums/category.jspa?categoryID=41

## 要求和支援

亚马逊火 os 开发科尔多瓦的应用程式需要安装的各种支援档，包括 android 系统的发展，以及亚马逊 web 视图 SDK 所需的一切。 请检查下面的清单中所需的安装：

*   [命令列介面](../../cli/index.html)
*   [Android SDK][3]
*   [Apache Ant][4]
*   [亚马逊 web 视图 SDK][1]

 [3]: http://developer.android.com/sdk/
 [4]: http://ant.apache.org

## 安装

### Android SDK 和 Apache Ant

从[developer.android.com/sdk][3]安装 Android SDK。 你可能会出现一个选择在哪里安装 SDK，否则移动下载 `adt-bundle` 树到无论您存储的开发工具。

你需要在运行 Android SDK 管理器 （ `android` 从命令列） 开始您的科尔多瓦专案前至少一次。 一定要安装最新版本的 Android SDK 工具和 SDK 平台**具体 API 级别为 19**。 请关于亚马逊开发人员门户如何设置您的开发环境为 Kindle 火 OS 设备的详细资讯，参阅[您的开发环境设置][5]。

 [5]: https://developer.amazon.com/public/resources/development-tools/ide-tools/tech-docs/01-setting-up-your-development-environment

Apache Ant 生成工具[下载蚂蚁二进位分发][6]，解压缩到您以后可以引用的目录的安装。 请参阅[Ant 手册][7]为更多的资讯。

 [6]: http://ant.apache.org/bindownload.cgi
 [7]: http://ant.apache.org/manual/index.html

对于科尔多瓦的命令列工具来工作，您需要包括 Android SDK 的 `tools` 、 `platform-tools` 和 `apache-ant/bin` 目录路径环境中的。

#### Mac/Linux 路径

关于 Mac、 Linux 或其他 unix 平台，您可以使用文字编辑器来创建或修改 `~/.bash_profile` 档中，添加行，如下，依据的 SDK 和 Ant 安装位置：

    汇出路径 = ${路径}：/开发/adt-捆绑/sdk/平台-工具：/开发/adt-捆绑/sdk/工具：/发展/阿帕奇-ant/bin
    

这暴露了 SDK 工具在新打开的终端视窗。否则运行这使它们在当前会话中可用：

    $ source ~/.bash_profile
    

#### Windows 路径

若要修改路径在 Windows 上的环境：

*   在桌面的左下角的**开始**功能表上按一下，在**电脑**上，按右键，然后按一下**属性**.

*   在左侧列中，按一下**高级系统设置**。

*   在结果对话方块中，按下**环境变数**.

*   选择**PATH**变数，然后按**编辑**.

*   将以下内容追加到哪里你安装了 SDK 和蚂蚁，例如基于的路径：
    
        ;C:\Development\adt-bundle\sdk\platform-tools;C:\Development\adt-bundle\sdk\tools;C:\Development\apache-ant\bin
        

*   将值保存并关闭这两个对话方块。

*   您还将需要启用 JAVA。 打开一个命令提示符并键入 `java` ，如果它没有运行，追加到您的路径以及 JAVA 二进位档案的位置。 请确保已安装 JDK 目录指向的 %JAVA_HOME%。 您可能必须添加 JAVA_HOME 环境变数分别。
    
        ； %JAVA_HOME%\bin
        

### 亚马逊 web 视图 SDK

若要创建使用目标亚马逊火 OS 平台的科尔多瓦应用程式，您需要下载、 解压和安装亚马逊 web 视图 SDK 的支援档。 这一步只需要为你的第一个亚马逊火 OS 专案做。

*   从[亚马逊开发人员门户][1]下载亚马逊 web 视图 SDK.

*   复制 `awv_interface.jar` 从下载 SDK 到科尔多瓦的工作目录。如果它不存在，请创建 commonlibs(shown below) 资料夹：
    
    **Mac/Linux:** `~/.cordova/lib/commonlibs/`
    
    **Windows:** `%USERPROFILE%\.cordova\lib\commonlibs`

## 为亚马逊火 OS 创建新专案

使用 `cordova` 实用程式来建立一个新的专案，如所述在科尔多瓦的命令列介面。例如，在一个原始程式码目录:

    $ cordova create hello com.example.hello "HelloWorld"
    $ cd hello
    $ cordova platform add amazon-fireos
    $ cordova build
    

***注：***第一次亚马逊 fireos 平台的安装在您的系统，它会到科尔多瓦的工作目录，下载相应的档但然后会失败，因为它缺少 AWV SDK 的支援档 （见上文）。 请按照上面的说明来安装 `awv_interface.jar` ，删除，然后重新将亚马逊 fireos 平台添加到您的专案。 这一步只需要为第一次亚马逊火 OS 专案做。

## 将部署到设备

一个应用程式直接推向该设备，请确保您的设备在[Android 开发者网站][8]上，所述上启用 USB 调试和使用一个迷你的 USB 电缆，把它插到你的系统。

 [8]: http://developer.android.com/tools/device.html

您可以从命令列将应用程式推送到设备：

    $ 科尔多瓦运行亚马逊 fireos
    

或者在 Eclipse，按右键该专案，然后选择**→ 作为运行 Android 应用程式**.

**注**： 目前，对于亚马逊 web 视图基于应用程式测试通过模拟器不支援，另外亚马逊 web 视图 API 是只可用火 OS 的设备上。 有关详细资讯，请参阅[亚马逊 web 视图 API SDK][1]文档。

### 运行标志

运行命令接受可选参数作为科尔多瓦的命令列介面文档中指定，火 OS 也接受额外 `--debug` 将启用远端 web 调试铬的开发人员工具的标志。

要使用的开发工具，请输入：

    $ cordova run --debug amazon-fireos
    

这将使在用户端上运行的工具。你可以连接到用户端通过埠转发使用安卓系统调试桥 （亚银） 指的应用程式的包名。

例如：

    亚行转发 tcp:9222 localabstract:com.example.helloworld.devtools
    

然后，可以使用通过基于铬的浏览器 DevTools 导航到：`http://localhost:9222`.

### 可选的 Eclipse 支援

一旦创建，您可以使用 Eclipse 随之而来的 Android SDK 来修改专案。 要小心是否你继续使用科尔多瓦命令列工具，通过 Eclipse 所做的修改将被覆盖。

*   启动**Eclipse**应用程式。

*   选择**新建专案**功能表项目。

*   从结果对话方块中，选择**从现有代码的 Android 专案**并按**下一步**： ![][9]

*   定位到 `hello` ，或无论你创建目录的专案，然后到 `platforms/amazon-fireos` 子目录。

*   Eclipse 将显示你你好、 你好-CorddovaLib-2 专案要添加。添加两个。

*   按**完成**.

 [9]: {{ site.baseurl }}/static/img/guide/platforms/android/eclipse_new_project.png

一旦日食视窗打开，一个红色的**X**可能似乎表明未解决的问题。如果是这样，请按照这些额外的步骤：

*   按右键专案目录。

*   在出现的**属性**对话方块中，选择**Android**从功能窗格。

*   专案的生成目标，请选择最高的 Android API 级别 （目前 API 级别 19），安装了。

*   按一下**确定**.

*   从**专案**功能表中选择**清洁**。这应该更正该专案中的所有错误。
