public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;
    public CirculatingBook(String author,String title,String isbn,String callNumber){
	super(author,title,isbn,callNumber);
	currentHolder = null;
	dueDate = null;
    }
    public String getCurrentHolder(){return currentHolder;}
    public String getDueDate(){return dueDate;}
    public void setCurrentHolder(String currentHolder){this.currentHolder = currentHolder;}
    public void setDueDate(String dueDat){this.dueDate = dueDate;}
    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }
    public void returned(){
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus(){
	if(currentHolder == null){
	    return "book available on shelves";
	}
	else{
	    return currentHolder + ", " + dueDate;
	}
    }
    public String toString(){
	String fin = super.toString();
	if(currentHolder != null){
	    fin += ", "+ currentHolder+", "+dueDate;
	}
	return fin;
    }
}
