package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.XML;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o caminho da pasta do arquivo: ");
		String path = sc.nextLine();
		System.out.print("Digite o nome do arquivo .xml: ");
		String file = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path + "\\" + file))) {

			JSONObject json = XML.toJSONObject(br);
			String jsonString = json.toString(4);

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\xml-convertido.json"))) {

				bw.write(jsonString);

				System.out.println("XML convertido com sucesso!");

			} catch (IOException e) {

				e.printStackTrace();

			}

		} catch (IOException e) {

			System.out.println("Error: " + e.getMessage());
		}

	}

}
