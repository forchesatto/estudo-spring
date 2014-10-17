Exemplos e testes Spring framework
=============

Repositório para testes e estudos sobre o ecosistema do framework Spring 

<h3>Resolvendo problema de Hot-Deploy com Spring-loaded</h3>

Spring-loaded é um Agente da JVM que recarega as modificações em classes enquanto a JVM está em execução. Faz o reload de inclusão, alteração ou exclusão de métodos, atributos ou classes. Em um projeto web faz reload também dos arquivos jsp, css, javascript. Mais informações e donwload: 

Site oficial: https://github.com/spring-projects/spring-loaded

Artigo passo a passo: http://www.leveluplunch.com/java/tutorials/004-hot-deploy-java-applications-with-spring-loaded/

Para configurar é simples, basta fazer o donwload do .jar e configurar em sua IDE preferida um javaagent na JVM desta maneira:

<code>-javaagent:<pathTo>/springloaded-{VERSION}.jar -noverify</code>

No eclipse basta criar um Run adicionando o código anterior em VM arguments.

Pode também configurar através do console

<code>java -javaagent:<pathTo>/springloaded-{VERSION}.jar -noverify</code>

<h3>Spring-Boot Básico</h3>

Projeto spring-boot-ioc é um teste inicial com Spring-Boot, Bootstrap da Pivot que facilita e muito o inicio do desenvolvimento de projetos com Spring. Como poucas linhas já temos uma aplicação funcional, sem xml e sem configurações consideradas triviais.

Documentação:
Site oficial: http://projects.spring.io/spring-boot/

Exemplos: https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples

<h3>Spring-Boot JSP Tomcat e Spring-Data-JPA</h3>

Projeto spring-boot-jsp-jpa é a junção de alguns exemplo do spring-boot-samples em um único projeto. O mesmo possui uma página web para cadastro de produto bem simples, mas que já dá para ter uma ideia da facilidade de start no desenvolvimento de uma aplicação CRUD Web.

Neste exemplo foi utilizado Spring-MVC, HTML básico no front e Spring-Data-JPA para persistência.

A base de dados esta em postgres para utilizar a base padrão basta retirar as configurações do arquivo application.properties e adicionar a dependência para o groupId=org.hsqldb artifactId=hsqldb
