# qiao-parent
乔氏家谱项目，包括内容管理模块、家谱管理模块
## 项目总体目录结构
### qiao-parent
> 地址 ：https://github.com/xingshidongman/qiao-parent

> 说明： 后台java服务库

### qiao-vue-front
> 地址 ：https://github.com/xingshidongman/qiao-vue-front

> 说明： 前台 vue 界面库

### kalix-vue-frame
> 地址 ：https://github.com/xingshidongman/kalix-vue-frame

> 说明： 前台 vue admin 核心库

<font color="red">需要使用qiao分支</font>

### kalix-vue-qiao
> 地址 ：https://github.com/xingshidongman/kalix-vue-qiao

> 说明： 前台 vue admin qiao 子模块库
## 菜单定义
乔氏家谱
  前台管理    cms
     栏目管理 column
     菜单管理 menu
     内容管理 content
  系统管理    system
     数据字典 dict
     广告管理 advert
     友情链接 blogroll
     公司信息 information

## maven 的配置
> 统一使用私服nexus进行maven包的管理

* 修改C:\Windows\System32\drivers\etc\hosts,增加如下一行：
``` 
# 192.168.31.128 nexus.apps.xing.com
 125.222.244.17 nexus.apps.bogon.com
```
* 创建下面文件形成settings.xml文件，复制到m2/repository目录
``` 
<?xml version="1.0" encoding="UTF-8"?>
<!--copy this file to m2_home/conf -->
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <pluginGroups>
    </pluginGroups>
    <servers>
        <server>
            <id>nexus-releases</id>
            <username>admin</username>
            <password>admin123</password>
        </server>
        <server>
            <id>nexus-snapshots</id>
            <username>admin</username>
            <password>admin123</password>
        </server>
    </servers>

    <mirrors>
        <!--<mirror>-->
        <!--<id>nexus2-remote</id>-->
        <!--<mirrorOf>*</mirrorOf>-->
        <!--<name>Nexus Mirror Remote</name>-->
        <!--<url>http://nexus.apps.xing.com/nexus/content/groups/public/</url>-->
        <!--</mirror>-->
    </mirrors>
    <profiles>
        <profile>
            <id>nexus-releases</id>
            <repositories>
                <repository>
                    <id>remote-nexus</id>
                    <url>http://nexus.apps.bogon.com/nexus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                </repository>
                <repository>
                    <id>snapshot-nexus</id>
                    <url>http://nexus.apps.bogon.com/nexus/content/repositories/snapshots/</url>
                    <releases>
                        <enabled>false</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                        <updatePolicy>always</updatePolicy>
                    </snapshots>
                </repository>

            </repositories>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>nexus-releases</activeProfile>
    </activeProfiles>
</settings>

```