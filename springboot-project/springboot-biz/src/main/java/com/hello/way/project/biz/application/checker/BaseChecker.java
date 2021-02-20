package com.hello.way.project.biz.application.checker;

import com.google.common.base.Preconditions;
import com.hello.way.project.biz.api.common.request.user.BaseUserRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: way
 * @Date: 2019-10-08 17:03
 */
public class BaseChecker {

    public static void checkUser(BaseUserRequest userRequest){
        Preconditions.checkArgument(StringUtils.isNoneBlank(userRequest.getUserName()), "userName参数不正确");
        Preconditions.checkArgument(StringUtils.isNoneBlank(userRequest.getUserNo()), "userNo参数不正确");
    }

}
