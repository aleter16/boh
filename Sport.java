package sport;
import java.util.*;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> list = new ArrayList<>();
        System.out.println("Name of the file? ");
        String path = scanner.nextLine();
        try(Scanner sc = new Scanner(Paths.get("D:/Programmazione/New/sport/" + path))){
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");
                list.add(parts);                
            }
        } catch (Exception e ){
            System.out.println("Error!");
        }
        System.out.println("Team:");
        String d = scanner.nextLine();
        int count = 0;
        int losecount = 0;
        int wincount = 0;
        for(String[] parts : list){
            String name1 = parts[0];
            String name2 = parts[1];
            int num1 = Integer.valueOf(parts[2]);
            int num2 = Integer.valueOf(parts[3]);
            if(d.equals(name1)){
                count++;            
                if(num1 > num2){
                    wincount++;
                }
                if(num2 > num1){
                    losecount++;
                }
            }
            if(d.equals(name2)){
                count++;
                if(num2 > num1){
                    wincount++;
                }
                if(num1 > num2){
                    losecount++;
                }
            }
        }
        System.out.println("Games: " + count);
        System.out.println("Wins: " + wincount);
        System.out.println("Lose: " + losecount);
        scanner.close();
    }
}
