// EXT:CEQ
// EXT:CNE

class Eq1 {
    public static void main(String[] args) {
        A a1;
        A a2;
        a1 = new A();
        a2 = new A();
        System.out.println(a1 == a1);
        System.out.println(a1 == a2);
        System.out.println(a2 != a1);
        System.out.println(a2 != a2);
    }
}

class A {

}
