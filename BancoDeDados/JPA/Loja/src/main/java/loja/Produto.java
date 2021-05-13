package loja;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	@Column(name = "Descricao", columnDefinition = "VARCHAR(100)")
	private String descricao;
	
	@Column(name = "ValorUnitario", columnDefinition = "decimal(10,2)")
	private Double valorUnitario;

	@OneToMany(mappedBy = "produto", fetch = FetchType.LAZY)
	private List<ItemPedido> itempedido;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer codProduto, String descricao, Double valorUnitario, List<ItemPedido> itempedido) {
		super();
		this.codProduto = codProduto;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.itempedido = itempedido;
	}


	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public List<ItemPedido> getItempedido() {
		return itempedido;
	}

	public void setItempedido(List<ItemPedido> itempedido) {
		this.itempedido = itempedido;
	}
	
	
}
