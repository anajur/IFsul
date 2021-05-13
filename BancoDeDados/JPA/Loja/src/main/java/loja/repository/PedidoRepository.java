package loja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PedidoRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("compubras");

	EntityManager em = emf.createEntityManager();

	// EXERCÍCIO 4
	public void listaClientePedido() {
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT c.nome, c.codCliente, p.codPedido FROM Pedido p INNER JOIN p.cliente c ORDER BY p.codPedido",
				Object[].class);

		List<Object[]> results = query.getResultList();

		int count = 0;
		for (Object[] result : results) {
			if (count <= 10) {
				System.out.println(
						"Cliente: " + result[0] + ", Código Cliente: " + result[1] + ", Código Pedido: " + result[2]);
				count++;
			}
		}
	}

	public void listaVendedorPorSalario(double salario) {
		// EXERCÍCIO 7
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT v.nome, v.codVendedor FROM Pedido p INNER JOIN p.vendedor v WHERE (p.prazoEntrega - p.dataPedido) > 15"
						+ " AND v.salarioFixo >= :salario " + " GROUP BY v.codVendedor ORDER BY v.nome ASC  ",
				Object[].class);

		query.setParameter("salario", salario);
		List<Object[]> results = query.getResultList();
		int count7 = 0;
		for (Object[] result : results) {
			if (count7 <= 10) {
				System.out.println("Vendedor: " + result[0] + ", Código Vendedor: " + result[1]);
				count7++;
			}
		}

	}

	public void listaVendedorPedido() {
		// EXERCICIO 6
		TypedQuery<Object[]> query6 = em.createQuery(
				"SELECT	c.nome, c.codCliente, p.prazoEntrega FROM Pedido p INNER JOIN p.cliente c ORDER BY p.prazoEntrega DESC",
				Object[].class);

		List<Object[]> results6 = query6.getResultList();
		int count6 = 0;
		for (Object[] result : results6) {
			if (count6 <= 10) {
				System.out.println("Vendedor: " + result[0] + ", Código Cliente: " + result[1] + ", Prazo de Entrega: "
						+ result[2]);
				count6++;
			}
		}

	}
}
