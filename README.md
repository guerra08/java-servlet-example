# java-servlet-example

Um exemplo de aplicação Java EE utilizando Servlet e Jetty.

### Execução

 - Clonar o repositório em um diretório de sua escolha
 - Acessar o diretório em um terminal / prompt
 - Execute `./mvnw install` e em seguida `./mvnw jetty:run`
 
### A aplicação

O servlet executa em **localhost:8080** e possui os seguintes **endpoints**:

 - **GET** /users -- Retorna uma lista de usuários cadastrados e sua chave identificadora
 - **GET** /users/{id} -- Retorna as informações de um usuário dado seu ID
 - **POST** /users -- Cadastra um usuário. Request body no formato JSON`{"id": 1, "name": "John"}`
 - **DELETE** /users/{id} -- Deleta um usuário dado o seu ID
 