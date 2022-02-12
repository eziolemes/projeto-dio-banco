package br.com.banco.modelo;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Banco {
	
	private String nome;
	private double valorCaixa;
	private List<Conta> contas;
	
	public Banco(String nome) {
		this.nome = nome;
		this.valorCaixa = 0;
		this.contas = new ArrayList<Conta>();
	}
	
	public int totalContas() {
		return contas.size();
	}
	
	public void setConta(Conta conta) {
		contas.add(conta);
	}
	
	public void setTaxa(double valorTaxa) {
		valorCaixa += valorTaxa;
	}
	
	private double totalCaptado() {
		double total = 0;
		
		for (Conta conta : contas) {
			total += conta.getSaldo();
		}
		
		return total + valorCaixa;
	}
	
	public void imprimeTotalCaptado() {
		System.out.println(String.format("Total captado pelo banco: %.2f", this.totalCaptado()));
		System.out.println("\n");
	}
	
	public void imprimeCaixaBanco() {
		System.out.println(String.format("Caixa do banco: %.2f", this.getValorCaixa()));
		System.out.println("\n");
	}
	
}
