package logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerInit {

    public static void setLoggerParameters(Logger logger) {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/loggingInfo.log", true);
            fileHandler.setFormatter(new CustomFormatter());
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
    }

}
