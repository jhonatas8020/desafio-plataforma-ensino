package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Dados da " + (i + 1) + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Título: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			switch(type) {
			case 'c':
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				
				list.add(new Video(title, url, seconds));
				break;
			case 't':
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int nQuestions = sc.nextInt();
				
				list.add(new Task(title, description, nQuestions));
				break;
			}
		}
		
		int total = 0;
		for(Lesson l : list) {
			total += l.duration();
		}
		
		System.out.println();
		System.out.println("DURAÇÃO TOTAL DO CURSO = " + total + " segundos");
		
		sc.close();
	}

}
