package challenge.autocomplete.model;

public class CandidateImpl implements Candidate, Comparable<Candidate> {
	String word;
	int confidence;
	
	public CandidateImpl() {}
	
	public CandidateImpl(String word) {
		this.word = word;
		this.confidence = 1;
	}

	@Override
	public String getWord() {
		return word;
	}

	@Override
	public Integer getConfidence() {
		return new Integer(confidence);
	}

	@Override
	public int incrementConfidenceValue() {
		this.confidence++;
		return confidence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + confidence;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateImpl other = (CandidateImpl) obj;
		if (confidence != other.confidence)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return word + " (" + confidence + ") ";
	}

    @Override
    public int compareTo(Candidate o ) {
    	return getConfidence().compareTo(o.getConfidence());
    }
	
}
