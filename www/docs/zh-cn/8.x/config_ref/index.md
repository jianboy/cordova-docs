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

title: Config.xml 档
toc_title: Config.xml文件
---

# Config.xml 档

与全域设定档，可以控制应用程式的行为的许多方面 `config.xml` 。 这与平台无关的 XML 档被安排基于 W3C 的[打包 Web 应用程式 （视窗小部件）][1]规范，并扩展指定核心Cordova API 功能、 外挂程式和平台特定的设置。

 [1]: http://www.w3.org/TR/widgets/

为专案创建与Cordova CLI （描述在命令列介面），可以在顶层目录中找到此档：

        app/config.xml
    

请注意之前的版本 3.3.1-0.2.0，该档存在 `app/www/config.xml` ，并且仍然支援让它在这里。

当使用 CLI 来生成专案时，此档的版本被动地被覆制到各种 `platforms/` 子目录，例如：

        app/platforms/ios/AppName/config.xml
        app/platforms/blackberry10/www/config.xml
        app/platforms/android/res/xml/config.xml
    

本节详细介绍全球和跨平台的配置选项。请参见以下各节为平台特定的选项：

*   [iOS 配置](../guide/platforms/ios/config.html)
*   [Android 系统组态](../guide/platforms/android/config.html)
*   [黑莓 10 配置](../guide/platforms/blackberry10/config.html)

除了下面详述的各种配置选项，您还可以配置每个目标平台的图像应用程式的核心的集。有关更多资讯，请参见图示和启动画面。

## 核心配置元素

此示例显示了预设的 `config.xml` 生成的 CLI 的 `create` 命令，所述的命令列介面：

        <widget id="com.example.hello" version="0.0.1">
            <name>HelloWorld</name>
            <description>
                A sample Apache Cordova application that responds to the deviceready event.
            </description>
            <author email="dev@callback.apache.org" href="http://cordova.io">
                Apache Cordova Team
            </author>
            <content src="index.html" />
            <access origin="*" />
        </widget>
    

以下的配置元素出现在顶级 `config.xml` 档，并在所有受支援的Cordova平台支持：

*   `<widget>`元素的 `id` 属性提供了应用程式的反向域识别码和 `version` 主要/次要/修补程式符号表示其完整版本号码。
    
    小部件标记也可以指定替代版本，即 versionCode 为安卓系统和 CFBundleVersion 的 iOS 的属性。请参阅下面的附加版本控制部分的详细资讯。

*   `<name>`元素指定应用程式的正式名称，因为它出现在设备的主画面上和在应用程式商店介面内。

*   `<description>`和 `<author>` 的元素指定的中继资料和联系资讯，可能会出现在应用程式商店清单内。

*   可选的 `<content>` 元素在顶级 web 资产目录中定义应用程式的起始页。 预设值是 `index.html` ，其中通常出现在一个专案中的顶级 `www` 目录。

*   `<access>`元素定义应用程式能够与进行通信的外部域的集。 如上所示的预设值允许它访问任何伺服器。 请参阅域白名单指南的详细资讯。

*   `<preference>`标记设置各种选项作为对 `name` / `value` 属性。 每个首选项的 `name` 是不区分大小写。 很多优惠是独有的特定平台上，如列于此页的顶部。 以下各节详细介绍了适用于多个平台的首选项。

### 其他的版本控制

同时，Android 和 iOS iOS 支援第二个版本字串 （或数位） 除了一个可见在应用程式商店， [versionCode][2]为安卓系统和[CFBundleVersion][3] 。 下面是一个示例，显式地设置 versionCode 和 CFBundleVersion

 [2]: http://developer.android.com/tools/publishing/versioning.html
 [3]: http://stackoverflow.com/questions/4933093/cfbundleversion-in-the-info-plist-upload-error

        <widget id="io.cordova.hellocordova"
          version="0.0.1"
          android-versionCode="7"
          ios-CFBundleVersion="3.3.3">
    

如果不指定替代版本，则将使用以下预设值：

        // assuming version = MAJOR.MINOR.PATCH-whatever
        versionCode = PATCH + MINOR * 100 + MAJOR * 10000
        CFBundleVersion = "MAJOR.MINOR.PATCH"
    

