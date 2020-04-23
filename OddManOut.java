import java.util.*;
import java.io.*;

public class OddManOut {
	public static void main(String[] args) {
		Kattio scan = new Kattio(System.in);

		int N = scan.getInt();
		for (int i =0; i < N; i++) {
			int G = scan.getInt();
			ArrayList<Long> usedc = new ArrayList<Long>(G);
			for (int j = 0; j< G; j++) {
				long C = scan.getLong();
				if (usedc.contains(C)) {
					usedc.remove(C);
					continue;
				}
				else {
					usedc.add(C);
				}
			}

			int count = i + 1;
			System.out.println("Case #" + count + ": " + usedc.get(0) );
		}

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