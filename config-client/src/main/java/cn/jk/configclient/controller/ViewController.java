package cn.jk.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jk
 * @date 2019/3/18 13:18
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@RestController
//@RefreshScope
public class ViewController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${address}")
    private String address;

    @RequestMapping("/view")
    public Object view(){
        return "name:" + name + "，age:" + age + "，address:" + address;
    }
}
