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

title: Windows 10 的Cordova
---

# Windows 10 的Cordova

也许你可以改称之为"Cordova 10 视窗"。 Windows 10 已经重新设计使Cordova支援到 web，并得到挡你路的平台安全限制其 HTML 和 JavaScript 应用程式平台。

## 开始使用 Windows 10

添加 Windows 10 支援您的应用程式非常简单，将您的 Windows 目标平台版本设置为 10.0:

    <preference name="windows-target-version" value="10.0" />
    <preference name="windows-phone-target-version" value="10.0" />


当您建立与这两个设置这些首选项时，将建成仅限单个.appx (和.appxupload)。 他们将至少需要 Windows 10。

### 了解远端与本地模式模式

远端模式是 Windows 10 HTML 应用程式的 Windows 平台的新功能。 在 Windows 8 和 8.1，HTML 应用程式在 Windows 10 工作中什么所谓的"本地模式"。 在本地模式下，HTML 应用程式具有完全访问本机 Windows API 表面和能力。 为了防止脚本注入攻击，这可能会导致泄漏由于恶意程式码的个人可识别资讯，本地模式不允许内联脚本，需要开发人员执行 DOM 操作，这样做内显式上下文 (`MSApp.execUnsafeLocalFunction`).

远端模式消除了这些要求，这使得它可以使用未修改的库像 jQuery 或 AngularJS 直接在代码中，没有发生任何变化。 要这样做，它将删除您声明某些功能时证明您在 Windows 应用商店的应用程式的能力。 删除的这些功能通常不会阻止进入特定的功能，但它可能需要使用不同的 Api 或战术组合。

### 远端方式对功能的影响

部署到 Windows 应用商店应用程式远端模式时，下列功能不可用:

  * 企业认证 (`enterpriseAuthentication`)
  * 共用的使用者证书 (`sharedUserCertificates`)
  * 文件库 (`documentsLibrary`)
  * 音乐库 (`musicLibrary`)
  * 图片库 (`picturesLibrary`)
  * 视频库 (`videosLibrary`)
  * 卸除式存放装置 (`removableStorage`)
  * 互联网端 (`internetClientServer`)-请注意， `internetClient`仍允许
  * 私人网路络用户端/伺服器 (`privateNetworkClientServer`)

每个库限制可能要求使用者与档案系统通过一个[档选取器](https://msdn.microsoft.com/en-us/library/windows/apps/windows.storage.pickers.fileopenpicker.aspx)交互工作周围。 这样可以防止恶意注入的代码任意访问档案系统。

通过使用不使用能力检查 API 或经纪通过标准的互联网沟通管道，如`XMLHttpRequest`或 Web 通讯端通信，必须解决与网路相关的限制。

企业身份验证和共用使用者证书功能是专门针对企业方案。 这些功能支援私营/企业启用的应用程式商店，所以如果你正在打算将其部署到内部部署机制的应用程式，您仍然可以支援这些。 然而，他们不支援远端模式在公共 Windows 应用商店的应用程式。 当你建立针对 Windows 10，如果这些功能之一检测到您的应用程式清单中时，将显示警告。

## 引用

### config.xml 首选项

#### windows-target-version, windows-phone-target-version

    <preference name="windows-target-version" value="10.0" />
    <preference name="windows-phone-target-version" value="10.0" />


*至少一个是必需的。*

这些首选项确定 Windows 或 Windows Phone 你想要的目标应用程式套装软体的版本。

**有效的值**

  * `10.0`，`UAP`: 为 Windows 10 通用的应用程式平台构建
  * `8.1`: 生成 Windows 8.1 或 Windows Phone 8.1
  * `8.0`: 构建 windows 8.0。 对于 Windows Phone 无效 (改用**wp8**Cordova平台)

**方案**

如果你只针对 Windows 10，你只需要 config.xml 档中有一个单一`windows 目标版本`设置。

#### WindowsDefaultUriPrefix

    <preference name="WindowsDefaultUriPrefix" value="ms-appx://|ms-appx-web://" />


此首选项标识是否想要您的应用程式作为其启动 URI 为目标的**局部上下文**或**远端上下文**。 当生成 Windows 10，预设值是远端上下文 (`ms-appx-web: / /`).

为了有一个本地模式应用程式，不受远端模式能力的限制，您必须将此首选项设置为`ms-appx://`和不声明任何`<access>`元素与远端 Uri。

**有效的值**

  * `ms-appx://`(预设为 Windows 8.0，8.1): 本地上下文中运行的起始页
  * `ms-appx-web://`(预设为 Windows 10): 远端上下文中运行的起始页

#### {SDK}-MinVersion，{SDK} MaxVersionTested

*可选*

    <preference name="Windows.Universal-MinVersion" value="10.0.0.0" />
    <preference name="Windows.Mobile-MinVersion" value="10.0.9927.0" />
    <preference name="Windows.Mobile-MaxVersionTested" value="10.0.10031.0" />
    <preference name="Microsoft.Band-MinVersion" value="10.0.11.0" />


这些首选项确定哪些生态系统 (包括但不是限于 Windows 通用、 Windows Mobile 或 Xbox) 和它们的最小/最大版本都相容。 他们仍然需要平台都支援通用的应用程式平台 (所以 Windows 10 作为基础的作业系统)。 然而，这些可能表明应用程式是意识到可能只在某些设备 (如游戏流在 Xbox 上) 可用的特定功能。

**有效的值**

有三个部分的每个值: **SDK**、**版本限制**和**版本价值**。 通过与`Windows`或`微软`开始和结束`-MinVersion`或`-MaxVersionTested`中检测到这些首选项:

  * **SDK**定义什么专门的平台，你想要的目标。 预设值是`Windows.Universal`。 有效值为这些 AppxManifest 架构，在`包/Depednencies/TargetPlatform`元素中定义。
  * 的 **版本限制** 定义应用程式相容性规则。 例如，如果 `-MinVersion` 设置为 10.1.0.0，然后至少 10.1.0.0 的相应的 sdk 并不支援的作业系统版本不能载入它。
      * `-MinVersion`指定 SDK 所需的最低的版本
      * `-MaxVersionTested`指定的最高测试版本的 sdk。 如果发布了新版本的相应的 sdk，它将运行在相容模式下为指定的版本。
  * **版本值**是 major.minor.build.qfe 的整数 4 元组形式**.

如果你 config.xml 档中指定这些类型没有偏好，然后将预设选择 Windows.Universal 10.0.0.0 版本。
