class MethodInv {
    public static void main(String[] args) {
        A a;
        a = new A();
        System.out.println(a.a(3));
    }
}

class A {
    public int a(int d) {
        return 2*d;
    }
}
