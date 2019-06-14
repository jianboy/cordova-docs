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

title: 命令列介面
toc_title: Create your first app
---

# 命令列介面

本指南演示如何创建应用程式并将它们部署到各种本机移动平台，使用 `cordova` 命令列介面 (CLI)。 此工具允许您创建新的专案、 生成它们在不同平台上，并运行实际设备或模拟程式内。 CLI 是要使用的跨平台工作流概述中所述的主要工具。 否则还可以使用 CLI 来初始化专案代码，然后切换到各种平台 Sdk 和外壳工具为继续发展。

## 系统必备元件

在运行任何命令列工具之前, 您需要为每个您想要的目标的平台安装 Sdk。（参见平台指南更多详细资讯。

若要添加支援或重建任何平台的一个专案，您需要从支援的平台 SDK 的同一台电脑上运行命令列介面。CLI 支援以下组合：

*   iOS (Mac)
*   亚马逊火 OS （Mac、 Linux、 Windows）
*   Android （Mac、 Linux、 Windows）
*   黑莓 10 （Mac、 Linux、 Windows）
*   Windows Phone 8 (Windows)
*   视窗 （视窗）
*   火狐浏览器的作业系统 （Mac、 Linux、 Windows）

在 Mac 上，命令列是可通过*终端*应用的。在 PC 上，它是可作为*命令提示符*下*配件*.

**注**： 仅限 Windows 平台，你还可以您在 Mac 的硬体上的发展通过在虚拟机器环境中或在双启动模式下运行 Windows。 可用的选项，请参阅 Windows Phone 8 平台指南或 Windows 平台指南。

就越有可能是你在 CLI 运行从不同的机器，更有意义保持远端原始程式码储存库，你拉下到本地工作目录的资产。

## 安装科尔多瓦 CLI

作为故宫包中使用准备好的格式分发，科尔多瓦命令列工具。不是有必要从原始程式码中编译它。

若要安装 `cordova` 命令列工具，请按照这些步骤操作：

1.  下载并安装[Node.js][1]。 安装完成后，您应该能够调用 `node` 和 `npm` 在命令列上。 如果需要，您可能会选择使用工具如 `nvm` 或 `nave` 来管理您的 Node.js 安装。

2.  下载并安装一个[git 用户端][2]，如果你已经没有之一。 安装完成后，您应该能够调用 `git` 对您的命令列。 即使您不会使用 `git` 手动，CLI 不会使用它幕后下载一些资产时创建一个新专案。

3.  安装 `cordova` 模组使用 `npm` 实用程式的 Node.js。`cordova`模组将会自动下载的 `npm` 实用程式。

 [1]: http://nodejs.org/
 [2]: http://git-scm.com/

*   在 OS X 与 Linux：
    
            $ sudo npm install -g cordova
        
    
    在 OS X 与 Linux，首码 `npm` 命令与 `sudo` 可能需要安装这种发展中的实用程式否则限制目录如 `/usr/local/share` 。 如果您使用的可选的 nvm/教堂中殿工具或具有对安装目录的写存取权限，您可能能够省略 `sudo` 首码。 有[的更多提示][3]可用上使用 `npm` 无 `sudo` 、 如果你渴望做的。

*   关于视窗：
    
            C:\>npm install -g cordova
        
    
    `-g`国旗上面告诉 `npm` 要安装 `cordova` 全球。 否则它将被安装在 `node_modules` 的当前工作目录的子目录。
    
    您可能需要添加 `npm` 目录到您 `PATH` 调用全域安装 `npm` 模组。 在 Windows 中， `npm` 通常可以发现在 `C:\Users\username\AppData\Roaming\npm` 。 在 OS X 与 Linux 上它通常可以找到在`/usr/local/share/npm`.
    
    安装日志可能会产生错误的任何已卸载平台 Sdk。
    
    安装完成后，您应该能够运行 `cordova` 与没有参数和它在命令列上应列印说明文本。

 [3]: http://justjs.com/posts/npm-link-developing-your-own-npm-modules-without-tears

## 创建应用程式

