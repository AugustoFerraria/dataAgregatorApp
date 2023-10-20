package com.DataAgregatorApp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ComuneDose {

	@Id
	private String codice;
	private String comune;
	private String provincia;
	private String sigla;
	private int dose1;
	private int dose2;
	private int booster;
	private int richiamo;

	@Override
	public String toString() {
		return "{" + "codice='" + codice + '\'' +
				", comune='" + comune + '\'' +
				", provincia='" + provincia + '\''+ 
				", sigla='" + sigla + '\'' +
				", dose1='" + dose1 + '\'' +
				", dose2='" + dose2 + '\'' +
				", booster='" + booster + '\'' +
				", richiamo='" + richiamo + '\'' + '}';
	}
}