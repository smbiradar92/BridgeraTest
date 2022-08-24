package com.bridgera.employeeWage;

import java.util.Scanner;

public class EmployeeWageCalculation {

	final int IS_PRESENT = 1;
	final int IS_PARTTIME = 2;
	final int IS_ABSENT = 0;
	static int WAGE_PER_HOUR = 0;
	static int workingHours = 0;
	static int employeeWage = 0;
	static int maxWorkingDays = 0;
	static int totalEmpWage = 0;
	static int day = 1;
	//defining variables to count the attendance of the employee
	static int absentCount = 0;
	static int presentCount = 0;
	static int partTimeCount = 0;

	// define scanner class to take input values
	static Scanner sc = new Scanner(System.in);
	
	/*
	 * function to calculate the employee attendance.A random function is used for
	 * checking the employee attendance, a while loop is used to calculate the
	 * total employee wage till maximum working days is reached, incrementing the counts for getting 
	 * employee present,Absent or part time
	 */
	public static void attendance() {

		System.out.println(
				"---------DayWise Summary----------");
		while (day != maxWorkingDays+1) {
			int options = (int) (Math.random() * 3);
			switch (options) {
			case 1:
				System.out.println(
						"day" + day + " => Present");
				workingHours = 8;
				presentCount++;
				break;
			case 2:

				System.out.println(
						"day" + day + " => PartTime");
				workingHours = 4;
				partTimeCount++;
				break;
			default:
				System.out.println(
						"day" + day + " => Absent");
				workingHours = 0;
				absentCount++;
			}
			//calculating daily wages for the employee.
			employeeWage = WAGE_PER_HOUR * workingHours;
			System.out.println(
					"Daily Wage => $" + employeeWage);
			System.out.println(
					"----------------------------------");
			//adding daily wage to get the monthly wage of the employee
			totalEmpWage = totalEmpWage + employeeWage;
			day++;
			
		}
	}

	// calling main method
	public static void main(String[] args) {

		System.out.println(
				"Welcome to Employee Wage Builder");
		// using try-catch blocks to handle the exceptions /Data Validation
		try {
			System.out.println(
					"Please enter the maximum working days");
			maxWorkingDays = sc.nextInt();
			System.out.println(
					"Please enter the employee wage per hour");
			WAGE_PER_HOUR = sc.nextInt();
			// condition for checking for non-negative input values
			if (maxWorkingDays > 0 && WAGE_PER_HOUR > 0) {
				attendance();
				System.out.println(
						"The monthly employee Wage of the employee is : $"
								+ totalEmpWage);
				
				System.out.println("Monthly Summary");
				System.out.println("Number of days the employee is Present : "+presentCount);
				System.out.println("Number of days the employee is Absent : "+absentCount);
				System.out.println("Number of days the employee is Present : "+partTimeCount);		
			} else {
				throw new Exception(
						"Please enter only positive values");
			}
		} catch (Exception e) {
			System.out.println(
					"Invalid input!!!\nPlease enter only integer values as input\nCode Terminated");
		}
		sc.close();
	}
}
