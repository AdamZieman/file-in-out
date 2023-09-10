package edu.uwp.csci.Cs242.assignment.a01.fileinout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileInOut extends java.lang.Object {
    private final String DEFAULTINFILENAME = "default_in.txt";
    private final String DEFAULTOUTFILENAME = "default_out.txt";
    private String inFilename = null;
    private String outFilename = null;
    private Scanner inFile = null;
    private PrintWriter outFile = null;

    /**
     * <p>Three argument constructor to instantiate a FileInOut object.</p>
     *
     * <p>This constructor uses the provided input and output file names to set the objects internal input and output
     * file names. The files can also be opened by passing TRUE as the pOpenFlag parameter. </p>
     *
     *
     * @param pIn - String value for the name of the input file.
     * @param pOut - String value for the name of the output file.
     * @param pOpenFlag - Flag that determined whether the files will be opened or not. TRUE means that the files
     *                  should be opened; FALSE otherwise.
     */
    public FileInOut(String pIn, String pOut, boolean pOpenFlag) {
        setInFilename(pIn);
        setOutFilename(pOut);

        if (pOpenFlag) {
            openFiles();
        }
    }

    /**
     * <p>Meta-method that opens both the input file and the output file.</p>
     */
    public void openFiles() {
        this.openInFile();
        this.openOutFile();
    }

    /**
     * <p>
     *     Opens the input file for input using a Scanner.
     * </p>
     * <p>
     *     This method opens the file whose name is specified in the class level variable inFilename. The length is
     *     checked to ensure the variable has content. The file is opened via the Java Scanner class.
     * </p>
     */
    public void openInFile() {
        File text = new File(getInFilename());

        // TODO: check length of file
        // TODO: throw new vs try-catch block
        
        try {
            inFile = new Scanner(text);
        }
        catch (FileNotFoundException e) {
                System.out.println("File not found: " + inFilename);
        }
    }

    /**
     * <p>Opens the output file for output using a PrintWriter.</p>
     *
     * <p>This method opens the file whose name is specified in the class level variable outFilename. The length is
     * checked to ensure the variable has content. The file is opened via the Java PrintWriter class.</p>
     */
    public void openOutFile() {
        // TODO: check length of file
        // TODO: throw new vs try-catch block
        try {
            outFile = new PrintWriter(getOutFilename());
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + outFilename);
        }
    }

    /**
     * Meta-method to close all of the open files.
     */
    public void closeFiles() {
        this.closeInFile();
        this.closeOutFile();
    }

    /**
     * <p>Closes the input file.</p>
     */
    public void closeInFile() {
        inFile.close();
    }

    /**
     * <p>Closes the output file.</p>
     */
    public void closeOutFile() {
        outFile.close();
    }

    /**
     * <p>Retrieves the input file name.</p>
     *
     * @return String value of the input file name.
     */
    public String getInFilename() {
        return inFilename;
    }

    /**
     * <p>Sets the input file name.</p>
     *
     * @param inFilename - String value of the input file name.
     */
    public void setInFilename(String inFilename) {
        if (inFilename.length() != 0) {
            this.inFilename = inFilename;
        }
        else {
            this.outFilename = DEFAULTINFILENAME;
        }
    }

    /**
     * <p>Retrieves the output file name.</p>
     *
     * @return String value of the output file name.
     */
    public String getOutFilename() {
        return outFilename;
    }

    /**
     * <p>Sets the output file name.</p>
     *
     * @param outFilename - String value of the output file name.
     */
    public void setOutFilename(String outFilename) {
        this.outFilename = outFilename;
    }

    /**
     * <p>Retrieves the input Scanner.</p>
     *
     * @return Scanner object for performing input on the opened file.
     */
    public Scanner getInFile() {
        return inFile;
    }

    /**
     * Retrieves the output PrintWriter.
     *
     * @return PrintWriter object for performing output on the opened file.
     */
    public PrintWriter getOutFile() {
        return outFile;
    }
}
