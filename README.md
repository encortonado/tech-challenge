# Tech Challenge

## Índice
- [Sobre](#-sobre)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação e execução](#-instalação-e-execução)
- [Tecnologias](#-tecnologias)
- [Testes](#-testes)

## 💻 Sobre


## 🗂 Pré-requisitos
Para rodar o projeto precisa apenas ter instalado os softwares abaixo:
* Docker
* Docker Compose

Para desenvolvimento é necessário:
* Docker
* Docker Compose
* JDK 20

## 🔥 Instalação e execução -- DOCKER
Os comandos para instalar e rodar local o projeto, basta utilizar o script disponibilizado no projeto com os comandos abaixo:
```bash
# modo de desenvolvimento com live reload
$ ./run.sh dev

# modo de produção
$ ./run.sh production

# encerrar o projeto
$ ./run.sh stop
```

## 🔥 Instalação e execução -- KUBERNETES
Os comandos para instalar e rodar local o projeto, basta utilizar o script disponibilizado no projeto com os comandos abaixo:
```bash
# inicia o banco de dados
$ ./run-kube.sh db

# inicia a aplicação em modo produção
$ ./run.sh app

# rodar todas as dependências
$ ./run.sh all

# encerrar o projeto
$ ./run.sh clear
```

## Possível erro de permissão

Caso ocorra algum erro basta rodar

```bash
# Aplica permissões para o comando
$ chmod +x ./run-kube.sh 
```

## 🛠 Tecnologias
As principais ferramentas usadas na construção do projeto:
- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [PostgreSql](https://www.postgresql.org)

## 🧪 Testes
Testes unitários utilizando o [JUnit5](https://junit.org/junit5/). Esses testes podem ser executados com:
```bash
$ mvn test
```

## 🚀 API's
Essas são as requisições exemplificada no POSTMAN

Segue a collection para baixar e utiliza-la com Docker Compose: [Tech Challenge](./Tech Challenge in Java.postman_collection.json)
e para Kubernetes: [Tech Challenge Kubernetes](./Tech Challenge in Java Kubernetes.postman_collection.json)

Utilizamos a variável ```{{host_docker}} = http://localhost:8080``` que se refere a porta em que o docker está rodando

segue os exemplos:

(o github não permite colocar gifs acima de 5MB, então coloquei os gifs no meu drive e vou colocar o link deles aqui [Gifs](https://drive.google.com/drive/folders/119A9ZyNVMpX50Ja6MZUExgr8KJIQQTVS?usp=sharing))

## Cliente
### Cadastrar cliente
![](https://i.imgur.com/8olwswZ.gif)
<a href="https://i.imgur.com/8olwswZ.gif" target="_blank">cadastrar-cliente.gif</a>

### Buscar clientes
![](https://i.imgur.com/Ija8VQq.gif)
<a href="https://i.imgur.com/Ija8VQq.gif" target="_blank">buscar-clientes.gif</a>

### Buscar cliente por CPF
passamos o CPF pela URL

![](https://i.imgur.com/6uX7tm3.gif)
<a href="https://i.imgur.com/6uX7tm3.gif" target="_blank">buscar-cliente-por-cpf.gif</a>

### Atualizar cliente
![](https://i.imgur.com/oMjOePo.gif)
<a href="https://i.imgur.com/oMjOePo.gif" target="_blank">atualizar-cliente.gif</a>

### Deletar cliente
passamos o CPF pela URL

![](https://i.imgur.com/OBh9IOC.gif)
<a href="https://i.imgur.com/OBh9IOC.gif" target="_blank">deletar-cliente.gif</a>

## Produto

### Criar produto

![](https://i.imgur.com/tlIQdN3.gif)
<a href="https://i.imgur.com/tlIQdN3.gif" target="_blank">criar-produto.gif</a>

### Buscar produto por categoria

Buscar na url o ```codigo_categoria``` passando a categoria cadastrada

![](https://i.imgur.com/dhyA9Kk.gif)
<a href="https://i.imgur.com/dhyA9Kk.gif" target="_blank">buscar-produto-por-categoria.gif</a>

### Buscar produto por ID

Buscar na url o ```id``` passando código do produto

![](https://i.imgur.com/iGAXjHl.gif)
<a href="https://i.imgur.com/iGAXjHl.gif" target="_blank">buscar-produto-por-id.gif</a>

### Deletar produto por ID

Buscar na url o ```id``` passando código do produto

![](https://i.imgur.com/7Fwutv7.gif)
<a href="https://i.imgur.com/7Fwutv7.gif" target="_blank">deletar-produto-por-id.gif</a>


### Atualizar produto

![](https://i.imgur.com/5uyiAuW.gif)
<a href="https://i.imgur.com/5uyiAuW.gif" target="_blank">atualizar-produto.gif</a>


## Pedido

### Criar pedido

Caso informe um CPF, é necessário informar um que já exista, por isso buscamos pela lista de clientes.

Enviamos um array de códigos dos pedidos, como no exemplo o código 5 se referia a Batata Fritae o código 6 a coca cola (informação buscada no endpoint "Busca Produto por categoria" passando o código de categoria 2)

![](https://i.imgur.com/qFptW11.gif)
<a href="https://i.imgur.com/qFptW11.gif" target="_blank">criar-pedido.gif</a>

### Lista pedidos

![](https://i.imgur.com/ydB9egq.gif)
<a href="https://i.imgur.com/ydB9egq.gif" target="_blank">lista-pedidos.gif</a>

## Atualiza Status do Pedido para Em Preparação

Endpoint responsável para atualizar o status do pedido de _Recebido_ para _Em preparação_

envia na url o ```codigoPedido``` passando código do pedido

![](https://i.imgur.com/FGt9SDT.gif)
<a href="https://i.imgur.com/FGt9SDT.gif" target="_blank">atualiza-status-do-pedido-para-em-preparacao.gif</a>


## Atualiza Status do Pedido para Pronto

Endpoint responsável para atualizar o status do pedido de _Em preparação_ para _Pronto_

envia na url o ```codigoPedido``` passando código do pedido

![](https://i.imgur.com/FFEinzc.gif)
<a href="https://i.imgur.com/FFEinzc.gif" target="_blank">atualiza-status-do-pedido-para-pronto.gif</a>


## Atualiza Status do Pedido para Finalizado

Endpoint responsável para atualizar o status do pedido de _Pronto_ para _Finalizado_

envia na url o ```codigoPedido``` passando código do pedido

![](https://i.imgur.com/qj2HSm5.gif)
<a href="https://i.imgur.com/qj2HSm5.gif" target="_blank">atualiza-status-do-pedido-para-finalizado.gif</a>


# Pagamento

Ao registar um novo pedido é retornado pela API um campo chamado `codigo_fatura` que é referente a fatura na instituição financeira.

## Verificação de Pagamento
A verificação do pagamento de uma fatura ocorre com a indicação desse código na rota `/pagamento/situacao?codigo_fatura=<string>`

## Confirmação de Pagamento

A simulação de um pagamento ocorre com a indicação desse código na rota `pagamento/webhook/MP/confirmar` indicando no caminho
```

    /path/{codigo_fatura}: <string>

```

## Rejeição de Pagamento

A simulação de uma rejeição de pagamento ocorre com a indicação desse código na rota `pagamento/webhook/MP/rejeitar` indicando o corpo
```

    /path/{codigo_fatura}: <string>

```

# Casos de Uso

## Módulo Pagamento

### Gerar Fatura para Pagamento
Ação: Cria uma nova fatura para ser paga em um fornecedor externo. Toda fatura é associada a um pedido.

Entrada: Código de identificador de pedido.

Saída: Um objeto contendo os dados da fatura e do pedido associado.

### Verificar Pagamento de Fatura
Ação: Verifica a situação do status de pagamento de uma fatura.

Entrada: Código identificador da fatura.

Saída: Um objeto contendo os dados da fatura e do pedido associado.

### Confirmar Pagamento de Fatura
Ação: Uma fatura que esteja com o status de pagamento como `Aguardando Pagamento` deve ter seu status de pagamento atualizado para `Pago`.

Entrada: Código identificador da fatura.

Saída: Um objeto contendo os dados da fatura e do pedido associado.

### Rejeitar Pagamento de Fatura
Ação: Uma fatura que esteja com o status de pagamento como `Aguardando Pagamento` deve ter seu status de pagamento atualizado para `Rejeitado`.

Entrada: Código identificador da fatura.

Saída: Um objeto contendo os dados da fatura e do pedido associado.

## Módulo Pedido

### Iniciar Preparação do Pedido
Ação: Um pedido que esteja com o status `Aguardando Pagamento` deve ter seu status atualizado para `Em preparação`.

Entrada: Código identificador do pedido.

Saída: Um objeto contendo os dados do pedido.

### Listar Pedidos em Andamento
Ação: Lista pedidos em andamento, cujos quais são os com o status igual à `Pronto`, `Em Preparação` e `Recebido`. Os pedidos com o status igual à `Aguardando Pagamento` ou à `Finalizado` não são computados.

Entrada: Nenhuma.

Saída: Uma lista de objetos de pedidos, ordenados pelo status e por ordem de recebimento.