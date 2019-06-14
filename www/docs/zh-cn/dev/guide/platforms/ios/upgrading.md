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

title: 升级 iOS
---

# 升级 iOS

本指南演示如何修改 iOS 专案从Cordova的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 命令列介面资讯，请参阅如何更新的 CLI 版本。

**注**： Xcode 4.6 必需的推荐 Xcode 5。 目前，以提交到苹果 App Store，你应使用最新的产品出厂的版本的 iOS SDK，这是 iOS 7。 iOS 7 SDK 尚不需要，但这可能会很快改变。

## 升级 3.1.0 专案到 3.2.0

对于非 CLI 的专案，请运行：

        bin/更新路径/到专案
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

## 升级 3.0.0 专案到 3.1.0

对于非 CLI 的专案，请运行：

        bin/更新路径/到专案
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

iOS 7 的问题：

1.  删除 `width=device-width, height=device-height` 从 `index.html` 档的 `viewport` `meta` 标记。 （请参见[相关 bug][1].)

2.  更新你的 iOS 7 支援的媒体、 媒体捕获和闪屏核心外挂程式。

 [1]: https://issues.apache.org/jira/browse/CB-4323

Xcode 5 的问题：

1.  如果 Xcode 5 提示您这样做 （在问题导航器），请更新您的专案设置。

2.  更新您**编译器的 C / C + + / 目标 C**根据**生成设置**选项卡，设置**生成选项**一节。 选择**预设编译器 （苹果 LLVM 5.0）**.

## 从 2.9.0 升级到 CLI （3.0.0)

1.  创建新的 Apache Cordova 3.0.0 专案使用 CLI，Cordova，如所述的命令列介面。

2.  添加您的平台到Cordova专案中，例如：`cordova
platform add ios`.

3.  该专案的内容复写 `www` 目录到 `www` 目录在您刚刚创建的Cordova专案的根目录。

4.  复制或覆盖任何本机资产从原始专案 （ `Resources` 等），这让肯定要添加任何新档到 `.xcodeproj` 专案。 IOS 专案内生成 `platforms\ios` 目录。

5.  复制您 `config.xml` 到 `www` 目录中，并删除任何外挂程式定义。修改设置在这里而不是平台目录。

6.  使用Cordova CLI 工具来安装您需要的任何外挂程式。请注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

7.  生成并测试。

## 升级 2.9.0 专案到 3.0.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 3.0.0 源，例如到`~/Documents/Cordova-3.0.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova.js` （注意它再也没有一个版本尾码，该版本是在该档本身在标题中） 到新专案中的档您 `www` 目录中，并删除您 `www/cordova.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

**注意**： 从开始Cordova 3.0.0，不预先安装外挂程式，和你需要使用 `plugman` 命令列实用程式来安装它们自己。 请参阅使用 Plugman 管理外挂程式。

## 升级 2.8.0 专案到 2.9.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.9.0 源，例如到`~/Documents/Cordova-2.9.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova.js` （注意它再也没有一个版本尾码，该版本是在该档本身在标题中） 到新专案中的档您 `www` 目录中，并删除您 `www/cordova.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

