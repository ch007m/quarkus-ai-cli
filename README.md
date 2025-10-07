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

## TODO: Scenario to be tested

```text
> Can you read the pom.xml file and tell me what it is ?
> Can you edit the pom.xml file to add the Quarkus BOM dependency within the dependencymanagement section and quarkus-arc, quarkus-core dependencies. The version of quarkus to be defined within the pom.xml properties is 3.26.4.
> Can you read the pom.xml file ?
> Can you read the pom.xml file and when done add the Apache Commons library to the pom.xml. Send me back the response and use the response to update and write the change within the pom.xml file 
```