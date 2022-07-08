eureka是一个注册中心，但他自己同时也是一个微服务
所以eureka自己也需要被注册

搭建EurekaServer步骤
1.引入eureka-server依赖
2.添加@EnableEurkaServer注解
3.在配置文件中配置eureka地址

服务注册
1.引入eureka-server依赖
2.在配置文件中配置eureka地址

服务拉取  是基于服务名称获取服务列表，然后对服务列表做负载均衡
1.给RestTemplate添加@LoadBalance注解
2.用服务提供者的服务名称远程调用

负载均衡
1、规则
规则接口是IRule，默认实现是ZoneAvoidanceRule，根据zone选择服务列表，然后轮询
2、定义方式
代码方式和配置方式

饥饿加载  组件默认是懒加载，定义饥饿加载后在项目启动的时刻该组件的加载就会完成

Nacos注册中心
Nacos是阿里巴巴的产品，现在是SpringCloud中的一个组件。相比Eureka功能更加丰富，在国内受欢迎程度较高。

Nacos服务搭建
①下载安装包②解压③在bin目录下运行指令：startup.cmd -m standalone

Nacos服务注册或发现
①引入nacos.discovery依赖②配置nacos地址spring.cloud.nacos.server-addr

Nacos服务分级存储模型
①一级是服务，例如userservice②二级是集群，例如杭州或上海③三级是实例，例如杭州机房的某台部署了userservice的服务器
如何设置实例的集群属性
①修改application.yml文件，添加spring.cloud.nacos.discovery.cluster-name属性即可

1.Nacos与eureka的共同点
①都支持服务注册和服务拉取
②都支持服务提供者心跳方式做健康检测
2.Nacos与Eureka的区别
①Nacos支持服务端主动检测提供者状态：临时实例采用心跳模式，非临时实例采用主动检测模式
②临时实例心跳不正常会被剔除，非临时实例则不会被剔除
③Nacos支持服务列表变更的消息推送模式，服务列表更新更及时
④Nacos集群默认采用AP方式，当集群中存在非临时实例时，采用CP模式：Eureka采用AP方式