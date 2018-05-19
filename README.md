# qiao-parent
乔氏家谱项目，包括内容管理模块、家谱管理模块
## 菜单定义
app 乔氏家谱
  内容管理
     栏目管理
     菜单管理
     内容管理
  系统管理
     数据字典
     广告管理
     友情链接
     公司信息

## maven 的配置
> 统一使用私服nexus进行maven包的管理

* 修改C:\Windows\System32\drivers\etc\hosts,增加如下一行：
``` 
192.168.31.128 nexus.apps.xing.com
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
                    <url>http://nexus.apps.xing.com/nexus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                </repository>
                <repository>
                    <id>snapshot-nexus</id>
                    <url>http://nexus.apps.xing.com/nexus/content/repositories/snapshots/</url>
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