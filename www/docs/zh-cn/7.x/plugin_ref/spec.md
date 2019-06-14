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

title: 外挂程式规范
toc_title: Plugin.xml
---

# 外挂程式规范

`plugin.xml`档是一个 XML 文档在 `plugins` 命名空间： `http://apache.org/cordova/ns/plugins/1.0` 。 它包含顶级 `plugin` 元素，定义该外挂程式和定义外挂程式的结构的儿童。

示例外挂程式元素：

    <?xml version="1.0" encoding="UTF-8"?>
    <plugin xmlns="http://apache.org/cordova/ns/plugins/1.0"
        xmlns:android="http://schemas.android.com/apk/res/android"
        id="com.alunny.foo"
        version="1.0.2">
    

## *外挂程式*元素

`plugin`元素是外挂程式清单的顶级元素。它具有下列属性：

*   `xmlns`（必填）： 外挂程式的命名空间， `http://apache.org/cordova/ns/plugins/1.0` 。 如果文档包含 XML 从其他命名空间如标记添加到 `AndroidManifest.xml` 档中，这些命名空间，也应该列入的顶级元素。

*   `id`（必填）： 一个反向域样式识别码的外挂程式，如`com.alunny.foo`

*   `version`（必填）： 该外挂程式相匹配的以下主要-未成年人-修补程式样式的正则运算式的版本号：
    
        ^\d+[.]\d+[.]\d+$
        

## *发动机*和*引擎*的元素

子项目的 `<engines>` 元素指定版本的此外挂程式支援的基于 Apache Cordova的框架。示例：

    <engines>
        <engine name="cordova" version="1.7.0" />
        <engine name="cordova" version="1.8.1" />
        <engine name="worklight" version="1.0.0" platform="android" scriptSrc="worklight_version"/>
    </engines>
    

类似于 `<plugin>` 元素的 `version` 属性中，指定的版本字串应匹配符合正则运算式的字串主要-未成年人-修补程式：

        ^\d+[.]\d+[.]\d+$
    

引擎的元素也可指定模糊比对为了避免重复，并减少维护基础平台更新时。 工具应该支援的最低 `>` ， `>=` ， `<` 和 `<=` ，例如：

    <engines>
        <engine name="cordova" version=">=1.7.0" />
        <engine name="cordova" version="<1.8.1" />
    </engines>
    

`<engine>`标签也有预设支援的所有主要平台存在的Cordova。 指定 `cordova` 引擎标记，则意味著所有版本的Cordova在任何平台上必须都满足发动机版本属性。 你可能还会列出特定的平台和它们的版本以覆盖全部捕获 `cordova` 引擎：

    <engines>
        <engine name="cordova" version=">=1.7.0" />
        <engine name="cordova-android" version=">=1.8.0" />
        <engine name="cordova-ios" version=">=1.7.1" />
    </engines>
    

这里是`< engine >`标记支援预设引擎的清单:

*   `cordova`
*   `cordova-plugman`
*   `cordova-amazon-fireos`
*   `cordova-android`
*   `cordova-ios`
*   `cordova-blackberry10`
*   `cordova-wp8`
*   `cordova-windows8`
*   `android-sdk` // returns the highest Android api level installed
*   `apple-xcode` // returns the xcode version 
*   `apple-ios` // returns the highest iOS version installed
*   `apple-osx` // returns the OSX version
*   `blackberry-ndk` // returns the native blackberry SDK version

指定自订的基于 Apache Cordova的框架应列出引擎标记下就像这样：

    <engines>
        <engine name="my_custom_framework" version="1.0.0" platform="android" scriptSrc="path_to_my_custom_framework_version"/>
        <engine name="another_framework" version=">0.2.0" platform="ios|android" scriptSrc="path_to_another_framework_version"/>
        <engine name="even_more_framework" version=">=2.2.0" platform="*" scriptSrc="path_to_even_more_framework_version"/>
    </engines>
    

一个自订的基于 Apache Cordova框架需要引擎的元素包含以下特性： `name` ， `version` ， `scriptSrc` ，和`platform`.

*   `name`(必填): 人类可读的名称为您自订的框架。

*   `version`(必填): 您的框架必须要安装的版本。

