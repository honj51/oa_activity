package org.crazyit.activiti.oa.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 向执行注发送信号
 * 
 * @author yangenxiong
 * 
 */
public class Signal {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到流程存储服务实例
		RepositoryService repositoryService = engine.getRepositoryService();
		// 得到运行时服务组件
		RuntimeService runtimeService = engine.getRuntimeService();
		// 部署流程描述文件
		repositoryService.createDeployment()
				.addClasspathResource("bpmn9.4/signal.bpmn20.xml").deploy();
		// 开始流程
		ProcessInstance pi = runtimeService
				.startProcessInstanceByKey("vacationRequest");
		// 查找执行流（当前只有一个执行流）
		Execution exe = runtimeService.createExecutionQuery().activityId("writeVacation").singleResult();
		if (exe != null) {
			System.out.println("当前流程节点为：writeVacation");
		}

		// 发送信息，让执行流向前进行
		runtimeService.signal(exe.getId());
		// 向下执行后，会出现流程分支, 根据流程节点ID查询两个执行流
		Execution managerAuditExe = runtimeService.createExecutionQuery()
				.activityId("managerAudit").singleResult();
		Execution hrAuditExe = runtimeService.createExecutionQuery()
				.activityId("hrAudit").singleResult();
		if (managerAuditExe != null && hrAuditExe != null) {
			System.out.println("当前流程节点为：managerAudit 和  hrAudit");
		}
		// 初始化参数
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("days", 5);
		//向前进行两个节点
		runtimeService.signal(managerAuditExe.getId());
		runtimeService.signal(hrAuditExe.getId(), vars);
		// 此时到了Boss Audit节点，查询节点对应的执行流
		Execution bossExe = runtimeService.createExecutionQuery()
				.activityId("bossAudit").singleResult();
		if (bossExe != null) {
			System.out.println("当前流程节点为：bossAudit");
		}
		// 输出参数
		System.out.println("当前参数：" + runtimeService.getVariable(bossExe.getId(), "days"));
		// 完成流程
		runtimeService.signal(bossExe.getId());
		// 查询执行流
		List<Execution> exes = runtimeService.createExecutionQuery()
				.processInstanceId(pi.getId()).list();
		System.out.println("流程完成，执行流数量：" + exes.size());

	}
}
