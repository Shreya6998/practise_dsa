package dsaProblems;

public class MatrixDiagonalTraversal {

	public static void main(String[] args) {
//		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] mat = {{1,2},{3,4}};
		int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//		int[][] mat = {{9,8,7},{6,5,4},{3,2,1}};
        int[] ans = matrixDiagonally(mat);
        for(int it = 0; it < ans.length; it++){
            System.out.print(ans[it] + " ");
        }
        System.out.println();
	}
	
	public static int[] matrixDiagonally(int[][] mat) {
        int size = mat.length;
        int x=0,y=0,z=0;
        boolean isUp = true;
        int[] result = new int[size*size];
        while(z < (size*size)) {
        	result[z]=mat[x][y];
        	if(isUp) { 
        		if(x>0 && y<size-1) {
        			x--;
        			y++;
        		}else {
        			isUp = false;
        			if(x==0 && y+1<size) {
        				y++;
        			}else if(y==size-1) {
        				x++;
        			}
        		}
        		
        	}else {
        		if(y>0 && x<size-1) {
            		y--;
            		x++;
        		}else {
        			isUp = true;
        			if(y == 0 && x+1<size) {
        				x++;
        			}else if(x==size-1) {
        				y++;
        			}
        		}
        	}
        	z++;
        }
//        //Naive Approach
//        while(z<(size*size)){
//            //Print element
//            result[z] = mat[x][y];
//            //check if going upwards
//            if(isUp){
//            	
//                //check if y is valid
//                if((y+1)>=0 && (y+1)<size){
//                    y++;
//                  
//                    //check if x is valid
//                    if((x-1)>=0 && (x-1)<size){
//                        x--;
//                    }else {
//                    	isUp = false;
//                    }
//                //if both not valid
//                }else {
//                	isUp = false;
//                	x++;
//                }
//            }
//            //if going downwards
//            else{
//                //check if x is valid
//                if((x+1)>=0 && (x+1)<size){
//                    x++;
//                    
//                  //check if y is valid
//                    if((y-1)>=0 && (y-1)<size){
//                        y--;
//                    }else {
//                    	isUp = true;
//                    }
//                // if both not valid
//                }else {
//                	isUp = true;
//                	y++;
//                }
//            }
//            z++;
//        }
        return result;
    }

}
