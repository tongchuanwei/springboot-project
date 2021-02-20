package com.hello.way.project.biz.application.component.mq.strategy;

import com.hello.way.project.biz.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 策略实现
 *
 * @author way
 * @since 2019-11-28
 */
@Slf4j
@Component
public class ProductListener implements CallBackListener {


	/**
	 *
	 * @param
	 * @param flowInstanceId
	 * @param processStatus
	 * @return
	 */
	@Override
	public boolean onMessage(String requirementId, String flowInstanceId, Integer processStatus) {


		return false;
	}

	/**
	 * @param processorKey
	 * @return
	 */
	@Override
	public boolean filter(String processorKey) {
		return Constants.PRODUCT_PROCESSOR_KEY.equalsIgnoreCase(processorKey);
	}
}
