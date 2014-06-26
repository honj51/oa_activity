package org.crazyit.activiti.oa.test10;

import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.runtime.Job;

/**
 * 工作执行异常
 * 
 * @author yangenxiong
 * 
 */
public class JobException {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngineImpl engine = (ProcessEngineImpl) ProcessEngines
				.getDefaultProcessEngine();
		engine.getProcessEngineConfiguration().getJobExecutor().start();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		repositoryService.createDeployment()
				.addClasspathResource("bpmn10.3/jobException.bpmn").deploy();
		// 关闭 JobExecutor
		Thread.sleep(2000);
		engine.getProcessEngineConfiguration().getJobExecutor().shutdown();		
		//查询工作
        ManagementService managementService = engine.getManagementService();
        Job job = managementService.createJobQuery().singleResult();
        System.out.println("分隔线=========================");
        //查询异常信息
        String msg = managementService.getJobExceptionStacktrace(job.getId());
        System.out.println(msg);
	}

}
