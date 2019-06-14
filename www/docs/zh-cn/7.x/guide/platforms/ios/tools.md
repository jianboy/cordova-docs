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

title: iOS 壳工具指南
---

# iOS 壳工具指南

本指南演示如何使用Cordova的套的平台为中心的外壳程式工具来开发 iOS 应用程式。 这种发展道路，概述中讨论可能会为您提供更广泛的发展方案时，iOS 比所述的命令列介面的跨平台 CLI 工具。 例如，您需要部署一个Cordova web 视图自订旁边的本机组件时使用外壳程式工具。 在使用之前要么发展路径，您必须首先配置 SDK 环境的 iOS 平台指南中所述。 这些工具依赖于 Xcode 的命令列工具如 `xcode-select` 和`xcodebuild`.

若要启用 iOS 的外壳工具，请从[cordova.apache.org][1]下载Cordova。 下载档案中包含单独的档案，为每个平台。 展开每个您想要的目标， `ios` 在这种情况下。 相关的工具，通常可用在顶级 `bin` 目录中，否则为咨询**自述**档，了解有关更多详细的指示。

 [1]: http://cordova.apache.org

这些工具允许您创建、 构建和运行 iOS 的应用程式。 额外的命令列介面，可以跨所有平台的外挂程式功能的资讯，请参阅使用 Plugman 到管理外挂程式。 有关如何开发外挂程式的详细资讯，请参阅应用程式外挂程式。

## 创建一个专案

运行 `create` 命令，指定的现有路径的专案、 反向域式包识别码和应用程式的显示名称。

        $ ./path/to/cordova-ios/bin/create /path/to/my_new_project com.example.project_name ProjectName
    

## 生成专案

        $ /path/to/my_new_project/cordova/build
    

## 在模拟器上运行应用程式

        $ /path/to/my_new_project/cordova/run --emulator
    

## 在设备上运行的应用程式

        $ /path/to/my_new_project/cordova/run --device
    

## 签署应用程式

你可以了解更多关于签署、 分发 iOS 应用程式、 创建证书和资源调配上[iOS 开发人员库][2]的设定档.

 [2]: https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/ConfiguringYourApp/ConfiguringYourApp.html

签在Cordova app 需要具备以下条件:

*   代码签名标识 (`-codeSignIdentity`):[使用 XCode][3]可以创建新的 iOS 签名标识并将其添加到您的钥匙串。 类型的代码签名身份 — — 通常分布或发展，需要在这里指定。

*   资源调配 (`-provisioningProfile`) 的设定档:[使用苹果会员中心][4]你可以创建一个资源调配的设定档。 下载到您的机器上设置的设定档并启动它在 XCode 来注册它。 它在你的 Mac 上复制到此处: ~/Library/MobileDevice/Provisioning\ 设定档 /。 在文字编辑器中打开它，你可以找到，需要在此处指定的 UUID。

*   代码签名资源规则 (`-codeSignResourceRules`) (可选): 允许您指定自订签名资源规则。

 [3]: https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/MaintainingCertificates/MaintainingCertificates.html#//apple_ref/doc/uid/TP40012582-CH31-SW6
 [4]: https://developer.apple.com/library/ios/documentation/IDEs/Conceptual/AppDistributionGuide/MaintainingProfiles/MaintainingProfiles.html#//apple_ref/doc/uid/TP40012582-CH30-SW61

可以使用`生成`或`运行`脚本上面的命令列参数指定这些参数:

        $ /path/to/my_new_project/cordova/build --codeSignIdentity="iPhone Distribtion" --provisioningProfile="926c2bd6-8de9-4c2f-8407-1016d2d12954" 
    

或者，您可以指定它们在组建组态档 （build.json） 中使用 （`--buildConfig`) 的论点。下面是组建组态档的一个示例：

    {
         "ios": {
             "debug": {
                 "codeSignIdentity": "iPhone Development",
                 "provisioningProfile": "926c2bd6-8de9-4c2f-8407-1016d2d12954"
             },
             "release": {
                 "codeSignIdentity": "iPhone Distribution",
                 "provisioningProfile": "70f699ad-faf1-4adE-8fea-9d84738fb306"
             }
         }
     }
    

此外，它还支援以混合和匹配的命令列参数和 build.json 档中的参数。从命令列参数的值将会得到优先。

## 日志记录

        $ /path/to/my_new_project/cordova/log
