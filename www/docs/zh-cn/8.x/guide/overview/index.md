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

title: 概述
toc_title: Overview
---

# 概述

Apache 科尔多瓦是一个开放源码移动开发框架。 它允许您使用标准的 web 技术如 HTML5、 CSS3 和 JavaScript 进行跨平台开发，避免每个移动平台的本机开发语言。 应用程式在有针对性的对每个平台的包装内执行，并依靠符合标准的 API 绑定访问每个设备的感应器、 资料和网路状态。

Apache 科尔多瓦于 2012 年 10 月毕业于作为一个顶级专案内阿帕奇软体基金会 (ASF)。 科尔多瓦的未来发展会透过 ASF，确保开放管理的专案。 它将永远是根据 Apache 许可证，2.0 版本的自由和开放源码。访问[cordova.apache.org][1]的详细资讯。

 [1]: http://cordova.apache.org

如果您是，使用 Apache 科尔多瓦：

*   移动开发人员和想要扩展应用程式跨多个平台，而无需重新实现它与每个平台的语言和工具集。

*   网页程式开发人员和想要部署 web 应用程式打包为分布在各种应用程式中存储的门户。

*   移动开发人员感兴趣与*web 视图*（特殊的浏览器视窗），可以访问设备级别的 Api，混合本机应用程式元件或如果你想开发一个外挂程式介面本机和 web 视图元件之间。

## 基本元件

Apache 科尔多瓦的应用程式都依赖于一个共同的 `config.xml` 档，提供有关应用程式的资讯，并指定参数影响它如何工作，如它是否回应方向转移。 此档遵循 W3C 的[打包 Web 应用程式][2]或*构件*，规范。

 [2]: http://www.w3.org/TR/widgets/

应用程式本身作为 web 页上，预设情况下名为*index.html*，引用任何 CSS、 JavaScript、 图像、 媒体档案或其他资源的本地档是必要的它的运行来实现。 这款应用程式作为*web 视图*的本机应用程式中包装，您分发给应用程式商店内执行。

科尔多瓦启用 web 视图可提供具有其整个使用者介面的应用程式。 在一些平台上，它也可以是更大，混合应用程式与本机应用程式元件混合 web 视图中的一个元件。 （请参阅嵌入 WebViews 的详细资讯）。

*外挂程式*介面，供科尔多瓦和本机组件与对方沟通。 这使您可以调用来调用本机代码从 JavaScript。 理想情况下，到该本机代码的 JavaScript Api 是一致的跨多个设备平台。 版本 3.0，外挂程式提供绑定到标准设备的 Api。 协力厂商外挂程式在所有平台上提供额外绑定到不一定可用的功能。 你可以在[外挂程式注册表][3]中找到这些协力厂商外挂程式，在您的应用程式中使用它们。 您也可以开发自己的外挂程式，外挂程式开发指南中所述。 外挂程式可能是必要的例如，科尔多瓦和自订本机组件之间进行通信。

 [3]: http://plugins.cordova.io

**注**： 版本为 3.0，当您创建它并没有任何外挂程式目前科尔多瓦专案。 这是新的缺省行为。 你的愿望，甚至核心外挂程式，必须显式添加任何外挂程式。

科尔多瓦不提供任何 UI 小部件或 MV * 框架。 科尔多瓦提供只在那些可以执行的运行时。 如果您想要使用 UI 部件和/或 MV * 框架，您将需要选择那些并将它们包含在应用程式中自己作为协力厂商材料。

## 发展路径

版本 3.0，你可以使用两种基本的工作流程来创建一个移动应用程式。虽然你经常可以使用任一工作流完成相同的任务，他们每个人都具有优点：

*   **跨平台 (CLI) 工作流程**： 使用此工作流如果您希望您的应用程式在许多不同的移动作业系统上运行，尽可能以小的特定于平台的发展需要。 此工作流都是围绕 `cordova` 实用程式，否则称为科尔多瓦*CLI*，引入的科尔多瓦 3.0。CLI 是功能的一个高级别的工具，使您可以生成许多平台的专案一次，提取很大一部分的较低级别 shell 脚本。 CLI 将一组通用的 web 资产复制到每个移动平台的子目录，使得任何必需的配置更改为每个，运行生成脚本来生成应用程式二进位档案。 CLI 还提供了一个通用介面，适用于您的应用程式的外挂程式。CLI 的更多详细资讯，请参阅命令列介面。 除非你有需要为该平台为中心的工作流，被建议的跨平台工作流。

*   **平台为中心的工作流**： 如果你想要注重建立一个单一的平台的应用程式和需要，以便能够在较低级别进行修改使用此工作流。 您需要使用这种方法，例如，如果您希望您的应用程式组合自订本机组件与基于 web 的科尔多瓦元件，如嵌入 WebViews 中所讨论。 作为一个经验法则，使用此工作流，如果您需要修改 SDK 中的专案。 此工作流，依赖于一套专门针对每个受支援的平台和单独的 Plugman 实用程式，它允许您要应用的外挂程式的较低级别 shell 脚本。 虽然您可以使用此工作流构建跨平台的应用程式，通常很难更因为缺乏的一种较高级别的工具意味著单独的组建循环和外挂程式修改为每个平台。 尽管如此，此工作流允许您提供的每个 SDK 的开发选项获得更多和复杂混合应用程式至关重要。 有关每个平台可用外壳实用程式，请参阅各种平台指南的详细资讯。

当第一次开始的时候，它可能是最简单的方法使用跨平台工作流来创建一个应用程式，如所述的命令列介面。 然后，您可以选择要切换到以平台为中心的工作流，如果你需要 SDK 提供的更大控制。 较低级别外壳实用程式，可在[cordova.apache.org][1]在 CLI 比单独的分发。 生成的专案最初由 CLI，这些外壳工具也是在中可用专案的各种 `platforms/*/cordova` 目录。

**注意**： 一旦你从基于 CLI 的工作流切换到一个围绕特定于平台的 Sdk 和壳的工具，你不能回去。 CLI 维护一套共同的跨平台原始程式码，这对每个构建它使用它来写入的特定于平台的原始程式码。 要保留的特定于平台的资产做的任何修改，你需要要切换到的以平台为中心的壳工具，忽视的跨平台原始程式码，并转而依赖特定于平台的原始程式码。

## 安装科尔多瓦

科尔多瓦的安装会不同上面你选择的工作流：

*   跨平台工作流： 请参阅命令列介面。

*   平台为中心的工作流： 请参见平台辅助线。

在安装之后科尔多瓦，建议您查看您将为开发移动平台平台指南。 它还建议你还审查的隐私指南、 [安全指南](../appdev/security/index.html) 》 和接下来的步骤。 用于配置科尔多瓦，见 config.xml 档。 从 JavaScript 访问本机函数在一个设备上的，请参阅外挂程式 Api。 和参考作为必要的其他包括指南。