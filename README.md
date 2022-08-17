
# Tudo de bom

API para a loja Tudo de Bom gerenciar suas transações.
O sistema deve permite cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque.



## Documentação da API

#### Retorna todos os clientes

```http
  GET /clients
```

#### Retorna um cliente

```http
  GET /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


#### Cadastra um cliente

```http
  POST /clients
```

#### Atualiza um cliente

```http
  PUT /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |



#### Deleta um cliente

```http
  DELETE /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


#### Retorna todos os produtos

```http
  GET /products
```

#### Retorna um produto

```http
  GET /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


#### Cadastra um produto

```http
  POST /products
```

#### Atualiza um produto

```http
  PUT /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |



#### Deleta um produto

```http
  DELETE /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


#### Retorna todas as entradas

```http
  GET /products/inputs
```


#### Retorna uma entrada

```http
  GET /products/${idProduct}/inputs
```

| Parâmetro   | Tipo       | Descrição                                                    |
| :---------- | :--------- |:-------------------------------------------------------------|
| `idProduct`      | `Long` | **Obrigatório**. O ID do produto que você quer ver a entrada |


#### Atualiza uma entrada

```http
  PUT /products/${idProduct}/inputs
```

| Parâmetro   | Tipo       | Descrição                                                          |
| :---------- | :--------- |:-------------------------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. O ID do produto que você quer atualizar a entrada |


#### Retorna todas as saídas

```http
  GET /products/outputs
```

#### Retorna uma saída

```http
  GET /products/{idProduct}/outputs
```

| Parâmetro   | Tipo       | Descrição                                                    |
| :---------- | :--------- |:-------------------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. O ID do produto que você quer obter a saída |


#### Atualiza uma saída

```http
  PUT /inputs/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


