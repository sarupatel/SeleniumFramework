import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStream {

	public static void main(String[] args) {
		//regular();
		//streamFilter();
		//streamMap();
		streamCollect();
		
	}
	
	public static void regular() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aleksey");
		names.add("Santosh");
		names.add("amar");
		System.out.println("Inside regular() method");
		int count = 0;
		for(String name : names) {
			if(name.startsWith("A") || name.startsWith("a")) {
				count++;
			}
		}
		System.out.println("Number of names starting with A/a: " + count);
	}
	
	public static void streamFilter() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Aleksey");
		names.add("Santosh");
		names.add("amar");
		System.out.println("Original List");
		names.stream().forEach(s->System.out.println(s));
		System.out.println("Inside streamFiter() method");
		Long count = names.stream().filter(s->s.startsWith("A") || s.startsWith("a")).count();
		System.out.println("Number of names starting with A/a: " + count);
		System.out.println("Names greater than 4 characters");
		names.stream().filter(s -> s.length() >4).limit(2).forEach(s->System.out.println(s.toUpperCase()));
		
	}
	
	public static void streamMap() {
		System.out.println("Names ending with a in uppercase");
		Stream.of("Abhijeet", "Rama", "Sarita").filter(s->s.endsWith("a")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		List<String> names = Arrays.asList("Abhijeet", "Don", "Aleksey", "Ram", "Adam");
		System.out.println("Names starting with A and sorted");
		names.stream().filter(s-> s.startsWith("A")).sorted().map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Medha");
		names1.add("Sneha");
		names1.add("Dhaval");
		//Merging two list
		Stream<String> newNames = Stream.concat(names.stream(), names1.stream());
		//newNames.sorted().forEach(s->System.out.println(s));
		boolean flag = newNames.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	public static void streamCollect() {
		List<String> ls =Stream.of("Abhijeet", "Rama", "Sarita").filter(s->s.endsWith("a")).map(s-> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2, 7,5,1,9,7);
		System.out.println("Unique Numbers");
		values.stream().distinct().forEach(s-> System.out.println(s));
		System.out.println("3 item in the Sorted List");
		List<Integer> newValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newValues.get(2));
	}
}
