package org.crazyit.activiti.oa.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 使用signaleEventReceived方法
 * @author yangenxiong
 *
 */
public class SignaleEventReceivedMethods {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn9.4/signalEventReceivedMethod.bpmn20.xml").deploy();
		// 开始三个流程实例 
		runtimeService.startProcessInstanceByKey("testProcess");
		runtimeService.startProcessInstanceByKey("testProcess");
		runtimeService.startProcessInstanceByKey("testProcess");
		// 查询流程实例
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processDefinitionKey("testProcess").list();
		System.out.println("流程开始，执行流数量：" + exes.size());
		//向全部执行流发送信号
		runtimeService.signalEventReceived("testSignal");
		// 重新查询执行流数量
		exes = runtimeService.createExecutionQuery().processDefinitionKey("testProcess").list();
		System.out.println("全部流程结束，执行流数量：" + exes.size());
	}

}
