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

import com.nff.magic.domain.Deck;
import com.nff.magic.domain.dto.DeckDTO;
import com.nff.magic.domain.dto.DeckFilterDTO;
import com.nff.magic.service.DeckService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/deck")
@RequiredArgsConstructor
public class DeckController {
	
	private final DeckService deckService;
	
	/* Metodo para buscar todos os Decks**/		
	@GetMapping
	public ResponseEntity<List<Deck>> findAll(){
		List<Deck> deck = deckService.findAll();		
		return ResponseEntity.ok().body(deck);
				
	}
	

	
	/* Metodo para buscar Deck pelo Id*/	
	@GetMapping(value = "/")
	public ResponseEntity<List<Deck>> findById(
			@RequestParam(value = "id", required = false) Long id, 
    		@RequestParam(value = "name", required = false) String name, 
    		@RequestParam(value = "sort", required = false) String sort) {
		 return ResponseEntity.ok()
	                .body(
	                        this.deckService.findBy(
	                                DeckFilterDTO.builder()
	                                        .id(id)
	                                        .name(name)	                                        
	                                        .sort(sort)
	                                        .build()
	                        ));		
	}		
	
	
	/*Metodo para Inserir novos Decks*/	
	@PostMapping
	public ResponseEntity<DeckDTO> insert (@RequestBody Deck playerParam, @RequestHeader("gamerTag") String gamerTag){
		Deck deck = deckService.insert(playerParam);
		DeckDTO deckDTO = new DeckDTO(deck);
		return ResponseEntity.ok().body(deckDTO);
	}
	
	/* Metodo para Deletar Deck pelo Id*/	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Deck> delete(@PathVariable Long id){
		deckService.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	/* Metodo para atualizar dados do Deck utilizando o Id como referência*/	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DeckDTO> update(@PathVariable Long id, @RequestBody Deck deck) {
		deck = deckService.update(id, deck);
		DeckDTO deckDTO = new DeckDTO(deck);
		return ResponseEntity.ok().body(deckDTO);
	}
	
//	/* Metodo ainda não finalizado para inserir associação entre cartas e decks*/	
//	@PostMapping(value = "/insertCards/deck/")
//	public ResponseEntity<Deck_card> insertCardsToDeck(@RequestBody Deck_card deck_card){
//		deckService.insertCardToDeck(deck_card);
//		return ResponseEntity.ok().body(null);
//	}
	
	

}
