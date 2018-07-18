package challenge.autocomplete.model;

public interface Candidate extends Comparable<Candidate>{
	
	String getWord();
	
	Integer getConfidence();
	
	int incrementConfidenceValue();
}
