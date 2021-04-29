package M208;

/**
 * @author JwZheng
 * @date 2021/4/14 12:28
 */
class Trie {

    private final TreeNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TreeNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TreeNode ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.next[ch - 'a'] == null) {
                ptr.next[ch - 'a'] = new TreeNode(ch);
            }
            ptr = ptr.next[ch - 'a'];
        }
        ptr.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TreeNode ptr = root;
        for (char ch : word.toCharArray()) {
            if (ptr.next[ch - 'a'] == null) {
                return false;
            }
            ptr = ptr.next[ch - 'a'];
        }
        return ptr.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TreeNode ptr = root;
        for (char ch : prefix.toCharArray()) {
            if (ptr.next[ch - 'a'] == null) {
                return false;
            }
            ptr = ptr.next[ch - 'a'];
        }
        return true;
    }

    static class TreeNode {
        char word;
        boolean isWord;
        TreeNode[] next;

        public TreeNode() {
            next = new TreeNode[26];
        }

        public TreeNode(char word) {
            this(word, false);
        }

        public TreeNode(char word, boolean isWord) {
            this.word = word;
            this.isWord = isWord;
            this.next = new TreeNode[26];
        }

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
