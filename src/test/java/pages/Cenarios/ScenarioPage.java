package pages.Cenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.ImportacaoDeDados.ImportacaoDados;

public class ScenarioPage extends BasePage {

    public ScenarioPage(WebDriver navegador) {
        super(navegador);
    }

    public ScenarioPage PreencherMesRefencia(String data_ref) throws InterruptedException {
        Thread.sleep(2000);
        WebElement Data_ref = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/input"));
        Data_ref.sendKeys(data_ref);
        return this;
    }

    public ScenarioPage EscolherTipoCenario(String tipo) throws InterruptedException {
        Thread.sleep(2000);
        if(tipo.equals("PlanoDeVendas")){
            WebElement plan = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[2]/div/mat-radio-group/mat-radio-button[1]/label/div[1]/div[2]"));
            plan.click();
        }else if(tipo.equals("ProgramaMensal")){
            WebElement prog = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[1]/div[2]/div/mat-radio-group/mat-radio-button[2]/label/div[1]/div[2]"));
            prog.click();
        }
        return this;
    }

    public ScenarioPage ClicarCriarCenario() throws InterruptedException {
        Thread.sleep(2000);
        WebElement CriarCenario = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/simple-box/div[2]/app-scnenarios-child/form/div/div[2]/button[1]"));
        CriarCenario.click();
        return this;
    }

    public ScenarioPage DescricaoCenario(String descricao) throws InterruptedException {
        Thread.sleep(2000);
        WebElement Descricao = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/form/div/mat-form-field/div/div[1]/div[3]/input"));
        Descricao.sendKeys(descricao);
        return this;
    }

    public ScenarioPage PreencherMesPlanjamento(String mes) throws InterruptedException {
        Thread.sleep(2000);
        WebElement MesPlan = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/form/div/div[1]/mat-form-field/div/div[1]/div[3]/input"));
        MesPlan.sendKeys(mes);
        return this;
    }

    public ScenarioPage Semanalizacao(String opcao) throws InterruptedException {
        Thread.sleep(2000);

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

    public ScenarioPage ClicarAdicionarMes() throws InterruptedException {
        Thread.sleep(2000);
        WebElement BtnAdiconarMes = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/app-create-horizon/div/div/button"));
        BtnAdiconarMes.click();
        return this;
    }

    public ScenarioPage CLicarSalvarCenario() throws InterruptedException {
        Thread.sleep(2000);
        WebElement ClicarSalvar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/div/div/div/div/div/button"));
        ClicarSalvar.click();
        return this;
    }

    public ScenarioPage AdicionarMesPlanejamentoCompleto(String Mes,String semanalizado) throws InterruptedException {
        PreencherMesPlanjamento(Mes);
        Semanalizacao(semanalizado);
        ClicarAdicionarMes();
        return this;
    }

    public ImportacaoDados EntrarCenario(String cenario) throws InterruptedException {
        Thread.sleep(2000);
        WebElement NomeCenario = navegador.findElement(By.xpath(""));
        Thread.sleep(2000);
        NomeCenario.click();

        return new ImportacaoDados(navegador);
    }

//    public InputPage EntrarCenarioComDados(String cenario) throws InterruptedException {
//        Thread.sleep(2000);
//        WebElement NomeCenario = navegador.findElement(By.linkText(cenario));
//        NomeCenario.click();
//        return new InputPage(navegador);
//    }

    public ImportacaoDados ClicaNoPrimeiroCenario() throws InterruptedException {
        Thread.sleep(2000);
        navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-scenarios/div/mat-accordion/app-planning-horizon[1]/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/app-header/div/div[1]/div")).click();
        return new ImportacaoDados(navegador);
    }


}
