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

title: 升级黑莓 10
---

# 升级黑莓 10

本指南演示如何修改黑莓手机的专案从科尔多瓦的旧版本进行升级。 大多数这些说明适用于与旧集的前面的命令列工具创建的专案 `cordova` CLI 实用程式。 资讯，请参阅命令列介面如何更新的 CLI 版本。

## 4.0.0 3.6.0 版升级专案

对于非 CLI 的专案，请运行：

        bin/update path/to/project
    

对于 CLI 专案:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  在你现有的专案中运行 `cordova platform update blackberry`。

## 从 3.1.0 升级到 3.2.0

为专案创建的科尔多瓦 CLI:

1.  更新 `cordova` CLI 版本。请参阅命令列介面。

2.  运行 `cordova platform update blackberry`

对于不使用 CLI 科尔多瓦创建的专案，请运行：

        bin/update <project_path>
    

## 从 3.0.0 升级到 3.1.0

1.  创建一个新的 Apache 科尔多瓦 3.1.0 专案使用 CLI，科尔多瓦，所述的命令列介面。

2.  添加您的平台到科尔多瓦专案中，例如：`cordova
platform add blackberry10`.

3.  复制的原始专案内容 `www` 目录到 `www` 目录在您刚刚创建的科尔多瓦专案的根目录。

4.  复制或覆盖原始专案中的任何本机资产 ( `Resources` ，等等.)

5.  复制 `config.xml` 档到 `www` 目录中，并删除任何外挂程式定义。您需要修改设置，在这里，而不是平台目录内。

6.  使用科尔多瓦 CLI 工具来安装您需要的任何外挂程式。 注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。 只有外挂程式标记 3.0.0 并且以上与 CLI 相容。

7.  生成并测试。

请注意，CLI 完全支援 BlackBerry10 平台。剧本和 BBOS，请参阅科尔多瓦版本 2.9.0 及以下。

## 从 2.9.0 升级到 CLI （3.0.0)

1.  创建新的 Apache 科尔多瓦 3.0.0 专案使用 CLI，科尔多瓦，如所述的命令列介面。

2.  添加您的平台到科尔多瓦专案中，例如:`cordova
platform add blackberry10`.

3.  将原始专案的内容复写 `www` 目录到 `www` 目录在科尔多瓦专案您刚刚创建的根。

4.  复制或覆盖任何本机的资产从原始专案 ( `Resources` ，等等.)

5.  复制 `config.xml` 档到 `www` 目录，并删除任何外挂程式定义。你需要修改设置在这里，而不是平台目录内。

6.  使用科尔多瓦 CLI 工具来安装您需要的任何外挂程式。请注意 CLI 处理所有核心 Api 作为外挂程式，所以他们可能需要添加。只有 3.0.0 外挂程式是与 CLI 相容。

7.  生成并测试。

## 升级 2.8.0 专案到 2.9.0

黑莓 10：

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的科尔多瓦 2.9.0 源，例如到`~/Cordova-2.9.0`.

2.  退出任何正在运行的 SDK 工具： 日食、 Momentics 和类似。

3.  导航到您放在上面，使用的 unix 像终端的下载的源的目录： 终端程式，Bash，这个软体，等等。

4.  创建一个新的专案，如黑莓手机壳工具指南中所述。这成为家中你更新的专案。

5.  从旧专案复制您的专案源 `/ www` 目录到新的专案 `/ www` 目录。

6.  科尔多瓦的脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

为 BlackBerryOS/行动手册：

1.  下载并解压缩到硬碟上，永久目录位置科尔多瓦 2.9.0 源例如到`~/Cordova-2.9.0`.

2.  退出任何正在运行的 SDK 工具： 日食、 Momentics 和类似。

3.  导航到您放在上面，使用的 unix 像终端的下载的源的目录： 终端程式，Bash，这个软体，等等。

4.  创建一个新的专案，如黑莓手机壳工具指南中所述。你需要从这个新的专案资产。

5.  复制 `www/cordova.js` 到新专案中的档 `www` 目录和删除 `www/cordova.js` 档。

6.  科尔多瓦的脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

7.  复制 `native` 目录从新专案到现有专案中，并覆盖旧 `native` 目录。

8.  复制 `lib` 目录从新专案到现有专案中，并覆盖旧 `lib` 目录。

9.  复制 `cordova` 目录从新专案到现有专案中，并覆盖旧 `cordova` 目录。

## 升级 2.7.0 专案到 2.8.0

