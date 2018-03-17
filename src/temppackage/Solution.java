package temppackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static Folder findFolder(List<Folder> folders, int id){
        for (int i = 0; i < folders.size(); i++) {
            Folder folder = folders.get(i);
            if (folder.id == id)
                return folder;
        }
        return null;
    }

    private static void traverse(int[] cows, Folder root){
        if(root.out == 0)
            for(int i : root.cows)
                cows[i]++;
        List<Folder> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            Folder f = children.get(i);
            if (f.access)
                f.appendCow(root.cows);
            traverse(cows, f);
        }
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        List<Folder> folders = new ArrayList<>();


        // parse and build folders
        int Q = scanner.nextInt();
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        while(M-- > 0){
            Folder f = new Folder(scanner.nextInt(), true);
            folders.add(f);
            int K = scanner.nextInt();
            while(K-- > 0)
                f.cows.add(scanner.nextInt());
        }
        while(N-- > 0){
            Folder f = new Folder(scanner.nextInt(), false);
            folders.add(f);
            int K = scanner.nextInt();
            while(K-- > 0)
                f.cows.add(scanner.nextInt());
        }

        // parse and build trees
        int G = scanner.nextInt();
        while(G-- > 0){
            int U = scanner.nextInt();
            int V = scanner.nextInt();
            Folder u = findFolder(folders, U);
            Folder v = findFolder(folders, V);
            if(u != null & v != null){
                u.children.add(v);
                u.out++;
                v.in++;
            }
        }

        // traverse
        int numLeaf = 0;
        int[] cows = new int[Q];
        numLeaf = getNumLeaf(folders, cows);

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < Q; i++)
            if(cows[i] < numLeaf)
                res.add(i);

        for(int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }

    private static int getNumLeaf(List<Folder> folders, int[] cows) {
        int nLeaves=0;
        for(int i = 0; i < folders.size(); i++){
            if(folders.get(i).in == 0)
                traverse(cows, folders.get(i));
            if(folders.get(i).out == 0)
                nLeaves++;
        }
        return nLeaves;
    }

    static class Folder{
        int id = 0;
        boolean access = false; // true: shared, false: confidential
        List<Folder> children = new LinkedList<>();
        List<Integer> cows = new ArrayList<>();
        int in = 0;
        int out = 0;

        Folder(int id, boolean access){
            this.id = id;
            this.access = access;
            in = 0;
            out = 0;
        }

        void appendCow(List<Integer> newCows){
            cows.addAll(newCows);
        }
    }
}
