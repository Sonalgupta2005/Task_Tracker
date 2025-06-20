package com.kiet.Task_Tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiet.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
	List<Task> findByCompletedFalse();
	List<Task> findByCompleted(Boolean completed);
	
}
