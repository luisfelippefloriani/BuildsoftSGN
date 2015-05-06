package br.com.buildsoft.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.domain.Empreendimento;

@FacesConverter("empreendimentoConverter")
public class EmpreendimentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
			Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(codigo);
			return empreendimento;

			} 
			
		catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component,
			Object objeto) {
		try {
			Empreendimento empreendimento = (Empreendimento) objeto;
			Long codigo = empreendimento.getCodigo();
			return codigo.toString();

		} catch (RuntimeException ex) {
			return null;
		}
		
	}
}
