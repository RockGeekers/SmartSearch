SmartSearch
===========

jar 包依赖搜索工具，  输入要寻找的jar包或者class关键字，  查找jar包来源， 并提供jar包下载和maven依赖导入

1. 安装
cd smartSearch-web
mvn clean install

2. 测试
在web容器中启动smartSearch

http://localhost:8080/smartsearch/jar/search/{keyword}  搜索class关键字查找jar包信息， 比如keyword为jsoup

http://localhost:8080/smartsearch/jar/detail/org.jsoup/jsoup  搜索jar包链接地址及maven依赖信息