*   `scriptSrc`(必填): 告诉 plugman 是什么版本的自订框架的指令档。 理想情况下，这个档应该在你的外挂程式目录的顶级目录内。

*   `platform`(必填): 您的框架支援哪些平台。 您可以使用万用字元`*`说支援的所有平台，指定多个像`android|ios|blackberry10`的管道字元或只是一个单一的平台，像`android`.

plugman 中止与非零代码为其目标专案不能满足发动机的约束任何外挂程式。

如果不是 `<engine>` 指定的标记、 plugman 尝试盲目地安装到指定的Cordova的专案目录。

## *名称*元素

该外挂程式，其文本内容包含外挂程式的名称人类可读的名称。例如：

    <name>Foo</name>
    

此元素还不能 () 处理当地语系化。

## *说明*元素

对该外挂程式的人类可读说明。元素的文本内容包含外挂程式的描述。示例：

    <description>Foo plugin description</description>
    

此元素还不能 () 处理当地语系化。

## *作者*元素

外挂程式作者姓名。元素的文本内容包含外挂程式作者的姓名。示例：

    <author>Foo plugin description</author>
    

## *关键字*元素

外挂程式关键字。元素的文本内容包含以逗号分隔的关键字来描述该外挂程式。示例：

    <keywords>foo,bar</keywords>
    

## *许可证*元素

外挂程式许可。元素的文本内容包含外挂程式许可证。示例：

    <license>Apache 2.0 License</license>
    

## *资产*元素

一个或多个元素列出档或目录复写到Cordova app `www` 目录。例子：

    <!-- a single file, to be copied in the root directory -->
    <asset src="www/foo.js" target="foo.js" />
    <!-- a directory, also to be copied in the root directory -->
    <asset src="www/foo" target="foo" />
    

所有 `<asset>` 标签需要两个 `src` 和 `target` 的属性。 只有 web 外挂程式包含主要是 `<asset>` 的元素。 任何 `<asset>` 元素的嵌套在 `<platform>` 元素指定特定于平台 web 资产，如下所述。 属性包括：

*   `src`(必填): 档或目录位于外挂程式包，相对于`plugin.xml`文档。 如果档不存在指定的`src`地点，plugman 停止反转安装过程，发出一个通知关于冲突，和与非零代码退出。

*   `target` (required):
    
    在那里的档或目录应位于Cordova app，相对于`www`目录。 资产可以有针对性地对子目录，例如:
    
        <asset src="www/new-foo.js" target="js/experimental/foo.js" />
        
    
    创建`js/experimental`目录在`www`目录中，除非已经呈现，然后将`new-foo.js`档案复制并重命名为`foo.js`。 如果目标位置已存在的档，plugman 停止和反转安装过程、 然后发出一个通知关于冲突，并在此与非零代码退出。

## *js 模组*元素

大多数的外挂程式包括一个或多个 JavaScript 档。 每个 `<js-module>` 标记对应于一个 JavaScript 档，并防止外挂程式的使用者不必添加 `<script>` 为每个档标记。 虽然 `<asset>` 标签只是将一个档案复制从外挂程式子目录到 `www` ， `<js-module>` 标记是复杂得多。 他们看起来像这样：

    <js-module src="socket.js" name="Socket">
        <clobbers target="chrome.socket" />
    </js-module>
    

与上面的例子，安装一个外挂程式时 `socket.js` 复制到 `www/plugins/my.plugin.id/socket.js` ，并作为对条目添加 `www/cordova_plugins.js` 。 在载入时，代码在 `cordova.js` 使用 XHR 来读取每个档并注入 `<script>` 到 HTML 标签。 它将添加一个映射，以痛打或合并并酌情按如下所述。

*不*换行的档 `cordova.define` ，因为它会自动添加。 模组包裹在一个闭包， `module` ， `exports` ，和 `require` 在范围中，如是正常的 AMD 模组。

详细资讯 `<js-module>` 标记：

*   `src`引用相对于`plugin.xml`档外挂程式目录中的档。

*   该`name`提供模组名称的最后一部分。 如果你想要使用`cordova.require`来导入你的外挂程式在 JavaScript 代码中的其他部分，它一般可以无论你喜欢，和它的唯一事项。 模组名称为`< js-module >`是你的外挂程式`id`后, 跟`名称`的值。 例如上面， `id`为`chrome.socket`的模组名称是`chrome.socket.Socket`.

