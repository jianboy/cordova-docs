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

本指南演示如何修改 iOS 专案从科尔多瓦的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 资讯，请参阅命令列介面如何更新的 CLI 版本。

**注**： Xcode 6 是必需。 目前，若要提交到苹果应用程式商店，您应该使用 iOS SDK，是 iOS 8 最新的发布的版本，这是只包括在 Xcode 6。

## 4.0.0 3.6.0 版升级专案

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  在你现有的专案中运行 `cordova platform update ios`。

## 升级 3.3.0 专案 3.4.0

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

## 升级 3.2.0 专案到 3.3.0

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

## 升级 3.1.0 专案到 3.2.0

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

## 升级 3.0.0 专案到 3.1.0

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update ios`

iOS 7 的问题：

1.  删除 `width=device-width、height=device-height` 从 `index.html` 档 `viewport meta` 标记。 （请参见 [相关的 bug][1].)

2.  更新您媒体、 媒体捕获和闪屏的核心外挂程式 iOS 7 的支援。

 [1]: https://issues.apache.org/jira/browse/CB-4323

Xcode 5 的问题：

1.  如果 Xcode 5 提示您这样做 （在问题导航），请更新您的专案设置。

2.  更新您 **编译器的 C / C + + 目标 C** 下 **生成设置** 选项卡，设置 **生成选项** 一节。 选择 **预设编译器 （苹果 LLVM 5.0）**.

## 从 2.9.0 升级到 CLI （3.0.0)

1.  创建一个新的 Apache 科尔多瓦 3.0.0 专案使用 CLI，科尔多瓦，所述的命令列介面。

2.  添加您的平台的科尔多瓦的专案，例如： `cordova platform add ios`.

3.  该专案的内容复写 `www` 目录到 `www` 目录在您刚刚创建的科尔多瓦专案的根目录。

4.  复制或覆盖任何本机的资产从原始专案 （`资源` 等），并确保向 `.xcodeproj` 专案中添加任何新档。 IOS 专案生成 `platforms\ios` 目录内。

5.  复制 `config.xml` 到 `www` 目录中，并移除任何外挂程式定义。修改而不是平台目录的设置。

6.  使用科尔多瓦 CLI 工具来安装您需要的任何外挂程式。注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

7.  生成并测试。

## 升级 2.9.0 专案 3.0.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-3.0.0` 的永久目录位置的科尔多瓦 3.0.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova.js` （注意它再也没有一个版本尾码，该版本是在该档本身在标题中） 到新专案中的档 `www` 目录中，并删除 `www/cordova.js` 档。

6.  科尔多瓦的脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  删除 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

**注**： 从科尔多瓦 3.0.0 开始，未预先安装的外挂程式，和你需要使用 `plugman` 命令列实用程式来安装它们自己。 请参阅使用 Plugman 管理外挂程式。

## 升级 2.8.0 专案 2.9.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.9.0` 的永久目录位置的科尔多瓦 2.9.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  复制 `www/cordova.js` （请注意它不再有版本尾码，该版本位于档本身在标题中） 到新专案中的档 `www` 目录中，并删除 `www/cordova.js` 档。

6.  科尔多瓦的脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

## 升级 2.7.0 专案到 2.8.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.8.0` 的永久目录位置的科尔多瓦 2.8.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，iOS 壳工具指南中所述。你需要从这个新的专案资产。

5.  复制 `www/cordova.js` （请注意它不再有版本尾码，该版本位于档本身在标题中） 到 `www` 目录中，从新的专案档案并删除 `www/cordova-2.7.0.js` 档。

6.  科尔多瓦脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 使其指向新 `cordova.js` 档。

