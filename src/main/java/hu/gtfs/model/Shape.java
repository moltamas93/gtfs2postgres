package hu.gtfs.model;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Tamas on 2017.03.05..
 */

@Entity(name="shapes")
@GtfsFile("shapes.txt")
@Getter
@Setter
public class Shape {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @GtfsColumn(column = "shape_id")
    @Column(name = "shape_id")
    private String shapeId;

    @GtfsColumn(column = "shape_pt_lat")
    @Column(name = "lat")
    private Double lat;

    @GtfsColumn(column = "shape_pt_lon")
    @Column(name = "lon")
    private Double lng;

    @GtfsColumn(column = "shape_pt_sequence")
    @Column(name = "shape_pt_sequence")
    private Integer sequence;

    @GtfsColumn(column = "shape_dist_traveled", optional = true)
    @Column(name = "shape_dist_traveled")
    private Double distanceTraveled;

}
