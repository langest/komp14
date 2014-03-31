package mjc;
import java.util.*;

import mjc.lexer.*;

public class MethodNode {
	private String name, canonicalName;
	private Type returnType;
	private FormalList parameters;
	
	public MethodNode(String name, Type returnType, FormalList parameters) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getCanonicalName() {
		return canonicalName;
	}
	
	public Type getReturnType() {
		return returnType;
	}
	
	public FormalList getParameters() {
		return parameters;
	}
}
