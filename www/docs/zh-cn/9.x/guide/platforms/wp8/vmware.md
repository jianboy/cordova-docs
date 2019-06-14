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

title: 配置 VMWare 融合
---

# 配置 VMWare 融合

这一节演示如何配置 VMWare 融合在 Mac 上，以便您可以使用科尔多瓦生成 Windows Phone 应用程式。

[Microsoft 开发人员网路][1]提供有关如何运行 Windows 下 VMWare 融合的一般说明。 之后安装 Windows，请执行以下步骤：

 [1]: http://msdn.microsoft.com/en-US/library/windows/apps/jj945426

1.  在 VMWare 融合内, 选择您已编写并选择**设置**的 Windows 8 磁片映射.

2.  选择的**处理器和记忆体**的配置选项。 请确保指定*两个*处理器内核，并**启用在此虚拟机器的虚拟机器管理程式应用程式**：
    
    ![][2]
    
    Windows Phone 模拟器单独使用半位元组的记忆体，所以，总体来说，你应该为 VMWare 预留至少 2 GB。

3.  选择**高级**设置。启用**首选虚拟化引擎： 英特尔 VT-x 与 EPT**选项：
    
    ![][3]

4.  修改*.vmx*档，添加或修改以下设置：
    
        hypervisor.cpuid.v0 ="FALSE"mce.enable ="TRUE"vhv.enable ="TRUE"
        

 [2]: {{ site.baseurl }}/static/img/guide/platforms/wp8/vmware_memory_opts.png
 [3]: {{ site.baseurl }}/static/img/guide/platforms/wp8/vmware_advanced_opts.png

一旦你完成这些步骤，你准备然后安装 Windows Phone SDK。请参阅 Windows Phone 8 平台指南的详细资讯。
