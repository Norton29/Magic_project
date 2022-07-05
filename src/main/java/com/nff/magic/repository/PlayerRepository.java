package com.nff.magic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nff.magic.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

	
	@Query(value = "select * from player where name = :name" , nativeQuery = true )
	List<Player> findByName(@Param("name") String name);
	
	@Query(value = "select * from player where name = :name" , nativeQuery = true )
	List<Player> findPlayer();
}
