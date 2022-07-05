package com.nff.magic.domain.dto;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerFilterDTO {

	private Long id;
	private String name;
	private String nickname;
	private String sort;
	
	
	public Sort getSort() {
		return Optional.ofNullable(this.sort).map(sort -> 
    	{
    		String[] split = sort.split(",");
    		Direction valueOf = Sort.Direction.valueOf(split[0]);
    		String attribute = split[1];
    		return Sort.by(valueOf , attribute);
    		 
    	}
    			).orElse(null);
	}

	
	
}
