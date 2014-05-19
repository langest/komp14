
class Cmp1 {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        boolean d;
        a = 1;
        b = 2;
        c = 3;
        if (a > b) {
            System.out.println(1);
        }
        if (b >= a+1) {
            System.out.println(2);
        }
        if (c > b && c == b+1) {
            System.out.println(3);
        }
        d = c >= a && c > b && c != b && a != b && b >= 0;
        if (d) {
            System.out.println(4);
        }
    }
}

