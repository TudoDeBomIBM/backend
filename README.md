
# Tudo de bom

API para a loja Tudo de Bom gerenciar suas transações.
O sistema deve permite cadastro de novos clientes, incluindo dados pessoais, dados para contato e controle de estoque.



## Documentação da API

#### Retorna todos os clientes

```http
  GET /clients
```

## Demonstração
<p> <a href="https://www.ibm.com/br-pt"><img src="src/assets/16-08-2022-04-21.gif"></a> </p>


#### Retorna um cliente

```http
  GET /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


## Demonstração


#### Cadastra um cliente

```http
  POST /clients
```

## Demonstração

<p> <a href="https://www.ibm.com/br-pt"><img src="src/assets/16-08-2022-03-36.gif"></a> </p>


#### Atualiza um cliente

```http
  PUT /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |



## Demonstração

#### Deleta um cliente

```http
  DELETE /clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |


## Demonstração

#### Retorna todos os produtos

```http
  GET /products
```

## Demonstração

#### Retorna um produto

```http
  GET /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |

## Demonstração

#### Cadastra um produto

```http
  POST /products
```

## Demonstração


#### Atualiza um produto

```http
  PUT /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |

## Demonstração


#### Deleta um produto

```http
  DELETE /products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |

## Demonstração

#### Retorna todas as entradas

```http
  GET /products/inputs
```
## Demonstração


#### Retorna uma entrada

```http
  GET /products/${idProduct}/inputs
```

| Parâmetro   | Tipo       | Descrição                                                    |
| :---------- | :--------- |:-------------------------------------------------------------|
| `idProduct`      | `Long` | **Obrigatório**. O ID do produto que você quer ver a entrada |

## Demonstração

#### Atualiza uma entrada

```http
  PUT /products/${idProduct}/inputs
```

| Parâmetro   | Tipo       | Descrição                                                          |
| :---------- | :--------- |:-------------------------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. O ID do produto que você quer atualizar a entrada |

## Demonstração


#### Retorna todas as saídas

```http
  GET /products/outputs
```
## Demonstração


#### Retorna uma saída

```http
  GET /products/{idProduct}/outputs
```

| Parâmetro   | Tipo       | Descrição                                                    |
| :---------- | :--------- |:-------------------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. O ID do produto que você quer obter a saída |

## Demonstração

#### Atualiza uma saída

```http
  PUT /inputs/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | **Obrigatório**. O ID do cliente que você quer |

## Demonstração

