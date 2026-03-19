<div align="center">

```
╔══════════════════════════════════════════════════════════════╗
║                                                              ║
║          PORTFÓLIO DE AUTOMAÇÃO DE TESTES                    ║
║          BDD · TDD · Selenium · Spring Boot                  ║
║                                                              ║
╚══════════════════════════════════════════════════════════════╝
```


---

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-7.x-23D96C?style=for-the-badge&logo=cucumber&logoColor=white)

</div>

---

## Sobre este repositório

Este portfólio reúne dois projetos de automação de testes que cobrem perspectivas complementares da engenharia de qualidade, o olhar externo do usuário navegando numa aplicação web, e o olhar interno do desenvolvedor garantindo a saúde das regras de negócio via API.

```
+-----------------------------------+-----------------------------------+
|         PROJETO 1                                 PROJETO 2           |
|        -----------                               -----------          |
|   Automacao UI com BDD           ←→        Beer Stock API com TDD     |
|                                                                       |
|   Selenium + Cucumber                      Spring Boot + Mockito      |
|   Gherkin / Cenarios                       JUnit + Hamcrest           |
|   E-commerce (UI)                          REST API (Backend)         |
+-----------------------------------+-----------------------------------+
```

---

# Projeto 1 — Automação UI com BDD

<div align="center">

