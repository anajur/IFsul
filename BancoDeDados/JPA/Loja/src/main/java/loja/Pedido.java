package loja;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;

	private Date prazoEntrega;

	private Date dataPedido;

	@JoinColumn(name = "codCliente")
	@ManyToOne
	private Cliente cliente;

	@JoinColumn(name = "codVendedor")
	@ManyToOne
	private Vendedor vendedor;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<ItemPedido> itempedido;

	public Pedido() {
		super();
	}

	public Pedido(Integer codPedido, Date prazoEntrega, Date dataPedido, Cliente cliente, Vendedor vendedor,
			List<ItemPedido> itempedido) {
		super();
		this.codPedido = codPedido;
		this.prazoEntrega = prazoEntrega;
		this.dataPedido = dataPedido;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itempedido = itempedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Date prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<ItemPedido> getItempedido() {
		return itempedido;
	}

	public void setItempedido(List<ItemPedido> itempedido) {
		this.itempedido = itempedido;
	}

}
