class ArrayIndexing {
	public static void main(String[] args) {
		int a;
		int[] a1;
		int[] a2;

		a = 3;
		a1 = new int[a];
		a2 = new int[7];

		a1[0] = 0;
		a1[1] = 1;
		a1[2] = 2;

		a2[a1[0]] = a1[0];
		a2[a1[1]] = a1[1];
		a2[a1[2]] = a1[2];
		a2[a] = a;
		
		System.out.println(a1[0]);
		System.out.println(a1[1]);
		System.out.println(a1[2]);
		System.out.println(a2[0]);
		System.out.println(a2[1]);
		System.out.println(a2[2]);
		System.out.println(a2[3]);
		System.out.println(a2[4]);
	}
}

