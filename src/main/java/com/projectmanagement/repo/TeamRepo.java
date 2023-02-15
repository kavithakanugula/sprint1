package com.projectmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectmanagement.entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {

}
