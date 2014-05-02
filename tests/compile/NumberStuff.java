
class NumberStuff {
    public static void main(String[] args) {
        int a1;
        int a2;
        int a3;
        int a4;
        boolean b1;
        boolean b2;
        Util util;
        util = new Util();
        a1 = 1;
        a2 = 2;
        a3 = 3;
        a4 = 4;
        b1 = true;
        b2 = false;
        while (a1 < 100) {
            if (b1) {
                a3 = a1+a2;
            } else {
                a3 = a1 - a2;
            }
            a4 = a4 + 1 + a3*(a1-a2);
            if (b2) {
                a4 = a4-util.min(a1, a2);
            } else {
                a4 = a4+util.min(a1, a3);
            }
            b1 = !b1;
            b2 = !b1 && a4 < a1;
            a1 = a1+1;
        }
        System.out.println(a4);
        System.out.println(b2);
    }
}

class Util {
    public int min(int a, int b) {
        int res;
        if (a < b) res = a;
        else res = b;
        return res;
    }
}

