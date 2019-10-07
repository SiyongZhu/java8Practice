package java8Practice.interview.ebi.string;

public class StringQuestions {

	// 7.7 
	public static String[] letters = {"0", "1", "ABC", "DEF", "GHI"};
	public static void allMnemonics (String phone) {		
		printAllMnemonic(phone, 0, "");
	}
	
	private static void printAllMnemonic(String phone, int digit, String partialMnemonic) {
		for (int i=0; i<letters[phone.charAt(digit)-'0'].length(); i++) {
			String mnemonic = partialMnemonic+letters[phone.charAt(digit)-'0'].charAt(i);
			if(mnemonic.length() == phone.length()) {
				System.out.println(mnemonic);
			}else {
				printAllMnemonic(phone, digit+1, mnemonic);
			}	
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("This is for array interview questions");
		System.out.println("Example of 7.7: ");
		allMnemonics("3102");
	}

}
