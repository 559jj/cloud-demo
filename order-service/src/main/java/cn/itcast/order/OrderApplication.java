package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //创建RestTemplate并注入ioc  通过restTemplate的getForObject(url, User.class)方法 向目标url发起http请求
    @Bean
    @LoadBalanced//开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //设置负载均衡的规则   方式一在配置类中设置  方式二在配置类中设置
//    @Bean//方式一的作用范围是所用的服务提供者都是随机  方式二是指定某个微服务的负载均衡规则
//    public IRule randomRule(){
//        return new RandomRule();
//    }
}