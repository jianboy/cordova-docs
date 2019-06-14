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

title: Windows Phone 8.0 WebViews
---

# Windows Phone 8.0 WebViews

本指南说明如何将嵌入在一个较大的 Windows Phone 8.0 应用程式内的Cordova启用 web 视图元件。

要按照这些说明进行操作，请确保您有最新的Cordova分布。 从[cordova.apache.org](http://cordova.apache.org)下载和解压缩其 Windows Phone 8.0 套装软体 （Cordova-wp8-*.zip）。

  1. 导航到包的 `wp8/framework` 目录和生成 `WPCordovaClassLib.sln` 。它将创建`Bin\Debug[Release]\WPCordovaClassLib.dll`.

  2. 复制 `WPCordovaClassLib.dll` 档到 Windows Phone 8 专案 `/libs` 目录，包括 `WPCordovaClassLib.dll` 到您的专案，通过 `Project->References->Add Reference` 。 或者，你可以直接引用 `wp8/framework/WPCordovaClassLib.csproj` 档。

  3. 添加 `CordovaView` 元件绑定到您的页面 （例如，`MainPage.xaml`).
    
        xmlns:my="clr-namespace:WPCordovaClassLib;assembly=WPCordovaClassLib">
        ...
        <my:CordovaView HorizontalAlignment="Stretch" Margin="0,0,0,0" 
        StartPageUri="html/index.html" x:Name="CordovaView" VerticalAlignment="Stretch" />
        

  4. 复制 `common/www/cordova.js` 以及应用程式的 HTML 和 JavaScript 档到 Windows Phone 8 专案 `html` 目录，并包括该专案的新档。

  5. 复制 `wp8/template/config.xml` 到专案的根目录中和

上面的说明将连结仅核心Cordova元件，看到使用 Plugman 管理外挂程式连结Cordova外挂程式。