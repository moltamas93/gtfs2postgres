package hu.gtfs.model;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Tamas on 2017.03.05..
 */
@GtfsFile("stops.txt")
@Entity(name = "stops")
@Getter
@Setter
public class Stop {

    @Id
    @GtfsColumn(column = "stop_id")
    @Column(name = "stop_id")
    private String stopId;

    @GtfsColumn(column = "stop_name")
    @Column(name = "stop_name")
    private String name;

    @GtfsColumn(column = "stop_code", optional = true)
    @Column(name = "stop_code")
    private String code;

    @GtfsColumn(column = "stop_lat")
    @Column(name = "lat")
    private Double lat;

    @GtfsColumn(column = "stop_lon")
    @Column(name = "lon")
    private Double lng;

    @GtfsColumn(column = "location_type", optional = true)
    @Column(name = "location_type")
    private Integer locationType;

    @GtfsColumn(column = "parent_station", optional = true)
    @Column(name = "parent_station")
    private String parentStation;

    @GtfsColumn(column = "wheelchair_boarding", optional = true)
    @Column(name = "wheelchair_boarding")
    private Integer wheelchairType;

    @GtfsColumn(column = "stop_direction", optional = true)
    @Column(name = "stop_direction")
    private Integer stopDirection;
}
