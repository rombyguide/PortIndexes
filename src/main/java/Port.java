import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Blinov
 */

public class Port {

    // Метод переводит строку в список чисел
    // "1,3,4,5" -> [1,3,4,5]
    public static List<Integer> stringToListInt(String str) {
        String[] tmpArray = str.split(",");
        List<Integer> listInt = new ArrayList<>();
        for (int i = 0; i < tmpArray.length; i++) {
            listInt.add(Integer.parseInt(tmpArray[i]));
        }

        return listInt;
    }

    // Метод проверяет строку на содержание дефиса, если он есть, то изменяет её в список чисел
    // "3-7" -> "3,4,5,6,7"
    public static String stringContainHyphen(String str) {
        if (str.contains("-")) {
            List<Integer> listInt = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            String[] tmpArray = str.split("-");
            int left = Integer.parseInt(tmpArray[0]);
            int right = Integer.parseInt(tmpArray[1]);
            listInt.add(left);

            while (left != right) {
                left++;
                listInt.add(left);
            }

            for (int i = 0; i < listInt.size(); i++) {
                builder.append(listInt.get(i));
                if (i < (listInt.size() - 1)) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }
        return str;
    }

    // 1. Метод, преобразовывающий массив строк indexes в массив последовательностей чисел
    // {"1,3-5", "2", "3-4"} -> {"1,3,4,5", "2", "3,4"}
    public static String[] sequencesOfNumbers(String[] indexes) {
        List<String> stringList = new ArrayList<>();

        for (String index : indexes) {
            if (index.contains(",")) {
                StringBuilder builder = new StringBuilder();
                String[] tmpArray = index.split(",");

                for (int i = 0; i < tmpArray.length; i++) {
                    builder.append(stringContainHyphen(tmpArray[i]));
                    if (i < (tmpArray.length - 1)) {
                        builder.append(",");
                    }
                }

                stringList.add(builder.toString());
            } else {
                stringList.add(stringContainHyphen(index));
            }
        }

        return stringList.toArray(new String[0]);
    }

    // Метод генерации всевозможных перестановок
    private static void generatingPermutations(List<List<Integer>> listInt,
                                               List<Integer> tempList,
                                               List<List<Integer>> initLists) {
        if (tempList.size() == initLists.size()) {
            listInt.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < initLists.size(); i++) {
            if (tempList.size() != i) {
                continue;
            }

            for (int j = 0; j < initLists.get(i).size(); j++) {
                tempList.add(initLists.get(i).get(j));
                generatingPermutations(listInt, tempList, initLists);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // 2. Метод, возвращающий все возможные упорядоченные пары элементов полученных массивов чисел.
    public static int[][] permutationsToArrInt(String[] strings) {
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> permutations = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            lists.add(i, stringToListInt(strings[i]));
        }

        generatingPermutations(permutations, new ArrayList<>(), lists);
        return permutations
                .stream().map(per -> per.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