7.  更新的 `config.xml` 档中的任何 `<plugin>` 标记为 `<feature>` 标记。 请注意现有 `<plugin>` 标签仍然工作，但都被否决了。 您可以在一个新的专案的 `config.xml` 档中复制此资讯。 举个例子：
    
        <plugins>
            <plugin name="LocalStorage" value="CDVLocalStorage" />
            <!-- other plugins -->
        </plugins>
        
        <!-- change to: (note that a <feature> tag is on the same level as <plugins> -->
        <feature name="LocalStorage">
            <param name="ios-package" value="CDVLocalStorage" />
        </feature>
        <!-- other <feature> tags -->
        

8.  删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

9.  这两个框架添加到专案中：
    
        OpenAL
        ImageIO
        

10. 更新您的专案目标 **生成设置**。根据 **连结 → 其他连结器标志**，编辑 **"-Obj-C"** 是 **"-陈寿"**.

11. 更新您的专案目标 **生成设置**。 根据 **连结 → 其他连结器标志**，更改 **"-所有 _ 载入"** 是 `-force\_load ${BUILT\_PRODUCTS\_DIR}/libCordova.a`。 你只需要这样做，如果你有问题中定义 [这一问题。][2].

 [2]: https://issues.apache.org/jira/browse/CB-3458

## 升级 2.6.0 专案 2.7.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.7.0` 的永久目录位置的科尔多瓦 2.7.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，iOS 壳工具指南中所述。你需要从这个新的专案资产。

5.  复制 `www/cordova-2.7.0.js` 到新专案中的档 `www` 目录中，并删除 `www/cordova-2.6.0.js` 档。

6.  科尔多瓦脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 使其指向新 `cordova-2.7.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `AppDelegate.m` 档根据从新一个专案 （见 [此比较][3]).

8.  在 `config.xml` 档中，[删除这条线][4].

9.  删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

 [3]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=5c05ac80e056753c0e8736f887ba9f28d5b0774c;hp=623ad8ec3c46f656ea18c6c3a190d650dd64e479;hb=c6e71147386d4ad94b07428952d1aae0a9cbf3f5;hpb=c017fda8af00375a453cf27cfc488647972e9a23
 [4]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=537705d76a5ef6bc5e57a8ebfcab78c02bb4110b;hp=8889726d9a8f8c530fe1371c56d858c34552992a;hb=064239b7b5fa9a867144cf1ee8b2fb798ce1f988;hpb=c9f233250d4b800f3412eeded811daaafb17b2cc

## 升级 2.5.0 专案到 2.6.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.6.0` 的永久目录位置的科尔多瓦 2.6.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  将该专案的 `www/cordova-2.6.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-2.5.0.js` 档。

6.  科尔多瓦 （以及其他引用脚本的档） 的 `www/index.html` 档中的脚本引用更新指向新的 `科尔多瓦 2.6.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `AppDelegate.m` 档根据从新一个专案 （见 [此比较][5]).

8.  在 `config.xml` 档中，[添加这条新线][6].

9.  在 `config.xml` 档中，[添加这条新线][7].

10. 在 `config.xml` 档中，[UIWebViewBounce 已改为 DisallowOverscroll，与预设值不同][8].

11. 在 `config.xml` 档中，已弃用 `EnableLocation` 偏好。

12. 删除 `CordovaLib` 目录和副本 `CordovaLib` 目录从新专案到专案的根目录。

 [5]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=124a56bb4f361e95616f44d6d6f5a96ffa439b60;hp=318f79326176be8f16ebc93bad85dd745f4205b6;hb=a28c7712810a63396e9f32fa4eb94fe3f8b93985;hpb=36acdf55e4cab52802d73764c8a4b5b42cf18ef9
 [6]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=1555b5e81de326a07efe0bccaa5f5e2326b07a9a;hp=0652d60f8d35ac13c825c572dca6ed01fea4a540;hb=95f16a6dc252db0299b8e2bb53797995b1e39aa1;hpb=a2de90b8f5f5f68bd9520bcbbb9afa3ac409b96d
 [7]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=d307827b7e67301171a913417fb10003d43ce39d;hp=04260aa9786d6d74ab20a07c86d7e8b34e31968c;hb=97b89edfae3527828c0ca6bb2f6d58d9ded95188;hpb=942d33c8e7174a5766029ea1232ba2e0df745c3f
 [8]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=8889726d9a8f8c530fe1371c56d858c34552992a;hp=d307827b7e67301171a913417fb10003d43ce39d;hb=57982de638a4dce6ae130a26662591741b065f00;hpb=ec411f18309d577b4debefd9a2f085ba719701d5

## 升级 2.4.0 专案 2.5.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.5.0` 的永久目录位置的科尔多瓦 2.5.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  将 `www/cordova-2.5.0.js` 档从新专案复制到 `www` 目录并删除 `www/cordova-2.4.0.js` 档。

6.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `科尔多瓦 2.5.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `AppDelegate.m` 档根据从新一个专案 （见 [此比较][9]).

8.  在 `config.xml` 档中，[添加这些新行][10].

9.  在 `config.xml` 档中，[编辑的根项目，改变它从科尔多瓦到小部件][11].

10. 在 `config.xml` 档中，[删除 OpenAllWhitelistURLsInWebView 偏好][12].

11. 删除 `科尔多瓦` 目录中，并从新专案中 `科尔多瓦` 目录复写到您的专案的根目录。在 2.5.0，这已更新脚本。

12. 删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

 [9]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=318f79326176be8f16ebc93bad85dd745f4205b6;hp=6dc7bfc84f0ecede4cc43d2a3256ef7c5383b9fe;hb=4001ae13fcb1fcbe73168327630fbc0ce44703d0;hpb=299a324e8c30065fc4511c1fe59c6515d4842f09
 [10]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=903944c4b1e58575295c820e154be2f5f09e6314;hp=721c734120b13004a4a543ee25f4287e541f34be;hb=ae467249b4a256bd31ee89aea7a06f4f2316b8ac;hpb=9e39f7ef8096fb15b38121ab0e245a3a958d9cbb
 [11]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=64e71636f5dd79fa0978a97b9ff5aa3860a493f5;hp=d8579352dfb21c14e5748e09b2cf3f4396450163;hb=0e711f8d09377a7ac10ff6be4ec17d22cdbee88d;hpb=57c3c082ed9be41c0588d0d63a1d2bfcd2ed878c
 [12]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=721c734120b13004a4a543ee25f4287e541f34be;hp=7d67508b70914aa921a16e79f79c00512502a8b6;hb=187bf21b308551bfb4b98b1a5e11edf04f699791;hpb=03b8854bdf039bcefbe0212db937abd81ac675e4

## 升级 2.3.0 专案 2.4.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.4.0` 的永久目录位置的科尔多瓦 2.4.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  从新专案中的 `www/cordova-2.4.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-2.3.0.js` 档。

6.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `科尔多瓦 2.4.0.js` 档。

7.  更新 （或替换，如果你永远不会更改的档） `MainViewController.m` 档根据从新一个专案 （见 [此比较][13]).

