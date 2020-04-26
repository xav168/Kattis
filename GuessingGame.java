import java.util.*;
import java.io.*;

public class GuessingGame {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in,System.out);
		// placeholder int for smallest number that is "too high" and largest number that is "too small"
		int larger = 11;
		int smaller = 0;
		for (int i = 0; i < 2501; i++) {
			int x = io.getInt();
			if (x==0)
				break;
			String guess = io.getLine();
			// target number is less than x
			if (guess.equals("too high")) {
				if (x < larger)
					larger = x;
			}
			// target number is x
			else if (guess.equals("too low")) {
				if (x > smaller)
					smaller = x;
			}
			// game end, output response
			else {
				if (x < larger && x > smaller) 
					io.println("Stan may be honest");
				else
					io.println("Stan is dishonest");
				larger = 11;
				smaller = 0;
			}
		}
		io.close();
	}
} 


class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String getLine() {
		String str = ""; 
		try
		{ 
			str = r.readLine(); 
		} 
			catch (IOException e) 
		{ 
			e.printStackTrace(); 
		} 
		return str; 
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}