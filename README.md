# Java

Repositório de Java

Código SQL Developer:

CREATE TABLE ddd_cliente(
    id_cliente NUMBER(6) NOT NULL PRIMARY KEY,
    cpf NUMBER(11) NOT NULL,
    nome VARCHAR2(50) NOT NULL,
    senha VARCHAR2(20) NOT NULL
)

CREATE TABLE ddd_receita(
    id_receita NUMBER(8) NOT NULL PRIMARY KEY,
    id_cliente number(6) NOT NULL,
    medicamento VARCHAR2(50) NOT NULL,
    prescricao VARCHAR2(250) NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES ddd__cliente(id_cliente)
)

CREATE TABLE ddd_receita(
    id_consulta NUMBER(8) NOT NULL PRIMARY KEY,
    id_cliente number(6) NOT NULL,
    nome_med VARCHAR2(50) NOT NULL,
    horario TIMESTAMP NOT NULL,
    local VARCHAR2(100) NOT NULL,
    observacao VARCHAR2(100),
    FOREIGN KEY(id_cliente) REFERENCES ddd__cliente(id_cliente)
)
