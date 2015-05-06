package br.com.buildsoft.domain;

import java.util.Date;

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
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "tbl_investidores")
@NamedQueries({
	@NamedQuery(name = "Investidor.listar", query = "SELECT investidor FROM Investidor investidor"),
	@NamedQuery(name = "Investidor.buscarPorCodigo", query = "SELECT investidor FROM Investidor investidor WHERE codigo = :codigo")
})
public class Investidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_codigo")
	private Long codigo;
	
	@NotEmpty(message = "O campo nome é obrigatório!")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome. Mínimo 5, máximo 50 caracteres!")
	@Column(name = "inv_nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "inv_rg", length = 14, unique = true)
	private String rg;
	
	@CPF(message = "O CPF informado é inválido ou já foi registrado!")
	@Column(name = "inv_cpf", length = 14, unique = true)
	private String cpf;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "inv_dataNascimento")
	private Date dataNascimento;
	
	@Column(name = "inv_cnpj", length = 20)
	private String cnpj;
	
	@Column(name = "inv_ie", length = 20)
	private String ie;
	
	@NotEmpty(message = "O campo tipo de pessoa é obrigatório!")
	@Column(name = "inv_tipoPessoa", length = 20, nullable = false)
	private String tipoPessoa;
	
	@NotEmpty(message = "O campo ramo profissional é obrigatório!")
	@Column(name = "inv_ramoProfissional", length = 20, nullable = false)
	private String ramoProfissional;
	
	@Column(name = "inv_telefoneResidencial", length = 20)
	private String telefoneResidencial;
	
	@NotEmpty(message = "O campo celular é obrigatório!")
	@Column(name = "inv_telefoneCelular", length = 15, nullable = false)
	private String telefoneCelular;
	
	@NotEmpty(message = "O campo email é obrigatório!")
	@Column(name = "inv_email", length = 70, nullable = false)
	private String email;
	
	@Column(name = "inv_enderecoLogradouro", length = 70)
	private String enderecoLogradouro;
	
	@Column(name = "inv_enderecoNumero", length = 10)
	private String enderecoNumero;
	
	@Column(name = "inv_enderecoComplemento", length = 15)
	private String enderecoComplemento;
	
	@Column(name = "inv_enderecoBairro", length = 20)
	private String enderecoBairro;
	
	@Column(name = "inv_enderecoCidade", length = 25)
	private String enderecoCidade;
	
	@Column(name = "inv_enderecoEstado", length = 2)
	private String enderecoEstado;
	
	@Column(name = "inv_enderecoPais", length = 15)
	private String enderecoPais;
	
	@Column(name = "inv_enderecoCep", length = 11)
	private String enderecoCep;
	
	@Column(name = "inv_EstadoCivil", length = 15)
	private String estadoCivil;
	
	//CHAVE-RELACIONAMENTO (muitos investidores são registrados por um usuário)	
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getRamoProfissional() {
		return ramoProfissional;
	}

	public void setRamoProfissional(String ramoProfissional) {
		this.ramoProfissional = ramoProfissional;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
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

	public String getEnderecoPais() {
		return enderecoPais;
	}

	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Investidor [codigo=" + codigo + ", nome=" + nome + ", rg=" + rg
				+ ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", cnpj=" + cnpj + ", ie=" + ie + ", tipoPessoa="
				+ tipoPessoa + ", ramoProfissional=" + ramoProfissional
				+ ", telefoneResidencial=" + telefoneResidencial
				+ ", telefoneCelular=" + telefoneCelular + ", email=" + email
				+ ", enderecoLogradouro=" + enderecoLogradouro
				+ ", enderecoNumero=" + enderecoNumero
				+ ", enderecoComplemento=" + enderecoComplemento
				+ ", enderecoBairro=" + enderecoBairro + ", enderecoCidade="
				+ enderecoCidade + ", enderecoEstado=" + enderecoEstado
				+ ", enderecoPais=" + enderecoPais + ", enderecoCep="
				+ enderecoCep + ", estadoCivil=" + estadoCivil + ", usuario="
				+ usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((enderecoBairro == null) ? 0 : enderecoBairro.hashCode());
		result = prime * result
				+ ((enderecoCep == null) ? 0 : enderecoCep.hashCode());
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
		result = prime * result
				+ ((enderecoPais == null) ? 0 : enderecoPais.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result + ((ie == null) ? 0 : ie.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((ramoProfissional == null) ? 0 : ramoProfissional.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result
				+ ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
		result = prime
				* result
				+ ((telefoneResidencial == null) ? 0 : telefoneResidencial
						.hashCode());
		result = prime * result
				+ ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
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
		Investidor other = (Investidor) obj;
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
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
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
		if (enderecoCep == null) {
			if (other.enderecoCep != null)
				return false;
		} else if (!enderecoCep.equals(other.enderecoCep))
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
		if (enderecoPais == null) {
			if (other.enderecoPais != null)
				return false;
		} else if (!enderecoPais.equals(other.enderecoPais))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (ie == null) {
			if (other.ie != null)
				return false;
		} else if (!ie.equals(other.ie))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ramoProfissional == null) {
			if (other.ramoProfissional != null)
				return false;
		} else if (!ramoProfissional.equals(other.ramoProfissional))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null)
				return false;
		} else if (!telefoneCelular.equals(other.telefoneCelular))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		if (tipoPessoa == null) {
			if (other.tipoPessoa != null)
				return false;
		} else if (!tipoPessoa.equals(other.tipoPessoa))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	

}
