package com.cognizant.projectmanagement.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task,Long>{

	List<Task> findAllByProjectId(Long id);
		
	List<Task> findAllByProjectIdAndStatus(Long id, String status);
	
}
