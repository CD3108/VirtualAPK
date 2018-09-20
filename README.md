# VirtualAPK
<<<<<<< HEAD

第一步：安装 host

第二步：将Demo 系列放入 getExternalStorageDirectory()+"/Download/" 下  （此路径为代码中配置的加载路径）

第三步，启动 host 即可
=======
Host 为宿主 APK
Demo 为插件1
DemoB 为插件2

运行步骤：

1.安装 Host.apk

2.将 Demo.apk ，DemoB.apk 放在 getExternalStorageDirectory()+"/Download/" 下

3.运行 Host.apk 即可

注意事项：Demo，DemoB 需要用gradle 命令   ./gradlew assemblePlugin 构建
构建后包放在 app\build\outputs\plugin\release 目录下

构建失败等一般问题可以看此博客 https://blog.csdn.net/a31081314/article/details/82661009
或联系 QQ 781217278
>>>>>>> 2a8791d5595004af300668911b6b07d9b4f270e7
