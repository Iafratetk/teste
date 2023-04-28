INSERT INTO cliente (nome, tipo, cpf_cnpj, rg_ie, data_cadastro, ativo) 
VALUES ('Maria', 'Pessoa Física', '98765432101', '987654321', '2022-02-01', true);

INSERT INTO cliente_telefones (cliente_id, telefones) 
VALUES (1, '(11) 5555-5555'), (1, '(11) 6666-6666');

INSERT INTO cliente (nome, tipo, cpf_cnpj, rg_ie, data_cadastro, ativo) 
VALUES ('José', 'Pessoa Física', '55544433322', '555444333', '2022-03-01', true);

INSERT INTO cliente_telefones (cliente_id, telefones) 
VALUES (2, '(11) 7777-7777');