![BDD](https://img.shields.io/badge/Abordagem-BDD-blueviolet?style=flat-square)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=flat-square&logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-Gherkin-23D96C?style=flat-square&logo=cucumber)
![Site](https://img.shields.io/badge/Alvo-practicesoftwaretesting.com-0078D4?style=flat-square&logo=googlechrome)

</div>

> Automação de ponta a ponta de um e-commerce simulado, com cenários escritos em linguagem natural (Gherkin) que funcionam como documentação viva do sistema.

---

### Fluxo de Execução

```
+--------------+     +--------------+     +--------------+     +--------------+
|              |     |              |     |              |     |              |
|  .feature    |---> |    Steps     |---> |    Pages     |---> |  Navegador   |
|  (Gherkin)   |     |   (Java)     |     |    (POM)     |     |  (Selenium)  |
|              |     |              |     |              |     |              |
+--------------+     +--------------+     +--------------+     +--------------+
       |                                                               |
       |                    +---------------+                          |
       +------------------> |    Report     | <------------------------+
                            | (Extent HTML) |
                            +---------------+
```

---

### Estrutura do Projeto

```
BDDGHERKIN_JUNITQA/
│
├── src/test/
│   ├── java/com/example/
│   │   │
│   │   ├── pages/                      ◀ Page Object Model
│   │   │   ├── BasePage.java               Métodos e elementos comuns
│   │   │   ├── HomePage.java               Página inicial
│   │   │   ├── CarrinhoPage.java           Carrinho de compras
│   │   │   ├── ResultadoPesquisaPage.java  Resultados de busca
│   │   │   └── SuportePage.java            Formulário de suporte
│   │   │
│   │   ├── steps/                      ◀ Definições de passos Gherkin
│   │   │   ├── HomeSteps.java
│   │   │   ├── CarrinhoSteps.java
│   │   │   ├── ResultadoPesquisaSteps.java
│   │   │   └── SuporteSteps.java
│   │   │
│   │   ├── tests/
│   │   │   └── RunnerTest.java         ◀ Runner principal do Cucumber
│   │   │
│   │   └── util/
│   │       ├── Hooks.java              ◀ Setup/Teardown e screenshots
│   │       └── Utils.java             ◀ Utilitários compartilhados
│   │
│   └── resources/features/            ◀ Especificações em Gherkin
│       ├── RealizaCompra.feature
│       └── ContatoSuporte.feature
```

---

### Cenários Automatizados

| Feature | Cenário | Tipo |
|---|---|---|
| `RealizaCompra` | Busca produto pelo nome | Funcional |
| `RealizaCompra` | Adiciona produto ao carrinho | Funcional |
| `RealizaCompra` | Finaliza compra com sucesso | E2E |
| `ContatoSuporte` | Preenche e envia formulário de contato | Funcional |

---

### Stack Completa

| Camada | Tecnologia | Função |
|---|---|---|
| Linguagem | Java 21 | Runtime e implementação dos testes |
| Build | Maven | Gerenciamento de dependências e execução |
| Runner | JUnit 5 | Orquestração dos testes |
| Automação | Selenium WebDriver 4.x | Controle do navegador |
| BDD | Cucumber 7.x | Mapeamento Gherkin → Java |
| Relatórios | ExtentReports (aventstack) | Relatórios HTML interativos |
| Logs | SLF4J | Rastreamento de execução |

---

### Como Executar

```bash
# 1. Clonar o repositório
git clone <url-do-repositório>
cd BDDGHERKIN_JUNITQA

# 2. Executar todos os cenários
mvn test

# 3. Executar uma feature específica
mvn test -Dcucumber.options="src/test/resources/features/RealizaCompra.feature"

# 4. Relatório gerado em:
#    target/extent-reports/index.html
```

---

# Projeto 2 — Beer Stock API com TDD

<div align="center">

![TDD](https://img.shields.io/badge/Abordagem-TDD-red?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=flat-square&logo=springboot)
![Mockito](https://img.shields.io/badge/Mockito-Mock_Framework-green?style=flat-square)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=flat-square&logo=swagger)
![Postman](https://img.shields.io/badge/Postman-Collections-FF6C37?style=flat-square&logo=postman)

</div>

> Fork e extensão da [beer_api_digital_innovation_one](https://github.com/rpeleias-v1/beer_api_digital_innovation_one).  
> API REST de gerenciamento de estoque de cervejas desenvolvida com TDD, os testes guiaram a implementação.

---

### O Ciclo TDD aplicado neste projeto

```
        ┌─────────────────────────────────────────────┐
        │                                             │
        ▼                                             │
  ┌───────────┐                                       │
  │  VERMELHO │  Escrever o teste que FALHA           │
  │    (RED)  │  antes de qualquer implementação      │
  └─────┬─────┘                                       │
        │                                             │
        ▼                                             │
  ┌───────────┐                                       │
  │   VERDE   │  Implementar o MÍNIMO necessário      │
  │  (GREEN)  │  para o teste passar                  │
  └─────┬─────┘                                       │
        │                                             │
        ▼                                             │
  ┌───────────┐                                       │
  │REFATORAÇÃO│  Melhorar o código sem quebrar        │
  │ (REFACTOR)│  os testes existentes ─────────────── ┘
  └───────────┘

  Funcionalidades desenvolvidas com TDD:
  ✔ Incremento de estoque (com validação de capacidade máxima)
  ✔ Decremento de estoque (com validação de limite mínimo)
```

---

### Estrutura do Projeto

```
BEERAPI_JUNITQA/
│
├── postman/
│   └── Beer API.postman_collection.json    ◀ Coleção para testes manuais
│
├── src/
│   ├── main/java/com/example/beerstock/
│   │   │
│   │   ├── config/         SwaggerConfig.java
│   │   ├── controller/     BeerController.java
│   │   │                   BeerControllerDocs.java
│   │   ├── dto/            BeerDTO.java · QuantityDTO.java
│   │   ├── entity/         Beer.java
│   │   ├── enums/          BeerType.java
│   │   ├── exception/      BeerAlreadyRegisteredException.java
│   │   │                   BeerNotFoundException.java
│   │   │                   BeerStockExceededException.java
│   │   ├── mapper/         BeerMapper.java
│   │   ├── repository/     BeerRepository.java
│   │   └── service/        BeerService.java
│   │
│   └── test/java/com/example/beerstock/
│       ├── builder/        BeerDTOBuilder.java     ◀ Padrão Builder para fixtures
│       ├── controller/     BeerControllerTest.java ◀ Testes de camada HTTP
│       ├── service/        BeerServiceTest.java    ◀ Testes de regras de negócio
│       └── utils/          JsonConvertionUtils.java
```

---

### Endpoints da API

```
BASE URL: http://localhost:8080/api/v1/beers
```

| Método | Rota | Descrição | Status |
|---|---|---|---|
| `POST` | `/` | Criar nova cerveja | `201 Created` |
| `GET` | `/{name}` | Buscar cerveja por nome | `200 OK` |
| `GET` | `/list` | Listar todas as cervejas | `200 OK` |
| `DELETE` | `/{id}` | Excluir cerveja por ID | `204 No Content` |
| `PATCH` | `/{id}/increment` | Incrementar estoque | `200 OK` |

> Documentação interativa disponível em `http://localhost:8080/swagger-ui.html`

---

### Stack Completa

**Aplicação**

| Camada | Tecnologia |
|---|---|
| Framework principal | Spring Boot 3.x |
| Camada REST | Spring Web |
| Persistência | Spring Data JPA + H2 (em memória) |
| Validações de entrada | Spring Validation |
| Monitoramento | Spring Actuator |
| Documentação | Springdoc OpenAPI (Swagger UI) |
| Mapeamento DTO ↔ Entidade | MapStruct |
| Redução de boilerplate | Lombok |
| Serialização de datas | Jackson JSR310 |

**Testes**

| Ferramenta | Responsabilidade |
|---|---|
| JUnit 5 | Estrutura dos testes e asserções base |
| Mockito | Mock de repositórios e serviços |
| Hamcrest | Asserções fluentes e legíveis |
| Spring Boot Test + MockMvc | Testes de controller sem servidor real |
| Postman | Exploração manual e validação dos endpoints |

---

### Cobertura dos Testes Unitários

```
BeerServiceTest
 ├── ✔ Deve criar cerveja com sucesso
 ├── ✔ Deve lançar exceção ao criar cerveja já cadastrada
 ├── ✔ Deve listar todas as cervejas
 ├── ✔ Deve encontrar cerveja por nome
 ├── ✔ Deve lançar exceção quando cerveja não encontrada
 ├── ✔ Deve excluir cerveja por ID
 ├── ✔ [TDD] Deve incrementar estoque com sucesso
 ├── ✔ [TDD] Deve lançar exceção ao exceder capacidade máxima
 ├── ✔ [TDD] Deve decrementar estoque com sucesso
 └── ✔ [TDD] Deve lançar exceção ao decrementar abaixo do mínimo

BeerControllerTest
 ├── ✔ POST /beers deve retornar 201 ao criar cerveja válida
 ├── ✔ POST /beers deve retornar 400 ao enviar dados inválidos
 ├── ✔ GET /beers/{name} deve retornar 200 com cerveja encontrada
 ├── ✔ GET /beers/{name} deve retornar 404 quando não encontrada
 ├── ✔ DELETE /beers/{id} deve retornar 204
 └── ✔ PATCH /beers/{id}/increment deve retornar 200
```

---

### Como Executar

```bash
# 1. Clonar o repositório
git clone <url-do-repositório>
cd BEERAPI_JUNITQA

# 2. Executar todos os testes unitários
mvn test

# 3. Subir a aplicação localmente
mvn spring-boot:run

# 4. Acessar o Swagger UI
#    http://localhost:8080/swagger-ui.html

# 5. Importar a coleção no Postman
#    postman/Beer API.postman_collection.json
```

---

## Pré-requisitos

```
✔ Java JDK 21+
✔ Maven 3.8+
✔ Navegador compatível + WebDriver (Projeto 1)
✔ Postman (opcional, para testes manuais do Projeto 2)
```

---

<div align="center">

```
─────────────────────────────────────────────────────────────────
  Desenvolvido como portfólio de engenharia de qualidade de
  software, cobrindo automação de UI com BDD e testes de
  API com TDD — duas disciplinas essenciais para entregar
  software confiável com velocidade e consistência.
─────────────────────────────────────────────────────────────────
```

![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow?style=for-the-badge)
![QA](https://img.shields.io/badge/Área-Quality_Assurance-informational?style=for-the-badge)

</div>
