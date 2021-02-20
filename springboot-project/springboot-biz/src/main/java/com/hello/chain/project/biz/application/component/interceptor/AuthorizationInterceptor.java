package com.hello.chain.project.biz.application.component.interceptor;

import com.hellobike.platform.scp.domain.client.ClientInfoResult;
import com.hellobike.platform.scp.domain.client.ClientInfoService;
import com.hellobike.soa.rpc.interceptor.server.ServerCallMethodInterceptor;
import com.hellobike.soa.rpc.interceptor.server.ServerCallMethodInterceptorRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author ：dzc
 * @date ：Created in 2019/11/21 15:58
 * @description：用户登录鉴权拦截器
 */
@Component
public class AuthorizationInterceptor implements ServerCallMethodInterceptor {

    @Autowired
    private ClientInfoService clientInfoService;

    @PostConstruct
    private void init() {
        ServerCallMethodInterceptorRegister.registerIntercepor(this);
    }

    @Override
    public void applyBefore(Map<String, Object> args) {
        //TODO
        //1.获取头信息

        //2.将头结点信息塞到ClientInfoService
        ClientInfoResult clientInfoResult = new ClientInfoResult();
        clientInfoResult.setClientIp("test");
        clientInfoResult.setUserId("userid");
        clientInfoResult.setUserName("username");
        clientInfoService.setClientInfoResult(clientInfoResult);

    }

    @Override
    public void applyAfter(Map<String, Object> args, Object response) {
        System.out.println("xxx");
    }

}