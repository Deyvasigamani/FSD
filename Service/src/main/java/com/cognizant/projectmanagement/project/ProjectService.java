package com.cognizant.projectmanagement.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.projectmanagement.task.TaskService;
import com.cognizant.projectmanagement.user.User;
import com.cognizant.projectmanagement.user.UserService;

@Service
public class ProjectService {
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@Autowired 
	private TaskService taskService;
	
	@Autowired 
	private UserService userService;

	

	public List<ProjectFilter> getAllProject() {
		List<Project> projects= new ArrayList();
		  projectRepository.findAll().forEach(projects::add);
		
		List<ProjectFilter> projectFilterList = new ArrayList<>();
		 for(Project project: projects){
			 ProjectFilter projectFilter = new ProjectFilter();
			 projectFilter.setProjectId(project.getProjectId());
			 projectFilter.setProjectName(project.getProjectName());
			 projectFilter.setStartDate(project.getStartDate());
			 projectFilter.setEndDate(project.getEndDate());
			 projectFilter.setPriority(project.getPriority());
			 projectFilter.setTaskNumber(taskService.findAllByProjectId(project.getProjectId()).size());
			 projectFilter.setCompletedTaskNumber(taskService.findAllByProjectIdAndStatus(project.getProjectId(), "COMPLETED").size());
			 projectFilter.setUserId(project.getUserId());
			 if(project.getUserId() != null){
				 User user = userService.getUser(project.getUserId());
				 if( user != null){
					 projectFilter.setManager(user.getFirstName());
				 }
			 }
			 
			 projectFilterList.add(projectFilter);
		 }
		return projectFilterList;
	}
	
	public Project getProject(Long id)
	{
		return projectRepository.findOne(id);
	}

	public Project createProject(Project project) {
		
		return projectRepository.save(project);
	
	}

	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		projectRepository.delete(id);
		
	}

}
