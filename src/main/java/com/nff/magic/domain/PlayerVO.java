package com.nff.magic.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PlayerVO {

	
	private final Long id;
	private final String name;
	private final String nickname;
	private final String gamerTag;
	

}
