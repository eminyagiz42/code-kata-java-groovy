package com.codekata.practice.pagination;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginationDemo {

    public static void main(String[] args) {

        String input = "3";
        List<String> yourlist = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        int partition = StringUtils.isNumeric(input) ? Integer.parseInt(input) : 1;

        List<List<String>> subLists = getSubLists(yourlist, partition);
        for (List<String> list : subLists) {
            System.out.println(list);
        }

        // Code Review : Use already exist library
        List<List<String>> subLists2 = ListUtils.partition(yourlist, partition);
        for (List<String> list2 : subLists2) {
            System.out.println(list2);
        }
    }

    private static List<List<String>> getSubLists(List<String> urllist, int partition) {
        List<List<String>> partitions = new ArrayList<>();
        for (int i = 0; i < urllist.size(); i += partition) {
            partitions.add(urllist.subList(i, Math.min(i + partition, urllist.size())));
        }
        return partitions;
    }
}

/*
Output:

[1, 2, 3]
[4, 5, 6]
[7, 8, 9]
[10]

 */