CREATE TABLE filme (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    preco NUMERIC(10,2) NOT NULL,
    distribuidora VARCHAR(100) NOT NULL,
    poster TEXT NOT NULL,
    duracao INTEGER NOT NULL,
    genero VARCHAR(30) NOT NULL,
    classificacao VARCHAR(5) NOT NULL,
    ano_lancamento INTEGER NOT NULL,

    CHECK (preco > 0),
    CHECK (duracao > 0),
    CHECK (TRIM(titulo) <> ''),
    CHECK (TRIM(distribuidora) <> ''),
    CHECK (TRIM(poster) <> ''),
    CHECK (classificacao IN ('Livre', '10+', '12+', '14+', '16+', '18+'))
);

INSERT INTO filme (
    titulo,
    preco,
    distribuidora,
    poster,
    duracao,
    genero,
    classificacao,
    ano_lancamento
)
VALUES
(
    'Homem aranha um novo dia',
    15.50,
    'Disney',
    'https://posters.onesheet.org/posters/current/2026/spider-man-brand-new-day-2026-us-character.jpg',
    260,
    'Ação',
    'Livre',
    2026
),
(
    'Clube da Luta',
    9.48,
    'Fox Film',
    'https://filmartgallery.com/cdn/shop/files/Fight-Club-Vintage-Movie-Poster-Original_0b916796_600x.jpg?v=1771985205',
    159,
    'Drama',
    '14+',
    1999
),
(
    'Matrix',
    12.53,
    'Warner Bros',
    'https://cdn.posteritati.com/posters/000/000/060/148/the-matrix-md-web.jpg',
    136,
    'Ficção científica',
    '16+',
    2003
);
