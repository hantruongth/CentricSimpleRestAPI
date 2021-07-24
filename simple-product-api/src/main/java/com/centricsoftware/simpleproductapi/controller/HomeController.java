package com.centricsoftware.simpleproductapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hantruong
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "index.html";
    }
}
