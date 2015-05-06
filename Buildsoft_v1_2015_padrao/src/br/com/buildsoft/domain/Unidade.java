package br.com.buildsoft.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_unidades")
@NamedQueries({
	@NamedQuery(name = "Unidade.listar", query = "SELECT unidade FROM Unidade unidade"),
	@NamedQuery(name = "Unidade.buscarPorCodigo", query = "SELECT unidade FROM Unidade unidade WHERE codigo = :codigo")
})
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uni_codigo")
	private Long codigo;

	@NotEmpty(message = "O campo número da unidade é obrigatório!")
	@Size(min = 2, max = 10, message = "Tamanho inválido para o campo nome. Mínimo 2, máximo 10 caracteres!")
	@Column(name = "uni_numero", length = 50, nullable = false)
	private String numeroUnidade;

	@Column(name = "uni_descricao", length = 500)
	private String descricao;

	@Column(name = "uni_matricula", length = 30)
	private String matricula;

	@Column(name = "uni_cartorio", length = 50)
	private String cartorio;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "uni_dataEntrega")
	private Date dataEntrega;

	@Column(name = "uni_status", length = 30)
	private String status;
	
	@NotNull(message = "O campo Valor é obrigatório!")
	//@DecimalMin(value = "9999999.99", message="Informe um valor menor que 9.999.999.99 para o campo preço!")
	//@DecimalMax(value = "0.00" , message="Informe um valor maior ou igual a zero para o campo preço!")
	//@Digits(integer=7, fraction=2, message="Informe um valor válido para o campo preço!")
	@Column(name = "uni_valor", precision = 9, scale = 2, nullable = false)
	private BigDecimal valor;
	

	// CHAVE-RELACIONAMENTO (muitos empreendimentos possuem muitas unidades)
	@NotNull(message = "Um empreendimento deve ser selecionado!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_empreendimentos_emp_codigo", referencedColumnName = "emp_codigo")
	private Empreendimento empreendimento;


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNumeroUnidade() {
		return numeroUnidade;
	}


	public void setNumeroUnidade(String numeroUnidade) {
		this.numeroUnidade = numeroUnidade;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getCartorio() {
		return cartorio;
	}


	public void setCartorio(String cartorio) {
		this.cartorio = cartorio;
	}


	public Date getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public Empreendimento getEmpreendimento() {
		return empreendimento;
	}


	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}


	@Override
	public String toString() {
		return "Unidade [codigo=" + codigo + ", numeroUnidade=" + numeroUnidade
				+ ", descricao=" + descricao + ", matricula=" + matricula
				+ ", cartorio=" + cartorio + ", dataEntrega=" + dataEntrega
				+ ", status=" + status + ", valor=" + valor
				+ ", empreendimento=" + empreendimento + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cartorio == null) ? 0 : cartorio.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((dataEntrega == null) ? 0 : dataEntrega.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((empreendimento == null) ? 0 : empreendimento.hashCode());
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result
				+ ((numeroUnidade == null) ? 0 : numeroUnidade.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Unidade other = (Unidade) obj;
		if (cartorio == null) {
			if (other.cartorio != null)
				return false;
		} else if (!cartorio.equals(other.cartorio))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataEntrega == null) {
			if (other.dataEntrega != null)
				return false;
		} else if (!dataEntrega.equals(other.dataEntrega))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (empreendimento == null) {
			if (other.empreendimento != null)
				return false;
		} else if (!empreendimento.equals(other.empreendimento))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (numeroUnidade == null) {
			if (other.numeroUnidade != null)
				return false;
		} else if (!numeroUnidade.equals(other.numeroUnidade))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	
	
	
	
}
