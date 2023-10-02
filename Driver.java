import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Driver {
	public static void main(String [] args) {
//		Polynomial p = new Polynomial();
//		System.out.println(p.evaluate(3));
//		double [] c1 = {6,5};
//		int[] po1 = {0,3};
//		Polynomial p1 = new Polynomial(c1, po1);
//		double [] c2 = {-2,-9};
//		int[] po2 = {1,4};
//		Polynomial p2 = new Polynomial(c2, po2);
//		Polynomial s = p1.add(p2);
//		System.out.println("s(0.1) = " + s.evaluate(0.1));
//		if(s.hasRoot(1)) {
//			System.out.println("1 is a root of s");
//		} else {
//			System.out.println("1 is not a root of s");
//		}
		double[] coeff1 = {1, 3, 2, 4};
		int[] pow1 = {0, 2, 3, 4};
		Polynomial poly1 = new Polynomial(coeff1, pow1);

		double[] coeff2 = {1, 3};
		int[] pow2 = {1, 2};
		Polynomial poly2 = new Polynomial(coeff2, pow2);

		double[] coeff3 = {2, 1, 1, 3, 2, 1};
		int[] pow3 = {2, 3, 4, 5, 6, 7};
		Polynomial poly3 = new Polynomial(coeff3, pow3);


		System.out.println("---------------NEW TESTS---------------");

		System.out.println("Test Evaluate:");
		System.out.println("Received: " +  poly1.evaluate(3));
		System.out.println("Expected: 406.0");
		System.out.println();

		System.out.println("Received: " +  poly2.evaluate(2));
		System.out.println("Expected: 14.0");
		System.out.println();

		System.out.println("Received: " +  poly3.evaluate(1));
		System.out.println("Expected: 10.0");
		System.out.println();

		System.out.println("Test HasRoot:");
		System.out.println("Received: " +  poly2.hasRoot(3));
		System.out.println("Expected: false");
		System.out.println();

		System.out.println("Received: " +  poly2.hasRoot(-1));
		System.out.println("Expected: false");
		System.out.println();

		System.out.println("Received: " +  poly2.hasRoot(-1));
		System.out.println("Expected: false");
		System.out.println();

		System.out.println("Test Add:");
		Polynomial sum =  poly2.add(poly1);
		System.out.println("Received: " + Arrays.toString(sum.non_zero) + "  " + Arrays.toString(sum.exponents));
		System.out.println("Expected: [1.0, 1.0, 6.0, 2.0, 4.0]  [0, 1, 4, 3, 4]");
		System.out.println();

		Polynomial sum2 = poly1.add(poly2);
		System.out.println("Received: " +  Arrays.toString(sum2.non_zero) + "  " + Arrays.toString(sum2.exponents));
		System.out.println("Expected: [1.0, 1.0, 6.0, 2.0, 4.0]  [0, 1, 4, 3, 4]");
		System.out.println();

		Polynomial sum3 = poly1.add(poly3);
		System.out.println("Received: " +  Arrays.toString(sum3.non_zero) + "  " + Arrays.toString(sum3.exponents));
		System.out.println("Expected: [1.0, 5.0, 3.0, 5.0, 3.0, 2.0, 1.0]  [0, 4, 6, 8, 5, 6, 7]");
		System.out.println();

		System.out.println("Test Multiply:");
		Polynomial prod1 =  poly1.multiply(poly2);
		System.out.println("Received: " + Arrays.toString(prod1.non_zero) + "  " + Arrays.toString(prod1.exponents));
		System.out.println("Expected: [1.0, 3.0, 3.0, 11.0, 10.0, 12.0]  [0, 1, 2, 3, 4, 5, 6]");
		System.out.println();

		Polynomial prod2 = poly2.multiply(poly1);
		System.out.println("Received: " +  Arrays.toString(prod2.non_zero) + "  " + Arrays.toString(prod2.exponents));
		System.out.println("Expected: [1.0, 3.0, 11.0, 10.0, 3.0, 12.0]  [1, 3, 4, 5, 2, 6]");
		System.out.println();

		Polynomial prod3 = poly1.multiply(poly3);
		System.out.println("Received: " +  Arrays.toString(prod3.non_zero) + "  " + Arrays.toString(prod3.exponents));
		System.out.println("Expected: [2.0, 1.0, 7.0, 10.0, 15.0, 16.0, 16.0, 19.0, 10.0, 4.0]  [2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
		System.out.println();

		System.out.println("Test Read from File:");
		File f = new File("poly.txt");
		try {
			Polynomial read = new Polynomial(f);
			System.out.println("Received: " +  Arrays.toString(read.non_zero) + "  " + Arrays.toString(read.exponents));
			System.out.println("Expected: [4.0, -1.0, 7.0]  [0, 2, 3]");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File f2 = new File("poly2.txt");
		try {
			Polynomial read2 = new Polynomial(f2);
			System.out.println("Received: " +  Arrays.toString(read2.non_zero) + "  " + Arrays.toString(read2.exponents));
			System.out.println("Expected: [3.0, 4.0, -5.0, 4.0, -8.0]  [0, 1, 4, 2, 6]");
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//System.out.println("Test Save To File:");
		//poly1.saveToFile("output.txt");
		//System.out.println("Successfully written to output.txt");
		//System.out.println();
		//System.out.println("Reading from output.txt");
		//try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
		//	String line;
		//	while ((line = reader.readLine()) != null) {
		//		System.out.println("Received: " + line);
		//	}
		//} catch (IOException e) {
		//	System.err.println("Error reading the file: " + e.getMessage());
		//}
		//System.out.println("Expected: 2.0+4.0x+1.0x2+5.0x3");
	}

}