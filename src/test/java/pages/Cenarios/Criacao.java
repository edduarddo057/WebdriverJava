package pages.Cenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.ImportacaoDeDados.ImportacaoDados;

public class Criacao extends BasePage {
    public Criacao(WebDriver navegador) {
        super(navegador);
    }

    public Criacao MesRef(String mes) throws InterruptedException {
        Thread.sleep(1000);
        WebElement mes_ref = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/input"));
        mes_ref.sendKeys(mes);

        return this;
    }

    public Criacao TipoCen(String tipo) throws InterruptedException {

        Thread.sleep(1000);
        if(tipo.equals("Plano de vendas")) {
            WebElement tipo_cen = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[2]/div/mat-radio-group/mat-radio-button[1]/label/div[1]"));
            tipo_cen.click();
        }else if(tipo.equals("Programa mensal")){
            WebElement tipo_cen = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/label/div[1]"));
            tipo_cen.click();
        }

        return this;
    }

    public Criacao CLickCriar() throws InterruptedException {

        Thread.sleep(1000);
        WebElement click_criar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[2]/button[1]"));
        click_criar.click();

        return this;
    }

    public Criacao AdcDescricao(String desc) throws InterruptedException {

        Thread.sleep(1000);
        WebElement descricao = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/form/div/mat-form-field/div/div[1]/div[3]/input"));
        descricao.sendKeys(desc);


        return  this;
    }

    public Criacao MesPlan(String mes) throws InterruptedException {

        Thread.sleep(1000);
        WebElement mes_plan = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/form/div/div[1]/mat-form-field/div/div[1]/div[3]/input"));
        mes_plan.sendKeys(mes);

        return this;

    }

    public Criacao Semanalizacao(String opcao) throws InterruptedException {

        Thread.sleep(1000);
        WebElement seman = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/form/div/div[2]/mat-slide-toggle/label/span"));
        String semanalizado = seman.getText();

        WebElement btnSemanalizado = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/form/div/div[2]/mat-slide-toggle/label/div"));
        if(opcao.equals("Sim")){
            if(semanalizado.equals("Sim")){
                return this;
            }else{
                btnSemanalizado.click();
            }
        }else if(opcao.equals("Não")){
            if(semanalizado.equals("Sim")){
                btnSemanalizado.click();
            }else{
                return this;
            }
        }

        return this;
    }

    public Criacao ClickAdcMes() throws InterruptedException {

        Thread.sleep(1000);
        WebElement BtnAdiconarMes = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/div/button"));
        BtnAdiconarMes.click();

        return this;
    }

    public Criacao ClickrSalvarCen() throws InterruptedException {

        Thread.sleep(1000);
        WebElement ClicarSalvar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/div/div/button"));
        ClicarSalvar.click();

        return this;
    }

    public Criacao CenCompleto(String mes, String tipo, String desc, String mesplan, String sema) throws InterruptedException {
        Thread.sleep(1000);
        new Criacao(navegador).MesRef(mes)
                .TipoCen(tipo)
                .CLickCriar()
                .AdcDescricao(desc)
                .MesPlan(mesplan)
                .Semanalizacao(sema)
                .ClickAdcMes()
                .ClickrSalvarCen();
        Thread.sleep(1000);
        return this;
    }

    public ImportacaoDados selecionarCenario(String numCen) throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.xpath("//*[@id=\"mat-expansion-panel-header-"+ numCen +"\"]/span/mat-panel-title/app-header/div/div[1]/div")).click();
        return new ImportacaoDados(navegador);
    }

}
