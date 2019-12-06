package org.springframework.samples.triangle;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TriangleTypeTest {
	TriangleType t;
	Random r;
	int inOne, inTwo, inThree;

	@Before
	public void init(){
		t = new TriangleType();
		r = new Random();
	}

	@Test
	public void lessThanZeroTest() {
		int inputVal = r.nextInt(3)+1;

		if(inputVal == 1){
			inOne = r.nextInt(50)-50;
		}else{
			inOne = r.nextInt(50)-10;
		}

		if(inputVal == 2){
			inTwo = r.nextInt(50)-50;
		}else{
			inTwo = r.nextInt(50)-10;
		}

		if(inputVal == 3){
			inThree = r.nextInt(50)-50;
		}else{
			inThree = r.nextInt(50)-10;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);

		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void equalToZeroTest() {
		int inputVal = r.nextInt(3)+1;

		if(inputVal == 1){
			inOne = 0;
		}else{
			inOne = r.nextInt(50);
		}

		if(inputVal == 2){
			inTwo = 0;
		}else{
			inTwo = r.nextInt(50);
		}

		if(inputVal == 3){
			inThree = 0;
		}else{
			inThree = r.nextInt(50);
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void dontAddUpTest() {
		int inputVal = r.nextInt(3)+1;

		if(inputVal == 1){
			inTwo = r.nextInt(50) + 1;
			inThree = r.nextInt(50) + 1;
			inOne = inTwo + inThree + r.nextInt(10);
		}
		if(inputVal == 2){
			inOne = r.nextInt(50) + 1;
			inThree = r.nextInt(50) + 1;
			inTwo = inOne + inThree + r.nextInt(10);
		}
		if(inputVal == 3){
			inTwo = r.nextInt(50) + 1;
			inOne = r.nextInt(50) + 1;
			inThree = inTwo + inOne + r.nextInt(10);
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void EquilateralTest() {
		int val = r.nextInt(50)+1;

		Triangle test = t.triangle(val, val, val);
		assertEquals(Triangle.EQUILATERAL, test);
	}

	@Test
	public void IsoscelesTest() {
		int inputVal = r.nextInt(3)+1;

		if(inputVal == 1){
			int valOne = r.nextInt(50) + 1;
			int valTwo = r.nextInt(50) + 1;
			while((valOne == valTwo)||(2*valTwo <= valOne)){
				valTwo = r.nextInt(50) + 1;
			}

			inOne = valOne;
			inTwo = valTwo;
			inThree = valTwo;
		}
		if(inputVal == 2){
			int valOne = r.nextInt(50) + 1;
			int valTwo = r.nextInt(50) + 1;
			while((valOne == valTwo)||(2*valTwo <= valOne)){
				valTwo = r.nextInt(50) + 1;
			}

			inOne = valTwo;
			inTwo = valOne;
			inThree = valTwo;
		}
		if(inputVal == 3){
			int valOne = r.nextInt(50) + 1;
			int valTwo = r.nextInt(50) + 1;
			while((valOne == valTwo)||(2*valTwo <= valOne)){
				valTwo = r.nextInt(50) + 1;
			}

			inOne = valTwo;
			inTwo = valTwo;
			inThree = valOne;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.ISOSCELES, test);
	}

	@Test
	public void ScaleneTest() {
		inOne = r.nextInt(50) + 1;
		inTwo = r.nextInt(50) + 1;
		while(inOne == inTwo){
			inTwo = r.nextInt(50) + 1;
		}
		inThree = r.nextInt(inOne + inTwo) + 1;
		while((inOne == inThree)||(inTwo == inThree)||(inOne + inTwo <= inThree)||(inOne + inThree <= inTwo)||(inTwo + inThree <= inOne)){
			inThree = r.nextInt(inOne + inTwo) + 1;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.SCALENE, test);
	}

	// FLAKY TESTS
	@Test
	public void flakyLessThanZeroTest() {
		int flaky = r.nextInt(2);
		if(flaky == 0){
			int inputVal = r.nextInt(3)+1;

			if(inputVal == 1){
				inOne = r.nextInt(50)-50;
			}else{
				inOne = r.nextInt(50)-10;
			}

			if(inputVal == 2){
				inTwo = r.nextInt(50)-50;
			}else{
				inTwo = r.nextInt(50)-10;
			}

			if(inputVal == 3){
				inThree = r.nextInt(50)-50;
			}else{
				inThree = r.nextInt(50)-10;
			}
		}else{
			inOne = r.nextInt(50)-10;
			inTwo = r.nextInt(50)-10;
			inThree = r.nextInt(50)-10;
		}
		System.out.println(inOne + " " + inTwo + " " + inThree);

		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void flakyEqualToZeroTest() {
		int flaky = r.nextInt(2);
		if(flaky == 0){
			int inputVal = r.nextInt(3)+1;

			if(inputVal == 1){
				inOne = 0;
			}else{
				inOne = r.nextInt(50);
			}

			if(inputVal == 2){
				inTwo = 0;
			}else{
				inTwo = r.nextInt(50);
			}

			if(inputVal == 3){
				inThree = 0;
			}else{
				inThree = r.nextInt(50);
			}
		}else{
			inOne = r.nextInt(50);
			inTwo = r.nextInt(50);
			inThree = r.nextInt(50);
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void flakyDontAddUpTest() {
		int flaky = r.nextInt(2);
		if(flaky == 0){
			int inputVal = r.nextInt(3)+1;

			if(inputVal == 1){
				inTwo = r.nextInt(50) + 1;
				inThree = r.nextInt(50) + 1;
				inOne = inTwo + inThree + r.nextInt(10);
			}
			if(inputVal == 2){
				inOne = r.nextInt(50) + 1;
				inThree = r.nextInt(50) + 1;
				inTwo = inOne + inThree + r.nextInt(10);
			}
			if(inputVal == 3){
				inTwo = r.nextInt(50) + 1;
				inOne = r.nextInt(50) + 1;
				inThree = inTwo + inOne + r.nextInt(10);
			}
		}else{
			inOne = r.nextInt(50)+1;
			inTwo = r.nextInt(50)+1;
			inThree = r.nextInt(50)+1;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.INVALID, test);
	}

	@Test
	public void flakyEquilateralTest() {
		Triangle test;
		int flaky = r.nextInt(2);
		if(flaky == 0){
			int val = r.nextInt(50)+1;


			test = t.triangle(val, val, val);
		}else{
			inOne = r.nextInt(50)+1;
			inTwo = r.nextInt(50)+1;
			inThree = r.nextInt(50)+1;
			test = t.triangle(inOne, inTwo, inThree);
		}
		assertEquals(Triangle.EQUILATERAL, test);
	}

	@Test
	public void flakyIsoscelesTest() {
		int flaky = r.nextInt(2);
		if(flaky == 0){
			int inputVal = r.nextInt(3)+1;

			if(inputVal == 1){
				int valOne = r.nextInt(50) + 1;
				int valTwo = r.nextInt(50) + 1;
				while((valOne == valTwo)||(2*valTwo <= valOne)){
					valTwo = r.nextInt(50) + 1;
				}

				inOne = valOne;
				inTwo = valTwo;
				inThree = valTwo;
			}
			if(inputVal == 2){
				int valOne = r.nextInt(50) + 1;
				int valTwo = r.nextInt(50) + 1;
				while((valOne == valTwo)||(2*valTwo <= valOne)){
					valTwo = r.nextInt(50) + 1;
				}

				inOne = valTwo;
				inTwo = valOne;
				inThree = valTwo;
			}
			if(inputVal == 3){
				int valOne = r.nextInt(50) + 1;
				int valTwo = r.nextInt(50) + 1;
				while((valOne == valTwo)||(2*valTwo <= valOne)){
					valTwo = r.nextInt(50) + 1;
				}

				inOne = valTwo;
				inTwo = valTwo;
				inThree = valOne;
			}
		}else{
			inOne = r.nextInt(50)+1;
			inTwo = r.nextInt(50)+1;
			inThree = r.nextInt(50)+1;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.ISOSCELES, test);
	}

	@Test
	public void flakyScaleneTest() {
		int flaky = r.nextInt(2);
		if(flaky == 0){
			inOne = r.nextInt(50) + 1;
			inTwo = r.nextInt(50) + 1;
			while(inOne == inTwo){
				inTwo = r.nextInt(50) + 1;
			}
			inThree = r.nextInt(inOne + inTwo) + 1;
			while((inOne == inThree)||(inTwo == inThree)||(inOne + inTwo <= inThree)||(inOne + inThree <= inTwo)||(inTwo + inThree <= inOne)){
				inThree = r.nextInt(inOne + inTwo) + 1;
			}
		}else{
			inOne = r.nextInt(50)+1;
			inTwo = r.nextInt(50)+1;
			inThree = r.nextInt(50)+1;
		}

		System.out.println(inOne + " " + inTwo + " " + inThree);
		Triangle test = t.triangle(inOne, inTwo, inThree);
		assertEquals(Triangle.SCALENE, test);
	}
	
	// To Test New Failing Code
	@Test
	public void inputsAreThreeFourFive(){
		Triangle test = t.triangle(3, 4, 5);
		assertEquals(Triangle.SCALENE, test);
	}
	
	@Test
	public void inputsAreZeroZeroFive(){
		Triangle test = t.triangle(0, 0, 5);
		assertEquals(Triangle.INVALID, test);
	}
}
