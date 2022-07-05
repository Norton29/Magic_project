package com.nff.magic.service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nff.magic.domain.Player;
import com.nff.magic.domain.PlayerVO;
import com.nff.magic.domain.dto.PlayerFilterDTO;
import com.nff.magic.repository.PlayerRepository;
import com.nff.magic.service.exception.ResourceNotFoundException;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }


    public List<Player> findBy(PlayerFilterDTO playerFilterDTO) {   
    	
        return this.playerRepository.findAll(
                Example.of(
                        Player.builder()
                                .id(playerFilterDTO.getId())
                                .name(playerFilterDTO.getName())
                                .nickname(playerFilterDTO.getNickname())                                
                                .build()
                ), playerFilterDTO.getSort()
               
        );
    }

    public PlayerVO insert(Player player) {
    	player.setGamerTag(UUID.randomUUID().toString());
    	Player save = playerRepository.save(player);   		    	
        return new PlayerVO(save.getId(), save.getName(), save.getNickname(), save.getGamerTag());
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Long id, Player player) {
        try {
            Player entity = playerRepository.getReferenceById(id);
            updateData(entity, player);
            return playerRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    private void updateData(Player entity, Player player) {
        entity.setName(player.getName());
        entity.setNickname(player.getNickname());
        entity.setDecks(player.getDecks());

    }

}
