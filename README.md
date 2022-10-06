<h1 align="center">
  Alticci Sequence
</h1>

<h4 align="center">
	🚧 Concluído 🚧
</h4>

Tabela de conteúdos
=================

* [Sobre o projeto](#-sobre-o-projeto)
* [Como executar o projeto](#-como-executar-o-projeto)
    * [Pré-requisitos](#pré-requisitos)
    * [Rodando o projeto](#-rodando-o-projeto)
* [Tecnologias](#-tecnologias)
* [Autor](#-autor)
* [Licença](#-licença)


## 💻 Sobre o projeto

Sistema para interpretação de strings para geração de relatório.

---

## 🚀 Como executar o projeto

### Pré-requisitos

- [Git](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/)
- [JDK 17.0.4.1 LTS](https://adoptium.net/)
- [NodeJs 16.17.1 LTS](https://nodejs.org/)

#### 🎲 Rodando o projeto backend

```bash
# Clone este repositório
$ git clone git@github.com:Ellian-aragao/alticci-sequence.git

# Acesse a pasta do projeto no terminal/cmd
$ cd alticci-sequence/backend

# Instale as dependências
$ mvn install

# Execute a aplicação
$ mvn quarkus:dev

```

#### 🎲 Rodando o projeto frontend

```bash
# Clone este repositório
$ git clone git@github.com:Ellian-aragao/alticci-sequence.git

# Acesse a pasta do projeto no terminal/cmd
$ cd alticci-sequence/frontend

# Instale as dependências
$ npm install

# Execute a aplicação
$ npm start

```

#### 🎲 Rodando o projeto completo via docker-compose

```bash
# Clone este repositório
$ git clone git@github.com:Ellian-aragao/alticci-sequence.git

# Acesse a pasta do projeto no terminal/cmd
$ cd alticci-sequence

# rode o docker-compose
$ docker-compose up


```


---

## 🛠 Tecnologias

Para linguagem de programação, fora utilizado o java em sua versão 17 por ser a
versão mais atual LTS.

O projeto foi desenvolvido utilizando o backend em [Quarkus](https://quarkus.io/),
através da stack reativa provida pelo framework, em questão de implementação,
fora seguido alguns padrões de arquitetura como clean code.

Para solução de cache, fora utilizado o banco [Redis](https://redis.io/) devido
suas características de alta performance.

Para frontend fora utilizado o framework [Angular](https://angular.io/)

---

## 🦸 Autor


 <img style="border-radius: 50%;" src="https://avatars1.githubusercontent.com/u/52057913?s=400&u=222dffcab5586f0eb4efcbff06caa868450f6b8a&v=4" width="100px;" alt=""/>
 <br />
 <a><sub><b>Ellian Aragão Dias</b></sub></a>
 <br />
 
[![Linkedin Badge](https://img.shields.io/badge/-Ellian-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/ellian-arag%C3%A3o-dias-22192a159/)](https://www.linkedin.com/in/ellian-arag%C3%A3o-dias-22192a159/)
[![Gmail Badge](https://img.shields.io/badge/-ellian.aragao@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:ellian.aragao@gmail.com)](mailto:ellian.aragao@gmail.com)

---

## 📝 Licença

Este projeto esta sobe a licença [MIT](./LICENSE).

Feito com ❤️ por Ellian Aragão Dias 👋🏽 [Entre em contato!](https://www.linkedin.com/in/ellian-arag%C3%A3o-dias-22192a159/)

---