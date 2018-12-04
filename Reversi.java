import java.util.*;

class State {
    char[] board;

    public State(char[] arr) {
        this.board = Arrays.copyOf(arr, arr.length);
    }

    public int getScore() {
    	int dark = 0, light = 0;
    	for(int i = 0; i < this.board.length; i++){
			if(this.board[i] == '1'){
				++dark;
			}else if(this.board[i] == '2'){
				++light;
			}
		}
		if(dark > light){
			return 1;
		}else if(dark < light){
			return -1;
		}else{
			return 0;
		}
    }
    
    public boolean isTerminal() {
    	State[] states = this.getSuccessors('1');
    	State[] otherS = this.getSuccessors('2');
    	if(states.length == 0 && otherS.length == 0){
    		return true;
    	}else{
    		return false;
    	}
    }

    public State[] getSuccessors(char player) {
    	List<State> states = new ArrayList<State>();
    	char twoD[][] = new char[4][4];
    	int k = 0;
    	
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			twoD[i][j] = this.board[k];
    			k++;
    		}
    	}
    	int r = 0;
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	ArrayList<Integer> arr1 = new ArrayList<Integer>();
    	ArrayList<Integer> arr2 = new ArrayList<Integer>();
    	ArrayList<Integer> arr3 = new ArrayList<Integer>();
    	ArrayList<Integer> arr4 = new ArrayList<Integer>();
    	ArrayList<Integer> arr5 = new ArrayList<Integer>();
    	ArrayList<Integer> arr6 = new ArrayList<Integer>();
    	ArrayList<Integer> arr7 = new ArrayList<Integer>();

    	//Only check positions that are valued 0
    	
    	for(int i = 0; i < 4; i++){
    		for(int j = 0; j < 4; j++){
    			if(twoD[i][j] == '0'){
    				
    				//Check Diagonal Up Left
    				r = 1;
    				while(j - r >= 0 && i - r >= 0){
    					if(twoD[i-r][j-r] == player){
    						if(arr.size() > 0){
    							break;
    						}else{
    							arr.clear();
    							break;
    						}
    					}else if(twoD[i-r][j-r] == '0'){
    						arr.clear();
    						break;
    					}else{
    						if(j-r-1 >= 0 && i-r-1 >= 0){
    							arr.add(((i - r)*10) + j-r);
    							r++;
    						}else{
    							arr.clear();
    							break;
    						}
    					}
    				}
				
    				//Check up
    				r = 1;
    				while(i - r >= 0){
    					if(twoD[i-r][j] == player){
    						if(arr1.size() > 0){
    							break;
    						}else{
    							arr1.clear();
    							break;
    						}
    					}else if(twoD[i-r][j] == '0'){
    						arr1.clear();
    						break;
    					}else{
    						if(i-r-1 >= 0){
    							arr1.add((i-r)*10 + j);
    							r++;
    						}else{
    							arr1.clear();
    							break;
    						}
    					}
    				}
    				
    				//Check Diagonal Up Right
    				r = 1;
    				while(j + r < 4 && i - r >= 0){
    					if(twoD[i-r][j+r] == player){
    						if(arr2.size() > 0){
    							break;
    						}else{
    							arr2.clear();
    							break;
    						}
    					}else if(twoD[i-r][j+r] == '0'){
    						arr2.clear();
    						break;
    					}else{
    						if(j+r+1 < 4 && i-r-1 >= 0){
    							arr2.add(((i - r)*10) + j+r);
    							r++;
    						}else{
    							arr2.clear();
    							break;
    						}
    					}
    				}

    				
    				//Check right
    				r = 1;
    				while(j + r < 4){
    					if(twoD[i][j+r] == player){
    						if(arr3.size() > 0){
    							break;
    						}else{
    							arr3.clear();
    							break;
    						}
    					}else if(twoD[i][j+r] == '0'){
    						arr3.clear();
    						break;
    					}else{
    						if(j+r+1 < 4){
    							arr3.add(i*10 + (j+r));
    							r++;
    						}else{
    							arr3.clear();
    							break;
    						}
    					}
    				}

    				
    				//Check Diagonal Down Right
    				r = 1;
    				while(j + r < 4 && i + r < 4){
    					if(twoD[i+r][j+r] == player){
    						if(arr4.size() > 0){
    							break;
    						}else{
    							arr4.clear();
    							break;
    						}
    					}else if(twoD[i+r][j+r] == '0'){
    						arr4.clear();
    						break;
    					}else{
    						if(j+r+1 < 4 && i+r+1 < 4){
    							arr4.add(((i + r)*10) + j+r);
    							r++;
    						}else{
    							arr4.clear();
    							break;
    						}
    					}
    				}

    				//Check down
    				r = 1;
    				while(i + r < 4){
    					if(twoD[i+r][j] == player){
    						if(arr5.size() > 0){
    							break;
    						}else{
    							arr5.clear();
    							break;
    						}
    					}else if(twoD[i+r][j] == '0'){
    						arr5.clear();
    						break;
    					}else{
    						if(i+r+1 < 4){
    							arr5.add((i+r)*10 + j);
    							r++;
    						}else{
    							arr5.clear();
    							break;
    						}
    					}
    				}
    				
    				//Check Diagonal Down Left
    				r = 1;
    				while(j - r >= 0 && i + r < 4){
    					if(twoD[i+r][j-r] == player){
    						if(arr6.size() > 0){
    							break;
    						}else{
    							arr6.clear();
    							break;
    						}
    					}else if(twoD[i+r][j-r] == '0'){
    						arr6.clear();
    						break;
    					}else{
    						if(j-r-1 >= 0 && i+r+1 < 4){
    							arr6.add(((i + r)*10) + j-r);
    							r++;
    						}else{
    							arr6.clear();
    							break;
    						}
    					}
    				}

    				
    				//Check left
    				r = 1;
    				while(j - r >= 0){
    					if(twoD[i][j-r] == player){
    						if(arr7.size() > 0){
    							break;
    						}else{
    							arr7.clear();
    							break;
    						}
    					}else if(twoD[i][j-r] == '0'){
    						arr7.clear();
    						break;
    					}else{
    						if(j-r-1 >= 0){
    							arr7.add((i*10) + (j-r));
    							r++;
    						}else{
    							arr7.clear();
    							break;
    						}
    					}
    				}
    				
    				if(arr.size() > 0 || arr1.size() > 0|| arr2.size() > 0 || arr3.size() > 0 || arr4.size() > 0 || arr5.size() > 0 || arr6.size() > 0 || arr7.size() > 0){

    					ArrayList<Integer> finalArr = new ArrayList<Integer>();
    					finalArr.add((i*10) + j);
    					for(int m = 0; m < arr.size(); m++){
    						finalArr.add(arr.get(m));
    					}
    					for(int m = 0; m < arr1.size(); m++){
    						finalArr.add(arr1.get(m));
    					}
    					for(int m = 0; m < arr2.size(); m++){
    						finalArr.add(arr2.get(m));
    					}
    					for(int m = 0; m < arr3.size(); m++){
    						finalArr.add(arr3.get(m));
    					}
    					for(int m = 0; m < arr4.size(); m++){
    						finalArr.add(arr4.get(m));
    					}
    					for(int m = 0; m < arr5.size(); m++){
    						finalArr.add(arr5.get(m));
    					}
    					for(int m = 0; m < arr6.size(); m++){
    						finalArr.add(arr6.get(m));
    					}
    					for(int m = 0; m < arr7.size(); m++){
    						finalArr.add(arr7.get(m));
    					}

    					char ar[] = new char[16];
    					k = 0;
    					char[][] arraynew = new char[4][4];
    					for(int a = 0; a < 4; a++){
    						for(int w = 0; w < 4; w++){
    							arraynew[a][w] = twoD[a][w];
    						}	
    					}
    					int v = finalArr.size()-1;
    					while(!finalArr.isEmpty()){
    						arraynew[finalArr.get(v)/10][finalArr.get(v)%10] = player;
    						finalArr.remove(v);
    						--v;
    					}
    					for(int e = 0; e < 4; e++){
    						for(int d = 0; d < 4; d++){
    							ar[k] = arraynew[e][d];
    							k++;
    						}
    					}
    					finalArr.clear();
    					State stat = new State(ar);
    					states.add(stat);
    					r = 0;
    				}
    				arr.clear();
    				arr1.clear();
    				arr2.clear();
    				arr3.clear();
    				arr4.clear();
    				arr5.clear();
    				arr6.clear();
    				arr7.clear();
    			}
    		}
    	}
    	State[] successors = new State[states.size()];
    	for(int i = 0; i < states.size(); i++){
    		successors[i] = states.get(i);
    	}
        return successors;
    }
    
    
    public void printState(int option, char player) {

        // TO DO: print a State based on option (flag)
    	if(option == 1){
    		if(!this.isTerminal()){
    			State[] successors = getSuccessors(player);
    			if(successors.length == 0){
    				System.out.println(this.getBoard());
    			}
    			for(int i = 0; i < successors.length; i++){
    				System.out.println(successors[i].getBoard());
    			}
    		}else{
    			return;
    		}
    	}else if(option == 2){
    		boolean full = this.isTerminal();
    		if(!full){
    			System.out.println("non-terminal");
    		}else{
    			int dark = 0, light = 0;
    			for(int i = 0; i < this.board.length; i++){
    				if(this.board[i] == '1'){
    					++dark;
    				}else{
    					++light;
    				}
    			}
    			if(dark > light){
    				System.out.println("1");
    			}else if(dark < light){
    				System.out.println("-1");
    			}else{
    				System.out.println("0");
    			}
    		}
    	}else if(option == 3){
    		int ans = Minimax.run(this, player);
    		System.out.println(ans);
    		System.out.println(Minimax.count);
    	}else if(option == 4){
    		int ans = Minimax.run(this, player);
    		State[] succ = this.getSuccessors(player);
    		int succScore = 0;
    		char otherP;
    		if(player == '2'){
    			otherP = '1';
    		}else{
    			otherP = '2';
    		}
    		if(succ.length == 0 && !this.isTerminal()){
    			System.out.println(this.getBoard());
    		}else{
    			for(int i = 0; i < succ.length; i++){
    				succScore = Minimax.run(succ[i], otherP);
    				if(succScore == ans){
    					System.out.println(succ[i].getBoard());
    					break;
    				}
    			}
    		}
    	}else if(option == 5){
    		int ans = Minimax.run_with_pruning(this, player);
    		System.out.println(ans);
    		System.out.println(Minimax.count);
    	}else{
    		int ans = Minimax.run_with_pruning(this, player);
    		State[] succ = this.getSuccessors(player);
    		int succScore = 0;
    		char otherP;
    		if(player == '2'){
    			otherP = '1';
    		}else{
    			otherP = '2';
    		}
    		if(succ.length == 0 && !this.isTerminal()){
    			System.out.println(this.getBoard());
    		}else{
    			for(int i = 0; i < succ.length; i++){
    				succScore = Minimax.run_with_pruning(succ[i], otherP);
    				if(succScore == ans){
    					System.out.println(succ[i].getBoard());
    					break;
    				}
    			}
    		}
    	}
    	
    }

    public String getBoard() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            builder.append(this.board[i]);
        }
        return builder.toString().trim();
    }

    public boolean equals(State src) {
        for (int i = 0; i < 16; i++) {
            if (this.board[i] != src.board[i])
                return false;
        }
        return true;
    }
}

