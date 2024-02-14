
# Biblioteca Digital

API desenvolvida para a interface da Biblioteca Digital

## Instalação

Realize o download do projeto com o comando:

```bash
git clone https://https://github.com/renan-auer/library-api
```

Foi utilizado banco de dados H2 para o desenvolvimento. Caso deseje utilizar outro banco será necessário alterar as propriedades no arquivo:


```bash
  \src\main\resources\application.properties
```

Após executar o projeto, o Spring JPA irá criar as tabelas necessárias na base de dados e em seguinda a API está disponível no seguinte endereço:

```bash
    http://localhost:8080/v1
```

Além disso, uma documentação com Swagger estará disponível no endereço:

```bash
  http://localhost:8080/swagger-ui.html#
```

## Gerando artefato para deploy

Para gerar o artefato para deploy rode o seguinte comando

```bash
  nvm package
```

