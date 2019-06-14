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

本指南演示如何修改 Android 专案从Cordova的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 命令列介面资讯，请参阅如何更新的 CLI 版本。

## 从 3.2.0 升级到 3.3.0

遵循相同的 instructinos`3.2.0`.

从 3.3.0 开始，Cordova运行时是现在作为编译 Android 的库，而不是 Jar。 这都不应该影响对于命令列用法，但 IDE 使用者将需要导入到新添加的 `MyProject-CordovaLib` 到其工作区中的专案。

## 从 3.1.0 升级到 3.2.0

为创建的Cordova CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update android`

对于不使用 CLI Cordova创建的专案，请运行：

        bin/update <project_path>
    

## 从 3.0.0 升级到 3.1.0

为创建的Cordova CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update android`

对于不使用 CLI Cordova创建的专案，请运行：

        bin/update <project_path>
    

## 从 2.9.0 升级到 CLI （3.0.0)

1.  创建新的 Apache Cordova 3.0.0 专案使用 CLI，Cordova，如所述的命令列介面。

2.  添加您的平台的Cordova专案，例如：`cordova
platform add android`.

3.  您的专案的内容复写 `www` 到目录 `www` 目录在您刚刚创建的Cordova专案的根目录。

4.  将本机的任何资产从旧专案复制到相应的目录下 `platforms/android` ： 此目录是您的本机Cordova android 专案存在的地方。

5.  使用Cordova CLI 工具来安装您需要的任何外挂程式。请注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

## 从 2.9.0 升级到 3.0.0

1.  创建一个新的 Apache Cordova Android 专案。

2.  将复制的内容你 `www` 目录到新的专案。

3.  复制任何本机的 Android 资产从您 `res` 目录到新的专案。

4.  复制在你安装从任何外挂程式 `src` 子目录到新专案。

5.  请确保要升级任何弃用 `<plugin>` 从你的旧的引用 `config.xml` 到新档 `<feature>` 规范。

6.  更新对任何引用 `org.apache.cordova.api` 包被`org.apache.cordova`.
    
    **注**： 所有核心 Api 已被移除，必须作为外挂程式安装。请有关详细资讯，参阅管理外挂程式指南的使用 Plugman。

## 从 2.8.0 升级到 2.9.0

1.  运行`bin/update <project_path>`.

## 从 2.7.0 升级到 2.8.0

1.  删除 `cordova-2.7.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.8.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

<!-- SS Eclipse -->

1.  复制新 `cordova.js` 到您的专案。

2.  更新您的 html 代码，使用新的 `cordova.js` 档。

3.  复制 `res/xml/config.xml` 档，以匹配`framework/res/xml/config.xml`.

4.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

5.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.6.0 升级到 2.7.0

1.  删除 `cordova-2.6.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.7.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.7.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.7.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.5.0 升级到 2.6.0

1.  删除 `cordova-2.5.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.6.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.6.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.6.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

运行 `bin/update <project>` 的专案路径与Cordova原始目录中列出。

## 从 2.4.0 升级到 2.5.0

1.  删除 `cordova-2.4.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.5.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.5.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.5.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  更新 `framework/res/xml/config.xml` 以前一样有类似的设置。

8.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.3.0 升级到 2.4.0

1.  删除 `cordova-2.3.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.4.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.4.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.4.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.2.0 升级到 2.3.0

1.  删除 `cordova-2.2.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.3.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.3.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.3.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.1.0 升级到 2.2.0

1.  删除 `cordova-2.1.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.2.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.2.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.2.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 2.0.0 升级到 2.1.0

1.  删除 `cordova-2.0.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.1.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.1.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.1.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

7.  将档从复制 `bin/templates/cordova` 到专案中的 `cordova` 目录。

## 从 1.9.0 升级到 2.0.0

1.  删除 `cordova-1.9.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-2.0.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-2.0.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-2.0.0.js` 档。

