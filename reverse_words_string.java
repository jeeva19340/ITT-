public class ReverseWords
{
    public static void main(String[] args){
        String str="have a nice day";
        String[] words=str.split(" ");
        for (int i=words.length-1; i>=0;i--){
            System.out.print(words[i] + " ");
        }
    }
}
