package dz_6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        
        // String path = "КРОК/task_6_2/src/./../../task_6_1/../../../мемы/котики";
        System.out.print("Input your path: ");
        String path = in.nextLine();

        // right answer is "../мемы/котики"
        try {
            System.out.println(normalization_path(path));
        } catch (Exception e) {
            System.out.println("Wrong line format!");
        }
    }

    /**
     * Getting right path (using normalization:
     *                                            "." means current directory
     *                                            ".." means parents directory for attitude to current directory
     *                                            "/" using for dividing directories)
     * @param path input path for normalization
     * @return right path
     */
    public static String normalization_path(String path) throws Exception {

        // checking on wrong input format
        if (path.startsWith("/") || path.endsWith("/")) {
            throw new Exception("Input correct path!");
        }

        // work with path
        for(int i=path.length()-1;i>=0;){

            // line has current or parent directory
            if (i-1>= 0 && path.substring(i-1, i+1).equals("./")) {

                // it has parent directory
                if (path.charAt(i-2) == '.') {
                    return path.substring(i-2);
                }

                // it has current directory
                return path.substring(i-1);
            }
            else {
                i--;
            }
        }
        return path;
    }
}
