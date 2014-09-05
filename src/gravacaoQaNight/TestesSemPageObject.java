package gravacaoQaNight;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;

public class TestesSemPageObject extends Driver {
	
	@Test
	public void criarNovoProduto() {
		String mensagemEsperada = "Product was successfully created.";
		
		driver.get(adminUrl);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("product_title")).sendKeys("primeiro teste");
		driver.findElement(By.id("product_price")).sendKeys("10");
		driver.findElement(By.id("product_image_file_name")).sendKeys("darkside.png");
		driver.findElement(By.id("product_submit")).click();	
		
		String mensagemAchada = driver.findElement(By.className("flash_notice")).getText();
		
		assertEquals(mensagemAchada,mensagemEsperada);		
	}
	
	@Test
	public void criarNovoProdutoSemCamposObrigatorios() {
		String mensagemEsperada = "Can't Be Blank";
		
		driver.get(adminUrl);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("product_title")).sendKeys("primeiro teste");
		driver.findElement(By.id("product_price")).sendKeys("10");
		driver.findElement(By.id("product_image_file_name")).sendKeys("");
		driver.findElement(By.id("product_submit")).click();
		
		String mensagemAchada = driver.findElement(By.className("inline-errors")).getText();
		
		assertEquals(mensagemAchada,mensagemEsperada);
		
		
	}

}
