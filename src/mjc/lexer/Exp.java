/* Generated By:JJTree: Do not edit this line. Exp.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import mjc.type_checker.SymTable;

public class Exp extends SimpleNode {
	public Exp(int id) {
		super(id);
	}

	public Exp(Lexer p, int id) {
		super(p, id);
	}

	public Type pass2(SymTable symTable) {
		return ((E0)children[0]).pass2(symTable);
	}

}
/* JavaCC - OriginalChecksum=db44867284f9537caaf20a373f443181 (do not edit this line) */
