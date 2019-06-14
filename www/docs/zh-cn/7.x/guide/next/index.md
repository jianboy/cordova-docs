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

title: 下一步
toc_title: Next Steps
---

# 下一步

对于开发人员了解如何使用科尔多瓦 CLI 并使使用的外挂程式，有几个东西你可能要考虑旁边建设得更好，更多性能科尔多瓦应用研究。 下面的文档提供了各种主题有关的最佳做法、 测试、 升级和其他主题的意见，但并不意味著要规范。 认为这是你为你的成长作为科尔多瓦开发人员的启动点。 同时，如果你看到一些可以做得更好，请[作出贡献][1]!

 [1]: http://cordova.apache.org/#contribute

本指南包含以下主题：

*   最佳做法
*   处理升级
*   测试科尔多瓦应用程式
*   科尔多瓦的调试应用程式
*   使用者介面
*   特殊的注意事项
*   保持
*   获取说明 

# 最佳做法科尔多瓦应用程式开发

## 1） SPA 是你的朋友

首先-科尔多瓦应用程式应在 SPA （单页面应用程式） 设计。 定义宽泛，SPA 是一个用户端应用程式，从一个请求 web 页的运行。 使用者载入一组初始的资源 （HTML、 CSS 和 JavaScript） 和进一步更新 （显示一个新的视图，资料载入） 通过 AJAX。 水疗中心常用应用于更复杂的用户端应用程式。 GMail 是一个伟大的例子。 你载入 GMail、 邮件视图、 编辑和组织后都是由更新而不是实际上离开当前页面 DOM 载入一个新的人。

使用一个水疗中心可以说明您组织您的应用程式在一个更有效率的方式，但它也有科尔多瓦申请的具体好处。 科尔多瓦应用程式必须等待要火可能使用的任何外挂程式之前的 [deviceready](../../cordova/events/events.deviceready.html) 事件。 如果您不使用水疗中心，和您的使用者按一下去从一个网页到另一个，你将不得不等待 [deviceready](../../cordova/events/events.deviceready.html) 再次触发之前要使用一个外挂程式。 这很容易忘记，您的应用程式变得更大。

即使您选择不使用科尔多瓦，创建一个移动应用程式不使用单个页面结构将产生严重的性能影响。 这是因为页面之间导航需要脚本、 资产等，被重新载入。 即使这些资产则进行缓存，仍有性能问题。

水疗中心库您可以在科尔多瓦应用程式中使用的示例如下：

*   [AngularJS][2]
*   [EmberJS][3]
*   [骨干][4]
*   [剑道 UI][5]
*   [摩纳卡][6]
*   [ReactJS][7]
*   [Sencha 触摸][8]
*   [jQuery 移动][9]

 [2]: http://angularjs.org
 [3]: http://emberjs.com
 [4]: http://backbonejs.org
 [5]: http://www.telerik.com/kendo-ui
 [6]: http://monaca.mobi/en/
 [7]: http://facebook.github.io/react/
 [8]: http://www.sencha.com/products/touch/
 [9]: http://jquerymobile.com

和许多，许多，更多。

## 2） 性能注意事项

新的科尔多瓦开发人员可以利用的最大错误之一是想当然地认为他们会在桌上型电脑的性能是相同的他们会在行动装置上。 虽然每年我们的行动装置已经变得更强大，但它们仍然缺乏电力和桌上型电脑性能。 行动装置通常有更少的 RAM 和很远从他们的桌面上的 GPU （或甚至笔记本电脑） 的弟兄们。 小窍门的完整清单将太多了，但这里有几件事要牢记 （与更长的时间在结束了为进一步研究的资源的清单）。

**按一下与触摸**-你能犯的最大和最简单的错误是使用 click 事件。 虽然这些手机上很好的"工作"，大多数设备征收上他们的 300ms年延迟，以区分触摸和触摸"持有"事件。 使用 `touchstart` ，或 `touchend` ，将导致一个戏剧性的改善 — — 300ms年不听起来很多，但它可以导致忽动忽停的 UI 更新和行为。 您还应该考虑"触摸"事件的事实不支援在非 webkit 浏览器，请参阅[CanIUse][10]。 为了应付这些限制，您可以签出不同的库，如 HandJS 和 Fastouch。

 [10]: http://caniuse.com/#search=touch

