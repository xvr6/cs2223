public class Hash {

    public static int hashString(String str){
        int h = 0;
        final int C = 123;
        final int m = 997;

        for(int i = 0; i < str.length(); i++){
            h = (h * C + str.charAt(i)) % m;
        }

        return h;
    }

}