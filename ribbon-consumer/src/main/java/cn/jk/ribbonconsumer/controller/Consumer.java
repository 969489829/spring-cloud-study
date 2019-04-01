package cn.jk.ribbonconsumer.controller;

import cn.jk.ribbonconsumer.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jk
 * @date 2019/3/20 11:15
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@RestController
@RequestMapping("/consumer")
public class Consumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public Person getPerson(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResponseEntity<Person> entity = restTemplate.getForEntity("http://ribbon-provider/provider", Person.class);
        return entity.getBody();
    }
}
