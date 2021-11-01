# microservices-course

-> Feign = Captura os WebServices para fazer a chamada aos microservices específicos.

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
