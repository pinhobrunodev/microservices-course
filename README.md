
# Sistema referente a área de Recursos Humanos de uma Empresa que contém seus próprios microserviços.

## Modelagem Conceitual 

![Modelagem Conceitual](https://user-images.githubusercontent.com/60756219/140233920-62544c32-c14f-438d-8ebb-547126ddeec5.png)

## Arquitetura do Microsservice

![Microsservice img](https://user-images.githubusercontent.com/60756219/140233956-c2ffd748-b356-4182-8b59-7d62fdd0b84e.png)

## Disposição dos Containers Docker

![Containers Docker](https://user-images.githubusercontent.com/60756219/140233969-4359cd37-aace-46dc-8a50-19743c9f4e80.png)

#

## Informações Técnicas

-> FeignClient = Captura os WebServices para fazer a chamada aos microservices específicos.

-> Ribbon = Balanceador de Carga, faz com que um microservice possa se comunicar com varias instancias de outros microservices,
evitando assim a sobrecarga de uma instância de um determinado microservice.

-> Eureka Server = Representa o nosso servidor Eureka

-> Eureka Client = Representa nossos Microservices que estão presentes dentro do Eureka Server

- É necessário informar o caminho do nosso Eureka Server para cada client , para que dessa forma eles possam ''encontrar o servidor''.
- Quando anotamos o EnableEurekaClient , já colocamos embutido o Ribbon.
- Podemos gerar portas aleatórias para cada tipo de microservice , gerando assim mais de uma instância de um mesmo microservice.

-> Hystrix = Faz o tratamento de falhas dos Microservices
- Podemos associá-lo ao Circuit Breaker.
- Quando determinado serviço de um microservice fica fora do ar podemos criar um fallback,ou seja,
 determinamos um  caminho alternativo que não dependa do seviço do microservice que está fora do ar.
- Podemos colocar um valor de time-out para a requisição , ou seja , vamos tentar acessar um determinado serviço
de um microservice, se passar de 10s , ativamos o caminho alternativo. 


-> API Gateway Zuul

- O Mundo externo vai realizar as requisições a partir deste Gateway.
- Sua principal funcionalidade é rotear as chamadas pelo menos dos microserviços com seus endpoints correspondentes.


-> Config Server
-  Local onde colocamos nossas configurações da aplicação.
-  No caso desse projeto, está em um repositório privado, ou seja , quando subirmos  no Docker  um microserviço que é um "client" do Config Server ele vai "ler"
o arquivo de configuração do repositório privado com base no tipo de perfil que está setado no arquivo "bootstrap.properties"

