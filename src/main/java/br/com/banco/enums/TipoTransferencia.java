package br.com.banco.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTransferencia {

	TED("Ted", 0.05),
	PIX("Pix", 0.0);

	private final String descricao;
	private final double taxa;
}