6.  复制 `res/xml/config.xml` 以匹配`framework/res/xml/config.xml`.

在 2.0.0 版、 `config.xml` 档结合和替换 `cordova.xml` 和 `plugins.xml` 。 旧的档已被否决，，虽然他们仍工作在 2.0.0，将停止在将来的版本中工作。

## 从 1.8.1 升级到 1.9.0

1.  删除 `cordova-1.8.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.9.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.9.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.9.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

由于采用了 `CordovaWebView` 的 1.9.0 版本中，协力厂商外挂程式可能无法工作。 这些外挂程式需要获取上下文从 `CordovaInterface` 使用 `getContext()` 或 `getActivity()` 。 如果您不是一个经验丰富的 Android 开发者，请联系外挂程式的维护者和将这项任务添加到其 bug 跟踪工具。

## 从 1.8.0 升级到 1.8.0

1.  删除 `cordova-1.8.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.8.1.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.8.1.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.8.1.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.7.0 升级到 1.8.0

1.  删除 `cordova-1.7.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.8.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.8.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.8.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.7.0 升级到 1.8.0

1.  删除 `cordova-1.7.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.8.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.8.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.8.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.6.1 升级到 1.7.0

1.  删除 `cordova-1.6.1.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.7.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.7.0.js` 到您的专案。

5.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.6.0 升级到 1.6.1

1.  删除 `cordova-1.6.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.6.1.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.6.1.js` 到您的专案。

5.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 1.5.0 版升级到 1.6.0

1.  删除 `cordova-1.5.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.6.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.6.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.6.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  替换 `res/xml/phonegap.xml` 与 `res/xml/cordova.xml` 进行匹配`framework/res/xml/cordova.xml`.

## 从 1.4.0 升级到 1.5.0 版

1.  删除 `phonegap-1.4.0.jar` 从专案的 `libs` 目录。

2.  添加 `cordova-1.5.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `cordova-1.5.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `cordova-1.5.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  替换 `res/xml/phonegap.xml` 与 `res/xml/cordova.xml` 进行匹配`framework/res/xml/cordova.xml`.

## 从 1.3.0 升级到 1.4.0

1.  删除 `phonegap-1.3.0.jar` 从专案的 `libs` 目录。

2.  添加 `phonegap-1.4.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `phonegap-1.4.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `phonegap-1.4.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 以匹配`framework/res/xml/phonegap.xml`.

## 从 1.2.0 升级到 1.3.0

1.  删除 `phonegap-1.2.0.jar` 从专案的 `libs` 目录。

2.  添加 `phonegap-1.3.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `phonegap-1.3.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `phonegap-1.2.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 以匹配`framework/res/xml/phonegap.xml`.

## 从 1.1.0 升级到 1.2.0

1.  删除 `phonegap-1.1.0.jar` 从专案的 `libs` 目录。

2.  添加 `phonegap-1.2.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `phonegap-1.2.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `phonegap-1.2.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

7.  更新 `res/xml/phonegap.xml` 以匹配`framework/res/xml/phonegap.xml`.

## 从 1.0.0 升级到 1.1.0

1.  删除 `phonegap-1.0.0.jar` 从专案的 `libs` 目录。

2.  添加 `phonegap-1.1.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `phonegap-1.1.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `phonegap-1.1.0.js` 档。

6.  更新 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.

## 从 0.9.6 升级到 1.0.0

1.  删除 `phonegap-0.9.6.jar` 从专案的 `libs` 目录。

2.  添加 `phonegap-1.0.0.jar` 到专案中的 `libs` 目录。

3.  如果您使用 Eclipse，请刷新您的 Eclipse 专案，做清洁。

4.  复制新 `phonegap-1.0.0.js` 到您的专案。

5.  更新您的 html 代码，使用新的 `phonegap-1.0.0.js` 档。

6.  添加 `res/xml/plugins.xml` 以匹配`framework/res/xml/plugins.xml`.