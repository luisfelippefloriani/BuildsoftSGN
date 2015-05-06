package br.com.buildsoft.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.dao.InvestidorDAO;
import br.com.buildsoft.domain.Investidor;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;


@ManagedBean
@ViewScoped
public class InvestidorBean {

	private Investidor investidorCadastro;
	private List<Investidor> listaInvestidores;
	private List<Investidor> listaInvestidoresFiltrados;
	private String acao;
	private Long codigo;

	public void salvar() {
		try {
			InvestidorDAO investidorDAO = new InvestidorDAO();
			investidorDAO.salvar(investidorCadastro);

			investidorCadastro = new Investidor();

			FacesUtil.adcionarMsgInfo("Investidor salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar salvar o investidor!");
			System.out.println(ex);

		}

	}

	/**********************************************************************/

	public void carregarPesquisa() {
		try {
			InvestidorDAO investidorDAO = new InvestidorDAO();
			listaInvestidores = investidorDAO.listar();
	
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar listar os investidores!");
	
		}
	
	}

	/**********************************************************************/

	public void carregarCadastro() {
		try {
	
			String valor = FacesUtil.getParam("invcod");
			
			if (valor != null) {
				
				Long codigo = Long.parseLong(valor);
				
				InvestidorDAO investidorDAO = new InvestidorDAO();
				investidorCadastro = investidorDAO.buscarPorCodigo(codigo);
	
			}
	
			else {
				investidorCadastro = new Investidor();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar obter os dados do investidor!");
					
		}
	}

	/**********************************************************************/

	public void excluir() {
		try {
			InvestidorDAO investidorDAO = new InvestidorDAO();
			investidorDAO.excluir(investidorCadastro);
	
			FacesUtil.adcionarMsgInfo("Investidor excluído com sucesso!");
	
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar excluir o investidor!");
		}
	}

	/**********************************************************************/

	public void editar() {
		try {
			InvestidorDAO investidorDAO = new InvestidorDAO();
			investidorDAO.editar(investidorCadastro);
	
			FacesUtil.adcionarMsgInfo("Investidor  editado com sucesso!");
	
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar editar o investidor");
	
		}
	}
	
	/**********************************************************************/

	public Investidor getInvestidorCadastro() {
		if (investidorCadastro == null) {
			investidorCadastro = new Investidor();

		}
		return investidorCadastro;
	}

	public void setInvestidorCadastro(Investidor investidorCadastro) {
		this.investidorCadastro = investidorCadastro;
	}

	public List<Investidor> getListaInvestidores() {
		return listaInvestidores;
	}

	public void setListaInvestidores(List<Investidor> listaInvestidores) {
		this.listaInvestidores = listaInvestidores;
	}

	public List<Investidor> getListaInvestidoresFiltrados() {
		return listaInvestidoresFiltrados;
	}

	public void setListaInvestidoresFiltrados(
			List<Investidor> listaInvestidoresFiltrados) {
		this.listaInvestidoresFiltrados = listaInvestidoresFiltrados;
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
	
	/**********************************************************************/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((investidorCadastro == null) ? 0 : investidorCadastro
						.hashCode());
		result = prime
				* result
				+ ((listaInvestidores == null) ? 0 : listaInvestidores
						.hashCode());
		result = prime
				* result
				+ ((listaInvestidoresFiltrados == null) ? 0
						: listaInvestidoresFiltrados.hashCode());
		return result;
	}
	
	/**********************************************************************/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvestidorBean other = (InvestidorBean) obj;
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
		if (investidorCadastro == null) {
			if (other.investidorCadastro != null)
				return false;
		} else if (!investidorCadastro.equals(other.investidorCadastro))
			return false;
		if (listaInvestidores == null) {
			if (other.listaInvestidores != null)
				return false;
		} else if (!listaInvestidores.equals(other.listaInvestidores))
			return false;
		if (listaInvestidoresFiltrados == null) {
			if (other.listaInvestidoresFiltrados != null)
				return false;
		} else if (!listaInvestidoresFiltrados
				.equals(other.listaInvestidoresFiltrados))
			return false;
		return true;
	}

	/**********************************************************************/
	
	@Override
	public String toString() {
		return "InvestidorBean [investidorCadastro=" + investidorCadastro
				+ ", listaInvestidores=" + listaInvestidores
				+ ", listaInvestidoresFiltrados=" + listaInvestidoresFiltrados
				+ ", acao=" + acao + ", codigo=" + codigo + "]";
	}
	
	/**********************************************************************/
	
	
	
	
	
	
	
}

	