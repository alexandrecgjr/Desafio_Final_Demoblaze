package br.com.desafio.automacaoweb.demoblaze;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;


import java.time.Duration;

public class DemoBlazeTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    @DisplayName("Automação de compra no site DemoBlaze")
    public void testeCompraDeMonitor() {
        // Configurar o WebDriver para o Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver navegador = new ChromeDriver(options);
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Abrir o site DemoBlaze
            navegador.get("https://www.demoblaze.com/index.html");
            System.out.println("Abrir o site DemoBlaze");

            // Acessar a categoria "Monitors"
            WebElement categoriaMonitor = navegador.findElement(By.linkText("Monitors"));
            categoriaMonitor.click();
            System.out.println("Acessar a categoria de monitores");

            // Adicionar um monitor ao carrinho (selecionar o primeiro monitor)
            WebElement monitor = navegador.findElement(By.linkText("Apple monitor 24"));
            monitor.click();
            System.out.println("Selecionar um monitor");

            WebElement adicionarAoCarrinho = navegador.findElement(By.xpath("//a[text()='Add to cart']"));
            adicionarAoCarrinho.click();
            System.out.println("Adicionar monitor ao carrinho");

            // Aceitar o alerta de confirmação
            navegador.switchTo().alert().accept();

            // Ir para o carrinho
            WebElement carrinho = navegador.findElement(By.linkText("Cart"));
            carrinho.click();
            System.out.println("Ir para o carrinho");

            // Finalizar a compra preenchendo os campos
            WebElement botaoPlaceOrder = navegador.findElement(By.xpath("//button[text()='Place Order']"));
            botaoPlaceOrder.click();

            // Preencher informações de compra
            navegador.findElement(By.id("name")).sendKeys("Nome Teste");
            navegador.findElement(By.id("country")).sendKeys("Brasil");
            navegador.findElement(By.id("city")).sendKeys("Cidade Teste");
            navegador.findElement(By.id("card")).sendKeys("1234 5678 9012 3456");
            navegador.findElement(By.id("month")).sendKeys("12");
            navegador.findElement(By.id("year")).sendKeys("2025");
            System.out.println("Preencher as informações de compra");

            // Clicar em "Purchase" para finalizar a compra
            WebElement botaoPurchase = navegador.findElement(By.xpath("//button[text()='Purchase']"));
            botaoPurchase.click();
            System.out.println("Finalizar a compra");

            // Validar mensagem de sucesso
            WebElement mensagemSucesso = navegador.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
            Assertions.assertNotNull(mensagemSucesso, "Compra não realizada com sucesso!");
            System.out.println("Compra realizada com sucesso!");

        } finally {
            navegador.quit(); // Fechar o navegador
        }
    }
}
