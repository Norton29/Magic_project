package com.nff.magic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nff.magic.domain.Player;
import com.nff.magic.repository.PlayerRepository;

@SpringBootTest
public class PlayerTest {

	@Autowired
	private PlayerRepository playerrepository;
	

	@Test
	void Player() {
		playerrepository.save(Player.builder()
				.id(10l)
				.name("Norton")
				.nickname("aleatorio")
				.build());

		}
	
	
	
}
