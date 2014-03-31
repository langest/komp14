package type_checker;

import java.util.*;
import lexer.*;
import errors.*;

public class SymTable {
	private Layer current;
	
	public SymTable() {
		current = new Layer();
	}
	
	public void openScope() {
		Layer newLayer = new Layer();
		newLayer.parent = current;
		current = newLayer;
	}
	
	public void closeScope() {
		current = current.parent;
	}
	
	public void addClassNode(ClassDecl classNode) {
		if (current.classes.containsKey(classNode.getName())) {
			throw new DummyException("class name " + classNode.getName() + " was already declared in this scope");
		}
		current.classes.put(classNode.getName(), classNode);
	}
	
	public void printClasses() {
		for (String c : current.classes.keySet()) {
			System.out.println("Class " + c + ":");
			current.classes.get(c).printMethodsAndVariables();
		}
	}
	
	static class Layer {
		private Layer parent;
		private HashMap<String, VarDecl> variables;
		private HashMap<String, ClassDecl> classes;
		
		private Layer() {
			parent = null;
			variables = new HashMap<String, VarDecl>();
			classes = new HashMap<String, ClassDecl>();
		}
	}
}
