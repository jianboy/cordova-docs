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

title: 黑莓 10 手机壳工具指南
---

# 黑莓 10 手机壳工具指南

`cordova`命令列实用程式是一个高级别的工具，允许您在一次跨几个平台生成的应用程式。 旧版本的科尔多瓦框架提供了特定于每个平台的命令列工具集。 若要使用它们作为 CLI 的替代，您需要从[cordova.apache.org][1]下载此版本的科尔多瓦。 下载档案中包含单独的档案，为每个平台。 展开您想要的目标平台。 这里描述的工具，通常可用在顶级 `bin` 目录中，否则为咨询**自述**档，了解有关更多详细的指示。

 [1]: http://cordova.apache.org

低级命令列介面，它使外挂程式的资讯，请参阅使用 Plugman 到管理外挂程式。有关如何开发外挂程式的详细资讯，请参阅应用程式外挂程式。

如果您需要帮助与下面列出的任何命令，请键入命令沿与 `-h` 或 `-help` 参数，所支援的所有命令并提供为每个可用的参数说明。

## 创建一个应用程式

`create`命令将创建一个新的专案：

        bin/创建 < 路径到专案 >< 专案-包 >< 专案名称 >
    

在哪里

*   `<path-to-project>`指定您想要的专案中创建的目录

*   `<project-package>`指定一个反向功能变数名称样式识别码

*   `<project-name>`指定应用程式的显示名称

**注**： `create` 命令引导其依赖项安装通过 `npm install` 命令。 根据安装的目录和系统许可权，这可能需要管理员特权。 如果在 OSX/Linux 上有问题，请运行 `sudo npm install` 之前使用 `create` 命令。 在 Windows 上，运行 `npm install` 命令列实用程式中打开具有管理员许可权。

## 创建目标

`target`命令允许您管理模拟器或您使用来测试应用程式的黑莓设备。您可以添加或删除一个目标，或将目标设置为预设的目标。

### 添加目标

        < 路径到专案 >/科尔多瓦/目标添加 < 名称 >< 的 ip 位址 > [-t |-类型 < 设备 | 模拟器 >] [-p |-< 密码 >] [— — pin < 设备针 >]
    

在哪里

*   `<name>`指定目标的唯一名称。

*   `<ip-address>`指定的 ip 位址的黑莓设备或模拟器。

*   `-p | --password <password>`指定的设备或模拟程式的密码。只有在设备或模拟器是受密码保护，这是必需的。

*   `--pin <device-pin>`指定的黑莓设备，作为一个有效的主机调试标记标识该设备的 PIN。 只有在创建调试权杖时，此参数是必需的。

### 删除目标

        < 路径到专案 >/科尔多瓦/目标删除 < 名称 >
    

### 将目标设置为预设值

        < 路径到专案 >/科尔多瓦/目标预设 < 名称 >
    

## 构建应用程式

`build`命令将生成作为.bar 档的专案。 您可以生成的应用程式中任何一种释放模式 （会产生一个签名的.bar 档） 或在侦错模式下 （会产生一个无符号的.bar 档）。

### 构建在发布模式下的应用程式

        < 路径到专案 >/科尔多瓦/生成释放 [-k |-keystorepass < 密码 >] [-b |-buildId < 数量 >] [-p |-params < params JSON 档 >]
    

在哪里

*   `-k | --keystorepass <password>`指定当您配置您的电脑以签名的应用程式定义的密码。

*   `-b | --buildId <number>`指定您的应用程式的内部版本号。 通常情况下，这个数位应从以前的已签名版本递增。 此参数是可选的。

*   `-p | --params <params-JSON-file>`指定包含要传递给下游工具的额外参数的 JSON 档。此参数是可选的。

### 生成在侦错模式下专案

        < 路径到专案 >/科尔多瓦/生成调试 [< 目标 >] [-k |-keystorepass < 密码 >] [-p |-params < params JSON 档 >] [-ll | — — loglevel < error|warn|verbose >]
    

在哪里

*   `<target>`指定以前添加的目标的名称。 如果 `<target>` 不指定，则预设的目标使用，如果其中一个已创建。 此参数才是必需的如果你想要的脚本来将应用程式部署到黑莓设备或模拟程式和你没有创建一个预设目标。 此外，如果 `<target>` 是一个设备，然后该设备必须连接到您的电脑的 USB 连接或连接到您的电脑位于同一 Wi-Fi 网路。

*   `-k | --keystorepass <password>`指定当您配置您的电脑以签名的应用程式定义的密码。 此密码还用于创建您的调试权杖。 此参数才是必需如果你想要创建并为您安装调试权杖的脚本。

*   `-p | --params <params-JSON-file>`指定包含要传递给下游工具的额外参数的 JSON 档。

*   `-ll | --loglevel <level>`指定的日志级别。日志级别可能是 `error` ， `warn` ，或`verbose`.

如果你有以前定义一个预设目标 （和以前安装调试的标记，如果这一目标是黑莓设备），您可以使用运行该脚本没有参数和脚本包您的应用程式并将它部署到的预设目标。 例如：

        < 路径到专案 >/科尔多瓦/生成调试
    

## 运行应用程式

`run`命令将部署应用程式的最新生成指定的黑莓设备或模拟程式上。若要部署您的应用程式，您需要指定一个目标设备或模拟程式：

        < 路径到专案 >/科尔多瓦/运行 < 目标 >
    

...现场 `<target>` 指定以前添加的目标的名称。 如果 `<target>` 是一个设备，然后它必须连接到您的电脑通过 USB 电缆，或者在您的电脑位于同一 Wi-Fi 网路。

## 控制码外挂程式

`target`命令允许您添加和删除外挂程式。要获取本地承载的外挂程式：

        < 路径到专案 >/科尔多瓦/外挂程式 fetch < 路径到外挂程式 >
    

查看已安装外挂程式的清单：

        < 路径到专案 >/科尔多瓦/外挂程式 ls
    

添加外挂程式：

        < 路径到专案 >/科尔多瓦/外挂程式添加 < 名称 >
    

删除某个外挂程式：

        < 路径到专案 >/科尔多瓦/外挂程式 rm < 名称 >