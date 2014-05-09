class IfElse {
	public static void main(String[] args) {
		if (false) {
			System.out.println(-1);
		} else {
			System.out.println(0);
			if (1 < 2) {
				System.out.println(1);
			} else {
				System.out.println(-1);
			}
		}
	}
}
