package ir.ac.kntu;

import java.util.*;

public class Tour {
    private int numberOfDays;
    private Region region ;
    private Long price ;
    private int minimumPeople ;
    private int maximumPeople ;
    private String originCity ;
    private String destinationCity ;
    private TripWay tripWay;
    private TourLeader leader;
    private Date startDay;
    private String tripCode ;
    private Map<Integer, String > visitingPlaces = new HashMap<>();
    private boolean foreign ;

    public boolean isForeign() {
        return foreign;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public Tour() {
    }

    public TourLeader getLeader() {
        return leader;
    }

    public void setLeader(TourLeader leader) {
        this.leader = leader;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public String getTripCode() {
        return tripCode;
    }

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    public Tour(int numberOfDays, Region region, Long price, int minimumPeople, int maximumPeople, String originCity, String destinationCity, TripWay tripWay, Map<Integer, String> visitingPlaces , boolean foreign ) {
        this.numberOfDays = numberOfDays;
        this.region = region;
        this.price = price;
        this.minimumPeople = minimumPeople;
        this.maximumPeople = maximumPeople;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.tripWay = tripWay;
        this.visitingPlaces = visitingPlaces;
        this.foreign = foreign ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tour tour = (Tour) o;
        return numberOfDays == tour.numberOfDays &&
                minimumPeople == tour.minimumPeople &&
                maximumPeople == tour.maximumPeople &&
                foreign == tour.foreign &&
                region.equals(tour.region) &&
                price.equals(tour.price) &&
                originCity.equals(tour.originCity) &&
                destinationCity.equals(tour.destinationCity) &&
                tripWay == tour.tripWay &&
                Objects.equals(visitingPlaces, tour.visitingPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfDays, region, price, minimumPeople, maximumPeople, originCity, destinationCity, tripWay, visitingPlaces, foreign);
    }

    void addTour(Tour tour , ArrayList<Tour> tourList){
        tourList.add(tour);
    }

    void printArrayList (ArrayList<Tour> tours){
        int i = 1 ;
        for ( Tour tour : tours){
            System.out.println(i +":"+ tour.toString1());
            i++ ;
        }
    }

    public Map<Integer, String> getVisitingPlaces() {
        return visitingPlaces;
    }

    void printArrayListFinal (ArrayList<Tour> tours){
        int i = 1 ;
        for ( Tour tour : tours){
            System.out.println(i +":"+ tour.toString2());
            i++ ;
        }
    }


    boolean editTripCode ( String newTripCode , String tripCode , ArrayList<Tour> tours ){
        Tour tour = searchTripCode(tripCode , Main.finalTours);
        if ( tour!= null){
            tour.setTripCode(newTripCode);
            return true;
        }else{
            return false ;
        }
    }

    Tour tourWithNoLeader (  Tour tour , Date date ,  String tripCode  ){
        Tour finalTour = new Tour(tour.numberOfDays , tour.region , tour.price , tour.minimumPeople , tour.maximumPeople , tour.originCity, tour.destinationCity , tour.tripWay , tour.visitingPlaces , tour.foreign );
        finalTour.setStartDay(date);
        finalTour.setTripCode(tripCode);
        return  finalTour;
    }

    static ArrayList<Tour> searchByPlace(String place, ArrayList<Tour> tours) {
        ArrayList<Tour> suitable = new ArrayList<>();
        for (int i = 0; i < tours.size(); i++) {
            if (tours.get(i).visitingPlaces!= null) {
                for (int j = 1; j <= tours.get(i).visitingPlaces.size(); j++) {
                    if (tours.get(i).visitingPlaces.get(j).equals(place)) {
                        suitable.add(tours.get(i));
                    }
                }

            }
        }
        return suitable;
    }


    static ArrayList<Tour> searchByLeader(String firstName ,String lastName, ArrayList<Tour> tours) {
        ArrayList<Tour> suitable = new ArrayList<>();
        for ( Tour tour : tours ){
            if ( tour.getLeader().getFirstName().equals(firstName) && tour.getLeader().getLastName().equals(lastName)){
                suitable.add(tour);
            }
        }
        return suitable;
    }


    ArrayList<Tour> searchNumberOfDays(int number , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.numberOfDays == number){
                suitable.add(tour);

            }
        }
        return suitable ;
    }

