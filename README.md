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

**<h2 id="doc-api">Documentação da API</h2>**
<br />

**<h3>Volume</h3>**

| Requisição | Rota                        | Resposta                        |
| ---------- | --------------------------- | ------------------------------- |
| POST       | /volumes/novo               | criação de um volume            |
| GET        | /volumes/{id}               | recupera volume                 |
| PUT        | /volumes/{id}               | atualiza volume                 |
| DELETE     | /volumes/{id}               | deleta volume                   |
| GET        | /volumes/{idVolume}/artigos | lista artigos de um volume      |
| GET        | /volumes                    | lista dados de todos os volumes |
| GET        | volumes/artigos/{idArtigo}/autores | lista dados de todos os autores de artigos de um dado volume |

<br />

**<h3>Artigo</h3>**

| Requisição | Rota                        | Resposta                                                     |
| ---------- | --------------------------- | ------------------------------------------------------------ |
| POST       | /artigos/novo               | criação de um artigo                                         |
| GET        | /artigos/{id}               | recupera artigo                                              |
| PUT        | /artigos/{id}               | atualiza artigo                                              |
| DELETE     | /artigos/{id}               | deleta artigo                                                |

<br />

**<h3>Autor</h3>**

| Requisição | Rota               | Resposta            |
| ---------- | ------------------ | ------------------- |
| POST       | /autores/novo      | criação de um autor |
| GET        | /autores/{idAutor} | recupera autor      |
| PUT        | /autores/{idAutor} | atualiza autor      |
| DELETE     | /autores/{idAutor} | deleta autor        |
