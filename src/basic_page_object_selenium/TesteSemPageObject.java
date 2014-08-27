package basic_page_object_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;


public class TesteSemPageObject extends Driver {
	

	@Test
	public void criarNovoProduto() {
		String mensagemEsperada = "Product was successfully created.";
		driver.get(adminUrl);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("product_title")).sendKeys("Rafael");
		driver.findElement(By.id("product_price")).sendKeys("10.0");
		driver.findElement(By.id("product_image_file_name")).sendKeys("darkside.jpg");
		driver.findElement(By.id("product_submit")).click();	
		String mensagemAchada = driver.findElement(By.className("flash_notice")).getText();
		assertEquals(mensagemEsperada,mensagemAchada);
		
	}
	
	@Test
	public void criarNovoProdutoSemCamposObrigatorios() {
		String mensagemEsperada = "Can't Be Blank";
		driver.get(adminUrl);
		String mensagemAchada = waitForElement(By.className("inline-errors")).getText();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("product_title")).sendKeys("Rafael");
		driver.findElement(By.id("product_price")).sendKeys("10.0");
		driver.findElement(By.id("product_submit")).click();	
		String mensagemAchada = driver.findElement(By.className("inline-errors")).getText();
		assertEquals(mensagemEsperada,mensagemAchada);		
	}

}
