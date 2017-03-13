package hu.gtfs.runner;

import hu.gtfs.configuration.ImportConfiguration;
import hu.gtfs.configuration.ProfileConfiguration;
import hu.gtfs.importer.GTFSImporLogic;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Tamas on 2017.03.05..
 */
@Slf4j
@Component
@Profile(ProfileConfiguration.TASK_GTFS)
public class GTFSImporter implements MainRunner {

    private ImportConfiguration importConfiguration;
    private GTFSImporLogic gtfsImporLogic;

    @Autowired
    public GTFSImporter(GTFSImporLogic gtfsImporLogic, ImportConfiguration importConfiguration) {
        this.importConfiguration = importConfiguration;
        this.gtfsImporLogic = gtfsImporLogic;
    }

    public void run() {
        log.info("Processing gtfs: " + importConfiguration.getFile());
        gtfsImporLogic.process(importConfiguration.getFile());
    }

}
