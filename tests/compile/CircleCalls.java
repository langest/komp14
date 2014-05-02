
class CircleCalls {
    public static void main(String[] args) {
        int n;
        C1 c1;
        n = 1;
        c1 = new C1().setM(2);
        while (n < 100) {
            n = c1.c2().c3().mult(n);
            c1 = c1.c2().c3().c1();
        }
        System.out.println(n);
    }
}

class C1 {
    int m;
    public C2 c2() {
        return new C2().setM(m);
    }
    public C1 setM(int m1) {
        m = m1;
        return this;
    }
}

class C2 {
    int m;
    public C3 c3() {
        return new C3().setM(m);
    }
    public C2 setM(int m1) {
        m = m1;
        return this;
    }
}

class C3 {
    int m;
    public int mult(int a) {
        return m*a;
    }
    public C1 c1() {
        return new C1().setM(m+1);
    }
    public C3 setM(int m1) {
        m = m1;
        return this;
    }
}
