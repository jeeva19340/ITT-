// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] shari = new long[N];
        long[] neta = new long[M];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            shari[i]=Long.parseLong(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int j=0;j<M;j++){
            neta[j]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(shari);
        Arrays.sort(neta);
        int shariIndex=0;
        int netaIndex=0;
        int sushicount=0;
        while(shariIndex < N && netaIndex < M){
            if(neta[netaIndex] <= 2*shari[shariIndex]){
                sushicount++;
                shariIndex++;
                netaIndex++;
            }
            else{
                shariIndex++;
            }
        }
        System.out.println(sushicount);
        }
    }

