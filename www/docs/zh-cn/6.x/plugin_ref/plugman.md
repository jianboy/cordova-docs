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

title: 使用 Plugman 来管理外挂程式
toc_title: Use Plugman
---

# 使用 Plugman 来管理外挂程式

从 3.0 版本开始，科尔多瓦实现所有设备 Api 作为外挂程式，然后留在预设情况下禁用。 此外，它还支援两种不同的方法来添加和删除外挂程式，根据您的工作流概述中讨论的选择：

*   如果您使用跨平台的工作流，则使用 `cordova` CLI 实用程式添加外挂程式，如所述的命令列介面。 CLI 一次修改所有指定平台的外挂程式。

*   如果你使用的平台为中心的工作流程，您使用一个较低级别的[Plugman][1]命令列介面，分别为每个目标平台。

 [1]: https://github.com/apache/cordova-plugman/

本节详细介绍的 Plugman 实用程式。 消费作为节点模组 Plugman 或修改的原始程式码的详细资讯，请参阅[其库中的读我档案][2].

 [2]: https://github.com/apache/cordova-plugman/blob/master/README.md

## 安装 Plugman

要安装 plugman，您必须在您的机器上安装的[节点][3]。 然后您可以运行下面的命令从任意位置在您的环境以全域，安装 plugman，这样就可从任何目录中：

 [3]: http://nodejs.org/

    $ npm install -g plugman
    

您还必须有有 `git` 上你 `PATH` ，以便能够直接从远端 git Url 安装的外挂程式。

**提示**： 如果您在安装与 plugman 后发现 `npm` 你是仍然不能运行任何 `plugman` 的命令，请确保您已添加 `/npm/` 目录到您`PATH`.

**注**： 您可以跳过此步骤，如果你不想污染您的全球性 `npm` 通过全球范围内安装 Plugman 的命名空间。 如果这种情况，然后当你与外壳工具创建科尔多瓦专案，将有 `node_modules` 目录里面您的专案包含 Plugman。 由于全球范围内你没有安装，您需要调用 `node` 的每个 Plugman 命令，例如 `node
./node_modules/plugman/main.js -version` 。 本指南的其余部分假定您已安装 Plugman 就全球而言，意味著您可以调用它与只是`plugman`.

## 创建一个专案，科尔多瓦

您可以使用 Plugman 之前，您必须创建一个科尔多瓦专案。 你可以用命令列介面或更低的级别的 shell 脚本。 使用 shell 脚本来创建您的专案的说明都位于平台指南页上列出的各项"命令列工具"指南。

## 添加外挂程式

一旦你已经安装了 Plugman，并已创建一个科尔多瓦专案，您可以开始将外挂程式添加到与平台：

    $ plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin <name|url|path> [--plugins_dir <directory>] [--www <directory>] [--variable <name>=<value> [--variable <name>=<value> ...]]
    

使用最小的参数，此命令将外挂程式安装到科尔多瓦的一个专案。 您必须指定一个为该平台的平台和科尔多瓦的专案位置。 此外必须指定与不同的外挂程式， `--plugin` 参数形式是：

*   `name`： 目录名称外挂程式内容存在的地方。 这必须是现有目录下的 `--plugins_dir` 路径 （见下面的详细资讯） 或一个外挂程式在科尔多瓦注册表中的。
*   `url`： URL 以 HTTPs:// 或 git 开始： / / 指向一个有效 git 存储库，是复本，包含 `plugin.xml` 档。 这个资料库的内容将复制到`--plugins_dir`.
*   `path`： 目录包含一个有效的外挂程式，其中包括路径 `plugin.xml` 档。此路径的内容将被覆制到`--plugins_dir`.

其他参数：

