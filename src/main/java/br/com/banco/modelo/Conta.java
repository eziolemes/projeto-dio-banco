package br.com.banco.modelo;

import br.com.banco.enums.TipoTransferencia;
import lombok.Data;

@Data
public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;

	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;


	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	public void sacar(double valor) throws Exception {
		if (temSaldo(valor)) {
			saldo -= valor;
		} else {
			throw new Exception("Você não tem saldo para realizar esta operação!");
		}
	}

	public void depositar(double valor) {
		saldo += valor;
	}

	public void transferir(double valor, Conta contaDestino, Banco banco, TipoTransferencia tipoTransferencia) throws Exception {
		double valorTaxa = calculaTaxa(valor, tipoTransferencia.getTaxa());
		this.sacar(valor + valorTaxa);
		contaDestino.depositar(valor);
		banco.setTaxa(valorTaxa);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("\n");
	}

	public boolean temSaldo(double valor) {
		if (valor > this.saldo) return false;

		return true;
	}
	
	private double calculaTaxa(Double valor, double taxa) {
		return valor * taxa;
	}
}