8.  更新 （或替换，如果你永远不会更改档） `AppDelegate.m` 档根据从新一个专案 （见 [此比较][14]).

9.  在 `config.xml` 档中，[添加这条新线][15].

10. 删除 `科尔多瓦` 目录中，并从新专案中 `科尔多瓦` 目录复写到您的专案的根目录。在 2.4.0，这具有固定的脚本。

11. 删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

12. AssetsLibrary.framework 作为一种资源添加到专案中。 （请参阅 [苹果的文档][16] 说明如何做到这一点。）。

 [13]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/MainViewController.m;h=5f9eeac15c2437cd02a6eb5835b48374e9b94100;hp=89da1082d06ba5e5d0dffc5b2e75a3a06d5c2aa6;hb=b4a2e4ae0445ba7aec788090dce9b822d67edfd8;hpb=a484850f4610e73c7b20cd429a7794ba829ec997
 [14]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/Classes/AppDelegate.m;h=6dc7bfc84f0ecede4cc43d2a3256ef7c5383b9fe;hp=1ca3dafeb354c4442b7e149da4f281675aa6b740;hb=6749c17640c5fed8a7d3a0b9cca204b89a855baa;hpb=deabeeb6fcb35bac9360b053c8bf902b45e6de4d
 [15]: https://git-wip-us.apache.org/repos/asf?p=cordova-ios.git;a=blobdiff;f=bin/templates/project/__TESTING__/config.xml;h=7d67508b70914aa921a16e79f79c00512502a8b6;hp=337d38da6f40c7432b0bce05aa3281d797eec40a;hb=6749c17640c5fed8a7d3a0b9cca204b89a855baa;hpb=deabeeb6fcb35bac9360b053c8bf902b45e6de4d
 [16]: https://developer.apple.com/library/ios/#recipes/xcode_help-project_editor/Articles/AddingaLibrarytoaTarget.html

