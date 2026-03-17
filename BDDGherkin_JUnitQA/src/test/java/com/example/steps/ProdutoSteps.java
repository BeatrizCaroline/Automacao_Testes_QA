package com.example.steps;

import org.junit.jupiter.api.Assertions;

import com.example.pages.CarrinhoPage;
import com.example.pages.ResultadoPesquisaPage;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class ProdutoSteps {

    @E("^acessa o produto \"(.*)\"$")
    public void acessarProduto(String nomeProduto) {
        ResultadoPesquisaPage resultadoPesquisaPage = new ResultadoPesquisaPage();
        resultadoPesquisaPage.acessarProduto(nomeProduto);
    }

    @E("^aumenta a quantidade para \"(.*)\"$")
    public void aumentarQuantidade(String quantidade) {
        ResultadoPesquisaPage resultadoPesquisaPage = new ResultadoPesquisaPage();
        resultadoPesquisaPage.alterarQuantidade(quantidade);
    }

    @Entao("^o produto  \"(.*)\" deve possuir a quantidade \"(.*)\" no carrinho$")
    public void verificarQuantidadeNoCarrinho(String nomeProduto, String quantidade) {
        CarrinhoPage carrinhoPage = new CarrinhoPage();
        Assertions.assertTrue(
            carrinhoPage.apresentouQuantidadeEsperadaNoCarrinho(nomeProduto, quantidade),
            "Deveria ter a quantidade [" + quantidade + "] para o produto [" + nomeProduto + "] no carrinho"
        );
    }
}
