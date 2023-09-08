import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main { 
    public static boolean CheckValid(String daString){       
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            sf.setLenient(false);
            sf.parse(daString);
            return true;
        } catch (Exception e) {
            return false;
        } 
    }
    public static int DateHandle(int d1, int m1, int y1, int d2, int m2, int y2){
        if(y1 > y2){
            return 1;
        }
        else if(y1 == y2 && m1 != m2){
            if(m1 > m2){
                return 1;
            }
            else if(m1 == m2){
                if(d1 > d2){
                    return 1;
                }
            }
        }
        else if(y1 == y2 && m1 == m2 && d1 == d2){
            return 0;
        }
        return -1;
    }
    public static void main(String[] args) {
        String date1, date2;
        int d1,m1,y1,d2,m2,y2;
        Scanner sc = new Scanner(System.in);
        do {
             System.out.print("Please enter the first date: ");
             date1 = sc.nextLine();
        } while (!CheckValid(date1));
        do { 
            System.out.print("Please enter the second date: ");
            date2 = sc.nextLine();
        } while (!CheckValid(date2));  
        String[] a = date1.split("/");
        d1 = Integer.parseInt(a[0]);
        m1 = Integer.parseInt(a[1]);
        y1 = Integer.parseInt(a[2]);
        String[] b = date2.split("/");
        d2 = Integer.parseInt(b[0]);
        m2 = Integer.parseInt(b[1]);
        y2 = Integer.parseInt(b[2]); 
        if(DateHandle(d1, m1, y1, d2, m2, y2) > 0) 
        {
            System.out.println("Date1 is after Date2");
        }
        else if(DateHandle(d1, m1, y1, d2, m2, y2) < 0) 
        {
            System.out.println("Date1 is before Date2");
        }
        else {
            System.out.println("Date1 is equals Date2");
        }
    }
}
