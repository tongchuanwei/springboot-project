package com.demo.way.project.web.controller.home;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * <p>
 *  描述业务主要功能
 *  必要关键点的介绍
 * <p>
 *
 * @author： way
 * @version： 1.0
 * @Date:  2019-08-07
 */
@RestController
@RequestMapping("/index")
public class IndexController  {

    @GetMapping("/error")
    public String error() {
        return "error";
    }
}