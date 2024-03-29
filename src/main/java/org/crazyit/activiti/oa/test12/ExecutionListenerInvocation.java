package org.crazyit.activiti.oa.test12;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.el.Expression;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class ExecutionListenerInvocation implements ExecutionListener {

	private Expression message;

	public void setMessage(Expression message) {
		this.message = message;
	}

	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("流程监听器：" + message.getValue(execution));
	}

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 得到任务服务组件
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService
				.createDeployment()
				.addClasspathResource(
						"bpmn12.7/ExecutionListenerInvocation.bpmn")
				.deploy();
		// 启动流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("process1");
		// 查找并完成任务
		Task task = taskService.createTaskQuery().singleResult();
		taskService.complete(task.getId());
	}

}
