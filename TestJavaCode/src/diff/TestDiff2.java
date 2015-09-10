package diff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import difflib.DiffUtils;
import difflib.Patch;
import difflib.PatchFailedException;

public class TestDiff2 {

	public static void main(String[] args) throws PatchFailedException {
		// TODO Auto-generated method stub
		String s1 = "CF Y已編輯 1 個項目";
		String s2 = "CF Y已重新命名 1 個項目";
		String cs = "測試";
		for (int i=0;i<10;i++){
			s1 = cs + s1;
			s2 = cs + s2;
		}
		for (int i=0;i<10;i++){
			s1 += cs;
			s2 += cs;
		}
		
		LinkedList<String> s1s = new LinkedList<String>();
		s1s.add(s1);
		LinkedList<String> s2s = new LinkedList<String>();
		s1s.add(s2);
		
		List<String> results = new LinkedList<String>();
		
		Patch patch = DiffUtils.diff(s1s, s2s);
		results = (List<String>) DiffUtils.patch(s1s, patch);
		
		for (String result:results){
			System.out.println(result);
			System.out.println("String size: "+s1.getBytes().length);
			System.out.println("Patch size: "+result.getBytes().length);
		}
	}

}
