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

title: 黑莓 10 配置
---

# 黑莓 10 配置

`config.xml`档控制应用于每个应用程式和 CordovaWebView 实例的应用程式的基本设置。 仅适用于黑莓 10 此节的详细资讯偏好生成。 有关全域配置选项的资讯，请参阅 [config.xml 档][1]。

 [1]: config_ref_index.md.html#The%20config.xml%20File

*   `ChildBrowser`( `disable` 或预设的 `enable` ）： 禁用儿童浏览器视窗。 预设情况下，应用程式启动一个辅助浏览器视窗以显示资源通过访问 `window.open()` 或通过指定 `_blank` 锚点目标。 指定 `disable` 重写此预设行为。
    
        <preference name="ChildBrowser" value="disable"/>
        

*   `PopupBlocker`( `enable` 或预设的 `disable` ）： 启用快显视窗阻止程式，这样可以防止对调用 `window.open()` 。 预设情况下，快显视窗在儿童浏览器视窗中显示。 将首选项设置为 `enable` 防止它显示在所有。
    
        <preference name="PopupBlocker" value="enable"/>
        

*   `WebSecurity`( `disable` 或预设的 `enable` ）： 设置为 `disable` 重写 web 安全设置，允许访问远端内容从未知的来源。 此首选项的目的是作为发展方便只，所以之前将它删除包装分布的应用程式。 发布应用程式，所有 Uri 都应已知和白名单使用 `<access>` 元素，域白名单指南中所述。
    
        <preference name="WebSecurity" value="disable"/>