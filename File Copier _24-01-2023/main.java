import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;
import java.io.*;

public class main {

    // main method
    final static String folderPath = "C:\\adil\\";

    public static void main(String[] args) throws IOException {
        System.out.print("Input file Name : ");
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        try {
            File src = new File(folderPath + fileName);
            String outputFile = outputFileName(fileName);
            File dest = new File(folderPath + outputFile);

            // Coping source file to destination file
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Output File Name : " + outputFile);
        } catch (NoSuchFileException e) {
            System.out.print("File Not Found");
        }

    }

    // This method will find the output file name
    public static String outputFileName(String fileName) {
        String[] file = fileName.split("\\.");
        int i = 1;
        String name = "";

        File outputFile = new File(folderPath + file[0] + " - copy." + file[1]);

        // When there is no copy of the input file
        if (!outputFile.exists()) {
            return file[0] + " - copy." + file[1];
        }

        // When there is already a copied file present
        while (true) {
            outputFile = new File(folderPath + file[0]
                    + " - copy(" + i + ")." + file[1]);
            if (outputFile.exists()) {
                i++;
            } else {
                name = file[0] + " - copy(" + i + ")." + file[1];
                break;
            }
        }
        return name;
    }
}