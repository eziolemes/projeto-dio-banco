package br.com.banco.modelo;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public void imprimeExtrato() {
		System.out.println("=== Extrato da Conta Corrente ===");
		imprimirInfosComuns();
	}
	
}