class Minimax {
	public static int count = 0; 
	private static int alpha = Integer.MIN_VALUE;
	private static int beta = Integer.MAX_VALUE;
	private static char max = '1';
	private static char min = '2';
	
	private static int max_value(State curr_state) {
		++count;
		if(curr_state.isTerminal()){
			return curr_state.getScore();
		}else{
			alpha = Integer.MIN_VALUE;
			State[] succ = curr_state.getSuccessors(max);
			if(succ.length == 0){
				return min_value(curr_state);
			}else{
				for(int i = 0; i < succ.length; i++){					
					alpha = Math.max(alpha, min_value(succ[i]));
				}
			}
		}
		return alpha;
	}
	
	private static int min_value(State curr_state) {
		++count;
		if(curr_state.isTerminal()){
			return curr_state.getScore();
		}else{
			beta = Integer.MAX_VALUE;
			State[] succ = curr_state.getSuccessors(min);
			if(succ.length == 0){
				return max_value(curr_state);
			}else{
				for(int i = 0; i < succ.length; i++){
					beta = Math.min(beta, max_value(succ[i]));
				}
			}
		}
		return beta;
	}
	
	
	private static int max_value_with_pruning(State curr_state, int alpha, int beta) {
		++count;
		if(curr_state.isTerminal()){
			return curr_state.getScore();
		}else{
			State[] succ = curr_state.getSuccessors(max);
			if(succ.length == 0){
				return min_value_with_pruning(curr_state, alpha, beta);
			}else{
				for(int i = 0; i < succ.length; i++){
					alpha = Math.max(alpha, min_value_with_pruning(succ[i], alpha, beta));
					if(alpha >= beta){
						return beta;
					}
				}
			}
			return alpha;
		}
		
	}
	
