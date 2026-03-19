#language: pt
#encoding: utf-8'

@Test
Funcionalidade: Reportar Problema para o Suporte

	Como um usuário
	Quero reportar um problema para o suporte
	Para que eu possa sober como resolver o problema ou obter ajuda
		
  Cenario: Acessar a página de contato do suporte
  	Dado que um usuario acessa a página de contato "https://practicesoftwaretesting.com/contact"
  	E adiciona o primeiro nome "Beatriz" no campo "First name"
  	E adiciona o sobrenome "Reis" no campo "Last name"
    E adiciona o email "beatriz.teste@exemplo.com" no campo "Email address"
    E seleciona o assunto "Customer service" no campo "Subject"
    E adiciona a mensagem "Olá, estou com um problema e preciso de ajuda com meu pedido." no campo "Message"
    Quando clico no botão "Send"
  	Entao a mensagem "Estou enfrentando um problema com meu pedido." deve ser enviada com sucesso