package codigoExemplo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	
	private WebDriver driver;
	
	private static final By productsMenuLink = By.linkText("Products");
	private static final By newProductBtn = By.linkText("New Product");
	private static final By productTitle = By.id("product_title");
	private static final By productPrice = By.id("product_price");
	private static final By productImage = By.id("product_image_file_name");
	private static final By productSubmit = By.id("product_submit");
	private static final By mensagemUsuario = By.className("flash_notice");
	private static final By camposObrigatorios = By.className("inline-errors"); 
	
	public ProductPage(WebDriver webDriver) {
		driver = webDriver;
	}
	
	public void acessaPaginaNovoProduto() {
		driver.findElement(productsMenuLink).click();
		driver.findElement(newProductBtn).click();
	}
	
	public void novoProduto(String titulo, String preco, String imagem) {
		driver.findElement(productTitle).sendKeys(titulo);
		driver.findElement(productPrice).sendKeys(preco);
		driver.findElement(productImage).sendKeys(imagem);
		driver.findElement(productSubmit).click();		
	}
	
	public boolean mensagemFoiMostrada(String mensagemEsperada) {
		String mensagemAchada = driver.findElement(mensagemUsuario).getText();
		return mensagemAchada.equals(mensagemEsperada);
	}
	
	public boolean mensagemCampoObrigatorioMostrado(String mensagemEsperada) {
		String mensagemAchada = driver.findElement(camposObrigatorios).getText();
		return mensagemAchada.equals(mensagemEsperada);
	}
	
	
		
	

}
