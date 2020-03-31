package pages.Inputs.Demanda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class Ferrovia extends BasePage {
    public Ferrovia(WebDriver navegador) {
        super(navegador);
    }

    public boolean ImportacaoTabelaFerrovia(String opcao) throws InterruptedException {
        WebElement PainelFerrovia = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[1]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon"));
                                                                // /html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[1]/mat-expansion-panel/mat-expansion-panel-header/span/mat-icon
        PainelFerrovia.click();

        Thread.sleep(4000);

        WebElement mercadoria = navegador.findElement(By.xpath(" /html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[1]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr[1]/td[2]/div"));
                                                            //  /html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[1]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr[1]/td[2]/div
        return !mercadoria.getText().isEmpty();
    }
}
