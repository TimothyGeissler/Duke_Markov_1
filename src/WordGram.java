import java.util.ArrayList;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author T Geissler
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = null;
		myHash = 0;

		for (int i = 0; i < size; i++) {
			myWords[i] = source[start + i];
		}

	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 *
	 * @return length of String array myWords of the WordGram object
	 */
	public int length(){
		return this.myWords.length;
	}


	/**
	 *
	 * @param o the object to be compared to
	 * @return boolean if o is WordGram object, same length & same words in myWords @ same indices
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof WordGram) || o == null){
			return false;
		} else {
			WordGram wg = (WordGram) o;
			boolean isEquals = true;
			if (this.myWords.length != wg.myWords.length) {
				isEquals = false;
			} else {
				for (int i = 0; i < wg.myWords.length; i++) {
					if (!this.myWords[0].equals(wg.myWords[0])) {
						isEquals = false;
					}
				}
			}
			if (!isEquals) {
				return false;
			} else {
				return true;
			}
		}
	}

	/**
	 *
	 * @return hashcode derived from toString of object
	 */
	@Override
	public int hashCode(){
		int myHash = 0;
		if (this.myHash == 0) {
			System.out.println("Calculating hashcode");
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return WordGRam object with elements shifted left & last param added
	 */
	public WordGram shiftAdd(String last) {
		System.out.println("last: " + last);
		System.out.println("Array to modify: " + Arrays.toString(myWords));
		String [] newWords = new String[myWords.length + 1];
		for (int i = 0; i < myWords.length; i++) {
			newWords[i] = myWords[i];
		}
		newWords[myWords.length] = last;
		System.out.println("New array: " + Arrays.toString(newWords));
		WordGram wg = new WordGram(newWords,1,newWords.length - 1);
		return wg;
	}

	/**
	 * Only triggers once, then stores in variable myToString
	 * @return String of combined items in myWords array of this object
	 */
	@Override
	public String toString(){
		if (this.myToString == null) {
			System.out.println("calculating toString...");
			myToString = String.join(" ", this.myWords);
		}

		return myToString;
	}
}
