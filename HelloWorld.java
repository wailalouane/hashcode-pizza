import kotlin.jvm.internal.MutablePropertyReference0Impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;


public class HelloWorld {


   public static int max;
   public static int nbrtyps;
   public static int somme2;
   public static int maximum=0;





   public static void getarray(String name){
        BufferedReader fr=null;

        try{
            int cpt = 0;
            fr=new BufferedReader(new FileReader(name+".in"));
            String firstline, line;
            firstline =fr.readLine();
            String[] tempo1;
            tempo1=firstline.split(" ");
            max=Integer.parseInt(tempo1[0]);
            nbrtyps=Integer.parseInt(tempo1[1]);
            int[][] typsarr = new int[nbrtyps][2];

            line=fr.readLine();
            tempo1=line.split(" ");
            int i;

            int size = tempo1.length;

            ArrayList<Integer> list = new ArrayList<Integer>(size);
            for(i = 1; i <= size; i++) {
                list.add(i);
            }
            int p,indx;
            Random rand = new Random();
            for(i=0;i<tempo1.length;i++){



                int index = rand.nextInt(list.size());
                //System.out.println("Selected: "+list.remove(index));
                p=Integer.parseInt(tempo1[i]);
                indx=list.remove(index)-1;
                typsarr[indx][0]=p;
                typsarr[indx][1]=i;

             //   System.out.println(typsarr[i]);
            }

          //  System.out.println(nbrtyps);

            int j;
            List<Integer> L1 =new ArrayList<>();
            List<Integer> L2=new ArrayList<>();
            int somme=0;
            somme2=0;
            j=nbrtyps-1;

            int esssay;
            boolean best=false;
            while(j>0 && !best ){
                cpt=0;
                L1.clear();
                somme=typsarr[j][0];
                p=typsarr[j][1];
                L1.add(p);
                i=j-1;
                cpt++;
                while (i!=j && somme<max){
                    esssay=typsarr[i][0]+somme;
                    if(max >= esssay){
                        somme=somme+typsarr[i][0];
                        p=typsarr[i][1];
                        L1.add(p);
                        cpt++;
                    }
                    i=i-1;
                    if(i<0){
                        i=nbrtyps-1;
                    }
                }
                if(somme2<somme){
                    somme2=somme;
                    L2=L1;

                }
                j=j-1;
                if(somme2==max){
                    best=true;
                }
            }

            System.out.println(somme2);

            if(maximum<somme2){
                maximum=somme2;
                Collections.sort(L2);

               System.out.println(L2);

                PrintStream outfile = new PrintStream(new File(name+".out"));
                outfile.print(Integer.valueOf(cpt));
                outfile.print("\n");
                for(i=0;i<L2.size();i++){
                    outfile.print(Integer.valueOf(L2.get(i))+" ");
                }
            }


        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

    public static void main(String[] args){
        int k=0;

        String[] namefil={"a_example","b_small","c_medium","d_quite_big","e_also_big"};
        int i=1;

        do{
            k++;
                //getarray("devlop.txt");
            getarray(namefil[i]);
        }while(k<100 && max!=somme2);



    }
}
