
class Or1 {
    public static void main(String[] args) {
        boolean a;
        boolean b;
        int c;
        int d;
        a = true;
        b = false;
        if (a || b) {
            System.out.println(1);
        }
        if (b || a) {
            System.out.println(2);
        }
        c = 1;
        d = 2;
        if (c < d || d < c) {
            System.out.println(3);
        }
        a = !(a || b);
        if (a || b) {
            System.out.println(4);
        }
        if (b || a) {
            System.out.println(5);
        }
        System.out.println(a || b || 1 < 2);
    }
}

