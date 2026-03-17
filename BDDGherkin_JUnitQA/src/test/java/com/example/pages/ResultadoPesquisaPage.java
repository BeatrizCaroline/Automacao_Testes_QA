package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.util.Hooks;

import java.time.Duration;

public class ResultadoPesquisaPage extends BasePage {

    @FindBy(css = "[data-test='add-to-cart']")
    protected WebElement botaoAdicionarAoCarrinho;

    public ResultadoPesquisaPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(Hooks.getDriver(), 10), this);
    }

    public void adicionarProdutoAoCarrinho(String nomeProduto) {
    WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));

    WebElement nomeProdutoTela = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@data-test='product-name' and normalize-space()='" + nomeProduto + "']")
        )
    );
    nomeProdutoTela.click();

    WebElement btnAddToCart = wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='add-to-cart']"))
    );
    btnAddToCart.click();

    WebElement btnCarrinho = wait.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='nav-cart']"))
    );
    btnCarrinho.click();

    log("Adicionou o produto [" + nomeProduto + "] ao carrinho");
    }

    public void acessarProduto(String nomeProduto) {
    WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
    WebElement nomeProdutoTela = wait.until(
        ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@data-test='product-name' and normalize-space()='" + nomeProduto + "']")
        )
    );
    nomeProdutoTela.click();
    log("Acessou o produto [" + nomeProduto + "]");
    }

    public void alterarQuantidade(String quantidade) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(15));
        WebElement campoQuantidade = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='quantity']"))
        );
        campoQuantidade.clear();
        campoQuantidade.sendKeys(quantidade);
        log("Alterou a quantidade para [" + quantidade + "]");
    }
}