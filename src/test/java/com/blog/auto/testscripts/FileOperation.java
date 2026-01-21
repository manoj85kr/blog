package com.blog.auto.testscripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			c = (char) br.read();
			System.out.println(c);

		} while (c != 'q');

	}

}
