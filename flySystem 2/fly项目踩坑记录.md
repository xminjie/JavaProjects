1.数据库连接不要给连接root用户，应该新创建的数据库用户，只赋予某一个库的权限（防止别人获得用户，对其他库干坏事，如果用新用户的话，及时被破解，也只能操作当前一个库，起到安全保护的作用）

2.事务开启时候的的connection获得新连接要加入线程池中

3.object.txt中的名字不要写错，class.forname("").newInstance

4.JLable与JTexField不要混淆

5.threadlocal中的

​	get()获得当前连接线程

​	remove()移除当前线程

​	set(Object o)把当前的对象加入线程池中

6.关闭connection连接时候要把con从线程池中移除去，否则下次获得的con是已关闭的，会异常

变量命名要规范，见名知意, 有固定风格