*   在`< js-module >`内允许三个标记:
    
    *   `< clobbers target="some.value"/ >`指示`module.exports`插入作为`window.some.value`的`视窗`物件。 你可以有多`< clobbers >`如你所愿。 创建任何物件在`window`上不可用。
    
    *   `< merges target="some.value"/ >`指示，应与在`window.some.value`的任何现有值合并模组。 如果已经存在任何键，模组的版本将覆盖原始。 你可以有多`< merges >`如你所愿。 创建任何物件在`window`上不可用。
    
    *   `< runs / >`意味著您的代码应该用`cordova.require`，指定，但不是安装在`window`物件上。 这是有用的当初始化模组，将事件处理常式附加或以其他方式。 你只能有一个`< runs / >`标记。 请注意，包括`< runs / >``< clobbers / >`或`< merges / >`是多余的因为他们也`cordova.require`您的模组。
    
    *   空的`< js-module >`仍然载入，并可以通过`cordova.require`的其他模组中访问.

如果 `src` 不能解决到现有档，plugman 将停止和反转安装，发出一个通知的问题，和以非零代码退出。

嵌套 `<js-module>` 内的元素 `<platform>` 声明特定平台 JavaScript 模组绑定。

## *依赖项*元素

`<dependency>`标记使您可以指定当前外挂程式所依赖的其他外挂程式。 虽然未来的版本将从外挂程式库访问它们，在短期内的外挂程式直接引用的 Url 作为 `<dependency>` 的标记。 他们的格式如下：

    <dependency id="com.plugin.id" url="https://github.com/myuser/someplugin" commit="428931ada3891801" subdir="some/path/here" />
    

*   `id`: 提供外挂程式的 ID。 它应该是全域唯一的并表示在反向域风格。 没有这些限制目前执行的而他们可能在将来。

*   `url`: 该外挂程式的 URL。这应引用一个 git 仓库，其中 plugman 试图克隆。

*   `commit`: 这是理解的`git 签出`任何 git 引用: 一个分支或标记的名称 (例如，`师父`， `0.3.1`) 或提交杂凑值 (例如， `975ddb228af811dd8bb37ed1dfd092a3d05295f9`).

*   `subdir`: 指定目标的外挂程式依赖存在作为 git 仓库的子目录。 这是有用的因为它允许存储库中包含几个相关的外挂程式，每个单独指定。

在将来，将会介绍版本限制，和一个外挂程式库会存在支援按名称而不是显式 Url 获取。

### 相对依赖项的路径

如果您将设置 `url` 的 `<dependency>` 标记到 `"."` ，并提供 `subdir` 、 依赖外挂程式安装从同一个本地或远端 git 资源库作为父外挂程式，指定 `<dependency>` 标记。

请注意， `subdir` 总是指定*根*的 git 资源库，不该父外挂程式的相对路径。 即使你安装的外挂程式与直接向它的本地路径，也是如此。 Plugman 发现 git 资源库的根目录，然后查找其他外挂程式从那里。

## *平台*元素

`<platform>`标记标识平台有关联的本机代码或需要对它们的设定档进行修改。 使用此规范的工具可以标识支援的平台和Cordova专案中安装代码。

无外挂程式 `<platform>` 标签被假定为只 JavaScript 的并因此可安装在所有的平台上。

平台标记示例：

    <platform name="android">
        <!-- android-specific elements -->
    </platform>
    <platform name="ios">
        <!-- ios-specific elements -->
    </platform>
    

所需 `name` 属性标识一个平台支援，将与该平台关联元素的子级。

平台名称应该是小写字母。平台名称，如任意选择，列出：

*   亚马逊 fireos
*   安卓系统
*   blackberry10
*   ios
*   wp8
*   windows8

## *原始程式码档*元素

`<source-file>`元素标识应安装到一个专案的可执行档的原始程式码。例子：

    <!-- android -->
    <source-file src="src/android/Foo.java"
                    target-dir="src/com/alunny/foo" />
    <!-- ios -->
    <source-file src="src/ios/CDVFoo.m" />
    <source-file src="src/ios/someLib.a" framework="true" />
    <source-file src="src/ios/someLib.a" compiler-flags="-fno-objc-arc" />
    

