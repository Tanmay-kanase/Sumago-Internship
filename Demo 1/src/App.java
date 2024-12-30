public class App {
    public static void main(String[] args) throws Exception {
        try{
        System.out.println("\n \n INternship  \n \n");
        // Assignment 1 : write your bio data from 10th to 2th with all details.
        /* Write your Bio data
         * from 10th to 12th.
         */


        int num = 100;
        System.out.println(num); // 100
        System.out.println(++num); // 101
        System.out.println(++num); // 102
        System.out.println(num++); // 102
        for(int i =0; i < 4; ++i){ // 
            System.out.println(i);
        }
        // Assignment 2 : 
        /*  */
        System.out.println("""
                Hello Everyone Myself Tanmay Kanase.
                I complete my HSC from Vidyabhhawan School Nerul.
                I got 83% in it.
                """);
    }catch(Exception e){
        System.out.println(e.getMessage());
    }


    }
}
