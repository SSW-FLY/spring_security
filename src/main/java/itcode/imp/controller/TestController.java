package itcode.imp.controller;

import itcode.imp.entity.OfflineFileMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2021/5/24
 */
@RestController
public class TestController {

    @GetMapping("api/test")
    @PreAuthorize("hasAuthority('admin')")
    public String test() {
        return "ok";
    }

    @GetMapping("api/test/hello")
    @PreAuthorize("hasAnyAuthority('user')")
    public String hello() {
        return "hello";
    }


    @PostMapping("/v1/hypers-proxy/customer/off-line/files")
    public void test1(@RequestBody OfflineFileMessage message) {
        System.out.println(message.toString());
    }

}
