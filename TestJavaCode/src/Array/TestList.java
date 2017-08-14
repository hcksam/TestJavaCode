package Array;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

public class TestList {
	public static Map<String,LinkedList<String>> data = getData();
			
	public static Map<String,LinkedList<String>> getData(){
		Map<String,LinkedList<String>> allData = new TreeMap<String,LinkedList<String>>();
		LinkedList<String> data = new LinkedList<String>();
		data.add("TestJob2_1");
		data.add("TestJob2_2");
		data.add("TestJob2_3");
		allData.put("TestJob1", data);
		
		data = new LinkedList<String>();
		allData.put("TestJob2_1", data);
		allData.put("TestJob2_3", data);
		allData.put("TestJob4", data);
		
		data = new LinkedList<String>();
		data.add("TestJob3");
		allData.put("TestJob2_2", data);
		
		data = new LinkedList<String>();
		data.add("TestJob4");
		allData.put("TestJob3", data);
		
		return allData;
	}
	
	public static LinkedList<String> getJobList(LinkedList<String> jobList, LinkedList<String> nextJobs) throws Exception{
		jobList.addAll(nextJobs);
		for (String nextJob:nextJobs){
			jobList = getJobList(jobList, getNextJobs(nextJob));
		}
		return jobList;
	}
	
	public static LinkedList<String> getNextJobs(String jobName) throws Exception{
		return data.get(jobName);
	}
	
	public static void testMain(){
		LinkedList<String> l1 = new LinkedList<String>();
		LinkedList<String> l2 = new LinkedList<String>();
		l2.add("1");
		l2.add("2");
		l2.add("3");
		l1.addAll(l2);
		l2.remove(1);
		
		for (String s:l1){
			System.out.println(s);
		}
		
		for (String s:l2){
			System.out.println(s);
		}
	}
	
	public static void testMain2() throws Exception{
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("TestJob1");
		l1 = getJobList(l1, getNextJobs("TestJob1"));
		
		for (String s:l1){
			System.out.println(s);
		}
	}
	
	public static void testMain3(){
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("1");
		l1.add("2");
		l1.add("3");
		LinkedList<String> l2 = new LinkedList<String>(l1);
		l1.remove(1);
		
		for (String s:l1){
			System.out.println(s);
		}
		
		for (String s:l2){
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws Exception{
//		TestList.testMain();
		
//		TestList.testMain2();
		
		TestList.testMain3();
		
		System.out.println("Complete");
	}
}
