# regc-parent
面试登记管理

一. 克隆乔氏项目（www.github.com/xingshidongman）

  运行项目让其项目跑起来 

1. 在IDEA中打开qiao-parent 自己运行
2. 在Webstorm中打开kalix-vue-lib-qiao ---> 在Terminal输入yarn--->  加载完毕输入 yarn link 
3. 在Webstorm中打开qiao-frame ---> 在Terminal输入yarn--->  加载完毕输入 yarn link  kalix-vue-lib-qiao 加载完毕后输入--->yarn dev 让其运行；  看到 I  Your application is running here: http://localhost:8787 运行成功  登录网址进行查看


二.在IDEA中打开qiao-parent 

1. 找到core-parent -->config.qiao.app.cfg -->注册面试登记模块
2.  复制cms-parent模块到qiao-parent下并修改名字（例：reg-parent）
3.  在qiao-parent -->pom.xml --> <modules>下添加你修改的名字
4.  修改reg-parent下文件名 将cms替换成reg 
5.  修改reg-parent -->pom.xml 文件 将cms替换成reg 
6.  修改reg-parent文件下src下main下java下所有包名
7.  修改包下文件名
8.  修改每个文件的pom.xml文件

三.在Webstorm中打开kalix-vue-lib-qiao

1. 在Terminal输入yarn
2. 加载完毕输入 yarn link 

三.在Webstorm中打开qiao-frame

1. 找到src-->views-->main 添加你要做面试登记组件（例：reg）
2. 找src-->advert复制 并粘贴到src文件下重命名（例：reg）
3. 找任何一个config.toml复制到reg下并修改
4. 修改reg-->model.js 变成与数据库对应
5. 修改reg-->index.js 将Advert改成Reg
6. 将reg下的vue文件中内容改成面试登记所需要的

 