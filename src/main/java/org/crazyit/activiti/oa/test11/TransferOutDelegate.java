package org.crazyit.activiti.oa.test11;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class TransferOutDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("转出银行扣减款项...");
	}

}