**CSS 转换与 DOM 操作**— — 使用硬体加速 CSS 转换将大大优于使用 JavaScript 来创建动画。 请参见本节末尾的资源的清单。

**网路吸**-好的网路不总是很烂，但移动网路的延迟甚至良好的移动网路，比你可能想像的差很远。 一个桌面的应用程式，吃了 500 行的 JSON 资料，每隔 30 秒，将既慢行动装置，以及电池的猪。 请牢记科尔多瓦的应用程式有多种的方式来保持资料在应用程式 （本机存放区和档案系统，例如）。 缓存本地资料，认识到你来回发送的资料量。 您的应用程式通过一个蜂窝网路连接时，这是一个特别重要的考虑因素。

**额外的性能文章和资源**

*   ["你一半屁股它"][11]
*   ["顶十的性能提示 PhoneGap 和混合应用程式"][12]
*   ["快速应用程式和网站的 JavaScript"][13]

 [11]: http://sintaxi.com/you-half-assed-it
 [12]: http://coenraets.org/blog/2013/10/top-10-performance-techniques-for-phonegap-and-hybrid-apps-slides-available/
 [13]: https://channel9.msdn.com/Events/Build/2013/4-313

## 3） 认识和处理离线状态

请参阅关于网路上的提示。 你不仅可以在慢速网路上，这是完全有可能为您的应用程式必须完全离线。 您的应用程式应该处理这一种智慧化的方式。 如果您的应用程式不存在，人们会以为您的应用程式被破坏。 鉴于它是多么容易处理 （科尔多瓦支援侦听离线和线上活动），就绝对没有理由为您的应用程式不回应时离线运行。 一定要测试 （见下面的测试一节） 您的应用程式，一定要测试您的应用程式是如何处理的当你开始处于一种状态，然后切换到另一个。

注意连线和离线的事件，如网路连接 API 不是完美。 您可能需要依赖于使用 XHR 请求，看看设备是否真正离线或连线。 在年底的一天，肯定添加某种形式的支助网路问题 — — 事实上，苹果商店 （和可能其他存储） 将拒绝不妥善处理离线/线上状态的应用程式。 关于这一主题的更多讨论，请参见["是对的这件事吗?"][14]

 [14]: http://blogs.telerik.com/appbuilder/posts/13-04-23/is-this-thing-on-%28part-1%29

# 处理升级

## 升级科尔多瓦专案

如果您现有的专案使用科尔多瓦创建 3.x 版，您可以通过发出以下升级该专案：

    科尔多瓦平台更新平台名称 ios，android，等。
    

如果现有专案所创建的是根据之前科尔多瓦的版本 3.x，它可能会最好创建一个新的科尔多瓦 3.x 专案，然后将您现有的专案代码和资源复制到新专案。 典型的步骤：

*   创建一个新的科尔多瓦 3.x 专案 (科尔多瓦创建...)
*   将 www 资料夹从您的旧专案复制到新的专案
*   将任何配置设置从旧专案复制到新的专案
*   添加到新专案的旧专案中使用任何外挂程式
*   生成您的专案
*   测试、 测试、 测试 ！

该专案以前的版本，无论是绝对关键的你读完上在更新后的版本中，更改了什么，更新可能会中断您的代码。 最好的地方要查找此资讯将公布在仓库中，并在科尔多瓦的博客上的版本资讯中。 你会想要进行全面测试您的应用程式，验证它工作正常后，则执行更新。

注： 某些外挂程式可能无法与科尔多瓦的新版本相容。 如果一个外挂程式不是相容的你可能能够找到一个更换外挂程式，你需要什么，或者您可能需要推迟升级您的专案。 另外，改变该外挂程式，以便在最新的版本下工作并重新对社会有贡献。

## 外挂程式升级

截至科尔多瓦 3.4 是没有升级更改的外挂程式使用单个命令的机制。相反，删除该外挂程式并添加它回到您的专案，并将安装新的版本：

    科尔多瓦外挂程式 rm com.some.plugin 科尔多瓦外挂程式添加 com.some.plugin
    

一定要检查更新的外挂程式的文档，因为您可能需要调整代码以使用最新的版本。 此外，再检查一遍，该外挂程式的新版本与您的专案版本的科尔多瓦。

始终在测试您的应用程式，以确保安装新外挂程式已不打破你预料不到的东西。

