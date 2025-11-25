public class SelectionSortProgram {
    public static void main(String[] args) {
        int[] scores = {88, 72, 95, 61, 78};

        for (int i = 0; i < scores.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < scores.length; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        System.out.println("Sorted Exam Scores:");
        for (int s : scores) System.out.print(s + " ");
    }
}
