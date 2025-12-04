# DevCalc

## Objetivo do Projeto

DevCalc é uma API REST desenvolvida em Java com Spring Boot que oferece operações matemáticas simples. O projeto tem como objetivo fornecer uma interface programática para realizar cálculos básicos de forma rápida e eficiente.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Maven** (ferramenta de build)
- **Spring Web MVC** (para criar API REST)

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

## TP1 - Docker e Docker Compose
Esta seção documenta o processo de containerização da aplicação DevCalc utilizando Docker e Docker Compose.

### Pré-requisitos:
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

## TP2 - Kubernetes
Esta seção documenta o processo de deploy da aplicação DevCalc em um cluster Kubernetes.

### Pré-requisitos
- Kubernetes cluster configurado
- kubectl instalado e configurado
- Namespace `tp2` criado no cluster

### Instruções de Deploy

1. **Criar o namespace (se não existir):**
```bash
kubectl create namespace tp2
```
2. **Aplicar o arquivo de configuração do Kubernetes:**
```bash
kubectl apply -f k8s/devcalc-deployment.yaml -n tp2
```

3. **Aplicar o serviço para expor a aplicação:**
```bash
kubectl apply -f k8s/devcalc-service.yaml -n tp2
```

4. **Verificar o status do deployment:**
```bash
kubectl get deployments -n tp2
kubectl get pods -n tp2
kubectl get services -n tp2
```

5. **Acessar a aplicação (A aplicação estará disponível no NodePort 30003):**
```bash
http://<node-ip>:30003
```

## TP3 - CI/CD com GitHub Actions

Esta seção documenta todos os workflows de CI/CD implementados no projeto usando GitHub Actions.

### Workflows Configurados

#### 1. Hello Workflow
[![Hello CI/CD](https://github.com/Shyuu7/devcalc-api/actions/workflows/hello.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/hello.yml)

**Arquivo:** `hello.yml`  
**Trigger:** Push em qualquer branch  
**Função:** Workflow básico que imprime "Hello CI/CD" para demonstração inicial do GitHub Actions.

#### 2. Maven Build
[![Maven CI](https://github.com/Shyuu7/devcalc-api/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/maven-ci.yml)

**Arquivo:** `maven-ci.yml`  
**Trigger:** Push na branch `main`  
**Função:** Compila o projeto Spring Boot usando Maven com JDK 21, executando `mvn clean install -DskipTests`.

#### 3. Testes Automatizados
[![Tests](https://github.com/Shyuu7/devcalc-api/actions/workflows/tests.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/tests.yml)

**Arquivo:** `tests.yml`  
**Trigger:** Pull Request  
**Função:** Executa testes automatizados quando um PR é aberto, garantindo qualidade do código antes do merge.

#### 4. Java Matrix Testing
[![Java Matrix Test](https://github.com/Shyuu7/devcalc-api/actions/workflows/java-matrix-test.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/java-matrix-test.yml)

**Arquivo:** `java-matrix-test.yml`  
**Trigger:** Push na branch `main`  
**Função:** Testa a aplicação em múltiplas versões do Java (11 e 17) usando matrix strategy, garantindo compatibilidade.

#### 5. Deploy de Release
[![Release Deploy](https://github.com/Shyuu7/devcalc-api/actions/workflows/release-deploy.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/release-deploy.yml)

**Arquivo:** `release-deploy.yml`  
**Trigger:** Publicação de release no GitHub  
**Função:** Executa deploy automatizado para produção quando uma nova release é publicada.

#### 6. Demonstração de Environment Variables
[![Environment Demo](https://github.com/Shyuu7/devcalc-api/actions/workflows/env-demo.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/env-demo.yml)

**Arquivo:** `env-demo.yml`  
**Trigger:** Push em qualquer branch  
**Função:** Demonstra o uso de variáveis de ambiente no GitHub Actions, exibindo `DEPLOY_ENV=staging`.

#### 7. Demonstração de Secrets
[![Secret Demo](https://github.com/Shyuu7/devcalc-api/actions/workflows/secret-demo.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/secret-demo.yml)

**Arquivo:** `secret-demo.yml`  
**Trigger:** Push na branch `main`  
**Função:** Demonstra o uso seguro de secrets do GitHub, utilizando a variável `API_KEY` de forma protegida.

#### 8. Deploy Multi-ambiente
[![Deploy](https://github.com/Shyuu7/devcalc-api/actions/workflows/deploy.yml/badge.svg)](https://github.com/Shyuu7/devcalc-api/actions/workflows/deploy.yml)

**Arquivo:** `deploy.yml`  
**Trigger:** Push na branch `main`  
**Função:** Pipeline de deploy sequencial em múltiplos ambientes (dev → staging → prod), usando variáveis de ambiente específicas para cada estágio e mascaramento de credenciais sensíveis.

### Pipeline de CI/CD

O projeto implementa uma pipeline completa de CI/CD que:
- **Integração Contínua:** Compila e testa o código a cada push/PR
- **Compatibilidade:** Verifica funcionamento em múltiplas versões do Java
- **Deploy Automatizado:** Realiza deploy quando uma release é publicada
- **Segurança:** Gerencia secrets e variáveis de ambiente de forma segura

Todos os workflows podem ser visualizados na aba [Actions](https://github.com/Shyuu7/devcalc-api/actions) do repositório.


### **Acesse a API**

A URL de acesso varia dependendo do método de execução:

#### Execução Local ou Docker:
- URL: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html

#### Execução com Kubernetes:
- URL: http://\<node-ip\>:30003
- Swagger UI: http://\<node-ip\>:30003/swagger-ui/index.html

### **Teste os endpoints**

Você pode testar os endpoints usando:
- Swagger UI - Interface web disponível na página principal
- Curl - Comandos HTTP via terminal
- Postman - Cliente REST gráfico
- Container de teste - Para verificar conectividade interna

#### Exemplo com execução local/Docker:
```bash
curl -X GET "http://localhost:8080/api/calc/sum?a=5&b=3" -H "accept: application/json"
```