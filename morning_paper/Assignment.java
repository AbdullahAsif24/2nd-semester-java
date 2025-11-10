package morning_paper;
public class Assignment {
    public static void main(String[] args) {
        System.out.println(urlChecker("https://mubashir..com"));
    }

    public static boolean urlChecker(String s){
        String[] st = {"http://", "https://", "www."};

        String subOfUrl = "";

        boolean stChecked = false;
        for (int i = 0; i < st.length; i++) {
             stChecked = stChecked || s.startsWith(st[i]);
            
             if (s.startsWith(st[i])) {
                subOfUrl = s.substring(st[i].length());
             }
        }

        if(!stChecked) return false;


        String[] doms = subOfUrl.split("\\.");

        if (doms.length < 2) return false;

        for (int i = 0; i < doms.length; i++) {
            if (doms[i].length() < 2) return false;
            
            char[] charArr = doms[i].toCharArray();

            for (int j = 0; j < charArr.length; j++) {
                if (!Character.isLetterOrDigit(charArr[j])) {
                    return false;
                }
            }
        }
        

        



        return stChecked;
    }
}
