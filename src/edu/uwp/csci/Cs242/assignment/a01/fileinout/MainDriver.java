package edu.uwp.csci.Cs242.assignment.a01.fileinout;

import java.util.Scanner;
import java.io.PrintWriter;

public class MainDriver {
    public static void main(String args[]) {
        FileInOut fio = new FileInOut("infile.txt", "outfile.txt", true);

        Scanner in = fio.getInFile();
        PrintWriter out = fio.getOutFile();

        System.out.println("Starting MainDriver().");

        while (in.hasNextLine()) {
            String word = in.nextLine();
            out.print(word + "\n");
        }

        fio.closeFiles();

        System.out.println("Ending MainDriver().");
    }
}
