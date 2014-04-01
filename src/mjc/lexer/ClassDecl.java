/* Generated By:JJTree: Do not edit this line. ClassDecl.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package mjc.lexer;

import java.util.*;

import mjc.errors.DummyException;
import mjc.type_checker.SymTable;

public class ClassDecl extends SimpleNode {

	private String name;
	private HashMap<String, VarDecl> variables = new HashMap<String, VarDecl>();
	private HashMap<String, MethodDecl> methods = new HashMap<String, MethodDecl>();

	public ClassDecl(int id) {
		super(id);
	}

	public ClassDecl(Lexer p, int id) {
		super(p, id);
	}

	public String toString() {
		return super.toString() + "(" + name + ")";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public VarDecl getVariable(String name) {
		if (!variables.containsKey(name)) {
			throw new DummyException("Can't find declaration for variable " + name);
		}
		return variables.get(name);
	}
	
	public MethodDecl getMethod(String name) {
		if (!methods.containsKey(name)) {
			throw new DummyException("Can't find declaration for method " + name);
		}
		return methods.get(name);
	}
	
	public void pass1(SymTable symTable) {
		if (children != null) {
			for (Node child : children) {
				if (child instanceof VarDecl) {
					VarDecl varDecl = (VarDecl) child;
					if (variables.containsKey(varDecl.getName())) {
						throw new DummyException("Variable " + varDecl.getName() + " already declared in this scope");
					}
					variables.put(varDecl.getName(), varDecl);
				} else {
					MethodDecl methodDecl = (MethodDecl) child;
					String methodName = methodDecl.getName();
					if (methods.containsKey(methodName)) {
						throw new DummyException("Method " + methodDecl.getName() + " already declared in this scope");
					}
					methods.put(methodName, methodDecl);
				}
			}
		}
	}
	
	public void pass2(SymTable symTable) {
		symTable.setCurrentClass(this);
		if (children != null) {
			for (Node child : children) {
				if (child instanceof MethodDecl) {
					symTable.openScope();
					((MethodDecl)child).pass2(symTable);
					symTable.closeScope();
				}
			}
		}
	}
	
	public void printMethodsAndVariables() {
		for (String v : variables.keySet()) {
			System.out.println("Variable: " + v);
		}
		for (String m : methods.keySet()) {
			System.out.println("Method: " + m);
		}
	}
}
/* JavaCC - OriginalChecksum=5f851a8dba450a40ed629e49ff366b0a (do not edit this line) */
