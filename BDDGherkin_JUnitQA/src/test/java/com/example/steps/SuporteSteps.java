package com.example.steps;

import org.junit.jupiter.api.Assertions;

import com.example.pages.SuportePage;
import com.example.util.Hooks;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

public class SuporteSteps {

	
    @Dado("^que um usuario acessa a página de contato \"(.*)\"$")
	public void acessarPaginaContato(String url) {
		Hooks.navigateToURLEdge(url);
	}

	@E("^adiciona o primeiro nome \"(.*)\" no campo \"(.*)\"$")
	public void adicionarPrimeiroNome(String nome, String campo) {
		SuportePage suportePage = new SuportePage();
		suportePage.adicionarPrimeiroNome(nome, campo);
	}

	@E("^adiciona o sobrenome \"(.*)\" no campo \"(.*)\"$")
	public void adicionarSobrenome(String sobrenome, String campo) {
		SuportePage suportePage = new SuportePage();
		suportePage.adicionarSobrenome(sobrenome, campo);
	}

    @E("^adiciona o email \"(.*)\" no campo \"(.*)\"$")
	public void adicionarEmail(String email, String campo) {
		SuportePage suportePage = new SuportePage();
		suportePage.adicionarEmail(email, campo);
	}

    @E("^seleciona o assunto \"(.*)\" no campo \"(.*)\"$")
	public void selecionarAssunto(String assunto, String campo) {
		SuportePage suportePage = new SuportePage();
		suportePage.selecionarAssunto(assunto);
	}

    @E("^adiciona a mensagem \"(.*)\" no campo \"(.*)\"$")
	public void adicionarMensagem(String mensagem, String campo) {
		SuportePage suportePage = new SuportePage();
		suportePage.adicionarMensagem(mensagem, campo);
	}

    @Quando("^clico no botão \"(.*)\"$")
	public void clicarNoBotao(String send) {
		SuportePage suportePage = new SuportePage();
		suportePage.clicarNoBotao(send);
	}

    @Entao("^a mensagem \"(.*)\" deve ser enviada com sucesso$")
    public void verificarEnvioDeMEnsagem(String mensagem) {
        SuportePage suportePage = new SuportePage();
        Assertions.assertTrue(
            suportePage.mensagemEnviadaComSucesso(mensagem),
            "A mensagem não foi enviada com sucesso"
        );
    }
}
