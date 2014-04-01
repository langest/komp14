class Main {
	public static void main(String[] args) {
		Foo foo;
        int a;
        foo = new Foo();
		a = foo.bar();
		a = a + foo.idontexist();
	}
}

class Foo {
	public int bar() {
		return 1337;
	}
}
