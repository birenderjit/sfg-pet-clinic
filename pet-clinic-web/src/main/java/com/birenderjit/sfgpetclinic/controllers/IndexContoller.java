package com.birenderjit.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexContoller {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }
}
