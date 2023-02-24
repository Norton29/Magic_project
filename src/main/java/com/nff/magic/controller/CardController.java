package com.nff.magic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nff.magic.domain.Card;
import com.nff.magic.domain.dto.CardFilterDTO;
import com.nff.magic.service.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/cards")
@RequiredArgsConstructor
public class CardController {
	
	
	private final CardService cardService;
	
	/* Metodo para buscar todos os Decks**/		
	@GetMapping
	public ResponseEntity<List<Card>> findAll(){
		List<Card> deck = cardService.findAll();		
		return ResponseEntity.ok().body(deck);
				
	}
	

	
	/* Metodo para buscar Deck pelo Id*/	
	@GetMapping(value = "/")
	public ResponseEntity<List<Card>> findById(
			@RequestParam(value = "id", required = false) Long id, 
    		@RequestParam(value = "name", required = false) String name, 
    		@RequestParam(value = "price", required = false) Double price, 
    		@RequestParam(value = "sort", required = false) String sort) {
		 return ResponseEntity.ok()
	                .body(
	                        this.cardService.findBy(
	                                CardFilterDTO.builder()
	                                        .id(id)
	                                        .name(name)
	                                        .price(price)
	                                        .sort(sort)
	                                        .build()
	                        ));		
	}		
	
	
	/*Metodo para Inserir novos Decks*/	
	@PostMapping
	public ResponseEntity<Card> insert (@RequestBody Card playerParam){
		Card card = cardService.insert(playerParam);		
		return ResponseEntity.ok().body(card);
	}
	
	/* Metodo para Deletar Deck pelo Id*/	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Card> delete(@PathVariable Long id){
		cardService.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	/* Metodo para atualizar dados do Deck utilizando o Id como referência*/	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Card card,  @RequestHeader("gamerTag") String gamerTag) {		
		try {
			return ResponseEntity.ok().body(cardService.update(id, card, gamerTag));
			
		}catch(Exception e) {
			return ResponseEntity.unprocessableEntity().body(e.getMessage());
		}
	}
	
//	/* Metodo ainda não finalizado para inserir associação entre cartas e decks*/	
//	@PostMapping(value = "/insertCards/deck/")
//	public ResponseEntity<Deck_card> insertCardsToDeck(@RequestBody Deck_card deck_card){
//		deckService.insertCardToDeck(deck_card);
//		return ResponseEntity.ok().body(null);
//	}
	
	

}
