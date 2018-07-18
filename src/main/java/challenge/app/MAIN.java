package challenge.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import challenge.autocomplete.model.Candidate;
import challenge.autocomplete.trie.RadixTrieWordComplete;

public class MAIN {
	public static void main(String [] args) {
		RadixTrieWordComplete wordCompleter = new RadixTrieWordComplete();
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				System.out.println("RUN OPTIONS: (t)Train the system, (p)Prefix word search, "
						+ " (w)Word frequency, \n\t (e)Examine the data structure, (q)quit");
				System.out.print("option input >> ");
				String line = br.readLine();
				char option = line.charAt(0);
				switch (option) {
				    case 't': {
				    	System.out.println("Enter a training passage");
				    	System.out.print(">> ");
				    	String passage = br.readLine();
				    	wordCompleter.train(passage);
				    	break;
				    }
				    case 'p': {
				    	System.out.println("Prefix word search");
				    	System.out.print(">> ");
				    	String fragment = br.readLine();
				    	System.out.println(fragment + "-> " + wordCompleter.getWords(fragment) + "\n");
				    	break;
				    }
				    case 'w': {
				    	System.out.println("dictionary: " + wordCompleter.examineCandidates() + "\n");
				    	break;
				    }
				    case 'e': {
				    	System.out.println(wordCompleter.toString() + "\n");
				    	break;
				    }
				    case 'q': {
				    	System.out.println("--program exit");
				    	System.exit(0);
				    }
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		

	}
}
