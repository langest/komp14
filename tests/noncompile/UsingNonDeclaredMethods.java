class Main {
	public static void main(String[] args) {
		Foo foo = new Foo();
		foo.bar();
		foo.idontexist();
	}
}

class Foo {
	public int bar() {
		return 1337;
	}
}
