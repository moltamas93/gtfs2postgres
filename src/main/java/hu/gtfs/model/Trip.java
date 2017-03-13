package hu.gtfs.model;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * One or more transit agencies that provide the data in this feed.
 *
 * @author trein
 */
@GtfsFile("trips.txt")
@Entity(name="trips")
@Data
@Getter
@Setter
public class Trip {

    @Id
    @GtfsColumn(column = "trip_id")
    @Column(name="trip_id")
    private String tripId;
    
    @GtfsColumn(column = "route_id")
    @Column(name="route_id")
    private String routeId;
    
    @GtfsColumn(column = "service_id")
    @Column(name="service_id")
    private String serviceId;
    
    @GtfsColumn(column = "trip_headsign", optional = true)
    @Column(name="trip_headsign")
    private String headsign;
    
    @GtfsColumn(column = "direction_id", optional = true)
    @Column(name="direction_id")
    private Integer directionType;
    
    @GtfsColumn(column = "block_id", optional = true)
    @Column(name="block_id")
    private String blockId;
    
    @GtfsColumn(column = "shape_id", optional = true)
    @Column(name="shape_id")
    private String shapeId;
    
    @GtfsColumn(column = "wheelchair_accessible", optional = true)
    @Column(name="wheelchair_accessible")
    private Integer wheelchairType;

    @GtfsColumn(column = "bikes_allowed", optional = true)
    @Column(name="bikes_allowed")
    private Integer bikesAllowed;

    @Override
    public String toString() {
        return String.format("Trip: %s::%s", this.tripId, this.routeId);
    }
    
}
