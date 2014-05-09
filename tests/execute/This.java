class Main {
	public static void main(String[] args) {
		C c;
		c = new C();
		c = c.foo();
		c = c.bar().bar();
		c = c.print();
	}
}

class C {
	int a;

	public C foo() {
		C d;
		a = 0;
		d = this.foo2();
		return this;
	}
	
	public C foo2() {
		a = 1;
		return this;
	}

	public C bar() {
		a = a + 1;
		return this;
	}

	public C print() {
		System.out.println(a);
		return this;
	}
}
