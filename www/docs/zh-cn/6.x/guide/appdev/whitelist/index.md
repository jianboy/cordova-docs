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

title: 白名单指南
toc_title: Whitelisting
---

# 白名单指南

域白名单是一种控制访问的安全模型向外部域，您的应用程式已不能控制。 Cordova提供了一个可配置的安全性原则来定义可以访问外部网站。 预设情况下，新的应用程式被配置为允许访问任何网站。 在您的应用程式到生产之前，应制订白名单和允许访问特定的网路域和子域。

对于 Android 和 iOS （如其 4.0 的版本），Cordova的安全性原则是可扩展的通过一个外挂程式介面。 您的应用程式应使用 [cordova-plugin-whitelist][1]，因为它提供了更好的安全性和可配置性比早期版本的Cordova。 虽然有可能实现自己的白名单外挂程式，它不建议除非您的应用程式有非常具体的安全性原则要求。 有关用法和配置，请参阅 [cordova-plugin-whitelist][1] 的详细资讯。

 [1]: https://github.com/apache/cordova-plugin-whitelist

对于其他平台，Cordova遵循 [W3C 部件访问][2] 规范，这依赖于应用程式的 `config.xml` 档以启用对特定域的网路访问中的 `<access>` 元素。 对于依赖于描述在命令列介面的 CLI 工作流程的专案，此档位于专案的顶级目录。 否则对于特定于平台的发展路径，以下各节列出的位置。 （每个平台上见各种平台指南的详细资讯）。

 [2]: http://www.w3.org/TR/widgets-access/

下面的示例演示 `<access>` 白名单语法：

*   [Google.com][3]访问：
    
        <access origin="http://google.com" />
        

*   对安全[google.com][4]的访问 ( `https://` ):
    
        <access origin="https://google.com" />
        

*   子域[maps.google.com][5]访问：
    
        <access origin="http://maps.google.com" />
        

*   对所有子域[google.com][3]，例如[mail.google.com][6]和[docs.google.com][7]的访问：
    
        <access origin="http://*.google.com" />
        

*   到*所有*的域，例如， [google.com][3]和[developer.mozilla.org][8]的访问：
    
        <access origin="*" />
        
    
    这是新创建的 CLI 专案的预设值。

 [3]: http://google.com
 [4]: https://google.com
 [5]: http://maps.google.com
 [6]: http://mail.google.com
 [7]: http://docs.google.com
 [8]: http://developer.mozilla.org

要知道有些网站可以自动从其主页定向到不同的 url，例如，使用 HTTPs 协定或具体国家域。 例如 HTTP://www.google.com 将重定向在 HTTPs://www.google.com，使用 SSL/TLS，然后可能进一步将重定向到一个地理位置，例如 HTTPs://www.google.co.uk。 这样的场景可能需要修改或额外的白名单的作品可以超越你所需的初期。 请考虑这您构建您的白名单。

请注意白名单仅适用于主要的Cordova web 视图，不适用于 InAppBrowser web 视图或系统 web 浏览器中的打开连结。

## 亚马逊火 OS 白

在 `res/xml/config.xml` 中找到特定于平台的白名单规则.

## Android 白

如上所述，看到 [cordova-plugin-whitelist][1] 的详细资讯。Cordova android 4.0.0 之前，请参阅本文档的旧版本。

## iOS 白名单

如上所述，看到 [cordova-plugin-whitelist][1] 的详细资讯。Cordova ios 4.0.0 之前，请参阅本文档的旧版本。

## 黑莓 10 白名单

在 `www/config.xml` 中找到白名单规则.

黑莓 10年使用万用字元有别于其他平台两种方式：

*   必须显式声明由 `XMLHttpRequest` 访问的任何内容。 设置 `origin="*"` 不能在这种情况下。 或者，可能使用黑莓手机配置中所述的 `WebSecurity` 偏好禁用所有 web 安全性：
    
        <preference name="websecurity" value="disable" />
        

*   作为设置 `*.domain` 的替代方法，将其他 `subdomains` 属性设置为 `true`。 它应该被预设设置为 `false`。 例如，下面的允许访问 `google.com`，`maps.google.com` 和 `docs.google.com`：
    
        <access origin="http://google.com" subdomains="true" />
        
    
    `Google.com` 以下缩小存取权限：
    
        <access origin="http://google.com" subdomains="false" />
        
    
    指定访问到所有的域，包括本地 `file://` 协定：
    
        <access origin="*" subdomains="true" />
        

（有关支援的详细资讯，请参阅黑莓的文档 [访问元素][9] 上.)

 [9]: https://developer.blackberry.com/html5/documentation/ww_developing/Access_element_834677_11.html

## 火狐浏览器作业系统

火狐浏览器作业系统特定的域还有白名单没有概念。 相反，有特殊的许可权称为 [SystemXHR][10]。 有必要将此许可权添加到 `config.xml`：

 [10]: https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest#Permissions

    <platform name="firefoxos">
        <permission name="systemXHR" privileged="true" description="load data from server" />
    </platform>
    

`XMLHttpRequest` 物件需要使用两个参数 `mozAnon` 和 `mozSystem` 进行具现化：

    var request = new XMLHttpRequest({
        mozAnon: true,
        mozSystem: true});
    

此解决方案是透明的因此没有其他平台的区别。

## Windows Phone 白名单

Windows Phone 8 的白名单规则是在应用程式的 `config.xml` 档中找到的。

## 泰白名单

白名单规则是在应用程式的 `config.xml` 档中找到的。 平台依靠相同的 `subdomains` 属性作为黑莓平台。 （有关支援的详细资讯，请参阅 Tizen 的文档 [访问元素][11] 上.)

 [11]: https://developer.tizen.org/help/index.jsp?topic=%2Forg.tizen.web.appprogramming%2Fhtml%2Fide_sdk_tools%2Fconfig_editor_w3celements.htm