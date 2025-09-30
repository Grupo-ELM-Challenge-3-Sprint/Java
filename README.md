# Java

Repositório de Java

Código SQL Developer:

CREATE TABLE consulta ( 
     id_consulta      NUMBER (8)  NOT NULL , 
     medicamento      VARCHAR2 (50)  NOT NULL , 
     prescricao       VARCHAR2 (200)  NOT NULL , 
     paciente_id_paci NUMBER (3)  NOT NULL
);

ALTER TABLE consulta 
    ADD CONSTRAINT consulta_PK PRIMARY KEY ( id_consulta, paciente_id_paci );

CREATE TABLE paciente( 
     id_paci NUMBER (3)  NOT NULL , 
     nm_paci VARCHAR2 (40)  NOT NULL , 
     cpf     NUMBER (11)  NOT NULL , 
     senha   VARCHAR2 (10)  NOT NULL
);

ALTER TABLE paciente 
    ADD CONSTRAINT paciente_PK PRIMARY KEY ( id_paci );

CREATE TABLE receita( 
     id_receita       NUMBER (8)  NOT NULL , 
     nome_med         VARCHAR2 (50)  NOT NULL , 
     horario          DATE  NOT NULL , 
     local            VARCHAR2 (50) , 
     observacao       VARCHAR2 (50) , 
     paciente_id_paci NUMBER (3)  NOT NULL
);

ALTER TABLE receita 
    ADD CONSTRAINT receita_PK PRIMARY KEY ( id_receita, paciente_id_paci );

ALTER TABLE consulta 
    ADD CONSTRAINT consulta_paciente_FK FOREIGN KEY 
    ( 
     paciente_id_paci
    ) 
    REFERENCES paciente 
    ( 
     id_paci
    );

ALTER TABLE receita 
    ADD CONSTRAINT receita_paciente_FK FOREIGN KEY 
    ( 
     paciente_id_paci
    ) 
    REFERENCES paciente 
    ( 
     id_paci
    );
