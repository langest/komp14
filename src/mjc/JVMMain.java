package mjc;
import java.io.FileInputStream;

import mjc.lexer.*;
import mjc.type_checker.*;


public class JVMMain {
	public static void main(String[] args) throws Exception {
        new Lexer(new FileInputStream(args[0]));
        Program program = Lexer.Program();
        
        SymTable symTable = new SymTable();
        program.pass1(symTable);
        symTable.printClasses();
        program.printEmptyFiles();
	}
	
	public static void printTree(SimpleNode node, String prefix) {
		System.out.println(prefix + node.toString() + " (" + node.jjtGetValue() + ")");
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			printTree((SimpleNode)node.jjtGetChild(i), prefix + " ");
		}
	}
}
