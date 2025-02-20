package br.com.desafio.automacaoweb.demoblaze;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private WebDriver driver;

    @FindBy(linkText = "Cart")
    private WebElement linkCarrinho;

    @FindBy(linkText = "Place Order")
    private WebElement btnFinalizarCompra;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void irParaCarrinho() {
        linkCarrinho.click();
    }

    public void finalizarCompra() {
        btnFinalizarCompra.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();
    }
}