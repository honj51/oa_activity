package org.crazyit.activiti.oa.test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 使用signaleEventReceived方法
 * @author yangenxiong
 *
 */
public class SignaleEventReceived {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		TaskService taskService = engine.getTaskService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn9.4/signalEventReceived.bpmn20.xml").deploy();
		// 开始流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("testProcess");
		
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("流程在第一个任务，执行流数量为：" + exes.size());		
		// 查找执行流
		Execution exe = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).singleResult();
		// 往下执行，将遇到Catch事件节点
		//runtimeService.signal(exe.getId());只能消息事件才能使用signal
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		taskService.complete(task.getId());
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("流程到了Catch事件节点，等待触发，执行流数量：" + exes.size());	
		//抛出一个信号
		runtimeService.signalEventReceived("testSignal");
		exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("触发Catch事件后，执行流数量：" + exes.size());
	}

}
