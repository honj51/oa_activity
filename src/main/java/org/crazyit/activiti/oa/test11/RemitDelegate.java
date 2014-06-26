package org.crazyit.activiti.oa.test11;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 处理汇款的JavaDelegate
 * @author yangenxiong
 *
 */
public class RemitDelegate implements JavaDelegate {

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("处理汇款业务");
	}

}
