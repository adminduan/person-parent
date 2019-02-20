package du.lo.sh.controller;

import du.lo.sh.configurations.CommonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoTestController
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/19 13:39
 * @Version 1.0
 */
@RequestMapping("/demotest")
@RestController
public class DemoTestController {


    @GetMapping("/hello")
    public String hello(){
        System.out.println("test123444");
        return "zhangsan";
    }
}
