package com.cognizant.projectmanagement.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/parenttask")
@CrossOrigin
public class ParentTaskController {

	@Autowired
	private ParentTaskService parentTaskService;
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<ParentTask> getAllParentTask() {
		return parentTaskService.getAllParentTask();
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody ParentTask createParentTask(@RequestBody ParentTask parentTask) {
		return parentTaskService.createParentTask(parentTask);		
	}

}
