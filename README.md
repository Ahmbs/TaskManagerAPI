# Task Manager API

API REST para gerenciamento de tarefas com autenticação JWT.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## Configuração do Ambiente

### Pré-requisitos

- Java 21 ou superior
- Maven
- PostgreSQL

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL chamado `taskmanager`
2. Configure as credenciais no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Executando a Aplicação

1. Clone o repositório
2. Execute o comando:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## Endpoints da API

### Autenticação

#### Registro de Usuário
```
POST /api/auth/register
Content-Type: application/json

{
    "username": "seu_usuario",
    "password": "sua_senha"
}
```

#### Login
```
POST /api/auth/login
Content-Type: application/json

{
    "username": "seu_usuario",
    "password": "sua_senha"
}
```

### Tarefas

#### Listar Tarefas
```
GET /api/tasks
Authorization: Bearer seu_token_jwt
```

Parâmetros de filtro opcionais:
- title: Filtrar por título
- assignee: Filtrar por responsável
- priority: Filtrar por prioridade (BAIXA, MEDIA, ALTA)
- status: Filtrar por status (EM_ANDAMENTO, CONCLUIDA)

#### Criar Tarefa
```
POST /api/tasks
Authorization: Bearer seu_token_jwt
Content-Type: application/json

{
    "title": "Título da Tarefa",
    "description": "Descrição da Tarefa",
    "assignee": "Responsável",
    "priority": "ALTA",
    "deadline": "DD-MM-YYYY"
}
```

#### Atualizar Tarefa
```
PUT /api/tasks/{id}
Authorization: Bearer seu_token_jwt
Content-Type: application/json

{
    "title": "Novo Título",
    "description": "Nova Descrição",
    "assignee": "Novo Responsável",
    "priority": "MEDIA",
    "deadline": "DD-MM-YYYY"
}
```

#### Marcar Tarefa como Concluída
```
PATCH /api/tasks/{id}/complete
Authorization: Bearer seu_token_jwt
```

#### Excluir Tarefa
```
DELETE /api/tasks/{id}
Authorization: Bearer seu_token_jwt
```

## Formato de Datas

Todas as datas na API seguem o formato `DD-MM-YYYY`.

## Segurança

- A API utiliza autenticação JWT
- Tokens expiram em 24 horas
- Todas as rotas, exceto `/api/auth/**`, requerem autenticação
- Senhas são armazenadas com hash seguro

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request 
