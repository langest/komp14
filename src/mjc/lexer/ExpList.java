/* Generated By:JJTree: Do not edit this line. ExpList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import mjc.errors.DummyException;
import mjc.errors.TypeError;
import mjc.type_checker.SymTable;

public class ExpList extends SimpleNode {
	public ExpList(int id) {
		super(id);
	}

	public ExpList(Lexer p, int id) {
		super(p, id);
	}
	
	public void pass2(SymTable symTable, MethodDecl methodDecl) {
		FormalList parameters = methodDecl.getParameters();
		if (jjtGetNumChildren() != parameters.jjtGetNumChildren()) {
			throw new DummyException("Mismatching parameters for method invocation: " + methodDecl.getName());
		}
		if (children != null) {
			Type type1 = ((Exp)children[0]).pass2(symTable);
			Type type2 = (Type)parameters.children[0];
			if (!type1.equals(type2)) {
				throw new TypeError("mismatching types for parameter: got " + type1.toShortString() + ", expected " + type2.toShortString());
			}
			for (int i = 1; i < children.length; i++) {
				((ExpRest)children[i]).pass2(symTable, (FormalRest)parameters.children[i]);
			}
		}
	}

}
/* JavaCC - OriginalChecksum=7d2a1472f491ce2982314262d7fc5884 (do not edit this line) */
