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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_agendaVisitas")
@NamedQueries({
	@NamedQuery(name = "AgendaVisita.listar", query = "SELECT agendaVisita FROM AgendaVisita agendaVisita"),
	@NamedQuery(name = "AgendaVisita.buscarPorCodigo", query = "SELECT agendaVisita FROM AgendaVisita agendaVisita WHERE codigo = :codigo")
})
public class AgendaVisita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "age_codigo")
	private Long codigo;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "age_data")
	private Date data;
	
	@Column(name = "age_descricao", length = 255)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_usuarios_usu_codigo", referencedColumnName = "usu_codigo")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_investidores_inv_codigo", referencedColumnName = "inv_codigo")
	private Investidor investidor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Investidor getInvestidor() {
		return investidor;
	}

	public void setInvestidor(Investidor investidor) {
		this.investidor = investidor;
	}

	@Override
	public String toString() {
		return "AgendaVisita [codigo=" + codigo + ", data=" + data
				+ ", descricao=" + descricao + ", usuario=" + usuario
				+ ", investidor=" + investidor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((investidor == null) ? 0 : investidor.hashCode());
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
		AgendaVisita other = (AgendaVisita) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (investidor == null) {
			if (other.investidor != null)
				return false;
		} else if (!investidor.equals(other.investidor))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	
	
	
}
