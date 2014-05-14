/* Generated By:JJTree: Do not edit this line. Stmt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import generator.JasminPrinter;
import mjc.errors.DummyException;
import mjc.errors.TypeError;
import mjc.type_checker.SymTable;

public class Stmt extends SimpleNode {

	private StmtType type;
	private String name;

	public enum StmtType {
		BRACES, IF_ELSE, WHILE, PRINT, ASSIGN, ARRAY_ASSIGN;
	}

	public Stmt(int id) {
		super(id);
	}

	public Stmt(Lexer p, int id) {
		super(p, id);
	}

	public StmtType getType() {
		return type;
	}

	public void setType(StmtType type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void pass2(SymTable symTable) {
		if (type == StmtType.BRACES) {
			if (children != null) {
				for (Node child : children) {
					((Stmt)child).pass2(symTable);
				}
			}
		} else if (type == StmtType.IF_ELSE) {
			Type type = ((Exp)children[0]).pass2(symTable);
			if (!type.isBoolean()) {
				throw new TypeError("Expected boolean expression, got " + type.toShortString());
			}
			int label = JasminPrinter.incrementLabel();
			JasminPrinter.print_ifeq(label);
			((Stmt)children[1]).pass2(symTable);
			
			int nextLabel = JasminPrinter.incrementLabel();
			JasminPrinter.print_goto(nextLabel);
			JasminPrinter.print_label(label);
			JasminPrinter.print_nop();
			
			((Stmt)children[2]).pass2(symTable);
			JasminPrinter.print_label(nextLabel);
			JasminPrinter.print_nop();
		} else if (type == StmtType.WHILE) {
			int label = JasminPrinter.getNextLabel();
			JasminPrinter.print_label();
			Type type = ((Exp)children[0]).pass2(symTable);
			if (!type.isBoolean()) {
				throw new TypeError("Expected boolean expression, got " + type.toShortString());
			}
			int nextLabel = JasminPrinter.incrementLabel();
			JasminPrinter.print_ifeq(nextLabel);
			((Stmt)children[1]).pass2(symTable);
			JasminPrinter.print_goto(label);
			JasminPrinter.print_label(nextLabel);
			JasminPrinter.print_nop();
		} else if (type == StmtType.PRINT) {
			JasminPrinter.openPrint();
			Type type = ((Exp)children[0]).pass2(symTable);
			if (!type.isBoolean() && !type.isInt()) {
				throw new TypeError("Invalid type for printing: " + type.toShortString());
			}
			if (type.isBoolean()) {
				JasminPrinter.closePrint("Z");
			} else {//is int
				JasminPrinter.closePrint("I");
			}
		} else if (type == StmtType.ASSIGN) {
			VarDecl assignVariable = symTable.getVariableNode(name);
			if (assignVariable.isField()) {
				JasminPrinter.print_aload(0);
			}
			Type type = ((Exp)children[0]).pass2(symTable);
			if (!type.equals(assignVariable.getType())) {
				throw new TypeError("Incompatible types for variable assignment: " + type.toShortString() + " and " + assignVariable.getType().toShortString());
			}
			if (assignVariable.isField()) {
				JasminPrinter.print_putField(symTable.getCurrentClass(), assignVariable);
			} else {
				if (assignVariable.getType().isInt() || assignVariable.getType().isBoolean()) {
					JasminPrinter.print_istore(symTable.getVariableIndex(assignVariable.getName()));
				} else {
					JasminPrinter.print_astore(symTable.getVariableIndex(assignVariable.getName()));
				}
			}
		} else if (type == StmtType.ARRAY_ASSIGN) {
			VarDecl assignVariable = symTable.getVariableNode(name);
			if (!assignVariable.getType().isIntArray()) {
				throw new TypeError("Trying to index non-array: " + assignVariable.getType().toShortString());
			}
			JasminPrinter.print_aload(symTable.getVariableIndex(assignVariable.getName()));
			Type type = ((Exp)children[0]).pass2(symTable);
			if (!type.isInt()) {
				throw new TypeError("Non-int type for array index: " + type.toShortString());
			}
			Type type2 = ((Exp)children[1]).pass2(symTable);
			if (!type2.isInt()) {
				throw new TypeError("Invalid type for array assignment: " + type2.toShortString());
			}
			JasminPrinter.print_iastore();
		} else {
			throw new DummyException("Unknown Stmt type");
		}
	}
	
	public String toString() {
		return super.toString() + " " + type + (name != null ? "(" + name + ")" : "");
	}

}
/* JavaCC - OriginalChecksum=79188639f98ec5c0a1da9aaed81dc2d7 (do not edit this line) */
