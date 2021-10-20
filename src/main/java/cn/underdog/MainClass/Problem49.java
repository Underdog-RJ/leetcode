package cn.underdog.MainClass;

public class Problem49 {
    public static void main(String[] args) {
//        boolean abaaabaaa = winnerOfGame("AAAAABBBBBBAAAAA");
//        boolean abaaabaaa = winnerOfGame("ABBBBBBBAAA");
//        boolean abaaabaaa = winnerOfGame("AAABABB");
        boolean abaaabaaa = winnerOfGame("BBBAAAABB");
        System.out.println(abaaabaaa);
    }

    public static boolean winnerOfGame(String colors) {

        if(colors.length()<=2)
            return false;
        String substring = colors;
        int ALength = 0;
        int AMaxLength = 0;
        int BLength =0;
        int BMaxLength = 0;
        for (int i = 0; i < substring.length(); i++) {
            if(substring.charAt(i)=='A'){
                ALength++;
            }else if(substring.charAt(i)!='A'){
                if(ALength>3){
                    AMaxLength+=ALength-2;
                }else if(ALength==3){
                    AMaxLength+=1;
                }
                ALength=0;

            }
        }
        if(ALength>3){
            AMaxLength+=ALength-2;
        }else if(ALength==3){
            AMaxLength+=1;
        }

        for (int i = 0; i < substring.length(); i++) {
            if(substring.charAt(i)=='B'){
                BLength++;
            }else if(substring.charAt(i)!='B'){
                if(BLength>3){
                    BMaxLength+=BLength-2;
                }else if(BLength==3){
                    BMaxLength+=1;
                }
                BLength=0;
            }
        }
        if(BLength>3){
            BMaxLength+=BLength-2;
        }else if(BLength==3){
            BMaxLength+=1;
        }

        return AMaxLength>BMaxLength?true:false;
    }

}
