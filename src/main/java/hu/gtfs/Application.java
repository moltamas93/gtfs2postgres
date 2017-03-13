package hu.gtfs;

import hu.gtfs.runner.MainRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

import static hu.gtfs.configuration.ProfileConfiguration.*;

@SpringBootApplication
@Slf4j
public class Application {

    public static final String[] TASKS = new String[]{TASK_GTFS};

	public static void main(String[] args) {
        if (args.length == 0 || !Arrays.asList(TASKS).contains(args[0])) {
            log.error("Missing task to run (one of: {})", Arrays.toString(TASKS));
            Runtime.getRuntime().exit(1);
        }

        String task = args[0];

        ConfigurableApplicationContext context = null;
        try {
            context = new SpringApplicationBuilder(Application.class)
                    .profiles(task)
                    .run(args);
            MainRunner runner = context.getBean(MainRunner.class);
            runner.run();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
