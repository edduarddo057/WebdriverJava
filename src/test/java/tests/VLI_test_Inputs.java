package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.Inputs.ChegadaDeNavios.ChegadaDeNavios;
import pages.Inputs.Demanda.Ferrovia;
import pages.Inputs.Demanda.Terminal;
import pages.Inputs.EstoqueDeVirada.Porto;
import pages.Login.LoginPage;
import static org.junit.Assert.*;
import suporte.Screenshot;
import suporte.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class VLI_test_Inputs {
    private WebDriver navegador;
    public LocalDate Data_atual = LocalDate.now();
    public LocalTime Hora_atual = LocalTime.now();

    @Rule
    public TestName nome_teste  = new TestName();

    @Before
    public void setUp() throws Exception {
        navegador = Web.createChrome();
        //navegador = Web.createLambdaTest();

        navegador.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        new LoginPage(navegador)
                .FazerLogin("enacom@enacom.com.br","enacom123")
                .selecionarCenario("0");
                Thread.sleep(2000);
    }

    @Test
    public void testTabelaDemandaFerrovia() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Boolean dadostabela = new Ferrovia(navegador).ImportacaoTabelaFerrovia("1");

        Thread.sleep(2000);

        //Este click nesse elemento é so para fazer uma rolagem da tela para o screenshot
        WebElement rolagem = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[1]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr[6]/td[2]/div"));
        rolagem.click();

        String screenshotArquivo = "/home/eduardo/IdeaProjects/WebdriverJava/src/test-report/Inputs/"+ this.Data_atual+"_"+this.Hora_atual.format(DateTimeFormatter.ofPattern("HH:mm"))+"_"+nome_teste.getMethodName();
        Screenshot.tirar(navegador,screenshotArquivo);

        assertEquals(true, dadostabela);
    }
    @Test
    public void testTabelaDemandaTerminal() throws IOException, InterruptedException {
        Thread.sleep(2000);
        Boolean dadostabela = new Terminal(navegador).ImportacaoTabelaTerminal("1");

        Thread.sleep(2500);

        //Este click nesse elemento é so para fazer uma rolagem da tela para o screenshot
        WebElement rolagem = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/div/mat-tab-body[1]/div/div/app-demand/mat-accordion/accordion[2]/mat-expansion-panel/div/div/div/dynamic-table/div/table/tbody/tr[4]/td[2]/div"));
        rolagem.click();

        String screenshotArquivo = "/home/eduardo/IdeaProjects/WebdriverJava/src/test-report/Terminal/"+ this.Data_atual+"_"+this.Hora_atual.format(DateTimeFormatter.ofPattern("HH:mm"))+"_"+nome_teste.getMethodName();
        Screenshot.tirar(navegador,screenshotArquivo);

        assertEquals(true, dadostabela);
    }

    @Test
    public void testIncluirChegadaDeNavios() throws InterruptedException {
        Thread.sleep(2000);

        WebElement clickChegada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]/div"));
        clickChegada.click();

        Thread.sleep(2000);
        new ChegadaDeNavios(navegador)
                .incluirChegadaNavios("Navio","Sim" ,"250",Data_atual.plusMonths(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"12:00",Data_atual.plusMonths(1).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"22:00","Observação!");

        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));
        assertEquals("Chegada de navio criada com sucesso.",sucesso.getText());
    }
    @Test
    public void testExcluirChegadaDeNavios() throws InterruptedException {
        Thread.sleep(2000);

        WebElement clickChegada = navegador.findElement(By.xpath("/html/body/app-root/page/app-navigation/mat-sidenav-container/mat-sidenav-content/main/app-filter-page/div/div/app-inputs/folder-tabs/mat-tab-group/mat-tab-header/div[2]/div/div/div[2]/div"));
        clickChegada.click();

        new ChegadaDeNavios(navegador).excluirChegadaNavios();

        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));
        assertEquals(sucesso.getText(),"Chegada de navio excluída com sucesso.");
    }

    @Test
    public void testIncluirEstoqueViradaTerminal() throws InterruptedException {
        Thread.sleep(2000);

        new pages.Inputs.EstoqueDeVirada.Terminal(navegador).incluirEstoqueDeViradaTerminal();
        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));

        assertEquals("Estoque de virada do terminal criado com sucesso.",sucesso.getText());
    }

    @Test
    public void testIncluirEstoqueViradaPorto() throws InterruptedException {
        Thread.sleep(2000);
        new Porto(navegador).incluirEstoqueDeViradaPorto();
        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));

        assertEquals("Estoque de virada do porto criado com sucesso.",sucesso.getText());
    }

    @Test
    public void testExcluirEstoqueViradaTerminal() throws InterruptedException {
        Thread.sleep(2000);

        new pages.Inputs.EstoqueDeVirada.Terminal(navegador).excluirEstoqueDeViradaTerminal();
        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));

        assertEquals("Estoque de virada do terminal excluído com sucesso.",sucesso.getText());
    }

    @Test
    public void testExcluirEstoqueViradaPorto() throws InterruptedException {
        Thread.sleep(2000);

        new Porto(navegador).excluirEstoqueDeViradaPorto();
        Thread.sleep(2000);
        WebElement sucesso = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));

        assertEquals("Estoque de virada do porto excluído com sucesso.",sucesso.getText());
    }

    @After
    public void tearDown() throws InterruptedException {
        try {
            Thread.sleep(2000);
            navegador.quit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
