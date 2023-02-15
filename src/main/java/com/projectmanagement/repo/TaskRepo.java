package com.projectmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanagement.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

}
