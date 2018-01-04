package com.cognizant.projectmanagement.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentTaskService {
	
	@Autowired
	private ParentTaskRepository parentTaskRepository;

	public List<ParentTask> getAllParentTask() {
		List<ParentTask> parentTask = new ArrayList();
		parentTaskRepository.findAll().forEach(parentTask::add);
		return parentTask;
	}

	public ParentTask createParentTask(ParentTask parentTask) {
		
		return parentTaskRepository.save(parentTask);
	}
	
   public ParentTask getParentTask(Long id) {
		
		return parentTaskRepository.findOne(id);
	}

}
