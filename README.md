# wechat-robot-Java 修改版

## Task List

### 可视化调整机器人

1. 调整自动回复缓存时间
2. 根据微信号指定回复
3. 显示回复信息到面板
4. 设置自定义回复内容
5. 加密储存记录文件
6. 结构化存储微信what's up

#### 具体需求

1. 菜单栏的文件，结构化存储（主要内容是好友what's up）类型是XML，经过加密（默认使用AES加密），可以修改为否
2. 菜单栏的设置可以对缓存时间（默认20分钟）、
3. 菜单栏的设置可以对是否接入机器人回复（默认否）
4. 菜单栏的设置可以修改输出信息模式（默认为简略）
5. 信息栏目显示使用指引，以及初始化二维码
6. 自动回复模式分为三种：默认回复，自定义回复，机器人回复（与设置中的机器人接入绑定）

**所有的默认配置要确保打开即可使用**

> **我开始研究个人版微信机器人不是为了让微信变得公众号可以回复天气预报乱七八糟的功能，而是为了可以在繁忙的状态下让对方知道我现在的状态，类似于QQ离开回复那样，更加的高度自定义，另外还可以应付一下老板的考勤~~**

## 修改内容

> 增加微信好友信息记录，形式：文件存储，在record文件里面。当然你也可以做一些爬虫之类的分析，但.....
<br>
删除茉莉机器人的自动回复，改为自定义回复。在me.biezhi.wechat.service.WechatServiceImpl  第395行修改，之后会修改成配置文件的形式<br>
默认20分钟不会对同一好友产生第二次自动回复<br>
不回复图片、语音信息<br>
控制台输出自己使用微信回复的内容


wechat-robot是基于微信网页版协议开发的普通微信号机器人程序，使用Java语言。

[微信协议分析](doc/protocol.md)

## 使用
* 在Eclipse中导入Git的maven项目，[不会点这里 ](http://www.cnblogs.com/lpshou/p/3199243.html)

* 直接运行 `me.biezhi.wechat.Application` 中的main函数

* [更多使用方法见：](https://github.com/biezhi/wechat-robot/blob/master/README.md)

## Issues Report

非常欢迎发issues

## Similar Projects
@fritx [wxbot](https://github.com/fritx/wxbot)  
@wechaty [wechaty](https://github.com/wechaty/wechaty)  

## 后记
目前我fork了不少个人微信机器人项目，例如有用python、Go、Node、Php写的，发现还是java最稳定，最容易使用，其他很容易出错或者搭建都是问题，毕竟国内的互联网环境并不尽人意。

> 如有侵权请联系 romennts@gmail.com 删除
