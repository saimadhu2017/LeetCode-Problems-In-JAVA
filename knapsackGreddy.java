import java.util.*;
// knapsack for greddy method.
public class knapsack{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int maxw=sc.nextInt();
        int[] w=new int[n];
        int[] p=new int[n];
        float[] pbw=new float[n];
        float[] pbwd=new float[n];
        float[] pbwa=new float[n];
        float[] x=new float[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            float pi=p[i];
            float wi=w[i];
            float v=pi/wi;
            pbw[i]=v;
            pbwd[i]=v;
            pbwa[i]=v;
        }
        Arrays.sort(pbwd);
        int max=maxw;
        for(int i=n-1;i>=0;i--){
            int index=-1;
            for(int j=0;j<n;j++){
                if(pbwd[i]==pbw[j]){
                    pbw[j]=-1;
                    index=j;
                    break;
                }
            }
            if(w[index]<=max){
                max=max-w[index];
                x[index]=1;

            }else if(max!=0 && w[index]>max){
                float a=max;
                float b=w[index];
                x[index]=a/b;
                max=0;
            }else{
                break;
            }
        }
        float sum=0;
        float maxprofit=0;
        for(int i=0;i<n;i++){
            sum=sum+(x[i]*w[i]);
            maxprofit=maxprofit+(x[i]*p[i]);
        }
        System.out.println("The bag capcity is: "+sum);
        System.out.println("The Maximum profit will be: "+maxprofit);

        sc.close();
    }
}