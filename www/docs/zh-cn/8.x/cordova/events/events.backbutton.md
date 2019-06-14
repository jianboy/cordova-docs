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

title: backbutton
---

# backbutton

在使用者按后退按钮时，将触发该事件。

    document.addEventListener("backbutton", yourCallbackFunction, false);
    

## 详细资讯

要重写后退按钮的预设行为，注册为事件拦截器 `backbutton` 事件，通常通过调用 `document.addEventListener` 一旦您收到 `[deviceready](events.deviceready.html)` 事件。 不再需要调用任何其他方法重写的后退按钮的行为。

## 支援的平台

*   亚马逊火 OS
*   Android 系统
*   黑莓 10
*   Windows Phone 8

## 快速的示例

    document.addEventListener("backbutton", onBackKeyDown, false);
    
    function onBackKeyDown() {
        // Handle the back button
    }
    

## 完整的示例

    <!DOCTYPE html>
    <html>
      <head>
        <title>Back Button Example</title>
    
        <script type="text/javascript" charset="utf-8" src="cordova.js"></script>
        <script type="text/javascript" charset="utf-8">
    
        // Wait for device API libraries to load
        //
        function onLoad() {
            document.addEventListener("deviceready", onDeviceReady, false);
        }
    
        // device APIs are available
        //
        function onDeviceReady() {
            // Register the event listener
            document.addEventListener("backbutton", onBackKeyDown, false);
        }
    
        // Handle the back button
        //
        function onBackKeyDown() {
        }
    
        </script>
      </head>
      <body onload="onLoad()">
      </body>
    </html>