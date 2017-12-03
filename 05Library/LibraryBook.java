public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author,String title,String isbn,String callNumber){
	super(author,title,isbn);
	this.callNumber = callNumber;
    }
    public String getCallNumber(){return callNumber;}
    public void setCallNumber(String callNumber){this.callNumber = callNumber;}
    public String toString(){return super.toString()+", "+callNumber;}
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    public abstract String circulationStatus();
    public int compareTo(LibraryBook a){
	if(callNumber.compareTo(a.callNumber) <= -1){
	    return -1;
	}
	if(callNumber.compareTo(a.callNumber) >= 1){
	    return 1;
	}
	return 0;
    }
}
