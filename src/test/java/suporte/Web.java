package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static String username = "lambdatestenacom";
    public static String accesskey = "STBUYKprwXG0TH01DjWBl2xjNsFjAAbOqNdLWzWrZL5Io7DREP";
    public static RemoteWebDriver driver = null;
    public static String gridURL = "@hub.lambdatest.com/wd/hub";

    //public  WebDriver navegador = null;

    public static WebDriver createChrome() {

        ChromeDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        //Navegando e fazendo login a pagina da vli
        navegador.get("https://vlisopdev.enacloud.me/#/autenticacao/login");

        return navegador;
    }

    public static WebDriver createLambdaTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "VLI");
        capabilities.setCapability("name", "test SOP-VLI");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "79.0");
        capabilities.setCapability("resolution", "1280x800");
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
            driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

            //Navegando e fazendo login a pagina da vli
            driver.get("https://vlisopdev.enacloud.me/#/autenticacao/login");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nALgo deu errado!!!! ");
        }

        return driver;

    }
}
