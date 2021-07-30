package com.ustc.leetcode.algorithmidea.backtracking;

/**
 * https://leetcode-cn.com/problems/word-search/submissions/
 * 79. 单词搜索
 */
public class L79 {
    /**
     * 深度优先遍历, 注意是4个方向， 这种题都会做了！！
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        return exist(board,m,n,word);
    }

    private boolean exist(char[][] board, int m, int n, String word) {
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, m,n,0,word,i,j, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, int depth, String word, int i, int j, boolean[][] visited) {
        // 超出矩形边界
        if (i >= m || j >= n || i < 0 || j < 0) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        // 在矩形内
        char currentChar = board[i][j];
        char compareChar = word.charAt(depth);
        if ( currentChar != compareChar ) {
            return false;
        }
        if (depth == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        // 右边
        boolean right = dfs(board, m,n, depth + 1, word,i, j + 1, visited);
        // 下边
        boolean down = dfs(board, m,n, depth + 1, word,i + 1, j, visited);
        // 左边
        boolean left = dfs(board, m,n, depth + 1, word,i, j - 1, visited);
        // 上边
        boolean top = dfs(board, m,n, depth + 1, word,i - 1, j, visited);

        visited[i][j] = false;
        return top || down || left || right;
    }
}
