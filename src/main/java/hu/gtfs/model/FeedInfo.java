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
@Entity(name="feed_info")
@GtfsFile("feed_info.txt")
@Getter
@Setter
public class FeedInfo {

    @GtfsColumn(column = "feed_publisher_name")
    @Column(name = "feed_publisher_name")
    private String publisherName;

    @GtfsColumn(column = "feed_publisher_url")
    @Column(name = "feed_publisher_url")
    private String pusblisherUrl;

    @GtfsColumn(column = "feed_lang")
    @Column(name = "feed_lang")
    private String language;

    @GtfsColumn(column = "feed_start_date", optional = true)
    @Column(name = "feed_start_date")
    private String startDate;

    @GtfsColumn(column = "feed_end_date", optional = true)
    @Column(name = "feed_end_date")
    private String endDate;

    @Id
    @GtfsColumn(column = "feed_version", optional = true)
    @Column(name = "feed_version")
    private String version;

    @GtfsColumn(column = "feed_ext_version", optional = true)
    @Column(name = "feed_ext_version")
    private String extVersion;

}
