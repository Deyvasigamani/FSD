package com.cognizant.projectmanagement.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ParentTask {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long parentId;

	private String parentTask;
	
	public ParentTask()
	{
		
	}
	
	public ParentTask(Long parentId, String parentTask) {
		super();
		this.parentId = parentId;
		this.parentTask = parentTask;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	
	

}
