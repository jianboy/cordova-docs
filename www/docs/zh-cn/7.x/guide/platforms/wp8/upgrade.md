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

title: 升级 Windows Phone 8
---

# 升级 Windows Phone 8

本指南演示如何修改 Windows Phone 8 专案，从Cordova的旧版本进行升级。 这些指令的一些适用于创建与前面的命令列工具旧套的专案 `cordova` CLI 实用程式。 资讯，请参阅命令列介面如何更新的 CLI 版本。 下面一节演示如何从非 CLI 和 CLI 专案升级。

## 4.0.0 3.6.0 版升级专案

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

CLI 专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行 `cordova platform update wp8` 在你现有的专案中。

## 从 3.1.0 升级到 3.2.0

为创建的Cordova CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update wp8`

对于不使用 CLI Cordova创建的专案，请运行：

        bin\update < project_path >
    

## 请升级到 3.1.0 从 3.0.0

为专案创建的Cordova CLI：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update wp8`

对于不使用 CLI Cordova创建的专案，请运行：

        bin\update <project_path>
    

## 从 2.9.0 升级到 CLI （3.0.0)

1.  创建一个新的 Apache Cordova 3.0.0 专案使用 CLI，Cordova，所述的命令列介面。

2.  添加您的平台到Cordova专案中，例如：`cordova
platform add wp8`.

3.  该专案的内容复写 `www` 目录到 `www` 目录在Cordova专案您刚刚创建的根。

4.  复制或覆盖任何本机的资产从原始专案 （`闪屏`、 `ApplicationIcon` 等），并确保向 `.csproj` 档中添加任何新的档。 Windows 手机 `platforms\wp8` 目录内的专案生成。

5.  使用Cordova CLI 工具来安装您需要的任何外挂程式。注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

6.  生成并测试。

## 从 2.x 升级到 3.0.0 (非 CLI)

在 Visual Studio 解决方案资源管理器视窗中：

1.  创建新的 Apache Cordova WP8 3.0.0 专案。

2.  将内容复写 `www` 目录到新专案中，并确保这些专案被添加到与专案。

3.  复制并覆盖任何闪屏或图示图像。

4.  复制到新专案从 `plugins` 目录的任何外挂程式，并确保这些也添加到 VS 专案。

5.  生成并测试。

**注**： 所有的核心 Api 从Cordova版本 3.0，删除和作为外挂程式必须单独安装。 有关如何重新启用这些功能在非 CLI 工作流的详细资讯，请参阅使用 Plugman 管理外挂程式。