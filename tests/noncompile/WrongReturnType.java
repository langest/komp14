class Main {
    public static void main(String[] args) {
        int b;
        b = new A().get(2);
        System.out.println(b);
    }
}

class A {
    public int get(int a) {
        return a < a+1;
    }
}
