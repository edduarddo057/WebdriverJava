package pages.Inputs.Demanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Terminal extends BasePage {
    public Terminal(WebDriver navegador) {
        super(navegador);
    }

    public boolean ImportacaoTabelaTerminal(String opcao) throws InterruptedException {
        Thread.sleep(2000);
        WebElement PainelTerminal = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[2]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon"));

        PainelTerminal.click();

        Thread.sleep(4000);

        WebElement operacao = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[2]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr["+opcao+"]/td[2]/div"));
        return !operacao.getText().isEmpty();
    }



}
