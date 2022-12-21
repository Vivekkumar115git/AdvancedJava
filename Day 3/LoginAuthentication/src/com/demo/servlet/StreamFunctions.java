package com.demo.test;
import java.util.Optional;
import java.util.stream.Stream;
public class StreamFunctions {

	public static void main(String[] args) {
		
		Stream<Integer> s1=Stream.of(10,12,13,14);
			s1.forEach(System.out::println);
			Stream.of(10,12,13,14).filter(e->e%2==0).forEach(System.out::println);
			
			
			System.out.println("--------------------------------");
			Stream<Integer> s3=Stream.of(100,127,130,145);
			Stream s4=s3.filter(e->{System.out.println("in filter"+e);return e%2==0;});
			System.out.println("**********************");
			System.out.println("Count: "+s4.count());
			Stream<Integer> s31=Stream.of(100,127,150,145);
			Optional<Integer> op=s31.filter(e->{System.out.println("in filter"+e);
			return e%7==0;}).findFirst();
			if(op.isPresent()) {
				System.out.println(op.get());
			}
			else {
				System.out.println("not found");
			}
			op.ofNullable("xxxxxx");
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


