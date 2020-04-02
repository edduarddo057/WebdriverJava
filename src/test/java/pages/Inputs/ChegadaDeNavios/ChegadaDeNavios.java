package pages.Inputs.ChegadaDeNavios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import suporte.Web;

public class ChegadaDeNavios extends BasePage {
    public ChegadaDeNavios(WebDriver navegador) {
        super(navegador);
    }

    public ChegadaDeNavios incluirChegadaNavios(String nomeNavio,String opera, String volFerro, String ETAmin, String ETAmax, String OBS ) throws InterruptedException {
        Thread.sleep(2000);
        WebElement incluirchegada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[2]/div/div/app-ship-arrival/dynamic-table/div/table/thead/tr/th[11]/div/button"));
        incluirchegada.click();

        WebElement porto = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        porto.click();
        navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]")).click();

        Thread.sleep(4000);
        WebElement mercadoria = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[2]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        mercadoria.click();

        Thread.sleep(2000);
        navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]")).click();

        Thread.sleep(1000);
        WebElement cliente = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[3]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        cliente.click();
        navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]")).click();

        WebElement operaMes = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[5]/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]"));
        operaMes.click();

        Thread.sleep(1000);

        navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[1]")).click();

        WebElement navio = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[4]/mat-form-field/div/div[1]/div[3]/input"));
        navio.sendKeys(nomeNavio);


        WebElement volFerroviario = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[6]/mat-form-field[1]/div/div[1]/div[3]/input"));
        volFerroviario.sendKeys(volFerro);

        WebElement etaMIN = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[7]/mat-form-field[1]/div/div[1]/div[3]/input"));
        etaMIN.sendKeys(ETAmin);

        WebElement etaMAX = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[7]/mat-form-field[2]/div/div[1]/div[3]/input"));
        etaMAX.sendKeys(ETAmax);

        WebElement obs = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[1]/div[8]/mat-form-field/div/div[1]/div[3]/input"));
        obs.sendKeys(OBS);

        WebElement salvarChaegada = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-ship-arrival-modal/form/div/div[3]/div[2]/button"));
        salvarChaegada.click();

        return  this;
    }
    public  ChegadaDeNavios excluirChegadaNavios() throws InterruptedException {
        Thread.sleep(2000);

        WebElement excluirChegada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[2]/div/div/app-ship-arrival/dynamic-table/div/table/tbody/tr/td[11]/div/button[2]/span/mat-icon"));
        excluirChegada.click();

        Thread.sleep(1000);

        WebElement confirmExclusao = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/swal/div/div[2]/button[2]"));
        confirmExclusao.click();

        return this;
    }
}
