package com.nff.magic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nff.magic.domain.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	@Query("SELECT p.gamerTag FROM Card c JOIN c.decks d JOIN d.player p WHERE c.id = :id")
	String findGamerTagById(@Param("id") Long id);
	
	
}
