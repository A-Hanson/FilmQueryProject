package com.skilldistillery.filmquery.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

class DatabaseAccessTests {
	private DatabaseAccessor db;

	@BeforeEach
	void setUp() throws Exception {
		db = new DatabaseAccessorObject();
	}

	@AfterEach
	void tearDown() throws Exception {
		db = null;
	}

	@Test
	@DisplayName("getFilmById return null for negative id")
	void test_getFilmById_with_invalid_id_returns_null() {
		Film f = db.findFilmById(-42);
		assertNull(f);
	}

	@Test
	@DisplayName("getFilmById returns null for id of zero")
	void test_getFilmById_zero() {
		Film f = db.findFilmById(0);
		assertNull(f);
	}

	@Test
	@DisplayName("getFilmById returns true for id of one")
	void test_getFilmById_one() {
		Film f = db.findFilmById(1);
		String expected = "ACADEMY DINOSAUR";
		String result = f.getTitle();
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("findActorById returns null for negative id")
	void test_findActorById_negative() {
		Actor a = db.findActorById(-42);
		assertNull(a);
	}
	
	@Test
	@DisplayName("findActorById returns null for id of zero")
	void test_findActorById_zero() {
		Actor a = db.findActorById(0);
		assertNull(a);
	}
	
	@Test
	@DisplayName("findActorById returns null for id of zero")
	void test_findActorById_one() {
		Actor a = db.findActorById(1);
		String expected = "Penelope Guiness";
		String result = a.getFullName();
		assertEquals(expected, result);
	}
	
	
}
