package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class TestSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] data = {
				{"a","5.1", "8.8", "4.3", "1", "7"},
				{"b","7", "8.8", "4.3", "2", "7"},
				{"c","1.1", "8.8", "4.3", "3", "7"},
				{"d","1", "8.8", "4.3", "4", "7"},
				{"e","2.1", "8.8", "4.3", "5", "7"}
		};
		
//		Arrays.sort(data, new Comparator<String[]>() {
//		    public int compare(String[] a, String[] b) {
//		    	try{
//		    		double da = Double.parseDouble(a[1]);
//		    		double db = Double.parseDouble(b[1]);
//		    		int index = Double.compare(da, db);
//		    		if (index < 0){
//		    			return 1;
//		    		}else if (index > 0){
//		    			return -1;
//		    		}else{
//		    			return 0;
//		    		}
//		    	}catch(NumberFormatException ne){
//		    		return 0;
//		    	}
//		    }
//		});
		
		for (int i=0;i<data.length;i++){
			for (int j=0;j<data[i].length;j++){
				System.out.print(data[i][j]+"||");;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		int[] si = getSortIndex(data);
		for (int i=0;i<si.length;i++){
			System.out.print(si[i]+"||");;
		}
		System.out.println();
		System.out.println();
		for (int i=0;i<data.length;i++){
			for (int j=0;j<data[i].length;j++){
				System.out.print(data[si[i]][j]+"||");;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
//		sortValue(data);
//		for (int i=0;i<data.length;i++){
//			String[] temp = new String[data[i].length-1];
//			for (int j=1;j<data[i].length;j++){
//				temp[j-1] = data[i][j];
//			}
//			Arrays.sort(temp);
//			for (int j=1;j<data[i].length;j++){
//				data[i][j] = temp[j-1];
//			}
//		}
//		
		for (int i=0;i<data.length;i++){
			for (int j=0;j<data[i].length;j++){
				System.out.print(data[i][j]+"||");;
			}
			System.out.println();
		}
	}
	
	
	
	//Modified selection sort algrothim
	public static void selectionSort(int[][] data){
	    for (int i = 0; i < data[0].length; i++){
	        int index = i;

	        for (int j = i + 1; j < data[0].length; j++){
	            if (data[0][j] < data[0][index]){
	                index = j;
	            }
	        }
	        
	        int smallerNumber = data[0][index];//Sort the first half like you would a 1D array
	        int smallerNumber2 = data[1][index];//When a value will be moved in the first half sort, prepare the number in the same index to be swapped

	        data[0][index] = data[0][i];//swap first half 
	        data[1][index] = data[1][i];//swap corresponding number in second half

	        data[0][i] = smallerNumber;//complete first half swap
	        data[1][i] = smallerNumber2;//complete second half swap
	    }
	}
	
	public static void sortValue(String[][] data) {
		for(int i=0; i < data.length; i++){
			for(int j=1; j < (data.length-i); j++){
				try{
					double da = Double.parseDouble(data[j-1][1]);
					double db = Double.parseDouble(data[j][1]);
				    if(da < db){
				        String temp = data[j-1][1];
				        data[j-1][1] = data[j][1];
				        data[j][1] = temp;
				    }
				}catch(NumberFormatException ne){
				}
		    }
		}
	}
	
	public static int[] getSortIndex(String[][] data) {
		int[] sortIndex = new int[data.length];
		String[][] sortedData = new String[data.length][2];
		
		for (int i=0;i<data.length;i++){
			sortIndex[i] = i;
			sortedData[i][0] = data[i][0];
			sortedData[i][1] = data[i][1];
		}
		
		for(int i=0; i < sortedData.length; i++){
			for(int j=1; j < (sortedData.length-i); j++){
				try{
					double da = Double.parseDouble(sortedData[j-1][1]);
					double db = Double.parseDouble(sortedData[j][1]);
				    if(da < db){
				        String temp = sortedData[j-1][1];
				        sortedData[j-1][1] = sortedData[j][1];
				        sortedData[j][1] = temp;
				        int tempIndex = sortIndex[j-1];
				        sortIndex[j-1] = sortIndex[j];
						sortIndex[j] = tempIndex;
				    }
				}catch(NumberFormatException nfe){
					nfe.printStackTrace();
				}
		    }
		}
		
		return sortIndex;
	}
	
//	public static int[] getSortIndex(String[][] data) {
//		int[] sortIndex = new int[data.length];
//		String[][] sortedData = new String[data.length][data[0].length];
//		
//		for (int i=0;i<data.length;i++){
//			sortIndex[i] = i;
//			for (int j=0;j<data[i].length;j++){
//				sortedData[i][j] = data[i][j];
//			}
//		}
//		
//		for(int i=0; i < sortedData.length; i++){
//			for(int j=1; j < (sortedData.length-i); j++){
//				try{
//					double da = Double.parseDouble(sortedData[j-1][1]);
//					double db = Double.parseDouble(sortedData[j][1]);
//				    if(da < db){
//				        String temp = sortedData[j-1][1];
//				        sortedData[j-1][1] = sortedData[j][1];
//				        sortedData[j][1] = temp;
//				        int tempIndex = sortIndex[j-1];
//				        sortIndex[j-1] = sortIndex[j];
//						sortIndex[j] = tempIndex;
//				    }
//				}catch(NumberFormatException ne){
//				}
//		    }
//		}
//		
//		return sortIndex;
//	}
}