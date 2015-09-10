package diff;

import java.util.LinkedList;

import name.fraser.neil.plaintext.diff_match_patch.Diff;
import name.fraser.neil.plaintext.diff_match_patch.Patch;

public class TestTextPatchUtils {

	public static void main(String[] args) {
		String s1 = "CF Y已編輯 1 個項目";
		String s2 = "CF Y已重新命名 1 個項目";
		String cs = "測試";
//		for (int i=0;i<100;i++){
//			s1 = cs + s1;
//			s2 = cs + s2;
//		}
//		for (int i=0;i<100;i++){
//			s1 += cs;
//			s2 += cs;
//		}
		
		LinkedList<Patch> patches = TextPatchUtils.getPatches(s1, s2);
		LinkedList<Patch> patches2 = TextPatchUtils.getPatches(s2, s1);
		LinkedList<Patch> disPatches = TextPatchUtils.getDisPatches(patches);
		LinkedList<Diff> diffs = TextPatchUtils.getDiffs(s2, s1);
//		LinkedList<Diff> disDiffs = TextPatchUtils.getDisDiffs(diffs);
		LinkedList<Patch> disPatches2 = TextPatchUtils.getDisPatchesByDiffs(diffs);
		
		System.out.println("patches");
//		TextPatchUtils.displayPatches(patches);
		TextPatchUtils.displayDiffs(diffs);
		System.out.println("patches2");
		TextPatchUtils.displayPatches(patches2);
		System.out.println("disPatches");
		TextPatchUtils.displayPatches(disPatches2);
//		TextPatchUtils.displayDiffs(disDiffs);
		String newText = TextPatchUtils.applyPatches(disPatches2, s2);
		System.out.println("newText: "+newText);
	}

}
