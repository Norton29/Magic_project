package com.nff.magic;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nff.magic.repository.DeckRepository;
import com.nff.magic.service.DeckService;

@SpringBootTest
@Transactional
public class DeckTest {

	@Autowired
	private DeckRepository deckRepository;

	@Autowired
	private DeckService deckService;
	

//	/* Buscar Deck */
//	@Test
//	void deckTestFindAll() {
//		deckRepository.findAll();
//	}
//
////	/* Buscar pelo Id */
////	@Test
////	void deckTestFindById() {
////		Deck findById = deckRepository.findById(10L).get();
////		assertEquals(10l, findById.getId());
////
////	}
//
//	
//
//	/* Insert Test para adicionar Deck */
//	@Test
//	void insertDeckTest() {
//		var createDeck = Deck.builder().name("Deck de ataque").card(null).player(Player.builder().id(1L).build())
//				.build();
//
//		deckService.insert(createDeck);
//		
//
//	}
//
//	/* Delete Teste */
//	@Test
//	void deleteDeckTest() {
//	
//		deckService.delete(10L);
//	}
//
//	/* Atualiza Teste */
//
//	@Test
//	void updateDeckTest() {
//		Deck referenceById = deckRepository.getReferenceById(10L);
//
//		var updateDeck = Deck.builder().name("Deck de Teste1").build();
//
//		deckService.updateData(referenceById, updateDeck);
//		deckRepository.save(updateDeck);
//
//	}
}
