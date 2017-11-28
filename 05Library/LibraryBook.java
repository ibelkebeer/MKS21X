public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;
    public LibraryBook(String author,String title,String isbn,String callNumber){
	this.author = author;
	this.title = title;
	this.isbn = isbn;
	this.callNumber = callNumber;
    }
    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public String getISBN(){return isbn;}
    public String getCallNumber(){return callNumber;}
    public void setAuthor(String author){this.author = author;}
    public void setTitle(String title){this.title = title;}
    public void setISBN(String isbn){this.isbn = isbn;}
    public void setCallNumber(String callNumber){this.callNumber = callNumber;}
    public String toString(){return title+", "+author+", "+isbn+", "+callNumber;}
    public abstract void checkout(String patron, String due);
    public abstract void returned();
    
