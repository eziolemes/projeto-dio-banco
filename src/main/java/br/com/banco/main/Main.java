package br.com.banco.main;

import br.com.banco.enums.TipoTransferencia;
import br.com.banco.modelo.Banco;
import br.com.banco.modelo.Cliente;
import br.com.banco.modelo.Conta;
import br.com.banco.modelo.ContaCorrente;
import br.com.banco.modelo.ContaPoupanca;

public class Main {

	public static void main(String[] args) throws Exception {
		Banco banco = new Banco("Bando DIO");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Ezio");
		
		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);

		banco.setConta(cc);
		banco.setConta(cp);
		
		cc.depositar(100);
		cc.transferir(50, cp, banco, TipoTransferencia.TED);
		
		cc.imprimeExtrato();
		cp.imprimeExtrato();
		
		banco.imprimeTotalCaptado();
		banco.imprimeCaixaBanco();
	}
}
