package problem.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] minho = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        String password = br.readLine();
        Map<Character, Integer> dna = new HashMap<>();
        char[] target = {'A','C','G','T'};
        int[] goal = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
        for (int i=0; i<goal.length; i++) if (goal[i] != 0) dna.put(target[i], goal[i]);

        int answer = 0, st = 0, ed = minho[1];

        String candi = password.substring(st, ed);
        for (char c : candi.toCharArray()) dna.computeIfPresent(c, (k, v) -> --v);
        if (dna.values().stream().filter(v -> v <= 0).count() == dna.size()) ++answer;

        while (ed < minho[0]) {
            dna.computeIfPresent(password.charAt(st++), (k, v) -> ++v);
            dna.computeIfPresent(password.charAt(ed++), (k, v) -> --v);
            if (dna.values().stream().filter(v -> v <= 0).count() == dna.size()) ++answer;
        }

        System.out.println(answer);
        br.close();
    }
}