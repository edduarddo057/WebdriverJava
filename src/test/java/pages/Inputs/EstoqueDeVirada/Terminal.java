package pages.Inputs.EstoqueDeVirada;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import suporte.Web;

public class Terminal extends BasePage {
    public Terminal(WebDriver navegador) {
        super(navegador);
        WebElement clickEstoque = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/mat-tab-header/div[2]/div/div/div[3]/div"));
        clickEstoque.click();
    }

    public Terminal incluirEstoqueDeViradaTerminal() throws InterruptedException {
        WebElement estoqueVirada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[1]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon"));
        estoqueVirada.click();

        WebElement incluirTerminal = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[1]/mat-expansion-panel/div/div/div/dynamic-table/div/table/thead/tr[2]/th[6]/div/button"));
        incluirTerminal.click();

        WebElement terminal = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        terminal.click();

        WebElement opcaoTerminal = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]"));
        opcaoTerminal.click();

        Thread.sleep(4000);
        WebElement mercadoria = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[1]/div[2]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        mercadoria.click();

        WebElement opcaoMercadoria = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[4]"));
        opcaoMercadoria.click();

        Thread.sleep(1000);
        WebElement cliente = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[1]/div[3]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        cliente.click();

        Thread.sleep(1000);
        WebElement opcaoCliente = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[2]"));
        opcaoCliente.click();

        WebElement destino = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[1]/div[4]/mat-form-field/div/div[1]/div[3]/select-infinite-scroll-search/mat-select/div/div[2]"));
        destino.click();

        Thread.sleep(1000);
        WebElement opcaoDestino = navegador.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/mat-option[3]"));
        opcaoDestino.click();

        WebElement volume = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[1]/div[5]/mat-form-field/div/div[1]/div[3]/input"));
        volume.sendKeys("200");

        Thread.sleep(2000);
        WebElement salvar = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-modal-terminal/div[1]/form/div/div[2]/button"));
        salvar.click();

        return this;
    }

    public Terminal excluirEstoqueDeViradaTerminal() throws InterruptedException {
        WebElement estoqueVirada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[1]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon"));
        estoqueVirada.click();

        Thread.sleep(1000);
        WebElement excluir = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[3]/div/div/app-turn-stock/mat-accordion/accordion[1]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr/td[6]/div/button[2]/span/mat-icon"));
        excluir.click();

        Thread.sleep(1000);
        WebElement confirmarExcluir = navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/swal/div/div[2]/button[2]"));
        confirmarExcluir.click();



        return this;
    }
}
