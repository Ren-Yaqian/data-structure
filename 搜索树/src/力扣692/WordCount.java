package 力扣692;

public class WordCount implements Comparable<WordCount> {
    int count;
    String word;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordCount o) {
        if (this.count == o.count) {
            return this.word.compareTo(o.word);
        }

        return o.count - this.count;
    }

    /*
        o1 = (leetcode, 1)
        o2 = (love, 2)
        排序是从小到大的
        期望结果是 [o2, o1]
        所以：
        期望的比较结果：o2 < o1
        所以：
        o1.compareTo(o2) 应该返回正数
        o2.compareTo(o1) 应该返回负数
        ++++++++++++++++++++++++++++++
        o1 = (i, 2)
        o2 = (love, 2)
        期望结果是 [o1, o2]
        所以，比较结果应该是 o1 < o2
        所以，o1.compareTo(o2) 应该返回负数，反之正数

        告诉前提：
        "i".compareTo("love") 就会返回负数   "i" < "love"
         */
    public int compareTo2(WordCount o) {
        // this 和 o
        // 返回负数说明 this < o

        if (this.count > o.count) {
            // this: (a, 2)    o: (b, 1)    this < o
            return -1;
        } else if (this.count < o.count) {
            // this: (a, 1)    o: (b, 2)    this > o
            return 1;
        } else {
            int cmp = this.word.compareTo(o.word);
            if (cmp < 0) {
                // this: i   o: love  应该是 this < o
                return -1;
            } else if (cmp > 0) {
                // this: love o: i   应该是 this > o
                return 1;
            } else {
                return 0;
            }
        }
    }
}
