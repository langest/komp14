import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new SyntaxChecker(System.in);
		List<Token> tokens = SyntaxChecker.parseTokens();
		System.out.println();
		System.out.println("START TOKENS");
		for (Token t : tokens) {
			System.out.println(t);
		}
		System.out.println("END TOKENS");
	}
}