## 2.2.0 升级专案到 2.3.0

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.3.0` 的永久目录位置的科尔多瓦 2.3.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  从新专案中的 `www/cordova-2.3.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-2.2.0.js` 档。

6.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-2.3.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `MainViewController.m` 根据新专案中的一个。

8.  删除 `科尔多瓦` 目录中，并从新专案中 `科尔多瓦` 目录复写到您的专案的根目录。这在 2.3.0，新的脚本。

9.  删除 `CordovaLib` 目录和复制 `CordovaLib` 目录从新专案到您的专案的根目录。

10. `Cordova.plist` 档转换 `config.xml`，通过在您的专案档案上运行脚本 `bin/cordova\_plist\_to\_config\_xml`）。

11. 通过添加此标记下 `< 科尔多瓦 >< 外挂程式 >` 对 `config.xml`，添加 InAppBrowser 外挂程式：
    
        <plugin name="InAppBrowser" value="CDVInAppBrowser" />
        

12. 请注意目标 C 外挂程式不再 *不* 列入白名单。 到白名单中您的连接与软体白名单中，您需要将该连接的 `使用者代理` 标头设置为相同的使用者代理作为主要的科尔多瓦 web 视图。 你可以通过访问关闭主要的视图控制器的 `使用者代理` 属性。 主视图-控制器 （`CDVViewController`） 也有 `URLisAllowed` 的方法，使您要检查 URL 是否通过白名单。

13. 设备的 API 更改：
    
    *   Ios，device.platform 用来返回 `iPhone`、 `iPad` 或 `iPod 触摸` ；现在它 （正确的） 返回 `iOS`.
    *   对于 iOS，device.name (现在适用于所有平台已弃用) 用于返回使用者的设备的名称 （例如 Shazron 的 iPhone 5 ′） ；现在它返回用于返回什么 device.platform： `iPhone`、 `iPad` 或 `iPod 触摸`.
    *   对于所有的平台，是一个新的属性，称为 device.model ；这将返回特定设备的型号，例如 `iPad2，5` （对于其他平台，返回用于返回什么 device.name）。

## 2.2.0 升级 2.1.0 专案

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.2.0` 的永久目录位置的科尔多瓦 2.2.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到你放在上面的下载的源的目录。

4.  创建一个新专案，如 iOS 壳工具指南中所述。您需要从这个新的专案资产。

5.  从新专案中的 `www/cordova-2.2.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-2.1.0.js` 档。

6.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-2.2.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `MainViewController.m` 根据新专案中的一个：
    
    *   更新 → viewWillAppear

8.  将 `cordova` 目录从新专案复制到您的专案的根目录。这在 2.2.0，更新后的模仿脚本。

9.  下一步，更新 `CordovaLib` 子专案引用。 开头科尔多瓦 2.1.0，我们不使用 CORDOVALIB Xcode 变数不再当引用 `CordovaLib` 驻留在何处的引用是绝对档引用现在。
    
    1.  启动终端程式
    2.  转到科尔多瓦的安装的位置 （见步骤 1），在 `bin` 子目录中
    3.  运行该脚本下面其中的第一个参数是您的专案 `.xcodeproj` 档的路径：
        
        `update_cordova_subproject path/to/your/project/xcodeproj`

**注**： 在 2.2.0，`bin/create` 脚本复制到您的专案 `CordovaLib` 子专案中。 要有同样的安装程式，只是将正确的 `CordovaLib` 中复制到专案目录中，并更新 `CordovaLib` 子专案位置 （相对于专案） 在 Xcode 档检查器中。

## 2.1.0 升级 2.0.0 专案

2.1.0 的科尔多瓦，`CordovaLib` 已被升级，从而使用 **自动引用计数 （ARC）**。 你不需要升级到 **弧**，使用 CordovaLib，但如果您想要升级您的专案使用 **弧**，请使用 Xcode 迁移向导从功能表中： **编辑 → 重构 → 转换为目标 C 弧......**，取消选择 libCordova.a，然后运行该向导以完成。

