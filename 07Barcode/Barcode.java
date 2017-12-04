public class Barcode{
    private String zip;
    private String barcode = "";
    public Barcode(String zip){
	this.zip = zip;
	makeBarcode(zip);
    }
    private void makeBarcode(String zip){
	int sum = 0;
	for(int x=0; x<zip.length(); x++){
	    sum += Integer.parseInt(zip.substring(x,x+1));
	}
	zip += sum/zip.length();
	for(int x=0; x<zip.length(); x++){
	    if(zip.charAt(x) == '0'){
		barcode += "||:::";
	    }
	    if(zip.charAt(x) == '1'){
		barcode += ":::||";
	    }
	    if(zip.charAt(x) == '2'){
		barcode += "::|:|";
	    }
	    if(zip.charAt(x) == '3'){
		barcode += "::||:";
	    }
	    if(zip.charAt(x) == '4'){
		barcode += ":|::|";
	    }
	    if(zip.charAt(x) == '5'){
		barcode += ":|:|:";
	    }
	    if(zip.charAt(x) == '6'){
		barcode += ":||::";
	    }
	    if(zip.charAt(x) == '7'){
		barcode += "|:::|";
	    }
	    if(zip.charAt(x) == '8'){
		barcode += "|::|:";
	    }
	    if(zip.charAt(x) == '9'){
		barcode += "|:|::";
	    }
	}
	zip = zip.substring(0,zip.length()-1);
    }
    public String getZip(){return zip;}
    public String getCode(){return this.toString();}
    public String toString(){return "|" + barcode + "|";}
    public int compareTo(Barcode other){return zip.compareTo(other.zip);}
    public boolean equals(Barcode other){
	if(zip.compareTo(other.zip) == 0){
	    return true;
	}
	return false;
    }
}
	
	
	
	
