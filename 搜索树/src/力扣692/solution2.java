package 力扣692;

import java.util.*;
import java.net.Socket;
import java.util.*;
public class solution2 {

        static class WordCount implements Comparable<WordCount> {
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
        }

        public List<String> topKFrequent(String[] words, int k) {
            // 1. 先统计各个单词的出现次数
            Map<String, Integer> map = new TreeMap<>();
            for (String w : words) {
                int count = map.getOrDefault(w, 0);
                map.put(w, count + 1);
            }

            // 2. 将所有单词 + 次数组织成线性结构
            List<WordCount> wordCountList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();

                WordCount wc = new WordCount(word, count);
                wordCountList.add(wc);
            }

            // 3. 进行排序
            Collections.sort(wordCountList);

            // 4. 获取前 k 个元素中的单词
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < k && i < wordCountList.size(); i++) {
                WordCount wc = wordCountList.get(i);
                ans.add(wc.word);
            }

            return ans;
        }

        public static void main(String[] args) {
            String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

            Solution s = new Solution();
            List<String> ans = s.topKFrequent(words, 5);
            System.out.println(ans);
        }
}
