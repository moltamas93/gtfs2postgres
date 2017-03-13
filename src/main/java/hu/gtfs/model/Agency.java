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
@GtfsFile("agency.txt")
@Entity(name = "agency")
@Getter
@Setter
public class Agency {

    @Id
    @GtfsColumn(column = "agency_id")
    @Column(name = "agency_id")
    private String agencyId;

    @GtfsColumn(column = "agency_name")
    @Column(name = "agency_name")
    private String name;

    @GtfsColumn(column = "agency_url")
    @Column(name = "agency_url")
    private String url;

    @GtfsColumn(column = "agency_timezone")
    @Column(name = "agency_timezone")
    private String timezone;

    @GtfsColumn(column = "agency_lang", optional = true)
    @Column(name = "agency_lang")
    private String lang;

    @GtfsColumn(column = "agency_phone", optional = true)
    @Column(name = "agency_phone")
    private String phone;

}
