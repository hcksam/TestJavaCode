package diff;

import java.util.LinkedList;

import name.fraser.neil.plaintext.diff_match_patch;
import name.fraser.neil.plaintext.diff_match_patch.Diff;
import name.fraser.neil.plaintext.diff_match_patch.Operation;
import name.fraser.neil.plaintext.diff_match_patch.Patch;

public class TestDiff {
	public static void main(String[] args) {
		String s1 = "CF Y已編輯 1 個項目";
		String s2 = "CF Y已重新命名 1 個項目";
		String cs = "測試";
		for (int i=0;i<100;i++){
			s1 = cs + s1;
			s2 = cs + s2;
		}
		for (int i=0;i<100;i++){
			s1 += cs;
			s2 += cs;
		}
		diff_match_patch dmp = new diff_match_patch();
//		LinkedList<Diff> allDiffs = diffPatch.diff_main(s1, s2);
//		LinkedList<Diff> diffs = new LinkedList<Diff>();
//		for (Diff diff:allDiffs){
//			if (!diff.operation.equals(diff_match_patch.Operation.EQUAL)){
//				System.out.println(diff.text);
//			}
//		}
		LinkedList<Patch> s1patches = dmp.patch_make(s1, s2);
		LinkedList<Patch> s2patches = dmp.patch_make(s2, s1);
		String s1firstDiff = null;
		String s2firstDiff = null;
		int start = 0;
		for (Patch patche:s1patches){
			if (s1firstDiff != null){
				break;
			}
			for (Diff diff:patche.diffs){
				if (!diff.operation.equals(Operation.EQUAL)){
					s1firstDiff = diff.text;
					start = patche.start2;
					break;
				}
			}
		}
		
		for (Patch patche:s2patches){
			if (s2firstDiff != null){
				break;
			}
			for (Diff diff:patche.diffs){
				if (!diff.operation.equals(Operation.EQUAL)){
					s2firstDiff = diff.text;
					start = patche.start2;
					break;
				}
			}
		}
		
		System.out.println(dmp.patch_toText(s1patches));
		System.out.println("firstDiff: "+s1firstDiff);
		System.out.println("String size: "+s1.getBytes().length);
		System.out.println("Patch size: "+dmp.patch_toText(s1patches).getBytes().length);
		Object[] os = dmp.patch_apply(s1patches, s1);
		String newText = String.valueOf(os[0]);
//		int index = newText.indexOf(firstDiff);
		int index = dmp.match_main(newText, s1firstDiff, start);
		boolean[] results = (boolean[]) os[1];
		System.out.println("new Text: "+newText);
		System.out.println("new Text(boolean): "+newText.equals(s2));
		int c = 0;
		for (boolean result:results){
			System.out.println("result["+c+++"]: "+result);
		}
		System.out.println(index);
//		System.out.println("index: "+newText.charAt(index));
	}

}
