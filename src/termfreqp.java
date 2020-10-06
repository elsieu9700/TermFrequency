import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintWriter;
public class termfreqp{
    private static ArrayList<String> terms = new ArrayList<String>(); 
    private static ArrayList<Integer> frequency = new ArrayList<Integer>();
    private static int nextThreadId = 0;
    private final static ReentrantLock RLock = new ReentrantLock();
static class SearchForTerms implements Runnable {
     private int threadId;
     private int beginning; 
     private int finish; 
     private ArrayList<String> file;
     public SearchForTerms(int beginning, int finish, ArrayList<String> file) {
         this.file = file;
         this.beginning = beginning;
         this.finish = finish;}
     public void run() {
         nextThreadId ++;
         threadId = nextThreadId;
         lookAtTerms(beginning, finish, file); }}
     private static void lookAtTerms(int beginning, int finish, ArrayList<String> file){
        for(int i = beginning; i < finish; i++) {
            RLock.lock();
            try{ 
              if(terms.contains(file.get(i))){ 
                  int x = terms.indexOf(file.get(i));
                  frequency.set(x, frequency.get(x)+1 ); 
              }else{
                  terms.add(file.get(i));
                  frequency.add(1);}
            }finally{
                RLock.unlock();}}}
     public static void main(String[] args)throws FileNotFoundException, InterruptedException{
        if(args.length < 4) {
		System.out.println("Error can't find termfreqs, INPUT_DOC_FILE, OUTPUT_TERM_FILE, OUTPUT_FREQFILE, try again");
		System.exit(1);}
        int numWorkers = Integer.parseInt(args[0]);
        Scanner inputFromFile = new Scanner(new FileInputStream(args[1]));
        ArrayList<String> TermsFromFile = new ArrayList<String>();
        inputFromFile.useDelimiter("[^a-zA-Z0-9_]+");
        while(inputFromFile.hasNext()){
            TermsFromFile.add((inputFromFile.next()).toLowerCase());}
        inputFromFile.close();
        PrintWriter OutputTerms = new PrintWriter(args[2]);
        PrintWriter OutputFrequency = new PrintWriter(args[3]);
        int levels = TermsFromFile.size()/numWorkers;
        Runnable[] serviceThreads = new Runnable[numWorkers];
        for (int i = 0; i< serviceThreads.length; i++){
            if(i == serviceThreads.length -1) 
                serviceThreads[i] = new SearchForTerms(levels*i, TermsFromFile.size(), TermsFromFile);
            else
            serviceThreads[i] = new SearchForTerms(levels*i, levels*(i+1), TermsFromFile);}
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(Runnable runnable: serviceThreads){
            executor.execute(runnable);}
        executor.shutdown();
        while(!executor.isTerminated());
        for (String term : terms)
            OutputTerms.println(term);
        for (Integer Frequency : frequency)
            OutputFrequency.println(Frequency);
        OutputTerms.close();
        OutputFrequency.close();}}
