package validador.marketingdigital.integracao.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class BrowserSimulator {
   public static void main(String[] args) throws Exception {
      // configurar as capacidades desejadas para o navegador remoto
      DesiredCapabilities capabilities = DesiredCapabilities.chrome();

      
      // instanciar o objeto do RemoteWebDriver
      WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), capabilities);

      // abrir o Google
      driver.get("https://www.google.com");

      // encontrar o campo de pesquisa e digitar "Java"
      WebElement searchField = driver.findElement(By.name("q"));
      searchField.sendKeys("Java");
      searchField.submit();

      // fechar o navegador
      driver.quit();
   }
}

