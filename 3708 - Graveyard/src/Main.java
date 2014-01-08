import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws Exception {
		MyScanner s = new MyScanner(System.in);		
		while (s.hasNext()) {
			int o=s.nextInt();
			int n=s.nextInt()+o;
			double[] os=new double[o];
			double[] cs=new double[n];
			
			for(int i=0;i<o;i++){
				os[i]=(double)i/(double)o;
			}
			
			for(int i=0;i<n;i++){
				cs[i]=(double)i/(double)n;
			}
			
			double result=0;
			
			for(int i=0;i<o;i++){
				double min=Double.MAX_VALUE;
				double diff=0;
				for(int j=0;j<n;j++){
					diff=Math.abs(cs[j]-os[i]);
					min=min>diff?diff:min;
				}
				result+=min;				
			}
			
			result*=10000;
			System.out.printf("%.4f\n", result);
		}
	}
}

class MyScanner {
	BufferedReader reader;

	StringTokenizer tokenizer;

	MyScanner(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}
	
	boolean hasNext() throws IOException{
		reader.mark(4000);
		boolean returnValue=(reader.readLine()!=null);
		reader.reset();
		return returnValue;
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}