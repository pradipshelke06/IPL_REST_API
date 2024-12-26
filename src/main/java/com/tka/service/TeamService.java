package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.TeamDao;
import com.tka.model.Team;

@Service
public class TeamService {
	
	@Autowired
	private TeamDao teamdao;
	
	public String addTeam(Team team) {
	
		String msg = teamdao.addTeam(team);
		
		return msg;
		
	}
	public List<Team> getAllTeams(){
		
		List<Team> allTeams = teamdao.getAllTeams();
		return allTeams;
		
	}
	
	public Team getTeamById(int id) {
		Team team = teamdao.getTeamById(id);
		
		return team;
		
	}

}