package itcode.imp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2020/12/9
 */
@RestController
public class TestController {

    @GetMapping("/api/projects/hma")
    public String test() {
        return "hma";
    }
}
