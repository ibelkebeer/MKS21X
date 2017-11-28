public class Book{
    private String author;
    private String title;
    private String isbn;
    public Book(String author, String title, String isbn){
	this.author = author;
	this.title = title;
	this.isbn = isbn;
    }
    public Book(){
    }
    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public String getISBN(){return isbn;}
    public void setAuthor(String author){this.author = author;}
    public void setTitle(String title){this.title = title;}
    public void setISBN(String isbn){this.isbn = isbn;}
    public String toString(){return title+", "+author+", "+isbn;}
}
