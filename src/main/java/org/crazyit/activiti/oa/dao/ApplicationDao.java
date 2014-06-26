package org.crazyit.activiti.oa.dao;

import java.util.List;

import org.crazyit.activiti.oa.entity.ExpenseAccount;
import org.crazyit.activiti.oa.entity.SalaryAdjust;
import org.crazyit.activiti.oa.entity.Vacation;

public interface ApplicationDao {

    /**
     * 保存一次请假记录到OA_VACATION
     * 
     * @param vac
     */
    void saveVacation(Vacation vac);

    /**
     * 根据用户查询请假记录
     * @param userId
     * @return
     */
    List<Vacation> listVacation(String userId);

    /**
     * 保存一次薪资调整记录到OA_SALARY_ADJUST表中
     * @param salaryAdjust
     */
    void saveSalaryAdjust(SalaryAdjust salaryAdjust);

    /**
     * 保存一次报销申请到OA_EXPENSE_ACCOUNT
     * @param expenseAccount
     */
    void saveExpenseAccount(ExpenseAccount expenseAccount);

    /**
     * 根据用户查询薪资调整申请记录
     * @param userId
     * @return
     */
    List<SalaryAdjust> listSalaryAdjust(String userId);

    /**
     * 根据用户查询报销记录
     * @param userId
     * @return
     */
    List<ExpenseAccount> listExpenseAccount(String userId);

}
