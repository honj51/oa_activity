package org.crazyit.activiti.oa.test11;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class GenOrderDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("系统完成生成订单");
	}

}
