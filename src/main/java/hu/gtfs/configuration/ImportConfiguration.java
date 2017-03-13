package hu.gtfs.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Tamas on 2017.03.05..
 */
@Component
@ConfigurationProperties("gtfs.import")
@Getter
@Setter
public class ImportConfiguration {

    private String file;

}
