package knowitall.reverbovernews;import java.io.File;import java.io.FileNotFoundException;import java.text.DateFormat;import java.text.SimpleDateFormat;import java.util.Scanner;import com.google.gson.JsonObject;import com.google.gson.JsonParser;public class Config {        private final String ENCODE = "UTF-8";    private final String JSON_FOLDER_NAME = "folder-name";    private final String JSON_DATE_FORMAT = "date-format";    private final String JSON_EXTRACTED_DATA_SUFFIX = "extracted_data_suffix";    private final String JSON_EXTRACTED_DIR = "extracted_data_dir";        private String rootDir;    private JsonObject config;    private DateFormat dateFormat;    private String extractedDataSuffix;    private String extractedDataDir;        /**     * load the configuration file with given file location     * @param configFile is the location of the configuration file     * @throws FileNotFoundException     */    public void loadConfig(String configFile) throws FileNotFoundException{                String fileContent = readFile(configFile);                config = (JsonObject)(new JsonParser()).parse(fileContent);        rootDir = config.get(JSON_FOLDER_NAME).getAsString();        dateFormat = new SimpleDateFormat(config.get(JSON_DATE_FORMAT).getAsString());        extractedDataSuffix = config.get(JSON_EXTRACTED_DATA_SUFFIX).getAsString();        extractedDataDir = config.get(JSON_EXTRACTED_DIR).getAsString();    }        /**     * return the dataFormat we want to use.     * @return     */    public DateFormat getDateFormat(){        return dateFormat;    }        /**     *      * @return the instance of current configuration.     */    public JsonObject getConfig(){        return config;    }        /**     *      * @return the directory of root file     */    public String getRootDir(){        return rootDir;    }        public String getExtractedDataSuffix(){        return extractedDataSuffix;    }        public String getExtractedDataDir(){        return extractedDataDir;    }    /*     * read the given file into memory as a string     */    private String readFile(String configFile) throws FileNotFoundException {        Scanner sc = new Scanner(new File(configFile), ENCODE);        StringBuilder sb = new StringBuilder();        while(sc.hasNextLine())            sb.append(sc.nextLine());                return sb.toString();    }}