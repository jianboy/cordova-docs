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

title: SQLResultSetRowList
---

# SQLResultSetRowList

属性之一的 `[SQLResultSet](../sqlresultset/sqlresultset.html)` 从 SQL 查询中包含的行返回。

## 属性

*   **长度**： SQL 查询所返回的行数。

## 方法

*   **专案**： 返回 JavaScript 物件所表示的指定索引处的行。

## 详细资讯

`SQLResultSetRowList`包含从 SQL 返回的资料 `select` 语句。 该物件包含 `length` 属性，该值多少行 `select` 语句返回。 若要获取的资料行，调用 `item` 方法，以指定一个索引。 它返回 JavaScript `Object` 其属性是的资料库列 `select` 反对执行语句。

## 支援的平台

*   Android 系统
*   黑莓手机 WebWorks （OS 6.0 和更高）
*   iOS
*   Tizen

## 执行 SQL 快速示例

    函数 queryDB(tx) {tx.executeSql (' 选择 * 从演示 '、 []、 querySuccess、 errorCB);}函数 querySuccess （德克萨斯州，结果） {var len = results.rows.length ；console.log ("演示表："+ len +"行发现") ；为 (var 我 = 0 ； 我 < len ； i + +) {console.log ("行 ="+ i +"ID ="+ results.rows.item (i).id +"的资料 ="+ results.rows.item(i).data) ；}} 函数 errorCB(err) {警报 （"处理 SQL 时出错:"+ err.code） ；} var db = window.openDatabase ("资料库"、"1.0"，"Cordova演示"，200000) ；db.transaction errorCB queryDB） ；
    

## 完整的示例

    <!DOCTYPE html >< html >< 头 >< 标题 > 存储示例 < / 标题 >< 脚本类型 ="文本/javascript"charset ="utf 8"src="cordova.js">< / 脚本 >< 脚本类型 ="文本/javascript"charset ="utf 8"> / / 等待设备 API 库载入 / / document.addEventListener ("deviceready"，onDeviceReady，false);/ / 填充资料库 / / 函数 populateDB(tx) {tx.executeSql ('下拉表如果存在演示') ；tx.executeSql (' 创建表如果不存在演示 （id 唯一的资料） ') ；tx.executeSql (' 的值插入到演示 （id、 资料） （1，"第一行"） ') ；tx.executeSql （插入到演示 （id、 资料） 值 （2，"第二行")) ；} / / 查询资料库 / / 函数 queryDB(tx) {tx.executeSql (' 选择 * 从演示 '、 []、 querySuccess、 errorCB） ；} / / 查询成功回档 / / 函数 querySuccess （德克萨斯州，结果） {var len = results.rows.length ；console.log ("演示表："+ len +"行发现") ；为 (var 我 = 0 ； 我 < len ； i + +) {console.log ("行 ="+ i +"ID ="+ results.rows.item (i).id +"的资料 ="+ results.rows.item(i).data) ；}} / / 交易错误回档 / / 函数 errorCB(err) {console.log ("处理 SQL 时出错:"+ err.code） ；} / / 交易成功回档 / / 函数 successCB() {var db = window.openDatabase ("资料库"、"1.0"，"Cordova演示"，200000) ；db.transaction errorCB queryDB） ；} / / 设备的 Api 可 / / 函数 onDeviceReady() {var db = window.openDatabase ("资料库"、"1.0"，"Cordova演示"，200000) ；db.transaction （populateDB、 errorCB、 successCB） ；} < / 脚本 >< / 头 >< 身体 >< h1 > 示例 < / h1 >< p > 资料库 </p >< / 身体 >< / html >