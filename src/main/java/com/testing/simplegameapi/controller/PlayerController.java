package com.testing.simplegameapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.persistence.RollbackException;

import com.testing.simplegameapi.model.entity.Player;
import com.testing.simplegameapi.model.repository.PlayerRepository;

@RestController
@RequestMapping(path="/player")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@PostMapping(path="/add")
	public ResponseEntity addNewPlayer (
		@RequestBody @Valid Player player
	) {
		try {
			//Player player = new Player(name, email);
			player = playerRepository.save(player);
			
			return ResponseEntity.ok().body(player);
		} catch (ConstraintViolationException e) {
			
			return ResponseEntity.badRequest().body(e.getConstraintViolations().toString());
		} catch (RollbackException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping
	public Iterable<Player> getAllPlayers() {
	    return playerRepository.findAll();  
	}
}
