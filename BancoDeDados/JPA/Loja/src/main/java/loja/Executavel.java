package loja;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import loja.repository.PedidoRepository;

public class Executavel {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("compubras");

		EntityManager em = emf.createEntityManager();

		
		PedidoRepository pedido = new PedidoRepository();
		pedido.listaVendedorPorSalario(1000.00);
		pedido.listaClientePedido();
		pedido.listaVendedorPedido();
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
