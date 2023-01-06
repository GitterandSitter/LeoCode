package leo;


public class enumeration {
    public static void main(String args[]) {


        enum Day {
            MONDAY(true), TUESDAY(true), WEDNESDAY(true), THURSDAY(true), FRIDAY(true), SATURDAY(false), SUNDAY(false);


            private boolean isWeekDay;

            Day(boolean weekDay) {
                this.isWeekDay = weekDay;
            }

            @Override
            public String toString() {
                return String.format("%s is a weekday %b",
                        name(), isWeekDay);
            }
        }
        enum Planets {

            /* Formatting sources (in need of better solution):
            https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html
            https://www.java67.com/2015/06/how-to-format-numbers-in-java.html
            https://www.iitk.ac.in/esc101/05Aug/tutorial/java/data/decimalFormat.html
             */
            MERCURY(36E6, 3.3022E23),VENUS(67E6, 4.8685E24), EARTH(92.96E6, 5.9736E24), MARS(142E6, 6.4185E23), JUPITER(484E6, 1.8986E27), SATURN(886E6, 5.6846E26), URANUS(10.8E9, 8.6810E25), NEPTUNE(2.8E9, 10.243E25);
            //URANUS-distance incorrect - Test case for formatting method
            private double distanceFromSun;
            private double mass;

            Planets(double dist, double mass) {
                this.distanceFromSun = dist;
                this.mass = mass;
            }

            public String getPlanetDistance(Planets planet){

                    double distance = planet.distanceFromSun;
                    String phrase = "";

                    if (distance > 10E9) {
                        planet.distanceFromSun = distance / 10E9;
                        phrase =  planet.distanceFromSun + " billion miles";

                    } else if (distance > 10E6) {
                        planet.distanceFromSun = distance / 10E6;
                        phrase =  planet.distanceFromSun + " million miles";
                    }
                    //System.out.println(Planets.valueOf(value.toString()));

                /*return String.format("%s is %l  %b",
                        name(), distanceFromSun, mass);*/

                    return phrase;
            }

        }


        /*for(Day day :  Day.values())
            {
                System.out.println(day.toString());
            }*/
        for(Planets planet :  Planets.values())
        {
            System.out.println(planet.name() + " is located at " + planet.getPlanetDistance(planet) + "\n and weighs: " + planet.mass + " kgs.");
        }


    }
}