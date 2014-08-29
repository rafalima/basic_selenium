package codigoFeitoNoQaNight;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TesteComPageObject extends Driver {
	
	@Before
	public void acessarAdminUrl() {
		driver.get(adminUrl);
	}
	
	@Test
	public void criarNovoProduto() {
		String mensagemEsperada = "Product was successfully created.";
		
		Produto produto = new Produto(driver);
		produto.acessaProduto();
		produto.criaNovoProduto("novo teste", "4000", "darkside.jpg");
		assertTrue(produto.mensagemFoiMostrada(mensagemEsperada));
	}
	
	@Test
	public void criarNovoProdutoSemCamposObrigatorios() {
		String mensagemEsperada = "Can't Be Blank";
		
		Produto produto = new Produto(driver);
		produto.acessaProduto();
		produto.criaNovoProduto("adas", "12321", "");
		assertTrue(produto.mensagemCampoObrigatoriaFoiMostrada(mensagemEsperada));
	}
	
	@Test
	public void criaDeletaNovoProduto() {
		String mensagemEsperada = "Product was successfully destroyed.";
		java.util.Date dataAtual = new Date(); 
		System.out.println(dataAtual);

		
		Produto produto = new Produto(driver);
		produto.acessaProduto();
		produto.criaNovoProduto(dataAtual.toString(), "12321", "darkside.jpg");
		
		produto.acessaProduto();

		produto.deletarProduto(dataAtual.toString());
		assertTrue(produto.mensagemFoiMostrada(mensagemEsperada));
	}
	
	
	@Test
	public void verificaProdutoDeletado(){
		java.util.Date dataAtual = new Date(); 
		System.out.println(dataAtual);
		
		Produto produto = new Produto(driver);
//		Produto produto = PageFactory.initElements(driver,Produto.class);
		produto.acessaProduto();
		produto.criaNovoProduto(dataAtual.toString(), "12321", "darkside.jpg");
		
		produto.acessaProduto();

		produto.deletarProduto(dataAtual.toString());
		assertTrue(produto.pesquisaPosDelete(dataAtual.toString()));
	}

}
