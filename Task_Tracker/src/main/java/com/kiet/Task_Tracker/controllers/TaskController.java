package com.kiet.Task_Tracker.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiet.Task_Tracker.services.TaskService;
import com.kiet.model.Task;

@Controller
public class TaskController {
	
	private TaskService service;

	public TaskController(TaskService service) {
		super();
		this.service = service;
	}
	@GetMapping("/tasks/{id}")
	public String getStudent(Model model,@PathVariable int id) {
		Task task=service.retrieveById(id);
		model.addAttribute("task",task);
		return "demo";
	}
	@GetMapping("/")
	public String getAllTasks(Model model) {
		List<Task> tasks=service.retrieveAll();
		model.addAttribute("tasks",tasks);
		return "index";
	}
	@GetMapping("/task/status/incomplete")
	public String getIncompleteTasks(Model model) {
		List<Task> incompleteTasks=service.retrieveIncompleteTasks();
		model.addAttribute("tasks",incompleteTasks);
		return "index";
	}
	@GetMapping("/addTask")
	public String addTask(Model model) {
		model.addAttribute("task",new Task());
		return "update";
	}
	@PostMapping("/task")
	public String insertTask(@ModelAttribute Task task) {
		service.addTask(task);
		return "redirect:/";
	}
	@GetMapping("/showFormUpdate/{id}")
	public String addTask(Model model,@PathVariable int id) {
		Task task=service.retrieveById(id);
		model.addAttribute("task",task);
		return "update";
	}
	@GetMapping("/delete/task/{id}")
	public String deleteTask(Model model,@PathVariable int id) {
		service.removeById(id);
		return "redirect:/";
	}
}

