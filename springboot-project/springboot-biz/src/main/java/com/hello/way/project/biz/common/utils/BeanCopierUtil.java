package com.hello.way.project.biz.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hello.way.project.biz.common.constant.ErrorCodeEnum;
import com.hello.way.project.biz.common.exception.BizException;
import com.hello.way.project.biz.common.log.Loggers;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.List;
import java.util.Map;

/**
 * 该工具类基于cglib直接生成字节码，性能极高与直接调用setter getter性能相差无几 
 * bean 该工具类与@Accessors注解生成的链式写法的setter不兼容（返回当前对象） 不支持 原始类型和封装类型 copy int <->
 * Integer,在使用自定义的数据转换器是不受此影响 类型转换不够智能，设置 useConverter 为 true 和重写
 * Converter，类型相同也会走转换的逻辑。
 * BeanCopier  beanCopier 每次淡出创建create beanCopier 此时新能与spring beanutils性能相差无几，与apache 的beanutils性能相差十几倍，在指定beanCopier的时候保守估计性能大约是apache的1000倍以上,尝试map存储但是与create方式性能差不多
 * 
 * 在10相同类属性情况下测试1，create 模式不带转换器的时候1000万次耗时11ms  
 * @author way
 * @date Feb 18, 2020
 * @time 2:48:25 PM
 */
public class BeanCopierUtil {

	public static final Converter AUTO_CONVERTER = new Converter() {
		@SuppressWarnings("unchecked")
		@Override
		public Object convert(Object value, Class target, Object context) {
			try {
				if (value == null) {
					return null;
				}
				if (target.isInstance(value)) {
					return value;
				}
				if (value instanceof Number) {
					Number number = (Number) value;
					if (target == Integer.class || target == int.class) {
						return number.intValue();
					}
					if (target == Short.class || target == short.class) {
						return number.shortValue();
					}
					if (target == Long.class || target == long.class) {
						return number.longValue();
					}
				}
				if (value instanceof String) {
					if (target.isAssignableFrom(List.class)) {
						return JSONArray.parseArray((String) value);
					}
					if (target.isAssignableFrom(Map.class)) {
						return JSONObject.parse((String) value);
					}
				}
				if (target == String.class) {
					return JSONObject.toJSONString(value);
				}
				return null;
			} catch (Exception e) {
				Loggers.ERROR.error("使用属性拷贝自动转换器异常value:{},valueType:{},targetType:{}", value,
						value.getClass().getName(), target.getName(), e);
				throw new BizException(ErrorCodeEnum.SYSTEM_ERROR.getCode(), "类型自动转换异常或为json数据格式不正确导致，请咨询检查参数");
			}
		}
	};

	/**
	 * BeanCopier的copy
	 * 
	 * @param source 源文件的
	 * @param target 目标文件
	 */
	public static void copy(Object source, Object target) {
		BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
		beanCopier.copy(source, target, null);
	}

	/**
	 * 使用自动转换器拷贝属性
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyByAutoConverter(Object source, Object target) {
		copy(source, target, AUTO_CONVERTER);
	}

	/**
	 * 使用自动类型转换器并生成实例
	 * 
	 * @param <T>
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T copyByAutoNewInstance(Object source, Class<T> clazz) {
		T t;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new BizException(ErrorCodeEnum.SYSTEM_ERROR.getCode(), "实例化对象失败");
		}
		copy(source, t, AUTO_CONVERTER);
		return t;
	}

	/**
	 * 不使用转换器并生成实例
	 * 
	 * @param <T>
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T copyNewInstance(Object source, Class<T> clazz) {
		T t;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new BizException(ErrorCodeEnum.SYSTEM_ERROR.getCode(), "实例化对象失败");
		}
		copy(source, t);
		return t;
	}

	/**
	 * BeanCopier的copy
	 * 
	 * @param source 源文件的
	 * @param target 目标文件
	 */
	public static void copy(Object source, Object target, Converter converter) {
		BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), true);
		beanCopier.copy(source, target, converter);
	}
	
	
	/**
	 * BeanCopier的copy
	 * 
	 * @param source 源文件的
	 * @param target 目标文件
	 */
	public static void copy(Object source, Object target, BeanCopier beanCopier) {
		beanCopier.copy(source, target, null);
	}

	/**
	 * 使用自动转换器拷贝属性
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyByAutoConverter(Object source, Object target, BeanCopier beanCopier) {
		copy(source, target, AUTO_CONVERTER,beanCopier);
	}

	/**
	 * 使用自动类型转换器并生成实例
	 * 
	 * @param <T>
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T copyByAutoNewInstance(Object source, Class<T> clazz, BeanCopier beanCopier) {
		T t;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new BizException(ErrorCodeEnum.SYSTEM_ERROR.getCode(), "实例化对象失败");
		}
		copy(source, t, AUTO_CONVERTER,beanCopier);
		return t;
	}

	/**
	 * 不使用转换器并生成实例
	 * 
	 * @param <T>
	 * @param source
	 * @param clazz
	 * @return
	 */
	public static <T> T copyNewInstance(Object source, Class<T> clazz, BeanCopier beanCopier) {
		T t;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			throw new BizException(ErrorCodeEnum.SYSTEM_ERROR.getCode(), "实例化对象失败");
		}
		copy(source, t,beanCopier);
		return t;
	}

	/**
	 * BeanCopier的copy
	 * 
	 * @param source 源文件的
	 * @param target 目标文件
	 */
	public static void copy(Object source, Object target, Converter converter, BeanCopier beanCopier) {
		beanCopier.copy(source, target, converter);
	}
}
