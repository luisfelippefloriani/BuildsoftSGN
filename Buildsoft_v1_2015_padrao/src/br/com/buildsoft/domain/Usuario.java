package br.com.buildsoft.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
	 @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
	 @NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.codigo = :codigo"),
	 @NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.cpf = :cpf AND usuario.senha = :senha")
	})
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usu_codigo")
	private Long codigo;

	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome. Mínimo 5, máximo 50 caracteres!")
	@Column(name = "usu_nome", length = 50, nullable = false)
	private String nome;

	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo senha. Mínimo 6, máximo 10 caracteres!")
	@Column(name = "usu_senha", length = 32, nullable = false)
	private String senha;

	@CPF(message = "O CPF informado é inválido ou já foi registrado!")
	@Column(name = "usu_cpf", length = 14, nullable = false, unique = true)
	private String cpf;

	@Column(name = "usu_rg", length = 14)
	private String rg;

	@Column(name = "usu_creci", length = 14)
	private String creci;

	@Column(name = "usu_cnpj", length = 20)
	private String cnpj;

	@Column(name = "usu_email", length = 70)
	private String email;

	@Column(name = "usu_enderecoLogradouro", length = 70, nullable = false)
	private String enderecoLogradouro;

	@Column(name = "usu_enderecoNumero", length = 10)
	private String enderecoNumero;

	@Column(name = "usu_enderecoComplemento", length = 20)
	private String enderecoComplemento;

	@Column(name = "usu_enderecoBairro", length = 30, nullable = false)
	private String enderecoBairro;

	
	@Column(name = "usu_enderecoCidade", length = 30, nullable = false)
	private String enderecoCidade;

	@Column(name = "usu_enderecoEstado", length = 2, nullable = false)
	private String enderecoEstado;

	@Column(name = "usu_telefoneResCom", length = 15)
	private String telefoneResCom;

	@Column(name = "usu_telefoneCel", length = 15, nullable = false)
	private String telefoneCel;

	@Column(name = "usu_tipo", length = 15)
	private String tipo;

	/*****************************************************/
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCreci() {
		return creci;
	}

	public void setCreci(String creci) {
		this.creci = creci;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
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

	public String getTelefoneResCom() {
		return telefoneResCom;
	}

	public void setTelefoneResCom(String telefoneResCom) {
		this.telefoneResCom = telefoneResCom;
	}

	public String getTelefoneCel() {
		return telefoneCel;
	}

	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/*******************************************************/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((creci == null) ? 0 : creci.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((enderecoBairro == null) ? 0 : enderecoBairro.hashCode());
		result = prime * result
				+ ((enderecoCidade == null) ? 0 : enderecoCidade.hashCode());
		result = prime
				* result
				+ ((enderecoComplemento == null) ? 0 : enderecoComplemento
						.hashCode());
		result = prime * result
				+ ((enderecoEstado == null) ? 0 : enderecoEstado.hashCode());
		result = prime
				* result
				+ ((enderecoLogradouro == null) ? 0 : enderecoLogradouro
						.hashCode());
		result = prime * result
				+ ((enderecoNumero == null) ? 0 : enderecoNumero.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result
				+ ((telefoneCel == null) ? 0 : telefoneCel.hashCode());
		result = prime * result
				+ ((telefoneResCom == null) ? 0 : telefoneResCom.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	/*******************************************************/
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (creci == null) {
			if (other.creci != null)
				return false;
		} else if (!creci.equals(other.creci))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (enderecoComplemento == null) {
			if (other.enderecoComplemento != null)
				return false;
		} else if (!enderecoComplemento.equals(other.enderecoComplemento))
			return false;
		if (enderecoEstado == null) {
			if (other.enderecoEstado != null)
				return false;
		} else if (!enderecoEstado.equals(other.enderecoEstado))
			return false;
		if (enderecoLogradouro == null) {
			if (other.enderecoLogradouro != null)
				return false;
		} else if (!enderecoLogradouro.equals(other.enderecoLogradouro))
			return false;
		if (enderecoNumero == null) {
			if (other.enderecoNumero != null)
				return false;
		} else if (!enderecoNumero.equals(other.enderecoNumero))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefoneCel == null) {
			if (other.telefoneCel != null)
				return false;
		} else if (!telefoneCel.equals(other.telefoneCel))
			return false;
		if (telefoneResCom == null) {
			if (other.telefoneResCom != null)
				return false;
		} else if (!telefoneResCom.equals(other.telefoneResCom))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	/*******************************************************/
	
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", senha="
				+ senha + ", cpf=" + cpf + ", rg=" + rg + ", creci=" + creci
				+ ", cnpj=" + cnpj + ", email=" + email
				+ ", enderecoLogradouro=" + enderecoLogradouro
				+ ", enderecoNumero=" + enderecoNumero
				+ ", enderecoComplemento=" + enderecoComplemento
				+ ", enderecoBairro=" + enderecoBairro + ", enderecoCidade="
				+ enderecoCidade + ", enderecoEstado=" + enderecoEstado
				+ ", telefoneResCom=" + telefoneResCom + ", telefoneCel="
				+ telefoneCel + ", tipo=" + tipo + "]";
	}

	/*******************************************************/
	
	



}
