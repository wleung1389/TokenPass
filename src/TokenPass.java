public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount) {
        this.board = new int[playerCount];
        for (int i = 0; i < board.length; i++) {
            board[i] = getRandomInteger(1, 10);
        }
        currentPlayer = getRandomInteger(0, board.length - 1);
    }

    public void distributePlayerTokens() {
        int totalTokens = board[currentPlayer];
        int pos = currentPlayer;
        for (int i = totalTokens; i > 0; i--) {
            if (pos >= board.length - 1) {
                pos = 0;
            } else {
                pos++;
            }
            board[currentPlayer] -= 1;
            totalTokens--;
            board[pos] += 1;
        }
    }

    public int getRandomInteger(int min, int max) {
        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("Player " + i + " : " + board[i] + "  ");
        }
        System.out.println("Current Player : " + currentPlayer);
    }

    public void nextPlayer()
    {
        if(currentPlayer >= board.length - 1)
        {
            currentPlayer = 0;

        }
        else
        {
            currentPlayer++;
        }
    }
    public int gameOver()
    {
        int game = -1;
        while(game == -1)
        {
            for(int i = 0; i < board.length; i++)
            {
                if(board[i] == 0)
                {
                    return i;
                }
                else
                {
                    if(i == board.length - 1)
                    {
                        game = -2;
                    }
                }
            }
        }
        return game;
    }
}
