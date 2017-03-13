package hu.gtfs.model;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Tamas on 2017.03.05..
 */
@GtfsFile("calendar_dates.txt")
@Entity(name = "calendar_dates")
public class CalendarDate {

    @Id
    @GeneratedValue
    private int id;

    @GtfsColumn(column = "service_id")
    @Column(name = "service_id")
    private String serviceId;

    @GtfsColumn(column = "date")
    @Column(name = "date")
    private String date;

    @GtfsColumn(column = "exception_type")
    @Column(name = "exception_type")
    private Integer exceptionType;
}