转至目录位置您维护您的原始程式码，并运行以下命令：

        $ cordova create hello com.example.hello HelloWorld
    

它可能需要一些时间完成的命令，有耐心。运行该命令与 `-d` 选项将显示有关其进度的资讯。

*你好*第一个参数指定要为您的专案生成的目录。 此目录不应该存在，科尔多瓦将为您创建它。 其 `www` 子目录的房子您应用程式的主页上，与各种资源下 `css` ， `js` ，和 `img` ，其中遵循共同 web 发展的档命名约定。 这些资产将会存储在设备的本地档案系统，不提供远端。 `config.xml`档包含生成和分发应用程式所需的重要的中继资料。

第二个参数 `com.example.hello` 为您的专案提供了一个反向域样式识别码。 此参数是可选的但只有当你也省略第三个参数，因为参数是位置。 您可以编辑以后此值在 `config.xml` 档中，但一定要注意可能生成外部的代码 `config.xml` 使用此值，如 JAVA 套装软体名称。 预设值是 `io.cordova.hellocordova` ，但它建议你选择一个适当的值。

第三个参数 `HelloWorld` 提供了应用程式的显示标题。 此参数是可选的。 您可以编辑以后此值在 `config.xml` 档中，但一定要注意可能生成外部的代码 `config.xml` 使用此值，如 JAVA 类的名称。 预设值是 `HelloCordova` ，但它建议你选择一个适当的值。

## 添加平台

后面的所有命令都需要在专案的目录或在其范围内的任何子目录内运行：

        $ cd hello
    

您可以生成专案之前，您需要指定一组的目标平台。 您运行这些命令的能力取决于您的电脑是否支援每个 SDK，是否你已经安装每个 SDK。 运行任何这些从 Mac：

        $ cordova platform add ios
        $ cordova platform add amazon-fireos
        $ cordova platform add android
        $ cordova platform add blackberry10
        $ cordova platform add firefoxos
    

运行的这些 Windows 机器上，从任何地方*wp*指的是不同版本的 Windows Phone 作业系统：

        $ 科尔多瓦平台添加 wp8 $ 科尔多瓦平台添加的 windows $ 科尔多瓦平台添加亚马逊 fireos $ 科尔多瓦平台添加 android $ 科尔多瓦平台添加 blackberry10 $ 科尔多瓦平台添加 firefoxos
    

运行此检查当前设置的平台：

        $ cordova platforms ls
    

（请注意 `platform` 和 `platforms` 命令是同义语.)

请运行下列同义命令来删除一个平台之一：

        $ cordova platform remove blackberry10
        $ cordova platform rm amazon-fireos
        $ cordova platform rm android
    

运行命令来添加或删除平台影响专案的*平台*目录的内容每个指定的平台作为一个子目录中的显示位置。 *Www*原始目录转载内每个平台的子目录中，例如出现在 `platforms/ios/www` 或 `platforms/android/assets/www` 。 因为 CLI 不断复制在源*www*资料夹中的档，应只编辑这些档，并不是位于*平台*的子目录下。 如果您使用的版本控制软体，您应将此源*www*资料夹，该*合并*的资料夹，添加到您的版本控制系统。 （有关*合并*资料夹的详细资讯可以找到下面的自订每个平台部分中）

**警告**： 当使用 CLI 来构建您的应用程式，你应该*不是*编辑任何档在 `/platforms/` 目录，除非你知道你在做什么，或者如果档指定，否则。 准备申请建设，或重新安装外挂程式时经常将覆盖此目录中的档。

如果您希望在此时，你可以使用 Eclipse 或 Xcode SDK 打开你创建的专案。 您将需要打开的资产从衍生金融工具集 `/platforms/` 要用 SDK 开发目录。 这是因为 SDK 的特定元资料档案存储在相应的 `/platform/` 子目录。 （见如何开发应用程式每个 IDE 内的资讯平台指南）使用这种方法，如果你只是想要初始化使用 CLI 的专案，然后切换到 SDK 为本机的工作。

如果您想要使用的整个开发周期的跨平台的工作流方式 (CLI)，请继续阅读。

## 构建应用程式

