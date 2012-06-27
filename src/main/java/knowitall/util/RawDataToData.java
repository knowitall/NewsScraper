package knowitall.util;

import java.io.File;
import java.net.URL;
import java.util.Calendar;

import knowitall.reverbovernews.NewsScraperMain;
import knowitall.reverbovernews.YahooRssScraper;

public class RawDataToData {
    
    public static void main(String[] args){
        File root = new File("yahoo_data/recover/");
        String[] folders = root.list();
        
        for(String folderName : folders) {
            YahooRssScraper yrs = new YahooRssScraper(Calendar.getInstance(), 
                    NewsScraperMain.DEFAULT_CONFIG_URL);
            yrs.scrape(false, true, "yahoo_data/recover/" + folderName + "/raw_data/", "yahoo_data/recover/" + folderName);
        }
    }
}
