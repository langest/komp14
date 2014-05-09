class M {
	public static void main(String[] args) {
		C c;
		c = new C();
		c = c.foo();
		c.foo();
	}
}

class C {
	public C foo() {
		return null;
	}
}
