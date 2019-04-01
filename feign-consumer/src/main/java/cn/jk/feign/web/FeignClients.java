package cn.jk.feign.web;

import cn.jk.ribbonprovider.po.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jk
 * @date 2019/3/26 9:49
 *
 * <b>类说明：</b>
 * <p>
 *
 * </p>
 */
@FeignClient("provider")
public interface FeignClients {

    @GetMapping
    Person getPerson();
}
