public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    Deque<int[]> snake;
    int width, height;
    LinkedList<int[]> foods;
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<int[]>();
        snake.add(new int[]{0, 0});
        this.width = width;
        this.height = height;
        this.foods = new LinkedList<int[]>();
        for(int[] f: food) {
            foods.add(f);
        }
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] head = Arrays.copyOf(snake.peek(), 2);
        switch(direction) {
            case "U":
                head[0]--;
                break;
            case "L":
                head[1]--;
                break;
            case "R":
                head[1]++;
                break;
            case "D":
                head[0]++;
            default:
        }
        if( head[0] < 0 || head[0] >= height || head[1] < 0 || head[1] >= width )
            return -1;
        if( Arrays.equals(foods.peek(), head) ) {
            //System.out.printf("Got food at %s\n", Arrays.toString(head));
            int[] temp = foods.poll();
        }
        else {
            int[] temp = snake.pollLast();
            //System.out.println("pop " + Arrays.toString(temp));
        }
        if( biteSelf(head) )
            return -1;
        snake.addFirst(head);
        return snake.size()-1;
    }
    public boolean biteSelf(int[] head) {
        for(int[] i: snake) {
            if( Arrays.equals(i, head) )
                return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */