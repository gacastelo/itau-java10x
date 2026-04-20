# Transação API - Desafio ITAU + Java10x

Esta é uma API simples para gerenciar transações financeiras feita para o Java10x. Ela permite criar, ler, atualizar e excluir transações, além de gerar estatísticas sobre as transações.

## Pré-requisitos

Antes de começar, certifique-se de ter o Java 25 instalado na sua máquina.

## Instalação

1. Clone o repositório
2. Abra o terminal na pasta do projeto
3. Execute o seguinte comando para instalar as dependências:
   ```
   mvn install
   ```
4. Configure as propriedades no arquivo `src/main/resources/application.properties`

## Executando a aplicação

1. Execute o seguinte comando para iniciar a aplicação:
   ```
   .\mvnw spring-boot:run
   ```
2. A aplicação estará disponível em `http://localhost:8080`

## Endpoints

### Criação de Transação

- **URL**: `/transacoes`
- **Método**: `POST`
- **Parâmetros**: 
  - `valor`: valor da transação (obrigatório)
  - `dataHora`: data e hora da transação (obrigatório)
- **Exemplo de requisição**:
  ```
  {
    "valor": 100.00,
    "dataHora": "2022-01-01T10:30:00"
  }
  ```
### Exclusão de Transação

- **URL**: `/transacoes`
- **Método**: `DELETE`

### Geração de Estatísticas

- **URL**: `/estatisticas`
- **Método**: `GET`
- **Exemplo de resposta**:
  ```
  {
    "count": 2,
    "sum": 50.00,
    "min": 50.00,
    "max": 100.00,
    "avg": 75.00
  }
  ```

## Configuração

As configurações da aplicação podem ser modificadas no arquivo `src/main/resources/application.properties`. Certifique-se de configurar as propriedades corretamente.
