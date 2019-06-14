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

title: iOS 平台指南
toc_title: iOS
---

# iOS 平台指南

本指南介绍如何设置您的 SDK 开发环境部署科尔多瓦的 iOS 设备 （如 iPhone 和 iPad 的应用程式。请参阅下列特定于平台的详细资讯：

*   [iOS 配置](config.html)
*   [升级 iOS](upgrading.html)
*   [WebViews iOS](webview.html)
*   [iOS 外挂程式](plugin.html)
*   [iOS 壳工具指南](tools.html)

上面的命令列工具请参阅科尔多瓦 3.0 以前的版本。关于当前介面的资讯，请参阅命令列介面。

## 要求和支援

苹果公司 ® 生成仅在基于英特尔的 Mac OS X 作业系统上运行的 iOS 应用程式所需的工具。 仅在 OS X 版本 10.9 （小牛） 上运行 Xcode ® 6.0 （所需的最低版本） 或更高版本，并包含 iOS 8 SDK （软体发展工具组）。 要提交到苹果 App Store℠ 的应用程式需要的苹果工具的最新版本。

您可以测试的许多科尔多瓦功能使用 iOS 模拟器安装 ios SDK 和 Xcode，但你需要使用实际的设备完全提交到 App Store 之前测试的所有应用程式的装置功能。 该设备必须至少有 iOS 装有 6.x、 到科尔多瓦 3.0 支援的最低的 iOS 版本。配套设备包括所有 iPad ® 模型、 iPhone ® 3GS 以上，和 iPod ® 触摸第三代或更高版本。 要安装到设备上的应用程式，您必须也是苹果公司的[iOS 开发者计划][1]，该费用每 99 年美元的成员。 本指南演示如何将应用程式部署到 iOS 模拟器，不必注册开发者计画。

 [1]: https://developer.apple.com/programs/ios/

[Ios sim 卡][2]和[ios-deploy][3]工具允许您启动到 iOS 模拟器的 iOS 应用程式并从命令列的 iOS 设备。

 [2]: https://www.npmjs.org/package/ios-sim
 [3]: https://www.npmjs.org/package/ios-deploy

## 安装 SDK

有两种方式下载 Xcode：

*   从[应用程式商店][4]，可通过搜索"Xcode"在**App Store**中的应用。

*   从[苹果开发者下载][5]，而作为苹果开发者需要注册。

 [4]: https://itunes.apple.com/us/app/xcode/id497799835?mt=12
 [5]: https://developer.apple.com/downloads/index.action

一旦安装了 Xcode，几个命令列工具需要为科尔多瓦运行启用。 从**Xcode**功能表中，选择**首选项**，然后**下载**选项卡。 从**元件**面板中，按**命令列工具**清单旁边的**安装**按钮。

## 安装部署工具

从普通型线路终端上运行：

        $ npm install -g ios-sim
        $ npm install -g ios-deploy
    

## 创建一个新的专案

使用`科尔多瓦`实用程式设置了一个新的专案，如所述在科尔多瓦的命令列介面。例如，在一个原始程式码目录：

        $ cordova create hello com.example.hello "HelloWorld"
        $ cd hello
        $ cordova platform add ios
        $ cordova prepare              # or "cordova build"
    

## 部署应用程式

要部署的应用程式连接的 iOS 设备上：

        $ cordova run ios --device
    

部署预设 iOS 模拟器上的应用程式：

        $ cordova emulate ios
    

您可以使用**cordova run ios --list**看到所有可用的目标和**cordova run ios --target=target_name**在一个特定的设备或模拟器上运行应用程式 （例如，`cordova run ios --target="iPhone-6"`).

您还可以使用**科尔多瓦运行 — — 说明**查看附加的生成和运行选项。

## 在 SDK 中打开专案

一旦 ios 平台添加到专案中，您可以打开它从内 Xcode。按两下以打开`hello/platforms/ios/hello.xcodeproj`档。萤幕应该如下所示：

![][6]

 [6]: {{ site.baseurl }}/static/img/guide/platforms/ios/helloworld_project.png

## 部署到模拟程式

若要预览在 iOS 模拟器中的应用程式：

1.  请确保在左边的面板中选择*.xcodeproj*档。

2.  选择**你好**app 立即向右面板中。

3.  从工具列上的**计划**功能表中选择预定的设备、 iPhone 等作为 6.0 模拟器在这里突出了：
    
    ![][7]

4.  按下**运行**按钮出现在同一工具列左侧的**计划**中。 那生成、 部署并在模拟器中运行应用程式。 一个单独的模拟器应用程式将打开，并显示该应用程式：
    
    ![][8]
    
    只有一个模拟程式可能会运行一次，所以如果你想要在不同的模拟器中测试应用程式，您需要退出的模拟程式应用程式和运行一个不同的目标在 Xcode 的范围内。

 [7]: {{ site.baseurl }}/static/img/guide/platforms/ios/select_xcode_scheme.png
 [8]: {{ site.baseurl }}/static/img/guide/platforms/ios/HelloWorldStandard.png

Xcode 捆绑与最新版本的 iPhone 和 iPad 的模拟器。 旧版本也许可以从**Xcode → 首选项 → 下载 → 元件**面板。

## 将部署到设备

