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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_propostas")
@NamedQueries({
	@NamedQuery(name = "Proposta.listar", query = "SELECT proposta FROM Proposta proposta"),
	@NamedQuery(name = "Proposta.buscarPorCodigo", query = "SELECT proposta FROM Proposta proposta WHERE codigo = :codigo")
})
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long codigo;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "pro_dataApresentacao", nullable = false)
	private Date dataApresentacao;

	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a zero para o campo Valor da Entrada!")
	@DecimalMax(value = "999999999.99", message = "Informe um valor menor que 99.999.999.99 para o campo Valor da Entrada!")
	@Column(name = "pro_valorEntrada", precision = 9, scale = 2)
	private BigDecimal valorEntrada;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "pro_dataEntrada")
	private Date dataEntrada;

	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a zero para o campo Valor das Chaves!")
	@DecimalMax(value = "99999999.99", message = "Informe um valor menor que 99.999.999.99 para o campo Valor das Chaves!")
	@Column(name = "pro_valorChaves", precision = 9, scale = 2)
	private BigDecimal valorChaves;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "pro_dataChaves")
	private Date dataChaves;

	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a zero para o campo Valor dos Reforços!")
	@DecimalMax(value = "99999999.99", message = "Informe um valor menor que 99.999.999.99 para o campo Valor dos Reforços!")
	@Column(name = "pro_valorReforco", precision = 9, scale = 2)
	private BigDecimal valorReforco;

	@Min(value = 0, message = "Informe um valor maior ou igual a zero para o campo Número de Reforços!")
	@Max(value = 999, message = "Informe um valor menor que 999 para o campo Número de Reforços!")
	@Column(name = "pro_numeroReforco")
	private Integer numeroReforco;

	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a zero para o campo Valor da Parcela!")
	@DecimalMax(value = "99999999.99", message = "Informe um valor menor que 999 para o campo Valor da Parcela!")
	@Column(name = "pro_valorParcela", precision = 9, scale = 2)
	private BigDecimal valorParcela;

	@Min(value = 0, message = "Informe um valor maior ou igual a zero para o campo Número de Parcelas!")
	@Max(value = 9999, message = "Informe um valor menor que 999 para o campo Número de Parcelas")
	@Column(name = "pro_numeroParcela")
	private Integer numeroParcela;
	
	@DecimalMin(value = "0.00", message = "Informe um valor maior ou igual a zero para o campo Valor da Parcela!")
	@DecimalMax(value = "99999999.99", message = "Informe um valor menor que 999 para o campo Valor da Parcela!")
	@Column(name = "pro_valorFinal", precision = 9, scale = 2)
	private BigDecimal valorFinal;
	
	@Size(min = 1, max = 6, message = "Tamanho inválido para o campo nome. Mínimo 1, máximo 6 caracteres!")
	@Column(name = "pro_unidade")
	private String unidade;
	
	@Size(min = 3, max = 30, message = "Tamanho inválido para o campo nome. Mínimo 3, máximo 30 caracteres!")
	@Column(name = "pro_empreendimento")
	private String empreendimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_usuario_usu_codigo", referencedColumnName = "usu_codigo")
	private Usuario usuario;

	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome. Mínimo 5, máximo 50 caracteres!")
	@Column(name = "pro_investidor", length = 50)
	private String investidor;

	/***********************************************************************/
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataApresentacao() {
		return dataApresentacao;
	}

	public void setDataApresentacao(Date dataApresentacao) {
		this.dataApresentacao = dataApresentacao;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public BigDecimal getValorChaves() {
		return valorChaves;
	}

	public void setValorChaves(BigDecimal valorChaves) {
		this.valorChaves = valorChaves;
	}

	public Date getDataChaves() {
		return dataChaves;
	}

	public void setDataChaves(Date dataChaves) {
		this.dataChaves = dataChaves;
	}

	public BigDecimal getValorReforco() {
		return valorReforco;
	}

	public void setValorReforco(BigDecimal valorReforco) {
		this.valorReforco = valorReforco;
	}

	public Integer getNumeroReforco() {
		return numeroReforco;
	}

	public void setNumeroReforco(Integer numeroReforco) {
		this.numeroReforco = numeroReforco;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(String empreendimento) {
		this.empreendimento = empreendimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getInvestidor() {
		return investidor;
	}

	public void setInvestidor(String investidor) {
		this.investidor = investidor;
	}
	
	/***********************************************************************/

	@Override
	public String toString() {
		return "Proposta [codigo=" + codigo + ", dataApresentacao="
				+ dataApresentacao + ", valorEntrada=" + valorEntrada
				+ ", dataEntrada=" + dataEntrada + ", valorChaves="
				+ valorChaves + ", dataChaves=" + dataChaves
				+ ", valorReforco=" + valorReforco + ", numeroReforco="
				+ numeroReforco + ", valorParcela=" + valorParcela
				+ ", numeroParcela=" + numeroParcela + ", valorFinal="
				+ valorFinal + ", unidade=" + unidade + ", empreendimento="
				+ empreendimento + ", usuario=" + usuario + ", investidor="
				+ investidor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((dataApresentacao == null) ? 0 : dataApresentacao.hashCode());
		result = prime * result
				+ ((dataChaves == null) ? 0 : dataChaves.hashCode());
		result = prime * result
				+ ((dataEntrada == null) ? 0 : dataEntrada.hashCode());
		result = prime * result
				+ ((empreendimento == null) ? 0 : empreendimento.hashCode());
		result = prime * result
				+ ((investidor == null) ? 0 : investidor.hashCode());
		result = prime * result
				+ ((numeroParcela == null) ? 0 : numeroParcela.hashCode());
		result = prime * result
				+ ((numeroReforco == null) ? 0 : numeroReforco.hashCode());
		result = prime * result + ((unidade == null) ? 0 : unidade.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result
				+ ((valorChaves == null) ? 0 : valorChaves.hashCode());
		result = prime * result
				+ ((valorEntrada == null) ? 0 : valorEntrada.hashCode());
		result = prime * result
				+ ((valorFinal == null) ? 0 : valorFinal.hashCode());
		result = prime * result
				+ ((valorParcela == null) ? 0 : valorParcela.hashCode());
		result = prime * result
				+ ((valorReforco == null) ? 0 : valorReforco.hashCode());
		return result;
	}
	
	/***********************************************************************/
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proposta other = (Proposta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataApresentacao == null) {
			if (other.dataApresentacao != null)
				return false;
		} else if (!dataApresentacao.equals(other.dataApresentacao))
			return false;
		if (dataChaves == null) {
			if (other.dataChaves != null)
				return false;
		} else if (!dataChaves.equals(other.dataChaves))
			return false;
		if (dataEntrada == null) {
			if (other.dataEntrada != null)
				return false;
		} else if (!dataEntrada.equals(other.dataEntrada))
			return false;
		if (empreendimento == null) {
			if (other.empreendimento != null)
				return false;
		} else if (!empreendimento.equals(other.empreendimento))
			return false;
		if (investidor == null) {
			if (other.investidor != null)
				return false;
		} else if (!investidor.equals(other.investidor))
			return false;
		if (numeroParcela == null) {
			if (other.numeroParcela != null)
				return false;
		} else if (!numeroParcela.equals(other.numeroParcela))
			return false;
		if (numeroReforco == null) {
			if (other.numeroReforco != null)
				return false;
		} else if (!numeroReforco.equals(other.numeroReforco))
			return false;
		if (unidade == null) {
			if (other.unidade != null)
				return false;
		} else if (!unidade.equals(other.unidade))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (valorChaves == null) {
			if (other.valorChaves != null)
				return false;
		} else if (!valorChaves.equals(other.valorChaves))
			return false;
		if (valorEntrada == null) {
			if (other.valorEntrada != null)
				return false;
		} else if (!valorEntrada.equals(other.valorEntrada))
			return false;
		if (valorFinal == null) {
			if (other.valorFinal != null)
				return false;
		} else if (!valorFinal.equals(other.valorFinal))
			return false;
		if (valorParcela == null) {
			if (other.valorParcela != null)
				return false;
		} else if (!valorParcela.equals(other.valorParcela))
			return false;
		if (valorReforco == null) {
			if (other.valorReforco != null)
				return false;
		} else if (!valorReforco.equals(other.valorReforco))
			return false;
		return true;
	}

	/***********************************************************************/
	
	
}
