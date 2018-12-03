create table usuario(
    codigo integer identity not null primary key,
    nome varchar(100),
    sobrenome varchar(100),
    email varchar(100),
    data_nascimento date,
    sexo char(1),
    cpf varchar(20),
    estado_civil char(1),
    renda_mensal numeric,
    login varchar(100), 
    senha varchar(100),
    UNIQUE (login)
);

create table tipo_movimentacao (
    codigo integer identity not null primary key,
    descricao varchar(100) not null,
    observacao varchar(100),
    codigo_usuario integer not null,
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);

create table movimentacao(
    codigo integer identity not null primary key,
    descricao varchar(100) not null,
    situacao char(1) not null,
    data timestamp not null,
    valor numeric not null,
    repetir char(1) not null,
    codigo_tipo_movimentacao integer not null,
    codigo_usuario integer not null,
    FOREIGN KEY (codigo_tipo_movimentacao) REFERENCES tipo_movimentacao(codigo),    
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo)
);

