package org.crazyit.activiti.oa.test11;

import java.net.Socket;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

public class NoneStartEvent {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn/NoneStartEvent.bpmn").deploy();
		runtimeService.startProcessInstanceByKey("myProcess");
	}

}
