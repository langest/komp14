/* Generated By:JJTree: Do not edit this line. E3.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import mjc.type_checker.SymTable;

public class E3 extends SimpleNode {
	public E3(int id) {
		super(id);
	}

	public E3(Lexer p, int id) {
		super(p, id);
	}
	
	public Type pass2(SymTable symTable) {
		Type type = ((E4)children[0]).pass2(symTable);
		return ((E3Cont)children[1]).pass2(symTable, type);
	}

}
/* JavaCC - OriginalChecksum=4b231f82016a9ab1080696295fef67dd (do not edit this line) */
