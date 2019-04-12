
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
    private final JFileChooser openModelChooser;
    private final ExecutorService asyncExecutor;
    private DefaultTableModel dm;
    private String outFilePathPos;
    private String outFilePathNeg;
    private final JFileChooser saveModelChooser;
    private Thread workerPos;
    private Thread workerNeg;
    private AlgoGSP algorithmPos;
    private AlgoGSP algorithmNeg;
    private SwingWorker<Boolean,String[]> workerTest;
    /**
     * Creates new form MainInterface1
     */
    public MainInterface() {
        initComponents();
        this.openFileChooser = new JFileChooser();
        this.openFileChooser.setCurrentDirectory(new File("./"));
        this.openModelChooser = new JFileChooser();
        this.openModelChooser.setCurrentDirectory(new File("./"));
        this.saveModelChooser = new JFileChooser();
        this.saveModelChooser.setCurrentDirectory(new File("./"));
        this.resultTable.setAutoCreateRowSorter(true);
        this.asyncExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        
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
        jLabel1 = new javax.swing.JLabel();
        trainingsetSize = new javax.swing.JTextField();
        analyserBTN = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        saveModel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        itemIndex = new javax.swing.JTextField();
        algoProg = new javax.swing.JProgressBar();
        stop = new javax.swing.JButton();
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

        ouvrirBtn.setText("Ouvrir ...");
        ouvrirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ouvrirBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Minimum support");

        minSuppTF.setText("1.0");
        minSuppTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minSuppTFActionPerformed(evt);
            }
        });

        jLabel1.setText("Taille de trainingset");

        trainingsetSize.setText("70");

        analyserBTN.setText("Analyser");
        analyserBTN.setToolTipText("");
        analyserBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyserBTNActionPerformed(evt);
            }
        });

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

        stop.setText("stop");
        stop.setEnabled(false);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(analyserBTN))
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(trainingsetSize, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(533, 533, 533))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(itemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stop)
                                .addGap(81, 81, 81))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(saveModel)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ouvrirBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filePathLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(minSuppTF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(algoProg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ouvrirBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filePathLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(minSuppTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(trainingsetSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyserBTN)
                    .addComponent(jLabel3)
                    .addComponent(itemIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop))
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
                .addContainerGap(190, Short.MAX_VALUE))
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
        // TODO add your handling code here:
        String filePath = this.filePathLbl.getText();
        int startAlgo = 0;
        if(!filePath.equals("")){
            startAlgo ++;
        }else{
            //show error
            JOptionPane.showMessageDialog(this, 
                        "Veuillez choisir un fichier valide!!",
                        "fichier introuvable",
                        JOptionPane.ERROR_MESSAGE);
        }
        double minSupp = 0.0;
        try{
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
        
        int trainLength = 0;
        try{
            
            trainLength = Integer.parseInt(this.trainingsetSize.getText());
            if(trainLength > 0){
                startAlgo ++;
            }else{
                if(startAlgo == 2)
                    JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de taille de trainingset!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
            }
        }catch(NumberFormatException nfe){
            //show error
            if(startAlgo == 2)
                JOptionPane.showMessageDialog(this, 
                        "Vérifier la valeur de taille de trainingset!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, 
                        e.getMessage(),
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }
        
        int index = 0;
        try{
            
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
                        "Vérifier la valeur de taille de \"index des items\"!!",
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, 
                        e.getMessage(),
                        "valeur erronée",
                        JOptionPane.ERROR_MESSAGE);
        }
        
        
        if(startAlgo == 4){
            
            //run algorithm
            double support = minSupp, mingap = 0, maxgap = 1, windowSize = 0;

            boolean keepPatterns = true;
            boolean verbose=false;

            // if you set the following parameter to true, the sequence ids of the sequences where
            // each pattern appears will be shown in the result
            boolean outputSequenceIdentifiers = false;
            
            //for trainset
            AbstractionCreator abstractionCreator = AbstractionCreator_Qualitative.getInstance();
            SequenceDatabase sequenceDatabaseTrainPos = new SequenceDatabase(abstractionCreator);
            SequenceDatabase sequenceDatabaseTrainNeg = new SequenceDatabase(abstractionCreator);

            //for testSet
            AbstractionCreator abstractionCreatorTest = AbstractionCreator_Qualitative.getInstance();
            SequenceDatabase sequenceDatabaseTest = new SequenceDatabase(abstractionCreatorTest);

            try {
                sequenceDatabaseTrainPos.loadFile(java.net.URLDecoder.decode(filePath,"UTF-8"), support,0,trainLength,"+",index);
                sequenceDatabaseTrainNeg.loadFile(java.net.URLDecoder.decode(filePath,"UTF-8"), support,0,trainLength,"-",index);
                sequenceDatabaseTest.loadFile(java.net.URLDecoder.decode(filePath,"UTF-8"), index, support,trainLength);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                                              "Veuillez choisir un fichier valide!!",
                                              "fichier introuvable",
                                              JOptionPane.ERROR_MESSAGE);
            }

            boolean isAbsolute = (support>=1);
            algorithmPos = new AlgoGSP(support, mingap, maxgap, windowSize,abstractionCreator,isAbsolute);
            algorithmNeg = new AlgoGSP(support, mingap, maxgap, windowSize,abstractionCreator,isAbsolute);
            
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
            LocalDate localDate = LocalDate.now();
            String[] path = filePath.split("\\\\");
            String filename = new File(filePath).getName();
            this.outFilePathPos = "./Out"+filename+"_"+support+"_"+dtf.format(localDate)+"_pos.csv";
            this.outFilePathNeg = "./Out"+filename+"_"+support+"_"+dtf.format(localDate)+"_neg.csv";
            this.resultArea.setText("les motifs de la classe \"+\" sont stockés dans le fichier:"
                    + this.outFilePathPos
                    + "\nles motifs de la classe \"-\" sont stockés dans le fichier:"
                    + this.outFilePathNeg);
            try {
                File file = new File(outFilePathPos);
                file.createNewFile();
                
                file = new File(outFilePathNeg);
                file.createNewFile();
                //System.out.println("Empty File Created:- " + file.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
            stop.setEnabled(true);
            saveModel.setEnabled(false);
            workerTest = new SwingWorker<Boolean,String[]>(){
                
                protected Boolean doInBackground() throws Exception{
                    int ctrCor = 0;
                    int ctrMal = 0;
                    System.out.println("test began!!");
                    String[] res = new String[2];
                    for (Sequence seq : sequenceDatabaseTest.getSequences()) {
                        double posValImp = testAlgo(seq,outFilePathPos);
                        double negValImp = testAlgo(seq,outFilePathNeg);
                        if(posValImp > negValImp){
                            if(seq.getClasse().equals("+")){
                                ctrCor ++;
                            }else{
                                ctrMal ++;
                            }
                            res[0]=seq.toString();
                            res[1]="+";
                            publish(res);

                        }else if(posValImp < negValImp){
                            if(seq.getClasse().equals("-")){
                                ctrCor ++;
                            }else{
                                ctrMal ++;
                            }
                            res[0]=seq.toString();
                            res[1]="-";
                            publish(res);
                        }
                    }
                    if(ctrMal == 0){
                        //show error
                        String[] re = new String[1];
                        re[0] = "\n\ntoute les seq ont été classé correctement!!";
                        publish(re);
                    }
                    else{
                        String[] re = new String[1];
                        re[0] = "\n\nLe taux de connaissance est "+(float)(ctrCor*100/ctrMal);
                        publish(re);
                    }
                    return true;
                     
                }
                
                public void done(){
                    boolean status;
                    algoProg.setIndeterminate(false);
                    try{
                        status = get();
                        if(status){
                            stop.setEnabled(false);
                            analyserBTN.setEnabled(true);
                            if(workerPos != null && workerNeg != null)
                                saveModel.setEnabled(true);
                        }
                    }catch (Exception e){
                        
                    }
                }
                
                
                protected void process(List<String[]> chunks){
                    String[] mostRecentVal = chunks.get(chunks.size()-1);
                    if(mostRecentVal.length > 1){
                        dm.addRow(new Object[]{mostRecentVal[0],mostRecentVal[1]});
                    }else{
                        MainInterface.this.resultArea.setText(MainInterface.this.resultArea.getText()+mostRecentVal[0]);
                    }
                    
                }
            };
            
            workerPos = new Thread(){
                public void run() {
                    algoProg.setIndeterminate(true);
                    MainInterface.this.analyserBTN.setEnabled(false);
                    MainInterface.this.resultArea.setText(MainInterface.this.resultArea.getText()+"\n\n"
                                + "***calcule des sequences positives ...");
                    try {
                        algorithmPos.runAlgorithm(sequenceDatabaseTrainPos,keepPatterns,verbose,outFilePathPos, outputSequenceIdentifiers);
                        MainInterface.this.resultArea.setText(MainInterface.this.resultArea.getText()+"\n"
                                + "Sequences positives trouvées.");
                        if(workerNeg != null){
                            if(!workerPos.isAlive()){
                                workerTest.execute();
                            }
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            };
            workerPos.start();
            workerNeg = new Thread(){
                public void run() {
                    algoProg.setIndeterminate(true);
                    MainInterface.this.analyserBTN.setEnabled(false);
                    MainInterface.this.resultArea.setText(MainInterface.this.resultArea.getText()+"\n\n"
                                + "***calcule des sequences negatives ...");
                    try {
                        
                        algorithmNeg.runAlgorithm(sequenceDatabaseTrainNeg,keepPatterns,verbose,outFilePathNeg, outputSequenceIdentifiers);
                        MainInterface.this.resultArea.setText(MainInterface.this.resultArea.getText()+"\n"
                                + "Sequences négatives trouvées.");
                        
                        if(workerPos != null && workerNeg != null){
                            if(!workerPos.isAlive()){
                                workerTest.execute();
                            }
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            };
            workerNeg.start();
            
            
            
        }
    }//GEN-LAST:event_analyserBTNActionPerformed

    public double testAlgo(Sequence seq, String outFile){
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
                    maxValImp = (valImp>maxValImp)? valImp : maxValImp;    
                }
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
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
        // TODO add your handling code here:
        predBtn.setEnabled(false);
        if(seq2Pred.getText().trim().equals("")){
            JOptionPane.showMessageDialog(MainInterface.this, 
                        "Veuillez introduire une sequence SVP!!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            predBtn.setEnabled(true);
            return ;
        }
        SwingWorker<Boolean,String[]> worker2;
        worker2 = new SwingWorker<Boolean,String[]>(){
            protected Boolean doInBackground() throws Exception{
                Sequence mySeq = new Sequence(0);
                mySeq.fromString(format(seq2Pred.getText().trim()).split(" "));
                
                BufferedReader myInputs = null;
                try{

                    FileInputStream fis = new FileInputStream(new File(modelPath.getText()));
                    myInputs = new BufferedReader(new InputStreamReader(fis));
                    String thisLine;
                    thisLine = myInputs.readLine();
                    String posFile = thisLine.split(":")[1];
                    thisLine = myInputs.readLine();
                    String negFile = thisLine.split(":")[1];

                    double posValImp = testAlgo(mySeq,posFile);
                    double negValImp = testAlgo(mySeq,negFile);
                    String[] s = new String[2];
                    s[0] = mySeq.toString();
                    if(posValImp > negValImp){
                        s[1] = "+";
                        publish(s);
                    }else if(posValImp < negValImp){
                        s[1] = "-";
                        publish(s);
                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
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
                return true;
            }
            
            public void done(){
                predBtn.setEnabled(true);
            }
            
            protected void process(List<String[]> chunks){
                
                String[] mostRecentVal = chunks.get(chunks.size()-1);
                dm.addRow(new Object[]{mostRecentVal[0],mostRecentVal[1]});
                
                
            }
        };
        worker2.execute();
          
    }//GEN-LAST:event_predBtnActionPerformed

    public String format(String line){
	String out = "";
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
        // TODO add your handling code here:
        int returnVal = this.saveModelChooser.showSaveDialog(this);
        String outPath = "./"+this.outFilePathNeg.replace("neg", "model");
        if(returnVal == JFileChooser.APPROVE_OPTION){
            outPath = saveModelChooser.getSelectedFile().getPath();
        }
        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(outPath+".model"));
            
            writer1.write("pos:"+outFilePathPos);
            writer1.newLine();
            writer1.write("neg:"+outFilePathNeg);
            writer1.newLine();
            writer1.close();
        } catch (IOException ex) {
            Logger.getLogger(MainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            modelPath.setText(outPath+".model");
            
        }
    }//GEN-LAST:event_saveModelActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:
        if(workerPos != null && workerPos.isAlive()){
            workerPos = null;
            algorithmPos.stop();
        }
        if(workerNeg != null && workerNeg.isAlive()){
            workerNeg = null;
            algorithmNeg.stop();
        }
        stop.setEnabled(false);
        analyserBTN.setEnabled(true);
        saveModel.setEnabled(false);
        algoProg.setIndeterminate(false);
    }//GEN-LAST:event_stopActionPerformed

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
    private javax.swing.JLabel filePathLbl;
    private javax.swing.JTextField itemIndex;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loadModelBtn;
    private javax.swing.JTextField minSuppTF;
    private javax.swing.JLabel modelPath;
    private javax.swing.JButton ouvrirBtn;
    private javax.swing.JButton predBtn;
    private javax.swing.JTextArea resultArea;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton saveModel;
    private javax.swing.JTextField seq2Pred;
    private javax.swing.JButton stop;
    private javax.swing.JTextField trainingsetSize;
    // End of variables declaration//GEN-END:variables
}
