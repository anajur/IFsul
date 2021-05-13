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
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVendedor;

	@Column(name = "FaixaComissao", columnDefinition = "enum('A','B','C','D')")
	private FaixaComissao faixacomissao;

	@Column(name = "SalarioFixo", columnDefinition = "decimal(10,2)")
	private double salarioFixo;

	@Column(name = "Nome", columnDefinition = "VARCHAR(45)")
	private String nome;

	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private List<Pedido> pedido;

	public Vendedor() {
		super();
	}

	public Vendedor(Integer codVendedor, FaixaComissao faixacomissao, double salarioFixo, String nome,
			List<Pedido> pedido) {
		super();
		this.codVendedor = codVendedor;
		this.faixacomissao = faixacomissao;
		this.salarioFixo = salarioFixo;
		this.nome = nome;
		this.pedido = pedido;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}

	public FaixaComissao getFaixacomissao() {
		return faixacomissao;
	}

	public void setFaixacomissao(FaixaComissao faixacomissao) {
		this.faixacomissao = faixacomissao;
	}

	public double getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
