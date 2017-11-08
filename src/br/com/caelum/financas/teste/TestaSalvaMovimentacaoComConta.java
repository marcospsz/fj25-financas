package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		MovimentacaoDao movimentoDao = new MovimentacaoDao(manager);
		ContaDao contaDAO = new ContaDao(manager);
		
		Conta conta = contaDAO.busca(3);
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		//movimentacao.setDataMovimentacao(LocalDateTime.now());
		movimentacao.setDescricao("teste3");
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(BigDecimal.valueOf(8632.55));	
		
		manager.getTransaction().begin();
		movimentoDao.adiciona(movimentacao);
		manager.getTransaction().commit();
		
		System.out.println("Movimentação inserida com sucesso");

	}

}
