import java.util.*;
import parser.*;
import java.io.*;
import lexer.*;

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
		
		Parser parser = new Parser(tokens);
		try {
			parser.parse();
		} catch (RuntimeException e) {
			System.err.println("Syntax error");
			e.printStackTrace();
		}
	}
}
