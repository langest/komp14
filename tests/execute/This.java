class Main {
	public static void main(String[] args) {
		C c;
		c = new C();
		c.foo();
		c.bar().bar();
		c.print();
	}
}

class C {
	int a;

	public void foo() {
		this.a = 1;
	}

	public C bar() {
		this.a = a + 1;
		return this;
	}

	public void print() {
		System.out.println(this.a);
	}
}
