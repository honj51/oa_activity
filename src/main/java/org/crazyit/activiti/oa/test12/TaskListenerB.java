package org.crazyit.activiti.oa.test12;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class TaskListenerB implements TaskListener {

	public void notify(DelegateTask delegateTask) {
		System.out.println("任务监听器B");
	}

}
