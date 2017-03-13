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
@GtfsFile("routes.txt")
@Entity(name="routes")
@Getter
@Setter
public class Route {
    @Id
    @GtfsColumn(column = "route_id")
    @Column(name = "route_id")
    private String routeId;

    @GtfsColumn(column = "agency_id", optional = true)
    @Column(name = "agency_id")
    private String agencyId;

    @GtfsColumn(column = "route_short_name")
    @Column(name = "route_short_name")
    private String shortName;

    @GtfsColumn(column = "route_long_name", optional = true)
    @Column(name = "route_long_name")
    private String longName;

    @GtfsColumn(column = "route_desc", optional = true)
    @Column(name = "route_desc")
    private String desc;

    @GtfsColumn(column = "route_type")
    @Column(name = "route_type")
    private Integer routeType;

    @GtfsColumn(column = "route_color", optional = true)
    @Column(name = "route_color")
    private String hexPathColor;

    @GtfsColumn(column = "route_text_color", optional = true)
    @Column(name = "route_text_color")
    private String hexTextColor;
}
