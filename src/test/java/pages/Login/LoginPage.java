package pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.Cenarios.Criacao;
import pages.Cenarios.ScenarioPage;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginPage digitarEmail(String email) {
        WebElement inputEmail = navegador.findElement(By.xpath("/html/body/app-root/page-external/app-login/authentication-box/div/div[2]/div/form/div[1]/mat-form-field[1]/div/div[1]/div[3]/input"));
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage digitarSenha(String senha) {
        WebElement inputSenha = navegador.findElement(By.xpath("/html/body/app-root/page-external/app-login/authentication-box/div/div[2]/div/form/div[1]/mat-form-field[2]/div/div[1]/div[3]/input"));
        inputSenha.sendKeys(senha);
        return this;
    }

    public ScenarioPage clicarEntrar() throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.xpath("/html/body/app-root/page-external/app-login/authentication-box/div/div[2]/div/form/div[2]/button")).click();
        return new ScenarioPage(navegador);
    }

    public Criacao FazerLogin(String email, String senha) throws InterruptedException {
        try {
            digitarEmail(email);
            digitarSenha(senha);
            clicarEntrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new pages.Cenarios.Criacao(navegador);
    }


}
