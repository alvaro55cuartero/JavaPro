package test.main;

import java.util.ArrayList;

public class Binario {

	int x = 3;
	
	int notas = 12;
	
	
	public static void main(String[] args) {
		
	
	byte[][] g = binario(12); 


	
	
//		for(int i = 0 ; i < Math.pow(2, 12); i++) {
//			
//			print(g[i]);
//		}
		
	}
	
	public static void print(byte[] g) {
		for(int j = 0; j < 12; j++) {
			System.out.print(g[j]);
		}
		System.out.println("");
	}
	
	public static byte[][] binario(int a) {
		byte[][] b = new byte[(int) Math.pow(2, a) ][12];
		
		for(int i = 1; i < b.length; i++) {
			b[i]  = by(b[i-1]);
		}
		
		
		return b;
	}
	
	public static byte[] by(byte[] b) {
		byte[] k = new byte[12];
		byte[] uno = {1,0,0,0,0,0,0,0,0,0,0,0};
		int f;
		
		int c = 0;
		for(int i = 0; i < 12; i++) {
			
			f = bu(b[i], uno[i], c);
			c = 0;
			if(f == 0) {
				k[i] = 0;
				
			} else if (f == 1) {
				k[i] = 1;
				
			} else if(f == 2){
				k[i] = 0;
				c = 1;
			} else {
				k[i] = 1;
				c = 1;
			}
		}
		return k;
	}
	
	public static int bu(byte a, byte b, int c) {
		return a + b + c;
	}
	
	public byte[][] rep (byte[][] k){
		ArrayList<byte[]> ok = new ArrayList<byte[]>();
		
		for(int i = 0; i <  Math.pow(2, 12); i++) {
			ok.add(k[i]);
		}
		
		for(int i = 0; i <  Math.pow(2, 12) ; i++) {
			
			byte[] h = shift(ok.get(i));
			
			for(int j = 0; j < 10; j++) {
				
				shift(h);
			
			}
			
		}
		
		
		return null;
		
	}
	
	public static byte[] shift(byte[] k) {
		
		byte[] p = new byte[k.length];
		
		for(int i = 1 ; i < p.length; i++) {
			p[i] = k[i-1];
		}
		p[0] = k[k.length-1];
		
		return p;
	}


}
