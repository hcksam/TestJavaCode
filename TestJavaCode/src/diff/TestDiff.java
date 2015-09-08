package diff;

import java.util.LinkedList;

import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;

public class TestDiff {

	public static void main(String[] args) {
		String s1 = "test1 test2 test3";
		String s2 = "test12 tset2";
		diff_match_patch diffPatch = new diff_match_patch();
		LinkedList<Diff> diffs = diffPatch.diff_main(s1, s2);
		for (Diff diff:diffs){
			if (diff.operation.equals(diff_match_patch.Operation.EQUAL)){
				System.out.println(diff.text);
			}
		}
	}

}
