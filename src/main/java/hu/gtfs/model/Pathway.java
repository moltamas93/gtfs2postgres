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
@Entity(name="pathways")
@GtfsFile("pathways.txt")
@Getter
@Setter
public class Pathway {

    @Id
    @GtfsColumn(column = "pathway_id")
    @Column(name = "pathway_id")
    private String pathwayId;

    @GtfsColumn(column = "pathway_type")
    @Column(name = "pathway_type")
    private Integer pathwayType;

    @GtfsColumn(column = "from_stop_id")
    @Column(name = "from_stop_id")
    private String fromStop;

    @GtfsColumn(column = "to_stop_id")
    @Column(name = "to_stop_id")
    private String toStop;

    @GtfsColumn(column = "traversal_time")
    @Column(name = "traversal_time")
    private Integer traversalTime;

    @GtfsColumn(column = "wheelchair_traversal_time")
    @Column(name = "wheelchair_traversal_time")
    private Integer wheelchairTraversalTime;

}