关于各项要求部署到一个设备的详细资讯，请参阅苹果公司[关于应用程式分配工作流][9]的*启动您的应用程式对设备*部分。 简单地说，您需要部署之前执行以下操作：

 [9]: https://developer.apple.com/library/prerelease/ios/documentation/IDEs/Conceptual/AppDistributionGuide/Introduction/Introduction.html

1.  加入苹果 iOS 开发者计划。

2.  创建*资源调配设定档*内[iOS 资源调配门户][10]。 您可以使用其*发展资源调配助理*来创建和安装设定档和证书 Xcode 需要。

3.  验证*代码签名*部分*代码签名标识*内的专案设置设置为您设置的设定档名称。

 [10]: https://developer.apple.com/ios/manage/overview/index.action

要部署到设备：

1.  使用 USB 电缆将设备插入到您的 mac。

2.  Xcode 视窗**计划**下拉清单中选择的专案的名称。

3.  从**设备**下拉清单中选择您的设备。如果它通过 USB 连接电源，但仍然没有出现，请按**管理器**按钮，以解决任何错误。

4.  按下**运行**按钮以生成、 部署并运行该应用程式在您的设备上。

## 常见的问题

**否决警告**： 当应用程式更改或替换为另一个 API 程式设计介面 (API) 时，它被标记为*已弃用*。 该 API 仍可工作在短期内，但最终将被删除。 一些这些过时的介面，反映在 Apache 科尔多瓦和 Xcode 问题关于他们的警告，当您生成和部署应用程式。

`InvokeString`方法 Xcode 的警告有关启动一个应用程式从一个自订的 URL 的功能。 虽然从一个自订的 URL 载入的机制发生了改变，此代码是仍然存在，以便为科尔多瓦的较早版本创建的应用程式提供向后的功能。 应用程式范例不使用此功能，因此可以忽略这些警告。 若要防止出现这些警告，请移除引用已弃用的 invokeString API 的代码：

*   编辑*Classes/MainViewController.m*档、 环绕的代码与下面的块 `/*` 和 `*/` 的评论如下所示，然后键入**命令-s**保存该档：
    
        (void)webViewDidFinishLoad:(UIWebView*)theWebView
        {
        // only valid if ___PROJECTNAME__-Info.plist specifies a protocol to handle
        /*
        if (self.invokeString) {
          // this is passed before the deviceready event is fired, so you can access it in js when you receive deviceready
          NSLog(@"DEPRECATED: window.invokeString - use the window.handleOpenURL(url) function instead, which is always called when the app is launched through a custom scheme url.");
          NSString* jsString = [NSString stringWithFormat:@"var invokeString = \"%@\";", self.invokeString];
          [theWebView stringByEvaluatingJavaScriptFromString:jsString];
        }
        */
        // Black base color for background matches the native apps
        theWebView.backgroundColor = [UIColor blackColor];
        
        return [super webViewDidFinishLoad:theWebView];
        }
        

*   编辑*Classes/AppViewDelegate.m*档，注释掉下面的行插入双斜杠，如下所示，然后键入**命令-s**保存该档：
    
        //self.viewController.invokeString = invokeString;
        

*   按**命令-b**重新生成专案并消除此警告。

<!-- Does this fix only last until the next "cordova prepare"? -->

**缺少标题**： 有关失踪的标头的编译错误导致从生成位置的问题，可以通过 Xcode 偏好固定：

1.  选择**Xcode → 首选项 → 位置**.

2.  在**派生的资料**部分中，按**高级**按钮并选择**唯一**作为**生成位置**如下所示：
    
    ![][11]

 [11]: {{ site.baseurl }}/static/img/guide/platforms/ios/xcode_build_location.png

这是一个新的 Xcode 安装的预设设置，但可以设置不同的升级之后从 Xcode 旧版本。

进一步的资讯，请参阅苹果的文档：

*   [开始开发 iOS 应用程式今天][12]快速概述的步骤开发 iOS 的应用程式。

*   [会员中心主页][13]提供几个 iOS 的连结技术资源包括技术资源，资源调配门户、 分布指南和社区论坛。

*   [IOS 工具工作流指南][14]

*   [Xcode 使用者指南][15]

*   从苹果世界广泛开发人员会议 (WWDC2012) 2012年[届会议视频][16]

*   安装[xcode 选择命令][17]，它有助于指定正确版本的 Xcode，如果不止一个的话。

 [12]: http://developer.apple.com/library/ios/#referencelibrary/GettingStarted/RoadMapiOS/index.html#//apple_ref/doc/uid/TP40011343
 [13]: https://developer.apple.com/membercenter/index.action
 [14]: http://developer.apple.com/library/ios/#documentation/Xcode/Conceptual/ios_development_workflow/00-About_the_iOS_Application_Development_Workflow/introduction.html#//apple_ref/doc/uid/TP40007959
 [15]: http://developer.apple.com/library/ios/#documentation/ToolsLanguages/Conceptual/Xcode4UserGuide/000-About_Xcode/about.html#//apple_ref/doc/uid/TP40010215
 [16]: https://developer.apple.com/videos/wwdc/2012/
 [17]: http://developer.apple.com/library/mac/#documentation/Darwin/Reference/ManPages/man1/xcode-select.1.html

（Mac ® OS X ® Xcode ® 苹果 ® 的应用程式进行，iPad ®，iPhone ®，iPod ® Finder ®，苹果公司商标)
