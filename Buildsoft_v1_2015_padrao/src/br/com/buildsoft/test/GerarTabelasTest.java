package br.com.buildsoft.test;

import org.junit.Test;

import br.com.buildsoft.util.HibernateUtil;



public class GerarTabelasTest {
	
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
		
	}

}