    Tour searchTripCode(String tripCode , ArrayList<Tour> tours){
        for ( Tour tour : tours){
            if ( tour.tripCode.equals(tripCode)){
                return tour;

            }
        }
        return null;
    }

    ArrayList<Tour> searchGeneralRegion(String generalRegion , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.region.getGeneralRegion().equals(generalRegion) ){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchMinPeople(int number , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( number == tour.minimumPeople){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchMaxPeople(int number , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( number == tour.maximumPeople){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchExactPrice (Long price , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.price.equals(price)){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchMinPrice (Long price , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.price > price){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchBetweenPrice (Long price1 , Long price2 ,  ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.price > price1 && tour.price < price2){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchMaxPrice (Long price , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( tour.price < price ){
                suitable.add(tour);
            }
        }
        return suitable ;
    }


    static Date finishDate ( Tour tour ){
        Date temp = tour.startDay;
        for ( int i =0 ; i < tour.numberOfDays-1 ; i++){
            temp = temp.nextDay();
        }
        return temp ;
    }

    ArrayList<Tour> searchBeforeDate (Date date  , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( Date.compareDate(date , finishDate(tour))==1){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    ArrayList<Tour> searchAfterDate (Date date  , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( Date.compareDate(date , tour.startDay)==-1){
                suitable.add(tour);
            }
        }
        return suitable ;
    }


    ArrayList<Tour> searchBetweenDate (Date date1 ,Date date2  , ArrayList<Tour> tours){
        ArrayList<Tour> suitable  = new ArrayList<>();
        for ( Tour tour : tours){
            if ( Date.compareDate(date1 , tour.startDay)==-1 && Date.compareDate(date2 , finishDate(tour))==1){
                suitable.add(tour);
            }
        }
        return suitable ;
    }

    Tour searchEdit ( String region , Long price  , ArrayList<Tour> tours ){
        for ( Tour tour : tours){
            if ( tour.region.getGeneralRegion().equals(region) && tour.price.equals(price)){
                return tour ;
            }
        }
        return  null ;
    }

    boolean editPrice ( String region , Long price , Long newPrice , ArrayList<Tour> tours ){
        Tour tour = searchEdit(region , price ,  Main.tours);
        if ( tour!= null){
            tour.setPrice(newPrice);
            return true;
        }else{
            return false ;
        }
    }


    public void setPrice(Long price) {
        this.price = price;
    }

    public String toString1() {
        return "Tour{" +
                "numberOfDays=" + numberOfDays +
                ", region=" + region +
                ", price=" + price +
                ", minimumPeople=" + minimumPeople +
                ", maximumPeople=" + maximumPeople +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", tripWay=" + tripWay +
                '}';
    }

    public String toString2() {
        return "Tour{" +
                "numberOfDays=" + numberOfDays +
                ", region=" + region +
                ", price=" + price +
                ", minimumPeople=" + minimumPeople +
                ", maximumPeople=" + maximumPeople +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", tripWay=" + tripWay +
                ", leader=" + leader +
                ", startDay=" + startDay +
                ", tripCode='" + tripCode + '\'' +
                ", visitingPlaces=" + visitingPlaces +
                '}';
    }

    void printSearch ( ArrayList <Tour> tours){
        if ( tours != null) {
            printArrayList(tours);
        }else{
            System.out.println("not existed !");
        }
    }

    void menu (){
        Scanner scanner = new Scanner ( System.in);
        while ( true ){
            System.out.println("1.tours list\n2.final tours list\n3.add a tour\n4.add a final tour\n5.edit a tour\n6.edit a final tour");
            System.out.println("7.search a tour\n8.search a final tour\n9.back");
            int input = scanner.nextInt();
            switch( input ){
                case 1 :
                    printArrayList(Main.tours);
                    break;
                case 2 :
                    printArrayListFinal(Main.finalTours);
                    break;
                case 3 :
                    System.out.println("number of days ?");
                    int duration = scanner.nextInt();
                    System.out.println("general region ?");
                    String generalRegion = scanner.next();
                    Region region =Region.searchGeneralRegion(generalRegion , Main.regions);
                    if ( region == null){
                        System.out.println("this region does not exist !\\n you can simply add it in the region menu ! ");
                        break ;
                    }
                    System.out.println("price ?");
                    Long price = scanner.nextLong();
                    System.out.println("maximum people ? ");
                    int max = scanner.nextInt();
                    System.out.println("minimum people ? ");
                    int min = scanner.nextInt();
                    System.out.println("origin city ? ");
                    String origin = scanner.next();
                    System.out.println("destination  city ? ");
                    String destination  = scanner.next();
                    System.out.println("trip way ? ( land / plane )  ");
                    TripWay tripWay = TripWay.valueOf(scanner.next().toUpperCase());
                    System.out.println("foreign ( true / false )?");
                    boolean result = scanner.nextBoolean();
                    System.out.println("places to visit ? ");
                    String [] placesToVisit = new String [duration] ;
                    for ( int i =0 ; i < duration ; i++ ){
                        placesToVisit[i] = scanner.next();
                    }
                    Set<String> place = new HashSet<>();
                    for ( int i =0 ; i < duration ; i++){
                        place.add(placesToVisit[i]);
                    }
                    int index = Region.searchGeneralRegionIndex( generalRegion , Main.regions );
                    for ( int i =0 ; i < duration ; i++ ) {
                        if (Main.regions.get(index).getRegion() != null) {
                            Main.regions.get(index).getRegion().add(placesToVisit[i]);
                        } else {
                            Main.regions.get(index).setRegion(place);
                        }
                    }

                    Map<Integer , String> visitingPlaces = new HashMap<>();
                    for ( int i =1 , j=0  ; i <= duration ; i++ , j++){
                        visitingPlaces.put( i , placesToVisit[j] );
                    }

                    Tour tour = new Tour(duration , region, price , max , min , origin , destination , tripWay , visitingPlaces , result );
                    if ( !Main.tours.contains(tour)) {
                        addTour(tour, Main.tours);
                    }else{
                        System.out.println("the tour already exists !");
                    }
                    printArrayList(Main.tours);
                    break ;
                case 4 :
                    System.out.println("enter the general region u wanna visit !");
                    String generalRegion1 = scanner.next();
                    ArrayList<TourLeader> suitable1 = TourLeader.searchByPlace(generalRegion1 , Main.tourLeaders);
                    ArrayList<Tour> suitable2 = searchGeneralRegion(generalRegion1 , Main.tours);
                    if ( !suitable1.isEmpty() && !suitable2.isEmpty()) {
                        System.out.println("here is the list of tour leaders !");
                        TourLeader.printArrayList(suitable1);
                        System.out.println("here is the list of tours ");
                        printArrayList(suitable2);
                        System.out.println("enter the first name and last name of the leader in turn from the printed list ! ");
                        String firstName = scanner.next();
                        String lastName = scanner.next();
                        TourLeader tourLeader = TourLeader.searchBoth(firstName, lastName, Main.tourLeaders);
                        ArrayList<Tour> tours = new ArrayList<>();
                        if ( tourLeader == null) {
                            System.out.println("wrong input of name !");
                            break ;
                        }
                        System.out.println("enter the number of tour ");
                        int num = scanner.nextInt();
                        Tour finalTour = suitable2.get(num - 1);
                        System.out.println("enter the trip code ");
                        String tripCode = scanner.next();
                        System.out.println("year ?");
                        int year = scanner.nextInt();
                        System.out.println("month ?");
                        int month = scanner.nextInt();
                        System.out.println("day  ?");
                        int day = scanner.nextInt();
                        Date date = new Date(year, month, day);
                        Tour finalTour1 = tourWithNoLeader(finalTour, date, tripCode);
                        if (tourLeader.getExistingTours()== null || TourLeader.isAvailable(tourLeader, finalTour1)) {
                            finalTour1.setLeader(tourLeader);
                            Main.finalTours.add(finalTour1);
                            if ( tourLeader.getExistingTours()== null ){
                                ArrayList<Tour> existingTours = new ArrayList<>();
                                existingTours.add(finalTour1);
                                tourLeader.setExistingTours(existingTours);
                            }else{
                                tourLeader.getExistingTours().add(finalTour1);
                            }
                            System.out.println("successfully added !");
                        } else {
                            System.out.println("the leader is not available !");
                        }
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 5 :
                    System.out.println("general region ? ");
                    String gRegion = scanner.next();
                    System.out.println("price ?");
                    Long currentPrice = scanner.nextLong();
                    System.out.println("new price ?");
                    Long  newPrice = scanner.nextLong();
                    boolean answer = editPrice(gRegion , currentPrice , newPrice , Main.tours);
                    if ( answer ){
                        System.out.println("successfully edited !" );
                        printArrayList(Main.tours);
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 6 :
                    System.out.println("trip code ? ");
                    String code = scanner.next();
                    System.out.println("new trip code ?");
                    String newCode = scanner.next();
                    boolean results = editTripCode(newCode , code , Main.finalTours) ;
                    if ( results ){
                        System.out.println("successfully edited !" );
                        printArrayList(Main.finalTours);
                    }else{
                        System.out.println("not existed !");
                    }
                    break;
                case 7 :
                    while ( true) {
                        System.out.println("1.number of days\n2.general region\n3.regions to visit\n4.min people\n5.max people\n6.exact price\n7.least price\n8.most price\n9.between 2 price\n10.back");
                        int key = scanner.nextInt();
                        switch (key){
                            case 1 :
                                System.out.println("number of days ?");
                                int number = scanner.nextInt();
                                printSearch(searchNumberOfDays(number , Main.tours));
                                break;
                            case 2 :
                                System.out.println("general region ? ");
                                String region1 = scanner.next();
                                printSearch(searchGeneralRegion(region1 , Main.tours));
                                break;
                            case 3 :
                                System.out.println("enter the place ");
                                String placeToVisit = scanner.next();
                                printSearch(searchByPlace(placeToVisit, Main.tours));
                                break ;
                            case 4:
                                System.out.println("min of people ?");
                                int minPeople = scanner.nextInt();
                                printSearch(searchMinPeople(minPeople , Main.tours));
                                break;
                            case 5 :
                                System.out.println("max of people ? ?");
                                int maxPeople = scanner.nextInt();
                                printSearch(searchMaxPeople(maxPeople , Main.tours));
                                break;
                            case 6 :
                                System.out.println("exact price ? ");
                                Long price1 = scanner.nextLong();
                                printSearch(searchExactPrice(price1, Main.tours));
                                break ;
                            case 7:
                                System.out.println("min price ?");
                                Long minPrice = scanner.nextLong();
                                printSearch(searchMinPrice(minPrice , Main.tours));
                                break;
                            case 8:
                                System.out.println("max price ?");
                                Long maxPrice = scanner.nextLong();
                                printSearch(searchMaxPrice(maxPrice , Main.tours));
                                break ;
                            case 9 :
                                System.out.println("enter 2 price in ascending form ");
                                Long firstPrice = scanner.nextLong();
                                Long secondPrice = scanner.nextLong();
                                printSearch(searchBetweenPrice(firstPrice , secondPrice , Main.tours));
                                break ;
                        }
                        if ( key == 10 ){
                            break;
                        }
                    }
                    break;
                case 8 :

                    while ( true) {
                        System.out.println("1.number of days\n2.general region\n3.regions to visit\n4.min people\n5.max people\n6.exact price\n7.least price\n8.most price\n9.between 2 price\n10.tours before a specific time\n11.tours after a specific time\n12. tours between 2 times\n13.leader\n14.back");
                        int key = scanner.nextInt();
                        switch (key){
                            case 1 :
                                System.out.println("number of days ?");
                                int number = scanner.nextInt();
                                printSearch(searchNumberOfDays(number , Main.tours));
                                break;
                            case 2 :
                                System.out.println("general region ? ");
                                String region1 = scanner.next();
                                printSearch(searchGeneralRegion(region1 , Main.tours));
                                break;
                            case 3 :
                                System.out.println("enter the place ");
                                String placeToVisit = scanner.next();
                                printSearch(searchByPlace(placeToVisit, Main.tours));
                                break ;
                            case 4:
                                System.out.println("min of people ?");
                                int minPeople = scanner.nextInt();
                                printSearch(searchMinPeople(minPeople , Main.tours));
                                break;
                            case 5 :
                                System.out.println("max of people ? ?");
                                int maxPeople = scanner.nextInt();
                                printSearch(searchMaxPeople(maxPeople , Main.tours));
                                break;
                            case 6 :
                                System.out.println("exact price ? ");
                                Long price1 = scanner.nextLong();
                                printSearch(searchExactPrice(price1, Main.tours));
                                break ;
                            case 7:
                                System.out.println("min price ?");
                                Long minPrice = scanner.nextLong();
                                printSearch(searchMinPrice(minPrice , Main.tours));
                                break;
                            case 8:
                                System.out.println("max price ?");
                                Long maxPrice = scanner.nextLong();
                                printSearch(searchMaxPrice(maxPrice , Main.tours));
                                break ;
                            case 9 :
                                System.out.println("enter 2 price in ascending form ");
                                Long firstPrice = scanner.nextLong();
                                Long secondPrice = scanner.nextLong();
                                printSearch(searchBetweenPrice(firstPrice , secondPrice , Main.tours));
                                break ;
                            case 10 :
                                System.out.println("enter year month date in turn !");
                                int year = scanner.nextInt();
                                int month = scanner.nextInt();
                                int day = scanner.nextInt();
                                Date date = new Date(year , month , day );
                                printSearch(searchBeforeDate(date , Main.finalTours));
                                break ;
                            case 11 :
                                System.out.println("enter year month date in turn !");
                                int year2 = scanner.nextInt();
                                int month2 = scanner.nextInt();
                                int day2 = scanner.nextInt();
                                Date date2 = new Date(year2 , month2 , day2 );
                                printSearch(searchAfterDate(date2 , Main.finalTours));
                                break ;
                            case 12 :
                                System.out.println("enter 2 dates in ascending form\nenter year month date in turn !");
                                int year3 = scanner.nextInt();
                                int month3 = scanner.nextInt();
                                int day3 = scanner.nextInt();
                                Date date3 = new Date(year3 , month3 , day3 );
                                System.out.println("enter year month date in turn !");
                                int year4 = scanner.nextInt();
                                int month4 = scanner.nextInt();
                                int day4 = scanner.nextInt();
                                Date date4 = new Date(year4 , month4 , day4 );
                                printSearch(searchBetweenDate(date3 , date4 , Main.finalTours));
                                break ;
                            case 13 :
                                System.out.println("first name ?");
                                String firstName = scanner.next();
                                System.out.println("lastName ?");
                                String lastName = scanner.next();
                                printSearch(searchByLeader(firstName , lastName , Main.finalTours));
                                break ;
                        }
                        if ( key == 14 ){
                            break;
                        }
                    }
                    break;
            }
            if ( input == 9 ){
                break ;
            }
        }
    }
}
