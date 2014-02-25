package parser;

import java.util.*;

import lexer.*;

public class Parser {
	
	private int numTokens, currentToken;
	private Token[] tokens;
	
	public Parser(List<Token> t) {
		this.tokens = new Token[t.size()];
		int i = 0;
		for (Token token : t) {
			tokens[i++] = token;
		}
		numTokens = this.tokens.length;
		currentToken = 0;
	}
	
	private void eat(int id) {
		if (!test(id)) {
			fail();
		}
		currentToken++;
	}
	
	private boolean test(int id) {
		return !isEOF() && tokens[currentToken].kind == id;
	}
	
	private void fail() {
		throw new RuntimeException(); // TODO
	}
	
	private void skip() {
		if (isEOF()) fail();
		currentToken++;
	}
	
	private boolean isEOF() {
		return currentToken == numTokens;
	}
	
	public void parse() {
		Program();
		if (!isEOF()) {
			fail();
		}
	}
	
	private void Program() {
		MainClass();
		while (!isEOF()) {
			ClassDecl();
		}
	}
	
	private void MainClass() {
		eat(LexerConstants.CLASS);
		eat(LexerConstants.ID);
		eat(LexerConstants.LBRACE);
		eat(LexerConstants.PUBLIC);
		eat(LexerConstants.STATIC);
		eat(LexerConstants.VOID);
		eat(LexerConstants.MAIN);
		eat(LexerConstants.LPAREN);
		eat(LexerConstants.STRING);
		eat(LexerConstants.LSQPAREN);
		eat(LexerConstants.RSQPAREN);
		eat(LexerConstants.ID);
		eat(LexerConstants.RPAREN);
		eat(LexerConstants.LBRACE);
		
		while (testVarDecl()) {
			VarDecl();
		}
		while (!test(LexerConstants.RBRACE)) {
			Stmt();
		}
		eat(LexerConstants.RBRACE);
		eat(LexerConstants.RBRACE);
	}
	
	private void ClassDecl() {
		eat(LexerConstants.CLASS);
		eat(LexerConstants.ID);
		eat(LexerConstants.LBRACE);
		while (testVarDecl()) {
			VarDecl();
		}
		while (!test(LexerConstants.RBRACE)) {
			MethodDecl();
		}
		eat(LexerConstants.RBRACE);
	}
	
	private boolean testVarDecl() {
		if (test(LexerConstants.INTEGER)) {
			return true;
		} else if (test(LexerConstants.BOOLEAN)) {
			return true;
		} else if (test(LexerConstants.ID)) {
			if (currentToken + 1 < numTokens && tokens[currentToken + 1].kind == LexerConstants.ID) {
				return true;
			}
		}
		return false;
	}
	
	private void VarDecl() {
		Type();
		eat(LexerConstants.ID);
		eat(LexerConstants.SEMICOLON);
	}
	
	private void MethodDecl() {
		eat(LexerConstants.PUBLIC);
		Type();
		eat(LexerConstants.ID);
		eat(LexerConstants.LPAREN);
		FormalList();
		eat(LexerConstants.RPAREN);
		eat(LexerConstants.LBRACE);
		while (testVarDecl()) {
			VarDecl();
		}
		while (!test(LexerConstants.RETURN)) {
			Stmt();
		}
		eat(LexerConstants.RETURN);
		Exp();
		eat(LexerConstants.SEMICOLON);
		eat(LexerConstants.RBRACE);
	}
	
	private void FormalList() {
		if (test(LexerConstants.RPAREN)) {
			// Empty
		} else {
			Type();
			eat(LexerConstants.ID);
			while (test(LexerConstants.COMMA)) {
				skip();
				Type();
				eat(LexerConstants.ID);
			}
		}
	}
	
	private void Type() {
		if (test(LexerConstants.INTEGER)) {
			skip();
			if (test(LexerConstants.LSQPAREN)) {
				skip();
				eat(LexerConstants.RSQPAREN);
			} else {
				
			}
		} else if (test(LexerConstants.BOOLEAN)) {
			skip();
		} else if (test(LexerConstants.ID)) {
			skip();
		}
	}
	
	// --------- Stmt ---------
	
