## Instructions


Compile the project and set the following env var to specify the path of the Quarkus Claude CLI
```shell
mvn clean install
set -xg CLAUDE_CLI_PATH $(pwd)/target/quarkus-app/quarkus-run.jar
```

Start the Quarkus Claude CLI under a project containing a pom.xml and start to play your instructions
```shell
set -gx QUARKUS_LANGCHAIN4J_ANTHROPIC_API_KEY <API_KEY>
set -gx QUARKUS_LANGCHAIN4J_ANTHROPIC_BASE_URL <AI_URL>
java -jar $CLAUDE_CLI_PATH

2025-10-07 14:32:19,799 INFO  [dev.sno.ai.qua.ClaudeAI] (main) Hello! I'm your document assistant. Ask me anything about your files.
2025-10-07 14:32:19,799 INFO  [dev.sno.ai.qua.ClaudeAI] (main) Type 'exit' to quit.
> 
> Add the Apache Commons Lang dependency to the pom.xml.
```

## Scenario tested on SpringBoot TODO

```text
> Can you add to the pom.xml file the Quarkus BOM dependency within the dependencyManagement section and the following dependencies: quarkus-arc, quarkus-core. The version of quarkus to be used and to included within the pom.xml properties is 3.26.4.
> Can you now remove the @SpringBootApplication from the java file which contains it. Next add to the same java class the @QuarkusMain annotation. The AppApplication should not implement QuarkusApplication. Remove within the main body SpringApplication run(..) and replace it with Quarkus.run and pass to the method of quarkus.run the arguments
> Add a new class com.todo.app.TodoApplication which implements QuarkusApplication. Use stdout to send a message: "Hello user" using args[0]. Next Pass as first argument: TodoApplication.class to Quarkus.run()
> Remove from the pom.xml the spring-boot-maven-plugin and use instead the quarkus plugin
```