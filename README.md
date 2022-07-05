# Zappts_Magic_Project
-----

## Esse projeto visa criar organização nos decks de cartas, para usuários do jogo Magic-The-Gathering.

### Para executar o projeto, será necessário instalar os seguintes programas/plugins:

*[JDK 17: Necessário para executar a aplicação Java](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

*[Maven 3.6.3: Necessário para realizar o build da aplicação](https://maven.apache.org/download.cgi)

*[Insomnia: Utilizado para envio de requisições JSON e consumo das API's](https://insomnia.rest/download)

*[Docker: Utilizado para subir o container do Banco de Dados Mysql](https://www.docker.com/)

*[Eclipse](https://www.eclipse.org/downloads/) ou [Intellij](https://www.jetbrains.com/pt-br/idea/download/): IDE para desenvolvimento do projeto.

*[Mysql Workbench](https://dev.mysql.com/downloads/workbench/): Para visualização do Bando de Dados e das informações inseridas.

### Desenvolvimento

Para iniciar o desenvolvimento, é necessário clonar o projeto do GitHub num diretório de sua preferência:

Para subir o container Mysql no Docker utilize o dockerfile: $ docker run -e MYSQL_ROOT_PASSWORD=root --name *container_name* -d -p 3306:3306 mysql:latest

Altere o campo "active: 'prod' " para "active: 'dev'" no arquivo application.yml
para que a aplicação funcione localmente.

### API Doc

[API docs](http://localhost:8080/v2/api-docs)

[Swagger-Ui](http://localhost:8080/swagger-ui.html)
