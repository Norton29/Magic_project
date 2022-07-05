package com.nff.magic.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nff.magic.domain.Deck;
import com.nff.magic.domain.dto.DeckFilterDTO;
import com.nff.magic.repository.DeckRepository;
import com.nff.magic.service.exception.ResourceNotFoundException;

@Service
public class DeckService {

	@Autowired
	private DeckRepository deckRepository;

	public List<Deck> findAll() {
		return deckRepository.findAll();

	}

	public List<Deck> findBy(DeckFilterDTO deckFilterDTO) {
		if(deckFilterDTO.getSort() == null) {
			return this.deckRepository.findAll(
					Example.of(
						Deck.builder()
								.id(deckFilterDTO.getId())
								.name(deckFilterDTO.getName())
								.build()
							)
					);
		}else {
			return this.deckRepository.findAll(
					Example.of(
						Deck.builder()
								.id(deckFilterDTO.getId())
								.name(deckFilterDTO.getName())
								.build()
							),deckFilterDTO.getSort()
					);
		}
		
		

	}

	public long countNumberOfCardOnDeck() {
		return deckRepository.count();
	}
	

	public Deck insert(Deck deck) {
		return deckRepository.save(deck);
	}

//	public void insertCardToDeck(Deck_card deck_card) {	
//		Deck_card entity = new Deck_card(deck_card.getDeck_id(), deck_card.getCard_id());
//		deckRepository.insertCardToDeck(entity.getDeck_id(), entity.getCard_id());
//		
//	}	

	public void delete(Long id) {
		deckRepository.deleteById(id);
	}

	public Deck update(Long id, Deck deck) {
		try {
			Deck entity = deckRepository.getReferenceById(id);
			updateData(entity, deck);
			return deckRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void updateData(Deck entity, Deck deck) {
		entity.setName(deck.getName());
		entity.setPlayer(deck.getPlayer());
		
	
			

	}

}
