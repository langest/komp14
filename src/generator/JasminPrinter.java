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
	
	public static void print_aaload() {
		out.println("aaload");
	}
	
	public static void print_aastore() {
		out.println("aastore");
	}
	
	public static void print_dup() {
		out.print("dup");
	}
	
	public static void print_baload() {
		out.println("baload");
	}
	
	public static void print_bastore() {
		out.println("bastore");
	}
	
	public static void print_invokespecial(String method) {
		out.println("invokespecial " + method);
	}
	
	public static void print_astore(int index) {
		out.println("astore " + index);
	}
	
	public static void print_aload(int index) {
		out.print("aload " + index);
	}
	
	public static void print_areturn() {
		out.println("areturn");
	}
	
	public static void print_pop() {
		out.println("pop");
	}
	
	public static void print_arraylength() {
		out.println("arraylength");
	}
	
	public static void print_new(String object) {
		out.println("new " + object);
	}
	
	public static void print_newarray(String type) {
		out.println("newarray " + type);
	}
	
	public static void print_anewarray() {
		out.println("anewarray");
	}
	
	public static void print_iadd() {
		out.println("iadd");
	}
	
	public static void print_iload(int index) {
		out.println("iload " + index);
	}
	
	public static void print_istore(int index) {
		out.println("istore " + index);
	}
	
	public static void print_iaload() {
		out.println("iaload");
	}
	
	public static void print_iastore(int index) {
		out.println("iastore " + index);
	}
	
	public static void print_if_acmpeq(int bb1, int bb2) {
		out.println("if_acmpeq " + bb1 + " " + bb2);
	}
	
	public static void print_if_acmpne(int bb1, int bb2) {
		out.println("if_acmpne " + bb1+ " " + bb2);
	}
	
	public static void print_if_icmpeq(int bb1, int bb2) {
		out.println("if_icmpeq " + bb1 + " " + bb2);
	}

	public static void print_if_icmpge(int bb1, int bb2) {
		out.println("if_icmpge " + bb1 + " " + bb2);
	}
	
	public static void print_if_icmpgt(int bb1, int bb2) {
		out.println("if_icmpgt" + bb1 + " " + bb2);
	}
	
	public static void print_if_icmple(int bb1, int bb2) {
		out.println("if_icmple " + bb1 + " " + bb2);
	}
	
	public static void print_ifeq(int bb1, int bb2) {
		out.println("ifeq " + bb1 + " " + bb2);
	}
	
	public static void print_ifge(int bb1, int bb2) {
		out.println("ifge " + bb1 + " " + bb2);
	}
	
	public static void print_ifgt(int bb1, int bb2) {
		out.println("ifgt " + bb1 + " " + bb2);
	}
	
	
	public static void print_iflt(int bb1, int bb2) {
		out.println("iflt " + bb1 + " " + bb2);
	}
	
	public static void print_ifne(int bb1, int bb2) {
		out.println("ifne " + bb1 + " " + bb2);
	}
	
	public static void print_ifnonnull(int bb1, int bb2) {
		out.println("ifnonnull " + bb1 + " " + bb2);
	}
	
	public static void print_ifnull(int bb1, int bb2) {
		out.println("ifnull " + bb1 + " " + bb2);
	}
	
	public static void print_isub() {
		out.println("isub");
	}
	
	public static void print_imul() {
		out.println("imul");
	}
	
	public static void print_ireturn() {
		out.println("ireturn");
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
	
	public static void printConstructor() {
		out.println(".method public <init>()V");
		out.println("invokespecial java/lang/Object/<init>()V");
		out.println("return");
		out.println(".end method");
	}
	
	public static void closeClass() {
		out.close();
	}
}
