package mjc;
import java.io.FileInputStream;
import java.io.IOException;

import mjc.lexer.*;
import mjc.type_checker.*;


public class JVMMain {
	public static void main(String[] args) throws Exception {
        new Lexer(new FileInputStream(args[0]));
        Program program = Lexer.Program();
        
        SymTable symTable = new SymTable();
        program.pass1(symTable);
        symTable.printClasses();
        try {
            program.pass2(symTable);
        } catch (IOException e) {
        	System.err.println("Error while printing files");
        	System.exit(1);
        }
	}
	
	public static void printTree(SimpleNode node, String prefix) {
		System.out.println(prefix + node.toString() + " (" + node.jjtGetValue() + ")");
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			printTree((SimpleNode)node.jjtGetChild(i), prefix + " ");
		}
	}
}
