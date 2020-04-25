package com.mpt.mm;
/*
 * 【2020年4月25日にサミットしたテクス１です。】
 * タスク１から６まであります。
 * タスク４の解決
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class Solution {

	public static void main(String[] args) {
		//Task４の入力データ
		int N = 1234;
		//出力データ【入力データと似ている全部のデータの回数】
		int result = task4(N);
		
		System.out.println(result);
		
	}

	/**
	 * <pre>
	 * 【2020年月日にサミットしたタスク４です。】
	 * 入力数字データと似ている全部の数字データの回数
	 * 例（１）　：　123 ⇨「１２３」と似ている数字は　「123,132,213,231,312,321」です。
	 * 　　　　　　　ですから答えは「６」です・
	 * 例（２）　：　1123 ⇨「１１２３」と似ている数字は「1123,1132,1231,1321,2311,2113,2131,3211,3112,3121,1213,1312」です。
	 * 　　　　　　　ですから答えは「１２」です。
	 * </pre>
	 * 
	 * @param A[] 
	 * 		建物の階の配列
	 * @return　出力データー
	 */
	/**
	 * @param N
	 * @return
	 */
	private static int task4(int N) {
		char[] cArr = String.valueOf(N).toCharArray();
		Long total = getFactorial(cArr.length);
		List<Integer> cList = new ArrayList<Integer>();
		
		char tmp = ' ';
		for(int i = 0; i<cArr.length;i++) {
			int count = 0;
			if(tmp == cArr[i]) continue;
			for(int j = i; j<cArr.length;j++) {
				if(cArr[i] == cArr[j]) {
					tmp = cArr[j];
					count ++;
				}
				
			}
			cList.add(count);
		}
		Object[] a = cList.stream().filter(c -> c > 1).toArray();
		long divisor = 1;
		for(Object num : a) {
			divisor = divisor * getFactorial((int) num);
		}
		long result = total/divisor;
		return (int)result;
	
	}
	/**
	 * <pre>Factorial の計算</pre>
	 * @param num
	 * 		入力数字
	 * @return　入力した数字をFactorialの計算をした値
	 */
	private static long getFactorial(int num) {
		return LongStream.rangeClosed( 1, num )
        .reduce(1, ( long a, long b ) -> a * b);
		
	}

}
