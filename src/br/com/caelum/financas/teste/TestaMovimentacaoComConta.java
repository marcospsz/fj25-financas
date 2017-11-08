package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacaoComConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		
		conta.setAgencia("3025");
		conta.setBanco("033");
		conta.setNumero("35214-6");
		conta.setTitular("JAVA SENIOR");
		manager.persist(conta);
		
		Movimentacao movimentacao = new Movimentacao();		
		
		movimentacao.setConta(conta);
		movimentacao.setDescricao("Teste1");
		movimentacao.setValor(BigDecimal.valueOf(1500));
		movimentacao.setDataMovimentacao(LocalDateTime.now());
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);		
		
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		
		manager.close();
		
		System.out.println("Movimentacao incluida com sucesso");
		
	}
	
}
