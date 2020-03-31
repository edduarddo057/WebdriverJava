package pages.Inputs.EstoqueDeVirada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Porto extends BasePage {
    public Porto(WebDriver navegador) {
        super(navegador);
        WebElement clickEstoque = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/mat-tab-header/div[2]/div/div/div[3]/div"));
        clickEstoque.click();
    }

    public Porto incluirEstoqueDeViradaPorto() throws InterruptedException {

        WebElement clickPorto = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[2]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon"));
        clickPorto.click();

        Thread.sleep(1000);
        WebElement incluirPorto = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[2]/mat-expansion-panel/div/div/div/dynamic-table/div/table/thead/tr[2]/th[6]/div/button"));
        incluirPorto.click();

        Thread.sleep(1000);
        WebElement porto = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        porto.click();

        Thread.sleep(1000);
        WebElement opcaoPorto = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]"));
        opcaoPorto.click();

        Thread.sleep(5000);
        WebElement mercadoria = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[1]/div[2]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        mercadoria.click();

        Thread.sleep(1000);
        WebElement opcaoMercadoria = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[6]"));
        opcaoMercadoria.click();

        Thread.sleep(1000);
        WebElement cliente = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[1]/div[3]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        cliente.click();

        Thread.sleep(1000);
        WebElement opcaoCliente = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[4]"));
        opcaoCliente.click();

        Thread.sleep(500);
        WebElement destino = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[1]/div[4]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        destino.click();

        Thread.sleep(1000);
        WebElement opcaoDestino = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[4]"));
        opcaoDestino.click();

        Thread.sleep(500);
        WebElement volume = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[1]/div[5]/mat-form-field/div/div[1]/div[3]/input"));
        volume.sendKeys("200");

        Thread.sleep(500);
        WebElement salvar = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-port/div[1]/form/div/div[2]/button"));
        salvar.click();

        return this;
    }
}