*   `--plugins_dir`预设值为 `<project>/cordova/plugins` ，但可以为每个包含子目录中任何目录获取外挂程式。
*   `--www`预设值为专案的 `www` 资料夹的位置，但可以作为科尔多瓦专案应用程式 web 资产使用的任何目录。
*   `--variable`允许指定某些变数在安装时，有必要对某些外挂程式需要 API 金钥或其他自订的使用者定义的参数。 请[外挂程式规范][4]的详细资讯，参阅。

 [4]: plugin_ref_spec.md.html#Plugin%20Specification

## 删除某个外挂程式

若要卸载外挂程式，你只需通过 `--uninstall` 标记，并提供外挂程式 id。

    $ plugman --uninstall --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin <id> [--www <directory>] [--plugins_dir <directory>]
    

## 说明命令

Plugman 特色全球说明命令，可以说明你如果你卡住或遇到的问题。它将显示所有可用的 Plugman 命令和它们的语法的清单：

    plugman -help
    plugman  # same as above
    

**注**： `plugman -help` 可能会显示一些额外的与注册表相关的命令。 这些命令用于外挂程式开发人员，不可能进行协力厂商外挂程式登记处。

您还可以将追加 `--debug|-d` 旗子到任何 Plugman 命令以运行该命令以详细模式，将显示任何内部调试消息，因为他们排放和可说明您跟踪下像缺少档的问题。

    # Adding Android battery-status plugin to "myProject":
    plugman -d --platform android --project myProject --plugin cordova-plugin-battery-status
    

最后，您可以使用 `--version|-v` 标志来查看您使用哪个版本的 Plugman。

    plugman -v
    

## 注册表操作

那里有很多的 plugman 命令，可以用于与[外挂程式注册表][5]进行交互。 请注意这些注册表命令是特定于*plugins.cordova.io*外挂程式注册表，不可能由协力厂商外挂程式登记处执行。

 [5]: http://plugins.cordova.io

### 寻找一个外挂程式

您可以使用 Plugman 来搜索[外挂程式注册表][5]外挂程式 id 的匹配给定以空格分隔的关键字清单。

    plugman search <plugin keywords>
    

### 更改外挂程式注册表

您可以获取或设置当前外挂程式注册表的 URL，使用的 plugman。通常你应该离开这在 HTTP://registry.cordova.io 设置，除非您想要使用协力厂商外挂程式注册表。

    plugman config set registry <url-to-registry>
    plugman config get registry
    

### 获取外挂程式的资讯

您可以获得有关任何特定外挂程式在外挂程式库中存储的资讯：

    plugman info <id>
    

这将联系的外挂程式注册表和提取资讯，如外挂程式的版本编号。

## 安装核心外挂程式

下面的示例显示如何添加外挂程式，如需要，这样您在您的专案中使用任何科尔多瓦 Api 仍然工作后你升级到 3.0 版本。对于每个命令，你需要选择目标平台，并引用该平台的专案目录。

*   cordova-plugin-battery-status
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-battery-status`

*   cordova-plugin-camera
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-camera`

*   cordova-plugin-console
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-console`

*   cordova-plugin-contacts
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-contacts`

*   cordova-plugin-device
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-device`

*   cordova-plugin-device-motion (accelerometer)
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-device-motion`

*   cordova-plugin-device-orientation (compass)
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-device-orientation`

*   cordova-plugin-dialogs
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-dialogs`

*   cordova-plugin-file
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-file`

*   cordova-plugin-file-transfer
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-file-transfer`

*   cordova-plugin-geolocation
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-geolocation`

*   cordova-plugin-globalization
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-globalization`

*   cordova-plugin-inappbrowser
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-inappbrowser`

*   cordova-plugin-media
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-media`

*   cordova-plugin-media-capture
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-media-capture`

*   cordova-plugin-network-information
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-network-information`

*   cordova-plugin-splashscreen
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-splashscreen`

*   cordova-plugin-vibration
    
    `plugman --platform <ios|amazon-fireos|android|blackberry10|wp8> --project <directory> --plugin cordova-plugin-vibration`