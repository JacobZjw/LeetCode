package M36;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JwZheng
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        //横向
        for(int i = 0;i < 9;i++){
            set.clear();
            for(int j = 0;j < 9;j++){
                if(board[i][j] != '.' && !set.add(board[i][j])){
                    return false;
                }
            }
        }
        set.clear();
        //竖向
        for(int i = 0;i < 9;i++){
            set.clear();
            for(int j = 0;j < 9;j++){
                if(board[j][i] != '.' && !set.add(board[j][i])){
                    return false;
                }
            }
        }
        //单元格
        for(int i = 0;i < 9;i++){
            if(!checkBox(board,(i/3)*3,(i % 3)*3)){
                return false;
            }
        }
        return true;
    }
    public boolean checkBox(char board[][],int pos1,int pos2){
        Set<Character> set = new HashSet<>();
        for(int j = pos1;j < 3 + pos1;j++){
            for(int k = pos2;k < 3 + pos2;k++){
                if(board[j][k]!= '.' && !set.add(board[j][k])){
                    return false;
                }
            }
        }
        return true;
    }
}
