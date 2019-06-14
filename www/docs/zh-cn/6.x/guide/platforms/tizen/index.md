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

title: Tizen 平台指南
---

# Tizen 平台指南

本指南介绍了如何设置您的 SDK 开发环境部署科尔多瓦运行 Tizen 作业系统的设备的应用程式。

## 要求和支援

Tizen SDK 需要 Linux Ubuntu 10.04/10.10/11.04/11.10 （32 位） 或 Windows XP SP3/7 （32 位）。

开发人员应使用 `cordova` 实用程式 Tizen SDK 的结合。 命令列介面资讯，请参阅如何安装它，添加专案，然后生成和部署专案。

## 安装 SDK

从[tizen.org][1]下载 Tizen SDK.

 [1]: https://developer.tizen.org/sdk

<!--

- (optional) Install Tizen Cordova template projects: copy the
  `/templates` directory content into the Tizen Eclipse IDE web
  templates directory (e.g.:
  `/home/my_username/tizen-sdk/IDE/Templates/web`).

- __Method #2: Use Tizen Eclipse IDE Cordova Tizen project templates__
    - Launch Tizen Eclipse IDE
    - Select  __File &rarr; New &rarr; Tizen Web Project__
    - Select __User Template__ and __User defined__ items
    - Select one of the Tizen Cordova template (e.g.: __CordovaBasicTemplate__)
    - Fill the __Project name__ and its target __Location__

    ![]({{ site.baseurl }}/static/img/guide/platforms/tizen/project_template.png)

    - Click __Finish__

    ![]({{ site.baseurl }}/static/img/guide/platforms/tizen/project_explorer.png)

    - Your project should now appear in the __Project Explorer__ view

-->

## 在 SDK 中打开的专案

1.  推出 Tizen Eclipse IDE。

2.  选择**档 → 导入 → Tizen Web 专案**：
    
    ![][2]

3.  按**下一步**.

4.  请确保选中了**选择根目录**。

5.  请确保选中了**复制到工作区中的专案**。

6.  按**流览**并选择科尔多瓦 Tizen `samples` 专案目录 （如 `/cordova-basic` ）：
    
    ![][3]

7.  按**完成**。您的专案现在应该将其导入并出现在**专案资源管理器**视图中：
    
    ![][4]

 [2]: {{ site.baseurl }}/static/img/guide/platforms/tizen/import_project.png
 [3]: {{ site.baseurl }}/static/img/guide/platforms/tizen/import_widget.png
 [4]: {{ site.baseurl }}/static/img/guide/platforms/tizen/project_explorer.png

重新生成专案，在**专案资源管理器**视图中按右键并选择**生成专案**：

![][5]

 [5]: {{ site.baseurl }}/static/img/guide/platforms/tizen/build_project.png

如*hello.wgt*的小部件包档应在专案的根目录中生成。

## 部署到模拟程式

用滑鼠右键按一下**专案资源管理器**视图中的专案并选择**运行作为 → Tizen Web 模拟器应用程式**：

![][6]

 [6]: {{ site.baseurl }}/static/img/guide/platforms/tizen/runas_web_sim_app.png

## 将部署到设备

*   请确保目标设备正常启动、 连接和配置。必须正确设置其**日期和时间**设置。

*   使用**连接资源管理器**视图选择的应用程式部署目标：**视窗显示视图 → 连接资源管理器**.
    
    ![][7]

*   用滑鼠右键按一下该专案在**专案资源管理器**视图，然后选择**运行作为 → Tizen Web 应用程式**：
    
    ![][8]

 [7]: {{ site.baseurl }}/static/img/guide/platforms/tizen/connection_explorer.png
 [8]: {{ site.baseurl }}/static/img/guide/platforms/tizen/runas_web_app.png
