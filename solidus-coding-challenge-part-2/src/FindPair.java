import java.util.Arrays;

public class FindPair {

    public FindPair(){

    }

    public int[] findPair(int[] items, int price){

        int i=0;
        int j=items.length-1;

        int min = Integer.MIN_VALUE;
        int[] res = new int[]{-1,-1};

        while(i<j){

            int sum = items[i]+items[j];
            if(sum ==price){
                return new int[]{i,j};
            } else {
                if(sum < price){
                    if(sum>min){
                        min = sum;
                        res[0] = i;
                        res[1] = j;
                    }

                    i++;

                } else if(sum>price){
                    j--;
                }
            }
        }

        return res;
    }

    public int[] findThreeGifts(int[] items, int price){

        int min = Integer.MIN_VALUE;
        int res[] = new int[]{-1,-1,-1};

        for(int i=0;i<items.length;i++){

            int j = i+1;
            int k = items.length-1;

            while(j<k){
                int sum = items[i]+items[j]+items[k];

                if(sum == price){
                    return new int[]{i,j,k};
                } else {
                    if(sum < price){
                        if(sum>min){
                            min = sum;
                            res[0] = i;
                            res[1] = j;
                            res[2] = k;
                        }
                        j++;
                    } else if (sum>price){
                        k--;
                    }

                }
            }
        }

        return res;
    }


}
