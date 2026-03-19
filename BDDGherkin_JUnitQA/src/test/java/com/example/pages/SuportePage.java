package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.example.util.Hooks;

public class SuportePage {

    public void adicionarPrimeiroNome(String nome, String campo) {
        Hooks.getDriver().findElement(By.cssSelector("[data-test='first-name']")).sendKeys(nome);
    }

    public void adicionarSobrenome(String sobrenome, String campo) {
        Hooks.getDriver().findElement(By.cssSelector("[data-test='last-name']")).sendKeys(sobrenome);
    }

    public void adicionarEmail(String email, String campo) {
        Hooks.getDriver().findElement(By.cssSelector("[data-test='email']")).sendKeys(email);
    }

    public void selecionarAssunto(String assunto) {
        WebElement select = Hooks.getDriver().findElement(By.cssSelector("[data-test='subject']"));
        new Select(select).selectByVisibleText(assunto);
    }

    public void adicionarMensagem(String mensagem, String campo) {
        Hooks.getDriver().findElement(By.cssSelector("[data-test='message']")).sendKeys(mensagem);
    }

    public void clicarNoBotao(String send) {
        Hooks.getDriver().findElement(By.cssSelector("[data-test='contact-submit']")).click();
    }

    public boolean mensagemEnviadaComSucesso(String mensagem) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        WebElement confirmacao = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));
        return confirmacao.isDisplayed();
    }
}