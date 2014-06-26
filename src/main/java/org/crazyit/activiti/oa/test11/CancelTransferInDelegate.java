package org.crazyit.activiti.oa.test11;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class CancelTransferInDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("转入银行取消接收款项...");
	}

}