预设情况下， `cordova create` 脚本生成骨骼基于 web 应用程式的主页是该专案的 `www/index.html` 档。 编辑此应用程式，但是你想要但应作为的一部分指定的任何初始化 `[deviceready](../../cordova/events/events.deviceready.html)` 事件处理常式中，从预设的引用`www/js/index.js`.

运行以下命令以反复运算方式生成专案：

        $ cordova build
    

这将生成特定于平台代码内专案的 `platforms` 子目录。你可以选择限制到特定的平台每个生成的范围：

        $ cordova build ios
    

`cordova build`命令是以下，而在此示例中还针对的是一个单一的平台的简写形式：

        $ cordova prepare ios
        $ cordova compile ios
    

在这种情况下，一次您运行 `prepare` ，你可以作为备用使用苹果公司的 Xcode SDK 修改和编译科尔多瓦在范围内生成的特定于平台代码 `platforms/ios` 。 您可以使用相同的方法与其他平台的 Sdk。

## 测试模拟器或设备上的应用程式

移动平台 Sdk 经常与捆绑在一起执行设备的图像，以便您可以启动该应用程式从主画面并看看它如何与许多平台功能交互的模拟程式。 运行如下命令来重新生成应用程式并查看它在特定的平台模拟器内：

        $ cordova emulate android
    

一些移动平台类比特定设备预设情况下，iPhone 的 iOS 专案等。对于其他平台，您可能需要首先将设备模拟程式与相关联。

**注**： 模拟器支援目前不可用的亚马逊火 OS。

（见平台指南的详细资讯）。例如，您可能会首先运行 `android` 命令以启动 Android SDK，然后运行一个特定的设备图像，启动它根据其预设行为：

![][4]

 [4]: {{ site.baseurl }}/static/img/guide/cli/android_emulate_init.png

跟进与 `cordova emulate` 命令刷新显示的最新应用，现已从主画面发射的模拟程式图像：

![][5]

 [5]: {{ site.baseurl }}/static/img/guide/cli/android_emulate_install.png

或者，可以将手机插入您的电脑和直接测试应用程式：

        $ cordova run android
    

在运行此命令之前, 您需要设置的设备进行测试，之后会发生变化，为每个平台的程式。 在 Android 和亚马逊火 OS 设备，你将必须启用设备上的**USB 调试**的选项和或许添加 USB 驱动程式根据您发展导读工作。 每个平台的要求的详细资讯，请参阅平台指南。

## 添加外挂程式的功能

生成和查看一个新专案时，将显示预设的应用程式不会很多。 您可以修改该应用程式在许多方面，利用标准的 web 技术，但应用程式紧密的联系，与各种设备级功能，您需要添加外挂程式，提供对核心科尔多瓦 Api 的访问。

*外挂程式*是有点的载入项代码的提供的本机组件的介面。 您可以设计您自己的外挂程式介面，例如，设计一个混合应用程式，与本机组件混合科尔多瓦 web 视图时。 （请参阅嵌入 WebViews 和[外挂程式开发指南][6]的详细资讯。更常见的是，您将添加外挂程式，以便启用科尔多瓦的基本设备级功能详细的 API Reference 中之一。

 [6]: guide_hybrid_plugins_index.md.html#Plugin%20Development%20Guide

版本 3.0，当您创建一个专案，科尔多瓦它并没有存在任何外挂程式。这是新的缺省行为。你的愿望，甚至核心外挂程式，必须显式添加任何外挂程式。

这些外挂程式，包括由社会，提供额外的协力厂商外挂程式的清单可以在[plugins.cordova.io][7]在注册表中找到。 您可以使用 CLI 要搜索的从这个注册表外挂程式。 例如，搜索 `bar` 和 `code` 产生单个结果相匹配这两个术语作为子字串不区分大小写：

 [7]: http://plugins.cordova.io/

        $ cordova plugin search bar code
    
        com.phonegap.plugins.barcodescanner - Scans Barcodes
    

只有在寻找 `bar` 长期收益率和额外的结果：

        cordova-plugin-statusbar - Cordova StatusBar Plugin
    

