CREATE TABLE IF NOT EXISTS receita (
    id UUID PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    modo_preparo TEXT,
    categoria VARCHAR(50),
    tipo_receita VARCHAR(20)
);

