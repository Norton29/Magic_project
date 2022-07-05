package com.nff.magic.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nff.magic.domain.Card;
import com.nff.magic.domain.dto.CardFilterDTO;
import com.nff.magic.repository.CardRepository;
import com.nff.magic.service.exception.ConstraintException;
import com.nff.magic.service.exception.ResourceNotFoundException;

@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<Card> findAll() {
		return cardRepository.findAll();
	}
	
	
	
	public List<Card> findBy(CardFilterDTO cardFilterDTO) {
		if(cardFilterDTO.getSort() == null) {
			return this.cardRepository.findAll(
					Example.of(
						Card.builder()
								.id(cardFilterDTO.getId())
								.name(cardFilterDTO.getName())
								.build()
							)
					);
		}else {
			return this.cardRepository.findAll(
					Example.of(
						Card.builder()
								.id(cardFilterDTO.getId())
								.name(cardFilterDTO.getName())
								.build()
							),cardFilterDTO.getSort()
					);
		}
		
		

	}
	
	public Card insert(Card card) {
		try {
			return cardRepository.save(card);
		}catch(DataIntegrityViolationException e) {
			throw new ConstraintException();
		}
	}
	
	public void delete(Long id) {
		cardRepository.deleteById(id);
	}
	
	public Card update(Long id, Card card) {
		try {
		Card entity = cardRepository.getReferenceById(id);
		updateData(entity, card);
		return cardRepository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	
	public void updateData(Card entity, Card card) {
		entity.setPrice(card.getPrice());
		entity.setQuantity(card.getQuantity());
		
	

}

	
}
