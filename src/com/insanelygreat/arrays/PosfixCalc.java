package com.insanelygreat.arrays;

import com.insanelygreat.Stack;
import com.insanelygreat.StackImpl;

/**
 *
 */
public class PosfixCalc {

    public static void main(String[] args) {
        /**
         * Stack states
         *
         * 2
         *
         * 3
         * 2
         *
         * 1
         * 3
         * 2
         *
         * 3
         * 2
         *
         * 5
         *
         * 9
         * 5
         *
         * 4
         */
        System.out.print(evaluateExpression("231*+9-"));

    }

    static int evaluateExpression(String exp) {
        Stack<Integer> stack = new StackImpl<>();
        for (int i = 0; i < exp.length(); i++) {

            //RPN algorithm
            // If digit push into the stack
            // If expression pop two items from the stack and apply the expression
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
