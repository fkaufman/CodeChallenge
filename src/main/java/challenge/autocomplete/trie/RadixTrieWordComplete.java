package challenge.autocomplete.trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import challenge.autocomplete.model.Candidate;
import challenge.autocomplete.model.CandidateImpl;

/**
 * RadixTrieWordComplete is a challenge coding exercise.
 * The challenge mimics the auto-complete feature used in texting on mobile phones.
 * The main feature of the class is the uses of the Apache Foundations Commons Collection4
 * PatriciaTrie.  A PatriciaTrie is a Radix Tree structure that supports the use of a prefix
 * Map to return possible matches.  
 * 
 * Word values are held in a Candidate POJO object which has a confidence value for reflecting
 * the number of times a word has been used.
 * 
 * @author Fred Kaufman
 * fred.kaufman@gmail.com
 *
 */

public class RadixTrieWordComplete implements AutoCompleteProvider {

	static Trie<String, Candidate> trie = new PatriciaTrie<>();
	
	/**
	 * When passed a word fragment the prefix is passed into the Trie and all words
	 *  that match that prefix will be returned.
	 */
	@Override
	public List<Candidate> getWords(String fragment) {
		SortedMap<String, Candidate> prefixMap = trie.prefixMap(fragment);
        List<Candidate> candidates = new ArrayList<>(prefixMap.values());
        Collections.sort(candidates, Collections.reverseOrder());
		return candidates;
	}

	/**
	 * String passage which will be tokenized and added to the Trie structure.
	 * Duplicates are handled by incrementing the confidence value.
	 */
	@Override
	public void train(String passage) {
		StringTokenizer st = new StringTokenizer(passage);
		while (st.hasMoreTokens()) {
		    String token = st.nextToken();
		    if(trie.containsKey(token.toLowerCase())) {
		    	Candidate candidate = (Candidate)trie.get(token.toLowerCase());
		    	candidate.incrementConfidenceValue();
		    	trie.replace(token.toLowerCase(), candidate);
		    }
		    else {
		    	trie.put(token.toLowerCase(), new CandidateImpl(token));
		    }
		}	
	}

	/**
	 * 
	 * @return the actual word values stored in the map. 
	 */
	public Collection<Candidate> examineCandidates() {
		return trie.values();
	}
	
	/**
	 * 
	 * @return keySet
	 */
	public Set<String> examineKeys() {
		return trie.keySet();
	}
	
	/**
	 * 
	 * @return the Trie Structure
	 */
	public Trie<String, Candidate> getTrie() {
		return trie;
	}
	
	public String toString() {
		return trie.toString();
	}

}
