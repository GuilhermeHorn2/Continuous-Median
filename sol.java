package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	public static class cont_median{
		
		public double curr_media = 0;
		public int n = 0;
		
		cont_median(){}
		
		cont_median(List<Double> set){
			
			this.n = set.size();
			
			if(n == 0) {
				return;
			}
			
			int sum = 0;
			for(int i = 0;i < set.size();i++){
				sum+=set.get(i);
			}
			this.curr_media = sum/n;
			
		}
		
		public void add(double x){
			
			if(n == 0) {
				curr_media = x;
				n++;
				return;
			}
			n++;
			curr_media = (curr_media*(n-1) + x)/n;
			
		}
		
		public String toString() {
			return ""+curr_media;
		}
		
	}
	
	public static void main(String[] args) {
	
	
		List<Double> set = new ArrayList<>();
		test_median(set,MAX,0,10);//The bigger the MAX the closer to 5.0 this median will be
		
	}
	
	private static double ger_double(int lower,int upper){
		
		Random r = new Random();
		return (upper-lower)*(r.nextDouble()) + lower ;
	}
	
	private static double test_median(List<Double> set,int itr,int lower,int upper){
		
		cont_median k = new cont_median(set);
		
		System.out.println("median --> "+k.curr_media);
		
		int c = 0;
		while(c < itr){
			k.add(ger_double(lower,upper));
			System.out.println("median --> "+k.curr_media);
			c++;
		}
		return k.curr_media;
	}
	
}
