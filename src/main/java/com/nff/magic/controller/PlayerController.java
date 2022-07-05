package com.nff.magic.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nff.magic.domain.Player;
import com.nff.magic.domain.dto.PlayerDTO;
import com.nff.magic.domain.dto.PlayerFilterDTO;
import com.nff.magic.service.PlayerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    /* Metodo para buscar todos os Players**/
    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok()
                .body(this.playerService.findAll());
    }

    /* Metodo para buscar Players pelo Id*/
    @GetMapping(value = "/")
    public ResponseEntity<List<Player>> findBy(
    		@RequestParam(value = "id", required = false) Long id, 
    		@RequestParam(value = "name", required = false) String name, 
    		@RequestParam(value = "nickName", required = false) String nickName,
    		@RequestParam(value = "sort", required = false) String sort
    		){
        return ResponseEntity.ok()
                .body(
                        this.playerService.findBy(
                                PlayerFilterDTO.builder()
                                        .id(id)
                                        .name(name)
                                        .nickname(nickName)
                                        .sort(sort)
                                        .build()
                        )
                        
                );
    }

    /*Metodo para Inserir novos Players*/
    @PostMapping
    public ResponseEntity<PlayerDTO> insert(@RequestBody Player playerParam) {
        Player player = playerService.insert(playerParam);
        PlayerDTO playerDTO = new PlayerDTO(player);
        return ResponseEntity.ok().body(playerDTO);
    }

    /* Metodo para Deletar Deck pelo Id*/
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Player> delete(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.ok().body(null);
    }

    /* Metodo para atualizar dados do Player utilizando o Id como referência*/
    @PutMapping(value = "/{id}")
    public ResponseEntity<PlayerDTO> update(@PathVariable Long id, @RequestBody Player player) {
        player = playerService.update(id, player);
        PlayerDTO playerDTO = new PlayerDTO(player);
        return ResponseEntity.ok().body(playerDTO);
    }


}
