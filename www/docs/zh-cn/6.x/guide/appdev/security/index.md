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

title: 安全指南
toc_title: Manage security
---

# 安全指南

以下指南包括开发科尔多瓦的应用程式时，应考虑一些安全最佳做法。 请务必注意安全是一个非常复杂的主题，因此本指南不是详尽无遗。 如果你认为你可以贡献本指南，请随时在科尔多瓦的 bug 追踪器下["文档"][1]中档的问题。 本指南旨在适用于一般科尔多瓦发展 （所有平台），但将指出特定于平台的特殊注意事项。

 [1]: https://issues.apache.org/jira/browse/CB/component/12316407

## 本指南讨论了下列主题：

*   白名单
*   Iframe 和回档 Id 机制
*   证书寄
*   自签名的证书
*   加密的存储
*   一般提示
*   推荐的文章和其他资源

## 白名单

*   阅读和理解，白名单指南

*   域白名单不能在 Android API 10 及以下，WP8 iframe 和用户端代码。 这意味著攻击者可以载入任何域中的 iframe，在 iframe 内页面上的任何脚本可以直接存取科尔多瓦 JavaScript 物件和相应的本机 JAVA 物件。 当为这些平台构建应用程式时，应考虑到这种情况。 在实践中这意味著确保目标高于 10，Android API 和如果可能的话您不使用 iframe 载入外部内容-使用 inAppBrowser 外挂程式或其他协力厂商外挂程式。

## Iframe 和回档 Id 机制

如果内容提供在 iframe 从白名单中的域中，该域将可以访问到本机的科尔多瓦桥。 这意味著，如果白名单中的协力厂商广告网路和服务通过 iframe 的那些广告，它有可能是恶意的广告将能够打破 iframe 并执行恶意操作。 因此，您通常不应使用 iframe 除非你控制的伺服器的承载的 iframe 内容。 此外请注意有协力厂商外挂程式提供支援的广告网路。 注意此语句不是真正的 iOS，拦截一切包括 iframe 的连接。

## 证书寄

科尔多瓦不支援真正的证书固定。 对此的一个主要障碍是证书的缺乏在 android 系统中的本机 Api 拦截 SSL 连线执行检查伺服器。 （虽然有可能要做证书寄于 Android 在 JAVA 中使用 JSSE，c + +，编写在 android 系统上的 web 视图和 web 视图为你处理伺服器连接，所以它是不可能有使用 JAVA 和 JSSE)。因为 Apache 科尔多瓦要跨多个平台提供一致的 Api，不具有能力的一个主要平台打破了这种一致性。

有种方法近似证书锁定，如检查伺服器的公开金钥 （指纹） 预期值，当您的应用程式启动时或在其他不同的时间，在您的应用程式的存留期内。 有协力厂商外挂程式可供能不能做到的科尔多瓦。 然而，这不是真实证书将锁定，将自动验证每个连接到伺服器上的预期值相同。

## 自签名的证书

不建议在您的伺服器上使用自签名的证书。 如果你渴望 SSL，那么强烈建议您的伺服器具有已正确地签署了著名的 CA （凭证授权单位） 的证书。 不能做真正的证书寄使这一重要。

原因是接受自签名的证书绕过凭证连结验证，它允许任何伺服器凭证才被视为有效的设备。 这将打开沟通的人在中间的攻击。 它变得非常容易为骇客不仅拦截并读取在设备和伺服器之间的所有通信，但也要修改通信。 设备永远不会知道这种情况发生，因为它不会验证服务器的证书由受信任的 CA 签署。 该设备具有伺服器是它期望的人没有证据证明。 因为做的人在中间攻击的易用性，接受自签名的证书才略微比只在不受信任的网路上运行而不是 HTTPs 的 HTTP。 是的交通将会被加密，但它可能会用金钥加密从一个男人-中--中间，所以拦截中可以访问的一切，所以加密是无用除了对被动的观察员。 使用者信任 SSL 以是安全的和这将故意做出它不安全的所以，SSL 利用成为具误导性。 如果这将受信任的网路上使用 （即，您是完全控制企业内部），然后仍不建议使用自签名的证书。 在受信任的网路中的两项建议是因为网路本身是受信任的只是使用 HTTP 或获取由受信任的 CA （不自签名） 签署的证书。 网路是受信任的或者它不是。

