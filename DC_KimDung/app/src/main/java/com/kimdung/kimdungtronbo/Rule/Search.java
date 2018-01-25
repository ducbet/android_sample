/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kimdung.kimdungtronbo.Rule;

import java.util.ArrayList;

/**
 *
 * @author trieu_000
 */
public class Search {

    public static void main(String[] args) {
        String content = "con mèo hôm 432q  nay đi dạo. Lọ đường . Rồi đi chơi. Bác đang dạy các con học bài";
        String keywords = "con đường đi học";
        search(content, keywords);

    }

    private static void search(String content, String keywords) {
        ArrayList<String> listKeyword = splitKeywords(keywords);
        System.out.println("");
        ArrayList<String> listContentWords = splitContent(content);
        System.out.println("\nRESULT:");
        for (int k = 0; k < listKeyword.size(); k++) {
            for (int c = 0; c < listContentWords.size(); c++) {
                if (listKeyword.get(k).equals(listContentWords.get(c))) {
                    int match = c;
                    if (match - 1 >= 0) {
                        System.out.print("'");
                        System.out.print(listContentWords.get(match - 1));
                        System.out.print("' '" + listContentWords.get(match) + "'");
                    } else if (match + 1 < listContentWords.size()) {
                        System.out.print("'" + listContentWords.get(match) + "' '");
                        System.out.print(listContentWords.get(match + 1));
                        System.out.print("'");
                    }
                    System.out.println("");
                }
            }
        }

    }

    private static ArrayList<String> splitKeywords(String keywords) {
        String[] str;
        ArrayList<String> listKeyword = new ArrayList<>();
        str = keywords.split(" ");
        for (String s : str) {
            if (!s.equals("")) {
                System.out.print("'" + s + "' ");
                listKeyword.add(s);
            }
        }
        return listKeyword;
    }

    private static ArrayList<String> splitContent(String content) {
        String[] str;
        ArrayList<String> words = new ArrayList<>();
        str = content.split(" ");
        for (String s : str) {
            if (!s.equals("")) {
                System.out.print("'" + s + "' ");
                words.add(s);
            }
        }
        return words;
    }
}
