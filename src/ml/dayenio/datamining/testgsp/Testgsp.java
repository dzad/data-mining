/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ml.dayenio.datamining.testgsp;

//Imports
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.AlgoGSP;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.SequenceDatabase;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.creators.AbstractionCreator;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.creators.AbstractionCreator_Qualitative;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Testgsp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("start GSP");
        // Load a sequence database
        double support = (double)0.1, mingap = 0, maxgap = 1, windowSize = 0;

        boolean keepPatterns = true;
        boolean verbose=true;
        
        // if you set the following parameter to true, the sequence ids of the sequences where
        // each pattern appears will be shown in the result
        boolean outputSequenceIdentifiers = false;

        AbstractionCreator abstractionCreator = AbstractionCreator_Qualitative.getInstance();
        SequenceDatabase sequenceDatabase = new SequenceDatabase(abstractionCreator);
        
        try {
            sequenceDatabase.loadFile(fileToPath("./contextPrefixSpanStrings.txt"), support);
        } catch (IOException ex) {
            Logger.getLogger(Testgsp.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        AlgoGSP algorithm = new AlgoGSP(support, mingap, maxgap, windowSize,abstractionCreator,true);


        System.out.println(sequenceDatabase.toString());

        try {
            algorithm.runAlgorithm(sequenceDatabase,keepPatterns,verbose,"out.txt", outputSequenceIdentifiers);
        } catch (IOException ex) {
            Logger.getLogger(Testgsp.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(algorithm.getNumberOfFrequentPatterns()+ " frequent pattern found.");

        System.out.println(algorithm.printedOutputToSaveInFile());
        
        //System.out.println(algorithm.printStatistics());
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = Testgsp.class.getResource(filename);
        if (url != null) {
            return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
        }

        System.out.println("file: " + filename + " not found");
        System.exit(-1); // or return empty string or null
        return "";
    }
}

