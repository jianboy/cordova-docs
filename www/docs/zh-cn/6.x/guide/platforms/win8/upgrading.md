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

title: 升级 Windows 8
---

# 升级 Windows 8

本指南演示如何修改 Windows 8 专案从科尔多瓦的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 命令列介面资讯，请参阅如何更新的 CLI 版本。

## 从 3.1.0 升级到 3.2.0

为创建的科尔多瓦 CLI 的专案：

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行`cordova platform update windows8`.

对于不使用 CLI 科尔多瓦创建的专案，请运行：

        bin\update <project_path>
    

## 升级到 3.1.0

在科尔多瓦 3.1.0 引入了对 Windows 8 的科尔多瓦 CLI 支援。若要升级，我们建议创建新的科尔多瓦 CLI 专案和所有必要的资产转移。

## 从 2.8.0 升级到 2.9.0

下面的命令应当从内进行 Visual Studio 可以肯定任何专案引用是更新删除。

1.  删除 `cordova-2.8.0.js` 从专案的 `www` 目录。

2.  添加 `cordova.js` 档从源到专案中的 `www` 目录。（请注意该档不再包含在档案名中的版本号）。

3.  生成和测试 ！

## 从 2.7.0 升级到 2.8.0

下面的命令应当从内进行 Visual Studio 可以肯定任何专案引用是更新删除。

1.  删除 `cordova-2.7.0.js` 从专案的 `www` 目录。

2.  添加 `cordova.js` 档从源到专案中的 `www` 目录。（请注意该档不再包含在档案名中的版本号）。

3.  生成和测试 ！