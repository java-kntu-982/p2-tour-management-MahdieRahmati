package ir.ac.kntu;

import ir.ac.kntu.maputil.MapUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowMap {

    Tour findByTripCode(String tripCode , ArrayList< Tour> finalTours ){
        for (Tour tour : finalTours){
            if(tour.getTripCode().equals(tripCode)){
                return tour;
            }
        }
        return null;
    }

    void menu (){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1.show origin city\n2.show destination city\n3.show origin and destination\n4.place to visit in a certain day\n5.all to-visit places\n6.a random city or country\n7.2 cities\n8.back ");
            int input = scanner.nextInt();
            switch(input){
                case 1:
                    System.out.println("enter the trip code !");
                    String tripCode = scanner.next();
                    Tour tour = findByTripCode(tripCode , Main.finalTours);
                    if ( tour != null) {
                        MapUtil.showMap(tour.getOriginCity());
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 2 :
                    System.out.println("enter the trip code !");
                    String tripCode1= scanner.next();
                    Tour tour1 = findByTripCode(tripCode1 , Main.finalTours);
                    if ( tour1 != null) {
                        MapUtil.showMap(tour1.getDestinationCity());
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 3 :
                    System.out.println("enter the trip code !");
                    String tripCode2= scanner.next();
                    Tour tour2 = findByTripCode(tripCode2 , Main.finalTours);
                    if ( tour2 != null) {
                        MapUtil.showMap(tour2.getOriginCity(), tour2.getDestinationCity());
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 4 :
                    System.out.println("enter the trip code !");
                    String tripCode3= scanner.next();
                    Tour tour3 = findByTripCode(tripCode3 , Main.finalTours);
                    if ( tour3 != null) {
                        if ( tour3.isForeign()) {
                            System.out.println("enter the day !");
                            int day = scanner.nextInt();
                            MapUtil.showMap(tour3.getVisitingPlaces().get(day));
                        }else{
                            System.out.println(" not foreign !");
                        }
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 5:
                    System.out.println("enter the trip code !");
                    String tripCode4= scanner.next();
                    Tour tour4 = findByTripCode(tripCode4 , Main.finalTours);
                    if ( tour4 != null ) {
                        if ( tour4.isForeign()) {
                            for (int i = 1; i <= tour4.getVisitingPlaces().size(); i++) {
                                MapUtil.showMap(tour4.getVisitingPlaces().get(i));
                            }
                        }else{
                            System.out.println("not foreign !");
                        }
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 6:
                    System.out.println("enter a city or a country ");
                    String place = scanner.next();
                    MapUtil.showMap(place);
                    break;
                case 7 :
                    System.out.println("enter 2 cities ");
                    String first = scanner.next();
                    String second = scanner.next();
                    MapUtil.showMap(first , second );
                    break ;
            }
            if ( input == 8 ){
                break ;
            }
        }
    }
}
