package com.trein.gtfs.csv.vo;

import com.trein.gtfs.csv.annotation.GtfsColumn;
import com.trein.gtfs.csv.annotation.GtfsFile;

/**
 * One or more transit agencies that provide the data in this feed.
 *
 * @author trein
 */
@GtfsFile("agency.txt")
public class GtfsAgency {

    @GtfsColumn(column = "agency_id")
    private String id;

    @GtfsColumn(column = "agency_name")
    private String name;

    @GtfsColumn(column = "agency_url")
    private String url;

    @GtfsColumn(column = "agency_timezone")
    private String timezone;

    @GtfsColumn(column = "agency_lang", optional = true)
    private String lang;

    @GtfsColumn(column = "agency_phone", optional = true)
    private String phone;

    @GtfsColumn(column = "agency_fare_url", optional = true)
    private String fareUrl;

    /**
     * agency_id Optional: The agency_id field is an ID that uniquely identifies a transit agency. A
     * transit feed may represent data from more than one agency. The agency_id is dataset unique.
     * This field is optional for transit feeds that only contain data for a single agency.
     *
     * @return current agency's id name.
     */
    public String getId() {
        return this.id;
    }

    /**
     * agency_name Required: The agency_name field contains the full name of the transit agency.
     * Google Maps will display this name.
     *
     * @return current agency's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Required: The agency_url field contains the URL of the transit agency. The value must be a
     * fully qualified URL that includes http:// or https://, and any special characters in the URL
     * must be correctly escaped. See http://www.w3.org/Addressing/URL/4_URI_Recommentations.html
     * for a description of how to create fully qualified URL values.
     *
     * @return current agency's url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * agency_timezone Required: The agency_timezone field contains the timezone where the transit
     * agency is located. Timezone names never contain the space character but may contain an
     * underscore. Please refer to http://en.wikipedia.org/wiki/List_of_tz_zones for a list of valid
     * values. If multiple agencies are specified in the feed, each must have the same
     * agency_timezone.
     *
     * @return current agency's timezone.
     */
    public String getTimezone() {
        return this.timezone;
    }

    /***
     * agency_lang Optional: The agency_lang field contains a two-letter ISO 639-1 code for the
     * primary language used by this transit agency. The language code is case-insensitive (both en
     * and EN are accepted). This setting defines capitalization rules and other language-specific
     * settings for all text contained in this transit agency's feed. Please refer to
     * http://www.loc.gov/standards/iso639-2/php/code_list.php for a list of valid values.
     *
     * @return current agency's language.
     */
    public String getLang() {
        return this.lang;
    }

    /**
     * agency_phone Optional: The agency_phone field contains a single voice telephone number for
     * the specified agency. This field is a string value that presents the telephone number as
     * typical for the agency's service area. It can and should contain punctuation marks to group
     * the digits of the number. Dialable text (for example, TriMet's "503-238-RIDE") is permitted,
     * but the field must not contain any other descriptive text.
     *
     * @return current agency's main telephone.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * agency_fare_url Optional: The agency_fare_url specifies the URL of a web page that allows a
     * rider to purchase tickets or other fare instruments for that agency online. The value must be
     * a fully qualified URL that includes http:// or https://, and any special characters in the
     * URL must be correctly escaped. See
     * http://www.w3.org/Addressing/URL/4_URI_Recommentations.html for a description of how to
     * create fully qualified URL values.
     *
     * @return current agency's fare url.
     */
    public String getFareUrl() {
        return this.fareUrl;
    }
    
    @Override
    public String toString() {
        return String.format("Agency: %s", this.name);
    }

}
