package com.projectmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.entity.Task;
import com.projectmanagement.exceptions.ResourceNotFoundException;
import com.projectmanagement.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping({ "/admin/get-task-by-id/{id}", "/team/get-task-by-id/{id}" })
	public ResponseEntity<?> getTaskById(@PathVariable long id) throws ResourceNotFoundException {
		return ResponseEntity.ok(taskService.getTaskById(id));
	}

	@PostMapping("/admin/add-task")
	public ResponseEntity<?> addTask(@RequestBody Task task) throws Exception {
		return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
	}

	@PutMapping({ "/admin/update-task" })
	public ResponseEntity<?> updateTask(@RequestBody Task task) throws ResourceNotFoundException {
		return ResponseEntity.ok(taskService.modifyTask(task));
	}

	@GetMapping("/admin/get-all-list-of-tasks")
	public ResponseEntity<?> getListOfTasks() {
		return ResponseEntity.ok(taskService.getListOfTasks());
	}

	@DeleteMapping("/admin/delete-task/{taskId}")
	public ResponseEntity<?> deleteTask(@PathVariable long taskId) throws ResourceNotFoundException {
		return ResponseEntity.ok(taskService.deleteTask(taskId));
	}

}
