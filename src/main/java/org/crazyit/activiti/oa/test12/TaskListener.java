package org.crazyit.activiti.oa.test12;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 使用Spring的bean设置权限
 * @author yangenxiong
 *
 */
public class TaskListener {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		TaskService taskService = engine.getTaskService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn12.2/TaskListener.bpmn").deploy();
		// 启动流程
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("process1");
		// 进行任务查询
		List<Task> tasks = taskService.createTaskQuery().taskAssignee("user1").list();
		System.out.println(tasks.size());
	}
}
