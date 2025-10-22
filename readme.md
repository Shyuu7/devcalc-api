# DevCalc

## Objetivo do Projeto

DevCalc é uma API REST desenvolvida em Java com Spring Boot que oferece operações matemáticas simples. O projeto tem como objetivo fornecer uma interface programática para realizar cálculos básicos de forma rápida e eficiente.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Maven** (ferramenta de build)
- **Spring Web MVC** (para criar a API REST)

## Ferramenta de Build

O projeto utiliza **Apache Maven** como ferramenta de build e gerenciamento de dependências. Maven facilita a compilação, empacotamento e execução do projeto através de comandos simples.

## Como Executar Localmente

### Pré-requisitos

- Java 11 ou superior instalado
- Maven instalado (ou usar o wrapper incluído)

### Passos para execução
#### Os comandos aqui aplicam-se se você estiver usando Maven diretamente. Se estiver usando o wrapper do Maven (mvnw), substitua `mvn` por `./mvnw`.

1. **Clone o repositório**
   ```bash
   git clone <https://github.com/Shyuu7/devcalc-api.git>
   cd DevCalc

2. **Compile o projeto**

   ```bash
   mvn clean install
   ```
3. **Execute a aplicação**
    ```bash
    mvn spring-boot:run
    ```
   
4. **Outros comandos úteis:**
    - Para compilar o projeto sem executar os testes:
     ```bash
      mvn clean install -DskipTests
     ```
    - Para executar os testes:
     ```bash
      mvn test
     ```
    - Para empacotar a aplicação em um arquivo JAR:
     ```bash
      mvn package
     ```
   - Para executar o JAR gerado:
   ```bash
     java -jar target/devcalc-0.0.1-SNAPSHOT.jar
     ```
   - Para limpar os arquivos compilados:
   ```bash
     mvn clean
     ```
4. **Acesse a API**

   A API estará disponível em `http://localhost:8080`.


5. **Teste os endpoints**

Você pode testar os endpoints usando o Swagger na página principal.