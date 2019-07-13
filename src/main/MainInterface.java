package main;


import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.AlgoGSP;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.Item;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.Itemset;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.Sequence;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.SequenceDatabase;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.creators.AbstractionCreator;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.creators.AbstractionCreator_Qualitative;
import ca.pfv.spmf.algorithms.sequentialpatterns.gsp_AGP.items.patterns.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zayd
 */
public class MainInterface extends javax.swing.JFrame {

    private final JFileChooser openFileChooser;
    private final JFileChooser openTestChooser;
    private final JFileChooser openModelChooser;
    private DefaultTableModel dm;
    private String outFilePathPos;
    private String outFilePathNeg;
    private String[] output;
    private final JFileChooser saveModelChooser;
    private Thread workerPos;
    private Thread workerNeg;
    private AlgoGSP algorithmPos;
    private AlgoGSP algorithmNeg;
    private Thread workerTest;
    /**
     * Creates new form MainInterface1
     */
    public MainInterface() {
        initComponents();
        this.openFileChooser = new JFileChooser();
        this.openFileChooser.setCurrentDirectory(new File("./"));
        this.openTestChooser = new JFileChooser();
        this.openTestChooser.setCurrentDirectory(new File("./"));
        this.openModelChooser = new JFileChooser();
        this.openModelChooser.setCurrentDirectory(new File("./"));
        this.saveModelChooser = new JFileChooser();
        this.saveModelChooser.setCurrentDirectory(new File("./"));
        this.resultTable.setAutoCreateRowSorter(true);
        
        setupTable();
    }
    
