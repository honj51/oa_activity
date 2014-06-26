package org.crazyit.activiti.oa.test13;

import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class EmbededJavaDelegate implements JavaDelegate {

	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("执行子流程Service Task的Java Delegate, 抛出错误");
		throw new BpmnError("myError");
	}

}