如果您的专案具有大量的外挂程式，您需要更新，则可能会节省时间来创建壳或批次处理脚本中删除并添加的外挂程式使用一个命令。

# 测试科尔多瓦应用程式

测试您的应用程式是非常重要的。科尔多瓦团队使用茉莉花却将任何 web 友好单位测试解决方案。

## 在实际设备上与模拟器上测试

它并非罕见时要使用桌面浏览器和设备模拟器/模拟器开发科尔多瓦的应用程式。 然而，这是非常重要的是您测试您的应用程式上尽可能多的物理设备，尽你所能：

*   模拟器只是： 模拟器。 例如，您的应用程式可能工作在 iOS 模拟器没有问题，但它真正的设备 （尤其是在某些情况下，例如一种低记忆体状态） 上可能会失败。 或者，您的应用程式实际上可能失败在模拟器上，虽然它在实际设备上只是正常工作。 
*   模拟程式只是： 模拟器。 他们并不代表您的应用程式将在一个物理设备上运行的多好。 例如，一些模拟器可能呈现您的应用程式与显示出现乱码，虽然实际设备没有任何问题。 （如果你确实遇到此问题，禁用在模拟程式中的主机 GPU。
*   模拟器都比您的物理设备一般快。 模拟器，另一方面，是通常速度较慢。 由它在模拟器或模拟器中的执行不判断您的应用程式的性能。 做以它对光谱的实际设备的运行方式来判断您的应用程式的性能。
*   它是不可能为您的应用程式如何回应通过使用模拟器或模拟器的触摸得到的感觉很好。 相反，真正的设备上运行的应用程式可以点出大小的使用者介面元素、 反应能力等问题。
*   虽然是很好，以便能够测试仅在平台每一台设备上，它是最佳体育许多不同的作业系统版本的很多设备上进行测试。 例如，什么作品对你特别的 Android 智慧手机上可能会失败另一个 Android 设备。 什么工作 7 的 iOS 设备上的 iOS 6 设备上可能会失败。

当然，这是不可能在市场上每个可能的设备上进行测试。 出于这个原因，它是明智招募许多测试人员有不同的设备。 虽然他们不会抓住每一个问题，很好他们会发现怪癖和你永远找不到一个人的问题。

小贴士： 它有可能在 Android nexus 系列设备很容易闪不同版本的 Android 设备上。 这个简单的过程将使您能够轻松地测试您的应用程式对不同级别的 Android 与一个单一的设备，没有排尿您的保修服务或要求你到"根"或"越狱"您的设备。 谷歌安卓系统工厂的图像和说明都位于： HTTPs://developers.google.com/android/nexus/images#instructions

# 科尔多瓦的调试应用程式

调试科尔多瓦需要进行一些设置。不像桌面应用程式，你只需打开 dev 工具无法在您的行动装置上，并开始调试，幸运的是，有一些不错的方案。

## iOS 调试

### Xcode

使用 Xcode 可以调试应用程式科尔多瓦的 iOS 本机侧。 确保调试区域显示 （-> 调试区域视图）。 一旦您的应用程式运行在设备 （或类比） 上，您可以在调试区域查看日志输出。 这是任何错误或警告的列印位置。 此外可以在原始档案中设置中断点。 这将允许您逐句通过一行代码一次，那次查看变数的状态。 命中中断点时，变数的状态是显示在调试区域。 一旦您的应用程式是在设备上启动并运行，你可以把 Safari 的 web 督察 （如下所述） 来调试您的应用程式 web 视图和 js 的一面。 有关更多详细资讯和说明，请参阅 Xcode 指南： [Xcode 调试指南][15]

 [15]: https://developer.apple.com/library/mac/documentation/ToolsLanguages/Conceptual/Xcode_Overview/DebugYourApp/DebugYourApp.html#//apple_ref/doc/uid/TP40010215-CH18-SW1

### Safari 远端侦错 Web 督察

