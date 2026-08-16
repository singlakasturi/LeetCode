/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    public boolean allSame(int[][] grid, int i, int j, int n) {
        for(int x = i; x < i + n; x++) {
            for(int y = j; y < j + n; y++) {
                if(grid[x][y] != grid[i][j])
                    return false;
            }
        }

        return true;
    }

    public Node solve(int[][] grid, int i, int j, int n) {
        if(allSame(grid, i, j, n))
            return new Node(grid[i][j] == 1 ? true : false, true);

        Node node = new Node(true, false);
        node.topLeft = solve(grid, i, j, n/2);
        node.topRight = solve(grid, i, j + n/2, n/2);
        node.bottomLeft = solve(grid, i + n/2, j, n/2);
        node.bottomRight = solve(grid, i + n/2, j + n/2, n/2);

        return node;
    }


    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }
}