它支援以下属性：

*   `src`(必填): 相对于`plugin.xml`档的位置。 如果不能找到`src`档，plugman 停止和反转安装、 然后发出一个通知有关的问题，并在此与非零代码退出。

*   `target-dir`: 档应该将复制到其中，相对于Cordova专案的根目录的目录。 在实践中，这是最重要的是基于 JAVA 的平台上，在`com.alunny.foo`包中的档必须位于`com/alunny/美孚`目录内。 对于原始目录是不重要的平台，应忽略此属性。
    
    作为资产，如果`target``source-file`会覆盖现有的档，plugman 停止和反转安装，发出一个通知有关的问题，并退出非零代码。

*   `framework`(仅适用于 iOS): 如果设置为`true`，还将指定的档作为一个框架添加到专案。

*   `compiler-flags`(仅适用于 iOS): 如果设置，分配特定的原始档案中指定的编译器标志。

## *设定档*元素

标识要进行修改，在该档中修改应考虑的地方，和什么应修改基于 XML 的设定档。

与此元素修改测试过的两种档案类型是 `xml` 和 `plist` 的档。

`config-file`元素只允许您将新的儿童追加到 XML 文档树。孩子们在目的文件中要插入的 XML 文本。

XML 的的示例：

    <config-file target="AndroidManifest.xml" parent="/manifest/application">
        <activity android:name="com.foo.Foo" android:label="@string/app_name">
            <intent-filter>
            </intent-filter>
        </activity>
    </config-file>
    

例如 `plist` ：

    <config-file target="*-Info.plist" parent="CFBundleURLTypes">
        <array>
            <dict>
                <key>PackageName</key>
                <string>$PACKAGE_NAME</string>
            </dict>
        </array>
    </config-file>
    

它支援以下属性：

*   `target`:
    
    要修改档和Cordova专案根目录的相对路径。
    
    目标可以包括万用字元 (``*) 元素。在这种情况下，plugman 递回搜索专案目录结构，并使用第一场比赛。
    
    在 iOS，相对于专案目录的根设定档的位置不是知道，所以指定目标`config.xml`解析为`cordova-ios-project/MyAppName/config.xml`.
    
    如果指定的档不存在，该工具将忽略配置更改并继续安装。

*   `parent`: XPath 选择器引用父级的元素添加到设定档。 如果你使用绝对选择器，您可以使用万用字元 (``*) 来指定的根项目，例如， `/ * / 外挂程式`.
    
    `Plist`档，`父`确定应该在什么父项下插入指定的 XML。
    
    如果选择器不会解析为指定文档的一个孩子，工具停止和挫折安装过程中，会发出警告，并且具有非零代码退出。

