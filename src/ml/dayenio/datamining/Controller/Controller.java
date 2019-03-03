package ml.dayenio.datamining.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Created by @siemah on 27/02/2019.
 */
public class Controller {

    protected String filePath = "";
    protected BufferedReader bufferedReader;
    protected FileReader fileReader;
    protected ArrayList<String> fileLines = new ArrayList<>();
    protected ArrayList<String> itemsListChain = new ArrayList<>();

    /**
     * constructor of Controller
     * @param fileath the path of file of data
     */
    public Controller(String fileath) {
        this.filePath = fileath;
        this.init();
    }

    /**
     * initialize reading file variables
     */
    protected void init() {
        try {
            this.fileReader = new FileReader(filePath);
            this.bufferedReader = new BufferedReader(this.fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get a all line of filePath file
     * @return ArrayList of lines
     */
    public ArrayList<String> getFileLines() {
        String line;
        try {
            while ( (line=this.bufferedReader.readLine()) != null ) {
                String[] splitLis = line.split(",");
                this.fileLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.fileLines;
    }

    /**
     * get list of items of each line in bdd file
     * @see Controller line 14 @var filePath
     * @return list of items of each line
     */
    public ArrayList<String> getItemsOfLine () {
        ArrayList<String> lines = this.getFileLines();
        lines.forEach(line -> {
            String[] lineStr;
            lineStr = line.split(",");
            this.itemsListChain.add(lineStr[2].trim());
        });
        return  this.itemsListChain;
    }

    /**
     * add data (sequence of items) to DB file
     * (this file maybe imported from Pc directory)
     * thus data separate by "," and ",\t
     * @param classType
     * @param classId
     * @param itemsChain
     */
    public void addDataToDB (String classType, String classId, String itemsChain) {
        String line = classType + "," + classId + ",\t" + itemsChain + "\n";
        try {
            Files.write(Paths.get(this.filePath), line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
