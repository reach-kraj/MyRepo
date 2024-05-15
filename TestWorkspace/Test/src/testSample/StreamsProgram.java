package testSample;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProgram {
	
	public List<Integer> filterFunction(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = numbers.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());

		return evenNumbers;
	}
	
	public List<String> mapFunction(){
		List<String> names = Arrays.asList("Vikram", "Naveen", "karthickraj", "vaRRUn");
		List<String> upperCaseNames = names.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		long count = names.stream().count();
		System.out.println("mapFunction count of elements: " + count);
		return upperCaseNames;
	}
	
	public List<String> mapFunctionLow(){
		List<String> names = Arrays.asList("PRatHI", "MALAR", "reENA");
		List<String> lowerCaseNames = names.stream()
				.map(String::toLowerCase)
				.collect(Collectors.toList());
		return lowerCaseNames;
	}
	
	public List<Integer> flatMapFunction(){
		List<List<Integer>> numbers = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9)
				);
		List<Integer> flattenedNumbers = numbers.stream()
				.flatMap(List::stream)
				.collect(Collectors.toList());

		return flattenedNumbers;
	}
	
	public List<Integer> distinctFunction(){
		List<Integer> numbers = Arrays.asList(10, 12, 12, 93, 93, 25, 15, 25);
		List<Integer> distinctNumbers = numbers.stream()
				.distinct().sorted()
				.collect(Collectors.toList());

		return distinctNumbers;
	}

	public List<Integer> limitAndSkipFunction(){
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> limitedandSkipNumbers = numbers.stream().skip(2)
				.limit(5)//.skip(2)
				.collect(Collectors.toList());

		return limitedandSkipNumbers;
	}
	
	
	public Set<Integer> collectorsFunction(){
		List<Integer> numbers = Arrays.asList(1, 2,2, 3,3, 4, 5, 6, 7,5, 9, 10);
		Set<Integer> limitedandSkipNumbers = numbers.stream()
				.collect(Collectors.toSet());

		return limitedandSkipNumbers;
	}
	
	public static void arrayFuntion() {
		String[] array = {"Laptop", "Charger", "board"};
		Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);
	}
	
	public void arrayFuntion2() {
		String[] array = {"Laptop", "Charger", "board"};
		Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StreamsProgram streamsProgram = new StreamsProgram();
		
		System.out.println("filter function evenNumbers: " + streamsProgram.filterFunction());
		System.out.println("mapFunctionCaps: " + streamsProgram.mapFunction());
		System.out.println("mapFunctionLow : " + streamsProgram.mapFunctionLow());
		System.out.println("flatMapFunction: " + streamsProgram.flatMapFunction());
		System.out.println("distinctFunction and sortingFunction: " + streamsProgram.distinctFunction());
		System.out.println("limitAndSkipFunction: " + streamsProgram.limitAndSkipFunction());
		System.out.println("collectorsFunction: " + streamsProgram.collectorsFunction());
		//static
		StreamsProgram.arrayFuntion();
		//non static
		streamsProgram.arrayFuntion2();
	}

}