`cordova plugin add`命令需要您指定的外挂程式代码的存储库。这里是你如何使用 CLI 来向应用程式添加功能的示例：

*   基本设备资讯 （设备 API）：
    
        $ cordova plugin add cordova-plugin-device
        

*   网路连接和电池事件：
    
        $ cordova plugin add cordova-plugin-network-information
        $ cordova plugin add cordova-plugin-battery-status
        

*   加速度计、 指南针、 和地理定位：
    
        $ cordova plugin add cordova-plugin-device-motion
        $ cordova plugin add cordova-plugin-device-orientation
        $ cordova plugin add cordova-plugin-geolocation
        

*   相机、 媒体重播和捕获：
    
        $ cordova plugin add cordova-plugin-camera
        $ cordova plugin add cordova-plugin-media-capture
        $ cordova plugin add cordova-plugin-media
        

*   访问设备或网路 （档 API） 上的档：
    
        $ cordova plugin add cordova-plugin-file
        $ cordova plugin add cordova-plugin-file-transfer
        

*   通过对话方块或振动发出通知：
    
        $ cordova plugin add cordova-plugin-dialogs
        $ cordova plugin add cordova-plugin-vibration
        

*   连络人：
    
        $ cordova plugin add cordova-plugin-contacts
        

*   全球化：
    
        $ cordova plugin add cordova-plugin-globalization
        

*   闪屏：
    
        $ cordova plugin add cordova-plugin-splashscreen
        

*   打开新的浏览器视窗 (InAppBrowser):
    
        $ cordova plugin add cordova-plugin-inappbrowser
        

*   调试主控台：
    
        $ cordova plugin add cordova-plugin-console
        

**注意**： CLI 将作为每个平台的相应添加外挂程式代码。 如果你想要发展与低级别外壳工具或平台 Sdk 作为概述中讨论，你需要运行 Plugman 实用程式来添加外挂程式单独为每个平台。 （有关详细资讯，见使用 Plugman 管理外挂程式）。

使用 `plugin ls` （或 `plugin list` ，或 `plugin` 本身） 查看当前已安装的外挂程式。每个显示的识别码：

        $ cordova plugin ls    # or 'plugin list'
        [ 'cordova-plugin-console' ]
    

若要删除一个外挂程式，它通过引用相同的识别码出现在清单中。例如，在这里是如何你会从一个发布版本中删除调试主控台的支援：

        $ cordova plugin rm cordova-plugin-console
        $ cordova plugin remove cordova-plugin-console    # same
    

你可以大量删除或添加的外挂程式通过指定多个参数的每个命令：

        $ cordova plugin add cordova-plugin-console cordova-plugin-device
    

## 高级的外挂程式选项

当添加外挂程式，几个选项允许您指定从何处获取该外挂程式。 上面的例子使用知名 `registry.cordova.io` 注册表和该外挂程式由指定 `id` :

        $ cordova plugin add cordova-plugin-console
    

`id`还可能包括外挂程式的版本号码后, 追加 `@` 字元。`latest`版本是最新版本的一个别名。例如：

        $ cordova plugin add cordova-plugin-console@latest
        $ cordova plugin add cordova-plugin-console@0.2.1
    

如果在没有注册该外挂程式 `registry.cordova.io` 位于另一个 git 仓库，但您可以指定一个备用的 URL：

        $ cordova plugin add https://github.com/apache/cordova-plugin-console.git
    

上面的 git 示例从主分支，末尾读取外挂程式但备用的 git ref，如一个标记或分支可以追加后 `#` 字元：

从标记安装:

        $ cordova plugin add https://github.com/apache/cordova-plugin-console.git#r0.2.0
    

或一个分支:

        $ cordova plugin add https://github.com/apache/cordova-plugin-console.git#CB-8438cordova-plugin-console
    

或 git ref 也可能是一个特定的提交:

        $ cordova plugin add https://github.com/apache/cordova-plugin-console.git#f055daec45575bf08538f885e09c85a0eba363ff
    

