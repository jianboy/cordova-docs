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

title: WebViews iOS
---

# WebViews iOS

本指南说明如何将嵌入在一个较大的 iOS 应用程式内的Cordova启用 web 视图元件。这些元件可以如何与对方沟通的详细资讯，请参阅应用程式外挂程式。

WebViews 为 iOS 支援开始与Cordova版本 1.4，用`切肉刀`元件为其 Xcode 范本可作为一个参考实现。 Cordova 2.0 及更高版本仅支援基于子专案的刀实施。

这些指示要求至少Cordova 3.x 和 Xcode 6.0 中，以及从新创建的 iOS 专案的 `config.xml` 档。 你可以使用程式的命令列介面来创建一个新专案，然后获取 `config.xml` 从档中的命名的应用程式子目录内`platforms/ios`.

要按照这些说明进行操作，请确保您有最新的Cordova分布。从[cordova.apache.org][1]下载并解压其 iOS 包。

 [1]: http://cordova.apache.org

## 将刀添加到 Xcode 专案 （CordovaLib 子专案）

1.  如果它正在运行，请退出 Xcode。

2.  打开一个终端并导航到Cordova iOS 的原始目录。

3.  复制 `config.xml` 档到专案目录上文所述。

4.  打开 Xcode 并使用 Finder 来复制 `config.xml` 档到其**专案导航**视窗。

5.  选择**创建组的任何添加的资料夹**，然后按**完成**.

6.  使用 Finder 来复制 `CordovaLib/CordovaLib.xcodeproj` 档到 Xcode 的**专案导航器**

7.  选择 `CordovaLib.xcodeproj` 内**专案导航器**.

8.  键入**选项-命令-1**键的组合，以显示**档检查器**.

9.  选择**相对于组****档检查器**器下拉式功能表中的**位置**.

10. 在**导航专案**中选择**专案图示**，选择**目标**，然后选择**生成设置**选项卡。

11. 添加 `-force_load` 和 `-Obj-C` 的**其他连结器标志**值。

12. 按一下专案导航器中的**专案图示**，选择**目标**，然后选择**生成阶段**选项卡。

13. 展开**连结二进位档案与库**.

14. 选择**+**按钮，然后添加下列**框架**。 （可选） 在**导航专案**内, 移动它们**框架**组下：
    
        AssetsLibrary.framework
        CoreLocation.framework
        CoreGraphics.framework
        MobileCoreServices.framework
        

15. 扩展**目标的依赖关系**，与该标签，如果有多个框顶部的框。

16. 选择**+**按钮，然后添加 `CordovaLib` 生成产品。

17. 展开**连结与库的二进位档案**，与该标签，如果有多个框顶部的框。

18. 选择**+**按钮，然后添加`libCordova.a`.

19. 设置**Xcode 首选项 → 位置 → 派生资料 → 高级...**到**独特**.

20. 在专案导航器中选择**专案图示**，选择你的**目标**，然后选择**生成设置**选项卡。

21. 搜索**标题搜索路径**。该设置，添加这三个值以下，包括引号：
    
        "$(TARGET_BUILD_DIR)/usr/local/lib/include"        
        "$(OBJROOT)/UninstalledProducts/include"
        "$(BUILT_PRODUCTS_DIR)"
        
    
    Cordova 2.1.0，如 `CordovaLib` 已升级为使用**自动引用计数 (弧)**。 你不需要升级到**弧**要使用 `CordovaLib` ，但如果您想要升级您的专案使用**弧**，则应使用 Xcode 迁移向导从**编辑 → 重构 → 转换为目标 C 弧...**功能表中，**取消选择 libCordova.a**，然后运行向导完成。

## 使用 CDVViewController

1.  添加以下标头：
    
        #import <Cordova/CDVViewController.h>
        

2.  具现化一个新的 `CDVViewController` 和保留它在某个地方，例如，到类的属性：
    
        CDVViewController* viewController = [CDVViewController new];
        

3.  （可选） 设置 `wwwFolderName` 属性，预设为 `www` ：
    
        viewController.wwwFolderName = @"myfolder";
        

4.  （可选） 设置的起始页 `config.xml` 档的 `<content>` 标记，或者本地的档：
    
        <content src="index.html" />
        
    
    ...或是远端站台：
    
        <content src="http://apache.org" />
        

5.  （可选） 设置 `useSplashScreen` 属性，预设为 `NO` ：
    
        viewController.useSplashScreen = YES;
        

6.  设置**视图框架**。始终设置为最后一个属性：
    
        viewController.view.frame = CGRectMake(0, 0, 320, 480);
        

7.  向视图添加刀：
    
        [myView addSubview:viewController.view];
        

## 添加 HTML、 CSS 和 JavaScript 资产

1.  创建一个新的目录，在专案中， `www` 为例。

2.  将 HTML、 CSS 和 JavaScript 资产放到此目录。

3.  使用 Finder 将目录复写到 Xcode 的**专案导航**视窗。

4.  选择**任何添加的资料夹创建资料夹的参考档**.

5.  设置相应的 `wwwFolderName` 和 `startPage` 你最初创建的目录的属性或使用预设值 （在上一节中指定） 时具现化`CDVViewController`.
    
        /*
         if you created a folder called 'myfolder' and
         you want the file 'mypage.html' in it to be
         the startPage
        */
        viewController.wwwFolderName = @"myfolder";
        viewController.startPage = @"mypage.html"