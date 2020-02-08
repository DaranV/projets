package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entit�s.Animal;

class TestAnimal {

	@Test
	void test() {
		Animal a1 = Animal.ELEPHANT;
		assertTrue(a1.getNom().equals("ELEPHANT"));
		
		Animal a2 = Animal.LION;
		assertTrue(a2.equals(Animal.LION));
		Animal a3 = Animal.LION;
		assertTrue(a2.equals(a3));
		
		Animal a4 = Animal.NULL;
		assertFalse(a4.getNom().equals("NULL"));
	}
	
}