*   `after`: 接受兄弟姐妹后要添加 XML 程式码片段的优先顺序的清单。 用于在需要严格排序的 XML 元素，如[HTTP://msdn.microsoft.com/en-us/library/windowsphone/develop/ff769509%28v=vs.105%29.aspx#BKMK_EXTENSIONSelement][1]的档中指定的变化

 [1]: http://msdn.microsoft.com/en-us/library/windowsphone/develop/ff769509%28v=vs.105%29.aspx#BKMK_EXTENSIONSelement

Windows 平台支援两个附加属性 （两个可选） 时影响 `package.appxmanifest` 元名称：

该 `device-target` 属性指示，只应包括，当生成指定的目标装置类型。 受支援的值是 `win`、 `phone` 或 `all`.

该 `versions` 属性指示特定的 Windows 版本的应用程式清单只应会被更改为指定的版本字串相匹配的版本。 值可以是任何有效的节点语义版本范围的字串。

使用这些视窗的特定属性的示例：

    <config-file target="package.appxmanifest" parent="/Package/Capabilities" versions="<8.1.0">
        <Capability Name="picturesLibrary" />
        <DeviceCapability Name="webcam" />
    </config-file>
    <config-file target="package.appxmanifest" parent="/Package/Capabilities" versions=">=8.1.0" device-target="phone">
        <DeviceCapability Name="webcam" />
    </config-file>
    

上面的示例中将设置预 8.1 平台 （Windows 8，具体），需要 `webcam` 装置功能和 `picturesLibrary` 的综合性能，而且 `webcam` 装置功能仅适用于 Windows 8.1 的专案生成为 Windows Phone。 Windows 桌面 8.1 系统是未被修改。

## *外挂程式-plist*元素

这是 *过时* 的因为它只适用于Cordova ios 2.2.0 和下面。Cordova的较新版本使用 `<config-file>` 标记。

示例:

    <config-file target="config.xml" parent="/widget/plugins">
        <feature name="ChildBrowser">
            <param name="ios-package" value="ChildBrowserCommand"/>
        </feature>
    </config-file>
    

指定的键和值追加到 iOS Cordova专案中的正确的 `AppInfo.plist` 档。举个例子：

    <plugins-plist key="Foo" string="CDVFoo" />
    

## *资源档*和*标头档*元素

像原始档案，而是专门负责 iOS 平台，区分原始档案、 标头档和资源。iOS 的例子：

    <resource-file src="CDVFoo.bundle" />
    <resource-file src="CDVFooViewController.xib" />
    <header-file src="CDVFoo.h" />
    

Android 的示例：

    <resource-file src="FooPluginStrings.xml" target="res/values/FooPluginStrings.xml" />
    

## *lib 档*元素

像源、 资源和标头档，而是专门负责平台 （如黑莓 10 的使用使用者生成的库。示例：

    <lib-file src="src/BlackBerry10/native/device/libfoo.so" arch="device" />
    <lib-file src="src/BlackBerry10/native/simulator/libfoo.so" arch="simulator" />
    

支援的属性：

*   `src`(必填): 相对于`plugin.xml`档的位置。 如果不能找到`src` ，plugman 停止和反转安装，具有非零代码问题有关的问题和出口的警告。

*   `arch`: 为`.so`档已经建成，`device`或`simulator`的体系结构.

对于 Windows 平台上，`<lib-file>` 元素允许 `< SDKReference >` 生成 Windows 专案档案中列入。

支援的属性：

*   `src`(必填): 的 SDK，包括名称 (这将用作生成的`< SDKReference >`元素`包含`属性的值)。

*   `arch`: 指示为指定的架构生成时只应包含`< SDKReference >` 。 受支援的值是 `x86` ， `x64` 或`ARM`.

*   `device-target`： 指示当生成指定的目标装置类型只应包含 `< SDKReference >`。 受支援的值是 `win` (或 `windows` )， `phone` 或`all`.

*   `versions`： 指示当生成指定的版本字串相匹配的版本只应包含 `< SDKReference >`。 值可以是任何有效的节点语义版本范围的字串。

例子:

    <lib-file src="Microsoft.WinJS.2.0, Version=1.0" arch="x86" />
    <lib-file src="Microsoft.WinJS.2.0, Version=1.0" versions=">=8.1" />
    <lib-file src="Microsoft.WinJS.2.0, Version=1.0" target="phone" />
    <lib-file src="Microsoft.WinJS.2.0, Version=1.0" target="win" versions="8.0" arch="x86" />
    

## *框架*元素

标识该外挂程式所依赖的框架 （通常的作业系统/平台的一部分）。

可选的`custom`属性是一个布林值，该值指示是否框架一种作为您的外挂程式档的一部分 (因此它不是一个系统框架)。

### iOS *framework*

    <framework src="libsqlite3.dylib" />
    <framework src="social.framework" weak="true" />
    <framework src="relative/path/to/my.framework" custom="true" />
    

可选的`weak`属性是一个布林值，该值指示是否应弱连结的框架。预设值为`false`.

### 安卓系统 *framework*

在 android 系统 (如 cordova-android@4.0.0)，*框架*标签用于包括 Maven 依赖关系，或包括捆绑的库专案。

例子:

    <!-- Depend on latest version of GCM from play services -->
    <framework src="com.google.android.gms:play-services-gcm:+" />
    <!-- Depend on v21 of appcompat-v7 support library -->
    <framework src="com.android.support:appcompat-v7:21+" />
    <!-- Depend on library project included in plugin -->
    <framework src="relative/path/FeedbackLib" custom="true" />
    

*framewokr*也可以用于有分纳入主要专案的.gradle 档的自订.gradle 档:

    <framework src="relative/path/rules.gradle" custom="true" type="gradleReference" />
    

为 pre-android@4.0.0 (基于 ANT 的专案):

可选的`type`属性是一个字串，指示框架添加的类型。 目前，只有`projectReference`支援并且仅用于 Windows。 使用`custom='true'`和`type='projectReference'`将引用添加到专案，将被添加到编译 + 连结Cordova专案的步骤。 这基本上是目前唯一的方式，'custom' 的框架可以针对多个体系结构，因为他们作为一种依赖由显式引用Cordova应用程式。

可选的`parent`将相对路径设置为包含要向其增加参考的子专案的目录。 预设值是`.`，即应用程式专案。 它允许添加像在此示例中的子专案之间的引用:

    <framework src="extras/android/support/v7/appcompat" custom="false" parent="FeedbackLib" />
    

### *framework*视窗

Windows 平台支援三个附加属性 (所有可选) 精炼时框架应包括:

    <framework src="path/to/project/LibProj.csproj" custom="true" type="projectReference"/>
    

该`arch`属性指示时为指定的建筑建设只应包括框架。 受支援的值是 `x86`、`x64` 或 `ARM`.

该`device-target`属性指示当生成指定的目标装置类型后，应该只能包含框架。 受支援的值是 `win` （或 `windows`），`phone` 或 `all`.

该`versions`属性指示框架只应包括当生成指定的版本字串相匹配的版本。 值可以是任何有效的节点语义版本范围的字串。

使用这些 Windows 特定属性的示例:

    <framework src="src/windows/example.dll" arch="x64" />
    <framework src="src/windows/example.dll" versions=">=8.0" />
    <framework src="src/windows/example.vcxproj" type="projectReference" target="win" />
    <framework src="src/windows/example.vcxproj" type="projectReference" target="all" versions="8.1" arch="x86" />
    

## *资讯*元素

向使用者提供的其他资料。当你需要额外的步骤，不能很容易自动或超出 plugman 的范围时，这非常有用。 例子:

    <info>
    You need to install __Google Play Services__ from the `Android Extras` section using the Android SDK manager (run `android`).
    
    You need to add the following line to the `local.properties`:
    
    android.library.reference.1=PATH_TO_ANDROID_SDK/sdk/extras/google/google_play_services/libproject/google-play-services_lib
    </info>
    

## *hook*元素

表示您自订的脚本，将调用由Cordova发生某些操作时 (例如，添加外挂程式或平台编写逻辑之后调用)。 当您需要扩展预设Cordova功能时，这很有用。 更多的资讯，请参阅挂钩的指南。

    <hook type="after_plugin_install" src="scripts/afterPluginInstall.js" />
    

## 变数

在某些情况下，外挂程式可能需要进行配置更改依赖于目标应用程式。 例如，若要注册为 C2DM 在 Android 上，其包 id 是`com.alunny.message`的应用程式还将如需要许可权:

    <uses-permission android:name="com.alunny.message.permission.C2D_MESSAGE"/>
    

在插入从`plugin.xml`档的内容不事先知道这种情况下，可以由一个货币符号进行一系列的大写英文字母，数位或底线表示变数。 对于上面的示例中， `plugin.xml`档将包括此标记:

    <uses-permission android:name="$PACKAGE_NAME.permission.C2D_MESSAGE"/>
    

plugman 变数引用替换为指定的值或空字串，如果没有找到。 可能检测到 (在这种情况下，从`AndroidManifest.xml`档) 或工具; 使用者指定的变数引用的值确切的过程是依赖于特定的工具。

plugman 可以要求使用者指定一个外挂程式所需的变数。例如，C2M 和谷歌地图的 API 金钥可以指定为一个命令列参数:

    plugman --platform android --project /path/to/project --plugin name|git-url|path --variable API_KEY=!@CFATGWE%^WGSFDGSDFW$%^#$%YTHGsdfhsfhyer56734
    

为了使变数成为强制性， `<platform>`标记需要包含`<preference>`标记。例如:

    <preference name="API_KEY" />
    

plugman 检查中通过的这些所需的首选项。 如果不是，它应该警告使用者如何传递中的变数和以非零代码退出。

应保留某些变数的名称，如下所示。

## $PACKAGE_NAME

反向功能变数名称风格包的对应于`CFBundleIdentifier`对 iOS 或`AndroidManifest.xml`档中的顶级`表现`元素的`包`属性的唯一识别码。