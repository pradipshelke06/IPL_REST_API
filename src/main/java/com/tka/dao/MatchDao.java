package com.tka.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tka.model.Match;
@Repository
public class MatchDao {

	List<Match>matchs=new LinkedList<Match>();
	public MatchDao() {
		matchs.add(new Match(101, "MI", "CSK", "2024-12-12", "Wankhede", "MI-Win"));
		matchs.add(new Match(102, "RCB", "DC", "2024-12-15", "Eden Gardens", "DC-Win"));
		
		//matchs.add(new Match(1, "MI", "Mumbai", "Polard"));
		//matchs.add(new Match(2, "CSK", "Chennai", "Dhoni"));
	}
	
	public String addMatch(Match match) {
		
		matchs.add(match);
		
		return "Added Successfully...";
		
	}
	public List<Match> getAllMatchs(){
		
		return matchs;
	}
	public Match getMatchById(int id) {
		
		for (Match match : matchs) {
			if (match.getMatchId()==id) {
				return match;
			}
			
		}
	return null;
}
	public int deleteMatch(int id) {
		
		for (Match match : matchs) {
			if (match.getMatchId()==id) {
				matchs.remove(match);				
				return 1;			
			}		
		}
		return 0;		
	}
	public int updateMatch(int id, Match match) {
		int status=deleteMatch(id);
		if (status==1) {
			matchs.add(match);
			return 1;
			
		}else {
			return 0;
		}	
	}
}
