package datastructures.binarytree.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sharukh Hasan on 9/30/16.
 *
 * Calculates path between two points in a binary tree
 */
public class PathCalculator {
    public static final String DIR_SEPARATOR = "/";

    public String calculate(String absolute, String r1, String r2) {
        if(absolute == null || r1 == null || r2 == null) {
            throw new IllegalArgumentException("You can't pass null strings as input.");
        }

        String[] absolutePath = absolute.split(DIR_SEPARATOR);
        String[] r1Path = r1.split(DIR_SEPARATOR);
        String[] r2Path = r2.split(DIR_SEPARATOR);
        String[] result = calculatePath(absolutePath, r1Path, r2Path);

        StringBuilder stringBuilder = new StringBuilder(DIR_SEPARATOR);
        for(String dir : result) {
            stringBuilder.append(dir);
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    private static String[] calculatePath(String[]... paths) {
        List<String> finalPath = new LinkedList<String>();
        for(String[] path : paths) {
            for(String dir : path) {
                if(dir.equals("..")) {
                    if(!finalPath.isEmpty()) {
                        finalPath.remove(finalPath.size() - 1);
                    }
                } else if (!dir.isEmpty()) {
                    finalPath.add(dir);
                }
            }
        }
        return finalPath.toArray(new String[finalPath.size()]);
    }
}
