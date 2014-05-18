package mjc.type_checker;

import java.util.*;

import mjc.errors.*;
import mjc.lexer.*;

public class SymTable {
	private Layer current;
	
	public int getVariableIndex(String varName) {
		if (!current.variableIndex.containsKey(varName)) {
			System.out.println("Can't find variable " + varName);
		}
		return current.variableIndex.get(varName);
	}
	
	public SymTable() {
		current = new Layer();
	}
	
	public void openScope() {
		Layer newLayer = new Layer();
		newLayer.parent = current;
		newLayer.currentClass = newLayer.parent.currentClass;
		current = newLayer;
	}
	
	public void closeScope() {
		current = current.parent;
	}
	
	public int getLocalCount() {
		return current.index;
	}
	
	public int getMaxStackSize() {
		return current.maxStackSize;
	}
	
	public int getCurrentStackSize() {
		return current.currentStackSize;
	}
	
	public void setCurrentStackSize(int stackSize) {
		current.currentStackSize = stackSize;
		current.maxStackSize = Math.max(current.maxStackSize, current.currentStackSize);
	}
	
	public void updateCurrentStackSize(int val) {
		current.currentStackSize += val;
		current.maxStackSize = Math.max(current.maxStackSize, current.currentStackSize);
	}
	
	public void addClassNode(ClassDecl classNode) {
		if (current.classes.containsKey(classNode.getName())) {
			throw new DummyException("class name " + classNode.getName() + " was already declared in this scope");
		}
		current.classes.put(classNode.getName(), classNode);
	}
	
	public ClassDecl getClassNode(String className) {
		Layer layer = current;
		while (layer != null) {
			if (layer.classes.containsKey(className)) {
				return layer.classes.get(className);
			}
			layer = layer.parent;
		}
		throw new DummyException("Undefined class name: " + className);
	}
	
	public void setCurrentClass(ClassDecl classDecl) {
		current.currentClass = classDecl;
	}
	
	public ClassDecl getCurrentClass() {
		return current.currentClass;
	}
	
	public void addVariableNode(VarDecl varNode) {
		Layer layer = current;
		while (layer != null) {
			if (layer.variables.containsKey(varNode.getName())) {
				throw new DummyException("Variable name " + varNode.getName() + " was already declared in this scope");
			}
			layer = layer.parent;
		}
		current.variables.put(varNode.getName(), varNode);
		current.variableIndex.put(varNode.getName(), current.index++);
	}
	
	public VarDecl getVariableNode(String variableName) {
		Layer layer = current;
		while (layer != null) {
			if (layer.variables.containsKey(variableName)) {
				return layer.variables.get(variableName);
			}
			layer = layer.parent;
		}
		// No local variable found, try class variable
		if (current.currentClass != null) {
			return current.currentClass.getVariable(variableName);
		}
		throw new DummyException("Undefined variable name: " + variableName);
	}
	
	public void printClasses() {
		for (String c : current.classes.keySet()) {
			System.out.println("Class " + c + ":");
			current.classes.get(c).printMethodsAndVariables();
		}
	} 
	
	static class Layer {
		private Layer parent;
		private ClassDecl currentClass;
		private HashMap<String, VarDecl> variables;
		private HashMap<String, ClassDecl> classes;
		private HashMap<String, Integer> variableIndex;
		private int index, currentStackSize, maxStackSize;
		
		private Layer() {
			parent = null;
			currentClass = null;
			variables = new HashMap<String, VarDecl>();
			classes = new HashMap<String, ClassDecl>();
			variableIndex = new HashMap<String, Integer>();
			index = 1;
			currentStackSize = 0;
			maxStackSize = 0;
		}
	}
}
