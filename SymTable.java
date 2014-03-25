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
