package app;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import markov.MarkovChain;

/** pas besoin de teste

         */

public class MarkovApp {
	
	public static void main(String[] args) throws Exception {
        String sentences = readFileAsString("./target/classes/VictorHugo_LesMiserables-II-Cosette.txt");
        System.out.println(sentences);

        MarkovChain markov = new MarkovChain(3);
        markov.learn(sentences);

        System.out.println("Generation :\n");
        System.out.println(markov.generateMarkov(6));
        System.out.println(markov.generateMarkov(9));
        System.out.println(markov.generateMarkov(12));

    }

    /** a demontter
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String readFileAsString(String fileName) throws Exception { 
        String data = ""; 
        Path path = Paths.get(fileName); 
        data = Files.readString(path, StandardCharsets.UTF_8); 
        return data; 
    } 
    
}
