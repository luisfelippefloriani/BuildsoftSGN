package br.com.buildsoft.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.UnidadeDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Unidade;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UnidadeBean {

	private Unidade unidadeCadastro;
	private List<Unidade> listaUnidades;
	private List<Unidade> listaUnidadesFiltrados;
	private List<Empreendimento> listaEmpreendimentos;
	private String acao;
	private Long codigo;
	
	

	/***************************************************************/

	public void salvar() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidadeDAO.salvar(unidadeCadastro);

			unidadeCadastro = new Unidade();

			FacesUtil.adcionarMsgInfo("Unidade salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar salvar a unidade!");
			System.out.println(ex);

		}

	}

	/**********************************************************************/

	public void carregarPesquisa() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			listaUnidades = unidadeDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar listar as unidades!");

		}

	}

	/**********************************************************************/

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				UnidadeDAO unidadeDAO = new UnidadeDAO();
				unidadeCadastro = unidadeDAO.buscarPorCodigo(codigo);

			} else {
				unidadeCadastro = new Unidade();
			}

			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			listaEmpreendimentos = empreendimentoDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil
					.adcionarMsgErro("Erro ao tentar obter os dados da unidade!");

		}
	}

	/**********************************************************************/

	public void excluir() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidadeDAO.excluir(unidadeCadastro);

			FacesUtil.adcionarMsgInfo("Unidade excluída com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar excluir a unidade!");
		}
	}

	/**********************************************************************/

	public void editar() {
		try {
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			unidadeDAO.editar(unidadeCadastro);

			FacesUtil.adcionarMsgInfo("Unidade editada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar editar a unidade!");

		}
	}

	/**********************************************************************/
	public void novo() {
		unidadeCadastro = new Unidade();

	}

	/**********************************************************************/

	public List<Empreendimento> getListaEmpreendimentos() {
		return listaEmpreendimentos;
	}

	public void setListaEmpreendimentos(
			List<Empreendimento> listaEmpreendimentos) {
		this.listaEmpreendimentos = listaEmpreendimentos;
	}

	public Unidade getUnidadeCadastro() {
		if (unidadeCadastro == null) {
			unidadeCadastro = new Unidade();

		}
		return unidadeCadastro;
	}

	public void setUnidadeCadastro(Unidade unidadeCadastro) {
		this.unidadeCadastro = unidadeCadastro;
	}

	public List<Unidade> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<Unidade> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

	public List<Unidade> getListaUnidadesFiltrados() {
		return listaUnidadesFiltrados;
	}

	public void setListaUnidadesFiltrados(List<Unidade> listaUnidadesFiltrados) {
		this.listaUnidadesFiltrados = listaUnidadesFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((listaEmpreendimentos == null) ? 0 : listaEmpreendimentos
						.hashCode());
		result = prime * result
				+ ((listaUnidades == null) ? 0 : listaUnidades.hashCode());
		result = prime
				* result
				+ ((listaUnidadesFiltrados == null) ? 0
						: listaUnidadesFiltrados.hashCode());
		result = prime * result
				+ ((unidadeCadastro == null) ? 0 : unidadeCadastro.hashCode());
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
		UnidadeBean other = (UnidadeBean) obj;
		if (acao == null) {
			if (other.acao != null)
				return false;
		} else if (!acao.equals(other.acao))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (listaEmpreendimentos == null) {
			if (other.listaEmpreendimentos != null)
				return false;
		} else if (!listaEmpreendimentos.equals(other.listaEmpreendimentos))
			return false;
		if (listaUnidades == null) {
			if (other.listaUnidades != null)
				return false;
		} else if (!listaUnidades.equals(other.listaUnidades))
			return false;
		if (listaUnidadesFiltrados == null) {
			if (other.listaUnidadesFiltrados != null)
				return false;
		} else if (!listaUnidadesFiltrados.equals(other.listaUnidadesFiltrados))
			return false;
		if (unidadeCadastro == null) {
			if (other.unidadeCadastro != null)
				return false;
		} else if (!unidadeCadastro.equals(other.unidadeCadastro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UnidadeBean [unidadeCadastro=" + unidadeCadastro
				+ ", listaUnidades=" + listaUnidades
				+ ", listaUnidadesFiltrados=" + listaUnidadesFiltrados
				+ ", acao=" + acao + ", codigo=" + codigo
				+ ", listaEmpreendimentos=" + listaEmpreendimentos + "]";
	}

}
