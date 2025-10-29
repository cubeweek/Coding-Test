package problem.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BJ30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> seminar = new HashMap();
        seminar.put("Algorithm", "204");
        seminar.put("DataAnalysis", "207");
        seminar.put("ArtificialIntelligence", "302");
        seminar.put("CyberSecurity", "B101");
        seminar.put("Network", "303");
        seminar.put("Startup", "501");
        seminar.put("TestStrategy", "105");

        int applyCnt = Integer.parseInt(br.readLine());

        List<String> location = new ArrayList<>();
        while (applyCnt-- > 0) {
            location.add(seminar.get(br.readLine()));
        }

        br.close();
        for (String l : location) System.out.println(l);
    }
}