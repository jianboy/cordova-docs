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

title: Android 系统组态
---

# Android 系统组态

`config.xml`档控制应用于每个应用程式和 CordovaWebView 实例的应用程式的基本设置。 本节详细说明仅适用于 android 系统生成的首选项。 有关全域配置选项的资讯，请参阅[config.xml 档][1]。

 [1]: config_ref_index.md.html#The%20config.xml%20File

*   `KeepRunning`(boolean 类型的值，预设值为 `true` ）： 确定应用程式是否保持甚至后在后台运行 `[pause](../../../cordova/events/events.pause.html)` 事件火灾。 将此设置为 `false` 不会杀死后的 app `[pause](../../../cordova/events/events.pause.html)` 事件，但只是暂停执行代码内科尔多瓦 web 视图应用程式时在背景中。

        <preference name="KeepRunning" value="false"/>


*   `LoadUrlTimeoutValue`(以毫秒为单位的数位，预设为 `20000` ，20 秒)： 当载入一个页面，在引发逾时错误之前等待的时间量。 此示例指定 10 秒，而不是 20：

        <preference name="LoadUrlTimeoutValue" value="10000"/>


*   `SplashScreen`（字串，预设值为 `splash` ）： 包括其副档名的档的名称 `res/drawable` 目录。 各种资产必须共用此各子目录中的共同名称。

        <preference name="SplashScreen" value="mySplash"/>


*   `SplashScreenDelay`(编号以毫秒为单位，预设值为 `3000` ）： 所需的时间初始萤幕图像显示。

        <preference name="SplashScreenDelay" value="10000"/>


*   `InAppBrowserStorageEnabled`(boolean 类型的值，预设值为 `true` ）： 控制项是否在 InAppBrowser 内打开的页可以访问同一认为和 WebSQL 存储作为预设浏览器打开的页面。

        <preference name="InAppBrowserStorageEnabled" value="true"/>


*   `LoadingDialog`（字串，预设值为 `null` ）： 如果设置，显示一对话方块中指定的标题和消息，和一个微调框，载入的应用程式中的第一页时。 由在此值字串中的逗号分隔的标题和消息，那逗号删除之前显示的对话方块。

        <preference name="LoadingDialog" value="My Title,My Message"/>


*   `LoadingPageDialog`（字串，预设值为 `null` ）： 相同， `LoadingDialog` ，但用于在应用程式中的第一页后载入的每个页面。

        <preference name="LoadingPageDialog" value="My Title,My Message"/>


*   `ErrorUrl`（URL，预设为 `null` ）： 如果设置，将显示而不是以"应用程式错误"标题对话方块的应用程式中的错误时所引用的网页。

        <preference name="ErrorUrl" value="myErrorPage.html"/>


*   `ShowTitle`(boolean 类型的值，预设值为 `false` ）： 显示在萤幕顶部的标题。

        <preference name="ShowTitle" value="true"/>


*   `LogLevel`（字串，预设值为 `ERROR` ）： 将通过哪些日志将过滤邮件从您的应用程式的最小日志级别设置。 有效的值为 `ERROR` ， `WARN` ， `INFO` ， `DEBUG` ，和`VERBOSE`.

        <preference name="LogLevel" value="VERBOSE"/>


*   `SetFullscreen`(boolean 类型的值，预设值为 `false` ）： 同样作为 `Fullscreen` 在此 xml 档的全域配置参数。 此 Android 特定元素支援全球否决 `Fullscreen` 元素，并将在未来版本中移除。

*   `AndroidLaunchMode`（字串，预设值为 `singleTop` ）： 设置活动 `android:launchMode` 属性。 这将更改该应用程式从应用程式图示或意图启动的是已经在运行的过程中会发生什么。 有效的值是 `standard` ， `singleTop` ， `singleTask` ，`singleInstance`.

        <preference name="AndroidLaunchMode" value="singleTop"/>


*   `DefaultVolumeStream`（字串，预设值为 `default` ，加在科尔多瓦 android 3.7.0): 设置的音量按钮连结到的硬体音量。 预设情况下这是"叫"手机和平板电脑的"媒体"。 将此设置为"媒体"有您的应用程式卷按钮总是改变媒体卷。 请注意，当使用科尔多瓦的媒体外挂程式时，音量按钮将动态地更改为任何媒体物件处于活动状态时，控制的媒体卷。

*   `OverrideUserAgent`(字串，预设情况下未设置): 如果设置，值将替换旧使用者代理的 web 视图。 它有利于从应用程式或浏览器请求时请求远端页面，识别。 使用持谨慎态度，这可能导致与 web 伺服器的 compitiable 问题。 对于大多数情况下，改用 AppendUserAgent。

        <preference name="OverrideUserAgent" value="Mozilla/5.0 My Browser" />


*   `AppendUserAgent`(字串，预设情况下未设置): 如果设置，值将附加到年底老使用者代理的 web 视图。 当使用 OverrideUserAgent，此值将被忽略。

        <preference name="AppendUserAgent" value="My Browser" />
