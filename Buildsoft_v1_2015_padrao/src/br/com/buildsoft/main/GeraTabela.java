package br.com.buildsoft.main;

import br.com.buildsoft.util.HibernateUtil;



public class GeraTabela {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
