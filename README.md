VirtualAPK

运行步骤：

1.安装 Host.apk

2.将 Demo.apk ，DemoB.apk 放在 getExternalStorageDirectory()+"/Download/" 下

3.运行 Host.apk 即可

注意事项：Demo，DemoB 需要用gradle 命令   ./gradlew assemblePlugin 构建
构建后包放在 app\build\outputs\plugin\release 目录下

VirtualAPK 迭代历史：http://jcenter.bintray.com/com/didi/virtualapk/gradle/

构建失败等一般问题可以看此博客 https://blog.csdn.net/a31081314/article/details/82661009
或联系 QQ 781217278

