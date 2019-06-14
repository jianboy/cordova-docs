[![Build Status](https://travis-ci.org/apache/cordova-docs.svg?branch=master)](https://travis-ci.org/apache/cordova-docs)

# Cordova Docs / Website

This repository contains the source code for the Cordova website at [cordova.apache.org](https://cordova.apache.org).

The site is also reachable with the short domain [cordova.io](http://cordova.io), the important subareas as [docs.cordova.io](http://docs.cordova.io), [blog.cordova.io](http://blog.cordova.io) and [plugins.cordova.io](http://plugins.cordova.io).

## 中文网站构架

```
git clone https://github.com/jianboy/cordova-docs-cn.git

docker-compose up -d

docker attach containerid -it /bin/bash

npm install

npm run-script build

```


或者手动执行（更快）：
```
node tools/bin/toc.js www/docs www/_data/toc

bundle exec jekyll build --config conf/_config.yml,conf/_defaults.yml,conf/_version.yml,conf/_prod.yml --watch

```