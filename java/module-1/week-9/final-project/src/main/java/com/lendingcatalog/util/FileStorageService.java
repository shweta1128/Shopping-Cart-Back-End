package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    //Scanner userInput = new Scanner(System.in);
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException, FileNotFoundException {
        try ( PrintWriter writer = new PrintWriter(new FileOutputStream(filename , appendFile))){
            writer.println(contents);


// we use FileOutputStream in order to use appendFile
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist");
        }
    }
        public static List<String> readContentsOfFile (String filename)  {
//
          List<String> readingFile = new ArrayList<>();
           File file = new File(filename) ;
            try (Scanner dataInput = new Scanner(file)) {
               // System.out.println("I am inside the try block");
                while(dataInput.hasNextLine()) {
                    String lineOfInput = dataInput.nextLine();
                    readingFile.add(lineOfInput);
                }
                return readingFile;
            } catch (FileNotFoundException e) {
                System.err.println("The file does not exist.");
                throw new RuntimeException(e);
            }

           // return readingFile;
        }
    }

