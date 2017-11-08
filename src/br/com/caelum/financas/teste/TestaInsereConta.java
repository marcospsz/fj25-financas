package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		long inicio = System.currentTimeMillis();	
		
		ContaDao dao = new ContaDao(manager) ;
				
		Conta conta = new Conta();
		
		conta.setAgencia("3025");
		conta.setBanco("033");
		conta.setNumero("35214-6");
		conta.setTitular("Caelum hoje ta melhor");
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();		
		
		//Conta encontrado = dao.busca(5);
		
		//System.out.println("Titular encontrado: " + encontrado.getTitular());
		
		List<Conta> encontrados = dao.lista();
		
		for (Conta contaEncontrada: encontrados)
			System.out.println(contaEncontrada.getAgencia() + " - " + contaEncontrada.getNumero() + " - " + contaEncontrada.getTitular() );		
					
		manager.close();
				
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim - inicio) + "ms");

	}

}
