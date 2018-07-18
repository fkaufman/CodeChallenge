package challenge.autocomplete.trie;

import java.util.List;

import challenge.autocomplete.model.Candidate;

public interface AutoCompleteProvider {
	
	List<Candidate> getWords(String fragment);
	
	void train(String passage);
}
