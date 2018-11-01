package com.gft.qa.qa;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Assert;
import org.junit.Test;



public class QaApplication {
	@Test
	public void ListGft() {
		Client client = ClientBuilder.newClient();
		
		
		WebTarget target = client.target("http://www.mocky.io"); //Localiza nome GFT no texto
		String conteudo	= target.path("/v2/5bda436c2f0000823706d445").request().get(String.class);		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("GFT "));
		
		
	}
	@Test
	public void testaConexaoComSiteGft1() {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://www.mocky.io"); // testes sucesso verifica se existe: "Specialists in capital markets"
		String conteudo	= target.path("/v2/5bda436c2f0000823706d445").request().get(String.class);		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("Specialists in capital markets"));
		
		
	}
	
	@Test
	public void consultaText() {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://www.mocky.io"); //Consulta a String no site e retornará teste com sucesso"
		String conteudo	= target.path("/v2/5bda436c2f0000823706d445").request().get(String.class);		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("The recent financial crisis has led to a significant increase in the level of regulation, "
				+ "oversight and scrutiny of the financial services sector. Governments around the world are placing a greater emphasis on risk"
				+ " management and operational procedures, intensifying the pressure on investment banks, brokerage firms and hedge funds."));
		
		
	}
	@Test
	public void consultaTextErro() {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://www.mocky.io"); //Consulta a String no site mocky e retornará erro devido não existir a palavra (led)" "
		String conteudo	= target.path("/v2/5bda436c2f0000823706d445").request().get(String.class);		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("The recent financial crisis has to a significant increase in the level of regulation, "
				+ "oversight and scrutiny of the financial services sector. Governments around the world are placing a greater emphasis on risk"
				+ " management and operational procedures, intensifying the pressure on investment banks, brokerage firms and hedge funds."));
		
		
	}
	@Test
	public void consultaTextSucess() {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://www.mocky.io"); //Testes sucesso."
		String conteudo	= target.path("/v2/5bda436c2f0000823706d445").request().get(String.class);		
		System.out.println(conteudo);
		Assert.assertTrue(conteudo.contains("projects which address complex business challenges, whatever the size of your organisation"));
		
	}
}