黑莓 10 使用新的 CLI 工具和管理核心作为外挂程式 Api。 说明将您的专案迁移到一个新的专案，而不是更新现有专案，更新旧专案的复杂性。 也说明科尔多瓦 js 指令档现在被称为 'cordova.js'，并不再包含版本字串。

1.  下载并解压缩到您的硬碟磁碟机上的永久目录位置的科尔多瓦 2.8.0 源，例如到`~/Cordova-2.8.0`.

2.  退出任何正在运行的 SDK 工具： 日食、 Momentics 和类似。

3.  导航到您放在上面，使用的 unix 像终端的下载的源的目录： 终端程式，Bash，这个软体，等等。

4.  创建一个新的专案，如黑莓手机壳工具指南中所述。这成为家中你更新的专案。

5.  从旧专案复制您的专案源 `/ www` 目录到新的专案 `/ www` 目录。

6.  科尔多瓦的脚本中的引用更新 `www/index.html` 档 （以及包含该脚本引用的任何其他档） 以指向新 `cordova.js` 档。

为 BlackBerryOS/剧本:

1.  下载并解压缩到硬碟上，永久目录位置科尔多瓦 2.8.0 源例如到`~/Cordova-2.8.0`.

2.  退出任何正在运行的 SDK 工具： 日食、 Momentics 和类似。

3.  导航到您放在上面，使用的 unix 像终端的下载的源的目录： 终端程式，Bash，这个软体，等等。

4.  创建一个新的专案，如黑莓手机壳工具指南中所述。你需要从这个新的专案资产。

5.  复制 `www/cordova.js` 到新专案中的档 `www` 目录和删除 `www/cordova.js` 档。

6.  更新在科尔多瓦脚本参考 `www/index.html` 档 (以及包含该脚本引用的任何其他档) 以指向新 `cordova.js` 档。

7.  复制 `native` 到现有专案中，并覆盖旧从新专案目录 `native` 目录。

8.  复制 `lib` 到现有专案中，并覆盖旧从新专案目录 `lib` 目录。

9.  复制 `cordova` 到现有专案中，并覆盖旧从新专案目录 `cordova` 目录。

## 升级 2.6.0 专案到 2.7.0

1.  下载并解压缩到硬碟上，例如对 `~/Cordova-2.7.0` 的永久目录位置的科尔多瓦 2.7.0 源.

2.  退出任何正在运行的 SDK 工具: Eclipse、 Momentics 等。

3.  导航到您放置上面，使用的 unix 像终端下载的原始目录: 终端程式，Bash，Cygwin。

4.  创建一个新的专案，如黑莓手机壳工具指南中所述。你需要从这个新的专案资产。

5.  复制 `www/cordova-2.7.0.js` 到新专案中的档 `www` 目录和删除 `www/cordova-2.6.0.js` 档。

6.  更新在科尔多瓦脚本参考 `www/index.html` 档 (以及包含该脚本引用的任何其他档) 以指向新 `cordova-2.7.0.js` 档。

7.  复制 `native` 目录从新专案到现有专案中，并覆盖旧 `native` 目录。

8.  复制 `lib` 目录从新专案到现有专案中，并覆盖旧 `lib` 目录。

9.  复制 `cordova` 目录从新专案到现有专案中，并覆盖旧 `cordova` 目录。

## 从 2.5.0 升级到 2.6.0

更新 PhoneGap 下载目录:

它被建议你下载整个目录的最新副本。

但是，这里有新的部件所需的零敲碎打的更新:

1.  更新中的 cordova.blackberry.js 档 `Phonegap-2.6.0/lib/blackberry/javascript` 目录。

2.  更新 `ext` ， `ext-air` ，和 `ext-qnx` 在 `Phonegap-2.6.0/lib/blackberry/framework` 目录。

3.  更新 `build.xml` 档在 `Phonegap-2.6.0/lib/blackberry` 目录。

4.  更新 `Phonegap-2.6.0/lib/blackberry/bin` 目录。

5.  更新 `VERSION` 档在 `Phonegap-2.6.0/lib/blackberry` 目录。

更新示例 / 目录或迁移现有的专案:

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  更新的内容 `ext-qnx/` 目录。

5.  复制新 `cordova-2.6.0.js` 到您的专案。

6.  更新你的 html 代码，使用新的 `cordova-2.6.0.js` 档。

## 从 2.4.0 升级到 2.5.0

更新 PhoneGap 下载目录:

