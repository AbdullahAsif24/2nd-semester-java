import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class RegionWise {
    public static void main(String[] args) {
        try {
            
            File file1 = new File("C:\\Users\\Lab User\\Desktop\\abd-java\\27-10-25\\data.txt");
            
            Scanner sc1 = new Scanner(file1);
            
            HashMap<String, Integer> regionArr = new HashMap<>();
            
            String line = sc1.nextLine();
            while (sc1.hasNext()) {
                line = sc1.nextLine();
                
                String[] arr = line.split("\t");
                
                if(!regionArr.containsKey(arr[1])){
                    regionArr.put(arr[1], 0);
                }
                
                int sumOfL = Integer.parseInt(arr[4]) * Integer.parseInt(arr[5]);
                

                regionArr.put(arr[1], (regionArr.get(arr[1]) + sumOfL));
                
            }
            

            for(String pr : regionArr.keySet()){
                System.out.println(pr + " : " + regionArr.get(pr));
            }

           
          
            
        } catch (Exception e) {

        }
    }
}
