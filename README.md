
This is a coding challenge for a company that I'm interviewing with.
It is a word auto-complete implementation which is similar to what you would find in a mobile
telephone messaging app.  The model is first trained and then when given a prefix of a couple letters the auto-completer will find other relevant words and the confidence score of how many 
times that word occurs in the Trie.

To build:   You must have maven configured and running Java1.8 JDK

> build.sh 

To run:   The jar has been built as a shaded executable

> java -jar ./target/CodeChallenge-0.0.1-SNAPSHOT.jar
or
> run.sh  - will get you there too.