它被建议你下载整个目录的最新副本。

但是，这里有新的部件所需的零敲碎打的更新:

1.  更新中的 cordova.blackberry.js 档 `Phonegap-2.5.0/lib/blackberry/javascript` 目录。

2.  更新 `ext` ， `ext-air` ，和 `ext-qnx` 在 `Phonegap-2.5.0/lib/blackberry/framework` 目录。

3.  更新 `build.xml` 档在 `Phonegap-2.5.0/lib/blackberry` 目录。

4.  更新 `Phonegap-2.5.0/lib/blackberry/bin` 目录。

5.  更新 `VERSION` 档在 `Phonegap-2.5.0/lib/blackberry` 目录。

更新示例 / 目录或迁移现有的专案:

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  更新的内容 `ext-qnx/` 目录。

5.  复制新 `cordova-2.5.0.js` 到您的专案。

6.  更新你的 html 代码，使用新的 `cordova-2.5.0.js` 档。

## 从 2.3.0 升级到 2.4.0

更新只是 `www` 目录：

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-2.4.0.js` 到您的专案。
    
    *   如果剧本，然后更新.js 档在 `playbook/` 目录。
    *   如果黑莓 10，然后更新中的.js 档 `qnx/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-2.4.0.js` 档。

更新 （即，更新使用 ant 工具） 的示例目录：

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.2.3.0/ext/` 目录。

3.  更新的内容 `cordova.2.3.0/ext-air/` 目录。

4.  更新的内容 `cordova.2.3.0/ext-qnx/` 目录。

5.  更新中的.js 档 `cordova.2.3.0/javascript/` 目录。

6.  打开 `sample/lib/` 目录和重命名 `cordova.2.3.0/` 目录到`cordova.2.4.0/`.

7.  类型 `ant blackberry build` 或 `ant playbook build` 更新 `www` 目录与更新科尔多瓦。

8.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-2.4.0.js` 档。

## 从 2.2.0 升级到 2.3.0

更新只是 `www` 目录:

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-2.3.0.js` 到您的专案。
    
    *   如果剧本，然后更新.js 档在 `playbook/` 目录。
    *   如果黑莓 10，然后更新中的.js 档 `qnx/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-2.3.0.js` 档。

更新 （即，更新使用 ant 工具） 的示例目录：

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.2.2.0/ext/` 目录。

3.  更新的内容 `cordova.2.2.0/ext-air/` 目录。

4.  更新的内容 `cordova.2.2.0/ext-qnx/` 目录。

5.  更新中的.js 档 `cordova.2.2.0/javascript/` 目录。

6.  打开 `sample/lib/` 目录和重命名 `cordova.2.2.0/` 目录到`cordova.2.3.0/`.

7.  类型 `ant blackberry build` 或 `ant playbook build` 来更新 `www` 目录与更新的科尔多瓦。

8.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-2.3.0.js` 档。

## 从 2.1.0 升级到 2.2.0

更新只是 www 目录：

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-2.2.0.js` 到您的专案。
    
    *   如果剧本，然后更新的.js 档中 `playbook/` 目录。
    *   如果黑莓 10，然后更新中的.js 档 `qnx/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-2.2.0.js` 档。

更新 （即，更新使用 ant 工具） 的示例目录：

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.2.1.0/ext/` 目录。

3.  更新的内容 `cordova.2.1.0/ext-air/` 目录。

4.  更新的内容 `cordova.2.1.0/ext-qnx/` 目录。

5.  更新中的.js 档 `cordova.2.1.0/javascript/` 目录。

6.  打开 `sample/lib/` 目录和重命名 `cordova.2.1.0/` 目录到`cordova.2.2.0/`.

7.  类型 `ant blackberry build` 或 `ant playbook build` 更新 `www` 目录与更新科尔多瓦。

8.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-2.2.0.js` 档。

## 从 2.0.0 升级到 2.1.0

更新只是 `www` 目录：

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-2.1.0.js` 到您的专案。
    
    *   如果剧本，然后更新.js 档在 `playbook/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-2.1.0.js` 档。

更新 （即，更新使用 ant 工具） 的示例目录：

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.2.0.0/ext/` 目录。

3.  更新的内容 `cordova.2.0.0/ext-air/` 目录。

4.  更新中的.js 档 `cordova.2.0.0/javascript/` 目录。

5.  打开 `sample/lib/` 目录和重命名 `cordova.2.0.0/` 目录到`cordova.2.1.0/`.

6.  类型 `ant blackberry build` 或 `ant playbook build` 更新 `www` 目录与更新科尔多瓦。

7.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-2.1.0.js` 档。

