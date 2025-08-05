# API de Registro de Veículos

API RESTful para o gerenciamento de um cadastro de veículos, desenvolvida com Java e Spring Boot. Este projeto demonstra a implementação de uma arquitetura de software robusta, seguindo as melhores práticas do mercado para a construção de serviços back-end.

## Features Implementadas

* **API RESTful Completa:** Operações de CRUD (Criar, Ler, Atualizar, Deletar) para veículos.
* **Arquitetura em Camadas:** Lógica de negócio (Service), acesso a dados (Repository) e controle de requisições (Controller) totalmente desacoplados.
* **Padrão DTO:** Utilização de Data Transfer Objects (`RequestDTO` e `ResponseDTO`) para garantir um contrato de API seguro e desacoplado do modelo de dados interno.
* **Validação de Dados:** Validação robusta dos dados de entrada utilizando o `spring-boot-starter-validation` para garantir a integridade dos dados.
* **Tratamento de Exceções Centralizado:** Um manipulador de exceções global (`@RestControllerAdvice`) que fornece respostas de erro claras e com os códigos de status HTTP corretos (404, 409, 500).
* **Gestão de Segredos:** As credenciais do banco de dados são gerenciadas de forma segura através de variáveis de ambiente, não expostas no código-fonte.
* **Persistência de Dados:** Integração com banco de dados relacional PostgreSQL através do Spring Data JPA e Hibernate.

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.5.4**
* **Spring Data JPA** & **Hibernate**
* **PostgreSQL**
* **Maven**
* **Lombok**

## Pré-requisitos para Execução

* Java 21 ou superior instalado.
* Maven instalado.
* Uma instância do PostgreSQL a correr localmente ou num container Docker.

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/eduardo-ml/registro-de-veiculos-springboot.git
    ```
2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no PostgreSQL chamado `registro-de-veiculos-db`.
    * Configure as seguintes variáveis de ambiente na sua IDE ou no seu sistema operacional para conectar ao seu banco de dados:
        * `DB_URL` (ex: `jdbc:postgresql://localhost:5432/registro-de-veiculos-db`)
        * `DB_USERNAME` (ex: `postgres`)
        * `DB_PASSWORD` (ex: `sua-senha-segura`)

3.  **Execute a aplicação:**
    * Navegue até o diretório raiz do projeto e execute o comando:
    ```bash
    mvn spring-boot:run
    ```
4.  A API estará disponível em `http://localhost:8080`.

## Endpoints da API

A seguir estão os endpoints disponíveis na API, baseados no `VeiculoController.java`.

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/veiculos` | Registra um novo veículo. |
| `GET` | `/veiculos` | Lista todos os veículos cadastrados. |
| `GET` | `/veiculos/{id}` | Busca um veículo específico pelo seu ID. |
| `PUT` | `/veiculos/{id}` | Atualiza os dados de um veículo existente. |
| `DELETE`| `/veiculos/{id}` | Exclui um veículo do registro. |