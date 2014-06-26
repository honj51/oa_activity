package org.crazyit.activiti.oa.test10;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class RetriesDelegate implements JavaDelegate {
	int i = 0;	
	public void execute(DelegateExecution execution) throws Exception {
		i++;
		if (i <= 3) {
			throw new RuntimeException("执行次数小于等于3次，抛出异常");
		} else {
			System.out.println("执行次数大于3次，成功执行");
		}
	}	
}
