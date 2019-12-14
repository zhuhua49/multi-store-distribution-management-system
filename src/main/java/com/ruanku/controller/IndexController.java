package com.ruanku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping()
public class IndexController {

    @RequestMapping("/member")
    public String changeMember(){
        return "member/login";
    }

    @RequestMapping("/admin")
    public String changeAdmin(){
        return "admin/login";
    }
}
