package br.com.desafio.automacaoweb.demoblaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonitorsPage {
    private WebDriver driver;

    @FindBy(linkText = "Apple monitor 24")
    private WebElement linkMonitor;

    public MonitorsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void adicionarMonitorAoCarrinho() {
        try {
            linkMonitor.click();
            driver.findElement(By.linkText("Add to cart")).click();


        } catch (Exception e) {
            System.out.println("Alerta não encontrado: " + e.getMessage());
        }
    }
}