package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        int i = 0;
        while (i < list.size() - 1) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String element = list.get(i);
            list.add(i, element);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;

        int i = 0;
        while (i < list.size() - 1) {
            String current = list.get(i);
            String next = list.get(i + 1);

            if (current.equals(next)) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (element.length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            stack.push(val);
            queue.add(val);
        }

        boolean isPal = true;

        for (int i = 0; i < size; i++) {
            int val = queue.remove();
            int stackVal = stack.pop();

            if (val != stackVal) {
                isPal = false;
            }
            queue.add(val);
        }

        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        List<Integer> tempList = new ArrayList<>(stack);
        Collections.sort(tempList);

        for (int num : tempList) {
            queue.add(num);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Queue<Integer> evenQueue = new LinkedList<>();
        Queue<Integer> oddQueue = new LinkedList<>();

        int size = queue.size();
        for(int i = 0; i < size; i++) {
            int val = queue.remove();
            if (val % 2 == 0) {
                evenQueue.add(val);
            } else {
                oddQueue.add(val);
            }
        }

        while (!evenQueue.isEmpty()) {
            queue.add(evenQueue.remove());
        }
        while (!oddQueue.isEmpty()) {
            queue.add(oddQueue.remove());
        }
    }

    public int maxLength(Set<String> set) {
        int maxLength = 0;
        for (String str : set) {
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.length() % 2 == 0) {
                iterator.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map.isEmpty()) return true;

        Collection<String> values = map.values();
        Set<String> uniqueValues = new HashSet<>(values);

        return uniqueValues.size() == map.size();
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer val1 = map1.get(key);
                Integer val2 = map2.get(key);

                if (val1 != null && val1.equals(val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> reversedMap = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer originalKey = entry.getKey();
            String originalValue = entry.getValue();

            reversedMap.put(originalValue, originalKey);
        }
        return reversedMap;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer val : map.values()) {
            if (counts.containsKey(val)) {
                counts.put(val, counts.get(val) + 1);
            } else {
                counts.put(val, 1);
            }
        }

        int minCount = Integer.MAX_VALUE;
        int resultValue = 0;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                resultValue = value;
            } else if (count == minCount) {
                if (value < resultValue) {
                    resultValue = value;
                }
            }
        }

        return resultValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();

        for (Integer num : list) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        int maxCount = 0;
        for (Integer count : counts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }
}