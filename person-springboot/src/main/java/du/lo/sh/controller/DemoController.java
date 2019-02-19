package du.lo.sh.controller;

import du.lo.sh.importcls.ImportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/19 10:10
 * @Version 1.0
 */
@RequestMapping("/")
@RestController
public class DemoController {

    @Autowired
    private ImportClass importClass;

    @GetMapping("/index")
    public String addDemo(){
        System.out.println(importClass);
        System.out.println("0000000000000");
        return "hello";
    }
}
