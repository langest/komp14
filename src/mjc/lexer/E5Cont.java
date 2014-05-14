/* Generated By:JJTree: Do not edit this line. E5Cont.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import generator.JasminPrinter;
import mjc.errors.TypeError;
import mjc.type_checker.SymTable;

public class E5Cont extends SimpleNode {

	private E5ContType type;
	private String name;

	public E5Cont(int id) {
		super(id);
	}

	public E5Cont(Lexer p, int id) {
		super(p, id);
	}

	public enum E5ContType {
		ARRAY_ACCESS, LENGTH, METHOD_INVOCATION;
	}

	public void setType(E5ContType type) {
		this.type = type;
	}

	public E5ContType getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Type pass2(SymTable symTable, Type inputType) {
		if (type == E5ContType.ARRAY_ACCESS) {
			if (!inputType.isIntArray()) {
				throw new TypeError("Non-array type for array access");
			}
			Type indexType = ((Exp)children[0]).pass2(symTable);
			if (!indexType.isInt()) {
				throw new TypeError("Non-int type for array index");
			}
			JasminPrinter.print_iaload();
			return Type.createIntType();
		} else if (type == E5ContType.LENGTH) {
			if (!inputType.isIntArray()) {
				throw new TypeError("Non-array type for length");
			}
			JasminPrinter.print_arraylength();
			return Type.createIntType();
		} else if (type == E5ContType.METHOD_INVOCATION) {
			if (!inputType.isCustom()) {
				throw new TypeError("Invalid type for method invocation: " + inputType.toShortString());
			}
			ClassDecl classDecl = symTable.getClassNode(inputType.getName());
			MethodDecl methodDecl = classDecl.getMethod(name);
			((ExpList)children[0]).pass2(symTable, methodDecl);
			
			JasminPrinter.print_invokevirtual(classDecl.getName() + "/" + methodDecl.getName() + "(" + methodDecl.getParameters().getMethodTypeDescriptor() + ")" + methodDecl.getReturnType().getTypeDescriptor());
			return ((E5Cont)children[1]).pass2(symTable, methodDecl.getReturnType());
		} else {
			return inputType;
		}
	}

	public String toString() {
		return super.toString() + " " + (children != null ? type + (type == E5ContType.METHOD_INVOCATION ? "(" + name + ")" : "") : "");
	}
}
/* JavaCC - OriginalChecksum=acc357d90a96f725c75d3a51ca7c9e08 (do not edit this line) */
