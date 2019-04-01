package cn.jk.ribbonconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * @author jk
 * @date 2019/3/20 11:25
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@Configuration
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        Date date = new Date();
        date.setHours(date.getHours() - 1);
        System.out.println((new Date().getTime() - date.getTime())/3600000);
    }
}
