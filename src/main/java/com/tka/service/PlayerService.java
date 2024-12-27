package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PlayerDao;
import com.tka.model.Player;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerDao playerdao;
	
	public String addPlayer(Player player) {
	
		String msg = playerdao.addPlayer(player);
		
		return msg;
		
	}
	public List<Player> getAllPlayers(){
		
		List<Player> allPlayers = playerdao.getAllPlayers();
		return allPlayers;
		
	}
	
	public Player getPlayerById(int id) {
		Player player = playerdao.getPlayerById(id);
		
		return player;
		
	}
	public String deletePlayer(int id) {
		int status =playerdao.deletePlayer(id);
		if (status==0) {	
			return "Player Not Found..";
		}else {
			return "Player Deleted....";
		}
		
		
	}
	public String updatePlayer(int id,Player player) {
		int status = playerdao.updatePlayer(id, player);
		if (status==0) {	
			return "Player Not Found to Update..";
		}else {
			return "Player Updated....";
		}
	
		
	}

}
