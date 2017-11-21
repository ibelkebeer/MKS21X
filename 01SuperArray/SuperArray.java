public class SuperArray{
    private String[] data;
    private int size;
    public SuperArray(){
	data = new String[10];
	size = 0;
    }
    public SuperArray(int capacity){
	data = new String[capacity];
	size = capacity;
    }
    public void clear(){
	for(int x=0; x < size ; x++){
	    data[x] = "";
	}
	size = 0;
    }
    public int size(){
	return size;
    }
    public boolean isEmpty(){
	if(size == 0){
	    return true;
	}
	return false;
    }
    public boolean add(String element){
	if(size == data.length){
	    resize();
	}
	data[size] = element;
	size++;
	return true;
    }
    public String toString(){
	String fin = "[";
	for(int x=0; x<size; x++){
	    fin += data[x] + ",";
	}
	if(fin.length() > 1){
	    fin = fin.substring(0, fin.length() - 1);
	}
	fin += "]";
	return fin;
    }
    public String get(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }
    public String set(int index, String element){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	data[index] = element;
	return old;
    }
    private void resize(){
	String[] fin = new String[data.length * 2];
	for(int x=0; x<data.length; x++){
	    fin[x] = data[x];
	}
	data = fin;
    }
    public boolean contains(String element){
	for(int x=0; x<size; x++){
	    if(data[x].equals(element)){
		return true;
	    }
	}
	return false;
    }
    public int indexOf(String element){
	for(int x=0; x<size; x++){
	    if(data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }
    public int lastIndexOf(String element){
	for(int x=size-1; x>=0; x--){
	    if(data[x].equals(element)){
		return x;
	    }
	}
	return -1;
    }
    public void add(int index, String element){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	if(size == data.length){
	    resize();
	}
	for(int x=size; x>index; x--){
	    data[x] = data[x-1];
	}
	data[index] = element;
	size++;
    }
    public String remove(int index){
	if(index < 0 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	String old = data[index];
	for(int x=index; x<size; x++){
	    data[x] = data[x+1];
	}
	size--;
	return old;
    }
    public boolean remove(String element){
	for(int x=0; x<size; x++){
	    if(data[x].equals(element)){
		remove(x);
		return true;
	    }
	}
	throw new IllegalArgumentException();
    }
}
    
	
