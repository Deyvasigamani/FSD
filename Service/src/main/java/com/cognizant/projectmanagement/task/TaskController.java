package com.cognizant.projectmanagement.task;


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
@RequestMapping(path="/task")
@CrossOrigin
public class TaskController {
	
	@Autowired 
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<TaskFilter> getAllTasks() {
		return taskService.getAllTasks();
		
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{projectId}")
	public @ResponseBody List<TaskFilter> getTasksByProject(@PathVariable Long projectId){
		return taskService.getTask(projectId);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Task createTask(@RequestBody Task task){
		return taskService.createTask(task);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{id}")
	public @ResponseBody Task updateTaskStatus(@PathVariable("id") Long id){
		return taskService.updateTaskStatus(id);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody Task updateTask(@RequestBody Task task){
		return taskService.updateTask(task);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	public @ResponseBody String deleteTask(@PathVariable("id") Long id){
		taskService.deleteTask(id);
	     return "Success";
		
	}
	
	
}