## 全球首选项

以下全球首选项适用于所有平台：

*   `Fullscreen`使您可以隐藏在萤幕顶部的状态列。预设值是 `false` 。示例：
    
        <preference name="Fullscreen" value="true" />
        

## 多平台首选项

下面的首选项应用到多个平台，但不是向他们：

*   `DisallowOverscroll`(boolean 类型的值，预设值为 `false` ）： 设置为 `true` 如果你不想要当使用者滚动过去的开头或结尾的内容时显示的任何回馈资讯的介面。
    
        <preference name="DisallowOverscroll" value="true"/>
        
    
    适用于 Android 和 iOS。 在 iOS，overscroll 手势事业内容反弹到其原始位置。 在 android 系统，它们产生一个更微妙的光晕效果沿的顶部或底部边缘的内容。

*   `BackgroundColor`： 设置应用程式的背景色。 支援四个位元组的十六进位值，与第一个位元组代表一个 Alpha 色板、 和标准的 RGB 值为以下三个位元组。 此示例指定蓝色：
    
        <preference name="BackgroundColor" value="0xff0000ff"/>
        
    
    适用于 Android 和黑莓手机。覆盖 CSS 否则为可跨*所有*平台，例如：`body{background-color:blue}`.

*   `HideKeyboardFormAccessoryBar`(boolean 类型的值，预设值为 `false` ）： 设置为 `true` ，隐藏其他工具列出现在键盘上方说明使用者导航到另一个表单输入从。
    
        <preference name="HideKeyboardFormAccessoryBar" value="true"/>
        
    
    适用于黑莓手机。

*   `Orientation`（字串，预设值为 `default`）： 允许您锁定方向并防止介面回应变化的方向旋转。 可能的值是 `default`，`landscape` 或 `portrait`。 示例：
    
        <preference name="Orientation" value="landscape" />
        
    
    此外，您可以指定任何特定于平台的定位值如果您放置 `<preference>` 元素中的 `<platform>` 元素：
    
        <platform name="android">
            <preference name="Orientation" value="sensorLandscape" />
        </platform>
        
    
    适用于 Android、 iOS，WP8，亚马逊火 OS 和火狐浏览器的作业系统。
    
    **注意**： `default` 值意味著Cordova将带定位首选项条目从平台的清单/设定档允许回退到其预设行为的平台。
    
    对于 iOS，指定纵向和横向模式您将使用平台特定的值`所有`:
    
        <platform name="ios">
            <preference name="Orientation" value="all" />
        </platform>
        
## *功能*元素

如果你使用的 CLI 来构建应用程式，您将使用`外挂程式`命令来启用设备的 Api。 这不修改顶级`config.xml`档中，所以`< 功能 >`元素并不适用于您的工作流。 如果您直接在 SDK 和使用特定于平台的`config.xml`档作为源工作，你使用`< 功能 >`标记启用设备级 Api 和外部外挂程式。 他们经常出现以特定于平台的`config.xml`档中的自订值。 例如，下面是如何指定设备 API 为 Android 专案:

        <feature name="Device">
            <param name="android-package" value="org.apache.cordova.device.Device" />
        </feature>
    

这里是 iOS 专案元素的显示方式:

        <feature name="Device">
            <param name="ios-package" value="CDVDevice" />
        </feature>
    

有关如何指定每个功能，请参阅 API 参考的详细资讯。看到外挂程式的外挂程式开发指南的详细资讯。

## *平台*的元素

使用 CLI 来构建应用程式，时，有时需要指定首选项或其他特定于特定平台的元素。 `<platform>`元素用于指定应该只出现在一个特定于平台的`config.xml`档中的配置。 例如，下面是如何指定那唯一的 android 应该使用全屏显示首选项:

        <platform name="android">
            <preference name="Fullscreen" value="true" />
        </platform>
    

## *hook*元

表示您自订的脚本，将调用由Cordova发生某些操作时 (例如，添加外挂程式或平台编写逻辑之后调用)。 当您需要扩展预设Cordova功能时，这很有用。 更多的资讯，请参阅挂钩的指南。

    <hook type="after_plugin_install" src="scripts/afterPluginInstall.js" />