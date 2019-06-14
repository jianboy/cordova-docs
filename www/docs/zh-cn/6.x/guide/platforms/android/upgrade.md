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

title: 升级 Android
---

# 升级 Android

本指南演示如何修改 Android 专案从Cordova的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 资讯，请参阅命令列介面如何更新的 CLI 版本。

## 升级到 4.0.0

有利用 4.0.0 的重大变化所需的特定升级步骤。第一，常见的升级步骤，如下所示。

对于非 CLI 专案，运行:

        bin/update path/to/project
    

对于 CLI 专案:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  在你现有的专案中运行 `cordova platform update android`。

### 升级白名单

现在通过外挂程式实现所有的白名单功能。 无外挂程式升级到 4.0.0 后您的应用程式不再却是白名单的保护。Cordova有两个白名单外挂程式，提供不同的保护层级。

1.  `cordova-plugin-whitelist` 外挂程式 *（推荐）*
    
    *   这个外挂程式被推荐的是更加安全和可配置比在以前的版本中白
    *   在所需的配置更改上看到 [cordova-plugin-whitelist][1] 的详细资讯
    *   兼营： `cordova plugin add cordova-plugin-crosswalk-webview`

2.  `cordova-plugin-legacy-whitelist` 外挂程式
    
    *   这个外挂程式提供了相同的白名单中行为，作为以前的版本。请参阅 [cordova-plugin-legacy-whitelist][2]
    *   没有配置更改是必需的但它提供了比推荐外挂程式的保护较少
    *   兼营： `cordova-plugin-legacy-whitelist`

 [1]: https://github.com/apache/cordova-plugin-whitelist
 [2]: https://github.com/apache/cordova-plugin-legacy-whitelist

### 使用人行横道上 web 视图

预设情况下，您的应用程式将继续使用 web 视图提供的设备的系统。如果你想要改用人行横道上 web 视图，只需添加人行横道上的外挂程式：

    cordova plugin add cordova-plugin-crosswalk-webview
    

后添加的外挂程式，您的应用程式会得到人行横道上 web 视图正确安装和配置。

### 升级到闪屏外挂程式

如果您的应用程式使用一个闪屏功能已被转移到一个外挂程式。 用于初始萤幕的配置选项是不变的。 所需的只有升级步骤是要添加的外挂程式：

    cordova plugin add cordova-plugin-splashscreen
    

## 从 3.6.0 版升级到 3.7.1

对于非 CLI 专案，运行:

        bin/update path/to/project
    

对于 CLI 专案:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行 `cordova platform update android` 在你现有的专案中。

## 从 3.2.0 升级到 3.3.0

按照关于 `3.2.0` 相同的说明.

入手 3.3.0，Cordova运行时现在被编译为 Android 的库，而不是一个罐子里。 这都不应该影响为命令列用法，但 IDE 使用者将需要新增的 `MyProject CordovaLib` 专案导入到他们的工作区。

## 从 3.1.0 升级到 3.2.0

为专案创建的Cordova CLI:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行 `cordova platform update android`

不创建与Cordova CLI 的专案，请运行:

        bin/update <project_path>
    

**警告：**关于 Android 4.4-Android 4.4.3，创建档输入具有类型的元素 ="档"将不会打开档选取器对话方块。 这是铬对 Android 的回归和能重现该问题在 Android 上独立 Chrome 浏览器 （见 HTTP://code.google.com/p/android/issues/detail?id=62220） 建议的解决方法是使用的档案传输和档的外挂程式为 Android 4.4。您可以侦听 onClick 事件从输入类型 ="档"，然后弹出一个档选择器 UI。 为了打领带表单资料的上传，你可以使用 JavaScript 将表单值附加到多个部分的 POST 请求所使。

## 从 3.0.0 升级到 3.1.0

为专案创建的Cordova CLI:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行 `cordova platform update android`

不创建与Cordova CLI 的专案，请运行:

        bin/update <project_path>
    

## 从 2.9.0 升级到 CLI (3.0.0)

1.  创建一个新的 Apache Cordova 3.0.0 专案使用 CLI，Cordova在命令列介面所述。

