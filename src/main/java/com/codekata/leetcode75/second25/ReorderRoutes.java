package com.codekata.leetcode75.second25;


import java.util.ArrayList;
import java.util.List;

class ReorderRoutes {

    public static void main(String[] args) {

		// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

		int n = 6;
		int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		System.out.println(minReorder(n, connections));
	}

	public static int minReorder(int n, int[][] connections) {
		List<Integer>[] graph = new List[n];

		for (int i = 0; i < n; ++i) {
			graph[i] = new ArrayList<>();
		}
		for (int[] conn : connections) {
			int conn0 = conn[0];
			int conn1 = conn[1];
			graph[conn0].add(conn1);
			graph[conn1].add(-conn0);
		}
		return depthFirstSearch(graph, 0, -1);
	}

	private static int depthFirstSearch(List<Integer>[] graph, int u, int parent) {
		int change = 0;
		for (final int v : graph[u]) {
			if (Math.abs(v) == parent) {
				continue;
			}
			if (v > 0) {
				++change;
			}
			change += depthFirstSearch(graph, Math.abs(v), u);
		}
		return change;
	}
}