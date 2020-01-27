import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindThreeGifts {


    public static void main(String args[]) throws FileNotFoundException, IOException {


        Scanner scanner = new Scanner(System.in);
        String filePath = "";
        int cardBalance = 0;
        String[] pairs = new String[3];

        System.out.println("Enter the path for file with sorted prices: ");
        filePath = scanner.next();
        System.out.println("Enter the balance of your Gift Card: ");
        cardBalance = scanner.nextInt();

        if(filePath.equals("")){
            System.out.print("Invalid file path");
        } else {
            pairs = findItemPair(filePath,cardBalance);
        }

        if(pairs.length<1){
            System.out.print("\nNot Possible");
        } else {
            System.out.print("Items you can buy: "+"\n");
            System.out.print(pairs[0]+"\n"+pairs[1]+"\n"+pairs[2]);
        }

    }

    private static String[] findItemPair(String filePath, int cardBalance) throws FileNotFoundException, IOException{


        File file = new File("./resources/"+filePath);

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        List<GiftItems> giftsList =  new ArrayList<>();

        while ((line = br.readLine()) != null){
            line = line.replaceAll(" ","");
            String item = line.split(",")[0];
            String itemPrice = line.split(",")[1];
            giftsList.add(new GiftItems(item,Integer.parseInt(itemPrice)));
        }

        int[] pricesArray = getPrices(giftsList);
        br.close();
        FindPair fp = new FindPair();
        int[] ans = fp.findThreeGifts(pricesArray,cardBalance);
        String result[] = new String[3];

        if(ans[0]!=-1 && ans[1] != -1 && ans[2] !=-1){
            for(int i=0;i<ans.length;i++){
                GiftItems canBuy = giftsList.get(ans[i]);
                result[i] = canBuy.item+", "+canBuy.price;
            }
            return result;
        }

        return new String[]{};

    }

    private static int[] getPrices(List<GiftItems> giftsList) {

        int prices[] = new int[giftsList.size()];
        int i=0;
        for(GiftItems item: giftsList){
            prices[i] = item.price;
            i++;
        }
        return prices;
    }

}
