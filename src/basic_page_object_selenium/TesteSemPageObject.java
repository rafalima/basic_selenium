package basic_page_object_selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class TesteSemPageObject extends TestPreparation {

	@Test
	public void criarNovoProduto() {
		driver.get("http://localhost:3000/admin");
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("product_title")).sendKeys("Rafael");
		driver.findElement(By.id("product_price")).sendKeys("10.0");
		driver.findElement(By.id("product_image_file_name")).sendKeys("imagem.png");
		driver.findElement(By.id("product_submit")).click();		
		
	}

}
