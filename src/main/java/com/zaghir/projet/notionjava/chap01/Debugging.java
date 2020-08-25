package com.zaghir.projet.notionjava.chap01;

import static java.util.stream.Collectors.toList;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class Debugging {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		numbers.stream().map(Calc::divideByZero).forEach(System.out::println);
		
		
		List<Integer> result =
				numbers.stream()
				.peek(x -> System.out.println("peek    from stream: " + x))
				.map(x -> x + 17)
				.peek(x -> System.out.println("peek    after map: " + x))
				.filter(x -> x % 2 == 0)
				.peek(x -> System.out.println("peek    after filter: " + x))
				.limit(3)
				.peek(x -> System.out.println("peek    after limit: " + x))
				.collect(toList());
		
		LocalDate date = LocalDate.now() ;//LocalDate.of(2017, 9, 21);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		System.out.println("year = "+year +" month ="+month.getValue()+" day="+day+" dow="+dow+" len="+len+" leap="+leap);
		
		
//		LocalTime time = LocalTime.of(13, 45, 20);
		LocalTime time = LocalTime.now();
		int hour = time.getHour();
		int minute = time.getMinute();
		int second = time.getSecond();
		System.out.println("hour = "+hour +" minute ="+minute+" second="+second);
		
//		LocalDate date = LocalDate.parse("2017-09-21");
//		LocalTime time = LocalTime.parse("13:45:20");
		
		LocalDateTime dt1 = LocalDateTime.of(2017, Month.SEPTEMBER, 21, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		
		System.out.println(Instant.ofEpochSecond(3));
		System.out.println(Instant.ofEpochSecond(3, 0));
		System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));
		System.out.println(Instant.ofEpochSecond(4, -1_000_000_000));
		
//		Duration d1 = Duration.between(time1, time2);
//		Duration d1 = Duration.between(dateTime1, dateTime2);
//		Duration d2 = Duration.between(instant1, instant2);
		
		Period tenDays = Period
				.between(
						LocalDate.of(2017, 9, 11),
						LocalDate.of(2017, 10, 21));
		System.out.println("tenDays = " +tenDays.getMonths()+"  "+ tenDays.getDays());
		
		Duration threeMinutes = Duration.ofMinutes(3);
		System.out.println("threeMinutes ="+threeMinutes);
		Duration threeMinutess = Duration.of(3, ChronoUnit.MINUTES);
		System.out.println("threeMinutes ="+threeMinutess);
		Period tenDayss = Period.ofDays(10);
		System.out.println("threeMinutes ="+tenDayss);
		Period threeWeeks = Period.ofWeeks(3);
		System.out.println("threeMinutes ="+threeWeeks);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		System.out.println("threeMinutes = "+twoYearsSixMonthsOneDay);
		
		LocalDate date0 = LocalDate.of(2014, 3, 18);
		System.out.println("date0 = "+date0);
		date0 = date.with(ChronoField.MONTH_OF_YEAR, 9);
		System.out.println("date0 = "+date0);
		date0 = date.plusYears(2).minusDays(10);
		System.out.println("date0 = "+date0);
		date0.withYear(2011);
		System.out.println("date0 = "+date0);
	}

//	public static int divideByZero(int n) {
//		return n / 0;
//	}
}
