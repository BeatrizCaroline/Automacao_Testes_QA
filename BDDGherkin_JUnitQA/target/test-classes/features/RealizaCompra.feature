#language: pt
#encoding: utf-8

@Test
Funcionalidade: Realizar Compra no E-commerce

	Como um comprador
	Quero ver a lista de produtos disponiveis
	Para que eu possa escolher qual devo comprar
		
  Cenario: Adicionar produto ao carrinho
  	Dado que um usuario acessa o site "https://practicesoftwaretesting.com"
  	E pesquisa pelo produto "Pliers"
  	Quando adiciona o produto "Pliers" ao carrinho
  	Entao o produto "Pliers" deve estar presente no carrinho

  Cenario: Aumentar a quantidade de produtos através do detalhes do produto
    Dado que um usuario acessa o site "https://practicesoftwaretesting.com"
  	E pesquisa pelo produto "Pliers"
	E acessa o produto "Pliers"
	E aumenta a quantidade para "2"
	Quando adiciona o produto "Pliers" ao carrinho
	Entao o produto  "Pliers" deve possuir a quantidade "2" no carrinho