## 从 1.9.0 升级到 2.0.0

更新只是 `www` 目录：

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-2.0.0.js` 到您的专案。
    
    *   如果剧本，然后更新.js 档在 `playbook/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-2.0.0.js` 档。

6.  更新 `www/plugins.xml` 档。两个外挂程式更改其命名空间/服务标签。更改用于捕获和连络人的外挂程式，从旧的条目:
    
        <plugin name="Capture" value="org.apache.cordova.media.MediaCapture"/>
        <plugin name="Contact" value="org.apache.cordova.pim.Contact"/>
        
    
    自：
    
        <plugin name="Capture" value="org.apache.cordova.capture.MediaCapture"/>
        <plugin name="Contacts" value="org.apache.cordova.pim.Contact"/>
        

更新 （即，更新使用 ant 工具） 的示例目录：

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.1.9.0/ext/` 目录。

3.  更新的内容 `cordova.1.9.0/ext-air/` 目录。

4.  更新中的.js 档 `cordova.1.9.0/javascript/` 目录。

5.  打开 `sample/lib/` 目录和重命名 `cordova.1.9.0/` 目录到`cordova.2.0.0/`.

6.  类型 `ant blackberry build` 或 `ant playbook build` 更新 `www` 目录与更新科尔多瓦。

7.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-2.0.0.js` 档。

8.  打开 `www` 目录和更新 `plugins.xml` 档。两个外挂程式更改其命名空间/服务标签。更改用于捕获和连络人的外挂程式，从旧的条目:
    
         <plugin name="Capture" value="org.apache.cordova.media.MediaCapture"/>
         <plugin name="Contact" value="org.apache.cordova.pim.Contact"/>
        
    
    自：
    
         <plugin name="Capture" value="org.apache.cordova.capture.MediaCapture"/>
         <plugin name="Contacts" value="org.apache.cordova.pim.Contact"/>
        

*   要升级到 1.8.0，请转从 1.7.0

## 从 1.7.0 以来升级到 1.8.0

更新只是 `www` 目录:

1.  打开 `www` 目录，其中包含该应用程式。

2.  删除和更新中的.jar 档 `ext/` 目录。

3.  更新的内容 `ext-air/` 目录。

4.  复制新 `cordova-1.8.0.js` 到您的专案。
    
    *   如果剧本，然后更新.js 档在 `playbook/` 目录。

5.  更新你的 html 代码，使用新的 `cordova-1.8.0.js` 档。

6.  更新 `www/plugins.xml` 档。两个外挂程式更改其命名空间/服务标签。更改用于捕获和连络人的外挂程式，从旧的条目:
    
        <plugin name="Capture" value="org.apache.cordova.media.MediaCapture"/>
        <plugin name="Contact" value="org.apache.cordova.pim.Contact"/>
        
    
    自：
    
        <plugin name="Capture" value="org.apache.cordova.capture.MediaCapture"/>
        <plugin name="Contacts" value="org.apache.cordova.pim.Contact"/>
        

更新示例目录中 (即，更新使用 ant 工具):

1.  打开 `sample/lib/` 目录。

2.  更新中的.jar 档 `cordova.1.7.0/ext/` 目录。

3.  更新的内容 `cordova.1.7.0/ext-air/` 目录。

4.  更新中的.js 档 `cordova.1.7.0/javascript/` 目录。

5.  打开 `sample/lib/` 目录和重命名 `cordova.1.7.0/` 目录到`cordova.1.8.0/`.

6.  类型 `ant blackberry build` 或 `ant playbook build` 更新 `www` 目录与更新科尔多瓦。

7.  打开 `www` 目录并更新你的 html 代码，使用新的 `cordova-1.8.0.js` 档。

8.  打开 `www` 目录和更新 `plugins.xml` 档。两个外挂程式更改其命名空间/服务标签。更改用于捕获和连络人的外挂程式，从旧的条目:
    
         <plugin name="Capture" value="org.apache.cordova.media.MediaCapture"/>
         <plugin name="Contact" value="org.apache.cordova.pim.Contact"/>
        
    
    自：
    
         <plugin name="Capture" value="org.apache.cordova.capture.MediaCapture"/>
         <plugin name="Contacts" value="org.apache.cordova.pim.Contact"/>