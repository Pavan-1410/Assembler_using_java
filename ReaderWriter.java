import java.util.concurrent.Semaphore;

public class ReaderWriter { 
    static Semaphore mutex = new Semaphore (1); 
    static Semaphore database = new Semaphore(1); 
    static int Read_Count=0; 
    static void Reader() throws Exception 
    { 
        while(true) 
        { 
            mutex.acquire();
            Read_Count = Read_Count + 1;
            if (Read_Count == 1)
            {
                database.acquire();
            }
            mutex.release();
            System.out.println("Data get read");
            mutex.acquire();
            Read_Count -- ;
            if (Read_Count == 0)
            {
                database.release();
            }
            mutex.release();
            break;
        } 
    } 

    static void Writer() throws Exception 
    { 
    
            while (true) { 
                database.acquire();
                System.err.println("Write done");
                break;
            }
         
    } 
    public static void main(String[] args)throws Exception { 
  
        Writer();
        Reader();
     
         
    } 
}