在这里所描述的原则不是特定于 Apache 科尔多瓦，它们适用于所有用户端-伺服器通信。

当运行时科尔多瓦在 android 系统上，使用 `android:debuggable="true"` 应用程式中清单将允许 SSL 错误，例如凭证连结验证错误的自签章凭证。 所以您可以在此配置中，使用自签名的证书，但这不是一种配置，您的应用程式是在生产时，应使用。 意思是，只有在应用程式开发期间使用。

## 加密的存储

（TBD）

## 一般提示

### 不要使用 Android 姜饼 ！

*   设置您的 min-目标-sdk 级别高于 10。API 10 是姜饼，和姜饼由谷歌或设备制造商，不再受支援，因此不推荐由科尔多瓦队。 
*   姜饼已被证明是不安全和最大的一个有针对性的移动开放源码软体[HTTP://www.mobilemag.com/2012/11/06/andriod-2-3-gingerbread-security/][2]. 
*   在 Android 上的白名单不工作与姜饼或更低。 这意味著攻击者可以载入，然后会对所有的科尔多瓦 Api 的访问，可以使用该存取权限来窃取个人资料、 发送 SMS 消息到溢价率的数位，以及执行其他恶意行为的 iframe 中的恶意程式码。 

 [2]: http://bgr.com/2012/11/06/android-security-gingerbread-malware/

### 使用 InAppBrowser 的外部连结

*   打开任何外部网站的连结时，请使用 InAppBrowser。 这是比白一个功能变数名称和直接在您的应用程式中包括的内容，因为 InAppBrowser 将使用本机浏览器的安全功能，并不会给网站访问到您的科尔多瓦环境安全得多。 即使您信任的协力厂商网站，并将其包括在您的应用程式中直接，那协力厂商网站可能连结到恶意 web 内容。 

### 验证所有使用者输入

*   始终验证您的应用程式接受的任何和所有输入。 这包括使用者名、 密码、 日期、 上载的媒体等。 因为攻击者可以操纵您的 HTML 和 JS 资产 （无论是通过反编译您的应用程式或使用像 chrome://inspect 这样的调试工具），这应该也执行验证您在伺服器上，尤其是在将资料提交给任何后端服务之前。 
*   其他来来源资料应进行的验证： 使用者文档、 连络人、 推式通知

### 不缓存敏感性资料

*   如果使用者名、 密码、 地理定位资讯和其他敏感性资料被缓存，然后它可以潜在检索以后由未经授权的使用者或应用程式。

### 除非你知道你在做什么，否则不要使用 eval()

*   JavaScript 函数 eval() 有被虐待的历史悠久。不正确地使用它，可以打开您的代码注入攻击，调试困难和代码执行速度变慢了。 

### 不要假定您的原始程式码是安全的

*   因为从 HTML 和 JavaScript 的资产在本机容器中获取打包生成的科尔多瓦应用程式，不应考虑您的代码是安全的。 它是可能要进行反向工程科尔多瓦应用程式。 

## 推荐的文章和其他资源

*   [HTML5 安全作弊，详细说明了如何确保您的 HTML5 应用程式][3]
*   [Phonegap 条设备安全问题，例如，使用加密的资料][4]
*   [关于 web 视图中的众所周知的安全缺陷白皮书基于混合应用程式][5]

 [3]: https://www.owasp.org/index.php/HTML5_Security_Cheat_Sheet
 [4]: https://github.com/phonegap/phonegap/wiki/Platform-Security
 [5]: http://www.cis.syr.edu/~wedu/Research/paper/webview_acsac2011.pdf