package loja;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CodCliente")
	private Integer codCliente;

	@Column(name = "Nome", columnDefinition = "VARCHAR(100)")
	private String nome;

	@Column(name = "Endereco", columnDefinition = "VARCHAR(255)")
	private String endereco;

	@Column(name = "Cidade", columnDefinition = "VARCHAR(60)")
	private String cidade;

	@Column(name = "Cep", columnDefinition = "VARCHAR(11)")
	private String cep;

	@Column(name = "Uf", columnDefinition = "CHAR(2)")
	private String uf;

	@Column(name = "Ie", columnDefinition = "VARCHAR(12)")
	private String ie;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Pedido> pedido;

	public Cliente() {
		super();
	}

	public Cliente(Integer codCliente, String nome, String endereco, String cidade, String cep, String uf, String ie,
			List<Pedido> pedido) {
		super();
		this.codCliente = codCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
		this.ie = ie;
		this.pedido = pedido;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

}
