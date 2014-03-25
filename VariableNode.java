import lexer.*;

public class VariableNode {
	private String name;
	private Type type;
	
	public VariableNode(String name, Type type) {
		this.name = name;
		this.type = type;
	}
}
