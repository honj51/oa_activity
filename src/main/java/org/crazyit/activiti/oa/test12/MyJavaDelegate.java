package org.crazyit.activiti.oa.test12;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MyJavaDelegate implements JavaDelegate, Serializable {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" 实现  JavaDelegate 的  JavaSeviceTask: " + this);
	}
}
