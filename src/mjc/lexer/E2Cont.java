/* Generated By:JJTree: Do not edit this line. E2Cont.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import generator.JasminPrinter;
import mjc.errors.TypeError;
import mjc.lexer.E3Cont.E3ContType;
import mjc.type_checker.SymTable;

public class E2Cont extends SimpleNode {
	public E2Cont(int id) {
		super(id);
	}

	public E2Cont(Lexer p, int id) {
		super(p, id);
	}
	
	public String toString() {
		return super.toString() + " " + (children != null ? "<" : "");
	}
	
	public Type pass2(SymTable symTable, Type type) {
		if (children != null) {
			Type type2 = ((E3)children[0]).pass2(symTable);
			if (!type.isInt() || !type2.isInt()) {
				throw new TypeError("Invalid types for < comparison: " + type.toShortString() + " and " + type2.toShortString());
			}
			int nextLabel = JasminPrinter.getNextLabel();
			JasminPrinter.print_if_icmplt(nextLabel);
			JasminPrinter.print_ldc(0);
			JasminPrinter.print_goto(nextLabel+1);
			JasminPrinter.print_label();
			JasminPrinter.print_ldc(1);
			JasminPrinter.print_label();
			return ((E2Cont)children[1]).pass2(symTable, Type.createBooleanType());
		} else {
			return type;
		}
	}

}
/* JavaCC - OriginalChecksum=c8ec47beb7ccd3714dc107074d649c62 (do not edit this line) */
