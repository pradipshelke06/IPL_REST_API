package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.MatchDao;
import com.tka.model.Match;
@Service
public class MatchService {
	@Autowired
	private MatchDao matchdao;
	
	public String addMatch(Match match) {
	
		String msg = matchdao.addMatch(match);
		
		return msg;
		
	}
	public List<Match> getAllMatchs(){
		
		List<Match> allMatchs = matchdao.getAllMatchs();
		return allMatchs;
		
	}
	
	public Match getMatchById(int id) {
		Match match = matchdao.getMatchById(id);
		
		return match;
		
	}
	public String deleteMatch(int id) {
		int status =matchdao.deleteMatch(id);
		if (status==0) {	
			return "Match Not Found..";
		}else {
			return "Match Deleted....";
		}
		
		
	}
	public String updateMatch(int id,Match match) {
		int status = matchdao.updateMatch(id, match);
		if (status==0) {	
			return "Match Not Found to Update..";
		}else {
			return "Match Updated....";
		}
	
		
	}

}
