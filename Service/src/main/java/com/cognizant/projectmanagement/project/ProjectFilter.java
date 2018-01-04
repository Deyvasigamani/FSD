package com.cognizant.projectmanagement.project;

import java.util.Date;

public class ProjectFilter {
	
private Long projectId;
	
	private String projectName;
	
	private Date startDate;
	
	private Date endDate;
	
	private Long priority;
	
	private Integer taskNumber;
	
	private Integer completedTaskNumber;
	
	private String manager;
	
	private Long userId;
	

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getTaskNumber() {
		return taskNumber;
	}

	public void setTaskNumber(Integer i) {
		this.taskNumber = i;
	}

	public Integer getCompletedTaskNumber() {
		return completedTaskNumber;
	}

	public void setCompletedTaskNumber(Integer completedTaskNumber) {
		this.completedTaskNumber = completedTaskNumber;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long long1) {
		this.projectId = long1;
	}


	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

}
