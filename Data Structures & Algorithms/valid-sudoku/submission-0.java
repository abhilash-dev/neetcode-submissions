class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Set<Character> seen = null;
        char empty = '.';

        //check rows
        for(int i = 0; i < m; i++){
            seen = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(seen.contains(board[i][j])){
                    return false;
                }else if(board[i][j] != empty){
                    seen.add(board[i][j]);
                }
            }
        }

        // check cols
        for(int i = 0; i < m; i++){
            seen = new HashSet<>();
            for(int j = 0; j < n; j++){
                if(seen.contains(board[j][i])){
                    return false;
                }else if(board[j][i] != empty){
                    seen.add(board[j][i]);
                }
            }
        }

        // check 3*3 grids
        for(int i = 0; i < m; i+=3){
            for (int j = 0; j < n; j+=3){
                seen = new HashSet<>();
                for(int k = i; k<i+3; k++){
                    for(int l = j; l<j+3; l++){
                        if(seen.contains(board[k][l])){
                            return false;
                        }else if(board[k][l] != empty){
                            seen.add(board[k][l]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
