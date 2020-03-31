package tests;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Cenarios.Criacao;
import pages.Login.LoginPage;
import suporte.Web;

import java.time.LocalDate;

public class VLI_test_Login_Cenario {
    private WebDriver navegador;
    public LocalDate hoje = LocalDate.now();

    @Before
    public void setUp() throws Exception {
        navegador = Web.createChrome();
        //navegador = Web.createLambdaTest();
    }

    @Test
    public void testLoginVLI() throws InterruptedException {
        new LoginPage(navegador)
            .digitarEmail("enacom@enacom.com.br")
            .digitarSenha("enacom123")
            .clicarEntrar();
        Thread.sleep(3000);
        assertEquals("https://vlisopdev.enacloud.me/#/cenarios",navegador.getCurrentUrl());
    }

    @Test
    public void testCriarCenario() throws InterruptedException {
        String mes;
        if(hoje.plusMonths(1).getMonthValue() < 10) {
             mes = "0"+ hoje.plusMonths(1).getMonthValue();
        }else{
             mes = ""+hoje.plusMonths(1).getMonthValue();
        }

        new LoginPage(navegador)
                .FazerLogin("enacom@enacom.com.br","enacom123")
                .CenCompleto(mes+hoje.getYear()+"","Plano de vendas", "teste-comp",mes+hoje.getYear()+"","Sim");

        Thread.sleep(2000);
        WebElement sucess = navegador.findElement(By.xpath("/html/body/div[2]/div/div/snack-bar-container/simple-snack-bar/span"));
        assertEquals("Cenário criado com sucesso.",sucess.getText());

    }




   // @Test
    public void testDuplicarCenario() throws InterruptedException {
        new LoginPage(navegador)
                .FazerLogin("enacom@enacom.com.br","enacom123");
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
