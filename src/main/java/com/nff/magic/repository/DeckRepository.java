package com.nff.magic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nff.magic.domain.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
	
//	@Transactional
//	@Modifying
//	@Query(value = "INSERT INTO deck_card (deck_id, card_id) VALUES (deck_id = :deck_id,card_id = :card_id);" , nativeQuery = true)
//	void insertCardToDeck(@Param("deck_id") Integer deck_id, @Param("card_id") Integer card_id);
	
	
	@Query(value = "select * from deck where name = :name" , nativeQuery = true )
	List<Deck> findByName(@Param("name") String name);
	
	@Query(value = "SELECT * FROM magic.deck INNER JOIN magic.deck_card ON magic.deck.id = magic.deck_card.deck_id"
			+ "AND magic.deck_card.card_id INNER JOIN magic.card ON magic.deck_card.card_id = magic.card.id ORDER BY magic.card.name", nativeQuery = true)
	List<Deck> findAllOrderByNameASC();
	
	@Query(value = "SELECT * FROM magic.deck INNER JOIN magic.deck_card ON magic.deck.id = magic.deck_card.deck_id"
			+ "AND magic.deck_card.card_id INNER JOIN magic.card.id ON magic.deck_card.card_id = magic.card.id ORDER BY magic.card.price" , nativeQuery = true)
	List<Deck> findAllOrderByPriceASC();

}
