public class Main {
    public static void main(String[] args) {
        //coordinate
        double distance = Air_distance(13.389045, 52.513350, 13.711835, 51.071995
                /*13.401394, 52.511273*/);
       // double distance1 = Air_distance1(13.389045, 52.513350, 55.750722, 37.614531);

        System.out.println("Berlin (13.389045, 52.513350) ");
        System.out.println("Dresden (13.711835, 51.071995) ");
        System.out.println("Moskau, Russland (55.750722,37.614531) ");
        System.out.println("Calgary, Canada (-114.068696,51.035241) ");
        System.out.println("Hamburg,  (9.993974,53.545044) ");
        System.out.println("Potsdam,  (13.065933,52.391199) ");
        System.out.println("krr,  (38.979064,45.051219 ) ");

        System.out.println("***********************************************************");
        System.out.println("Distance between Berlin and Dresden " + distance + " km ");
     //   System.out.println("Distance between Berlin and Calgary " + distance1 + " km");


    }
    // with Radius r
    public static double Air_distance(
            double lat1, double lng1, double lat2, double lng2) {
        int r = 6371; // average radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                        * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r * c;
        return d;

    }
}
