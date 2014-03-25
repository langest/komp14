import java.util.*;

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
	
	public void addClassNode(ClassNode classNode) {
		if (current.classes.containsKey(classNode.getName())) {
			throw new DummyException("class name " + classNode.getName() + " was already declared in this scope");
		}
		current.classes.put(classNode.getName(), classNode);
	}
	
	static class Layer {
		private Layer parent;
		private HashMap<String, VariableNode> variables;
		private HashMap<String, MethodNode> methods;
		private HashMap<String, ClassNode> classes;
		
		private Layer() {
			parent = null;
			variables = new HashMap<String, VariableNode>();
			methods = new HashMap<String, MethodNode>();
			classes = new HashMap<String, ClassNode>();
		}
	}
}
