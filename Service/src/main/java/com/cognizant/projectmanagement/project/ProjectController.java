package com.cognizant.projectmanagement.project;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ProjectFilter> getAllProject() {
		
		return projectService.getAllProject();	
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody Project createProject(@RequestBody Project project) {
		
		return projectService.createProject(project);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public @ResponseBody Project updateProject(@RequestBody Project project) {
		
		return projectService.updateProject(project);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public @ResponseBody String deleteProject(@PathVariable("id") Long id){
		projectService.deleteProject(id);
	     return "Success";
		
	}
	
}
