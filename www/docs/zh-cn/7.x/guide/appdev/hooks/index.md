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

title: 钩子指南
toc_title: Hooks
---

# 钩子指南

Cordova钩表示特别的脚本可以由应用程式和外挂程式开发人员添加或甚至由您自己构建体系，以自订Cordova命令。 钩脚本可以通过将其添加到特殊的预定义资料夹 (`/hooks`) 或通过设定档 (`config.xml`和`plugin.xml`) 定义和连续运行顺序如下:

  * 应用程式挂钩从`/hooks`;
  * 应用钩子从`config.xml`;
  * 从`plugins/.../plugin.xml`外挂程式钩子.

**注**: `/hooks`目录被认为是支援在 config.xml 和 plugin.xml 钩元素，否决。

## 支援的钩类型

支援以下的钩子类型:

    after_build
    after_compile
    after_clean
    after_docs
    after_emulate
    after_platform_add
    after_platform_rm
    after_platform_ls
    after_plugin_add
    after_plugin_ls
    after_plugin_rm
    after_plugin_search
    after_plugin_install // Plugin hooks in plugin.xml are executed for a plugin being installed only
    after_prepare
    after_run
    after_serve
    before_build
    before_clean
    before_compile
    before_docs
    before_emulate
    before_platform_add
    before_platform_rm/
    before_platform_ls
    before_plugin_add
    before_plugin_ls
    before_plugin_rm
    before_plugin_search/
    before_plugin_install // Plugin hooks in plugin.xml are executed for a plugin being installed only
    before_plugin_uninstall // Plugin hooks in plugin.xml are executed for a plugin being uninstalled only
    before_prepare
    before_run
    before_serve
    pre_package // Windows and Windows Phone only
    

## 如何定义钩子

### 通过`/hooks`目录

**注意**: 此方法被认为是支援在 config.xml 和 plugin.xml 钩元素，否决。

在相应的钩子类型触发时执行自订操作、 使用钩型作为 '钩' 目录内的子资料夹的名称和地方您编写的指令档在这里，例如:

    # script file will be automatically executed after each build
    hooks/after_build/after_build_custom_action.js
    

当使用这些钩子，他们总是将作为不作为可载入 JavaScript 模组的可执行档运行。 **记住**: 在这种情况下使您的脚本可执行。

### Config.xml

钩子可以定义在专案的`config.xml`使用`< 钩 >`元素，例如:

    <hook type="before_build" src="scripts/appBeforeBuild.bat" />
    <hook type="before_build" src="scripts/appBeforeBuild.js" />
    <hook type="before_plugin_install" src="scripts/appBeforePluginInstall.js" />
    
    <platform name="wp8">
        <hook type="before_build" src="scripts/wp8/appWP8BeforeBuild.bat" />
        <hook type="before_build" src="scripts/wp8/appWP8BeforeBuild.js" />
        <hook type="before_plugin_install" src="scripts/wp8/appWP8BeforePluginInstall.js" />
        ...
    </platform>
    
    <platform name="windows8">
        <hook type="before_build" src="scripts/windows8/appWin8BeforeBuild.bat" />
        <hook type="before_build" src="scripts/windows8/appWin8BeforeBuild.js" />
        <hook type="before_plugin_install" src="scripts/windows8/appWin8BeforePluginInstall.js" />
        ...
    </platform>
    

### 外挂程式钩子 (plugin.xml)

作为外挂程式的开发人员，您可以定义挂接在`plugin.xml`中那样使用`< 钩 >`元素的脚本:

    <hook type="before_plugin_install" src="scripts/beforeInstall.js" />
    <hook type="after_build" src="scripts/afterBuild.js" />
    
    <platform name="wp8">
        <hook type="before_plugin_install" src="scripts/wp8BeforeInstall.js" />
        <hook type="before_build" src="scripts/wp8BeforeBuild.js" />
        ...
    </platform>
    

`before_plugin_install`， `after_plugin_install`， `before_plugin_uninstall`外挂程式钩子将发射专门为正在安装卸载该外挂程式。

## 指令码介面

### JAVAscript

如果您正在编写钩使用 Node.js，应使用下列模组定义:

```javascript
module.exports = function(context) {
    ...
}
```

您可以使用问: 你 scipts 非同步

```javascript
module.exports = function(context) {
    var Q = context.requireCordovaModule('q');
    var deferral = new Q.defer();

    setTimeout(function(){
      console.log('hook.js>> end');
    deferral.resolve();
    }, 1000);

    return deferral.promise;
}
```

`上下文`物件包含的钩子类型，执行的脚本的完整路径，钩选项，命令列参数传递给Cordova和顶级的"Cordova"物件:

