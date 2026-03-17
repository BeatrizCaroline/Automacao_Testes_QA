package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.util.Hooks;

import java.time.Duration;

public class CarrinhoPage extends BasePage {

    public CarrinhoPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Hooks.getDriver(), 10), this);
    }

    public boolean apresentouProdutoEsperadoNoCarrinho(String nomeProduto) {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
            wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("[data-test='product-title']")
                )
            );
            String textoProduto = Hooks.getDriver()
                .findElement(By.cssSelector("[data-test='product-title']"))
                .getText()
                .trim();

            if (textoProduto.contains(nomeProduto)) {
                log("Apresentou o produto [" + nomeProduto + "] no carrinho conforme esperado.");
                return true;
            }
        } catch (Exception e) {

        }
        logFail("Deveria ter apresentado o produto [" + nomeProduto + "] no carrinho.");
        return false;
    }

    public boolean apresentouQuantidadeEsperadaNoCarrinho(String nomeProduto, String quantidade) {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
            WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("[data-test='product-quantity']")
                )
            );
            String valorAtual = input.getAttribute("value");
            if (quantidade.equals(valorAtual)) {
                log("Produto [" + nomeProduto + "] com quantidade [" + quantidade + "] conforme esperado.");
                return true;
            }
        } catch (Exception e) {

        }
        logFail("Quantidade esperada [" + quantidade + "] não encontrada no carrinho.");
        return false;
    }
}