如果外挂程式 (和其`plugin.xml`档) 是在 git 存储库中的子目录中，您可以指定它与`:`字元。 `#`字元仍然需要注意:

        $ cordova plugin add https://github.com/someone/aplugin.git#:/my/sub/dir
    

您还可以将合并 git-ref 和子目录:

        $ cordova plugin add https://github.com/someone/aplugin.git#r0.0.1:/my/sub/dir
    

或者，指定包含`plugin.xml`档的外挂程式目录的本地路径:

        $ cordova plugin add ../my_plugin_dir
    

## 使用*合并*到自订的每个平台

而科尔多瓦允许您轻松地部署应用程式的许多不同的平台，有时你需要添加自订项。 在这种情况下，你不想修改原始档案中各种`www`目录内的顶级`平台`目录，因为他们定期更换顶级`www`目录跨平台源。

相反，顶级`merges`目录提供了一个地方来指定资产在特定平台上部署。 每个特定于平台的子目录内`merges`镜像`www`源树中，允许您重写或根据需要添加的档的目录结构。 例如，这里是你如何使用`合并`以提高安卓和亚马逊火 OS 设备的预设字型大小:

*   编辑 `www/index.html` 档，添加一个连结到一个额外的 CSS 档，该档 `overrides.css` 在这种情况下：
    
        <link rel="stylesheet" type="text/css" href="css/overrides.css" />
        

*   （可选） 创建一个空的 `www/css/overrides.css` 档，将适用于所有非 Android 生成，防止丢失档错误。

*   创建 `css` 中的子目录 `merges/android` ，然后添加相应的 `overrides.css` 档。 指定将覆盖 12 点预设的字体大小范围内指定的 CSS `www/css/index.css` ，例如：
    
        body { font-size:14px; }
        

当你重新生成专案时，Android 版本特点的自订字体大小，而其他人保持不变。

您也可以使用`merges`添加原始的`www`目录中不存在的档。 例如，一个应用程式可以将*后退按钮*的图形纳入 iOS 介面，存储在`merges/ios/img/back_button.png`，而 Android 版本相反可以捕获从对应的硬体按钮的`[backbutton](../../cordova/events/events.backbutton.html)`事件。

## 说明命令

科尔多瓦特点两三个全域命令，可以说明你，如果你被卡住或遇到的问题。 `help`命令显示所有可用的科尔多瓦命令和它们的语法:

    $ cordova help
    $ cordova        # same
    

此外，你可以在一个特定的命令更详细的说明。 例如:

    $ cordova run --help
    

`Info`命令产生的潜在的有用的详细资讯，如当前安装的平台和外挂程式，每个平台 SDK 版本的 CLI 和`node.js`版本的清单:

    $ cordova info
    

它提出了对萤幕资讯和捕获本地`info.txt`档中的输出。

**注**: 目前，只有细节在 iOS 和 Android 平台上的都可用。

## 更新科尔多瓦和您的专案

安装后的`cordova`实用程式，您可以始终进行更新到最新版本通过运行以下命令:

        $ sudo npm update -g cordova
    

使用此语法来安装特定的版本:

        $ sudo npm install -g cordova@3.1.0-0.2.0
    

运行`cordova -v`来查看当前正在运行哪个版本。 运行更长的清单，其中包括当前版本以及其他可用的版本编号为`npm info`命令:

        $ npm info cordova
    

科尔多瓦 3.0 是支援这一节中描述的命令列介面的第一个版本。 如果你从 3.0 以前的版本更新，您需要创建一个新专案，如上文所述，然后将旧应用程式资产复制到顶级`www`目录。 在适用的情况下，更多关于升级到 3.0 的详情，可用平台指南中。 一旦你升级到`科尔多瓦`命令列介面并使用`npm 更新`保持最新，更费时所述有程式不再相关。

科尔多瓦 3.0 + 可能仍然需要对专案级别的目录结构和其他依赖关系的各种变化。 你运行上面的`npm`命令，若要更新本身的科尔多瓦后，您可能需要确保您的专案资源符合最新的版本要求。 运行下面这样的命令为每个平台您正在构建:

        $ cordova platform update android
        $ cordova platform update ios
        ...etc.
