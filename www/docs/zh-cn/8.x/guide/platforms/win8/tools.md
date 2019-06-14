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

title: Windows 8 的命令列工具
---

# Windows 8 的命令列工具

`cordova`命令列实用程式是一个高级别的工具，允许您在一次跨几个平台生成的应用程式。 旧版本的科尔多瓦框架提供了特定于每个平台的命令列工具集。 若要使用它们作为 CLI 的替代，您需要从[cordova.apache.org][1]下载此版本的科尔多瓦。 下载档案中包含单独的档案，为每个平台。 展开您想要的目标平台。 这里描述的工具，通常可用在顶级 `bin` 目录中，否则为咨询**自述**档，了解有关更多详细的指示。

 [1]: http://cordova.apache.org

低级命令列介面，它使外挂程式的资讯，请参阅使用 Plugman 到管理外挂程式。有关概述，请参见应用程式外挂程式。

## Windows 8

Windows 8 的命令列工具仅支援创建新专案。必须从 cmd 或 powershell 的提示符下运行命令。

## 创建一个专案

运行 `create` 命令使用以下参数：

*   您新的科尔多瓦 Windows 8 专案的路径

*   之后反向域风格公约的包名称。这将成为预设 Namespace。

*   专案名称