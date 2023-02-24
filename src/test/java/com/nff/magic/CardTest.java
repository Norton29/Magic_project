package com.nff.magic;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nff.magic.domain.Card;
import com.nff.magic.domain.Enuns.Language;
import com.nff.magic.domain.dto.CardFilterDTO;
import com.nff.magic.repository.CardRepository;
import com.nff.magic.service.CardService;

@SpringBootTest
@Transactional
public class CardTest {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardService cardService;
	



//	/*Listar por ordem alfabetico*/
//	@Test
//	void cardTestFindByNameASC() {
//	
//		cardService.findBy(
//				CardFilterDTO.builder()
//					.id(null)
//	                .name("")	                                        
//	                .sort("ASC,name")
//	                .build());
//		
//	
//	}
//	
//	/*Listar por ordem de valor*/
//	@Test
//	void cardTestFindByPriceASC() {
//	
//		cardService.findBy(
//				CardFilterDTO.builder()
//					.id(null)
//	                .name("")	                                        
//	                .sort("ASC,price")
//	                .build());
//		
//	
//	}
//	
//
//	/* Insert Test para adicionar Card */
//	@Test
//	void insertCardTest() {
//		var createCard = Card.builder()
//				.name("Espada")
//				.edition(1)
//				.language(Language.INGLÊS)
//				.foil(true)
//				.price(500.00)
//				.quantity(1)				
//				.build();
//
//		cardRepository.save(createCard);	
//
//	}	

	/* Atualiza Teste */

//	@Test
//	void updateCardTest() {
//		Card referenceById = cardRepository.getReferenceById(1L);
//
//		var updateCard = Card.builder()
//				.price(100.00)
//				.quantity(3)
//				.build();
//
//		cardService.updateData(referenceById, updateCard);
//		cardRepository.save(updateCard);
//
//	}
//	
//	/* Delete Teste */
//	@Test
//	void deleteTest() {	
//		
//
//		cardService.delete(1L);
//	}
}
