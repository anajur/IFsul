package loja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodItemPedido")
	private Integer codItemPedido;

	private int quantidade;

	@JoinColumn(name = "codpedido")
	@ManyToOne
	private Pedido pedido;

	@JoinColumn(name = "codproduto")
	@ManyToOne
	private Produto produto;

	public ItemPedido() {
		super();
	}

	public ItemPedido(Integer codItemPedido, int quantidade, Pedido pedido, Produto produto) {
		super();
		this.codItemPedido = codItemPedido;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getCodItemPedido() {
		return codItemPedido;
	}

	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
