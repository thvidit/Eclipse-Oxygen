package Hackerrank;

public class operations {
	
	public int findMiddle(int n){
		int middle =-1;
		if(n%2 == 0){
			middle = n/2;
		}else{
			middle = n/2 +1;
		}
		return middle-1;
	}
	
	public void reverse(int[] arr, int middle, int end){
		int length = arr.length;
		int[] a = new int[middle+1];
		int[] b = new int[length-middle-1];
		int[] c = new int[length];
		int k=0,l=0;
		
		for(int i = middle;i >= 0;i--){
			
			a[k] = arr[i];
			k++;
		}
		
		
		int z=0;
		for(int j = end; j>middle;j--){
			b[l] = arr[j];
			l++;
		}
		
		sort(a);
		sort1(b);
		
		for(z=0;z<a.length;z++){
			c[z] = a[z];
		}
		
		for(int v=0;v<b.length;v++){
			if(z<length){
			c[z] = b[v];
			z++;
			}
		}
		
		for(int h=0;h<length;h++){
			System.out.println(" " + c[h]);
		}
		
		System.out.println("Pyramid 1");
		
		makePyramid(a);
		
		System.out.println("Pyramid 2");
		
		makePyramid(b);
	
	}
	
	public void makePyramid(int[] numbers){
		int n = numbers.length;
		int id = 0;
		int numRows = 0;

	
		while(id < n){
		    numRows++; 
		    for(int numInRow=0; numInRow<numRows; numInRow++){
		        id++;
		    }
		}
		
		int sum=0;
		for(int f=1;f<=numRows;f++){
			sum = sum +f;
		}
		
		if(sum ==n){
			numRows  =numRows;
		}else{
			numRows= numRows -1;
		}
		

		
		id = 0;
		for(int i=1; i <= numRows && id < n; i++){
		    for(int j=0; j < (numRows-i) ; j++){
		        System.out.print(" "); 
		    }

		    for(int j=0; j<i; j++){       
		        System.out.print(numbers[id++] +" "); 
		        if(id >= n){
		            break; 
		        }
		    }
		    System.out.println(); 
		}
	}
	
	//for first array
	void sort(int arr[])
    {
        int n = arr.length;
 
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
	
	//for second array
	void sort1(int arr[])
    {
        int n = arr.length;
 
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] > arr[min_idx])
                    min_idx = j;
 
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
	
	//for complete array
	void ascDsc(int[] arr,int n){
		int[] c = new int[n];
		for (int i = 0; i < n / 2; i++) 
	        System.out.print(arr[i]+" ");
	
	    for (int j = n - 1; j >= n / 2; j--)
	    	System.out.print(arr[j]+" ");
		
	}

}
