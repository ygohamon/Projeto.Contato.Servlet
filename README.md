# Projeto.Contato.Servlet
Banco de Dados usado MySql
---------------------------------------------------
Codigo do Banco: >>>

CREATE DATABASE BASE;
USE BASE;
CREATE TABLE CONTATO(
  ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NOME VARCHAR(200) NOT NULL,
  EMAIL VARCHAR(200) NOT NULL,
  TELEFONE VARCHAR(200) NOT NULL
);
