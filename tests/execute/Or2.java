class Or2 {
	public static void main(String[] args) {
		A a;
		a = new A();
		if (a.reset()<1 && false || a.inc() || a.inc()) {
			System.out.println(a.get());
		} else {System.out.println(222);}
		System.out.println(a.get());
		a.set(2);
		if (true || a.reset()<1 && true) {
			System.out.println(2);
		} else {System.out.println(3434);}
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

	public int set(int i) {
		a = i;
		return a;
	}
}
