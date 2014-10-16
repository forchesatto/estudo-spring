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
