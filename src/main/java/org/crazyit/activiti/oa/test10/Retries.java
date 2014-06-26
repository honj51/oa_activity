package org.crazyit.activiti.oa.test10;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.runtime.Job;

/**
 * 设置工作执行次数
 * @author yangenxiong
 *
 */
public class Retries {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngineImpl engine = (ProcessEngineImpl)ProcessEngines.getDefaultProcessEngine();
		//启动JobExecutor
		engine.getProcessEngineConfiguration().getJobExecutor().start();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("bpmn10.3/retries.bpmn").deploy();
		// 获取管理服务组件
		ManagementService managementService = engine.getManagementService();
		Thread.sleep(3000);
		//设置执行次数为1 
		Job job = managementService.createJobQuery().singleResult();
		managementService.setJobRetries(job.getId(), 1);
		// 关闭JobExecutor
		Thread.sleep(3000);
		engine.getProcessEngineConfiguration().getJobExecutor().shutdown();
	}

}
