class Main {
    public static void main(String[] args) {
        Incrementor a;
        int res;
        a = new Incrementor();
        a = a.inc(1).inc(3).inc(4);
        res = a.inc(2).inc(8).inc(1).getVal();
        System.out.println(res);
    }
}

class Incrementor {
    int val;

    public int init() {
        val = 0;
        return val;
    }

    public Incrementor inc(int v) {
        val = val + v;
        return this;
    }

    public int getVal() {
        return val;
    }
}
