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

title: 存储
toc_title: Store data
---

# 存储

> 科尔多瓦的存储选项的概述。

几个存储 Api 是对科尔多瓦应用程式可用。请参阅 [html5rocks][1]。有关更完整的概述和示例。

 [1]: http://www.html5rocks.com/en/features/storage

## 认为

此 API 也已知作为*web 存储*、*简单的存储*，或由其备用*会话存储*介面，提供同步键/值对存储，是可用基础 web 视图实现中。 请参阅[W3C 规范][2]的详细资讯。

 [2]: http://www.w3.org/TR/webstorage/

## WebSQL

此 API 是在底层 web 视图中可用。 [Web SQL 资料库规范][3]提供了更多的功能全面的资料库表可以通过 SQL 查询访问。

 [3]: http://dev.w3.org/html5/webdatabase/

以下平台支援 WebSQL：

*   Android 系统
*   黑莓 10
*   iOS
*   Tizen

## IndexedDB

此 API 是在底层 web 视图中可用。[索引 DB][4]提供更多的功能比 LocalStorage 但较少比 WebSQL。

 [4]: http://www.w3.org/TR/IndexedDB/

以下平台支援 IndexedDB：

*   黑莓 10
*   火狐浏览器的作业系统
*   Windows Phone 8
*   Windows 8

## 基于外挂程式的选项

除了上面列出的 Api 的存储，[档 API][5]允许您对本地档案系统上的缓存资料。 其他的[科尔多瓦外挂程式][6]提供类似的存储选项。

 [5]: https://github.com/apache/cordova-plugin-file/blob/master/doc/index.md
 [6]: http://plugins.cordova.io/