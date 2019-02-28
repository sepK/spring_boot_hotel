package com.ecjtu.kongtao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author t.k
 * @date 2019/2/28 18:48
 */
@Controller
@RequestMapping(value = "/app")
public class FrontDeskController extends BaseController{

    @RequestMapping(value = "/main.html")
    public String toAbout() {
        return "app/main.html";
    }
}
