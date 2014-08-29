package codigoExemplo;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import codigoFeitoNoQaNight.Driver;

public class TestComPageObject extends Driver {
	
	
	@Before
	public void acessaPaginaAdmin() {
		driver.get(adminUrl);
	}
	
	@Test
	public void criarNovoProduto() {
		String mensagemEsperada = "Product was successfully created.";
		
		ProductPage productPage = new ProductPage(driver);
		productPage.acessaPaginaNovoProduto();
		productPage.novoProduto("producto PO", "10", "darkside.png");
		assertTrue(productPage.mensagemFoiMostrada(mensagemEsperada));	
	}
	
	@Test
	public void criarNovoProdutoSemCamposObrigatorios() {
		String mensagemEsperada = "Can't Be Blank";
		
		ProductPage productPage = new ProductPage(driver);
		productPage.acessaPaginaNovoProduto();
		productPage.novoProduto("novo Produto", "10", "");
		assertTrue(productPage.mensagemCampoObrigatorioMostrado(mensagemEsperada));
	}

}
