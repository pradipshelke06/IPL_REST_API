package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tka.model.Team;

@Repository
public class TeamDao {
	List<Team>teams=new ArrayList<Team>();
	
	public String addTeam(Team team) {
		
		teams.add(team);
		
		return "Added Successfully...";
		
	}
	public List<Team> getAllTeams(){
		
		return teams;
	}
	public Team getTeamById(int id) {
		
		for (Team team : teams) {
			if (team.getTeamId()==id) {
				return team;
			}
			
		}
	return null;
}
}
