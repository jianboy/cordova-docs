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

title: Windows 包装
---

# Windows 包装

你可以了解更多关于签署和包装在[MSDN](https://msdn.microsoft.com/en-us/library/hh446593(v=vs.85).aspx)上的应用 Windows 商店应用程式.

为了能够正确打包和签名 Windows 应用程式有是所需的几件事:

  * 签章凭证
  * 身份细节匹配提供的签章凭证

在 Windows 专案标识的详细资讯保存在名为 package.appxmanifest 的档。此档是自动填满每次科尔多瓦应用程式的构建。身份保留 3 重要栏位。

  * Name
  * Publisher
  * Version

可以从**config.xml**设置*NAme*和*Version*。*Publisher*可以作为生成的参数提供，或可以在**build.json**档上设置。

![]({{ site.baseurl }}/static/img/guide/platforms/win8/packaging.png)

从任一 CLI 或通过 build.json 档，可以提供签名的证书。证书相关 CLI 的标志是:

  * `--packageCertificateKeyFile` : 一旦创建了签章凭证包，可以使用此参数，将该证书与应用程式相关联。此标志将档路径作为参数。 如。 `> cordova build -- --packageCertificateKeyFile="platforms\windows\CordovaApp_TemporaryKey.pfx"`
  * `--packageThumbprint` : 包指纹用于验证封装证书金钥档的真实性。 创建证书金钥档时，将向最终使用者提供此值。 如。 `> cordova build -- --packageCertificateKeyFile="platforms\windows\CordovaApp_TemporaryKey.pfx" --packageThumbprint="ABCABCABCABC123123123123"`

或者，这些值可以使用指定组建组态档 (build.json) 使用 CLI (-buildConfig)。一个示例组建组态档:

    {
        "windows": {
            "debug": {
                "packageCertificateKeyFile": "platforms\\windows\\CordovaApp_TemporaryKey.pfx"
            },
            "release": {
                "packageCertificateKeyFile": "c:\\path-to-key\\keycert.pfx",
                "packageThumbprint": "ABCABCABCABC123123123123",
                "publisherId": "CN=FakeCorp.com, L=Redmond, S=Washington, C=US"
            }
        }
    }


此外，它还支援以混合和匹配的命令列参数和 build.json 档中的参数。从命令列参数的值将会得到优先。

# 如何创建证书金钥和标志科尔多瓦 windows 应用程式

需要分发和安装 Windows 应用商店应用程式签名的。 当你部署套装程式版本，这一过程将由 Visual Studio 通常进行处理。 我们要做 tmhis 没有 Visual Studio 创建我们自己的证书。

用于创建证书，我们需要使用[makecert.exe](https://msdn.microsoft.com/en-us/library/ff548309(v=vs.85).aspx)公用程式 此工具附带 Windows SDK，可以发现下`%ProgramFiles(x86) %\Windows Kits\8.1\bin\x64`或`%ProgramFiles(x86) %\Windows Kits\8.1\bin\x86`.

我们需要做的第一件事是创建为签署我们的应用程式的根键。

`makecert.exe -n "CN=FakeCorp.com" -r -eku "1.3.6.1.5.5.7.3.3,1.3.6.1.4.1.311.10.3.13" -e "01/01/2020" -h 0 -sv FakeCorp.com.pvk FakeCorp.com.cer`

要理解什么金钥做，这里是参数做了简要说明:

  * -n"CN=FakeCorp.com": 这是[X.509](http://en.wikipedia.org/wiki/X.509)证书主题名称。在这个例子中它是**C**处理逐渐显露出来**N**ame=FakeCorp.com。
  * -r: 创建[自签章凭证](http://en.wikipedia.org/wiki/Self-signed_certificate).
  * -eku #EKU_VAL #: 逗号分隔的增强型金钥用法 Oid。
      * 1.3.6.1.5.5.7.3.3 表示该证书是有效的代码签名。始终指定此值以限制证书的用途。
      * 1.3.6.1.4.1.311.10.3.13 指示证书尊重一生签署。 通常情况下，如果签名是时间戳记，只要证书是在点有效时间戳记的时候，该签名仍然有效即使在证书过期。 这 EKU 部队要过期而不管签名是否加盖时间戳记的签名。
  * -e"2020/1/1": 设置证书的过期日期。
  * -h 0: 将此证书下面的树的最大高度设置为 0，以防止证书被用于作为凭证授权单位 (CA) 可以颁发其他证书。
  * -sv FakeCorp.com.pvk: 输出 PVK 档。Windows 使用 PVK 档来存储用于代码签名的私密金钥。
  * FakeCorp.com.cer: 输出证书档。CER 档用于存储 X.509 凭证。

在第一次运行金钥之后, 在萤幕上就会弹出输入私人密码:

![]({{ site.baseurl }}/static/img/guide/platforms/win8/createprivatekeywindow.png)

一旦创建了 pvk 和 cer 档，我们需要从这些证书创建一个 pfx 档。 Pfx (个人交换格式) 档包含各种加密资讯，如证书、 根凭证授权单位，凭证连结和私密金钥。 进行包装证书，我们将使用一种工具叫[pvk2pfx](https://msdn.microsoft.com/en-us/library/ff550672(v=vs.85).aspx)。 此工具附带 Windows SDK，可以发现下 `%ProgramFiles(x86)%\Windows Kits\8.1\bin\x64` 或`%ProgramFiles(x86)%\Windows Kits\8.1\bin\x86`.

`pvk2pfx -pvk FakeCorp.com.pvk -pi pvkPassword -spc FakeCorp.com.cer -pfx FakeCorp.com.pfx -po pfxPassword`

地点:

  * pvk: 输入 pvk 档案名称
  * pi: pvk 密码
  * spc: 输入证书档案名
  * pfx: 输出 pfx 档案名称
  * 大埔: pfx 密码;pvk 密码如果不提供相同

如果我们提供此 pfx 档到 build.json 档中，我们将会有以下错误:"金钥档可能受密码保护。 要更正此问题，请尝试手动导入证书到当前使用者的个人凭证存储区。"。 为了将其导入我们必须使用[certutil](https://technet.microsoft.com/en-us/library/ee624045(v=ws.10).aspx)从 admin 提示符:

`certutil -user -p PASSWORD -importPFX FakeCorp.com.pfx`

地点:

  * user: 指定"当前使用者"个人存储区
  * p: pfx 档密码
  * importPfx: pfx 档的名称

一旦安装完毕下, 一步是将 packageThumbprint 和 packageCertificateKeyFile 添加到 build.json。 为了找到 packageThumbprint，搜索的公开我们已经与证书关联:

`powershell -Command " & {dir -path cert:\LocalMachine\My | where { $_.Subject -like \"*FakeCorp.com*\" }}"`

一旦这些最后的值提供。科尔多瓦应该成功打包和签名应用程式。
