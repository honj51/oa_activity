package org.crazyit.activiti.oa.action;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.crazyit.activiti.oa.service.GroupService;
import org.crazyit.activiti.oa.service.impl.GroupServiceImpl;

public class GroupAction extends BaseAction {

    private GroupService groupService;
    
    private List<Group> groups;

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
    
    public String list(){
        this.groups = groupService.list();
        return SUCCESS;
    }
}