2.  添加您的平台的Cordova的专案，例如： `cordova platform add android`.

3.  将您的专案 `www` 目录中的内容复写到您刚刚创建的Cordova专案根本 `www` 目录。

4.  将本机的任何资产从旧专案复制到相应的目录下 `平台/android`： 此目录是您的本机Cordova android 专案所在。

5.  使用Cordova CLI 工具来安装您需要的任何外挂程式。注意，CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

## 从 2.9.0 升级到 3.0.0

1.  创建一个新的 Apache Cordova Android 专案。

2.  将 `www` 目录中的内容复写到新专案中。

3.  将任何原生的 Android 资产从 `res` 目录复写到新的专案。

4.  复制您安装到新专案的 `src` 子目录中的任何外挂程式。

5.  请务必升级任何弃用 `<plugin>` 从你旧的 `config.xml` 档到新的 `<feature>` 规范的引用。

6.  更新到 `org.apache.cordova.api` 包是 `org.apache.cordova` 的任何引用.
    
    **注**： 所有的核心 Api 已被删除，并且必须作为外挂程式安装。请有关详细资讯，参阅使用 Plugman 管理外挂程式指南。

## 从 2.8.0 升级到 2.9.0

1.  运行 `bin/update <project_path>`.

## 从 2.7.0 升级到 2.8.0

1.  从专案的 `libs` 目录删除 `cordova-2.7.0.jar`。

2.  将 `cordova-2.8.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

<!-- SS Eclipse -->

1.  将新的 `cordova.js` 复制到您的专案。

2.  更新你的 html 代码，使用新的 `cordova.js` 档。

3.  要匹配 `framework/res/xml/config.xml` 的 `res/xml/config.xml` 档的副本.

4.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

5.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 2.6.0 升级到 2.7.0

1.  从专案的 `libs` 目录删除 `cordova-2.6.0.jar`。

2.  将 `cordova-2.7.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-2.7.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.7.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 2.5.0 升级到 2.6.0

1.  从专案的 `libs` 目录删除 `cordova-2.5.0.jar`。

2.  将 `cordova-2.6.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.6.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.6.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

Cordova原始目录中列出的专案路径与运行 `bin/update < 专案 >`。

## 从 2.4.0 升级到 2.5.0

1.  从专案的 `libs` 目录删除 `cordova-2.4.0.jar`。

2.  将 `cordova-2.5.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.5.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.5.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 2.3.0 升级到 2.4.0

1.  从专案的 `libs` 目录删除 `cordova-2.3.0.jar`。

2.  将 `cordova-2.4.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.4.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.4.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.2.0 升级到 2.3.0

1.  从专案的 `libs` 目录删除 `cordova-2.2.0.jar`。

2.  将 `cordova-2.3.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.3.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.3.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 2.1.0 升级到 2.2.0

1.  从专案的 `libs` 目录删除 `cordova-2.1.0.jar`。

2.  将 `cordova-2.2.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.2.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.2.0.js` 档。

6.  复制 `res/xml/config.xml` 相匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 2.0.0 升级到 2.1.0

1.  从专案的 `libs` 目录删除 `cordova-2.0.0.jar`。

2.  将 `cordova-2.1.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.1.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.1.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案的 `cordova` 目录。

## 从 1.9.0 升级到 2.0.0

1.  从专案的 `libs` 目录删除 `cordova-1.9.0.jar`。

2.  将 `cordova-2.0.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.0.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-2.0.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

在 2.0.0 释放，`config.xml` 档相结合，并取代了 `cordova.xml` 和 `plugins.xml`。 旧的档已被否决，和当他们仍然在 2.0.0，工作就会停止工作在将来的版本中。

## 从 1.8.1 升级到 1.9.0

1.  从专案的 `libs` 目录删除 `cordova-1.8.0.jar`。

