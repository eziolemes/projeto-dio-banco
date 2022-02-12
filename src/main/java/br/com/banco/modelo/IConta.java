package br.com.banco.modelo;

import br.com.banco.enums.TipoTransferencia;

public interface IConta {
	
	void sacar(double valor) throws Exception;
	
	void depositar(double valor);
	
	void transferir(double valor, Conta contaDestino, Banco banco, TipoTransferencia tipoTransferencia) throws Exception;
	
	void imprimeExtrato();
	
	boolean temSaldo(double valor);
}