1.  下载并解压缩到硬碟上，例如对 `~/Documents/Cordova-2.1.0` 的永久目录位置的科尔多瓦 2.1.0 源.

2.  如果它正在运行，请退出 Xcode。

3.  使用终端程式，定位到的目录，你把上面的下载的原始程式码放在哪里。

4.  创建一个新专案，iOS 壳工具指南中所述。你需要从这个新的专案资产。

5.  从新专案中的 `www/cordova-2.1.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-2.0.0.js` 档。

6.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `科尔多瓦 2.1.0.js` 档。

7.  更新 （或替换，如果你永远不会更改档） `AppDelegate.m` 根据新专案中的一个：
    
    *   Edited → application:didFinishLaunchingWithOptions:
    *   Added → application:supportedInterfaceOrientationsForWindow:

8.  更新 （或替换，如果你永远不会更改档） `MainViewController.m` 根据新专案中的一个：
    
    *   添加 → viewWillAppear

9.  将 `科尔多瓦` 目录从新专案复制到您的专案的根目录。这在 2.1.0，更新的脚本，以支援包含空格的路径。

10. 从您的专案 （是在 `CordovaLib` 中删除 `VERSION` 档引用).

11. 下一步，更新 `CordovaLib` 子专案引用。 开头科尔多瓦 2.1.0，我们不使用 CORDOVALIB Xcode 变数不再当引用 `CordovaLib` 驻留在何处的引用是绝对档引用现在。
    
    1.  启动终端程式
    2.  转到科尔多瓦的安装的位置 （见步骤 1），在 `bin` 子目录中
    3.  运行该脚本下面其中的第一个参数是您的专案 `.xcodeproj` 档的路径：
        
        `update_cordova_subproject path/to/your/project/xcodeproj`

## 升级 1.9.0 专案 2.0.0

1.  安装 2.0.0 科尔多瓦。

2.  创建一个新专案，iOS 壳工具指南中所述。你需要从这个新的专案资产。

3.  从新专案中的 `www/cordova-2.0.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-1.9.0.js` 档。

4.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-2.0.0.js` 档。

5.  `cordova` 目录从新专案复制到您的专案的根目录 （如果你想要的专案的命令列工具）。

6.  在 `Cordova.plist` 档中，**支援档** 组下添加一个新条目下 `的外挂程式`。 关键是 `key` 和的值是 `CDVDevice`.

7.  删除 `Cordova.framework`.

8.  从 **支援档** 组中删除 `verify.sh`。

9.  在专案导航器中选择专案图示，选择您的专案 **目标**，然后选择 **生成设置** 选项卡。

10. 搜索 **预处理器宏**，然后删除所有 **CORDOVA_FRAMEWORK = 1** 值。

11. 找到安装在您的个人资料夹 `档` 子目录下你硬碟上的 `CordovaLib` 目录。

12. 找到 `CordovaLib.xcodeproj` 档在 `CordovaLib` 目录中，然后拖动并将档放入您的专案。它应该显示为子专案。

13. 生成您的专案，你应该与有关的 `#import` 指令的一些错误。

14. 对于 `#import` 错误，更改任何报价基于进口的这种风格：
    
        #import "CDV.h"
        
    
    为此基于方括弧的样式：
    
        #import <Cordova/CDV.h>
        
    
    删除任何 `#ifdef` （wrapper 任何科尔多瓦进口，他们再也不需要 （现在统一进口)

15. 再次，生成您的专案，它不应该有任何的 `#import` 错误。

16. 在专案导航器中选择 **专案图示**，选择您的专案 **目标**，然后选择 **生成阶段** 选项卡。

17. 扩展 **目标依赖关系** 阶段，然后选择 **+** 按钮。

18. 选择 `CordovaLib` 的目标，然后选择 **添加** 按钮。

19. 展开 **连结二进位与图书馆** 第一阶段 （它应该已经包含大量的框架），然后选择 **+** 按钮。

20. 选择 `libCordova.a` 静态程式库，然后选择 **添加** 按钮。

21. 删除 **运行脚本** 阶段。

22. 在专案导航器中选择 **专案图示**，选择您的专案 **目标**，然后选择 **生成设置** 选项卡。

