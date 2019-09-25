package com.hello.chain.project.web.controller.home;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class IndexController  {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH,method = RequestMethod.GET)
    public String error() {
        return " ";
    }

}