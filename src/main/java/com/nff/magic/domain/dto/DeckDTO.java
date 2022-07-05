package com.nff.magic.domain.dto;

import com.nff.magic.domain.Deck;
import com.nff.magic.domain.Player;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeckDTO {

	
	private String name;
	private Player player;
	
	

	
	
	public DeckDTO(Deck deck) {
		name = deck.getName();
		player = deck.getPlayer();
				
	}
	
	
	
}
