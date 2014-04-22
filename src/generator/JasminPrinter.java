package generator;

import java.io.*;
import java.util.*;

public class JasminPrinter {
	private static PrintWriter out;
	
	public static void openClass(String className) throws IOException {
		out = new PrintWriter(new FileWriter(className+".j"));
		out.println(".class public " + className);
		out.println(".super java/lang/Object");
		out.println();
	}
	
	public static void openMainMethod() {
		out.println(".method public static main([Ljava/lang/String;)V");
	}
	
	public static void closeMethod() {
		out.println(".end method");
		out.println();
	}
	
	public static void print_limit_stack(int limit) {
		out.println(".limit stack " + limit);
	}
	
	public static void print_limit_locals(int limit) {
		out.println(".limit locals " + limit);
	}
	
	public static void print_return() {
		out.println("return");
	}
	
	public static void print_ireturn() {
		out.println("ireturn");
	}
	
	public static void print_areturn() {
		out.println("areturn");
	}
	
	public static void print(String s) {
		out.print(s);
	}
	
	public static void println(String s) {
		out.println(s);
	}
	
	public static void print(int n) {
		out.print(n);
	}
	
	public static void println(int n) {
		out.println(n);
	}
	
	public static void closeClass() {
		out.close();
	}
}
