import java.util.*;
public class SuperArrayIterator implements Iterator<String>{
    int current,end;
    SuperArray data;
    public SuperArrayIterator(int stop, SuperArray data){
	current = 0;
	end = stop;
	this.data = data;
    }
    public void remove(){
	throw new UnsupportedOperationException();
    }
    public String next(){
	if(hasNext()){
	    current++;
	}else{
	    System.exit(0);
	}
	return data.get(current-1);
    }
    public boolean hasNext(){
	return current < end;
    }
}
