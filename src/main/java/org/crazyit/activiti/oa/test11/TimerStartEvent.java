package org.crazyit.activiti.oa.test11;

import java.util.List;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * 定时器开始事件
 * @author yangenxiong
 *
 */
public class TimerStartEvent {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngineImpl engine = (ProcessEngineImpl)ProcessEngines.getDefaultProcessEngine();
		// 启动JobExecutor
		engine.getProcessEngineConfiguration().getJobExecutor().start();
		// 得到流程存储服务组件
		RepositoryService repositoryService = engine.getRepositoryService();
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程文件
		repositoryService.createDeployment()
			.addClasspathResource("bpmn11.3/TimerStartEvent.bpmn").deploy();
		// 一分钟后关闭JobExecutor
		Thread.sleep(1000 * 60);
		engine.getProcessEngineConfiguration().getJobExecutor().shutdown();
		// 查询流程实例
		List<ProcessInstance> ints = runtimeService.createProcessInstanceQuery().list();
		System.out.println(ints.size());
	}

}
