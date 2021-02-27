package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//	private void test() {
//		Film film = db.findFilmById(1);
//		Actor actor = db.findActorById(1);
//		System.out.println(film);
//		System.out.println(actor);
//	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepGoing = true;
		int userChoice = 0;
		do {
			printMainMenu();
			try {
				userChoice = input.nextInt();
				input.nextLine();
				keepGoing = startSelection(userChoice, input);
			} catch (InputMismatchException e) {
				System.out.println("Was expecting a whole number, please try again.");
				input.nextLine();
			}
		} while (keepGoing);
	}
	private boolean startSelection(int userChoice, Scanner input) {
		boolean keepGoing = true;
		switch (userChoice) {
		case 1:
			printFilmIdMenu();
			try {
				int id = input.nextInt();
				input.nextLine();
				Film film = findFilmById(id);
				if (film != null) {
					runSubMenu(input, film, null);
				}
			} catch (InputMismatchException e) {
				System.out.println("Was expecting a whole number, please try again.");
				input.nextLine();
			}
			break;
		case 2:
			printFilmKeywordMenu();
			String kw = input.nextLine();
			List<Film> list = findFilmByKeyword(kw);
			if (list != null) {
				runSubMenu(input, null, list);
			}
			break;
		case 3:
			keepGoing = false;
			System.out.println("Goodbye.");
			break;
		default:
			System.out.println("Please enter 1, 2, or 3.");
		}
		return keepGoing;
	}
	
	private void runSubMenu(Scanner input, Film film, List<Film> list) {
		printSubMenu();
		try {
			int choice = input.nextInt();
			input.nextLine();
			subMenuSelection(choice, film, list);
		} catch (InputMismatchException e) {
			System.out.println("Was expecting a whole number, please try again.");
			input.nextLine();
		}
	}
	
	private void subMenuSelection(int choice, Film filmId, List<Film> list) {
		switch (choice) {
		case 1:
			System.out.println("Returning to main menu...");
			break;
		case 2:
			if (list == null) {
				System.out.println(filmId.toString());
			}
			else {
				for (Film film : list) {
					System.out.println(film.toString());
					System.out.println("--------");
				}
			}
			break;
		default:
			System.out.println("Hmmmm, not sure what that was. Let's just go back to the main menu.");
		}
	}
	
	private List<Film> findFilmByKeyword(String kw) {
		List<Film> films = db.findFilmByKeyword(kw);
		if (films.size() == 0) {
			System.out.println("Sorry, no films were found with your search term.");
		} else {
			for (Film film : films) {
				displayFilm(film);
				System.out.println("----------");
			}
		}
		return films;
	}
	
	private Film findFilmById(int id) {
		Film film = db.findFilmById(id);
		if (film == null) {
			System.out.println("Sorry, that id doesn't have any movies.");
		} else {
			displayFilm(film);
		}
		return film;
	}
	private void displayFilm(Film f) {
		StringBuilder sb = new StringBuilder("Title: ").append(f.getTitle())
								.append("\nYear Released: ").append(f.getReleaseYear())
								.append("\nRating: ").append(f.getRating())
								.append("\nLanguage: ").append(f.getLanguage())
								.append("\nDescription: ").append(f.getDescription())
								.append("\nActors: ");
		for (Actor actor : f.getActors()) {
			sb.append(actor.getFullName() + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		System.out.println(sb.toString());
	}
	private void printSubMenu() {
		System.out.println("*-------------------------------------------------*");
		System.out.println("* What do you want to do next?					  *");
		System.out.println("* 1. Return to Main Menu 						  *");
		System.out.println("* 2. Print all of the film's details			  *");
		System.out.println("*-------------------------------------------------*");
	}
	
	private void printFilmKeywordMenu() {
		System.out.println("*-------------------------------------------------*");
		System.out.println("* What keyword do you want to search for?		  *");
		System.out.println("*-- Please enter selection below -----------------*");
	}
	private void printFilmIdMenu() {
		System.out.println("*-------------------------------------------------*");
		System.out.println("* What is the id of the film you want to see? *");
		System.out.println("*-- Please enter selection below -----------------*");
	}

	private void printMainMenu() {
		System.out.println("*-------------------------------------------------*");
		System.out.println("* What would you like to do?  		  *");
		System.out.println("* 1. Look up a film by its id 		  *");
		System.out.println("* 2. Look up a film by a search keyword   *");
		System.out.println("* 3. Exit				  *");
		System.out.println("*-- Please enter selection below -----------------*");
	}

}
