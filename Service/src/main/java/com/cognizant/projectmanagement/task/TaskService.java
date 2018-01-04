package com.cognizant.projectmanagement.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.projectmanagement.project.Project;
import com.cognizant.projectmanagement.project.ProjectService;
import com.cognizant.projectmanagement.user.User;
import com.cognizant.projectmanagement.user.UserService;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ParentTaskService parentTaskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	
	public List<Task >findAllByProjectId(Long id)
	{
		return taskRepository.findAllByProjectId(id);
		
	}
	
	public List<Task> findAllByProjectIdAndStatus(Long id, String status)
	{
		return taskRepository.findAllByProjectIdAndStatus(id, status);
		
	}

	public List<TaskFilter> getAllTasks() {
		List<Task> task = new ArrayList();
		List<TaskFilter> taskFilter = new ArrayList<>();
		taskRepository.findAll().forEach(task::add);
		for(Task t: task){
			TaskFilter taskobj = new TaskFilter();
			taskobj.setTaskId(t.getTaskId());
			taskobj.setParentTaskId(t.getParentId());
			taskobj.setProjectId(t.getProjectId());
			taskobj.setTaskName(t.getTaskName());
			taskobj.setStartDate(t.getStartDate());
			taskobj.setEndDate(t.getEndDate());
			taskobj.setPriority(t.getPriority());
			taskobj.setStatus(t.getStatus());
			taskobj.setUserId(t.getUserId());
			if(t.getParentId() != null){
				ParentTask parentTask = parentTaskService.getParentTask(t.getParentId());
				if(parentTask != null){
					taskobj.setParentTaskName(parentTask.getParentTask());
				}
			}
			if(t.getProjectId() != null){
				Project project = projectService.getProject(t.getProjectId());
				if(project != null){
					taskobj.setProjectName(project.getProjectName());
				}	
			}
			if(t.getUserId() != null){
				User user = userService.getUser(t.getUserId());
				if(user != null){
					taskobj.setUserName(user.getFirstName());
				}
			}
			
			taskFilter.add(taskobj);
			
		}
		return taskFilter;
		
	}

	public List<TaskFilter> getTask(Long projectId) {
		List<TaskFilter> taskFilterList = new ArrayList<>();
		List<Task> taskList = taskRepository.findAllByProjectId(projectId);
		for(Task t: taskList){
			TaskFilter filterObj = new TaskFilter();
			filterObj.setTaskId(t.getTaskId());
			filterObj.setParentTaskId(t.getParentId());
			filterObj.setProjectId(t.getProjectId());
			filterObj.setTaskName(t.getTaskName());
			filterObj.setStartDate(t.getStartDate());
			filterObj.setEndDate(t.getEndDate());
			filterObj.setPriority(t.getPriority());
			filterObj.setStatus(t.getStatus());
			filterObj.setUserId(t.getUserId());
			if(t.getParentId() != null){
				ParentTask parentTask = parentTaskService.getParentTask(t.getParentId());
				if(parentTask != null){
					filterObj.setParentTaskName(parentTask.getParentTask());
				}
			}
			if(t.getProjectId() != null){
				Project project = projectService.getProject(t.getProjectId());
				if(project!= null){
					filterObj.setProjectName(project.getProjectName());
				}	
			}
			if(t.getUserId() != null){
				User user = userService.getUser(t.getUserId());
				if(user != null){
					filterObj.setUserName(user.getFirstName());
				}
			}
			
			taskFilterList.add(filterObj);
			
		}
		return taskFilterList;
	}
	
    public void deleteTask(Long id) {
		
		taskRepository.delete(id);
	}

	public Task createTask(Task task) {
		
		return taskRepository.save(task);
	}

	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

}