	private static int min_value_with_pruning(State curr_state, int alpha, int beta) {
		++count;
		if(curr_state.isTerminal()){
			return curr_state.getScore();
		}else{
			State[] succ = curr_state.getSuccessors(min);
			if(succ.length == 0){
				return max_value_with_pruning(curr_state, alpha, beta);
			}else{
				for(int i = 0; i < succ.length; i++){
					beta = Math.min(beta, max_value_with_pruning(succ[i], alpha, beta));
					if(alpha >= beta){
						return alpha;
					}
				}
			}
			return beta;
		}
		
	}
	
	public static int run(State curr_state, char player) {
		int result = 0;
		if(player == '1'){
			result = max_value(curr_state);
		}else{
			result = min_value(curr_state);
		}
		return result;
	}
	
	public static int run_with_pruning(State curr_state, char player) {
		int result = 0;
		int alpha1 = Integer.MIN_VALUE;
		int beta1 = Integer.MAX_VALUE;
		if(player == '1'){
			result = max_value_with_pruning(curr_state, alpha1, beta1);
		}else{
			result = min_value_with_pruning(curr_state, alpha1, beta1);
		}
		return result;
	}
}

public class Reversi {
    public static void main(String args[]) {
        if (args.length != 3) {
            System.out.println("Invalid Number of Input Arguments");
            return;
        }
        int flag = Integer.valueOf(args[0]);
        char[] board = new char[16];
        for (int i = 0; i < 16; i++) {
            board[i] = args[2].charAt(i);
        }
        int option = flag / 100;
        char player = args[1].charAt(0);
        if ((player != '1' && player != '2') || args[1].length() != 1) {
            System.out.println("Invalid Player Input");
            return;
        }
        State init = new State(board);
        init.printState(option, player);
    }
}
