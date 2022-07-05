package com.nff.magic.domain.Enuns;

public enum Language {
	
	INGLÊS(1, "Inglês"), 
	PORTUGUÊS(2, "Português"), 
	JAPONÊS(3, "Japonês");
	
	private Integer cod;
	private String language;

	Language(Integer cod, String language) {
		
	}

	public Integer getCod() {
		return cod;
	}

	public String getLanguage() {
		return language;
	}

	public static Language toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(Language x : Language.values()) {
			if(cod == x.getCod()) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Codígo inválido: " + cod);
		
	}
	
	
}
