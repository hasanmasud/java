package com.smartcompute.codility.trial.algo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

public class ModuleLIneiterator implements Iterable<Integer> {

	private Reader reader;
	private Integer valid;

	public ModuleLIneiterator(Reader reader) {
		this.reader = reader;
	}

	public Iterator<Integer> iterator() {

		return new Iterator<Integer>() {
			public boolean hasNext() {
				int chr = 0;
				StringBuilder strBuilder = new StringBuilder();
				try {
					while (true) {
						chr = reader.read();
						if (chr == -1) {
							return false;
						}
						if (chr != 10) {
							strBuilder.append((char) chr);
						} else {
							String s = strBuilder.toString();
							s = s.replace("\r", "").replace("\n", "");
							try {
								if(check(s)){
									valid = Integer.parseInt(s);
									return true;
								}else{
									strBuilder =  new StringBuilder();
								}
							} catch (NumberFormatException numberFormatException) {
								strBuilder = new StringBuilder();
							}
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
			
			private boolean check(String s){
				if(s.charAt(0) == '+' || s.charAt(0) == '-'){
					int i = s.charAt(1);
					if( !(i >= 48 && i <= 57) ){
						return false;
					}
				}
				if( s.length() > 1 && s.charAt(0) == '0' && s.charAt(1) == '0' ){
					return false;
				}

				return true;
			}

			public Integer next() {
				return valid;
			}

			public void remove() {
				// TODO Auto-generated method stub
			}
		};
	}

	public static void main(String... args) throws FileNotFoundException {
		Reader r = new FileReader(
				"F:\\MyGitHubRepository\\java\\Codility\\test.txt");
		for (Integer x : new ModuleLIneiterator(r)) {
			System.out.println(x);
		}
	}

}
