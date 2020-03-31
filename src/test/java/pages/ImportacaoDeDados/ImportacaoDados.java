package pages.ImportacaoDeDados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.Inputs.Demanda.Ferrovia;

public class ImportacaoDados extends BasePage {
    public ImportacaoDados(WebDriver navegador) {
        super(navegador);
    }


    public ImportacaoDados ImportFluxo(String LocalArquivo) throws InterruptedException {

        //LocalArquivo: /home/eduardo/Área de Trabalho/dados vli sop/Fluxos.xlsx

        WebElement Click_selecionar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[1]/form/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
        Click_selecionar.click();

        WebElement OpcaoFluxo = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[3]"));
        OpcaoFluxo.click();

        WebElement Input_anexar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[1]/input"));
        Input_anexar.sendKeys(LocalArquivo);

        WebElement Btn_enviar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[2]/button"));
        Btn_enviar.click();
        Thread.sleep(60000);

        return this;
    }

    public ImportacaoDados ImportDemanda(String LocalArquivo) throws InterruptedException {

        //LocalArquivo: /home/eduardo/Área de Trabalho/dados vli sop/demanda.xlsx

        WebElement Click_selecionar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[1]/form/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
        Click_selecionar.click();

        WebElement OpcaoDemanda = navegador.findElement(By.xpath("//*[@id=\"mat-option-1\"]/span"));
        OpcaoDemanda.click();

        WebElement Input_anexar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[1]/input"));
        Input_anexar.sendKeys(LocalArquivo);

        WebElement Btn_enviar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[2]/button"));
        Btn_enviar.click();
        Thread.sleep(25000);

        return this;
    }

    public ImportacaoDados ImportClassificacao(String LocalArquivo) throws InterruptedException {

        //LocalArquivo: /home/eduardo/Área de Trabalho/dados vli sop/classificacao.xlsx

        WebElement Click_selecionar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[1]/form/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
        Click_selecionar.click();

        WebElement OpcaoClassificacao = navegador.findElement(By.xpath("//*[@id=\"mat-option-0\"]/span"));
        OpcaoClassificacao.click();

        WebElement Input_anexar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[1]/input"));
        Input_anexar.sendKeys(LocalArquivo);

        WebElement Btn_enviar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[2]/button"));
        Btn_enviar.click();
        Thread.sleep(42000);

        return this;
    }

    public ImportacaoDados ImportTerminais(String LocalArquivo) throws InterruptedException {

        //LocalArquivo: /home/eduardo/Área de Trabalho/dados vli sop/Terminais_terceiros.xlsx

        WebElement Click_selecionar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[1]/form/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]/span"));
        Click_selecionar.click();

        WebElement OpcaoTerminais = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/mat-option[4]/span"));
        OpcaoTerminais.click();

        WebElement Input_anexar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[1]/input"));
        Input_anexar.sendKeys(LocalArquivo);

        WebElement Btn_enviar = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/main/app-imports/div/simple-box/div[2]/div[1]/div[2]/div/app-filepicker/div/div[2]/button"));
        Btn_enviar.click();
        Thread.sleep(20000);

        return this;
    }

    public Ferrovia ImportCompleto(String LocalFluxo,String LocalDemanda, String LocalClassificacao, String LocalTerminais) throws InterruptedException {

        //LocalFluxo: "/home/eduardo/Área de Trabalho/dados vli sop/Fluxos.xlsx"
        //LocalDemanda: "/home/eduardo/Área de Trabalho/dados vli sop/demanda.xlsx"
        //LocalClassificacao: "/home/eduardo/Área de Trabalho/dados vli sop/classificacao.xlsx"
        //LocalTerminais: "/home/eduardo/Área de Trabalho/dados vli sop/Terminais_terceiros.xlsx"
        Thread.sleep(1000);
        ImportFluxo(LocalFluxo);
        ImportDemanda(LocalDemanda);
        ImportClassificacao(LocalClassificacao);
        ImportTerminais(LocalTerminais);

        navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/app-topnavbar/mat-toolbar/mat-toolbar-row[2]/mat-nav-bar-pagination/div/div[2]/nav/div/a[3]")).click();

        return new Ferrovia(navegador);
    }


}
