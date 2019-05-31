package cn.jk.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class Consumer {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public String getPerson(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://provider/provider", String.class);
        return forEntity.getBody();
    }
}
