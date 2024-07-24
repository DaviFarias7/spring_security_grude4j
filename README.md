# Authentication API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

Projeto criado para demonstrar no evento 23º Meet Up da comunidade Grude4J (Instagram: https://www.instagram.com/grude4joficial/ site: https://grude4j.github.io/grude4jsite/) a implementação padrão da autenticação, autorização e definição de permissões de usuários utilizando Spring Security com Token JWT. Nesta aplicação foram criados dois tipos de usuários, sendo um 
com a role "ADMIN" (Que possui a permissão de acessar todos os endpoints do tipo POST e GET) e outro com a role "USER"(Acessa apenas os endpoints do tipo GET). 


## <img align="center" alt="Alan-CSS" height="30" width="40" src="https://github.com/tandpfun/skill-icons/blob/main/icons/Spring-Dark.svg">  Requisitos
- Java 17
- Postgress
- Spring Boot
- Dependências: Spring Security, Java JWT, Flyway


## Criação do banco de dados Postgress

- No PG Admin crie uma Database com o nome de "product"

- Configure sua conexão com o bando no PG Admin e adicione as configurações no arquivo application.properties da sua aplicação:

```
spring.application.name=grude4j

spring.datasource.url=jdbc:postgresql://localhost:5432/product
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SEU_PASSWORD

api.security.token.secret=${JWT_SECRET:my-secret-key}

```
- A criação das tabelas "product" e "users" é feita pelos scripts SQL salvos nos aqruivos V1_create-product-table.sql e V2_create-table-users.sql quando a aplicação é iniciada.

```
CREATE TABLE product (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    price INTEGER NOT NULL
);
```
```
CREATE TABLE users (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);
```

## Executando o Serviço Localmente

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute `./mvnw spring-boot:run`

## Endpoints

- `POST /auth/register` - Cria um novo usuário
  
Exemplo de teste de ciração de usuários:
```
{
    "login": "admin",
    "password": "123456",
    "role": "ADMIN"
}
```


```
{
    "login": "user",
    "password": "123456",
    "role": "USER"
}
```
  
- `POST /auth/register` - Efetua o login na aplicação e gera o Token JWT para ser utilizado como Bearer Token nos outros endpoints
- `GET /auth/users` - Lista todos os usuários cadastrados (Apenas usuário com a role "ADMIN" pode executar)
- `GET /product` - Lista todos os produtos cadastrados
- `POST /product` - Cadastra um novo produto (Apenas usuário com a role "ADMIN" pode executar)
- `DELETE /product` - Deleta um produto pelo id (Apenas usuário com a role "ADMIN" pode executar) 

## Configuração de Produção

Para colocar em produção, você pode usar qualquer plataforma de sua escolha. Certifique-se de configurar corretamente as variáveis de ambiente para o Postgres.
