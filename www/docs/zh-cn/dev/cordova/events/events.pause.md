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

title: pause
---

# pause

当一个应用程式放入后台，将触发该事件。

    document.addEventListener("pause", yourCallbackFunction, false);
    

## 详细资讯

`pause`当本机平台放入背景，应用程式通常在使用者切换到不同的应用程式时激发的事件。

应用程式通常应使用 `document.addEventListener` 将一个事件拦截器附加一次 `[deviceready](events.deviceready.html)` 事件火灾。

## 支援的平台

*   亚马逊火 OS
*   Android 系统
*   黑莓 10
*   iOS
*   Windows Phone 8
*   Windows 8

## 快速的示例

    document.addEventListener("pause", onPause, false);
    
    function onPause() {
        // Handle the pause event
    }
    

## 完整的示例

    <!DOCTYPE html>
    <html>
      <head>
        <title>Pause Example</title>
    
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
            document.addEventListener("pause", onPause, false);
        }
    
        // Handle the pause event
        //
        function onPause() {
        }
    
        </script>
      </head>
      <body onload="onLoad()">
      </body>
    </html>
    

## iOS 的怪癖

在 `pause` 处理常式中，任何调用到Cordova API 或穿过目标 C 的本机外挂程式不工作，以及任何互动式调用，如警报或 `console.log()` 。 当应用程式恢复后，在下一次运行回圈上他们，只处理。

特定于 iOS `resign` 事件是可用作为替代 `pause` ，并检测时的使用者启用**锁定**按钮锁定设备与应用程式在前台运行。 如果为多工启用的应用程式 （和设备），则这配对与其后 `pause` 事件，但只在 iOS 5 下的。 实际上，所有锁定应用程式已启用多工的 iOS 5 中被推到背景中。 对于应用程式继续运行在 iOS 5 下锁定时，禁用应用程式的多工处理通过将[UIApplicationExitsOnSuspend][1]设置为 `YES` 。 若要运行在 iOS 4 上锁定状态时，此设置并不重要。

 [1]: http://developer.apple.com/library/ios/#documentation/general/Reference/InfoPlistKeyReference/Articles/iPhoneOSKeys.html