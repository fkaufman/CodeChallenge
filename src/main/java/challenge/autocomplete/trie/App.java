package challenge.autocomplete.trie;

import java.util.List;
import java.util.Scanner;

import challenge.autocomplete.model.Candidate;

public class App {
	public static void main(String [] args) {
		RadixTrieWordComplete rt = new RadixTrieWordComplete();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Menu: - You must train the System first");
		System.out.println("Enter 1 to Train the System");
		System.out.println("Enter 2 to search via word prefix");
		System.out.print(">> ");
		int option = keyboard.nextInt();
		if(option == 1) {
			System.out.println("Enter training passage then press enter:\n");
		    String passage = keyboard.nextLine();
		    rt.train(passage);
		}
	    else if(option == 2 ) {
	    	System.out.println("Enter word prefix");
		    String fragment = keyboard.nextLine();
		    List<Candidate> words = rt.getWords(fragment);
		    System.out.println(words);
	    }
		
		
		System.out.println(option);
		
		keyboard.close();

	}
}
