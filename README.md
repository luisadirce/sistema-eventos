# Eventos - Sistema de cadastro de eventos científicos

<!--ts-->

- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Documentação da API](#doc-api)
  <!--te-->
  <br /><br />

<h2 id="sobre">Sobre</h2>
Este sistema foi desenvolvido para a disciplina de Desenvolvimento de Aplicações Corporativas oferecida pela UFF.

É composto pela entidade volume, que representa o agregado de artigos aceitos em um dado evento, pela entidade artigo e a entidade autor.
<br /><br />

<h2 id="tecnologias">Tecnologias </h2>

As seguintes ferramentas foram usadas na construção do projeto (e referências para entender um pouco de cada uma):

- [Java](https://www.devmedia.com.br/iniciando-na-linguagem-java/21136)
- [JPA](https://www.devmedia.com.br/introducao-a-jpa-java-persistence-api/28173)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [API Rest](https://rockcontent.com/br/blog/rest-api/)

<br />

**<h2 id="doc-api">Documentação</h2>**
<br />

**<h3>Index</h3>**

| Requisição | Rota | Resposta                        |
| ---------- | ---- | ------------------------------- |
| GET        | /    | lista dados de todos os volumes |


<br />

**<h3>Volume</h3>**

| Requisição | Rota                 | Resposta                        |
| ---------- | -------------------- | ------------------------------- |
| POST       | /createvolume        | criação de um volume            |
| GET        | /volume/{id}         | recupera volume                 |
| PUT        | /volume/edit/{id}    | atualiza volume                 |
| DELETE     | /volumes/delete/{id} | deleta volume                   |
| GET        | /volumes/{id}        | lista artigos de um volume      |
| GET        | /                    | lista dados de todos os volumes |


<br />

**<h3>Artigo</h3>**

| Requisição | Rota                 | Resposta                                                     |
| ---------- | -------------------- | ------------------------------------------------------------ |
| POST       | /createarticle       | criação de um artigo                                         |
| GET        | /article/{id}        | recupera artigo                                              |
| PUT        | /article/edit/{id}   | atualiza artigo                                              |
| DELETE     | /article/delete/{id} | deleta artigo                                                |
| GET        | article/{id}         | lista dados de todos os autores de artigos de um dado volume |

<br />

**<h3>Autor</h3>**

| Requisição | Rota                | Resposta            |
| ---------- | ------------------- | ------------------- |
| POST       | /createauthor       | criação de um autor |
| GET        | /author/{id}        | recupera autor      |
| PUT        | /author/edit/{id}   | atualiza autor      |
| DELETE     | /author/delete/{id} | deleta autor        |
