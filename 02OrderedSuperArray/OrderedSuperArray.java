public class OrderedSuperArray extends SuperArray{
    public OrderedSuperArray(){
	super();
    }
    public OrderedSuperArray(int capacity){
	super(capacity);
    }
    public OrderedSuperArray(String[] ary){
	super();
	for(int x=0; x<ary.length; x++){
	    add(ary[x]);
	}
    }
    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }
    public void add(int index, String element){
	add(element);
    }
    private int findIndex(String element){
	for(int x=0; x<super.size(); x++){
	    if(element.compareTo(get(x)) <= 0){
		return x;
	    }
	}
	return super.size();
    }
    private int findIndexBinary(String element){
	int lb = 0;
	int ub = super.size()-1;
	int ci;
	while(lb <= ub){
	    ci = (ub+lb)/2;
	    if(ci == 0 && element.compareTo(get(ci)) <= 0){
		return 0;
	    }
	    if(element.compareTo(get(ci)) >= 1){
		lb = ci + 1;
	    }
	    else if(element.compareTo(get(ci)) <= 0 && element.compareTo(get(ci-1)) >= 1){
		return ci;
	    }
	    else{
		ub = ci - 1;
	    }
	}
	return super.size();
    }
    public boolean add(String element){
	if(super.size() == 0){
	    super.add(element);
	    return true;
	}
	super.add(findIndexBinary(element), element);
	return true;
    }
}

