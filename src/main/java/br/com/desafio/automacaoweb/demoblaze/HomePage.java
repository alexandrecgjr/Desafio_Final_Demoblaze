package br.com.desafio.automacaoweb.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(linkText = "Monitors")
    private WebElement linkMonitores;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acessarCategoriaMonitores() {
        linkMonitores.click();
    }
}