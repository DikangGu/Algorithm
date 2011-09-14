package com.dikang.algorithm.topcoder.tree;

import java.util.StringTokenizer;

/**
 * Nebula Cloud Platform
 * Copyright 2010 Innovation Works Limited, All Rights Reserved.
 * Author: dikang
 *
 * srm286 > Division Two - Level Three
 *
 *
Regardless the extension of the statement,
 the problem should be easily understood by anyone familiar to programming:
 it asked for inferring the type of an expression in a (typed) programming language,
 based on certain assumptions given as the ï¿½definitionsï¿½.
 Any compiler of a typed language (as all languages currently used in TopCoder competitions)
 performs this task for each constant, function call, operator application, etc.
 in a piece of source code. A great part of the problem complexity comes from parsing of the expression,
 which can be seen as a tree where function calls are nodes (with one or more children),
 and constants are its leaves. Parsing such an expression is a common example of use of stack automatas,
 and can be implemented either using recursion or a stack to keep track of depth in the tree
 that represents the expression (parenthesis nesting).
 Inferring the type of the expression requires to check each function and constant
 name against the definitions, and recurse this task to typecheck each of the subexpressions.
 For a constant to have type, it has just to be declared in the definitions.
 For a node to have type, it must hold that:

1. there is a definition for that name,
2. the parameter count in that definition matches the actual usage in the expression, and
recursively each of the nodes have type and match the type declared for each parameter in the definitions.

 In Type Theory, these two rules are usually part of a monomorphic type system,
 usually being the simplest rules in typechecking.


 *
 */
public class MonomorphicTyper {

    String[] tokens, defs;
    int at = 0;

    void msplit(String s) {
        StringTokenizer t = new StringTokenizer(s, ":(),!", true);
        tokens = new String[t.countTokens()];

        int i=0;
        while(t.hasMoreTokens()) {
            tokens[i++] = t.nextToken();
        }
    }

    String mustMatch(String s) {
        for (String d : defs) {
            if (d.startsWith(s)) {
                return d.substring(s.length());
            }
        }

        return "";
    }

    String eval() {
        String r = tokens[at++];
        if (tokens[at].equals("(")) {
            r += tokens[at++];
            while(true) {
                r = r + eval() + tokens[at++];
                if (tokens[at-1].equals(")"))
                    break;
            }
        }

        return mustMatch(r+":");
    }


    public String infer(String expression, String[] definitions) {
        msplit(expression+"!") ;

        defs = definitions;
        for (String token : tokens) {
            System.out.println(token);
        }

        return eval();
    }

    public static void main(String[] args) {
        System.out.println(new MonomorphicTyper().
                infer("upper(x)", new String[] {"x:Char","upper(Char):Char"}));

        System.out.println(new MonomorphicTyper().
                infer("ord(upper(letter))",
                        new String[] {"ord(Char):Int","upper(Char):Char","letter:Char","Letter:String"}));
    }
}
