package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaAberturaConexoes {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 20; i++){
			
			EntityManager manager = JPAUtil.getEntityManager();
			
			manager.getTransaction().begin();
			System.out.println("criado EntityManager numero: " + i);
			
		}
		
		Thread.sleep(30 * 1000);

	}

}
