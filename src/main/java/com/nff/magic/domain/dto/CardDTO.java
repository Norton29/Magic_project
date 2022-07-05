package com.nff.magic.domain.dto;

import com.nff.magic.domain.Card;
import com.nff.magic.domain.Enuns.Language;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
	
	private String name;
	private Integer edition;
	private Language language;
	private Boolean foil;
	private Double price;
	private Integer quantity;

	
	public CardDTO(Card card){
		name = card.getName();
		edition = card.getEdition();
		language =card.getLanguage();
		foil = card.getFoil();
		price = card.getPrice();
		quantity = card.getQuantity();
		
	
	}

}