## 升级 2.7.0 专案到 2.8.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.8.0 源，例如到`~/Documents/Cordova-2.8.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova.js` （注意它再也没有一个版本尾码，该版本是在该档本身在标题中） 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.7.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  更新任何 `<plugin>` 标签在 `config.xml` 档到 `<feature>` 标签。 注意，现有 `<plugin>` 标签仍正常工作，但都被否决了。 您可以复制此资讯在 `config.xml` 档的一个新的专案。 例如：
    
        <plugins>
            <plugin name="LocalStorage" value="CDVLocalStorage" />
            <!-- other plugins -->
        </plugins>
        
        <!-- change to: (note that a <feature> tag is on the same level as <plugins> -->
        <feature name="LocalStorage">
            <param name="ios-package" value="CDVLocalStorage" />
        </feature>
        <!-- other <feature> tags -->
        

8.  删除 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

9.  将这两个框架添加到您的专案：
    
        OpenAL ImageIO
        

10. 更新您的专案目标**生成设置**。编辑**"-Obj-C"**要下**连结 → 其他连结器标志**， **"-ObjC"**.

11. 更新您的专案目标**生成设置**。 在**连结 → 其他连结器标志**，更改**"-all_load"**是 `-force\_load ${BUILT\_PRODUCTS\_DIR}/libCordova.a` 。 你只需要这样做，如果你有在中定义的问题[这一问题。][2].

 [2]: https://issues.apache.org/jira/browse/CB-3458

## 升级 2.6.0 专案到 2.7.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.7.0 源，例如到`~/Documents/Cordova-2.7.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.7.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.6.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.7.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `AppDelegate.m` 档根据您从新专案 (见[此比较][3]).

8.  在您 `config.xml` 档，[删除这条线][4].

9.  删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

 [3]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=5c05ac80e056753c0e8736f887ba9f28d5b0774c;hp=623ad8ec3c46f656ea18c6c3a190d650dd64e479;hb=c6e71147386d4ad94b07428952d1aae0a9cbf3f5;hpb=c017fda8af00375a453cf27cfc488647972e9a23
 [4]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=537705d76a5ef6bc5e57a8ebfcab78c02bb4110b;hp=8889726d9a8f8c530fe1371c56d858c34552992a;hb=064239b7b5fa9a867144cf1ee8b2fb798ce1f988;hpb=c9f233250d4b800f3412eeded811daaafb17b2cc

## 升级 2.5.0 专案到 2.6.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.6.0 源，例如到`~/Documents/Cordova-2.6.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制专案的 `www/cordova-2.6.0.js` 档到您 `www` 目录中，并删除您 `www/cordova-2.5.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及引用的脚本的任何其他档） 来引用到新的 `cordova-2.6.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `AppDelegate.m` 档根据您从新专案 (见[此比较][5]).

8.  在您 `config.xml` 档，[添加此新行][6].

9.  在您 `config.xml` 档，[添加此新行][7].

10. 在您 `config.xml` 档， [UIWebViewBounce 已改为 DisallowOverscroll，和预设值都不同][8].

11. 在您 `config.xml` 档， `EnableLocation` 首选项已被否决。

12. 删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

 [5]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=124a56bb4f361e95616f44d6d6f5a96ffa439b60;hp=318f79326176be8f16ebc93bad85dd745f4205b6;hb=a28c7712810a63396e9f32fa4eb94fe3f8b93985;hpb=36acdf55e4cab52802d73764c8a4b5b42cf18ef9
 [6]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=1555b5e81de326a07efe0bccaa5f5e2326b07a9a;hp=0652d60f8d35ac13c825c572dca6ed01fea4a540;hb=95f16a6dc252db0299b8e2bb53797995b1e39aa1;hpb=a2de90b8f5f5f68bd9520bcbbb9afa3ac409b96d
 [7]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=d307827b7e67301171a913417fb10003d43ce39d;hp=04260aa9786d6d74ab20a07c86d7e8b34e31968c;hb=97b89edfae3527828c0ca6bb2f6d58d9ded95188;hpb=942d33c8e7174a5766029ea1232ba2e0df745c3f
 [8]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=8889726d9a8f8c530fe1371c56d858c34552992a;hp=d307827b7e67301171a913417fb10003d43ce39d;hb=57982de638a4dce6ae130a26662591741b065f00;hpb=ec411f18309d577b4debefd9a2f085ba719701d5

## 升级 2.4.0 专案到 2.5.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.5.0 源，例如到`~/Documents/Cordova-2.5.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.5.0.js` 到新专案中的档您 `www` 目录并删除您 `www/cordova-2.4.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.5.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `AppDelegate.m` 档根据您从新专案 (见[此比较][9]).

8.  在您 `config.xml` 档，[添加这些新行][10].

9.  在您 `config.xml` 档，[编辑的根项目，更改它从Cordova到构件][11].

10. 在您 `config.xml` 档，[删除 OpenAllWhitelistURLsInWebView 首选项][12].

11. 删除您 `cordova` 目录和副本 `cordova` 目录从新专案到专案的根目录。在 2.5.0，这已更新脚本。

12. 删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

 [9]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=318f79326176be8f16ebc93bad85dd745f4205b6;hp=6dc7bfc84f0ecede4cc43d2a3256ef7c5383b9fe;hb=4001ae13fcb1fcbe73168327630fbc0ce44703d0;hpb=299a324e8c30065fc4511c1fe59c6515d4842f09
 [10]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=903944c4b1e58575295c820e154be2f5f09e6314;hp=721c734120b13004a4a543ee25f4287e541f34be;hb=ae467249b4a256bd31ee89aea7a06f4f2316b8ac;hpb=9e39f7ef8096fb15b38121ab0e245a3a958d9cbb
 [11]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=64e71636f5dd79fa0978a97b9ff5aa3860a493f5;hp=d8579352dfb21c14e5748e09b2cf3f4396450163;hb=0e711f8d09377a7ac10ff6be4ec17d22cdbee88d;hpb=57c3c082ed9be41c0588d0d63a1d2bfcd2ed878c
 [12]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=721c734120b13004a4a543ee25f4287e541f34be;hp=7d67508b70914aa921a16e79f79c00512502a8b6;hb=187bf21b308551bfb4b98b1a5e11edf04f699791;hpb=03b8854bdf039bcefbe0212db937abd81ac675e4

## 升级 2.3.0 专案到 2.4.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.4.0 源，例如到`~/Documents/Cordova-2.4.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.4.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.3.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.4.0.js` 档。

7.  更新 （或替换，如果您从未更改档） 您 `MainViewController.m` 档根据您从新专案 (见[此比较][13]).

8.  更新 （或如果您从未更改该档替换） 您 `AppDelegate.m` 档根据您从新专案 (见[此比较][14]).

9.  在您 `config.xml` 档，[添加此新行][15].

10. 删除您 `cordova` 目录和副本 `cordova` 目录从新专案到专案的根目录。在 2.4.0，这已固定的脚本。

11. 删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

12. AssetsLibrary.framework 作为资源添加到专案中。 （参见[苹果的文档][16]有关如何执行此操作的说明.）。

 [13]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/MainViewController.m;h=5f9eeac15c2437cd02a6eb5835b48374e9b94100;hp=89da1082d06ba5e5d0dffc5b2e75a3a06d5c2aa6;hb=b4a2e4ae0445ba7aec788090dce9b822d67edfd8;hpb=a484850f4610e73c7b20cd429a7794ba829ec997
 [14]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=6dc7bfc84f0ecede4cc43d2a3256ef7c5383b9fe;hp=1ca3dafeb354c4442b7e149da4f281675aa6b740;hb=6749c17640c5fed8a7d3a0b9cca204b89a855baa;hpb=deabeeb6fcb35bac9360b053c8bf902b45e6de4d
 [15]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=7d67508b70914aa921a16e79f79c00512502a8b6;hp=337d38da6f40c7432b0bce05aa3281d797eec40a;hb=6749c17640c5fed8a7d3a0b9cca204b89a855baa;hpb=deabeeb6fcb35bac9360b053c8bf902b45e6de4d
 [16]: https://developer.apple.com/library/ios/#recipes/xcode_help-project_editor/Articles/AddingaLibrarytoaTarget.html

## 升级 2.2.0 专案到 2.3.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.3.0 源，例如到`~/Documents/Cordova-2.3.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.3.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.2.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.3.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `MainViewController.m` 根据新专案中的一个。

8.  删除您 `cordova` 目录和副本 `cordova` 目录从新专案到专案的根目录。2.3.0，在这新的脚本。

9.  删除您 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

10. 转换您 `Cordova.plist` 档为 `config.xml` ，通过运行脚本 `bin/cordova\_plist\_to\_config\_xml` 对您的专案档案。

11. 添加到 InAppBrowser 外挂程式你 `config.xml` ，通过添加此标记下的 `<cordova><plugins>` ：
    
        < 外挂程式名称 = 值"InAppBrowser"="CDVInAppBrowser"/ >
        

12. 请注意目标 C 外挂程式*不*列入白名单了。 到白名单中您的连接与应用程式白名单中，您需要设置 `User-Agent` 连接到同一个使用者代理作为主要的Cordova web 视图的标题。 你可以通过访问 `userAgent` 关闭主视图-控制器属性。 主视图-控制器 ( `CDVViewController` ) 也有 `URLisAllowed` 为您检查是否一个 URL 通过白名单中的方法。

13. 设备的 API 更改：
    
    *   Ios，device.platform 用于返回 `iPhone` ， `iPad` 或 `iPod Touch` ； 现在它返回 （正确）`iOS`.
    *   对于 iOS，device.name (现已被否决所有平台) 用于返回使用者的设备的名称 （例如 Shazron 的 iPhone 5 ′) ；现在它返回用于返回什么 device.platform： `iPhone` ， `iPad` 或`iPod Touch`.
    *   对于所有平台，有一个名为 device.model ； 的新属性这将返回特定的设备模型，例如： `iPad2,5` （对于其他平台，返回用于返回什么 device.name）。

