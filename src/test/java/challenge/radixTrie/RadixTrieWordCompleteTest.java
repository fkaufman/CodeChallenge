package challenge.radixTrie;

import org.junit.Before;
import org.junit.Test;

import challenge.autocomplete.model.Candidate;
import challenge.autocomplete.trie.RadixTrieWordComplete;

import java.util.List;
import java.util.Set;

public class RadixTrieWordCompleteTest {
    RadixTrieWordComplete rt = new RadixTrieWordComplete();

    @Before
    public void setup() {
		rt.train("what hath God wrought");
		rt.train("this that there thing done this that this these");
    }

    @Test
    public void examineRadixTrie() {
    	System.out.println(rt);
    }
    
    @Test
    public void trainTest() {
    	rt.train("the time clock ticks as the time thus passes");
    	List<Candidate> words = rt.getWords("clock");
    	assert(words.size() == 1);
    	
    }
    
    @Test
    public void trieGetWordsTest() {
        List<Candidate> candidates = rt.getWords("thi");
        assert(candidates.size() == 2);
        System.out.println(candidates);
        assert(candidates.get(0).getWord().equals("this"));
        assert(candidates.get(1).getWord().equals("thing"));
    }
    
    @Test
    public void checkConfidenceIncrement() {
    	rt.train("duck");
    	System.out.println(rt.getWords("duck"));
    	Set<String> keys = rt.examineKeys();
    	assert(keys.contains("duck"));
    	rt.train("duck");
    	System.out.println(rt.getWords("duck"));
    	
    }

}


