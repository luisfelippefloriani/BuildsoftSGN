package br.com.buildsoft.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.PropostaDAO;
import br.com.buildsoft.dao.UnidadeDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Proposta;
import br.com.buildsoft.domain.Unidade;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;




@ManagedBean
@ViewScoped
public class PropostaBean {
	
	private Proposta propostaCadastro;
	private List<Proposta> listaPropostas; 
	private List<Proposta> listaPropostasFiltradas;
	private List<Usuario> listaUsuarios;
	private List<Empreendimento> listaEmpreendimentos;
	private List<Unidade> listaUnidades;
	private List<Unidade> listaUnidadesFiltradas;
	
	private String acao;
	private Long codigo;
	
	
	
	/***************************************************************/
	
	public void salvar() {
		try {
			PropostaDAO propostaDAO = new PropostaDAO();
			propostaDAO.salvar(propostaCadastro);

			propostaCadastro = new Proposta();
			propostaCadastro.setValorFinal(new BigDecimal("0.00"));

			FacesUtil.adcionarMsgInfo("Proposta salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar salvar a proposta!");
			System.out.println(ex);

		}

	}
	
	/***************************************************************/
	
	public void carregarPesquisa() {
		try {
			PropostaDAO propostaDAO = new PropostaDAO();
			listaPropostas = propostaDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar listar as propostas!");

		}

	}
	
	
	/***************************************************************/
	

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				PropostaDAO propostaDAO = new PropostaDAO();
				propostaCadastro = propostaDAO.buscarPorCodigo(codigo);

			} else {
				propostaCadastro = new Proposta();
			}

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar();

			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			listaEmpreendimentos = empreendimentoDAO.listar();
			
			UnidadeDAO unidadeDAO = new UnidadeDAO();
			listaUnidades= unidadeDAO.listar();
			
			
		} catch (RuntimeException ex) {
			FacesUtil
					.adcionarMsgErro("Erro ao tentar obter os dados da proposta!");

		}
	}
	
	/***************************************************************/
	
	public void excluir() {
		try {
			PropostaDAO propostaDAO = new PropostaDAO();
			propostaDAO.excluir(propostaCadastro);

			FacesUtil.adcionarMsgInfo("Proposta excluída com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar excluir a proposta!");
		}
	}
	
	
	/***************************************************************/
	
	public void editar() {
		try {
			PropostaDAO propostaDAO = new PropostaDAO();
			propostaDAO.editar(propostaCadastro);

			FacesUtil.adcionarMsgInfo("Proposta editada com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar editar a proposta!");

		}
	}
	
	/***************************************************************/
	
	public void novo() {
		propostaCadastro = new Proposta();

	}

	/***************************************************************/
	
	public void carregarDadosProposta(){
		propostaCadastro.setDataApresentacao(new Date());
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);
		propostaCadastro.setUsuario(usuario);
		
	}
	
	
	/***************************************************************/

	public Proposta getPropostaCadastro() {
		if(propostaCadastro == null){
			propostaCadastro = new Proposta();
			propostaCadastro.setValorFinal(new BigDecimal("0.00"));
		}
		
		return propostaCadastro;
	}

	public void setPropostaCadastro(Proposta propostaCadastro) {
		this.propostaCadastro = propostaCadastro;
	}

	public List<Proposta> getListaPropostas() {
		return listaPropostas;
	}

	public void setListaPropostas(List<Proposta> listaPropostas) {
		this.listaPropostas = listaPropostas;
	}

	public List<Proposta> getListaPropostasFiltradas() {
		return listaPropostasFiltradas;
	}

	public void setListaPropostasFiltradas(List<Proposta> listaPropostasFiltradas) {
		this.listaPropostasFiltradas = listaPropostasFiltradas;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Empreendimento> getListaEmpreendimentos() {
		return listaEmpreendimentos;
	}

	public void setListaEmpreendimentos(List<Empreendimento> listaEmpreendimentos) {
		this.listaEmpreendimentos = listaEmpreendimentos;
	}

	public List<Unidade> getListaUnidades() {
		return listaUnidades;
	}

	public void setListaUnidades(List<Unidade> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

	public List<Unidade> getListaUnidadesFiltradas() {
		return listaUnidadesFiltradas;
	}

	public void setListaUnidadesFiltradas(List<Unidade> listaUnidadesFiltradas) {
		this.listaUnidadesFiltradas = listaUnidadesFiltradas;
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
				+ ((listaPropostas == null) ? 0 : listaPropostas.hashCode());
		result = prime
				* result
				+ ((listaPropostasFiltradas == null) ? 0
						: listaPropostasFiltradas.hashCode());
		result = prime * result
				+ ((listaUnidades == null) ? 0 : listaUnidades.hashCode());
		result = prime
				* result
				+ ((listaUnidadesFiltradas == null) ? 0
						: listaUnidadesFiltradas.hashCode());
		result = prime * result
				+ ((listaUsuarios == null) ? 0 : listaUsuarios.hashCode());
		result = prime
				* result
				+ ((propostaCadastro == null) ? 0 : propostaCadastro.hashCode());
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
		PropostaBean other = (PropostaBean) obj;
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
		if (listaPropostas == null) {
			if (other.listaPropostas != null)
				return false;
		} else if (!listaPropostas.equals(other.listaPropostas))
			return false;
		if (listaPropostasFiltradas == null) {
			if (other.listaPropostasFiltradas != null)
				return false;
		} else if (!listaPropostasFiltradas
				.equals(other.listaPropostasFiltradas))
			return false;
		if (listaUnidades == null) {
			if (other.listaUnidades != null)
				return false;
		} else if (!listaUnidades.equals(other.listaUnidades))
			return false;
		if (listaUnidadesFiltradas == null) {
			if (other.listaUnidadesFiltradas != null)
				return false;
		} else if (!listaUnidadesFiltradas.equals(other.listaUnidadesFiltradas))
			return false;
		if (listaUsuarios == null) {
			if (other.listaUsuarios != null)
				return false;
		} else if (!listaUsuarios.equals(other.listaUsuarios))
			return false;
		if (propostaCadastro == null) {
			if (other.propostaCadastro != null)
				return false;
		} else if (!propostaCadastro.equals(other.propostaCadastro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PropostaBean [propostaCadastro=" + propostaCadastro
				+ ", listaPropostas=" + listaPropostas
				+ ", listaPropostasFiltradas=" + listaPropostasFiltradas
				+ ", listaUsuarios=" + listaUsuarios
				+ ", listaEmpreendimentos=" + listaEmpreendimentos
				+ ", listaUnidades=" + listaUnidades
				+ ", listaUnidadesFiltradas=" + listaUnidadesFiltradas
				+ ", acao=" + acao + ", codigo=" + codigo + "]";
	}
	
	
	
	/***************************************************************/

	
	
	
	
	
	
	
}	