2.  将 `cordova-1.9.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-1.9.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.9.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

由于引入了 `CordovaWebView` 在 1.9.0 释放，协力厂商外挂程式可能无法工作。 这些外挂程式需要从 `CordovaInterface` 使用 `getContext()` 或 `getActivity()` 获取上下文。 如果你不是一个经验丰富的 Android 开发者，请联系外挂程式的维护者，并将该任务添加到其 bug 追踪器。

## 从 1.8.0 升级到 1.8.0

1.  从专案的 `libs` 目录删除 `cordova-1.8.0.jar`。

2.  将 `cordova-1.8.1.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-1.8.1.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.8.1.js` 档。

6.  更新 `res/xml/plugins.xml` 相匹配`framework/res/xml/plugins.xml`.

## 从 1.7.0 以来升级到 1.8.0

1.  从专案的 `libs` 目录删除 `cordova-1.7.0.jar`。

2.  将 `cordova-1.8.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.8.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.8.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.7.0 以来升级到 1.8.0

1.  从专案的 `libs` 目录删除 `cordova-1.7.0.jar`。

2.  将 `cordova-1.8.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.8.0.js` 到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.8.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.6.1 升级到 1.7.0 以来

1.  从专案的 `libs` 目录删除 `cordova-1.6.1.jar`。

2.  将 `cordova-1.7.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案和做清洁。

4.  将新的 `cordova-1.7.0.js` 复制到您的专案。

5.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.6.0 升级到 1.6.1

1.  从专案的 `libs` 目录删除 `cordova-1.6.0.jar`。

2.  将 `cordova-1.6.1.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-1.6.1.js` 复制到您的专案。

5.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.5.0 版升级到 1.6.0

1.  从专案的 `libs` 目录删除 `cordova-1.5.0.jar`。

2.  将 `cordova-1.6.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-1.6.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.6.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  替换 `res/xml/cordova.xml` 以匹配 `framework/res/xml/cordova.xml` `res/xml/phonegap.xml`.

## 从 1.4.0 升级到 1.5.0 版

1.  从专案的 `libs` 目录删除 `phonegap-1.4.0.jar`。

2.  将 `cordova-1.5.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新的 `cordova-1.5.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `cordova-1.5.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  替换 `res/xml/cordova.xml` 以匹配 `framework/res/xml/cordova.xml` `res/xml/phonegap.xml`.

## 从 1.3.0 升级到 1.4.0

1.  从专案的 `libs` 目录删除 `phonegap-1.3.0.jar`。

2.  将 `phonegap-1.4.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新 `phonegap-1.4.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `phonegap-1.4.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 相匹配`framework/res/xml/phonegap.xml`.

## 从 1.2.0 升级到 1.3.0

1.  从专案的 `libs` 目录删除 `phonegap-1.2.0.jar`。

2.  将 `phonegap-1.3.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  将新 `phonegap-1.3.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `phonegap-1.2.0.js` 档。

6.  更新 `res/xml/plugins.xml` 相匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 以匹配`framework/res/xml/phonegap.xml`.

## 请升级到 1.2.0 从 1.1.0

1.  从专案的 `libs` 目录删除 `phonegap-1.1.0.jar`。

2.  将 `phonegap-1.2.0.jar` 添加到专案的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案和做清洁。

4.  将新 `phonegap-1.2.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `phonegap-1.2.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 以匹配`framework/res/xml/phonegap.xml`.

## 从 1.0.0 升级到 1.1.0

1.  从专案的 `libs` 目录删除 `phonegap-1.0.0.jar`。

2.  将 `phonegap-1.1.0.jar` 添加到专案的 `libs` 目录。

3.  如果你使用 Eclipse，请刷新您的 Eclipse 专案和做清洁。

4.  将新 `phonegap-1.1.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `phonegap-1.1.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 0.9.6 升级到 1.0.0

1.  从专案的 `libs` 目录删除 `phonegap-0.9.6.jar`。

2.  将 `phonegap-1.0.0.jar` 添加到专案的 `libs` 目录。

3.  如果你使用 Eclipse，请刷新您的 Eclipse 专案和做清洁。

4.  将新 `phonegap-1.0.0.js` 复制到您的专案。

5.  更新你的 html 代码，使用新的 `phonegap-1.0.0.js` 档。

6.  添加 `res/xml/plugins.xml` 以匹配 `framework/res/xml/plugins.xml`.