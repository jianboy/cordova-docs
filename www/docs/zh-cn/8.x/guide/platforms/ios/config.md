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

title: iOS 配置
---

# iOS 配置

`config.xml`档控制应用于每个应用程式和 CordovaWebView 实例的应用程式的基本设置。 本节详细说明仅适用于 iOS 版本的首选项。 有关全域配置选项的资讯，请参阅 [config.xml 档][1]。

 [1]: config_ref_index.md.html#The%20config.xml%20File

*   `EnableViewportScale`(boolean 类型的值，预设值为 `false` ）： 设置为 `true` ，以便视区元标记来禁用或限制的范围的使用者比例，这预设启用的。

        <preference name="EnableViewportScale" value="true"/>


    放置在 HTML 中禁用缩放和适合的视口，如下内容灵活地内呈现 web 视图：

        <meta name='viewport' content='width=device-width, initial-scale=1, user-scalable=no' />


*   `MediaPlaybackAllowsAirPlay`(预设为`true`的布林值): 设置为`false` ，以防止空气发挥被使用在此视图中。 在预设 UIWebView 和 WKWebView 中可用。

        <preference name="MediaPlaybackAllowsAirPlay" value="false"/>


*   `MediaPlaybackRequiresUserAction`(预设为`false`的布林值): 设置为`true`以防止自动播放`自动播放`属性或通过 JavaScript HTML5 视频或音讯。

        <preference name="MediaPlaybackRequiresUserAction" value="true"/>


*   `AllowInlineMediaPlayback`(预设为`false`的布林值): 设置为`true` ，允许 HTML5 媒体重播显示*内联*在萤幕布局，使用浏览器提供的控制项，而不是本机控制项内。 这项工作，将添加到任何`< video >`元素的`webkit playsinline`属性。

        <preference name="AllowInlineMediaPlayback" value="true"/>


*   `BackupWebStorage`(字串，要么`none`，`local`，或预设`云`): 设置为`cloud`以允许通过 iCloud 备份 web 存储资料。 设置为`local`以允许只有本地备份通过 iTunes 同步。 设置为`none`防止 web 存储备份。

        <preference name="BackupWebStorage" value="local"/>


*   `TopActivityIndicator`(字串，预设为`gray`): 控制状态列指示大量的处理器活动中旋转的小图示的外观。 有效值为`whiteLarge`、`white`和`gray`.

        <preference name="TopActivityIndicator" value="white"/>


*   `KeyboardDisplayRequiresUserAction`(预设为`true`的布林值): 设置为`false`以允许键盘显示表单输入调用`focus ()`时。

        <preference name="KeyboardDisplayRequiresUserAction" value="false"/>


*   `SuppressesIncrementalRendering`(预设为`false`的布林值): 设置为`true` ，等待，直到在呈现到萤幕之前已收到的所有内容。

        <preference name="SuppressesIncrementalRendering" value="true"/>


*   `GapBetweenPages`(浮动，预设值为``): 的大小，以磅为单位，页面之间的差距。

        <preference name="GapBetweenPages" value="0"/>


*   `PageLength`(浮动，预设值为``): 每个页面，在页面流的方向点的大小。 当 PaginationMode 是从右至左或从左至右，此属性工作表示每个页面的宽度。 当 PaginationMode 是 topToBottom 或 bottomToTop 时，此属性工作表示每个页面的高度。 预设值为 0，这意味著布局使用视区的大小来确定页面的大小。

        <preference name="PageLength" value="0"/>


*   `PaginationBreakingMode`(字串，预设为`页面`): 有效值为`页`和`列`。在列或页破发生的方式。 此属性确定是否某些 CSS 属性关于列和页破是荣幸还是忽略。 当此属性设置为`列`时，内容方面与到位的页破断列相关的 CSS 属性。

        <preference name="PaginationBreakingMode" value="page"/>


*   `PaginationMode`(字串，预设为`unpaginated`): 有效值为`unpaginated`， `leftToRight`、 `topToBottom`、 `bottomToTop`和`rightToLeft`。 此属性可确定是否在 web 视图中的内容分解成页面全屏显示视图一次，或一个长的滚动视图所示。 如果设置为分页的表单，此属性切换分页的布局的内容，其内容造成 web 视图使用场地的 PageLength 和 GapBetweenPages 的值。

        <preference name="PaginationMode" value="unpaginated"/>


*   `UIWebViewDecelerationSpeed`(字串，预设为`normal`): 有效的值都是`normal`，`fast`。 此属性控制减速的势头滚动。 对于大多数本机应用程式的预设速度是`normal`和`fast`是移动 Safari 的预设值。

        <preference name="UIWebViewDecelerationSpeed" value="fast" />


*   `ErrorUrl`(字串，预设情况下未设置): 如果设置，将显示在应用程式中出现错误时所引用的本地网页。

        <preference name="ErrorUrl" value="myErrorPage.html"/>


*   `OverrideUserAgent`(字串，预设情况下未设置): 如果设置，值将替换旧使用者代理的 web 视图。 它有利于从应用程式或浏览器请求时请求远端页面，识别。 使用持谨慎态度，这可能导致与 web 伺服器的 compitiable 问题。 对于大多数情况下，改用 AppendUserAgent。

        <preference name="OverrideUserAgent" value="Mozilla/5.0 My Browser" />


*   `AppendUserAgent`(字串，预设情况下未设置): 如果设置，值将附加到年底老使用者代理的 web 视图。 当使用 OverrideUserAgent，此值将被忽略。

        <preference name="AppendUserAgent" value="My Browser" />
