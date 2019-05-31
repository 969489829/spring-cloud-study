package cn.jk.feign.controller;

import cn.jk.feign.web.FeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jk
 * @date 2019/4/4 10:01
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@RestController
@RequestMapping("/feign")
public class Consume {

    @Autowired
    private FeignClients client;

    @RequestMapping
    public Object test(){
        return client.getPerson();
    }
}
