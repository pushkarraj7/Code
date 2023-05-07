class Solution {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgCol){
            return;
        }
        image[sr][sc]=color;
        vis[sr][sc]=true;
        helper(image,sr,sc-1,color,vis,orgCol); //left
        helper(image,sr,sc+1,color,vis,orgCol); //right
        helper(image,sr-1,sc,color,vis,orgCol); //up
        helper(image,sr+1,sc,color,vis,orgCol); //down
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[0].length == 0 || sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }
        boolean[][] vis=new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }
}