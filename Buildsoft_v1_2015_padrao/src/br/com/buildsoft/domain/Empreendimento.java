package br.com.buildsoft.domain;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_empreendimentos")
@NamedQueries({
	@NamedQuery(name = "Empreendimento.listar", query = "SELECT empreendimento FROM Empreendimento empreendimento"),
	@NamedQuery(name = "Empreendimento.buscarPorCodigo", query = "SELECT empreendimento FROM Empreendimento empreendimento WHERE codigo = :codigo")
})

public class Empreendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório!")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome. Mínimo 5, máximo 50 caracteres!")
	@Column(name = "emp_nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "emp_descricao", length = 255)
	private String descricao;

	@NotEmpty(message = "O campo logradouro do endereço é obrigatório!")
	@Column(name = "emp_enderecoLogradouro", length = 70, nullable = false)
	private String enderecologradouro;

	@NotEmpty(message = "O campo número do endereço é obrigatório!")
	@Column(name = "emp_enderecoNumero", length = 10, nullable = false)
	private String enderecoNumero;

	@NotEmpty(message = "O campo bairro do endereço é obrigatório!")
	@Column(name = "emp_enderecoBairro", length = 30, nullable = false)	
	private String enderecoBairro;

	@NotEmpty(message = "O campo cidade do endereço é obrigatório!")
	@Column(name = "emp_enderecoCidade", length = 30, nullable = false)
	private String enderecoCidade;

	@NotEmpty(message = "O campo estado do endereço é obrigatório!")
	@Column(name = "emp_enderecoEstado", length = 30, nullable = false)
	private String enderecoEstado;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "emp_dataInicioObra")
	private Date dataInicioObra;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "emp_dataConclusao")
	private Date dataConclusaoObra;

	//CHAVE-RELACIONAMENTO (muitos empreendimentos são registrados por um usuário)	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_usuarios_usu_codigo", referencedColumnName = "usu_codigo")
	private Usuario usuario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEnderecologradouro() {
		return enderecologradouro;
	}

	public void setEnderecologradouro(String enderecologradouro) {
		this.enderecologradouro = enderecologradouro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public String getEnderecoCidade() {
		return enderecoCidade;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public String getEnderecoEstado() {
		return enderecoEstado;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public Date getDataInicioObra() {
		return dataInicioObra;
	}

	public void setDataInicioObra(Date dataInicioObra) {
		this.dataInicioObra = dataInicioObra;
	}

	public Date getDataConclusaoObra() {
		return dataConclusaoObra;
	}

	public void setDataConclusaoObra(Date dataConclusaoObra) {
		this.dataConclusaoObra = dataConclusaoObra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((dataConclusaoObra == null) ? 0 : dataConclusaoObra
						.hashCode());
		result = prime * result
				+ ((dataInicioObra == null) ? 0 : dataInicioObra.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((enderecoBairro == null) ? 0 : enderecoBairro.hashCode());
		result = prime * result
				+ ((enderecoCidade == null) ? 0 : enderecoCidade.hashCode());
		result = prime * result
				+ ((enderecoEstado == null) ? 0 : enderecoEstado.hashCode());
		result = prime * result
				+ ((enderecoNumero == null) ? 0 : enderecoNumero.hashCode());
		result = prime
				* result
				+ ((enderecologradouro == null) ? 0 : enderecologradouro
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empreendimento other = (Empreendimento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataConclusaoObra == null) {
			if (other.dataConclusaoObra != null)
				return false;
		} else if (!dataConclusaoObra.equals(other.dataConclusaoObra))
			return false;
		if (dataInicioObra == null) {
			if (other.dataInicioObra != null)
				return false;
		} else if (!dataInicioObra.equals(other.dataInicioObra))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (enderecoBairro == null) {
			if (other.enderecoBairro != null)
				return false;
		} else if (!enderecoBairro.equals(other.enderecoBairro))
			return false;
		if (enderecoCidade == null) {
			if (other.enderecoCidade != null)
				return false;
		} else if (!enderecoCidade.equals(other.enderecoCidade))
			return false;
		if (enderecoEstado == null) {
			if (other.enderecoEstado != null)
				return false;
		} else if (!enderecoEstado.equals(other.enderecoEstado))
			return false;
		if (enderecoNumero == null) {
			if (other.enderecoNumero != null)
				return false;
		} else if (!enderecoNumero.equals(other.enderecoNumero))
			return false;
		if (enderecologradouro == null) {
			if (other.enderecologradouro != null)
				return false;
		} else if (!enderecologradouro.equals(other.enderecologradouro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empreendimento [codigo=" + codigo + ", nome=" + nome
				+ ", descricao=" + descricao + ", enderecologradouro="
				+ enderecologradouro + ", enderecoNumero=" + enderecoNumero
				+ ", enderecoBairro=" + enderecoBairro + ", enderecoCidade="
				+ enderecoCidade + ", enderecoEstado=" + enderecoEstado
				+ ", dataInicioObra=" + dataInicioObra + ", dataConclusaoObra="
				+ dataConclusaoObra + ", usuario=" + usuario + "]";
	}

	
	

}