使用 Safari 的 web 检查器，您可以调试的 web 视图和 js 代码科尔多瓦在应用程式中。 这工作只在 OSX 上，只与 iOS 6 （或更高）。 它使用 Safari 来连接到您的设备 （或类比），并将连接到科尔多瓦应用程式的浏览器的开发工具。 你得到你期望从 DOM 检查/操作、 JavaScript 调试器、 网路检测、 主控台和开发工具。 像 Xcode，使用 Safari 的 web 检查器可以在 JavaScript 代码中设置中断点并查看变数的状态在那段时间。 您可以查看任何错误、 警告或消息列印到主控台。 当您的应用程式正在运行，您还可以直接从主控台运行 JavaScript 命令。 有关如何设置它，你可以做的更多详细资讯，请参阅这篇优秀博客： [HTTP://moduscreate.com/enable-remote-web-inspector-in-ios-6/][16]和本指南： [Safari 网路督察指南][17]

 [16]: http://moduscreate.com/enable-remote-web-inspector-in-ios-6/
 [17]: https://developer.apple.com/library/safari/documentation/AppleApplications/Conceptual/Safari_Developer_Guide/Introduction/Introduction.html

## 铬远端侦错

Safari 版本几乎一样，这只与 Android 工作但可以从任何桌面作业系统使用。 它需要最小的 Android 4.4 （奇巧）、 最低 API 级别的 19 和铬 30 + （在桌面上）。 一旦连接，您可以得到相同的 Chrome 开发工具体验移动应用程式像你与你的桌面应用程式。 更妙的是，Chrome 开发工具有一个镜像选项表明您在行动装置上运行的应用程式。 这是不仅仅是一个视图-您可以向下滚动并按一下从开发工具，它在行动装置上更新。 铬远端侦错功能的更多详细资讯可以在这里找到： [HTTPs://developers.google.com/chrome/mobile/docs/debugging][18]

 [18]: https://developers.google.com/chrome/mobile/docs/debugging

它是可能使用 Chrome 开发工具来检查 iOS 应用程式，通过 WebKit 代理： [HTTPs://github.com/google/ios-webkit-debug-proxy/][19]

 [19]: https://github.com/google/ios-webkit-debug-proxy/

## 波纹

波纹是一个桌面的基于的模拟器科尔多瓦专案。 本质上，它允许您在您的桌面应用程式中运行科尔多瓦应用和假科尔多瓦的各种功能。 例如，它允许您类比加速度感应器检测摇事件。 它通过让您从您的硬碟上选择一张图片假货摄像头 API。 波纹让你更专注于您的自订代码，而不是担心科尔多瓦外挂程式。 你可以在这里找到更多关于波纹： [HTTP://ripple.incubator.apache.org/][20]

 [20]: http://ripple.incubator.apache.org/

## Weinre

Weinre 创建可以承载您科尔多瓦的应用程式的远端侦错用户端的本机伺服器。 您已经安装并启动它后，你将某行代码复制到您的科尔多瓦应用程式，然后重新开机它。 然后可以在您的桌面上，使用应用程式打开一个 dev 工具面板。 Weinre 不是很高档的铬和 Safari 远端侦错但有工作的作业系统和平台的范围要大得多的效益。 更多的资讯可以在这里找到： [HTTP://people.apache.org/~pmuellr/weinre/docs/latest/][21]

 [21]: http://people.apache.org/~pmuellr/weinre/docs/latest/

## 其他选项

*   黑莓 10 支援以及调试：[文档][22]
*   你可以调试以及使用火狐浏览器的应用程式管理器，请参见[此博客文章][23]和此[MDN 条][24].
*   更多的例子和解释上面的调试提示，请参阅： [HTTP://developer.telerik.com/featured/a-concise-guide-to-remote-debugging-on-ios-android-and-windows-phone/][25]

 [22]: https://developer.blackberry.com/html5/documentation/v2_0/debugging_using_web_inspector.html
 [23]: https://hacks.mozilla.org/2014/02/building-cordova-apps-for-firefox-os/
 [24]: https://developer.mozilla.org/en-US/Apps/Tools_and_frameworks/Cordova_support_for_Firefox_OS#Testing_and_debugging
 [25]: http://developer.telerik.com/featured/a-concise-guide-to-remote-debugging-on-ios-android-and-windows-phone/

# 使用者介面

构建一个科尔多瓦应用程式，看起来不错移动可以是一种挑战，尤其是开发商。 很多人选择使用 UI 框架使这个容易。 这里是您可能想要考虑的选项短名单。

*   [jQuery 移动][9]-jQuery 移动自动增强您的移动优化的布局。它也可以处理自动为你创建一个水疗中心。
*   [离子][26]-此功能强大的 UI 框架实际上有它自己的 CLI 来处理创建专案。 
*   [棘轮][27]-带给你的那些创建引导的人。 
*   [剑道 UI][5] -开放原始码的使用者介面和应用程式框架从 Telerik。
*   [面漆][28]
*   [ReactJS][7]

 [26]: http://ionicframework.com/
 [27]: http://goratchet.com/
 [28]: http://topcoat.io

建立您的使用者介面，时，重要的是思考你的目标的所有平台和使用者的期望之间的差异。 例如，有 iOS 样式的使用者介面的 Android 应用程式可能不会很好与使用者。 这有时是即使执行各种应用程式商店。 正因为如此，很重要的尊重每个平台的公约，因此熟悉各种人机界面指南:

*   [iOS][29]
*   [安卓系统][30]
*   [Windows Phone][31]

 [29]: https://developer.apple.com/library/ios/documentation/userexperience/conceptual/MobileHIG/index.html
 [30]: https://developer.android.com/designWP8
 [31]: http://dev.windowsphone.com/en-us/design/library

## 其他 UI 文章和资源

尽管浏览器引擎变得更多、 更多标准的投诉，我们仍然生活在一个带首码的世界 （-webkit 和-女士） 开发 UI 中的跨浏览器的应用程式时，下面的文章是宝贵： [HTTP://blogs.windows.com/windows_phone/b/wpdev/archive/2012/11/15/adapting-your-webkit-optimized-site-for-internet-explorer-10.aspx][32]

 [32]: http://blogs.windows.com/windows_phone/b/wpdev/archive/2012/11/15/adapting-your-webkit-optimized-site-for-internet-explorer-10.aspx

# 特殊的注意事项

虽然科尔多瓦跨平台开发更加容易，但它是不可能提供 100%从底层本机平台的隔离。所以要了解限制。

## 平台的怪癖

在阅读文档时，寻找其中简要说明了不同的行为或要求在多个平台上的部分。 如果存在，这些将是在一节题为"安卓 Quirks 」，"iOS 怪癖"等。 通读这些怪癖，觉察到它们作为你工作与科尔多瓦。

## 载入远端内容

调用科尔多瓦 JavaScript 函数从一个远端载入的 HTML 页面 （不存储在本地设备上的 HTML 页） 是一种不受支援的配置。 这是因为科尔多瓦被设计用来此，和 Apache 科尔多瓦社区并没有测试此配置。 虽然它可以工作在某些情况下，它不是建议也不支援。 还有挑战与同源策略，保持上的 javascript 代码和科尔多瓦的本机部分同步相同的版本 （因为他们耦合通过私人的 Api 可能会更改），在调用本机的本地函数和潜在的应用程式商店拒绝的远端内容的可信度。

应该做的远端载入 HTML 内容在 web 视图中显示使用科尔多瓦的 InAppBrowser。 InAppBrowser 专门设计，以便 JavaScript 运行那里没有存取权限的但对科尔多瓦 JavaScript Api 为上面列出的原因。 请参阅安全指南。

# 保持

这里有几种方法可以更新科尔多瓦。

*   [科尔多瓦博客][33]订阅.
*   订阅的[开发人员名单][34]。请注意--这不是一个支援组!相反，这是发展的科尔多瓦是的讨论。

 [33]: http://cordova.apache.org/#news
 [34]: http://cordova.apache.org/#mailing-list

# 获取说明

下面的连结是最好的地方去科尔多瓦的说明：

*   计算机: [HTTP://stackoverflow.com/questions/tagged/cordova][35]通过使用科尔多瓦标记，您可以查看和流览所有的科尔多瓦问题。 请注意计算机自动转换到"科尔多瓦""Phonegap"标记，所以这种方式你将能够访问历史问题以及
*   PhoneGap 谷歌组: [HTTPs://groups.google.com/forum/#! 论坛/phonegap][36]此谷歌组的时候老支援论坛科尔多瓦还叫 PhoneGap。 虽然仍有很多频繁的这一组的科尔多瓦使用者，科尔多瓦表示，社会上对这群不会专注并改用计算机支援兴趣
*   Meetup: [HTTP://phonegap.meetup.com][37] -考虑寻找本地的科尔多瓦/PhoneGap meetup 组

 [35]: http://stackoverflow.com/questions/tagged/cordova
 [36]: https://groups.google.com/forum/#!forum/phonegap
 [37]: http://phonegap.meetup.com