    public void setupTable(){
        String header[] = new String [] {"Sequence", "Resultat de GSP"};
            final Class[] classes = new Class[]{String.class, String.class};
            this.dm = new DefaultTableModel(0,0){

                @Override
                public Class<?> getColumnClass(int columnIndex){
                    if (columnIndex < classes.length) 
                        return classes[columnIndex];
                    return super.getColumnClass(columnIndex);
                }

            };
           
            dm.setColumnIdentifiers(header);
            this.resultTable.setModel(dm);
            /*
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.resultTable.getModel());
            this.resultTable.setRowSorter(sorter);
            sorter.setComparator(0, new Comparator<String>() {
                @Override
                public int compare(String name1, String name2) {
                    if(name1.length()-name2.length() == 0){
                        return name1.compareTo(name2);
                    }
                    return name1.length()-name2.length();
                }
            });

            class FloatComparator implements Comparator {
                public int compare(Object o1, Object o2) {
                    float dif = (float)o1-(float)o2;
                    if (dif == 0) return 0;
                    if (dif > 0) return 1;
                    return -1;
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            sorter.setComparator(2, new FloatComparator());

            class IntComparator implements Comparator {
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) 0;
                    Integer int2 = (Integer) 0;
                    if (o1.getClass() == Integer.class){
                       int1 = (Integer)o1;
                    }else if(o1.getClass() == Double.class){
                        Double d1 = (Double) o1;
                        int1 = d1.intValue();
                    }else if(o1.getClass() == Float.class){
                        Float d1 = (Float) o1;
                        int1 = d1.intValue();
                    }

                    if (o2.getClass() == Integer.class){
                       int2 = (Integer)o2;
                    }else if(o2.getClass() == Double.class){
                        Double d2 = (Double) o2;
                        int2 = d2.intValue();
                    }else if(o2.getClass() == Float.class){
                        Float d2 = (Float) o2;
                        int2 = d2.intValue();
                    }

                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            sorter.setComparator(1, new IntComparator());
            */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        ouvrirBtn = new javax.swing.JButton();
        filePathLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        minSuppTF = new javax.swing.JTextField();
        analyserBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        saveModel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        itemIndex = new javax.swing.JTextField();
        algoProg = new javax.swing.JProgressBar();
        stop = new javax.swing.JButton();
        openTestBtn = new javax.swing.JButton();
        testPathLbl = new javax.swing.JLabel();
        classIndex = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        seq2Pred = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loadModelBtn = new javax.swing.JButton();
        modelPath = new javax.swing.JLabel();
        predBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ouvrirBtn.setText("Ouvrir fichier principale...");
        ouvrirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirBtnActionPerformed(evt);
            }
        });

        filePathLbl.setText("...");

        jLabel5.setText("Minimum support");

        minSuppTF.setText("1.0");
        minSuppTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minSuppTFActionPerformed(evt);
            }
        });

        analyserBTN.setText("Analyser");
        analyserBTN.setToolTipText("");
        analyserBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyserBTNActionPerformed(evt);
            }
        });

        resultArea.setEditable(false);
        resultArea.setColumns(20);
        resultArea.setRows(5);
        jScrollPane2.setViewportView(resultArea);

        saveModel.setText("sauvgarder le model");
        saveModel.setEnabled(false);
        saveModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModelActionPerformed(evt);
            }
        });

        jLabel3.setText("l'index des items");

        itemIndex.setText("1");
        itemIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemIndexActionPerformed(evt);
            }
        });

        stop.setText("stop");
        stop.setEnabled(false);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        openTestBtn.setText("Ouvrir fichier test ...");
        openTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTestBtnActionPerformed(evt);
            }
        });

        testPathLbl.setText("...");

        classIndex.setText("0");
        classIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIndexActionPerformed(evt);
            }
        });

        jLabel4.setText("l'index du classe");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(saveModel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(testPathLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ouvrirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filePathLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(openTestBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(itemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(minSuppTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(classIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)
                                .addComponent(stop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(analyserBTN))
                            .addComponent(algoProg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ouvrirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filePathLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openTestBtn)
                    .addComponent(testPathLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minSuppTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(classIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(analyserBTN)
                        .addComponent(jLabel3)
                        .addComponent(itemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stop)))
                .addGap(7, 7, 7)
                .addComponent(algoProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveModel)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("création de model", jPanel1);

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "sequence", "Resultat de GSP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(resultTable);

        seq2Pred.setToolTipText("");

        jLabel2.setText("Sequnce");

        loadModelBtn.setText("Selectionner le model");
        loadModelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadModelBtnActionPerformed(evt);
            }
        });

        modelPath.setText("...");

        predBtn.setText("Classer l'item");
        predBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(74, 74, 74)
                        .addComponent(seq2Pred, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(loadModelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modelPath)))
                .addContainerGap(261, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(predBtn))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(seq2Pred, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadModelBtn)
                    .addComponent(modelPath))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(predBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("prédiction", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void minSuppTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minSuppTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minSuppTFActionPerformed

    private void analyserBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyserBTNActionPerformed
        // get the db file path
        String filePath = this.filePathLbl.getText();
        // remove all the rows from the table
        this.dm.setRowCount(0);
        // reset the output
        this.output = new String[] {"","","","","","","",""};
        // startAlgo is used to know if the fields are set correctly
        int startAlgo = 0;
        
        // check if the user choosed a file or not
        if(!filePath.equals("...")){
            startAlgo ++;
        }else{
            //show error
            JOptionPane.showMessageDialog(this, 
                        "Veuillez choisir un fichier d'entrainement valide!!",
                        "fichier introuvable",
                        JOptionPane.ERROR_MESSAGE);
        }
        double minSupp = 0.0;
        try{
            // check if the uer entered a valid min-supp
            minSupp = Double.parseDouble(this.minSuppTF.getText());
            if(minSupp > 0){
                startAlgo ++;
            }else{
                if(startAlgo == 1)
                    JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de Minimum support!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException nfe){
            //show error
            if(startAlgo == 1)
                JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de Minimum support!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }
        // get the test db file
        String testPath = this.testPathLbl.getText();
        // check if the user choosed a valid test file
        if(!testPath.equals("...")){
            startAlgo ++;
        }else{
            if(startAlgo == 2)
                JOptionPane.showMessageDialog(this, 
                    "Veuillez choisir un fichier de test valide!!",
                    "valeur erronée",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        int index = 0;
        try{
            // verify the value of item index
            index = Integer.parseInt(this.itemIndex.getText());
            if(index >= 0){
                startAlgo ++;
            }else{
                if(startAlgo == 3)
                JOptionPane.showMessageDialog(this, 
                    "Vérifier la valeur de taille de \"index des items\"!!",
                    "valeur erronée",
                    JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException nfe){
            //show error
            if(startAlgo == 3)
                JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de \"index des items\"!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, 
                        e.getMessage(),
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }
        
        int classIndex = 0;
        try{
            // verify the class index
            classIndex = Integer.parseInt(this.classIndex.getText());
            if(classIndex >= 0){
                startAlgo ++;
            }else{
                if(startAlgo == 4)
                JOptionPane.showMessageDialog(this, 
                    "Vérifier la valeur de taille de \"index des items\"!!",
                    "valeur erronée",
                    JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException nfe){
            //show error
            if(startAlgo == 4)
                JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de taille de \"index des items\"!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, 
                        e.getMessage(),
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }
        
        // if all values are set correctly
        if(startAlgo == 5){
            
            //setting the algorithm parameters
            double support = minSupp, mingap = 0, maxgap = 1, windowSize = 0;
            boolean keepPatterns = true;
            boolean verbose=false;
            // if you set the following parameter to true, the sequence ids of the sequences where
            // each pattern appears will be shown in the result
            boolean outputSequenceIdentifiers = false;
            AbstractionCreator abstractionCreator = AbstractionCreator_Qualitative.getInstance();
            
            // prepare positive db
            SequenceDatabase sequenceDatabaseTrainPos = new SequenceDatabase(abstractionCreator);
            // prepare negative db
            SequenceDatabase sequenceDatabaseTrainNeg = new SequenceDatabase(abstractionCreator);

            AbstractionCreator abstractionCreatorTest = AbstractionCreator_Qualitative.getInstance();
            // prepare test db
            SequenceDatabase sequenceDatabaseTest = new SequenceDatabase(abstractionCreatorTest);

            try {
                // read the sequence database and store the values in a variable
                // read positive db
                sequenceDatabaseTrainPos.loadFile(java.net.URLDecoder.decode(filePath,"UTF-8"), support,"+",index,classIndex);
                
                // read negative db
                sequenceDatabaseTrainNeg.loadFile(java.net.URLDecoder.decode(filePath,"UTF-8"), support,"-",index,classIndex);
                
                // read test db
                sequenceDatabaseTest.loadFile(java.net.URLDecoder.decode(testPath,"UTF-8"), support, index, classIndex);
                
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                                              "Veuillez choisir un fichier valide!!",
                                              "fichier introuvable",
                                              JOptionPane.ERROR_MESSAGE);
            }
            // check if the user entered a % value for min-supp or an absolute value
            boolean isAbsolute = (support>=1);
            
            // initiate the AlgoGSP for both neg and pos
            algorithmPos = new AlgoGSP(support, mingap, maxgap, windowSize,abstractionCreator,isAbsolute);
            algorithmNeg = new AlgoGSP(support, mingap, maxgap, windowSize,abstractionCreator,isAbsolute);
            
            // create temp files to store the output of the algorithm
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
            LocalDate localDate = LocalDate.now();
            String[] path = filePath.split("\\\\");
            String filename = new File(filePath).getName();
            String tmp = System.getProperty("java.io.tmpdir");
            this.outFilePathPos = tmp+"Out"+filename+"_"+support+"_"+dtf.format(localDate)+"_pos.csv";
            this.outFilePathNeg = tmp+"Out"+filename+"_"+support+"_"+dtf.format(localDate)+"_neg.csv";
            
            // update the output to inform the user about the updates
            output[0] = "\nles motifs de la classe \"+\" sont stockés dans le fichier:"
                    + this.outFilePathPos
                    + "\nles motifs de la classe \"-\" sont stockés dans le fichier:"
                    + this.outFilePathNeg;
            this.resultArea.setText("".join("\n", output));
            
            // create the tmp files
            try {
                File file = new File(outFilePathPos);
                Files.deleteIfExists(file.toPath());
                file.createNewFile();
                
                file = new File(outFilePathNeg);
                Files.deleteIfExists(file.toPath());
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // update the state of buttons
            stop.setEnabled(true);
            saveModel.setEnabled(false);
            
            // create nez thread for the test process
            workerTest = new Thread(){
                public void run() {
                    // new variables to count the (Taux de connaissance)
                    int ctrCor = 0;// how much sequences are correctly predicted
                    int ctrMal = 0;// how much sequences are not correctly predicted

                    String[] res = new String[2]; // this variable is used to update the table.
                    
                    // get the test sequences
                    List<Sequence> seqs = sequenceDatabaseTest.getSequences();
                    
                    // iterate for each sequence in test sequences
                    for (Sequence seq : seqs) {
                        boolean predicted = false;
                        double posValImp = Integer.MAX_VALUE;
                        double negValImp = Integer.MAX_VALUE;
                        
                        // loop until we get a different values of posValImp and negValImp
                        while(!predicted && (posValImp != 0.0 && negValImp != 0.0)){
                            // get the maximum value from the positive algorithm
                            posValImp = testAlgo(seq, posValImp, outFilePathPos);
                            // get the maximum value from the negative algorithm
                            negValImp = testAlgo(seq, negValImp, outFilePathNeg);
                            
                            //if posValImp > negValImp then the predicted class should be "+"
                            // else the predited class should be "-"
                            // if they are equal then we search for second maximum value from the algorithms and so on 
                            if(posValImp > negValImp){
                                if(seq.getClasse().equals("+")){
                                    ctrCor ++;
                                }else{
                                    ctrMal ++;
                                }
                                predicted = true;
                                res[0]=seq.toString();
                                res[1]="+";
                                publish(res);

                            }else if(posValImp < negValImp){
                                if(seq.getClasse().equals("-")){
                                    ctrCor ++;
                                }else{
                                    ctrMal ++;
                                }
                                predicted = true;
                                res[0]=seq.toString();
                                res[1]="-";
                                publish(res);
                            }//end if
                            
                        }//end while
                        
                        // if we couldn't find two difrent values for (posValImp and negValImp) then we couldn't predict the class
                        if(!predicted){
                            ctrMal ++;
                            res[0]=seq.toString();
                            res[1]="Impossible de prédire la classe (50% de possibilité)";
                            publish(res);
                        }
                    }//end foreach
                    
                    // calculate the (Taux de connaissance) and update the status in the screen
                    String[] re = new String[1];
                    re[0] = "\nLe taux de connaissance est "+(float)(ctrCor*100/(ctrMal + ctrCor));
                    publish(re);
                    
                    
                    // update the UI ( progressbar and buttons )
                    algoProg.setIndeterminate(false);
                    try{
                        stop.setEnabled(false);
                        analyserBTN.setEnabled(true);
                        saveModel.setEnabled(true);
                        
                    }catch (Exception e){
                        
                    }
                     
                }
                
                public void publish(String[] mostRecentVal){
                    if(mostRecentVal.length > 1){
                        // update the table
                        dm.addRow(new Object[]{mostRecentVal[0],mostRecentVal[1]});
                    }else{
                        // inform the user about the state
                        output[7] = mostRecentVal[0];
                        MainInterface.this.resultArea.setText("".join("\n",output));
                    }
                    
                }
            };
            
            
            // new thread to train the positive class
            workerPos = new Thread(){
                public void run() {
                    // update the UI
                    algoProg.setIndeterminate(true);
                    MainInterface.this.analyserBTN.setEnabled(false);
                    output[1] = "\n***calcule des sequences positives ...";
                    MainInterface.this.resultArea.setText("".join("\n",output));// inform the user about the state

                    try {
                        // train the positive algorithm
                        algorithmPos.runAlgorithm(sequenceDatabaseTrainPos,keepPatterns,verbose,outFilePathPos, outputSequenceIdentifiers);
                        
                        // update the UI
                        output[2] = algorithmPos.getNumberOfFrequentPatterns() + " Sequences positives trouvées.";
                        MainInterface.this.resultArea.setText("".join("\n",output));// inform the user about the state 
                        
                        output[3] = algorithmPos.printStatistics();
                        MainInterface.this.resultArea.setText("".join("\n",output));// inform the user about the state
                        
                        if(workerNeg != null){ // if the negative algorithm finished we start the test.
                            if(!workerNeg.isAlive()){
                                workerTest.start();
                            }
                        }
                        
                        
                    } catch (Exception ex) {
                    }
                    
                    
                    
                }
            };
            
            // new thread to train the negative algorithm
            workerNeg = new Thread(){
                public void run() {
                    try {
                        
                        // update the UI
                        algoProg.setIndeterminate(true);
                        MainInterface.this.analyserBTN.setEnabled(false);
                        output[4] = "\n***calcule des sequences negatives ...";
                        MainInterface.this.resultArea.setText("".join("\n",output)); // inform the user about the state
                        
                        // train the negative algorithm
                        algorithmNeg.runAlgorithm(sequenceDatabaseTrainNeg,keepPatterns,verbose,outFilePathNeg, outputSequenceIdentifiers);
                        
                        // update the UI
                        output[5] = algorithmNeg.getNumberOfFrequentPatterns() + " Sequences positives trouvées.";
                        output[6] = algorithmNeg.printStatistics();
                        MainInterface.this.resultArea.setText("".join("\n",output)); // inform the user about the state
                        
                        if(workerPos != null){// if the positive algorithm finished we start the test.
                            if(!workerPos.isAlive()){
                                workerTest.start();
                            }
                        }
                        
                        
                    } catch (Exception ex) {
                    }
                        
                    
                    
                }
            };
            
            workerPos.setPriority(Thread.MAX_PRIORITY);
            workerPos.start();
            
            workerNeg.setPriority(Thread.MAX_PRIORITY);
            workerNeg.start();
            
        }
    }//GEN-LAST:event_analyserBTNActionPerformed

    /**
     * It return the max valImp of pattern that exist in the passed sequence
     * 
     * @param seq the sequence to predict;
     * @param valImpBorder the maximum border;
     * @param outFile the file that contains the result of the GSP algorithm;
     *
     * @return maxValImp in this interval [0,valImpBorder]
     */
    public double testAlgo(Sequence seq, Double valImpBorder, String outFile){
        String thisLine;
        BufferedReader myInput = null;
        double maxValImp = 0.0;
        
        try{
            FileInputStream fis = new FileInputStream(new File(outFile));
            myInput = new BufferedReader(new InputStreamReader(fis));
                        
            while ((thisLine = myInput.readLine()) != null) {
                String[] pattern = thisLine.split(",");
                Sequence mySeq = new Sequence(0);
                mySeq.fromString(format(pattern[0]).split(" "));
                Pattern p = new Pattern();
                boolean b = true;
                int i =0;
                for (Itemset item : mySeq.getItemsets()) {
                    for(Item it : item.getItems()){
                        try{
                            int[] o = seq.searchForTheFirstAppearance(i, 0, it);
                            if(o != null){
                                i = o[0]+1;
                                b = true;
                            }else{
                                b = false;
                                break;
                            }
                        }catch(Exception e){
                            b = false;
                        }
                    }
                    if(!b)
                    break;
                    
                }
                
                if(b){
                    double valImp = Double.parseDouble(pattern[pattern.length-1]);
                    if(valImp < valImpBorder)
                        maxValImp = (valImp>maxValImp)? valImp : maxValImp;    
                }
                
            }
        }catch(Exception e){
        }finally{
            if (myInput != null) {
                try {
                    myInput.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return maxValImp;
    }
    
    private void ouvrirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ouvrirBtnActionPerformed
        // TODO add your handling code here:
        int returnVal = this.openFileChooser.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            filePathLbl.setText(openFileChooser.getSelectedFile().getAbsolutePath());    
        }
    }//GEN-LAST:event_ouvrirBtnActionPerformed

    private void predBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predBtnActionPerformed
        // update the UI
        predBtn.setEnabled(false);
        
        // if the user did not entered a seq
        if(seq2Pred.getText().trim().equals("")){
            JOptionPane.showMessageDialog(MainInterface.this, 
                        "Veuillez introduire une sequence SVP!!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            predBtn.setEnabled(true);
            return ;
        }
        
        
        Thread worker2 = new Thread(){
            public void run() {
                Sequence mySeq = new Sequence(0);
                mySeq.fromString(format(seq2Pred.getText().trim()).split(" "));

                BufferedReader myInputs = null;
                try{
                    // get the files paths for (negative algo and the positive algo) from the model file
                    Path mPath = Paths.get(modelPath.getText());
                    FileInputStream fis = new FileInputStream(new File(mPath.toString()));
                    myInputs = new BufferedReader(new InputStreamReader(fis));
                    String thisLine;
                    thisLine = myInputs.readLine();
                    String posFile = mPath.getParent().toString() + thisLine.split(":")[1];
                    thisLine = myInputs.readLine();
                    String negFile = mPath.getParent().toString() + thisLine.split(":")[1];
                    
                    // predict the sequence class
                    boolean predicted = false;
                    double posValImp = Integer.MAX_VALUE;
                    double negValImp = Integer.MAX_VALUE;
                    while(!predicted && (posValImp != 0.0 && negValImp != 0.0)){
                        posValImp = testAlgo(mySeq, posValImp, posFile);
                        negValImp = testAlgo(mySeq, negValImp, negFile);
                        String[] s = new String[2];
                        s[0] = mySeq.toString();
                        if(posValImp > negValImp){
                            s[1] = "+";
                            publish(s);
                            predicted = true;
                        }else if(posValImp < negValImp){
                            s[1] = "-";
                            publish(s);
                            predicted = true;
                        }
                    }
                    if(!predicted){
                        String[] s = new String[2];
                        s[0]=mySeq.toString();
                        s[1]="Impossible de prédire la classe (50% de possibilité)";
                        publish(s);
                    }


                }catch(Exception e){
                    JOptionPane.showMessageDialog(MainInterface.this, 
                        "Veuillez choisir un moddel valide!!",
                        "model introuvable",
                        JOptionPane.ERROR_MESSAGE);
                }finally{
                    if (myInputs != null) {
                        try {
                            myInputs.close();
                        } catch (IOException ex) {
                            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                // update the UI
                predBtn.setEnabled(true);
            }

            protected void publish(String[] mostRecentVal){
                // add the sequence and its predicted class to the table
                dm.addRow(new Object[]{mostRecentVal[0],mostRecentVal[1]});
            }
        };
            
        worker2.start();
          
    }//GEN-LAST:event_predBtnActionPerformed

    //format the sequence to be readable in the Library
    public String format(String line){
	String out = "";
        line = line.toLowerCase();
	boolean betweenBrkt = false;
	for(int i = 0; i<line.length(); i++){
            if(line.charAt(i) == '('){
                betweenBrkt = true;
            }else if(line.charAt(i) == ')'){
                betweenBrkt = false;
            }else if(line.charAt(i) != ' '){
                out += line.charAt(i) + " ";
            }
            if (i==line.length()-1){
                out += "-1 -2";
            }else if (!betweenBrkt && line.charAt(i) != ' '){
                out += "-1 ";
            }
	}

        return out;	
    }
    
    private void loadModelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadModelBtnActionPerformed
        // TODO add your handling code here:
        int returnVal = this.openModelChooser.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            modelPath.setText(openModelChooser.getSelectedFile().getAbsolutePath());    
        }
    }//GEN-LAST:event_loadModelBtnActionPerformed

    private void saveModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveModelActionPerformed
        // Save the model
        int returnVal = this.saveModelChooser.showSaveDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String outPath = saveModelChooser.getSelectedFile().getPath();
            try {
                BufferedWriter writer1 = new BufferedWriter(new FileWriter(outPath+".model"));

                writer1.write("pos:"+outFilePathPos.substring(outFilePathPos.lastIndexOf("\\")));
                writer1.newLine();
                writer1.write("neg:"+outFilePathNeg.substring(outFilePathNeg.lastIndexOf("\\")));
                writer1.newLine();
                writer1.close();
            } catch (IOException ex) {
                Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                modelPath.setText(outPath+".model");
                try {
                    Files.copy(Paths.get(outFilePathNeg), Paths.get(outPath.substring(0,outPath.lastIndexOf("\\"))+outFilePathNeg.substring(outFilePathNeg.lastIndexOf("\\"))), StandardCopyOption.REPLACE_EXISTING);
                    Files.copy(Paths.get(outFilePathPos), Paths.get(outPath.substring(0,outPath.lastIndexOf("\\"))+outFilePathPos.substring(outFilePathPos.lastIndexOf("\\"))), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        
    }//GEN-LAST:event_saveModelActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // stop the algorithms
        if(workerPos != null && workerPos.isAlive()){
            workerPos = null;
            algorithmPos.stop();
        }
        if(workerNeg != null && workerNeg.isAlive()){
            workerNeg = null;
            algorithmNeg.stop();
        }
        
        // update the UI
        stop.setEnabled(false);
        analyserBTN.setEnabled(true);
        saveModel.setEnabled(false);
        algoProg.setIndeterminate(false);
        
    }//GEN-LAST:event_stopActionPerformed

    private void openTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTestBtnActionPerformed
        
        int returnVal = this.openTestChooser.showOpenDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            testPathLbl.setText(openTestChooser.getSelectedFile().getAbsolutePath());    
        }
    }//GEN-LAST:event_openTestBtnActionPerformed

    private void classIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classIndexActionPerformed

    private void itemIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemIndexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemIndexActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar algoProg;
    private javax.swing.JButton analyserBTN;
    private javax.swing.JTextField classIndex;
    private javax.swing.JLabel filePathLbl;
    private javax.swing.JTextField itemIndex;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadModelBtn;
    private javax.swing.JTextField minSuppTF;
    private javax.swing.JLabel modelPath;
    private javax.swing.JButton openTestBtn;
    private javax.swing.JButton ouvrirBtn;
    private javax.swing.JButton predBtn;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton saveModel;
    private javax.swing.JTextField seq2Pred;
    private javax.swing.JButton stop;
    private javax.swing.JLabel testPathLbl;
    // End of variables declaration//GEN-END:variables
}
