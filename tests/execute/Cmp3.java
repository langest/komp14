
class Cmp3 {
    public static void main(String[] args) {
        int a;
        int b;
        boolean c;
        boolean d;
        a = 1;
        b = 2;
        c = true;
        d = false;
        System.out.println(c || d);
        System.out.println(c == d);
        System.out.println(c != d);
        System.out.println(1 < 2 && c == d || c != d);
        System.out.println(c == d || 1 == a && b < a);
    }
}
