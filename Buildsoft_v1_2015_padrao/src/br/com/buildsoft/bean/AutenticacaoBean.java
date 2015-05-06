package br.com.buildsoft.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Usuario;
import br.com.buildsoft.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}

		return usuarioLogado;
	}

	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	
	public String autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getCpf(), usuarioLogado.getSenha());

			
			if (usuarioLogado == null) {
				FacesUtil.adcionarMsgErro("Erro ao tentar autenticar! CPF e/ou senha inválidos!");
				//significa que vai ficar na mesma página 
				return null;
				
			} else {
				FacesUtil.adcionarMsgInfo("Usuário autenticado com sucesso!");
				return "/pages/principal.xhtml?faces-redirect=true";

			}

		} catch (RuntimeException ex) {
			FacesUtil.adcionarMsgErro("Erro ao tentar acessar o sistema!");
			    return null;

		}

	}

	public String sair() {
		usuarioLogado = null;
		return "/pages/autenticacao.xhtml?faces-redirect=true";

	}

}
