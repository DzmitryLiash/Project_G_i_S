package com.company;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.*;
import java.util.*;

class SCCKosaraju {

    public static List<List<Integer>> scc(List<Integer>[] graph) {
        int n = graph.length;
        boolean[] used = new boolean[n];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!used[i])
                dfs(graph, used, order, i);

        List<Integer>[] reverseGraph = new List[n];
        for (int i = 0; i < n; i++)
            reverseGraph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j : graph[i])
                reverseGraph[j].add(i);

        List<List<Integer>> components = new ArrayList<>();
        Arrays.fill(used, false);
        Collections.reverse(order);

        for (int u : order)
            if (!used[u]) {
                List<Integer> component = new ArrayList<>();
                dfs(reverseGraph, used, component, u);
                components.add(component);
            }

        return components;
    }

    static void dfs(List<Integer>[] graph, boolean[] used, List<Integer> res, int u) {
        used[u] = true;
        for (int v : graph[u])
            if (!used[v])
                dfs(graph, used, res, v);
        res.add(u);
    }

    static List<Integer>[] ReadFile() throws IOException {

        FileReader fileReader = new FileReader("graf1.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linia =  bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(linia);
        int numbOfVert = Integer.parseInt(stringTokenizer.nextToken());

        List<Integer>[] g = new List[numbOfVert];
        for (int i = 0; i < g.length; i++)
            g[i] = new ArrayList<>();


        for (int i=0; i<numbOfVert; ++i){
            linia = bufferedReader.readLine();
            char[] lineOfChar = linia.toCharArray();
            //System.out.println(linia);
            for (int j = 0; j < lineOfChar.length; j++){
                if (lineOfChar[j] == 49){
                    g[i].add(j);
                    System.out.print(i + " - index i, "  + j + " - index j\n" );
                }

            }
        }
        return g;

    }

    // Usage example
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {



        //StrongConnectedComponents gui = new StrongConnectedComponents();
        //gui.setVisible(true);


        List<Integer>[] g = ReadFile();

        List<List<Integer>> components = scc(g);
        System.out.println(components);

    }
}