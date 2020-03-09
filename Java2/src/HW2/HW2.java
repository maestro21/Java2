package HW2;

public class HW2 {

    public static class WrongMatrixSizeException extends IllegalArgumentException {
        public WrongMatrixSizeException(String s) {
            super(s);
        }
    }

    public static class IllegalMatrixElementException extends NumberFormatException {
        public IllegalMatrixElementException(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {
        // 1st string is correct from HW2 task, others are wrong
        String[] strings = new String[]{
            "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0",
            "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0 10",
            "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0\n10 44 11 3",
            "10 b 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0",
            "10 3  2 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"
        };

        for(int i = 0; i < strings.length; i++) {
            try {
                System.out.println();
                System.out.println(strings[i]);
                float sum = countMatrixSum(getMatrixFromString(strings[i]));
                System.out.printf("Sum / 2 = %f\n", sum);
            } catch (WrongMatrixSizeException | IllegalMatrixElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String[][] getMatrixFromString(String str) throws WrongMatrixSizeException {
        String[] tmp = str.split("\\n");
        String[][] result = new String[4][4];
        if(tmp.length != 4) {
            throw new WrongMatrixSizeException("Wrong matrix size");
        }

        for(int i = 0; i < tmp.length; i++) {
            result[i] = tmp[i].split(" ");
            if(result[i].length != 4) {
                throw new WrongMatrixSizeException("Wrong matrix size");
            }
        }
        return result;
    }

    public static float countMatrixSum(String[][] matrix) throws IllegalMatrixElementException {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                try {
                    int num = Integer.parseInt(matrix[i][j]);
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalMatrixElementException("Illegal matrix element");
                }
            }
        }
        return sum / 2;
    }
}
