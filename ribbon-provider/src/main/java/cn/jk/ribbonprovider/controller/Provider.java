package cn.jk.ribbonprovider.controller;

import cn.jk.ribbonprovider.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jk
 * @date 2019/3/20 11:04
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@RestController
@RequestMapping("/provider")
@RefreshScope
public class Provider {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${gender}")
    private String gender;

    @Value("${address}")
    private String address;

    @RequestMapping
    public Person getPerson() {
        return new Person(name, age, gender, address);
    }
}
