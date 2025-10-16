package sample;

import java.io.*;

public class Sample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!"".equals(br.readLine())) {
            bw.write(Integer.parseInt(br.readLine()));
            bw.flush();
        }

        int b = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(b));
        bw.flush();
        bw.close();
    }
}
