public class ReversedCharSequence implements CharSequence{
    private String seq = "";
    public ReversedCharSequence(String sequence){
	for(int x=sequence.length()-1; x>=0; x--){
	    seq += sequence.substring(x,x+1);
	}
    }
    public char charAt(int index){
	if(index < 0 || index >= seq.length()){
	    throw new IndexOutOfBoundsException();
	}
	return seq.charAt(index);
    }
    public int length(){
	return seq.length();
    }
    public ReversedCharSequence subSequence(int start,int end){
	if(start < 0 || end >= seq.length() || start > end){
	    throw new IndexOutOfBoundsException();
	}
	String old = seq.substring(start,end);
	String fin = "";
	for(int x=old.length()-1; x>=0; x--){
	    fin += old.substring(x,x+1);
	}
	return new ReversedCharSequence(fin);
    }
    public String toString(){
	return seq;
    }
}
	
