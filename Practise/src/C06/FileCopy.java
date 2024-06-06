package C06;

import java.io.*;

public class FileCopy {
    static final int BUFFER_SIZE = 1024;

    //main method may happen IOException
    public static void main(String[] args) throws IOException {
        InputStream in = null;
        OutputStream out =null;

        long totalTime = 0;
        long count = 0;

        try{
            try{
                in = new FileInputStream("Practise/resources/words/dictionary.txt");
                out = new FileOutputStream("output.txt");

                //use buffering
                //give the stream a buffer
                in = new BufferedInputStream(in, BUFFER_SIZE);
                out = new BufferedOutputStream(out, BUFFER_SIZE);

                int i;
                //read the current nanoTime (ns)
                long startTime = System.nanoTime();
                i = in.read();
                while(i!=-1){
                    byte b = (byte)i;
                    out.write(b);
                    count++;
                    i = in.read();
                }
                //use the buffer, when the buffer is not full, it will not write data into IO disk
                //we can enforce flush, actually, we don't need to flush here, when we close the stream, it will write the rest part in buffer into the IO disk
                out.flush();
                //after finish of the read, we read the finish time
                long finishTime = System.nanoTime();
                totalTime = finishTime-startTime;

            }catch (FileNotFoundException e){
                //not found the file, give exception
                e.printStackTrace();
            }finally {
                //whenever the code run, we should also close the stream
                if(in!=null){
                    in.close();
                }
                if(out!=null){
                    out.close();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(count + " bytes copied in " + (totalTime * 1e-9)+" seconds");
    }
}