23. 搜索 **其他连结器标志**，并添加相应的值 **-force_load** 和 **-Obj-C**.

24. 展开的 `CordovaLib` 的子专案。

25. 定位的 `VERSION` 档，将它拖入主要专案 （我们想要创建连结到它，不是一个副本）。

26. 选择 **任何添加的资料夹创建组** 的选项按钮，然后选择 **完成** 按钮。

27. 在上一步中选择您刚刚拖动的 `VERSION` 档。

28. 键入 **选项命令 1** 复合键以显示 **档检查器** (或功能表项目 **视图 → 实用程式 → 显示档检查器**).

29. **相对于 CORDOVALIB** **档检查** 器下拉式功能表中选择 **位置**.

30. 设置 Xcode 偏好 **Xcode 偏好 → 地点 → 派生资料 → 先进......** 了 **独特** 的发现的统一的标头。

31. 在专案导航器中选择 **专案图示**，选择你的 **目标**，然后选择 **生成设置** 选项卡。

32. **标题搜索路径** 的搜索。该设置将追加这三个值，包括引号：
    
        "$(TARGET_BUILD_DIR)/usr/local/lib/include"
        
        "$(OBJROOT)/UninstalledProducts/include"
        
        "$(BUILT_PRODUCTS_DIR)"
        

33. 搜索 **其他连结器的标志**。该设置将追加此值：
    
        -weak_framework CoreFoundation
        

34. 生成您的专案，它应编译和连结 **没有** 问题.

35. 从 **方案** 下拉式功能表，选择您的专案，然后选择 **iPhone 5.1 模拟器**.

36. 选择 **运行** 按钮。

**注意**： 如果您的专案预期在模拟器中无法正常工作，请记下任何错误主控台日志中 Xcode 的线索。

## 1.8.x 计划升级为 1.9.0

1.  安装科尔多瓦 1.9.0。

2.  创建一个新专案。您将需要的一些资产从这个新的专案。

3.  从新专案中的 `www/cordova-1.9.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-1.8.x.js` 档。

4.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-1.9.0.js` 档。

**注**： 1.9.0 支援新的 `BackupWebStorage` 布林 `Cordova.plist` 设置。 它预设启用的所以将其设置为 `false` 以禁用它，尤其是在 iOS 6。 请参阅 [版本资讯： Safari 和 UIKit 科][17]

 [17]: https://developer.apple.com/library/prerelease/ios/#releasenotes/General/RN-iOSSDK-6_0/_index.html

## 1.8.x 升级 1.7.0 以来专案

1.  安装科尔多瓦 1.8.0。

2.  创建一个新的专案。您将需要一些资产从这个新的专案。

3.  从新专案中的 `www/cordova-1.8.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-1.7.x.js` 档。

4.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `科尔多瓦 1.8.0.js` 档。

如果您打算使用捕获的 API，您将需要新的 **iPad 视网膜显示** 资产：

1.  将从新专案的 `Resources/Capture.bundle` 专案复制到您的专案目录，过度写您现有的 `Resources/Capture.bundle` 专案。

2.  在您的专案中，选择 `Capture.bundle` 专案到您专案中 Xcode 的导航器，键入 **Delete** 键，然后从出现的对话方块中选择 **移除引用**。

3.  从上面的步骤 1 中将新 `Capture.bundle` 拖动到 Xcode，你的专案导航器中，然后选择 **为任何添加的资料夹创建组** 的选项按钮。

## 1.6.x 专案升级到 1.7.0 以来

1.  安装科尔多瓦 1.7.0 以来。

2.  创建一个新的专案。您将需要一些资产从这个新的专案。

3.  从新专案中的 `www/cordova-1.7.0.js` 档案复制到 `www` 目录中，并删除 `www/cordova-1.6.0.js` 档。

4.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-1.7.0.js` 档。

## 1.6.x 版升级 1.5.0 专案

1.  安装 1.6.1 科尔多瓦。

2.  在您的专案制作一个备份的 `AppDelegate.m`、 `AppDelegate.h`、 `MainViewController.m`、 `MainViewController.h`、 `Cordova.plist`。

3.  创建一个新的专案。您将需要一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 1.5.0-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        Cordova.plist
        

