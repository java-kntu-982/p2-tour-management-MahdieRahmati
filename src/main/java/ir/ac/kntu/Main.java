package ir.ac.kntu;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static  ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    public static ArrayList<Tour> finalTours = new ArrayList<>();
    public static  ArrayList<Tour> tours = new ArrayList<>();
    public static ArrayList<Region> regions = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner( System.in);
        while ( true ){
            System.out.println("1.leaders menu\n2.tours menu\n3.regions menu\n4.maps menu\n5.exit");
            int key = scanner.nextInt();
            switch ( key ){
                case 1 :
                    TourLeader tourLeader = new TourLeader();
                    tourLeader.menu();
                    break ;
                case 2 :
                    Tour tour = new Tour();
                    tour.menu();
                    break;
                case 3 :
                    Region region = new Region();
                    region.menu();
                    break;
                case 4 :
                    ShowMap showMap = new ShowMap();
                    showMap.menu();
                    break ;
            }
            if ( key == 5 ){
                break ;
            }
        }
    }
}
