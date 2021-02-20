package com.hello.chain.project.biz.common.utils;


import com.hello.chain.project.biz.common.exception.BizException;

import java.util.function.Function;

/**
 * @author way
 */
public class ConvertUtils {


    /**
     * convert template
     * @param source
     * @param convert
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> R convertTo(T source, Function<T, R> convert) {

        if (convert != null) {
            return convert.apply(source);
        }

        throw new BizException(null,"数据转换异常");

    }
}
