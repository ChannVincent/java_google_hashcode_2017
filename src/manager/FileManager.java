package manager;

import java.io.*;

/**
 * Created by vchann on 17/02/2017.
 */
public class FileManager {

    static final public String outputFileExemple = "output/output_example.txt";
    static final public String outputFileSmall = "output/output_small.txt";
    static final public String outputFileMedium = "output/output_medium.txt";
    static final public String outputFileBig = "output/output_big.txt";

    static final public String inputFileExemple = "input/example.txt";
    static final public String inputFileSmall = "input/small.txt";
    static final public String inputFileMedium = "input/medium.txt";
    static final public String inputFileBig = "input/big.txt";

    public FileManager() {
        cleanOutputFiles();
    }

    /*
    Public methods
     */
    public void cleanOutputFiles() {
        writeFile("", outputFileExemple);
        writeFile("", outputFileSmall);
        writeFile("", outputFileMedium);
        writeFile("", outputFileBig);
    }

    /*
    Input
     */
    public String getBigInput() {
        return readFile(FileManager.inputFileBig);
    }

    public String getMediumInput() {
        return readFile(FileManager.inputFileMedium);
    }

    public String getSmallInput() {
        return readFile(FileManager.inputFileSmall);
    }

    public String getExempleInput() {
        return readFile(FileManager.inputFileExemple);
    }

    /*
    Output
     */
    public void writeBigOutput(String input) {
        writeFile(input, outputFileBig);
    }

    public void writeMediumOutput(String input) {
        writeFile(input, outputFileMedium);
    }

    public void writeSmallOutput(String input) {
        writeFile(input, outputFileSmall);
    }

    public void writeExempleOutput(String input) {
        writeFile(input, outputFileExemple);
    }

    /*
    Tests
     */
    public void test() {
        writeBigOutput(getBigInput());
        writeMediumOutput(getMediumInput());
        writeSmallOutput(getSmallInput());
        writeExempleOutput(getExempleInput());
    }

    /*
    Closed methods
     */
    protected String readFile(String filename) {
        String result = "";
        String line = null;
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filename + "'");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    protected void writeFile(String input, String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(input);
            bufferedWriter.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
