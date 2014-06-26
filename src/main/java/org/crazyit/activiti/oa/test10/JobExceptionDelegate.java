package org.crazyit.activiti.oa.test10;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JobExceptionDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("this is job exception delegate");
		//throw new RuntimeException("JobExceptionDelegate message");
	}
}
