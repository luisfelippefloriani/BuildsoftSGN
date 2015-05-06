package br.com.buildsoft.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuarioCadastro;
	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrados;
	private String acao;
	private Long codigo;

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuarioCadastro);

			usuarioCadastro = new Usuario();

			FacesUtil.adcionarMsgInfo("Corretor salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar salvar o corretor!");
			System.out.println(ex);

		}

	}

	/**********************************************************************/

	public void carregarPesquisa() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar();

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar listar os corretores!");

		}

	}

	/**********************************************************************/

	public void carregarCadastro() {
		try {

			String valor = FacesUtil.getParam("usucod");

			if (valor != null) {

				Long codigo = Long.parseLong(valor);

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioCadastro = usuarioDAO.buscarPorCodigo(codigo);

			}

			else {
				usuarioCadastro = new Usuario();
			}
		} catch (RuntimeException ex) {
			FacesUtil
					.adcionarMsgErro("Erro ao tentar obter os dados do corretor!");

		}
	}

	/**********************************************************************/

	public void excluir() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuarioCadastro);

			FacesUtil.adcionarMsgInfo("Corretor excluído com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar excluir o corretor!");
		}
	}

	/**********************************************************************/

	public void editar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.editar(usuarioCadastro);

			FacesUtil.adcionarMsgInfo("Corretor  editado com sucesso!");

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar editar o corretor");

		}
	}

	/**********************************************************************/

	public void entrar() {
		try {
			FacesUtil.adcionarMsgInfo("Usuário autenticado com sucesso!");
		} catch (Exception e) {
			FacesUtil
					.adcionarMsgErro("Erro ao tentar autenticar-se no sistema!");
		}
	}

	/**********************************************************************/

	public Usuario getUsuarioCadastro() {
		if (usuarioCadastro == null) {
			usuarioCadastro = new Usuario();

		}
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
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

}