## 升级 2.1.0 专案到 2.2.0

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.2.0 源，例如到`~/Documents/Cordova-2.2.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.2.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.1.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.2.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `MainViewController.m` 根据新专案中的一个：
    
    *   更新 → viewWillAppear

8.  复制 `cordova` 目录从新专案到专案的根目录。在 2.2.0，这有更新的 '模仿' 脚本。

9.  下一步，更新您 `CordovaLib` 分专案的引用。 从Cordova 2.1.0 开始，我们 CORDOVALIB Xcode 变数不再使用引用的位置时 `CordovaLib` 驻留，引用现在是绝对档引用。
    
    1.  启动终端程式
    2.  转到您安装Cordova的位置 （请参见步骤 1）、 在 `bin` 子目录
    3.  运行下面的脚本，其中第一个参数是您的专案的路径 `.xcodeproj` 档：
        
        `update_cordova_subproject path/to/your/project/xcodeproj`

**注**： 在 2.2.0， `bin/create` 脚本中的副本 `CordovaLib` 分专案到您的专案。 要有相同种类的安装程式，只是复制权在 `CordovaLib` 到你的专案目录和更新 `CordovaLib` 分专案 （相对于专案) 在 Xcode 档检查器中的位置。

## 升级 2.0.0 专案到 2.1.0

与Cordova 2.1.0， `CordovaLib` 已升级为使用**自动引用计数 (弧)**。 你不需要升级到**弧**要使用 CordovaLib，但是如果你想要升级您的专案使用**弧**，请使用 Xcode 迁移向导从功能表中：**编辑 → 重构 → 转换为目标 C 弧...**，取消选择 libCordova.a，然后运行向导完成。

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的Cordova 2.1.0 源，例如到`~/Documents/Cordova-2.1.0`.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova-2.1.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-2.0.0.js` 档。

