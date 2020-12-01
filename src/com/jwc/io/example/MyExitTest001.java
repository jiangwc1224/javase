package com.jwc.io.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyExitTest001 {
	public static void main(String[] args) {
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;

		inputStreamReader = new InputStreamReader(System.in);
		outputStreamWriter = new OutputStreamWriter(System.out);
		bufferedReader = new BufferedReader(inputStreamReader);
		bufferedWriter = new BufferedWriter(outputStreamWriter);
		try {
			String str = "";
			while (!str.equals("exit")) {

				str = bufferedReader.readLine();
				bufferedWriter.write(str);
				bufferedWriter.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				bufferedWriter.close();
				bufferedReader.close();
				outputStreamWriter.close();
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
