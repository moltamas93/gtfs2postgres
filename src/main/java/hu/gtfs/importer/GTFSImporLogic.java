package hu.gtfs.importer;

import java.io.InputStream;

import com.googlecode.jcsv.annotations.internal.ValueProcessorProvider;
import com.googlecode.jcsv.reader.CSVReader;
import com.trein.gtfs.csv.annotation.GtfsFile;
import com.trein.gtfs.csv.reader.CSVHeaderAwareEntryParser;
import com.trein.gtfs.csv.reader.CSVHeaderAwareReaderBuilder;
import hu.gtfs.model.*;
import hu.gtfs.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by Tamas on 2017.03.08..
 */
@Slf4j
@Service
public class GTFSImporLogic {

    private Map<Class<?>, JpaRepository<?,?>> repos = new HashMap<>();

    @Autowired
    private AgencyRepository agencyRepository;
    @Autowired
    private CalendarDateRepository calendarDateRepository;
    @Autowired
    private FeedInfoRepository feedInfoRepository;
    @Autowired
    private PathwayRepository pathwayRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private ShapeRepository shapeRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private StopTimeRepository stopTimeRepository;
    @Autowired
    private TripRepository tripRepository;

    private Class<?>[] objectTypes = {
            Agency.class,
            CalendarDate.class,
            FeedInfo.class,
            Pathway.class,
            Route.class,
            Shape.class,
            Stop.class,
            StopTime.class,
            Trip.class
    };

    public Class<?> getClassByFileName(String fileName) {
        for(Class<?> objectType: objectTypes) {
            String name = objectType.getAnnotation(GtfsFile.class).value();
            if (name.equals(fileName)) {
                return objectType;
            }
        }
        log.error("Unknown file: " + fileName);
        return null;
    }


    public void process(String gtfsPath) {
        init();
        try {
            ZipFile zipFile = new ZipFile(gtfsPath);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while(entries.hasMoreElements()){
                ZipEntry entry = entries.nextElement();
                InputStream stream = zipFile.getInputStream(entry);
                Class<?> clazz = getClassByFileName(entry.getName());
                if (clazz != null) {
                    log.info("Processing file: " + entry.getName());
                    parseAndSaveEntity(clazz, stream);
                } else {
                    log.info("Skip process, unknown file: " + entry.getName());
                }
            }
        } catch (IOException e) {
            log.error("Cannot read file: " + gtfsPath, e);
            return;
        }

    }


    public <T> void parseAndSaveEntity(Class<T> clazz, InputStream inputStream) {
        Reader csv = new InputStreamReader(inputStream);
        ValueProcessorProvider vpp = new ValueProcessorProvider();
        CSVHeaderAwareEntryParser<T> parser = new CSVHeaderAwareEntryParser<T>(clazz, vpp);

        CSVReader<T> reader = new CSVHeaderAwareReaderBuilder<T>(csv).entryParser(parser).build();
        try {
            log.info("Save entities: " + clazz.getName());
            List<T> entities = reader.readAll() ;
            if (entities == null) {
                log.error("Entites null: " + clazz.getName());
            } else {
                saveEntityList(clazz, entities);
            }

        } catch(IOException ex) {
            log.error("Cannot parse: " + clazz.toString(), ex);
            return;
        }
    }

    public <T> void saveEntityList(Class<T> clazz, List<T> entities) {
        JpaRepository<T, ?> jpaRepository = getRepo(clazz);
        for(T entity: entities) {
            jpaRepository.save(entity);
        }

    }

    private void init(){
        putRepo(Agency.class, agencyRepository);
        putRepo(CalendarDate.class, calendarDateRepository);
        putRepo(FeedInfo.class, feedInfoRepository);
        putRepo(Pathway.class, pathwayRepository);
        putRepo(Route.class, routeRepository);
        putRepo(Shape.class, shapeRepository);
        putRepo(Stop.class, stopRepository);
        putRepo(StopTime.class, stopTimeRepository);
        putRepo(Trip.class, tripRepository);
    }

    public <T> void putRepo(Class<T> clazz, JpaRepository<T, ?> jpaRepository) {
        repos.put(clazz, jpaRepository);
    }

    public <T> JpaRepository<T,?> getRepo(Class<T> clazz){
        return (JpaRepository<T, ?>) repos.get(clazz);
    }

}