5.  将所有新的 `MainViewController` 和 `AppDelegate` 档添加到您的 Xcode 专案。

6.  从新专案中的 `www/cordova-1.6.1.js` 档案复制到 `www` 目录中，并删除 `www/cordova-1.5.0.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `cordova-1.6.1.js` 档。

8.  新的 `Cordova.plist` 档添加到您的专案中。 这是必要的因为核心外挂程式服务名称必须更改以匹配那些从 Android 和黑莓，为统一的科尔多瓦 JavaScript 档 (`cordova-js`).

9.  集成任何设置、 **外挂程式** 和 **ExternalHosts** 的条目，你在你的 **备份 Cordova.plist** `Cordova.plist` 新进.

10. 集成到新的 `AppDelegate` 档，你有在您的备份 `AppDelegate.h` 和 `AppDelegate.m` 的任何特定于专案的代码。 `AppDelegate.m` 中的任何 `UIWebViewDelegate` 或 `CDVCommandDelegate` 的代码需要转到 `MainViewController.m` 现在 （见该档中的注释掉节）。

11. 集成到新的 MainViewController 档，你有在您的备份 `MainViewController.h` 和 `MainViewController.m` 的任何特定于专案的代码。

12. 点击专案导航器中的专案图示，选择您的 **专案**，然后选择 **生成设置** 选项卡。

13. 输入 **编译器的 C / C + + 目标 C** 在搜索栏位中。

14. 选择 **苹果 LLVM 编译器 3.1** 值。

## 升级到 1.5.0 版的 1.4.x 专案

1.  安装科尔多瓦 1.5.0 版。

2.  创建一个新的专案并运行一次。您将需要一些资产从这个新的专案。

3.  从新专案中的 `www/cordova-1.5.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-1.4.x.js` 档。

4.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的科尔多瓦 `cordova-1.5.0.js` 档。

5.  在您的专案浏览器中找到 `PhoneGap.framework`，请选择它。

6.  键入 **Delete** 键，删除 `PhoneGap.framework` 参考专案导航器中。

7.  键入 **选项命令 A** 复合键应下拉表将档添加到您的专案 （**添加档...** 表）。 请确保选中 **创建组的任何添加的资料夹** 选项按钮。

8.  键入 **转变-命令-G** 复合键应该降下来为你去到一个资料夹中的另一个表 （**转到资料夹：** 表）。

9.  输入 `/Users/Shared/Cordova/Frameworks/Cordova.framework` 在 **转到资料夹：** 表，然后按 **继续** 按钮。

10. 在工作表中 **添加的档......**，请按 **添加** 按钮。

11. 在专案导航器中选择 `Cordova.framework`。

12. 键入 **选项命令 1** 复合键以显示 **档检查器**.

13. **绝对路径** 的 **档检查器** 的下拉式功能表中选择 **位置**.

14. 键入 **选项命令 A** 复合键应下拉表将档添加到您的专案 （**添加档...** 表）。 请确保选中 **创建组的任何添加的资料夹** 选项按钮。

15. 键入 **转变-命令-G** 复合键应该降下来为你去到一个资料夹中的另一个表 （**转到资料夹：** 表）。

16. 输入 `~/Documents/CordovaLib/Classes/deprecated` 在 **转到资料夹：** 表，然后按 **继续** 按钮。

17. 在工作表中 **添加的档......**，请按 **添加** 按钮。

18. 在 `AppDelegate.h`，`AppDelegate.m` 和 `MainViewController.h` 档，替换整个 `#ifdef PHONEGAP_FRAMEWORK` 块：
    
        #import "CDVDeprecated.h"
        

19. 按一下 **专案图示** 在专案导航器中，选择你的 **目标**，然后选择 **生成设置** 选项卡。

20. 搜索 **框架搜索路径**.

21. 替换现有 `/Users/Shared/Cordova/Frameworks`.

22. **预处理器宏** 搜索.

23. 对于第一个 （组合） 值，替换的值与 **CORDOVA_FRAMEWORK = YES**.

24. 选择 **生成阶段** 选项卡。

25. 扩展 **运行脚本**.

26. 任何替换 **PhoneGap** 与 **科尔多瓦**.

