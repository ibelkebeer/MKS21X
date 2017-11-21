import java.util.*;
import java.io.*;

public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random randgen;
    private String key;
    public WordSearch(int row, int col, String filename){
	data = new char[row][col];
	for(int x = 0; x < data.length; x++){
	    for(int i = 0; i < data[x].length; i++){
		data[x][i] = '_';
	    }
	}
	int seed = (int)(Math.random() * 100000);
	System.out.println("This is your seed: " + seed + "\n");
	randgen = new Random(seed);
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while (in.hasNext()){
		String line = in.nextLine();
		wordsToAdd.add(line);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("Error: File not found: " + filename);
	    System.exit(1);
	}
    }
    public WordSearch(int row,int col,String filename,int seed){
	data = new char[row][col];
	for(int x = 0; x < data.length; x++){
	    for(int i = 0; i < data[x].length; i++){
		data[x][i] = '_';
	    }
	}
        System.out.println("This is yout seed: " + seed + "\n");
        randgen = new Random(seed);
        try{
	    File f = new File(filename);
            Scanner in = new Scanner(f);
            while(in.hasNext()){
		String line = in.nextLine();
		wordsToAdd.add(line);
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
            System.exit(1);
	}
    }
    private void clear(){
	for(int x = 0; x < data.length; x++){
	    for(int i = 0; i < data[i].length; i++){
		data[x][i] = '_';
	    }
	}
    }
    public String toString(){
	String fin = "";
	for(int x = 0; x < data.length; x++){
	    for(int i = 0; i < data[x].length; i++){
		fin += data[x][i] + " ";
	    }
	    fin += "\n";
	}
	return fin;
    }
    private boolean addWord(String word, int row, int col, int rowIncrement, int colIncrement){
	String add = word.toUpperCase();
        if(rowIncrement == 0 && colIncrement == 0){
	    return false;
	}
	int r = row;
	int c = col;
	if(r < 0 || r > data.length){
	    return false;
	}
	if(c < 0 || c > data[r].length){
	    return false;
	}
        if(rowIncrement == -1 && r - word.length() < 0){
	    return false;
	}
	if(rowIncrement == 1 && r + word.length() >= data.length){
            return false;
        }
	if(colIncrement == -1 && c - word.length() < 0){
            return false;
	}
	if(colIncrement == 1 && c + word.length() >= data[r].length){
	    return false;
	}
        boolean check = true;;
        for(int x = 0; x < word.length(); x++){
	    if(data[r][c] != '_' && data[r][c] != add.charAt(x)) {
		check = false;
	    }
	    r += rowIncrement;
	    c += colIncrement;
	}
	r = row;
        c = col;
        if(check){
	    for(int x = 0; x < word.length(); x++){
		data[r][c] = add.charAt(x);
		r += rowIncrement;
		c += colIncrement;
	    }
	}else{
	    return false;
	}
	return true;
    }
    private boolean addAllWords() {
	for(int x = 0; x < 22222; x++){
	    if(wordsToAdd.size() == 0){
		key = toString();
	    }else{
		String word = wordsToAdd.remove(randgen.nextInt(wordsToAdd.size()));
		if(addWord(word, randgen.nextInt(data.length), randgen.nextInt(data[0].length), randgen.nextInt(2), randgen.nextInt(2))) {
		    wordsAdded.add(word);
		}
	    }
	}
	if(wordsAdded.size() >= 1){
	    addLetters();
	    System.out.println(this);
            String str = "Words: \n";
	    int ctr = 0;
	    for(int x = 0; x < wordsAdded.size() - 1; x++){
		str += wordsAdded.get(x) + ", ";
		if (ctr == 2) {
		    str += "\n";
		    ctr = 0;
		}else{
		    ctr++;
		}
	    }
	    str += wordsAdded.get(wordsAdded.size() - 1) + "\n";
	    System.out.println(str);
	    return true;
	}
	System.out.println("Error: No words added to puzzle. Either the word file is empty or no words could be added because they are too long or the puzzle is too small.");
        return false;
    }
    private boolean addLetters(){
	String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	for(int x = 0; x < data.length; x++){
	    for(int i = 0; i < data[0].length; i++){
		if(data[x][i] == '_'){
		    data[x][i] = alphabet.charAt(randgen.nextInt(26));
		}
	    }
	}
	return true;
    }
    public boolean ans(){
	System.out.println(key);
	return true;
    }
    public static void main(String[]args){
	String inst = "To create a word search, type in how many rows and columns you want as the first and second parameters respectively\nThen type in a file name that has words to add to the word search as the third parameter\nIf you want to recreate a past puzzle, type in the seed of that puzzle as the fourth parameter\nIf you want the answer key for a puzzle, type in the seed of that puzzle and type in 'key' as the fifth parameter";
	if (args.length < 3) {
	    System.out.println(inst);
	    System.exit(1);
	}
	try{
	    if (Integer.parseInt(args[0]) <= 0 || Integer.parseInt(args[1]) <= 0) {
		System.out.println("Error: Can't have a word search with less than 1 row or less than 1 column.");
		System.exit(1);
	    }
	}catch (NumberFormatException e){
	    System.out.println("Error: Input for number of rows and/or columns is not a number.");
	    System.exit(1);
	}
	if (args.length == 3){
	    WordSearch w1 = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
	    w1.addAllWords();
	}else{
	    try{
		int seed = Integer.parseInt(args[3]);
	    }catch (NumberFormatException e){
		System.out.println("Error: Seed given is not an int or is too large to be a seed.");
		System.exit(1);
	    }
	    WordSearch w1 = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
	    w1.addAllWords();
	    if(args.length == 5){
		if(args[4].equals("key")){
		    w1.ans();
		}else{
		    System.out.println("If you would like to see the answer key, you must type in 'key' as the fifth parameter.");
		}
	    }
	}
    }
}
