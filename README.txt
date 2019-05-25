1.环境
	jdk8,mysql

2.数据库
	1）连接数据库：数据库的连接参数在src/jdbc.properties里面，可自行修改。
	2）建立数据库：首先建立数据库schedule: 
	create database schedule
然后执行相应的sql文件。
	没有数据的sql文件：sql/schedule.sql，可以添加课程。
	有数据的sql文件：sql/scheduleWithData.sql，不能添加课程。

3.运行
	直接导入到eclipse或idea中，运行src目录下的bootstrap.java即可。需要将编码设置为utf-8，否则会乱码。

