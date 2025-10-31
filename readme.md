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
   
### Opção 2: usando Docker

Pré-requisitos:
- Docker instalado
- Docker Compose instalado

Executar apenas a API:
1. Pull da imagem do Docker Hub:
   ```bash
   docker pull shyuu7/devcalc:latest
   ```
2. Executar o container:
   ```bash
   docker run -d -p 8080:8080 shyuu7/devcalc:latest
   ```
   
Executar ambiente completo com Docker Compose:
1. Clone o repositório:
   ```bash
   git clone https://github.com/Shyuu7/devcalc-api.git
   cd devcalc-api
   ```
2. Iniciar os serviços:
   ```bash
   docker-compose up -d
   ```
3. Verificar os containers em execução:
   ```bash
   docker ps
   ```
4. Parar os serviços:
   ```bash
   docker-compose down
   ```
5. Parar e remover todos os containers, redes e volumes:
   ```bash
   docker-compose down -v
   ```


### **Acesse a API**

Independente do método de execução escolhido, a API estará disponível em:

URL: http://localhost:8080

Swagger UI: http://localhost:8080/swagger-ui/index.html


### **Teste os endpoints**

Você pode testar os endpoints usando:
- Swagger UI - Interface web disponível na página principal
- Curl - Comandos HTTP via terminal
- Postman - Cliente REST gráfico
- Container de teste - Para verificar conectividade interna

Exemplo de comando curl para somar dois números:
```bash
curl -X GET "http://localhost:8080/api/calc/sum?a=5&b=3" -H "accept: application/json"
```