	private void Stmt() {
		if (test(LexerConstants.LBRACE)) {
			skip();
			while (!test(LexerConstants.RBRACE)) {
				Stmt();
			}
			skip();
		} else if (test(LexerConstants.IF)) {
			skip();
			eat(LexerConstants.LPAREN);
			Exp();
			eat(LexerConstants.RPAREN);
			Stmt();
			eat(LexerConstants.ELSE);
			Stmt();
		} else if(test(LexerConstants.WHILE)) {
			skip();
			eat(LexerConstants.LPAREN);
			Exp();
			eat(LexerConstants.RPAREN);
			Stmt();
		} else if (test(LexerConstants.PRINT)) {
			skip();
			eat(LexerConstants.LPAREN);
			Exp();
			eat(LexerConstants.RPAREN);
			eat(LexerConstants.SEMICOLON);
		} else if (test(LexerConstants.ID)) {
			skip();
			if (test(LexerConstants.ASSIGN)) {
				skip();
				Exp();
				eat(LexerConstants.SEMICOLON);
			} else if (test(LexerConstants.LSQPAREN)) {
				skip();
				Exp();
				eat(LexerConstants.RSQPAREN);
				eat(LexerConstants.ASSIGN);
				Exp();
				eat(LexerConstants.SEMICOLON);
			} else {
				fail();
			}
		} else {
			fail();
		}
	}
	
	// --------- Exp ----------
	
	private void Exp() {
		L();
		Exp2();
	}
	
	private void Exp2() {
		if (test(LexerConstants.AND)) {
			skip();
			L();
			Exp2();
		} else {
			
		}
	}
	
	private void L() {
		P();
		L2();
	}
	
	private void L2() {
		if (test(LexerConstants.LT)) {
			skip();
			P();
			L2();
		} else {
			
		}
	}
	
	private void P() {
		M();
		P2();
	}
	
	private void P2() {
		if (test(LexerConstants.PLUS)) {
			skip();
			M();
			P2();
		} else if (test(LexerConstants.MINUS)) {
			skip();
			M();
			P2();
		} else {
			
		}
	}
	
	private void M() {
		F();
		M2();
	}
	
	private void M2() {
		if (test(LexerConstants.MULT)) {
			skip();
			F();
			M2();
		} else {
			
		}
	}
	
	private void F() {
		if (test(LexerConstants.NOT)) {
			skip();
			Exp();
			F2();
		} else if (test(LexerConstants.LPAREN)) {
			skip();
			Exp();
			eat(LexerConstants.RPAREN);
			F2();
		} else if (test(LexerConstants.ID)) {
			skip();
			F2();
		} else if (test(LexerConstants.INT_LIT)) {
			skip();
			F2();
		} else if (test(LexerConstants.TRUE)) {
			skip();
			F2();
		} else if (test(LexerConstants.FALSE)) {
			skip();
			F2();
		} else if (test(LexerConstants.THIS)) {
			skip();
			F2();
		} else if (test(LexerConstants.NEW)) {
			skip();
			if (test(LexerConstants.INTEGER)) {
				skip();
				eat(LexerConstants.LSQPAREN);
				Exp();
				eat(LexerConstants.RSQPAREN);
				F2();
			} else if (test(LexerConstants.ID)) {
				skip();
				eat(LexerConstants.LPAREN);
				eat(LexerConstants.RPAREN);
				F2();
			} else {
				fail();
			}
		}
	}
	
	private void F2() {
		if (test(LexerConstants.LSQPAREN)) {
			skip();
			Exp();
			eat(LexerConstants.RSQPAREN);
			F2();
		} else if (test(LexerConstants.DOT)) {
			skip();
			if (test(LexerConstants.LENGTH)) {
				skip();
				F2();
			} else if (test(LexerConstants.ID)) {
				skip();
				eat(LexerConstants.LPAREN);
				ExpList();
				eat(LexerConstants.RPAREN);
				F2();
			} else {
				fail();
			}
		} else {
			
		}
	}
	
	private void ExpList() {
		if (test(LexerConstants.RPAREN)) {
			// Empty
		} else {
			Exp();
			while (test(LexerConstants.COMMA)) {
				skip();
				Exp();
			}
		}
	}
}
