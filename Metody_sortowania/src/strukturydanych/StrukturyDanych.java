package strukturydanych;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Zaneta
 */
public class StrukturyDanych {
    
    public static void bubbleSort(int[] tab){
        int temp;
        for (int i=0; i<tab.length-1; i++){       
           for (int j=0; j<tab.length-1; j++){
                if(tab[j] > tab[j+1]){
                    temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                    }
                }
          }                 
    }
    
    public static void bubbleSort2(int[] tab){
        boolean wym=false;
        for(int i=0; i<tab.length-1; i++){
            for(int j=tab.length-1; j>i; j--){
                if(tab[j-1]>tab[j]){
                    wym=true;
                    int temp = tab[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = temp;
                    
                }
                else if(!wym){
                break;
                }
        }
    }
    }
    
    private static void quickSort(int[] tab, int l, int r){
        int i, j, v, temp;
        i=l-1;
        j=r+1;
        v=tab[(l+r)/2];
        if(l<r){
            do{
                do{ 
                   i++; 
                }while(tab[i]<v);
                do{
                    j--;
                }while(v<tab[j]);
                if(i<j){
                    temp=tab[i];
                    tab[i]=tab[j];
                    tab[j]=temp;
                }
            }while(i<j);
                    quickSort(tab,l,j);
                    quickSort(tab,j+1,r);
        }
    }
    
    public static void quickSort(int[] tab){
        quickSort(tab,0,tab.length-1);
    }
    
    static int[] pom;
    
    public static void merge(int[] tab, int pocz, int sr, int kon) {
        int i, j, q;
        int[] t = new int[tab.length];
        for (i = pocz; i <= kon; i++) {
            t[i] = tab[i];
        }
        i = pocz;
        j = sr + 1;
        q = pocz;
        while (i <= sr && j <= kon) {
            if (t[i] < t[j]) {
                tab[q] = t[i];
                q++;
                i++;
            } else {
                tab[q] = t[j];
                q++;
                j++;
            }
        }
        while (i <= sr) {
            tab[q] = t[i];
            q++;
            i++;
        }
        while (j <= kon) {
            tab[q] = t[j];
            q++;
            j++;
        }
    }
    
    
    private static void mergeSort(int[] tab, int pocz, int kon) {
        int sr;
        if (pocz < kon) {
            sr = (pocz + kon) / 2;
            mergeSort(tab, pocz, sr);
            mergeSort(tab, sr + 1, kon);
            merge(tab, pocz, sr, kon);
        }
    }
    
    

    public static void mergeSort(int[] tab) {
        mergeSort(tab, 0, tab.length-1);
    }
    
    public static void countSort(int [] tab, int l){
        int [] count = new int[l];
        int [] t = new int [tab.length];
        int i,j,p;
        for(j=0; j<l; j++){
            count[j]=0;
        }
        for(i=0;i<tab.length;i++){
            count[tab[i]]=count[tab[i]]+1;
        }
        for(j=1;j<l;j++){
            count[j]=count[j-1]+count[j];
        }
        for(i=tab.length-1;i>=0; i--){
            p=tab[i];
            t[count[p]-1]=p;
            count[p]=count[p]-1;
        }
        for(i=0;i<tab.length; i++){
            tab[i]=t[i];
        }
    }
    
    
    public static void countingBinSort(int [] tab, int m){
        int [] count = new int[2];
        int [] t = new int [tab.length];
        int i,j,p;
        count[0]=0;
        count[1]=0;
        for(i=0;i<tab.length;i++){
            if((tab[i]&m)>0){
            count[1]++;
            }else{
             count[0]++;       
        }
        }
        count[1]+=count[0];
        for(i=tab.length-1;i>=0; i--){
            p=tab[i]&m;
            if(p>0){
                t[count[1]-1]=tab[i];
                count[1]--;
            }
            else{
               t[count[0]-1]=tab[i];
                count[0]--; 
        }
            
        }
        for(i=0;i<tab.length; i++){
            tab[i]=t[i];
        }
    }
    
    public static void radixSort(int[] tab, int k){
        int m = 1;
        while(m<=k){
            countingBinSort(tab, m);
            m=m*2;
        }
    }
    
    public static void sortowanieDwudzielne(int[] tab){
        int p,l;
        p=tab.length-1;
        l=0;
        int pom;
        while(l<=p){
            if(tab[p]==0){
                pom=tab[p];
                tab[p]=tab[l];
                tab[l]=pom;
                l++;
            }else{
                p--;
            }
        }
    }
    
    public static void sortowanieTrojdzielne(int[] tab){
        int p,l,r;
        p=tab.length-1;
        l=0;
        r=0;
        int pom;
        
        while(l<p){
            if(tab[l]==0){
                pom=tab[l];
                tab[l]=tab[r];
                tab[r]=pom;
                
                r++;
                l++;   
            }else if(tab[l]==1){
                l++;
            }else{
                pom=tab[p];
                tab[p]=tab[l];
                tab[l]=pom;
                p--;
            }
        }
    }
    
    

    public static void bucketSort(int[] tab, int k) {
        int[] wystap = new int[k];
        for (int i = 0; i < k; ++i) {
            wystap[i] = 0;
            
            for (int j = 0; j < tab.length; ++j) {
                if (tab[j] == i) {
                    wystap[i]++;
                }
            }
        }
        int x = 0;
        for (int i = 0; i < k; ++i) {
            while (wystap[i] != 0) {
                tab[x] = i;
                ++x;
            }
            ++i;
        }
    }
    
    public static void insertSort(int[] tab){
        for(int i=0; i<tab.length; i++){
            for(int j=i; j>0; j--){
                if(tab[j] < tab[j-1]){
                    int temp = tab[j];
                    tab[j] = tab[j-1];
                    tab[j-1] = temp;
                }
            }
        }
    }
    
    public static void insertSort2(int[] tab){
        int pom, j;
        for(int i=1; i<tab.length; i++){
            pom=tab[i];
            j=i;
            while(j>0 && tab[j-1]>pom){
                tab[j] = tab[j-1];
                j--;
            }
            tab[j] = pom;
            
        }
     }
    
    public static void swap(int a, int b){
        int temp;
        temp=a;
        a=b;
        b=temp;
    }
    
    public static void selectionSort(int[] tab){
        int min, temp;
        for(int i=0; i<tab.length-1; i++){
            min=i;
            for(int j=i+1; j<tab.length; j++){
                if(tab[j]<tab[min]){
                    min=j;
                }   
            }
            temp=tab[i];
            tab[i]=tab[min];
            tab[min]=temp;
        }
    }
    
    
    public static void main(String[] args) {
        int n=10;
        int[] tab = new int[n];
        Random gen = new Random();
        for(int i=0; i<n; i++){
            tab[i]=gen.nextInt(3);
//            tab[i]=gen.nextInt(2);
        }
       
        int[] pom = new int[10];
        int[] b = new int[10];
        
//        mergeSort(tab);
//        System.out.println(Arrays.toString(tab));
        
        
        radixSort(tab, 3);
        System.out.println(Arrays.toString(tab));
        
//         sortowanieDwudzielne(tab);
//         System.out.println(Arrays.toString(tab));   
         
//         sortowanieTrojdzielne(tab);
//         System.out.println(Arrays.toString(tab)); 
        
        
//        for(int i=0; i<n; i++){
//            System.out.println(tab[i]);
//        }
//        System.out.println(Arrays.toString(tab));
//        bubbleSort(tab);
//        System.out.println(Arrays.toString(tab));
//        insertSort(tab);
//        System.out.println(Arrays.toString(tab));
//        insertSort2(tab);
//        System.out.println(Arrays.toString(tab));
//        selectionSort(tab);
//        System.out.println(Arrays.toString(tab));
//        
//        System.out.println(Arrays.toString(tab));
//        bubbleSort2(tab);
//        System.out.println(Arrays.toString(tab));
//        quickSort(tab);
//        System.out.println(Arrays.toString(tab));
        
        /////
        
//        int[] tab2=Arrays.copyOf(tab,tab.length);
//        
//        long t1, t2;
//        
//        t1= System.nanoTime();
//        quickSort(tab2);
//        t2= System.nanoTime();
//        System.out.println(t2-t1);
//        
////        int[] tab3=Arrays.copyOf(tab,tab.length);
////        
////        t1= System.nanoTime();
////        bubbleSort2(tab3);
////        t2= System.nanoTime();
////        System.out.println(t2-t1);
//        
//        int[] tab4=Arrays.copyOf(tab,tab.length);
//        
//        t1= System.nanoTime();
//        insertSort2(tab4);
//        t2= System.nanoTime();
//        System.out.println(t2-t1);
//        
//        int[] tab5=Arrays.copyOf(tab,tab.length);
//        
//        t1= System.nanoTime();
//        selectionSort(tab5);
//        t2= System.nanoTime();
//        System.out.println(t2-t1);
        
        
                
    }
    
}
