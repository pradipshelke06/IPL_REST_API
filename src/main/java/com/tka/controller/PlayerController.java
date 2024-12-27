package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.model.Player;
import com.tka.service.PlayerService;


@RestController
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/api/players")
	public String addPlayer(@RequestBody Player player) {
		
		String msg = playerService.addPlayer(player);
		
		return msg;
	}
	
	@GetMapping("/api/players/all")
	public List<Player> getAllPlayers(){
		List<Player> allPlayers = playerService.getAllPlayers();
		return allPlayers;
		
	}
	@GetMapping("/api/player")
	public Object getPlayerById(@RequestParam int id) {
		Player player = playerService.getPlayerById(id);
		if (player!=null) {
			return player;
		}else {
			return "Player Not Found....";
		}
		
		
	}
	@DeleteMapping("/api/player/{id}")
	public String deletePlayer(@PathVariable int id) {
		
		return playerService.deletePlayer(id);
		
	}
	@PutMapping("/api/player/{id}")
	public String updatePlayer(@RequestBody Player player, @PathVariable int id) {
		String msg = playerService.updatePlayer(id, player);
		return msg;
	}

}
