package org.crazyit.activiti.oa.service;

import java.util.List;

import org.activiti.engine.identity.Group;

public interface GroupService {
    /**
     * 查询全部的用户组
     * 
     * @return
     */
    List<Group> list();
}
