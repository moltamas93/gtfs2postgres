package hu.gtfs.model;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Tamas on 2017.03.05..
 */
@GtfsFile("stop_times.txt")
@Entity(name = "stop_times")
@Getter
@Setter
public class StopTime {

    @Id
    @GeneratedValue
    private long id;

    @GtfsColumn(column = "trip_id")
    @Column(name = "trip_id")
    private String tripId;

    @GtfsColumn(column = "arrival_time", optional = true)
    @Column(name = "arrival_time")
    private String arrivalTime;

    @GtfsColumn(column = "departure_time", optional = true)
    @Column(name = "departure_time")
    private String departureTime;

    @GtfsColumn(column = "stop_id")
    @Column(name = "stop_id")
    private String stopId;

    @GtfsColumn(column = "stop_sequence")
    @Column(name = "stop_sequence")
    private Integer stopSequence;

    @GtfsColumn(column = "stop_headsign", optional = true)
    @Column(name = "stop_headsign")
    private String stopHeadsign;

    @GtfsColumn(column = "shape_dist_traveled", optional = true)
    @Column(name = "shape_dist_traveled")
    private Double shapeDistanceTraveled;
}
