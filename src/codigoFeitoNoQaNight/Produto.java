package codigoFeitoNoQaNight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Produto {
	
	private WebDriver driver;
	
	private static final By menuProduto = By.linkText("Products");
	private static final By novoProdutoBtn = By.linkText("New Product");
	private static final By tituloProduto = By.id("product_title");
	private static final By precoProduto = By.id("product_price");
	private static final By imagemProduto = By.id("product_image_file_name");
	private static final By submitProdutoBtn = By.id("product_submit");
	private static final By mensagemUsuario = By.className("flash_notice");
	private static final By mensagemCampoObrigatorio = By.className("inline-errors");
	private static final By pesquisaTitulo  = By.id("q_title");
	private static final By pesquisaBtn = By.id("q_submit");
	private static final By mensagemNaoEncontrada = By.className("blank_slate");

	public Produto(WebDriver webDriver) {
		driver = webDriver;
	}
	
	public void acessaProduto() {
		driver.findElement(menuProduto).click();	
	}
	
	public void criaNovoProduto(String titulo, String preco, String imagem) {
		driver.findElement(novoProdutoBtn).click();
		driver.findElement(tituloProduto).sendKeys(titulo);
		driver.findElement(precoProduto).sendKeys(preco);
		driver.findElement(imagemProduto).sendKeys(imagem);
		driver.findElement(submitProdutoBtn).click();
	}
	
	public boolean mensagemFoiMostrada(String mensagemEsperada) {
		String mensagemAtual = driver.findElement(mensagemUsuario).getText();
		return mensagemAtual.equals(mensagemEsperada);		
	}
	
	public boolean mensagemCampoObrigatoriaFoiMostrada(String mensagemEsperada) {
		String mensagemAtual = driver.findElement(mensagemCampoObrigatorio).getText();
		return mensagemAtual.equals(mensagemEsperada);
	}

	public void deletarProduto(String nomeProduto) {
		
		driver.findElement(By.linkText(nomeProduto)).click();
		driver.findElement(By.linkText("Delete Product")).click();
		
	}
	
	public boolean pesquisaPosDelete(String titulo){
		driver.findElement(pesquisaTitulo).sendKeys(titulo);
		driver.findElement(pesquisaBtn).click();
		return driver.findElement(mensagemNaoEncontrada).getText().equals("No Products found");
	}
	
}
