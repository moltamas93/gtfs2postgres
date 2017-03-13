package com.googlecode.jcsv.annotations.processors;

import com.googlecode.jcsv.annotations.ValueProcessor;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Processes Date values, using a specified DateFormat. By default, the ValueProcessorProvider uses
 * {@link DateFormat#getDateInstance()} as the DateFormat.
 * 
 * @author Eike Bergmann
 */
public class DateProcessor implements ValueProcessor<Date> {
    
    private final DateFormat sdf;
    
    public DateProcessor(DateFormat sdf) {
	this.sdf = sdf;
	
    }
    
    /**
     * Parses the value as a date, using the given DateFormat instance.
     * 
     * @param value the input string
     * @return Date the date
     * @throws IllegalArgumentException if the input String can not be parsed by the given
     *         DateFormat instance
     */
    @Override
    public Date processValue(String value) {
	Date result = null;
	try {
	    result = this.sdf.parse(value);
	} catch (ParseException pe) {
	    throw new IllegalArgumentException(value + " can not be parsed as a date", pe);
	}
	
	return result;
    }
}
