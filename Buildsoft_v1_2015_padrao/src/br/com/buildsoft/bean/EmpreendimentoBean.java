package br.com.buildsoft.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;


@ManagedBean
@ViewScoped
public class EmpreendimentoBean {
	
	private Empreendimento empreendimentoCadastro;
	private List<Empreendimento> listaEmpreendimentos;
	private List<Empreendimento> listaEmpreendimentosFiltrados;
	
	private String acao;
	private Long codigo;
		
	
	public void salvar() {
		try {
			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			empreendimentoDAO.salvar(empreendimentoCadastro);

			empreendimentoCadastro = new Empreendimento();

			FacesUtil.adcionarMsgInfo("Empreendimento salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar salvar o empreendimento!");
			System.out.println(ex);

		}

	}
	
	/**********************************************************************/

	public void carregarPesquisa() {
		try {
			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			listaEmpreendimentos = empreendimentoDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar listar os empreendimentos!");

		}

	}
	
	/**********************************************************************/

	public void carregarCadastro() {
		try {		
			if (codigo != null) {
				
				
				EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
				
				empreendimentoCadastro = empreendimentoDAO.buscarPorCodigo(codigo);

			}

			else {
				empreendimentoCadastro = new Empreendimento();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar obter os dados do empreendimento!");
					
		}
	}
	
	/**********************************************************************/

	public void excluir() {
		try {
			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			empreendimentoDAO.excluir(empreendimentoCadastro);

			FacesUtil.adcionarMsgInfo("Empreendimento excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar excluir o empreendimento! </br> Verfique se não há alguma unidade ou proposta cadastrada!");
		}
	}

	/**********************************************************************/
	
	public void editar() {
		try {
			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			empreendimentoDAO.editar(empreendimentoCadastro);

			FacesUtil.adcionarMsgInfo("Empreendimento  editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar editar o empreendimento!");

		}
	}

	/**********************************************************************/
	
	public void novo() {
		empreendimentoCadastro = new Empreendimento();

	}
	
	/**********************************************************************/
	
	
	public Empreendimento getEmpreendimentoCadastro() {
		
		return empreendimentoCadastro;
	}

	public void setEmpreendimentoCadastro(Empreendimento empreendimentoCadastro) {
		this.empreendimentoCadastro = empreendimentoCadastro;
	}

	public List<Empreendimento> getListaEmpreendimentos() {
		return listaEmpreendimentos;
	}

	public void setListaEmpreendimentos(List<Empreendimento> listaEmpreendimentos) {
		this.listaEmpreendimentos = listaEmpreendimentos;
	}

	public List<Empreendimento> getListaEmpreendimentosFiltrados() {
		return listaEmpreendimentosFiltrados;
	}

	public void setListaEmpreendimentosFiltrados(
			List<Empreendimento> listaEmpreendimentosFiltrados) {
		this.listaEmpreendimentosFiltrados = listaEmpreendimentosFiltrados;
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
				+ ((empreendimentoCadastro == null) ? 0
						: empreendimentoCadastro.hashCode());
		result = prime
				* result
				+ ((listaEmpreendimentos == null) ? 0 : listaEmpreendimentos
						.hashCode());
		result = prime
				* result
				+ ((listaEmpreendimentosFiltrados == null) ? 0
						: listaEmpreendimentosFiltrados.hashCode());
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
		EmpreendimentoBean other = (EmpreendimentoBean) obj;
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
		if (empreendimentoCadastro == null) {
			if (other.empreendimentoCadastro != null)
				return false;
		} else if (!empreendimentoCadastro.equals(other.empreendimentoCadastro))
			return false;
		if (listaEmpreendimentos == null) {
			if (other.listaEmpreendimentos != null)
				return false;
		} else if (!listaEmpreendimentos.equals(other.listaEmpreendimentos))
			return false;
		if (listaEmpreendimentosFiltrados == null) {
			if (other.listaEmpreendimentosFiltrados != null)
				return false;
		} else if (!listaEmpreendimentosFiltrados
				.equals(other.listaEmpreendimentosFiltrados))
			return false;
		return true;
	}

	/**********************************************************************/
	
	@Override
	public String toString() {
		return "EmpreendimentoBean [empreendimentoCadastro="
				+ empreendimentoCadastro + ", listaEmpreendimentos="
				+ listaEmpreendimentos + ", listaEmpreendimentosFiltrados="
				+ listaEmpreendimentosFiltrados + ", acao=" + acao
				+ ", codigo=" + codigo + "]";
	}

	/**********************************************************************/
	
	
	
	

}
