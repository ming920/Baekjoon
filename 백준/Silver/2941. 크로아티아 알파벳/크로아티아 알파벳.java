import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alphabets = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        
        String line = br.readLine();
        for (String str : alphabets) {
            line = line.replace(str, " ");
        }

        System.out.println(line.length());
    }
}