6.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.1.0.js` 档。

7.  更新 （或如果您从未更改该档替换） 您 `AppDelegate.m` 根据新专案中的一个：
    
    *   编辑 → 应用程式： didFinishLaunchingWithOptions：
    *   添加 → 应用程式： supportedInterfaceOrientationsForWindow：

8.  更新 （或如果您从未更改该档替换） 您 `MainViewController.m` 根据新专案中的一个：
    
    *   添加 → viewWillAppear

9.  复制 `cordova` 目录从新专案到专案的根目录。在 2.1.0，这有更新的脚本，支援带空格的路径。

10. 删除 `VERSION` 档从您的专案参考 （**是在`CordovaLib`).

11. 下一步，更新您 `CordovaLib` 分专案的引用。 从Cordova 2.1.0 开始，我们 CORDOVALIB Xcode 变数不再使用引用的位置时 `CordovaLib` 驻留，引用现在是绝对档引用。
    
    1.  启动终端程式
    2.  转到您安装Cordova的位置 （请参见步骤 1）、 在 `bin` 子目录
    3.  运行下面的脚本，其中第一个参数是您的专案的路径 `.xcodeproj` 档：
        
        `update_cordova_subproject 路径/为/您/专案/xcodeproj`

## 升级 1.9.0 专案到 2.0.0

1.  安装 2.0.0 Cordova。

2.  创建一个新专案，如 iOS 命令列工具中所述。您需要从这个新的专案资产。

3.  复制 `www/cordova-2.0.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-1.9.0.js` 档。

4.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-2.0.0.js` 档。

5.  复制 `cordova` 目录从新专案到专案的根目录 （如果你想要的专案的命令列工具)。

6.  添加一个新条目下的 `Plugins` 在你 `Cordova.plist` 下**支援档**组的档。 关键是 `Device` 和值是`CDVDevice`.

7.  删除`Cordova.framework`.

8.  删除 `verify.sh` 从**支援档**组。

