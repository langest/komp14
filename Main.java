import lexer.*;

public class Main {
	public static void main(String[] args) throws ParseException {
        new Lexer(System.in);
        SimpleNode node = Lexer.Program();
        node.dump("");
	}
}
