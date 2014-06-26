package org.crazyit.activiti.oa.test11;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 处理错误的JavaDelegate类
 * @author yangenxiong
 *
 */
public class HandleErrorDelegate implements JavaDelegate {

	public void execute(DelegateExecution arg0) throws Exception {
		System.out.println("8080端口关闭，开始处理...");
	}

}