9.  在专案导航器中选择专案图示，选择您的专案**目标**，然后选择**生成设置**选项卡。

10. 搜索**预处理器宏**，然后删除所有**CORDOVA_FRAMEWORK = 1**值。

11. 找到 `CordovaLib` 安装在您的硬碟-上根据您的个人资料夹中的目录 `Documents` 子目录。

12. 找到 `CordovaLib.xcodeproj` 档在 `CordovaLib` 目录中，然后拖放到您的专案档案。它应显示作为子专案。

13. 构建您的专案，你应该与有关的一些错误 `#import` 指令。

14. 为 `#import` 的错误，改变这种风格在任何基于报价进口：
    
        #import "CDV.h"
        
    
    为此基于方括弧中的样式：
    
        #import <Cordova/CDV.h>
        
    
    和删除任何 `#ifdef` 任何Cordova的包装进口，他们再也不需要 （现在统一进口)

15. 再次，生成您的专案和它不应具有任何 `#import` 的错误。

16. 在专案导航器中选择**专案图示**，选择您的专案**目标**，然后选择**生成阶段**选项卡。

17. 展开**目标依赖项**阶段，然后选择**+**按钮。

18. 选择 `CordovaLib` 的目标，然后选择**添加**按钮。

19. 展开**连结二进位与图书馆**的第一阶段，（它应该已经包含框架的一群），然后选择**+**按钮。

20. 选择 `libCordova.a` 静态程式库，然后选择**添加**按钮。

21. 删除**运行脚本**阶段。

22. 在专案导航器中选择**专案图示**，选择您的专案**目标**，然后选择**生成设置**选项卡。

23. 搜索**其他的连结器标志**，并添加相应的值**-force_load**和**-Obj C**.

24. 扩大 `CordovaLib` 子专案。

25. 找到 `VERSION` 档，将它拖动到您 （我们想要创建一个连结到它，不是副本） 的主专案。

26. 选择**创建组的任何添加的资料夹**选项按钮，然后选择**完成**按钮。

27. 选择 `VERSION` 档，你只是被拖上一步中。

28. 键入**选项-命令-1**键的组合，以显示**档检查器**(或功能表项目**查看 → 实用程式 → 显示档检查器**).

29. 选择**相对于 CORDOVALIB** **档检查器**器下拉式功能表中的**位置**.

30. 设置为**独特**，这样才可以找到统一标头的 Xcode 偏好**Xcode 首选项 → 位置 → 派生资料 → 先进的......** 。

31. 在专案导航器中选择**专案图示**，选择你的**目标**，然后选择**生成设置**选项卡。

32. 搜索**标题搜索路径**。该设置将追加这三个值，包括引号：
    
        "$(TARGET_BUILD_DIR)/usr/local/lib/include"
        
        "$(OBJROOT)/UninstalledProducts/include"
        
        "$(BUILT_PRODUCTS_DIR)"
        

33. 搜索**其他连结器标志**。该设置将追加此值：
    
        -weak_framework CoreFoundation
        

34. 生成您的专案，它应编译和连结**没有**问题.

35. 从该**计划**下拉箭头，选择您的专案，然后选择**iPhone 5.1 模拟器**.

36. 选择**运行**按钮。

**注**： 如果您的专案不预期正常工作在模拟器中，请注意任何错误的主控台日志中 Xcode 的线索。

## 1.8.X 专案升级到 1.9.0

1.  安装包 1.9.0 Cordova。

2.  创建一个新专案。您将需要的一些资产从这个新的专案。

3.  复制 `www/cordova-1.9.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-1.8.x.js` 档。

4.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-1.9.0.js` 档。

**注**： 1.9.0 支援新 `BackupWebStorage` 布林 `Cordova.plist` 设置。 它预设启用的那么将其设置为 `false` ，禁用它，尤其是在 iOS 6 上。 请参阅[版本资讯： 野生动物园和 UIKit 科][17]

 [17]: https://developer.apple.com/library/prerelease/ios/#releasenotes/General/RN-iOSSDK-6_0/_index.html

## 升级 1.7.0 专案到 1.8.x

1.  安装 1.8.0 Cordova。

2.  创建一个新专案。您将需要的一些资产从这个新的专案。

3.  复制 `www/cordova-1.8.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-1.7.x.js` 档。

4.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-1.8.0.js` 档。

