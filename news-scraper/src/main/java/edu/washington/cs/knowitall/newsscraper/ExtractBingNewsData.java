package edu.washington.cs.knowitall.newsscraper;

import java.util.Calendar;

import org.apache.commons.cli.Options;

public class ExtractBingNewsData {
    private static Calendar calendar;
    private static Options options;
    private static Config config;
    
    public static void main(String[] args){
    	
    	NewsScraperMain.initializeVars();
//    	config = NewsScraperMain.getConfig();
    	config = null;
    	ExtractedDataFormatter formatter = new ExtractedDataFormatter(
                calendar, config);
    	formatter.format(new String[]{"bing_data"}, null, -1, null, false);
    }
}
