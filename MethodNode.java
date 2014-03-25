import java.util.*;
import lexer.*;

public class MethodNode {
	private String name;
	private Type returnType;
	private FormalList parameters;
	
	public MethodNode(String name, Type returnType, FormalList parameters) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
	}
}
