import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
public class termfreqs{
    public static void main(String[] args)throws FileNotFoundException{
        ArrayList<String> terms = new ArrayList<String>();
        ArrayList<Integer> frequency = new java.util.ArrayList<Integer>();
        if(args.length < 3) {
            System.out.println("Error can't find termfreqs, INPUT_DOC_FILE, OUTPUT_TERM_FILE, OUTPUT_FREQFILE, try again");
        System.exit(1);}
        Scanner inputFromFile = new Scanner(new FileInputStream(args[0]));
        PrintWriter outputTerms = new PrintWriter(args[1]);
        PrintWriter outputFrequency = new PrintWriter(args[2]);
        lookAt(inputFromFile,terms,outputTerms,frequency,outputFrequency);
        inputFromFile.close(); 
        outputTerms.close(); 
        outputFrequency.close();}
    public static void lookAt(Scanner scan, ArrayList<String> ArrayOfTerms, PrintWriter TermsPrintWriter, ArrayList<Integer> FrequencyArray, PrintWriter FrequencyPrintWriter){
        scan.useDelimiter("[^a-zA-Z0-9]+");
        while(scan.hasNext()){
            String RunnerUpString = (scan.next()).toLowerCase();
            if(ArrayOfTerms.contains(RunnerUpString)){ 
                int x = ArrayOfTerms.indexOf(RunnerUpString);
                FrequencyArray.set(x, FrequencyArray.get(x) +1);
            }else{
                ArrayOfTerms.add(RunnerUpString);
                FrequencyArray.add(1);}}
        scan.close();
        for (String term : ArrayOfTerms){
            TermsPrintWriter.println(term);}
        for(int frequency : FrequencyArray){
            FrequencyPrintWriter.println(frequency);}}}