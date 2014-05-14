class TrickyAnd {
    public static void main(String[] args) {
        A a;
        boolean b;
        a = new A();
        b = 2 < 1;
        if (b && a.inc()) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
        System.out.println(a.getA());
    }
}

class A {
    int a;
    public int getA() {
        return a;
    }
    
    public boolean inc() {
        a = a+1;
        return true;
    }
}

