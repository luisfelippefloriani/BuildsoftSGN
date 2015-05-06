package br.com.buildsoft.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.buildsoft.util.FacesUtil;

@ManagedBean
@ViewScoped
public class AgendaVisitaBean {
	
	public void salvar(){
		FacesUtil.adcionarMsgInfo("Visita salva com sucesso!");
	}


}
