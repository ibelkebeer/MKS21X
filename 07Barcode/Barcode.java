public class Barcode{
    private String zip;
    private String barcode = "";
    public Barcode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	for(int x=0; x<5; x++){
	    if(!(Character.isDigit(zip.charAt(x)))){
		throw new IllegalArgumentException();
	    }
	}
	this.zip = zip;
	barcode = makeBarcode(zip);
    }
    private static String makeBarcode(String zip){
	int sum = 0;
	for(int x=0; x<5; x++){
	    sum += Integer.parseInt(zip.substring(x,x+1));
	}
	zip += sum % 10;
	String barcode = "";
	for(int x=0; x<6; x++){
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
	zip = zip.substring(0,5);
	return barcode;
    }
    public String getZip(){return zip;}
    public String getCode(){return this.toString();}
    public String toString(){return "|" + barcode + "| (" + zip + ")";}
    public int compareTo(Barcode other){return zip.compareTo(other.zip);}
    public boolean equals(Barcode other){
	if(zip.compareTo(other.zip) == 0){
	    return true;
	}
	return false;
    }
    public static String toCode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException();
	}
	for(int x=0; x<5; x++){
	    if(!(Character.isDigit(zip.charAt(x)))){
		throw new IllegalArgumentException();
	    }
	}
	return "|" + makeBarcode(zip) + "|";
    }	
    public static String toZip(String barcode){
	if(barcode.length() != 32 || barcode.charAt(0) != '|' || barcode.charAt(31) != '|'){
	    throw new IllegalArgumentException();
	}
	barcode = barcode.substring(1,31);
	String zip = "";
	for(int x=0; x<=25; x+=5){
	    int test = 0;
	    if(barcode.substring(x,x+5).equals("||:::")){
		zip += "0";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals(":::||")){
		zip += "1";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals("::|:|")){
		zip += "2";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals("::||:")){
		zip += "3";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals(":|::|")){
		zip += "4";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals(":|:|:")){
		zip += "5";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals(":||::")){
		zip += "6";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals("|:::|")){
		zip += "7";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals("|::|:")){
		zip += "8";
		test ++;
	    }
	    if(barcode.substring(x,x+5).equals("|:|::")){
		zip += "9";
		test ++;
	    }
	    if(test == 0){
		throw new IllegalArgumentException();
	    }
	}
	int sum = 0;
	for(int x=0; x<5; x++){
	    sum += Integer.parseInt(zip.substring(x,x+1));
	}
	if(Integer.parseInt(zip.substring(5,6)) != sum % 10){
	    throw new IllegalArgumentException();
	}
	return zip.substring(0,5);
    }
}
	
	
	
	
