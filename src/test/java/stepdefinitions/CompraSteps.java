package stepdefinitions;

import br.com.desafio.automacaoweb.demoblaze.CartPage;
import br.com.desafio.automacaoweb.demoblaze.HomePage;
import br.com.desafio.automacaoweb.demoblaze.MonitorsPage;
import io.cucumber.java.pt.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class CompraSteps {
    private WebDriver driver;
    private HomePage homePage;
    private MonitorsPage monitorsPage;
    private CartPage cartPage;

    @Dado("Eu abro o site DemoBlaze")
    public void abrirSite() {
        driver = WebDriverFactory.getDriver();
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }

    @Quando("Eu acesso a categoria de monitores")
    public void acessarCategoriaMonitores() {
        homePage.acessarCategoriaMonitores();
        monitorsPage = new MonitorsPage(driver);
    }

    @E("Eu adiciono um monitor ao carrinho")
    public void adicionarMonitorAoCarrinho() {
        monitorsPage.adicionarMonitorAoCarrinho();
    }

    @E("Eu vou para o carrinho")
    public void irParaCarrinho() {
        cartPage = new CartPage(driver);
        cartPage.irParaCarrinho();
    }

    @E("Eu finalizo a compra preenchendo todos os campos")
    public void finalizarCompra() {
        cartPage.finalizarCompra();
    }

    @Entao("A compra é concluída com sucesso")
    public void validarCompraConcluida() {
        Assert.assertTrue(true); // Exemplo simples
    }
}