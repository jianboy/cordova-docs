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

title: 平台和外挂程式版本管理
toc_title: Manage versions and platforms
---

# 平台和外挂程式版本管理

从版 4.3.0 开始，科尔多瓦提供保存和还原平台和外挂程式的能力。

此功能允许开发人员保存，并将他们的应用程式还原到已知状态，而无需检查在所有的平台和外挂程式的原始程式码。

保存命令在 config.xml 中存储应用程式的平台和外挂程式版本的详细资讯。 '还原' 一步会自动发生**'cordova prepare'**发出，制作时使用以前保存的 config.xml 档中的资讯。

在哪里保存/恢复功能派上用场的一个方案是在处理一个应用程式，专注于一个平台或者外挂程式每个团队成员的大型团队。 此功能很容易地共用专案和减少冗余检查存储库中的代码的数量。

## 平台版本控制

### 储蓄的平台

若要保存一个平台，你可以发出以下命令:

    $ cordova platform add <platform[@<version>] | directory | git_url> --save
    

运行上述命令后，由此产生的 config.xml 看起来像:

    <?xml version='1.0' encoding='utf-8'?>
        ...
        <engine name="android" spec="~4.0.0" />
        ...
    </xml>
    

一些例子:

  * **'cordova platform add android --save'** => 检索固定的版本的 android 平台，将其添加到该专案，然后更新 config.xml。
  * **'cordova platform add android@3.7.0 --save'** => 检索 android 平台上，从新公共管理，版本 3.7.0 将它添加到专案，然后更新 config.xml。
  * **'cordova platform add android@https://github.com/apache/cordova-android.git​ --save'** => 克隆指定的科尔多瓦 android git 仓库，将 android 平台添加到专案中，然后更新 config.xml 并指向指定的 git url 及其版本。
  * **cordova platform add C:/path/to/android/platform --save** => 从指定的目录中检索的 android 平台，将其添加到专案中，然后更新 config.xml 和指向的目录。

### 保存对现有专案的平台的大众

'--save' 上文所述的旗帜只是有用的你只要记得使用平台添加期间。 如果你有一个预先存在的专案，并且您想要保存您的专案中的所有当前添加的平台，您可以使用:

    $ cordova platform save
    

### 更新/删除平台

它也是可能更新或删除从 config.xml 命令 '科尔多瓦平台更新' 和 '科尔多瓦平台删除' 期间:

    $ cordova platform update <platform[@<version>] | directory | git_url> --save
    $ cordova platform remove <platform> --save
    

一些例子:

  * 除了到固定的版本，更新 config.xml 条目更新 android 平台**'cordova platform update android --save'** =>
  * 除了 android 平台更新到版本 3.8.0，更新 config.xml 条目**'cordova platform update android@3.8.0 --save'** =>
  * 除了 android 平台更新到版本更新资料夹，更新 config.xml 条目中**'cordova platform update /path/to/android/platform --save'** =>
  * =>**'cordova platform remove android --save'**从专案中移除的 android 平台，从 config.xml 中删除其专案。

### 恢复平台

**'cordova prepare'**命令运行时，将会从 config.xml 自动还原平台。

如果没有指定版本的资料夹/git_url 中添加一个平台，要安装的版本取自 config.xml，**如果发现**.

示例:

假设您的 config.xml 档包含以下项:

    <?xml version='1.0' encoding='utf-8'?>
        ...
        <engine name="android" spec="3.7.0" />
        ...
    </xml>
    

< / xml > 如果你运行命令**'cordova platform add android'** (没有版本/资料夹/git_url 指定)，将安装平台 'android@3.7.0' (如从 config.xml 中检索)。

* * *

## 外挂程式版本控制

*(外挂程式命令是外挂程式命令镜像)*

### 保存外挂程式

若要保存外挂程式，您可以发出以下命令:

    $ cordova plugin add <plugin[@<version>] | directory | git_url> --save
    

运行上述命令后，由此产生的 config.xml 看起来像:

    <?xml version='1.0' encoding='utf-8'?>
        ...
        <plugin name="cordova-plugin-console" spec="~1.0.0" />
        ...
    </xml>
    

一些例子:

  * => **'cordova plugin add cordova-plugin-console --save'**检索固定的版本的主控台外挂程式，将其添加到该专案，然后更新 config.xml。
  * **cordova plugin add cordova-plugin-console@0.2.13 --save** => 检索 android 外挂程式，版本 0.2.13 从新公共管理，将其添加到该专案，然后更新 config.xml。
  * => **'cordova plugin add https://github.com/apache/cordova-plugin-console.git --save'**克隆指定的主控台外挂程式 git 仓库、 将主控台外挂程式添加到该专案，然后更新 config.xml 和指向指定的 git url 及其版本。
  * **cordova plugin add C:/path/to/console/plugin --save**=> 从指定的目录中检索该主控台外挂程式，将其添加到专案中，然后更新 config.xml 和指向的目录。

### 大众在现有专案保存外挂程式

'--save' 上文所述的旗帜只是有用的你只要记得使用外挂程式添加期间。 如果你有一个预先存在的专案，并且您想要保存所有当前专案中添加的外挂程式，您可以使用:

    $ cordova plugin save
    

### 更新/删除外挂程式

它也是可能更新或删除从 config.xml 命令 '科尔多瓦外挂程式更新' 和 '科尔多瓦外挂程式删除' 期间:

    $ cordova plugin update <plugin[@<version>] | directory | git_url> --save
    $ cordova plugin remove <plugin> --save
    

一些例子:

  * 除了到固定的版本，更新 config.xml 条目更新主控台外挂程式**'cordova plugin update cordova-plugin-console --save'** =>
  * 除了 android 外挂程式更新到版本 3.8.0，更新 config.xml 条目**'cordova plugin update cordova-plugin-console@0.2.13 --save'** =>
  * 除了更新到版本资料夹，更新 config.xml 条目中的主控台外挂程式**'cordova plugin update /path/to/console/plugin --save'** =>
  * =>**'cordova plugin remove cordova-plugin-console --save'**从专案中移除该主控台外挂程式和从 config.xml 中删除它的条目。

### 恢复外挂程式

从 config.xml 的外挂程式会自动复原， **'cordova prepare'**命令运行时。

如果没有指定版本的资料夹/git_url 添加一个外挂程式，要安装的版本取自 config.xml，**如果发现**.

示例:

假设您的 config.xml 档包含以下项:

    <?xml version='1.0' encoding='utf-8'?>
        ...
        <plugin name="cordova-plugin-console" spec="0.2.11" />
        ...
    </ xml>
    

< / xml > 如果你运行命令**'cordova plugin add cordova-plugin-console'** (没veresion/folder/git_url 指定)，将安装该外挂程式 'cordova-plugin-console@0.2.11' (如从 config.xml 中检索)。