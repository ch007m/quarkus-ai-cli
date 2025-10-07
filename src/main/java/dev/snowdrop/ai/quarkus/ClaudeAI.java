package dev.snowdrop.ai.quarkus;

import io.quarkus.picocli.runtime.annotations.TopCommand;
import jakarta.inject.Inject;
import picocli.CommandLine.Command;
import org.jboss.logging.Logger;

import java.io.Console;

@TopCommand
@Command(mixinStandardHelpOptions = true,
    description = "Interactive chat with Claude assistant.")
public class ClaudeAI implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ClaudeAI.class);

    @Inject
    Assistant assistant;

    @Override
    public void run() {
        LOGGER.info("Hello! I'm your document assistant. Ask me anything about your files.");
        LOGGER.info("Type 'exit' to quit.");

        Console console = System.console();
        if (console == null) {
            LOGGER.error("Console not available. This is an interactive application.");
            return;
        }

        while (true) {
            String userMessage = console.readLine("> ");
            if ("exit".equalsIgnoreCase(userMessage)) {
                LOGGER.info("Goodbye!");
                break;
            }

            String response = assistant.chat(userMessage);
            System.out.println("Claude: " + response);
        }
    }
}