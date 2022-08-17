
# Tudo de bom

API para a loja Tudo de Bom gerenciar suas transações.
O sistema deve permitir cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque.



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

#### Cadastra uma order

```http
  POST /order
```


#### Retorna todas as orders

```http
  GET /order
```


#### Retorna uma order

```http
  GET /orders/${id}
```

| Parâmetro   | Tipo       | Descrição                                                    |
| :---------- | :--------- |:-------------------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. O ID da order que você quer visualizar |



