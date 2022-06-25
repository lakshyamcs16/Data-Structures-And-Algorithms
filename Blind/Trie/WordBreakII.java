import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
    char ch;
    Node[] children;
    boolean isEnd;
    List<String> words;
    
    Node(char ch) {
        this.ch = ch;
        children = new Node[26];
        isEnd = false;
        words = new ArrayList<String>();
    }
    
    public Node getChild(char ch) {
        return children[ch - 'a'];
    }
}

class Trie {
    Node root;
    
    Trie() {
         root = new Node(' ');
    }
    
    public void addWord(String word) {
        Node node = this.root;
        for(char ch : word.toCharArray()) {
            Node current = node.getChild(ch);
            if(current == null) {
                node.children[ch - 'a'] = new Node(ch);
            }
            node = node.getChild(ch);
        }
        node.isEnd = true;
        node.words.add(word);
    }
    
    public Node getChild(Node node, char ch) {
        return node.getChild(ch);
    }
    
    public Node getRootNode() {
        return this.root;
    }
}

class Solution {
	Set<String> res;
    
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        
        Set<Character> starts = new HashSet<Character>();
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Trie root = new Trie();
        res = new HashSet<String>();
        
        for(String word : words) {
            root.addWord(word);
            starts.add(word.charAt(0));
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(starts.contains(board[i][j])) {
                    dfs(board, root, root.getRootNode(), visited, dirs, m, n, i, j);
                }
            }
        }
        
        return new ArrayList<String>(res);
    }
    
    private void dfs(char[][] board, Trie root, Node rootNode, boolean[][] visited, int[][] dirs, int m, int n, int x, int y) {
        Node node = root.getChild(rootNode, board[x][y]);
        visited[x][y] = true;
        
        if(node != null) {
            if (node.isEnd) {
                res.addAll(new ArrayList<String>(node.words));
            }
            
            for(int[] dir : dirs) {
                int nextX = x + dir[0]; int nextY = y + dir[1];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                        dfs(board, root, node, visited, dirs, m, n, nextX, nextY);
                }
            }
        }
        
        visited[x][y] = false;
        
    }
}

public class WordBreakII {

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = new char[][] { {'a','b','c','e'}, 
										{'x','x','c','d'}, 
										{'x','x','b','a'}};
		String[] words = new String[] {"abc", "abcd"};
		
		System.out.println(solution.findWords(board, words));

	}

}
