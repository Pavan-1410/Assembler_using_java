class pass_1_asm
{
       public static void main(String[] args)throws Exception {
        int i;
        String arr[][]={                        //our input asm code
            {"","START","101",""},
            {"","MOVER","BREG","ONE"},
            {"","MOVEM","BREG","TERM"},
            {"AGAIN","MULT","BREG","TERM"},
            {"","MOVER","CREG","TERM"},
            {"","MOVEM","CREG","RESULT"},
            {"N","DS","6",""},
            {"RESULT","DS","6",""},
            {"ONE","DC","1",""},
            {"TERM","DS","3",""},
            {"END","","",""}
            
        };
        int lc=Integer.parseInt(arr[0][2])-1;         //indicate 101 and changing the string into integer
        String st[][]=new String[arr.length][2];    //creating new table to store symbol and lc 
        int cnt=0,l;
        for(i=0;i<11;i++)
        {
            if(!(arr[i][0].equals("")))
            {
                st[cnt][0]=arr[i][0];
                st[cnt][1]=Integer.toString(lc);       //changing int to srting
                cnt++;
                if(arr[i][1].equals("DS"))
                {
                    l=Integer.parseInt(arr[i][2]);
                    lc=lc+l;
                }
                else{
                    lc++;
                }

            }
            else{
                lc++;
            }
        }
        System.out.println("SYMBOL \t\t VALUES\n");
        for(i=0;i<5;i++)
        {
            System.err.println(st[i][0]+"\t\t"+st[i][1]);
        }
       }
}