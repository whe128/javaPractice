package C06;

import java.io.*;
import java.util.HexFormat;
import java.util.StringJoiner;

public class FileReadingDemo {
    /**
     * input stream
     * @param in input stream
     * @param len read how many length
     */
    public static void showBytes(InputStream in, int len) throws IOException {
        //we use byte to store the read, it is byte stream
        byte[] bytes = new byte[len];
        //read the len length byte
        for (int i = 0; i < len; i++) {
            //read give us the number (0~255)
            //just the range of a byte
            //if read the end, read will give -1; we also transfer -1 to be the byte
            bytes[i] = (byte) in.read();
        }

        //transfer byte to hexadecimal, use ofDelimiter to separate these hexadecimal num
        HexFormat hexFormat = HexFormat.ofDelimiter(" ");
        String string = hexFormat.formatHex(bytes);

        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            if(bytes[i]>=32 && bytes[i]<=126){
                chars[i] = (char)bytes[i];
            }
            else {
                chars[i] = '.';
            }
        }

        System.out.println(string +" "+ String.valueOf(chars));
    }

    public static void showChars(Reader in,int len) throws IOException{
        //we use char to store the read, it is char steam
        //read char every time we read 2 byte
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = (char)in.read();
        }

        StringJoiner joiner = new StringJoiner(" ");

        for (int i = 0; i < len; i++) {
            joiner.add(Integer.toString(Character.codePointAt(chars,i)));
        }
        System.out.println(new String(chars)+"   ("+joiner+")");

    }

    public static void main(String[] args) {
        FileInputStream in = null;
        try{
            try{
                in = new FileInputStream("Practise/resources/words/hamlet.txt");
                InputStreamReader reader = new InputStreamReader(in);
                for (int i = 0; i < 20; i++) {
                    //read char can also suit the ASCII code text
                    showBytes(in, 16);
                    //showChars(reader,16);
                }
                in.close();

                System.out.println("------------------------");
                // in (Brazilian) Portuguese that has accents and are not
                // in the ASCII set of characters
                // this cannot use read byte, should use read char, the code of character is Unicode
                in = new FileInputStream("Practise/resources/words/portuguese_words_with_accents.txt");
                //this we read the char, not read the byte
                reader = new InputStreamReader(in);
                for (int i = 0; i < 20; i++) {
                    showChars(reader, 16);
                }
                in.close();

            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            finally {
                //we all should close the file stream
                if(in!=null){
                    in.close();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
