/* Generated By:JJTree: Do not edit this line. E3Cont.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package lexer;

public
class E3Cont extends SimpleNode {

	private E3ContType type;

	public E3Cont(int id) {
		super(id);
	}

	public E3Cont(Lexer p, int id) {
		super(p, id);
	}

	public E3ContType getType() {
		return type;
	}

	public void setType(E3ContType type) {
		this.type = type;
	}

	public enum E3ContType {
		PLUS, MINUS;
	}
	
	public String toString() {
		return super.toString() + " " + (children != null ? type == E3ContType.PLUS ? "+" : "-" : "");
	}

}
/* JavaCC - OriginalChecksum=b58a49d84c75c905cbdfb7ea631a16c1 (do not edit this line) */