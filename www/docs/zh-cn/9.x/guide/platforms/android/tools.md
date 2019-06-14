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

title: Android 壳工具指南
---

# Android 壳工具指南

本指南演示如何使用平台为中心的外壳工具Cordova的一整套开发 Android 应用程式。 这种发展道路，概述中讨论可能会为您提供比所述的命令列介面的跨平台 CLI 工具更大范围的发展方案。 例如，您需要部署一个Cordova web 视图自订旁边的本机组件时使用外壳程式工具。 在使用之前要么发展路径，您必须首先配置 Android SDK 环境 Android 平台指南中所述。

要为 android 系统启用外壳工具，请从[cordova.apache.org][1]下载Cordova。 下载档案中包含单独的档案，为每个平台。 展开每个您想要的目标， `android` 在这种情况下。 相关的工具，通常可用在顶级 `bin` 目录中，否则为咨询**自述**档，了解有关更多详细的指示。

 [1]: http://cordova.apache.org

这些工具允许您创建、 构建和运行 Android 应用程式。 额外的命令列介面，可以跨所有平台的外挂程式功能的资讯，请参阅使用 Plugman 到管理外挂程式。 有关如何开发外挂程式的详细资讯，请参阅应用程式外挂程式。

## 创建一个专案

运行 `create` 命令，指定的现有路径的专案、 反向域风格包识别码和应用程式的显示名称。 这里是 Mac/Linux 和 Windows 的语法：

        $ /path/to/cordova-android/bin/create /path/to/project com.example.project_name ProjectName
    
        C:\>\path\to\cordova-android\bin\create.bat \path\to\project com.example.project_name ProjectName
    

## 生成

此清理，然后生成专案。

在 Mac/Linux 或 Windows 上调试：

        $ /path/to/project/cordova/build --debug
    
        C:\>\path\to\project\cordova\build.bat --debug
    

释放，Mac/Linux 或 Windows 上：

        $ /path/to/project/cordova/build --release
    
        C:\>\path\to\project\cordova\build.bat --release
    

## 运行应用程式

`run`命令接受下列*可选*的参数：

*   目标规范。这包括 `--emulator` ， `--device` ，或`--target=<targetID>`.

*   生成规范。这包括 `--debug` ， `--release` ，或`--nobuild`.
    
        $ /path/to/project/cordova/run [Target] [Build]
        
        C:\>\path\to\project\cordova\run.bat [Target] [Build]
        

请确保您创建至少一个 Android 虚拟装置，否则为系统会提示您这样与做 `android` 命令。 如果多个 AVD 可用作为目标，提示您选择一个。 预设情况下 `run` 命令检测连接的设备或当前正在运行的模拟程式，如果没有设备发现。

## 签署应用程式

您可以查看签名要求在这里的安卓应用程式： HTTP://developer.android.com/tools/publishing/app-signing.html

要签名的应用程式，您需要以下参数:

*   金钥库 (`--keystore`): 可容纳一套钥匙的二进位档案的路径。

*   金钥库口令 (`-storePassword`): 到金钥库的密码

*   别名 (`--alias`): 指定私密金钥用于唱歌的 id。

*   * 密码 （`--password`）： 为指定的私密金钥的密码。

*   金钥库 (`--keystoreType`) 类型: pkcs12 jks (预设: 自动检测基于档副档名)

可以使用`build`或`run`脚本上面的命令列参数指定这些参数。

或者，您可以指定它们在组建组态档 (build.json) 中使用 ( `--buildConfig` ) 参数。这里是组建组态档的一个示例:

    {
         "android": {
             "debug": {
                 "keystore": "..\android.keystore",
                 "storePassword": "android",
                 "alias": "mykey1",
                 "password" : "password",
                 "keystoreType": ""
             },
             "release": {
                 "keystore": "..\android.keystore",
                 "storePassword": "",
                 "alias": "mykey2",
                 "password" : "password",
                 "keystoreType": ""
             }
         }
     }
    

对于发布签名，可以排除密码和构建系统会发出提示要求输入密码。

此外，它还支援以混合和匹配的命令列参数和 build.json 档中的参数。 从命令列参数的值将会得到优先。 这可用于在命令列上指定的密码。

## 日志记录

        $ /path/to/project/cordova/log
    
        C:\>\path\to\project\cordova\log.bat
    

## 清洗

        $ /path/to/project/cordova/clean
    
        C:\>\path\to\project\cordova\clean.bat
    

## Gradle 建筑

截至 cordova-android@4.0.0，专案生成使用[Gradle][2]。 关于建设与蚂蚁的说明，请参阅文档的旧版本。

 [2]: http://www.gradle.org/

### Gradle 属性

可以设置这些[属性][3]以自订生成:

 [3]: http://www.gradle.org/docs/current/userguide/tutorial_this_and_that.html

*   **cdvBuildMultipleApks**(预设: false)
    
    如果设置此值，则将生成多个 APK 档: 库专案所支援的本机平台每一个 (x 86，ARM，等)。 这可能是重要的如果您的专案使用大型的本机库，可以大幅增加生成 apk 档的大小。
    
    如果未设置，然后将生成单个 APK，可以在所有设备上使用。

*   **cdvVersionCode**
    
    VersionCode 在`AndroidManifest.xml`中设置将重写

*   **cdvReleaseSigningPropertiesFile**（预设： release-signing.properties)
    
    包含签名发布的资讯进行.properties 档路径生成。 该档应该看起来像:
    
        storeFile=relative/path/to/keystore.p12
        storePassword=SECRET1
        storeType=pkcs12
        keyAlias=DebugSigningKey
        keyPassword=SECRET2
        
    
    `storePassword`和`keyPassword`是可选的如果省略将提示输入。

*   **cdvDebugSigningPropertiesFile**（预设： debug-signing.properties)
    
    同样作为 cdvReleaseSigningPropertiesFile，但用于调试生成。当您需要与其他开发人员共用的签名金钥时有用。

*   **cdvMinSdkVersion**
    
    重写`minSdkVersion`在`AndroidManifest.xml`中设置的值。有用的当创建多个 APKs 基于 SDK 版本。

*   **cdvBuildToolsVersion**
    
    重写自动检测到的`android.buildToolsVersion`值。

*   **cdvCompileSdkVersion**
    
    重写自动检测到的`android.compileSdkVersion`值。

### 扩展 build.gradle

如果您需要自订`build.gradle`，而不是直接编辑，您应该创建一个名为`build-extras.gradle`的同级档。 此档将包含由主要的`build.gradle`时本。 下面是一个示例:

    # Example build-extras.gradle
    # This file is included at the beginning of `build.gradle`
    ext.cdvDebugSigningPropertiesFile = '../../android-debug-keys.properties'
    # When set, this function allows code to run at the end of `build.gradle`
    ext.postBuildExtras = {
        android.buildTypes.debug.applicationIdSuffix = '.debug'
    }
    

请注意，外挂程式也可以包括通过`build-extras.gradle`档:

    <framework src="some.gradle" custom="true" type="gradleReference" />
    

### 示例生成

    export ORG_GRADLE_PROJECT_cdvMinSdkVersion=14
    cordova build android -- --gradleArg=-PcdvBuildMultipleApks=true