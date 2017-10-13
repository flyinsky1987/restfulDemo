1、从数据库查询记录生成json数组
http://localhost/restfulDemo/api/api/list
2、不查询数据库直接返回信息
http://localhost/restfulDemo/api/api/index


配置

1、数据库配置
res/jdbc.txt

2、程序主控制器
src/com/tm/common/config/DruidConfig.java


其他说明
com/tm/api 	存放业务代码
com/tm/pojo	数据库操作