如果您打算使用捕获 API，您将需要在新的**iPad 视网膜显示**资产：

1.  复制 `Resources/Capture.bundle` 从新专案到专案目录中，覆盖您现有的专案 `Resources/Capture.bundle` 专案。

2.  在您的专案中选择 `Capture.bundle` 专案到您的专案在 Xcode 中导航，键入**Delete**键，然后从出现的对话方块中选择**移除引用**。

3.  拖动新 `Capture.bundle` 从步骤 1 以上到您专案中 Xcode 导航器，然后选择**创建组的任何添加的资料夹**选项按钮。

## 升级到 1.7.0 的 1.6.x 专案

1.  安装Cordova 1.7.0。

2.  创建一个新专案。您将需要的一些资产从这个新的专案。

3.  复制 `www/cordova-1.7.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-1.6.0.js` 档。

4.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-1.7.0.js` 档。

## 升级 1.5.0 专案到 1.6.x

1.  安装 1.6.1 Cordova。

2.  创建的备份， `AppDelegate.m` ， `AppDelegate.h` ， `MainViewController.m` ， `MainViewController.h` ，和 `Cordova.plist` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 1.5.0-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        Cordova.plist
        

5.  添加所有新的 `MainViewController` 和 `AppDelegate` 档，放入您的 Xcode 专案。

6.  复制 `www/cordova-1.6.1.js` 到新专案中的档您 `www` 目录中，并删除您 `www/cordova-1.5.0.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova-1.6.1.js` 档。

8.  添加新的 `Cordova.plist` 档到您的专案。 这是必要的因为核心外挂程式服务名称必须更改以匹配为一个统一的Cordova JavaScript 档 (从 Android 和黑莓，部分`cordova-js`).

9.  集成任何设置，你在你的**备份 Cordova.plist**成新的**外挂程式**和**ExternalHosts**条目`Cordova.plist`.

10. 集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新 `AppDelegate` 档。 任何 `UIWebViewDelegate` 或 `CDVCommandDelegate` 中的代码 `AppDelegate.m` 需要去到 `MainViewController.m` 现在 （见该档中的注释掉节）。

11. 集成任何您已在您的备份中的具体专案代码 `MainViewController.h` 和 `MainViewController.m` 成新的 MainViewController 档。

12. 在专案导航器中的专案图示上按一下，选择您的**专案**，然后选择**生成设置**选项卡。

13. 输入**编译器的 C / C + + / 目标 C**在搜索栏位中。

14. 选择**苹果 LLVM 编译器 3.1**的值。

## 升级到 1.5.0 版的 1.4.x 专案

1.  安装Cordova 1.5.0 版。

2.  创建一个新的专案并运行一次。您将需要的一些资产从这个新的专案。

3.  复制 `www/cordova-1.5.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-1.4.x.js` 档。

4.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新的Cordova `cordova-1.5.0.js` 档。

5.  找到 `PhoneGap.framework` 在你专案导航器中选择它。

6.  键入**Delete**键，删除 `PhoneGap.framework` 专案导航器中的引用。

7.  键入**选项-命令-A**复合键，应下拉表将档添加到您的专案 （**添加档...**表）。 请确保选中**创建组的任何添加的资料夹**选项按钮。

8.  键入的**Shift-命令-G**键组合，应下拉你去到一个资料夹中的另一个工作表 （**转到资料夹：**表）。

9.  输入 `/Users/Shared/Cordova/Frameworks/Cordova.framework` 在**转到资料夹：**工作表，然后按**继续**按钮。

10. 在工作表中**添加的档......** ，请按**添加**按钮。

11. 选择 `Cordova.framework` 专案导航器中。

12. 键入**选项-命令-1**键的组合，以显示**档检查器**.

13. **绝对路径**在**档检查器**的下拉式功能表中选择的**位置**.

14. 键入**选项-命令-A**复合键，应下拉表将档添加到您的专案 （**添加档...**表）。 请确保选中**创建组的任何添加的资料夹**选项按钮。

15. 键入的**Shift-命令-G**键组合，应下拉你去到一个资料夹中的另一个工作表 （**转到资料夹：**表）。

16. 输入 `~/Documents/CordovaLib/Classes/deprecated` 在**转到资料夹：**工作表，然后按**继续**按钮。

17. 在工作表中**添加的档......** ，请按**添加**按钮。

18. 在你 `AppDelegate.h` ， `AppDelegate.m` ，和 `MainViewController.h` 档，替换整个 `#ifdef PHONEGAP_FRAMEWORK` 与块：
    
        #import"CDVDeprecated.h"
        

