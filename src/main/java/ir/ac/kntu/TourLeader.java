package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;


public class TourLeader {
    private String firstName;
    private String lastName;
    private Long nationalCode;
    private Long identityNumber;
    private Date dateOfBirth;
    private Date dateOfEmployment;
    private MaritalStatus status;
    private ArrayList<Tour> existingTours;
    private ArrayList<String> knownPlaces;

    public ArrayList<Tour> getExistingTours() {
        return existingTours;
    }

    public void setExistingTours(ArrayList<Tour> existingTours) {
        this.existingTours = existingTours;
    }

    public TourLeader() {
    }

    public TourLeader(String firstName, String lastName, Long nationalCode, Long identityNumber, Date dateOfBirth, Date dateOfEmployment, MaritalStatus status, ArrayList<String> knownPlaces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEmployment = dateOfEmployment;
        this.status = status;
        this.knownPlaces = knownPlaces;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNationalCode(Long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    boolean editFirstName ( String newFirstName , String firstName , String lastName , ArrayList<TourLeader> tourLeaders ){
        TourLeader tourLeader = searchBoth(firstName , lastName , Main.tourLeaders);
        if ( tourLeader!= null){
            tourLeader.setFirstName(newFirstName);
            return true;
        }else{
            return false ;
        }
    }


    boolean editLastName ( String newLastName , String firstName , String lastName , ArrayList<TourLeader> tourLeaders ){
        TourLeader tourLeader = searchBoth(firstName , lastName , Main.tourLeaders);
        if ( tourLeader!= null){
            tourLeader.setFirstName(newLastName);
            return true;
        }else{
            return false ;
        }
    }

    boolean editIdentityCode ( Long newCode , String firstName , String lastName , ArrayList<TourLeader> tourLeaders ){
        TourLeader tourLeader = searchBoth(firstName , lastName , Main.tourLeaders);
        if ( tourLeader!= null){
            tourLeader.setIdentityNumber(newCode);
            return true;
        }else{
            return false ;
        }
    }


    boolean editNationalCode ( Long newCode , String firstName , String lastName , ArrayList<TourLeader> tourLeaders ){
        TourLeader tourLeader = searchBoth(firstName , lastName , Main.tourLeaders);
        if ( tourLeader!= null){
            tourLeader.setNationalCode(newCode);
            return true;
        }else{
            return false ;
        }
    }

    static void printArrayList(ArrayList<TourLeader> tourLeaders) {
        for (TourLeader tourLeader : tourLeaders) {
            System.out.println(tourLeader);
        }
    }

    static ArrayList<TourLeader> searchByPlace(String place, ArrayList<TourLeader> tourLeaderList) {
        ArrayList<TourLeader> guides = new ArrayList<>();
        for (int i = 0; i < tourLeaderList.size(); i++) {
            if (tourLeaderList.get(i).knownPlaces != null) {
                for (int j = 0; j < tourLeaderList.get(i).knownPlaces.size(); j++) {
                    if (tourLeaderList.get(i).knownPlaces.get(j).equals(place)) {
                        guides.add(tourLeaderList.get(i));
                    }
                }

            }
        }
        return guides;
    }

    public TourLeader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    void addLeader(TourLeader tourLeader, ArrayList<TourLeader> tourLeaderList) {
        tourLeaderList.add(tourLeader);
    }


    boolean deleteLeader(String firstName, String lastName, ArrayList<TourLeader> tourLeaderList) {
        TourLeader tourLeader = searchBoth(firstName, lastName, tourLeaderList);
        if (tourLeader != null) {
            tourLeaderList.remove(tourLeader);
            return true;
        } else {
            return false;
        }
    }

    ArrayList<TourLeader>  searchFirstName(String firstName, ArrayList<TourLeader> tourLeaderList) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaderList) {
            if (tourLeader.firstName.equals(firstName)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;
    }

    ArrayList<TourLeader> searchLastName(String lastName, ArrayList<TourLeader> tourLeaderList) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaderList) {
            if (tourLeader.lastName.equals(lastName)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;
    }


    static TourLeader searchBoth(String firstName, String lastName, ArrayList<TourLeader> tourLeaderList) {
        for (TourLeader tourLeader : tourLeaderList) {
            if (tourLeader.lastName.equals(lastName) && tourLeader.firstName.equals(firstName)) {
                return tourLeader;
            }
        }
        return null;
    }

    int ageCalculator(int year, TourLeader tourLeader) {
        int age = year - tourLeader.dateOfBirth.getYear();
        return age;
    }

    ArrayList<TourLeader> searchAge(int age, int year, ArrayList<TourLeader> tourLeaders) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (age == ageCalculator(year, tourLeader)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;

    }

    ArrayList<TourLeader> searchMoreAge(int age, int year, ArrayList<TourLeader> tourLeaders) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (age < ageCalculator(year, tourLeader)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;

    }

    ArrayList<TourLeader> searchLessAge(int age, int year, ArrayList<TourLeader> tourLeaders) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (age > ageCalculator(year, tourLeader)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;

    }

    ArrayList<TourLeader> searchBetweenAge(int firstAge,int secondAge , int year, ArrayList<TourLeader> tourLeaders) {
        ArrayList<TourLeader> suitable = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (firstAge<ageCalculator(year, tourLeader) && secondAge> ageCalculator(year, tourLeader)) {
                suitable.add(tourLeader);
            }
        }
        return suitable;

    }

    static boolean isAvailable ( TourLeader tourLeader , Tour tour  ){
        for ( int i =0 ; i < tourLeader.getExistingTours().size() ; i++ ){
            if ( (Date.compareDate(tourLeader.getExistingTours().get(i).getStartDay() , Tour.finishDate(tour)) == -1 ||Date.compareDate(tourLeader.getExistingTours().get(i).getStartDay() , Tour.finishDate(tour)) == 0) && ((Date.compareDate(Tour.finishDate(tourLeader.getExistingTours().get(i)) , tour.getStartDay()) == -1  ||Date.compareDate(Tour.finishDate(tourLeader.getExistingTours().get(i)) , tour.getStartDay()) == 0)) ){
                return false ;
            }
        }
        return true ;
    }

    static void addExistingTours(TourLeader tourLeader , Tour tour ){
        tourLeader.getExistingTours().add(tour);

    }

    @Override
    public String toString() {
        return "TourLeader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalCode=" + nationalCode +
                ", identityNumber=" + identityNumber +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                ", status=" + status +
                ", knownPlaces=" + knownPlaces +
                '}';
    }

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1.all leaders\n2.add a leader\n3.delete a leader\n4.edit a leader\n5.search a leader\n6.back\n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    printArrayList(Main.tourLeaders);
                    break;
                case 2:
                    System.out.println("first name ? ");
                    String firstName = scanner.next();
                    System.out.println("last name ? ");
                    String lastName = scanner.next();
                    System.out.println("national code ?");
                    Long code = scanner.nextLong();
                    System.out.println("identity code ?");
                    Long code2 = scanner.nextLong();
                    System.out.println("date of birth :\nyear ?");
                    int year = scanner.nextInt();
                    System.out.println("month ?");
                    int month = scanner.nextInt();
                    System.out.println("day?");
                    int day = scanner.nextInt();
                    Date birthDate = new Date(year, month, day);
                    System.out.println("date of employment  :\nyear ?");
                    int year1 = scanner.nextInt();
                    System.out.println("month ?");
                    int month1 = scanner.nextInt();
                    System.out.println("day?");
                    int day1 = scanner.nextInt();
                    Date employmentDate = new Date(year, month, day);
                    System.out.println("marital status ( single/married ) ? ");
                    MaritalStatus status = MaritalStatus.valueOf(scanner.next().toUpperCase());
                    System.out.println("number of known places ? ");
                    int number = scanner.nextInt();
                    String [] temp = new String[number];
                    for ( int i =0 ; i < number ; i++ ){
                        temp[i] = scanner.next();
                        Region place = Region.searchGeneralRegion(temp[i] , Main.regions);
                        if ( place == null){
                            Region knownPlace = new Region(temp[i]);
                            Main.regions.add(knownPlace);
                            System.out.println("Region added !");
                        }else{
                            System.out.println( " Region existed !");
                        }
                    }
                    ArrayList<String> finalKnownPlaces = new ArrayList<>();
                    for ( int i =0 ; i < number ; i++){
                        finalKnownPlaces.add(temp[i]);
                    }
                    TourLeader tourLeader = new TourLeader(firstName, lastName, code, code2, birthDate, employmentDate, status, finalKnownPlaces);
                    addLeader(tourLeader, Main.tourLeaders);
                    printArrayList(Main.tourLeaders);
                    break;
                case 3:
                    System.out.println("first name ? ");
                    String firstName1 = scanner.next();
                    System.out.println("last name ? ");
                    String lastName1 = scanner.next();
                    if (deleteLeader(firstName1, lastName1, Main.tourLeaders)) {
                        System.out.println("successfully deleted !");
                    } else {
                        System.out.println("not existed !");
                    }
                    printArrayList(Main.tourLeaders);
                    break;
                case 4:
                    while(true){
                        System.out.println("1.edit first name\n2.edit last name\n3.edit identity code\n4.edit national code\n5.back ");
                        int input1 = scanner.nextInt();
                        switch(input1){
                            case 1 :
                                System.out.println("first name  ? ");
                                String fName = scanner.next();
                                System.out.println( "last name  ? ");
                                String lName = scanner.next();
                                System.out.println("new first name ?");
                                String newFName = scanner.next();
                                boolean result = editFirstName(newFName , fName , lName , Main.tourLeaders) ;
                                if ( result ){
                                    System.out.println("successfully edited !" );
                                    printArrayList(Main.tourLeaders);
                                }else{
                                    System.out.println("not existed !");
                                }
                                break ;
                            case 2 :
                                System.out.println("first name  ? ");
                                String fName1 = scanner.next();
                                System.out.println( "last name  ? ");
                                String lName1 = scanner.next();
                                System.out.println("new first name ?");
                                String newLName = scanner.next();
                                boolean result1 = editLastName(newLName , fName1 , lName1 , Main.tourLeaders) ;
                                if ( result1 ){
                                    System.out.println("successfully edited !" );
                                    printArrayList(Main.tourLeaders);
                                }else{
                                    System.out.println("not existed !");
                                }
                                break ;
                            case 3 :
                                System.out.println("first name  ? ");
                                String fName2 = scanner.next();
                                System.out.println( "last name  ? ");
                                String lName2 = scanner.next();
                                System.out.println("new identity code ?");
                                Long identityCode = scanner.nextLong();
                                boolean result2 = editIdentityCode(identityCode , fName2 , lName2 , Main.tourLeaders) ;
                                if ( result2 ){
                                    System.out.println("successfully edited !" );
                                    printArrayList(Main.tourLeaders);
                                }else{
                                    System.out.println("not existed !");
                                }
                                break ;
                            case 4 :
                                System.out.println("first name  ? ");
                                String fName3 = scanner.next();
                                System.out.println( "last name  ? ");
                                String lName3 = scanner.next();
                                System.out.println("new national code ?");
                                Long nationalCode = scanner.nextLong();
                                boolean result3 = editNationalCode(nationalCode , fName3 , lName3 , Main.tourLeaders) ;
                                if ( result3 ){
                                    System.out.println("successfully edited !" );
                                    printArrayList(Main.tourLeaders);
                                }else{
                                    System.out.println("not existed !");
                                }
                                break ;

                        }
                        if ( input1 ==5 ){
                            break ;
                        }
                    }
                    break;
                case 5:
                    while (true ) {
                        System.out.println("1.first name\n2.last name \n3.known places\n4.exact age\n5.more than a number\n6.less than a number\n7.between 2 numbers\n8.back");
                        int key = scanner.nextInt();
                        switch (key) {
                            case 1:
                                System.out.println("first name ? ");
                                String firstName2 = scanner.next();
                                ArrayList<TourLeader> result = searchFirstName(firstName2, Main.tourLeaders);
                                if (!result.isEmpty()) {
                                    System.out.println(result);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                            case 2:
                                System.out.println("last name ? ");
                                String lastName2 = scanner.next();
                                ArrayList<TourLeader> result1 = searchLastName(lastName2, Main.tourLeaders);
                                if (!result1.isEmpty()) {
                                    System.out.println(result1);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                            case 3:
                                System.out.println("known place ? ");
                                String place = scanner.next();
                                ArrayList<TourLeader> suitable1 = searchByPlace(place, Main.tourLeaders);
                                if (!suitable1.isEmpty()) {
                                    printArrayList(suitable1);
                                } else {
                                    System.out.println("not existed ! ");
                                }
                                break;
                            case 4:
                                System.out.println("age ?");
                                int age = scanner.nextInt();
                                System.out.println("year?");
                                int currentYear = scanner.nextInt();
                                ArrayList<TourLeader> suitable = new ArrayList<>();
                                suitable = searchAge(age, currentYear, Main.tourLeaders);
                                if (!suitable.isEmpty()) {
                                    printArrayList(suitable);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                            case 5:
                                System.out.println("age ?");
                                int age2 = scanner.nextInt();
                                System.out.println("year?");
                                int currentYear2 = scanner.nextInt();
                                ArrayList<TourLeader> suitable2 = new ArrayList<>();
                                suitable2 = searchLessAge(age2, currentYear2, Main.tourLeaders);
                                if (!suitable2.isEmpty()) {
                                    printArrayList(suitable2);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                            case 6:
                                System.out.println("age ?");
                                int age3 = scanner.nextInt();
                                System.out.println("year?");
                                int currentYear3 = scanner.nextInt();
                                ArrayList<TourLeader> suitable3 = new ArrayList<>();
                                suitable3 = searchMoreAge(age3, currentYear3, Main.tourLeaders);
                                if (!suitable3.isEmpty()) {
                                    printArrayList(suitable3);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                            case 7:
                                System.out.println("min age ?");
                                int minAge = scanner.nextInt();
                                System.out.println("max age ?");
                                int maxAge = scanner.nextInt();
                                System.out.println("year?");
                                int currentYear4 = scanner.nextInt();
                                ArrayList<TourLeader> suitable4 = new ArrayList<>();
                                suitable4 = searchBetweenAge(minAge, maxAge, currentYear4, Main.tourLeaders);
                                if (!suitable4.isEmpty()) {
                                    printArrayList(suitable4);
                                } else {
                                    System.out.println("not existed !");
                                }
                                break;
                        }
                        if (key == 8) {
                            break;
                        }
                    }
                    break;
            }
            if (input == 6) {
                break;
            }
        }
    }
}


