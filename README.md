# Projeto Spring Boot - Formação DevSuperior

Este repositório contém o desenvolvimento de uma API REST robusta, seguindo os padrões de mercado e as melhores práticas de engenharia de software ensinadas pelo Prof. Nelio Alves na plataforma DevSuperior.

## 🛠️ Tecnologias e Conceitos Aplicados

Até o momento, o projeto cobre os seguintes pilares do ecossistema Java Spring:

### 1. Arquitetura e Injeção de Dependência
* Organização do projeto em camadas: **Web (Controllers)**, **Service** e **Repository**.
* Gerenciamento de componentes e acoplamento fraco através da Injeção de Dependência nativa do Spring.

### 2. Modelo de Domínio e Persistência (ORM)
* Mapeamento objeto-relacional utilizando **JPA/Hibernate**.
* Criação de entidades complexas e associações entre tabelas do banco de dados.

### 3. API REST e Tratamento de Dados
* Implementação completa de **CRUD** (Create, Read, Update, Delete).
* Uso de **DTOs (Data Transfer Objects)** para otimizar a transferência de dados e segurança da API.
* Validação de dados de entrada com **Bean Validation**.
* Tratamento global de exceções customizadas, garantindo respostas HTTP semânticas.

### 4. Consultas e Performance
* Domínio de consultas **SQL e JPQL** para buscas otimizadas.
* Implementação de paginação e ordenação de resultados para alta performance.

### 5. Segurança e Controle de Acesso (Em andamento)
* Autenticação e Autorização com **Spring Security**.
* Implementação de fluxo de Login e níveis de acesso baseados em perfis de usuário.

---

## 🚀 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)
   ```
2. Importe o projeto em sua IDE (STS ou IntelliJ).

3 .Execute a aplicação como Spring Boot App.

Acesse o console do H2 (se configurado) em: http://localhost:8080/h2-console