19. 按一下专案导航器中的**专案图示**，选择你的**目标**，然后选择**生成设置**选项卡。

20. **框架搜索路径**搜索.

21. 替换现有值与`/Users/Shared/Cordova/Frameworks`.

22. 搜索**预处理器宏**.

23. 对于第一次 （组合） 值，替换的值与**CORDOVA_FRAMEWORK = YES**.

24. 选择**生成阶段**选项卡。

25. 扩大**运行脚本**.

26. 与**Cordova**的**PhoneGap**任何替换.

27. 找到您 `PhoneGap.plist` 档在专案导航器，并按一下档案名一旦输入名称编辑模式。

28. 重命名 `PhoneGap.plist` 到`Cordova.plist`.

29. 用滑鼠右键按一下 `Cordova.plist` ，然后选择**→ 作为开放源码的代码**.

30. 按**选项-命令-F**，选择**替换**从下拉在上面留下的源视窗。

31. 输入 `com.phonegap` 查找字串，和 `org.apache.cordova` 的替换字串，然后按**全部替换**按钮。

32. 查找字串和**CDV**的**PG**输入替换字串，然后按**全部替换**按钮。

33. 按**命令-B**生成。 你仍然有你可以摆脱在将来的瞧不起 （请参阅 `CDVDeprecated.h` 。 例如，替换在您的代码中使用的类，PG * CDV *）。

## 升级 1.4.0 1.4.1 向专案

1.  安装 1.4.1 Cordova。

2.  制作一个备份`MainViewController.m`.

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  复制 `MainViewController.m` 到 1.4.0-based 专案目录中的新专案从磁片上的档，替换旧档 （备份您的档第一次从上面的步骤 2）。

5.  添加 `MainViewController.m` 到 Xcode 专案档案。

6.  将任何您已在您的备份中的具体专案代码集成 `MainViewController.m` 成新的档。

7.  更新 `phonegap-1.4.0.js` 档是可选的 JavaScript 1.4.0 和 1.4.1 之间上没有任何改变。

## 升级 1.3.0 专案到 1.4.0

1.  安装 1.4.0 Cordova。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 1.3.0-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h AppDelegate.m MainViewController.h MainViewController.m MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  复制 `www/phonegap-1.4.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-1.3.0.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `phonegap-1.4.0.js` 档。

8.  添加一个新条目下的 `Plugins` 在你 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 1.2.0 专案到 1.3.0

1.  安装 1.3.0 Cordova。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 1.2.0-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h AppDelegate.m MainViewController.h MainViewController.m MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  复制 `www/phonegap-1.3.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-1.2.0.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `phonegap-1.3.0.js` 档。

8.  添加一个新条目下的 `Plugins` 在你 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 1.1.0 专案到 1.2.0

1.  安装Cordova 1.2.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 1.1.0-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h AppDelegate.m MainViewController.h MainViewController.m MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  复制 `www/phonegap-1.2.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-1.1.0.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `phonegap-1.2.0.js` 档。

8.  添加一个新条目下的 `Plugins` 在你 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 1.0.0 专案到 1.1.0

1.  安装Cordova 1.1.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 1.0.0-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h AppDelegate.m MainViewController.h MainViewController.m MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  复制 `www/phonegap-1.1.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-1.0.0.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `phonegap-1.1.0.js` 档。

8.  添加一个新条目下的 `Plugins` 在你 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 0.9.6 专案到 1.0.0

1.  安装Cordova 1.0.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您的 0.9.6-based 专案目录在磁片上，取代任何旧的档 （备份您的档首次从上述步骤 2）：
    
        AppDelegate.h AppDelegate.m MainViewController.h MainViewController.m MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  复制 `www/phonegap-1.0.0.js` 到新专案中的档您 `www` 目录中，并删除您 `www/phonegap-0.9.6.js` 档。

7.  更新中的Cordova脚本引用您 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `phonegap-1.0.0.js` 档。

8.  添加一个新条目下的 `Plugins` 在你 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。