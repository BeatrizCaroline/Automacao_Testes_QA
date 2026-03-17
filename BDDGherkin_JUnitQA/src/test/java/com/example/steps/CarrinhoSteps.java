package com.example.steps;

import org.junit.jupiter.api.Assertions;

import com.example.pages.CarrinhoPage;

import io.cucumber.java.pt.Entao;

public class CarrinhoSteps {

    @Entao("^o produto \"(.*)\" deve estar presente no carrinho$")
    public void apresentouProdutoEsperadoNoCarrinho(String nomeProduto) {
        CarrinhoPage carrinhoPage = new CarrinhoPage();
        Assertions.assertTrue(
            carrinhoPage.apresentouProdutoEsperadoNoCarrinho(nomeProduto),
            "Deveria ter apresentado o produto [" + nomeProduto + "] no carrinho"
        );
    }

}