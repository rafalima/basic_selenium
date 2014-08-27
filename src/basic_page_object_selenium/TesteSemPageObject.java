package basic_page_object_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;


public class TesteSemPageObject extends Driver {
	

	@Test
	public void criarNovoProduto() {
		String mensagemEsperada = "Product was successfully created.";
		driver.get(adminUrl);
		waitForElement(By.linkText("Products")).click();
		waitForElement(By.linkText("New Product")).click();
		waitForElement(By.id("product_title")).sendKeys("Rafael");
		waitForElement(By.id("product_price")).sendKeys("10.0");
		waitForElement(By.id("product_image_file_name")).sendKeys("darkside.jpg");
		waitForElement(By.id("product_submit")).click();	
		String mensagemAchada = waitForElement(By.className("flash_notice")).getText();
		assertEquals(mensagemEsperada,mensagemAchada);
		
	}
	
	@Test
	public void criarNovoProdutoSemCamposObrigatorios() {
		String mensagemEsperada = "Can't Be Blank";
		driver.get(adminUrl);
		waitForElement(By.linkText("Products")).click();
		waitForElement(By.linkText("New Product")).click();
		waitForElement(By.id("product_title")).sendKeys("Rafael");
		waitForElement(By.id("product_price")).sendKeys("10.0");
		waitForElement(By.id("product_submit")).click();	
		String mensagemAchada = waitForElement(By.className("inline-errors")).getText();
		assertEquals(mensagemEsperada,mensagemAchada);		
	}

}
