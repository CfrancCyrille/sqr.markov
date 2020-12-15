package markov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MarkovChain {
	
	/** Paramètre NGRAM de la chaine de Markov (Séquence de mot proche) */
	private int ngram;
	/** Générateur de nombre random rgen  */
	private Random rgen = new Random();
	/** Déclaration de la valeur de stockage MarkovData  */
    private MarkovData data = null;

    /** Créateur de la classe MarkovChain */
	public MarkovChain (int ngram){
		this.ngram = ngram;
		this.data = new MarkovData();
	}

    /** Fonction learn */
	public void learn(String text) {
		data.read(text);
		
		// Apprendre jusqu'au dernier mot NGRAM
        int maxwords = data.keyWordSize() - ngram - 1;
        String keyString = null;
        int end;
        
        // Recherche du prochain empaquetage du mot NGRAM
        for (int j = 0; j < maxwords; j++) {
            keyString = "";
            end = j + ngram;
            for(int k = j; k < end; k++) {
                keyString = keyString + data.getKeyWord(k) + " ";
            }
			keyString = keyString.trim(); // Retirer les espaces finaux
			
			String wordToLearn = data.getKeyWord(end);
			
			boolean isNewKey = data.renforceWord(keyString, wordToLearn);
			if(!isNewKey) {
				if(end <= maxwords)	{
					data.learnWord(keyString, wordToLearn);
				}
			}
        }
	}

    /**Fonction de génération de Markov */
    public String generateMarkov(int numWords) {
        // Consrtuit une chaîne aléatoire en utilisant la table de chaînes de Markov ci-dessus
        String buffer = "";
        String newword = "";
        String keyString = "";
        
        // Initialisation du générateur de nombres aléatoires
        List<String> lastwords = new ArrayList<String>();
        int possible = data.keyWordSize() - ngram;
		int startnum = rgen.nextInt(possible);
		
		// Obtenir la chaîne de mots de début aléatoire des mots NGRAM
        for (int i = startnum, j = 0; i < startnum+ngram; i++,j++){ 	
        	newword = data.getKeyWord(i);
			lastwords.add(j, newword);
            buffer += newword + " ";
        }

        // Boucle jusqu'à ce que numWords soit généré
        for(int i = ngram; i < numWords; i++){
            keyString = "";
            
            // Générer la KeyChain
            for (int j = 0; j < ngram; j++) {
                keyString = keyString + lastwords.get(j) + " ";
            }
            // Retirer les espaces en fin
			keyString = keyString.trim();		
			
			// Si NGRAM présent dans la liste, ajoutez le mot suivant
			if(data.containsKeyWord(keyString))	{
		        List<String> possiblenext = new ArrayList<String>();
                possiblenext = Arrays.asList(data.getLearnedWord(keyString).split(" "));
                int c = possiblenext.size();	// Au moins de 1
               	int r = rgen.nextInt(c);
                
                String nextword = possiblenext.get(r);
                buffer += nextword +" ";
                for (int j = 0; j < ngram-1; j++) {
                	// Décalage des mots vers la gauche
                    lastwords.set(j, lastwords.get(j+1));	
                }
                // Ajoute le dernier mot à la fin
                lastwords.set(ngram-1, nextword);			
            }
        }

         return buffer.trim();
    }

	public void setRgen(Random rgen) {
		this.rgen = rgen;
	}    
}
