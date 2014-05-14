class IfElse {
	public static void main(String[] args) {
        boolean b1;
        boolean b2;
        int a1;
        a1 = 1;
        b1 = true;
        b2 = false;
		if (b1 && b2) {
			System.out.println(2);
		} else {
			System.out.println(0);
			if (a1 < 2) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