```json
{
  "hook": "before_plugin_install",
  "scriptLocation": "c:\\script\\full\\path\\appBeforePluginInstall.js",
  "cmdLine": "The\\exact\\command\\cordova\\run\\with arguments",
  "opts": {
    "projectRoot":"C:\\path\\to\\the\\project",
    "cordova": {
      "platforms": ["wp8"],
      "plugins": ["com.plugin.withhooks"],
      "version": "0.21.7-dev"
    },
    "plugin": {
      "id": "com.plugin.withhooks",
      "pluginInfo": {
        ...
      },
      "platform": "wp8",
      "dir": "C:\\path\\to\\the\\project\\plugins\\com.plugin.withhooks"
    }
  },
  "cordova": {...}
}

```

`coNtext.opts.plugin`物件仅将传递到外挂程式钩子脚本。

您还可以通过以下方式使用`coNtext.requireCordovaModule`脚本中要求Cordova的附加模组:

```javascript
var Q = context.requireCordovaModule('q');
```

**注意**: 新模组载入程式指令码介面用于定义通过`config.xml`或`plugin.xml`只的`.js`档。 出于相容性原因钩档指定通过`/hooks`资料夹运行通过节点 child_process 菌种，见 ' 非 javascript 一节。

### 非 javascript

**注意**: 我们强烈推荐写你钩使用 Node.js，所以，他们都是跨平台的见上面的 'JAVAscript 一节。

非 javascript 脚本从专案的根目录中通过节点 child_process 菌种运行，并且都经过目录根作为第一个参数。 所有其他选项都传递到脚本使用环境变数:

  * CORDOVA_VERSION-Cordova CLI 的版本。
  * CORDOVA_PLATFORMS-的逗号分隔清单命令适用于的平台 (例如: android、 ios)。
  * CORDOVA_PLUGINS-以逗号分隔的清单中的外挂程式 Id 命令适用于 (如: org.apache.cordova.file、 org.apache.cordova.file 转让)
  * CORDOVA_HOOK-的挂钩上正在执行的路径。
  * CORDOVA_CMDLINE-传递到Cordova的确切的命令列参数 (例如: Cordova运行 ios — — 模仿)

如果一个脚本返回一个非零结束代码，然后将中止父Cordova命令。

此外请注意，即使您正在在 Windows 上，以防你钩脚本并不是蝙蝠档 (这建议，如果你想要你上班非 Windows 作业系统中的脚本) Cordova CLI 将期望一切线作为第一行才知道翻译它需要使用启动脚本。 一切行应匹配下面的示例:

    #!/usr/bin/env [name_of_interpreter_executable]
    

## 示例用法

此示例演示Cordova钩用法跟踪到主控台输出为 Android 平台生成的.apk 档的大小。

创建空白Cordova app 并向`config.xml`来告诉Cordova在每个平台生成后运行`afterBuild.js`脚本添加下面的定义。

    <hook type="after_build" src="scripts/afterBuild.js" />
    

创建`scripts/afterBuild.js`档并添加下面的实现。 我们使用`fs.stat`方法的非同步版本来演示如何非同步功能可以通过挂钩。

    module.exports = function(ctx) {
        // make sure android platform is part of build 
        if (ctx.opts.platforms.indexOf('android') < 0) {
            return;
        }
        var fs = ctx.requireCordovaModule('fs'),
            path = ctx.requireCordovaModule('path'),
            deferral = ctx.requireCordovaModule('q').defer();
    
        var platformRoot = path.join(ctx.opts.projectRoot, 'platforms/android');
        var apkFileLocation = path.join(platformRoot, 'build/outputs/apk/android-debug.apk');
    
        fs.stat(apkFileLocation, function(err,stats) {
            if (err) {
                 deferral.reject('Operation failed');
            } else {
                console.log('Size of ' + apkFileLocation + ' is ' + stats.size +' bytes');
                deferral.resolve();
            }
        });
    
        return deferral.promise;
    };
    

参数`环磷醯胺`在上面例子中通过Cordova和表示脚本的完整路径、 目标平台、 命令列参数等的执行上下文，也暴露出额外的协助工具。 有关更多详细资讯请参见`指令码介面`节以上。

现在可以添加 android 平台，并执行生成。

    cordova platform add android
    ..
    cordova build
    ..
    Size of path\to\app\platforms\android\build\outputs\apk\android-debug.apk is 1821193 bytes
    

可以在这里找到更多好的用法示例:

<http://devgirl.org/2013/11/12/three-hooks-your-cordovaphonegap-project-needs/>