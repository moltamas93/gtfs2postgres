package com.googlecode.jcsv.reader.internal;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the default implementation of the CSVTokenizer. This implementation follows the csv
 * formatting standard, described in: http://en.wikipedia.org/wiki/Comma-separated_values If you
 * have a more specific csv format, such as constant column widths or columns that do not need to be
 * quoted, you may consider to write a more simple but performant CSVTokenizer.
 */
public class CSVTokenizerImpl implements CSVTokenizer {
    
    private enum State {
	NORMAL, QUOTED
    }
    
    @Override
    public List<String> tokenizeLine(String line, CSVStrategy strategy, BufferedReader reader) throws IOException {
	final char DELIMITER = strategy.getDelimiter();
	final char QUOTE = strategy.getQuoteCharacter();
	final char NEW_LINE = '\n';
	
	final StringBuilder sb = new StringBuilder(30);
	final List<String> token = new ArrayList<String>();
	
	line += NEW_LINE;
	State state = State.NORMAL;
	
	int pointer = 0;
	while (true) {
	    final char c = line.charAt(pointer);
	    
	    switch (state) {
		case NORMAL:
		    if (c == DELIMITER) {
			token.add(sb.toString());
			sb.delete(0, sb.length());
		    } else if (c == NEW_LINE) {
			if (!((token.size() == 0) && (sb.length() == 0))) {
			    token.add(sb.toString());
			}
			return token;
		    } else if (c == QUOTE) {
			if (sb.length() == 0) {
			    state = State.QUOTED;
			} else if ((line.charAt(pointer + 1) == QUOTE) && (sb.length() > 0)) {
			    sb.append(c);
			    pointer++;
			} else if (line.charAt(pointer + 1) != QUOTE) {
			    state = State.QUOTED;
			}
		    } else {
			sb.append(c);
		    }
		    break;
		
		case QUOTED:
		    if (c == NEW_LINE) {
			sb.append(NEW_LINE);
			pointer = -1;
			line = reader.readLine();
			if (line == null) {
			    throw new IllegalStateException("unexpected end of file, unclosed quotation");
			}
			line += NEW_LINE;
		    } else if (c == QUOTE) {
			if (line.charAt(pointer + 1) == QUOTE) {
			    sb.append(c);
			    pointer++;
			    break;
			} else {
			    state = State.NORMAL;
			}
		    } else {
			sb.append(c);
		    }
		    break;
	    }
	    
	    pointer++;
	}
    }
}
