public class Sorts{
    public static String name(){
	return "10.Belkebir.Imad";
    }
    public static void selectionSort(int[] data){
	for(int x=0; x<data.length-1; x++){
	    int index = x;
	    int min = data[x];
	    for(int y=x; y<data.length; y++){
		if(data[y] < min){
		    min = data[y];
		    index = y;
		}
	    }
	    int temp = data[x];
	    data[x] = data[index];
	    data[index] = temp;
	}
    }
    public static void insertionSort(int[] data){
	for(int x=1; x<data.length; x++){
	    int index = x;
	    if(data[x] < data[x-1]){
		while(index > 0 && data[index] < data[index-1]){
		    int temp = data[index];
		    data[index] = data[index-1];
		    data[index-1] = temp;
		    index--;
		}
	    }
	}
    }
    public static void bubbleSort(int[] data){
	boolean sorted = false;
	int length = data.length;
	while(!sorted){
	    length--;
	    sorted = true;
	    for(int x=0; x < length; x++){
		if(data[x] > data[x+1]){
		    int temp = data[x];
		    data[x] = data[x+1];
		    data[x+1] = temp;
		    sorted = false;
		}
	    }
	}
    }
}
