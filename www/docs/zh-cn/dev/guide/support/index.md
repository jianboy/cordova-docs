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

title: 平台支持
toc_title: 平台支持
---

# 平台支持

下面显示一的组开发工具和设备的 Api 可为每个移动平台。 Api 在此处列出的设备是由核心外挂程式，提供额外的 Api 都是通过[协力厂商外挂程式][1]提供。 列标题显示的 CLI 速记名称。

 [1]: http://plugins.cordova.io

<!-- START HTML -->

<table class="compat" width="100%">
  <tr>
    <th>
      </td> <th>
        亚马逊-fireos
      </th>

      <th>
        android 系统
      </th>

      <th>
        blackberry10
      </th>

      <th>
        火狐浏览器作业系统
      </th>

      <th>
        ios
      </th>

      <th>
        Ubuntu
      </th>

      <th>
        wp8<br />(Windows Phone 8）
      </th>

      <th>
        windows<br />(8.0、 8.1，10<br />8.1 的电话）
      </th>

      <th>
        tizen
      </th></tr> </thead>

      <tr>
        <th>
          <a href="../cli/index.html">Cordova<br />CLI</a>
        </th>

        <td data-col="amazon-fireos" class="y">
          Mac、 Windows、 Linux
        </td>

        <td data-col="android"    class="y">
          Mac、 Windows、 Linux
        </td>

        <td data-col="blackberry10" class="y">
          Mac Windows
        </td>

        <td data-col="firefoxos" class="y">
          Mac、 Windows、 Linux
        </td>

        <td data-col="ios"        class="y">
          Mac
        </td>

        <td data-col="ubuntu"        class="y">
          Ubuntu
        </td>

        <td data-col="winphone8"  class="y">
          Windows
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="../hybrid/webviews/index.html">嵌入式<br />Web 视图</a>
        </th>

        <td data-col="amazon-fireos" class="y">
          <a href="../platforms/amazonfireos/webview.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="android"    class="y">
          <a href="../platforms/android/webview.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="blackberry10" class="n">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
          <a href="../platforms/ios/webview.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="n">
        </td>

        <td data-col="win8"       class="n">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="../hybrid/plugins/index.html">外挂程式<br />介面</a>
        </th>

        <td data-col="amazon-fireos" class="y">
          <a href="../platforms/amazonfireos/plugin.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="android"    class="y">
          <a href="../platforms/android/plugin.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="blackberry10" class="y">
          <a href="../platforms/blackberry10/plugin.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
          <a href="../platforms/ios/plugin.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
          <a href="../platforms/wp8/plugin.html">（请参阅详细资讯）</a>
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
        </th>

        <th colspan="20">
          平台 Api
        </th>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-device-motion">加速度计</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-battery-status">BatteryStatus</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="n">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
          * 仅限于 Windows Phone 8.1
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-camera">相机</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-media-capture">捕获</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-device-orientation">指南针</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
          (3GS) +
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-network-information">连接</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-contacts">连络人</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="p">
          部分
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-device">设备</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="../../cordova/events/events.html">事件</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-file">档</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-file-transfer">档案传输</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
          * 不支援 onprogress，也不放弃
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="n">
        </td>

        <td data-col="winphone8"  class="y">
          * 不支援 onprogress，也不放弃
        </td>

        <td data-col="win8"       class="y">
          * 不支援 onprogress，也不放弃
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-geolocation">地理位置</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-globalization">全球化</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-inappbrowser">InAppBrowser</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="p">
          使用 iframe
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-media">媒体</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-dialogs">通知</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-splashscreen">闪屏</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-statusbar">状态列</a>
        </th>

        <td data-col="amazon-fireos" class="n">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="n">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="n">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
          仅限于 Windows Phone 8.1
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr>

      <tr>
        <th>
          <a href="../../cordova/storage/storage.html">存储</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="n">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="y">
        </td>

        <td data-col="winphone8"  class="y">
          <a href="../../cordova/storage/localstorage/localstorage.html">localStorage</a> indexedDB &
        </td>

        <td data-col="win8"       class="y">
          <a href="../../cordova/storage/localstorage/localstorage.html">localStorage</a> indexedDB &
        </td>

        <td data-col="tizen"       class="y">
        </td>
      </tr>

      <tr>
        <th>
          <a href="https://www.npmjs.com/package/cordova-plugin-vibration">振动</a>
        </th>

        <td data-col="amazon-fireos" class="y">
        </td>

        <td data-col="android"    class="y">
        </td>

        <td data-col="blackberry10" class="y">
        </td>

        <td data-col="firefoxos" class="y">
        </td>

        <td data-col="ios"        class="y">
        </td>

        <td data-col="ubuntu"        class="n">
        </td>

        <td data-col="winphone8"  class="y">
        </td>

        <td data-col="win8"       class="y">
          * 仅限于 Windows Phone 8.1
        </td>

        <td data-col="tizen"       class="n">
        </td>
      </tr></table>

      <!-- END HTML -->
