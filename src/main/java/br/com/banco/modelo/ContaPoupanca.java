package br.com.banco.modelo;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public void imprimeExtrato() {
		System.out.println("=== Extrato da Conta Poupança ===");
		imprimirInfosComuns();
	}

}
