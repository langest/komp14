/* Generated By:JJTree: Do not edit this line. MainClass.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import java.io.IOException;

import generator.JasminPrinter;
import mjc.type_checker.SymTable;

public class MainClass extends SimpleNode {
	
	private String name;
	
  public MainClass(int id) {
    super(id);
  }

  public MainClass(Lexer p, int id) {
    super(p, id);
  }
  
  public void setName(String name) {
	  this.name = name;
  }
  
  public String getname() {
	  return name;
  }
  
  public void pass2(SymTable symTable) throws IOException {
	  JasminPrinter.openClass(name);
	  JasminPrinter.openMainMethod();
	  if (children != null) {
		  for (Node child: children) {
			  if (child instanceof VarDecl) {
				  ((VarDecl)child).pass2(symTable);
			  } else {
				  ((Stmt)child).pass2(symTable);
			  }
		  } 
	  }
	  // TODO calculate limits
	  JasminPrinter.print_limit_locals(150);
	  JasminPrinter.print_limit_stack(150);
	  JasminPrinter.print_return();
	  JasminPrinter.closeMethod();
	  JasminPrinter.closeClass();
  }
  
  public String toString() {
	  return super.toString() + "(" +  name + ")";
  }

}
/* JavaCC - OriginalChecksum=b645a637ba8993531736d30518182fb8 (do not edit this line) */
