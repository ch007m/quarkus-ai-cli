package dev.snowdrop.ai.quarkus;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.jboss.logging.Logger;

@ApplicationScoped
public class FileSystemTool {
    private static final Logger logger = Logger.getLogger(FileSystemTool.class.getName());

    @Tool("Reads the full content of a specified file")
    public String readFile(String path) {
        try {
            logger.info("Reading file: " + path);
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    @Tool("Writes the content to the specified file, overwriting it if it exists")
    public String writeFile(String path, String content) {

        logger.infof("Writing file: %s", path);
        logger.infof("String content : %s", content);

        if (path == null || path.isBlank() || content == null) {
            return "Error: File path and content cannot be null or empty. Please provide both.";
        }

        // CRITICAL: Add a security confirmation step
        Console console = System.console();
        if (console == null) {
            return "Confirmation failed: Console not available.";
        }

        System.out.println("\n--------------------------------------------------");
        System.out.println("AI is requesting to WRITE to the file: " + path);
        System.out.println("Content to be written:");
        System.out.println(content);
        System.out.println("--------------------------------------------------");
        String confirmation = console.readLine("Do you want to proceed? (y/n): ");

        if (!"y".equalsIgnoreCase(confirmation)) {
            return "Write operation cancelled by user.";
        }

        try {
            Path filePath = Paths.get(path);
            Files.createDirectories(filePath.getParent());
            Files.writeString(filePath, content);
            return "File '" + path + "' written successfully.";
        } catch (IOException e) {
            return "Error writing file: " + e.getMessage();
        }
    }
}