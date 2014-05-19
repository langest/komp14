class Or2 {
	public static void main(String[] args) {
		A a;
		a = new A();
		if (false || a.reset()<1 && false || a.inc() || a.inc()) {
			System.out.println(a.get());
		}
	}
}

class A {
	int a;
	public boolean inc() {
		a = a + 1;
		return true;
	}
	public int reset() {
		a = 0;
		return a;
	}
	public int get() {
		return a;
	}
}
