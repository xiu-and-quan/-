package 笔记.数据库;

/**
 * @Author shizq18
 * @Date 2023/8/17
 * @Description
 */
public class 学习总结mysql相关 {
    /*
    * 1、rpm安装mysql，可以更改yum的库
    * 2、mysql修改dataDir，需要先给自定义的目录设置权限为mysql，命令为：chown -R mysql:mysql custom_path
    *   最重要在于初始花，rpm装mysql的位置为cd /usr/local/mysql/bin/，
    *   初始化命令为：./mysqld --defaults-file=/etc/my.cnf (--basedir=/usr/local/mysql/ 可选项) --datadir=/data/mysql/(自定义路径) --user=mysql --initialize
    *   如果出现Can‘t connect to local MySQL server through socket ‘/tmp/mysql.sock‘ (2)
    *   需要在my.cnf 添加[client] stock = ([mysqld]里面对应的sock的对应地址)
    *   不同版本的修改账号密码sql不一样，看日志，位置为 /var/log/mysql.log
    * 3、用mysql导入数据.sql文件，use 数据库名字； source *.sql 文件绝对路径
    * 4、修改用户远程登录权限用该命令:RENAME USER 'sammy'@'localhost' TO 'sammy'@'remote_server_ip';
    * */
}
