# searchNewsFromBD
java 实现的Windows下小程序，可使用maven编译生成可执行的jar包。融合spring boot，运行后可直接在浏览器中查看搜索后的结果。
包含源码及编译后的可执行文件

具体功能：
读取指定目录下记录关键词的文本文档，调用百度搜索API进行查询；
对搜索出来的结果简单分析处理；

使用方法：
将包含关键词的文本文档放在D盘根目录，执行可执行程序run.bat（前提java环境已配置），浏览器访问 http://localhost:8080/search 即可
