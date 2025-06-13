package com.kiet.Task_Tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.Task_Tracker.repository.TaskRepository;
import com.kiet.model.Task;


@Service
public class TaskService {
	private TaskRepository repository;

	public TaskService(TaskRepository repository) {
		super();
		this.repository = repository;
//		repository.save(new Task(101,"E-commerce application","12-07-25",false));
//		repository.save(new Task(102,"Reviewing code","13-06-25",true));
//		repository.save(new Task(103,"Check UI","20-06-25",false));
	}

	public List<Task> retrieveAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Task retrieveById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	public Task addTask(Task task) {
		// TODO Auto-generated method stub
	return repository.save(task);
	}

	public void removeById(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
	}

	public List<Task> retrieveIncompleteTasks() {
		// TODO Auto-generated method stub
		return repository.findByCompletedFalse();
	}
	 public List<Task> filterTasksByStatus(String status) {
	        if (status == null || status.equalsIgnoreCase("all")) {
	            return repository.findAll();
	        } else if (status.equalsIgnoreCase("completed")) {
	            return repository.findByCompleted(true);
	        } else if (status.equalsIgnoreCase("incomplete")) {
	            return repository.findByCompleted(false);
	        }
	        return List.of();
	    }
	

}

