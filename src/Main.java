import lexer.*;

import type_checker.*;

public class Main {
	public static void main(String[] args) throws ParseException {
        new Lexer(System.in);
        Program program = Lexer.Program();
        
        SymTable symTable = new SymTable();
        program.pass1(symTable);
        symTable.printClasses();
	}
	
	public static void printTree(SimpleNode node, String prefix) {
		System.out.println(prefix + node.toString() + " (" + node.jjtGetValue() + ")");
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			printTree((SimpleNode)node.jjtGetChild(i), prefix + " ");
		}
	}
}
