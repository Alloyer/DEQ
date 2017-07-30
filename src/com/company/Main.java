package com.company;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = "";
        Deque<String> deque = new Deque<String>();
        while (!str.equals("END")) {
            str = sc.next();
            if(str.equals("-T")) StdOut.println(deque.removeFirst());
            else if(str.equals("-E")) StdOut.println(deque.removeLast());
            else if(str.toCharArray()[0] == '+')
            {
                if(str.toCharArray()[1] == '+')
                {
                    String strToAdd = str.substring(2);
                    deque.addLast(strToAdd);
                }
                else
                {
                    String strToAdd = str.substring(1);
                    deque.addFirst(strToAdd);
                }
            }
        }

        StdOut.println(deque.size() + " left on deque");

        for(String s : deque)
        {
            System.out.println(s);
        }

    }
}
