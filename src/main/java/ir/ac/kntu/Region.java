package ir.ac.kntu;

import java.util.*;

public class Region {

    private String generalRegion ;
    private Set<String > region  ;


    public Region(String generalRegion) {
        this.generalRegion = generalRegion;
    }

    public Region (){

    }

    public String getGeneralRegion() {
        return generalRegion;
    }

    public void setGeneralRegion(String generalRegion) {

        this.generalRegion = generalRegion;
    }

    public Set<String> getRegion() {
        return region;
    }

    public void setRegion(Set<String> region) {
        this.region = region;
    }

    public static ArrayList<String> generalRegion (ArrayList <Region> regions){
        ArrayList < String > generalRegions = new ArrayList<>();
        for ( Region region : regions ){
            generalRegions.add(region.getGeneralRegion());
        }
        return generalRegions;
    }

    void printArrayList (ArrayList<Region> regions ){
        for ( Region region : regions ){
            System.out.println(region.getGeneralRegion());
        }
    }

    void addGeneralRegion(String generalRegion , ArrayList<Region> regions){
        Region region = new Region ();
        region.setGeneralRegion(generalRegion);
        regions.add(region);
    }


    public static Region searchGeneralRegion(String generalRegion , ArrayList<Region> regions){
        for (Region region : regions){
            if ( region.generalRegion.equals(generalRegion)){
                return region;
            }
        }
        return null ;
    }

    public static int searchGeneralRegionIndex(String generalRegion , ArrayList<Region> regions){
        for (int i =0 ; i < regions.size() ; i++ ){
            if ( regions.get(i).generalRegion.equals(generalRegion)){
                return i;
            }
        }
        return -1;
    }



    boolean deleteGeneralRegion (String generalRegion, ArrayList<Region> regions){
        Region region = searchGeneralRegion(generalRegion , regions);
        if ( region != null){
            regions.remove(region);
            return true;
        }else{
            return false;
        }
    }

    boolean editRegion ( String currentGeneralRegion , String newGeneralRegion , ArrayList<Region> regions ){
        Region region = searchGeneralRegion(currentGeneralRegion, regions);
        if ( region != null){
            region.setGeneralRegion(newGeneralRegion);
            return true;
        }else{
            return false ;
        }

    }

    @Override
    public String toString() {
        return "Region{" +
                "generalRegion='" + generalRegion + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Region region1 = (Region) o;
        return Objects.equals(generalRegion, region1.generalRegion) &&
                Objects.equals(region, region1.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalRegion, region);
    }

    void menu(){
        Scanner scanner = new Scanner(System.in);
        while ( true ){
            System.out.println("1. regions list\n2.add a region\n3.edit a region\n4.delete a region\n5.back ");
            int input = scanner.nextInt();
            switch ( input ){
                case 1:
                    printArrayList(Main.regions);
                    break;
                case 2 :
                    System.out.println("general region ? ");
                    String generalRegion = scanner.next() ;
                    addGeneralRegion(generalRegion , Main.regions);
                    printArrayList(Main.regions);
                    break ;
                case 3 :
                    System.out.println("general region ? ");
                    String generalRegion2 = scanner.next();
                    System.out.println( "new name ? ");
                    String newName = scanner.next();
                    boolean result = editRegion(generalRegion2 , newName , Main.regions) ;
                    if ( result ){
                        System.out.println("successfully edited !" );
                        printArrayList(Main.regions);
                    }else{
                        System.out.println("not existed !");
                    }
                    break ;
                case 4 :
                    System.out.println("general region ? ");
                    String generalRegion3 = scanner.next() ;
                    boolean result2 = deleteGeneralRegion(generalRegion3 , Main.regions);
                    if ( result2 ){
                        System.out.println(" successfully deleted ! ");
                        printArrayList(Main.regions);
                    }else{
                        System.out.println("not existed ! ");
                    }
                    break ;
            }
            if ( input == 5 ){
                break ;
            }
        }
    }

}
