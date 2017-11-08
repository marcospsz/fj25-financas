package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraConta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager manager = JPAUtil.getEntityManager();
		
		int id = 5;
						
		long inicio = System.currentTimeMillis();	
		
		ContaDao dao = new ContaDao(manager) ;
				
		manager.getTransaction().begin();
		
		Conta conta = dao.busca(id);
		conta.setTitular("Marcos Souza");
		manager.getTransaction().commit();		
		
				
		System.out.println("Titular encontrado/alterado: " + conta.getTitular());
		
		//List<Conta> encontrados = dao.lista();
		
		//for (Conta contaEncontrada: encontrados)
		//	System.out.println(contaEncontrada.getAgencia() + " - " + contaEncontrada.getNumero() + " - " + contaEncontrada.getTitular() );		
					
		manager.close();
				
		long fim = System.currentTimeMillis();
		
		System.out.println("Executado em: " + (fim - inicio) + "ms");

	}

}
