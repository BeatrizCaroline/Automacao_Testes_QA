package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.example.util.Hooks;

public class HomePage extends BasePage {

    @FindBy(css = "[data-test='search-query']")
    protected WebElement campoBusca;

    @FindBy(css = "[data-test='search-submit']")
    protected WebElement botaoLupaBuscar;

    public void pesquisarProduto(String nomeProduto) {
        PageFactory.initElements(
                new AjaxElementLocatorFactory(Hooks.getDriver(), 10), this);
        campoBusca.sendKeys(nomeProduto);
        botaoLupaBuscar.click();
        log("Pesquisou pelo produto: " + nomeProduto);
    }
}
