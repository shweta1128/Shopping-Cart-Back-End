package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();
        System.out.println("What is the source file?");
        String sourcePath = userInput.nextLine();
        System.out.println("What is the destination file?");
        String destination = userInput.nextLine();

        File object = new File(sourcePath);

       // Open both the input and output files.
        try (Scanner fileInput = new Scanner(object);
             PrintWriter writer = new PrintWriter(destination)) {
            // Write the text in uppercase to the output file.


        while (fileInput.hasNextLine()) {
            // Read the next line into 'lineOfText'
            String lineOfText = fileInput.nextLine();// it's holding a bunch of lines
            //lineCount++;
            writer.println(lineOfText.replace(searchWord, replacementWord));
            // Print the file to the user
        }
    } catch (FileNotFoundException e) {
        // Could not find the file at the specified path.
        System.err.println("The file was not found: " );

    }

    }

    static private File getConvertedFile(File bookFile) {
        // Get the name of the book file
        String bookPath = bookFile.getAbsolutePath();

        // Insert ".ham" into the book file path to arrive at a name for the converted file.
        int dotIndex = bookPath.lastIndexOf('.');
        String convertedPath;
        if (dotIndex >= 0) {
            // found an extension, like .txt
            convertedPath = bookPath.substring(0, dotIndex) + ".ham." + bookPath.substring(dotIndex + 1);
        } else {
            // There is no file extension
            convertedPath = bookPath + ".ham";
        }
        return new File(convertedPath);
    }
}