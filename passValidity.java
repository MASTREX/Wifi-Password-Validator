import java.util.*;
import java.io.*;
class passValidity
{
    static void main(String FlName) throws IOException
    {
        FileReader fr=new FileReader("list/"+FlName);
        BufferedReader br=new BufferedReader(fr);
        FileWriter fw=new FileWriter("valid/"+FlName);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        char arr[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'};
        String s="";
        int wdel=0,lws=0;
        do{
            s=br.readLine();
            if(s!=null)
            {
                if(s.length()==5)
                {
                    if(check(s)!="not")
                    {
                        pw.println(s);
                    }
                    else
                    {
                        wdel++;
                    }
                }
                else if(s.length()>=8 && s.length()<=63)
                {
                    if(check(s)!="not")
                    {
                        pw.println(s);
                    }
                    else
                    {
                        wdel++;
                    }
                }
                else if(s.length()>63)
                {
                    String rs=s.substring(0,63);
                    lws++;
                    for(int i=0;i<arr.length;i++)
                    {
                        if(s.charAt(63)==arr[i])
                        {
                            rs=rs+s.charAt(63);
                            break;
                        }
                    }
                    if(check(rs)!="not")
                    {
                        pw.println(rs);
                    }
                    else
                    {
                        wdel++;
                        lws--;
                    }
                }
                else
                {
                    wdel++;
                }
            }
        }while(s!=null);
        System.out.println("Word Deleted:- "+wdel);
        System.out.println("Long Word Shorted:- "+lws);
        br.close();
        pw.close();
    }

    public static String check(String str)
    {
        char ascii[]={' ','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/','0','1','2','3','4','5','6','7','8','9',':',';','<','=','>','?','@','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','[','\\',']','^','_','`','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','{','|','}','~','Ç','ü','é','â','ä','à','å','ç','ê','ë','è','ï','î','ì','Ä','Å','É','æ','Æ','ô','ö','ò','û','ù','ÿ','Ö','Ü','ø','£','Ø','×','ƒ','á','í','ó','ú','ñ','Ñ','ª','º','¿','®','¬','½','¼','¡','«','»','░','▒','▓','│','┤','Á','Â','À','©','╣','║','╗','╝','¢','¥','┐','└','┴','┬','├','─','┼','ã','Ã','╚','╔','╩','╦','╠','═','╬','¤','ð','Ð','Ê','Ë','È','ı','Í','Î','Ï','┘','┌','█','▄','¦','Ì','▀','Ó','ß','Ô','Ò','õ','Õ','µ','þ','Þ','Ú','Û','Ù','ý','Ý','¯','´','±','‗','¾','¶','§','÷','¸','°','¨','•','¹','³','²','■'};
        for(int i=0; i<str.length();i++)
        {
            for(int j=0;j<ascii.length;j++)
            {
                if(str.charAt(i)==ascii[j])
                    break;
                if(j==ascii.length-1)
                {
                    return "not";
                }
            }
        }
        return str;
    }
}