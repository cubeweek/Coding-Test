package contest.leetcode.biweekly182

class Q1 {
    fun scoreValidator(events: Array<String>): IntArray {
        val answer = IntArray(2)

        for (e in events) {
            when(e) {
                "0","1","2","3","4","5","6" -> answer[0] += e.toInt()
                "W" -> answer[1]++
                "WD" -> answer[0]++
                "NB" -> answer[0]++
            }
            if (answer[1] > 9) break
        }
        return answer
    }
}