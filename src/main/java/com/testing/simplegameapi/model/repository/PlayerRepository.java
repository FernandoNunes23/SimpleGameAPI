package com.testing.simplegameapi.model.repository;

import com.testing.simplegameapi.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
