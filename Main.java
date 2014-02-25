import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Lexer(System.in);
		List<Token> tokens = Lexer.parseTokens();
		System.out.println();
		System.out.println("START TOKENS");
		for (Token t : tokens) {
			System.out.println(t + " (" + t.kind + ")");
		}
		System.out.println("END TOKENS");
	}
}
