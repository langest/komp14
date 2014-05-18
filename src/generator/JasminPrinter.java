package generator;

import java.io.*;
import java.util.*;

import mjc.lexer.ClassDecl;
import mjc.lexer.MethodDecl;
import mjc.lexer.VarDecl;

public class JasminPrinter {
	private static PrintWriter out;
	private static int labelCounter = 1;
	
	public static void openClass(String className) throws IOException {
		out = new PrintWriter(new FileWriter(className+".j"));
		out.println(".class public '" + className + "'");
		out.println(".super java/lang/Object");
		out.println();
	}

	public static void openMainMethod() {
		out.println(".method public static main([Ljava/lang/String;)V");
	}

	public static void printConstructor() { //TODO all lines needed?
		out.println(".method <init>()V");
		out.println(".limit stack 1");
		out.println(".limit locals 1");
		out.println("aload_0");
		out.println("invokespecial java/lang/Object/<init>()V");
		out.println("return");
		closeMethod();
	}

	public static void openMethod(MethodDecl methodDecl) {
		out.print(".method public ");
		out.print(methodDecl.getName() + "(");
		out.print(methodDecl.getParameters().getMethodTypeDescriptor());
		out.print(")");
		out.println(methodDecl.getReturnType().getTypeDescriptor());
	}

	public static void print_ldc(int value) {
		out.println("ldc " + value);
	}

	public static void openPrint() {
		out.println("getstatic java/lang/System/out Ljava/io/PrintStream;");
	}

	public static void closePrint(String IorZ) {
		out.println("invokevirtual java/io/PrintStream/println(" + IorZ + ")V");
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
	
	public static void print_field(VarDecl field) {
		out.println(".field '" + field.getName() + "' " + field.getType().getTypeDescriptor());
	}
	
	public static void print_getField(ClassDecl classDecl, VarDecl field) {
		out.println("getfield " + classDecl.getName() + "/" + field.getName() + " " + field.getType().getTypeDescriptor());
	}
	
	public static void print_putField(ClassDecl classDecl, VarDecl field) {
		out.println("putfield " + classDecl.getName() + "/" + field.getName() + " " + field.getType().getTypeDescriptor());
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
		out.println("dup");
	}
	
	public static void print_iand() {
		out.println("iand");
	}
	
	public static void print_ixor() {
		out.println("ixor");
	}

	public static void print_baload() {
		out.println("baload");
	}

	public static void print_bastore() {
		out.println("bastore");
	}
	
	public static void invokeConstructor(ClassDecl classDecl) {
		out.println("invokespecial " + classDecl.getName() + "/<init>()V");
	}
	
	public static void print_invokevirtual(ClassDecl classDecl, MethodDecl methodDecl) {
		out.print("invokevirtual ");
		out.print(classDecl.getName() + "/");
		out.print(methodDecl.getName() + "(");
		out.print(methodDecl.getParameters().getMethodTypeDescriptor());
		out.println(")" + methodDecl.getReturnType().getTypeDescriptor());
	}

	public static void print_astore(int index) {
		out.println("astore " + index);
	}

	public static void print_aload(int index) {
		out.println("aload " + index);
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

	public static void print_new(ClassDecl classDecl) {
		out.println("new '" + classDecl.getName() + "'");
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

	public static void print_iastore() {
		out.println("iastore");
	}
	
	public static void print_newarray() {
		out.println("newarray int");
	}
	
	public static void print_if_icmplt(int label) {
		out.println("if_icmplt " + label);
	}
	
	public static void print_goto(int label) {
		out.println("goto " + label);
	}

	public static void print_ineg() {
		out.println("ineg");
	}

	public static void print_ifeq(int label) {
		out.println("ifeq " + label);
	}

	public static void print_isub() {
		out.println("isub");
	}

	public static void print_imul() {
		out.println("imul");
	}
	
	public static void print_nop() {
		out.println("nop");
	}
	
	public static void print_label() {
		out.print(labelCounter + ": ");
		labelCounter++;
	}
	
	public static void print_label(int label) {
		out.print(label + ": ");
	}
	
	public static int getNextLabel() {
		return labelCounter;
	}
	
	public static int incrementLabel() {
		return labelCounter++;
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

	public static void closeClass() {
		out.close();
	}
}
