package com.nff.magic.domain.dto;

import java.util.UUID;

import com.nff.magic.domain.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

	private String name;
	private String nickname;
	private UUID gamerTag;

	
	public PlayerDTO(Player player) {
		name = player.getName();
		nickname = player.getNickname();
		gamerTag = player.getGamerTag();
		
	}
	
	
	
}
