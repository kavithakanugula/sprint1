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
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.entity.Team;
import com.projectmanagement.exceptions.ResourceNotFoundException;
import com.projectmanagement.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping({ "/admin/get-team-by-id/{teamId}", "/teamlead/get-team-by-id/{teamId}" })
	public ResponseEntity<?> getTeamById(@PathVariable long teamId) throws ResourceNotFoundException {
		return ResponseEntity.ok(teamService.getTeamById(teamId));
	}

	@PostMapping("/admin/add-team")
	public ResponseEntity<?> addTeam(@RequestBody Team team) throws Exception {
		return new ResponseEntity<>(teamService.addTeam(team), HttpStatus.CREATED);
	}

	@GetMapping("/admin/get-all-teams")
	public ResponseEntity<?> getAllTeams() {
		return ResponseEntity.ok(teamService.getListOfTeam());
	}

	@PutMapping({ "/admin/update-team", "teamlead/update-team" })
	public ResponseEntity<?> updateTeam(@RequestBody Team team) throws ResourceNotFoundException {
		return ResponseEntity.ok(teamService.updateTeam(team));
	}

	@DeleteMapping("/admin/delete-team/{teamId}")
	public ResponseEntity<?> deleteTeam(@PathVariable long teamId) throws ResourceNotFoundException {
		return ResponseEntity.ok(teamService.deleteTeam(teamId));
	}
}
