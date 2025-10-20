# SimpleToDoListApi

API RESTful para gerenciamento simples de tarefas (ToDo). Implementada em Java com Spring Boot, seguindo uma separação inspirada em Clean Architecture (domínio, casos de uso, infraestrutura).

## Descrição
Projeto exemplo de lista de tarefas com:
- Entidades: `Person`, `Task`, `TaskSharing`
- Casos de uso em `src/main/java/dev/elberjsn/todoapi/core` e `infrastructure/usercase`
- Controle de acesso via JWT em `src/main/java/dev/elberjsn/todoapi/infrastructure/security`
- Mapeamento e persistência JPA com migrações Flyway em `src/main/resources/db/migrations`

## Tecnologias
- Java
- Spring Boot
- Maven
- JPA / Hibernate
- Flyway (migrações)
- JWT (autenticação)
- Banco de dados SQL (configurar em `application.yml`)

## Arquitetura
O projeto organiza responsabilidades em camadas:
- `core/domain` — modelos de domínio e enums
- `core/exceptions` — exceções de negócio
- `infrastructure/usercase` — casos de uso/portas (CRUD, login, validações)
- `infrastructure/controllers` — controllers HTTP (person, task, sharing)
- `infrastructure/persistence` — repositorios JPA, mappers e config
- `infrastructure/security` — configuração JWT e filtros

Essa separação facilita testes e manutenção e aproxima-se do conceito de Clean Architecture.

## Estrutura principal (resumida)
- `src/main/java/dev/elberjsn/todoapi/SimpleToDoListApiApplication.java`
- `src/main/java/dev/elberjsn/todoapi/core/...`
- `src/main/java/dev/elberjsn/todoapi/infrastructure/controllers/person/PersonController.java`
- `src/main/java/dev/elberjsn/todoapi/infrastructure/controllers/task/TaskController.java`
- `src/main/java/dev/elberjsn/todoapi/infrastructure/controllers/sharing/TaskSharingController.java`
- `src/main/resources/db/migrations` (Flyway)
- `src/main/resources/application.yml`

## Como rodar localmente

Pré-requisitos:
- Java (11+ ou versão compatível com o projeto)
- Maven
- Banco de dados (configurar em `application.yml` — ex.: PostgreSQL)

Passos:
1. Ajustar conexão do banco em `src/main/resources/application.yml`.
2. Rodar migrações Flyway (ocorrem automaticamente no startup).
3. Build e execução:
    - Build: `mvn clean package`
    - Executar: `mvn spring-boot:run` ou `java -jar target/<artifact>.jar`
4. Endpoints principais expostos pelos controllers em:
    - `infrastructure/controllers/person/PersonController.java`
    - `infrastructure/controllers/task/TaskController.java`
    - `infrastructure/controllers/sharing/TaskSharingController.java`

Observação: autenticação JWT é aplicada conforme `infrastructure/security/SecurityConfig.java`. Faça login via endpoint implementado no caso de uso `LoginPerson` para receber token.

## Testes
Executar testes unitários/integrados:
- `mvn test`

## Migrações
As migrações Flyway estão em `src/main/resources/db/migrations`. Elas serão executadas automaticamente na inicialização da aplicação, desde que a configuração do datasource esteja correta.

## Notas sobre desenvolvimento
- Implementações de porta/repositório ficam em `infrastructure/persistence/*RepositoryImpl`
- Casos de uso são organizados por domínio em `infrastructure/usercase/*`
- DTOs e mappers estão próximos aos controllers e entidades para separar transformação de dados

## Contribuição
- Abrir issues descrevendo bug ou feature
- Criar pull requests com commit pequenos e tests quando aplicável
