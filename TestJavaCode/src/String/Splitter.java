package String;

import java.util.regex.Pattern;

public class Splitter {
	public final static int Index_Sentence_Action_ALL = 0;

	// private final String SpecialSign_Sentence_Chi = "　』 ";
	// private final String SpecialSign_Sentence_Eng = "\"\'";
	private final String Sign_Sentence_Chi = "。！？；";
	private final String Sign_Sentence_Eng = ".!?;";
	private final String Sign_Sentence = Sign_Sentence_Chi + Sign_Sentence_Eng;

	// private Pattern pattern;

	// public Splitter(int Action) {
	// switch(Action){
	// case Index_Action_Sentence:
	// pattern = Pattern.compile(Sign_Sentence);
	// break;
	// }
	// }

	public String[] splitSentence(String Document, int Action) {
		Pattern pattern = null;
		switch (Action) {
		case Index_Sentence_Action_ALL:
			pattern = Pattern.compile(Sign_Sentence);
			break;
		}
		return (pattern != null) ? pattern.split(Document) : null;
	}
}