27. 在专案导航器中找到 `PhoneGap.plist` 档，然后按一下档案名一旦进入编辑模式的名称。

28. 将重命名为 `Cordova.plist` 的 `PhoneGap.plist`.

29. 在 `Cordova.plist` 上右击并选择 **打开为 → 原始程式码**.

30. 请按 **选项-命令-F**，选择 **替换** 从下拉顶上留下的源视窗。

31. 为查找字串和替换字串中，`org.apache.cordova` 输入 `com.phonegap`，然后按 **全部替换** 按钮。

32. **PG** **CDV** 的查找字串输入替换字串，然后按 **全部替换** 按钮。

33. 按 **命令 B** 打造。 你仍然有在将来你可以摆脱的用法 （见 `CDVDeprecated.h`。 例如，在代码中使用 PG * 对犬瘟热病毒 * 的替换类）。

## 1.4.1 升级 1.4.0 专案

1.  安装 1.4.1 科尔多瓦。

2.  制作一个备份 `MainViewController.m`.

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将 `MainViewController.m` 档从新专案复制到您在磁片上，替换旧档的 1.4.0-based 专案目录 （备份您的档第一次从上面的步骤 2）。

5.  将 `MainViewController.m` 档添加到您的 Xcode 专案。

6.  整合您有在您备份 `MainViewController.m` 到新档中的任何特定于专案的代码。

7.  更新 `phonegap 1.4.0.js` 档是可选的什么都没有改变在 JavaScript 中 1.4.0 和 1.4.1 之间。

## 1.4.0 升级 1.3.0 专案

1.  安装科尔多瓦 1.4.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 1.3.0-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  从新专案中的 `www/phonegap-1.4.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-1.3.0.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `phonegap-1.4.0.js` 档。

8.  添加一个新条目下的 `Plugins` 的 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 1.3.0 升级 1.2.0 专案

1.  安装科尔多瓦 1.3.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 1.2.0-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  从新专案中的 `www/phonegap-1.3.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-1.2.0.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `phonegap-1.3.0.js` 档。

8.  添加一个新条目下的 `Plugins` 的 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 1.2.0 升级 1.1.0 专案

1.  安装科尔多瓦 1.2.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 1.1.0-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  从新专案中的 `www/phonegap-1.2.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-1.1.0.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `phonegap-1.2.0.js` 档。

8.  添加一个新条目下的 `Plugins` 的 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 1.0.0 专案到 1.1.0

1.  安装科尔多瓦 1.1.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新专案。您将需要的一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 1.0.0-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        MainViewController.xib
        

5.  添加所有 `MainViewController` 入 Xcode 专案档案。

6.  从新专案中的 `www/phonegap-1.1.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-1.0.0.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `phonegap-1.1.0.js` 档。

8.  添加一个新条目下的 `Plugins` 的 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 和值是`PGBattery`.

9.  集成任何您已在您的备份中的具体专案代码 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。

## 升级 0.9.6 专案 1.0.0

1.  安装科尔多瓦 1.0.0。

2.  制作一个备份的 `AppDelegate.m` 和 `AppDelegate.h` 在您的专案中。

3.  创建一个新的专案。您将需要一些资产从这个新的专案。

4.  将这些档从新专案复制到您在磁片上，取代任何旧的档 （备份您的档第一次从上述步骤 2） 的 0.9.6-based 专案目录：
    
        AppDelegate.h
        AppDelegate.m
        MainViewController.h
        MainViewController.m
        MainViewController.xib
        

5.  在添加了所有 `MainViewController` 档到您的 Xcode 专案。

6.  从新专案中的 `www/phonegap-1.0.0.js` 档案复制到 `www` 目录中，并删除 `www/phonegap-0.9.6.js` 档。

7.  科尔多瓦脚本中 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 的引用更新为指向新的 `phonegap-1.0.0.js` 档。

8.  添加一个新条目下的 `Plugins` 的 `PhoneGap.plist` 档。关键是 `com.phonegap.battery` 的值`PGBattery`.

9.  将您在您的备份任何特定于专案的代码集成 `AppDelegate.h` 和 `AppDelegate.m` 成新的 AppDelegate 档。