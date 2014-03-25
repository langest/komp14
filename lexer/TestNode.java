package lexer;

public class TestNode extends SimpleNode {
	public TestNode(int i) {
		super(i);
	}
	
	public int hej;
	
	public String toString() {
		return "kind: " + hej;
	}
}
