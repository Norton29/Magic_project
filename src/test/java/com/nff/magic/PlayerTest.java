package com.nff.magic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.CapturesArguments;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import com.nff.magic.domain.Player;
import com.nff.magic.domain.dto.PlayerFilterDTO;
import com.nff.magic.repository.PlayerRepository;
import com.nff.magic.service.PlayerService;

@ExtendWith(MockitoExtension.class)
public class PlayerTest {

	@InjectMocks
	private PlayerService playerService;
	
	@Mock
	private PlayerRepository playerRepository;
	
	@Captor
	ArgumentCaptor<Player> playerCaptor;
	
	List<Player> listPlayer = new ArrayList<>();
	PlayerFilterDTO build = PlayerFilterDTO.builder()
		.id(1l)
		.name("Norton")
		.nickname("Vegetal")
		.sort("ASC,name")
		.build();
	Player player = Player.builder()
			.id(build.getId())
			.name(build.getName())
			.nickname(build.getNickname())
			.build();
	Player newPlayer = Player.builder()
			.id(2l)
			.name("Novo Player")
			.nickname("Novato")
			.build();
	
	

	@Test
	void ShouldGetPlayersByFilter() {
		//arrange
		listPlayer.add(player);
		
		when(playerRepository.findAll(Example.of(player),
				build.getSort())).thenReturn(listPlayer);
		
		//action
		playerService.findBy(build);
		
		
		//assertions
		
		verify(playerRepository).findAll(Example.of(player), build.getSort());
		
		
		}
	
	@Test
	void ShouldInsertPlayer() {
		//arrange
		when(playerRepository.save(player)).thenReturn(player);	
		
		//action
		playerService.insert(player);
		
		//assertion
		verify(playerRepository).save(playerCaptor.capture());
		Player playerSave = playerCaptor.getValue();
		
		assertEquals("Norton", playerSave.getName());
		assertThat(playerSave.getGamerTag()).isNotNull();
		
	}
	
	
	@Test
	void ShouldUpdatePlayer() {
		//arrange
		when(playerRepository.getReferenceById(1l)).thenReturn(player);
		
	}
	
	@Test
	void ShouldnotUpdatePlayer() {
		
	}
	
	
	
	
}
