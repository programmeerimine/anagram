import java.io.*;
import java.util.Arrays;



class anagramApplication {

    public static void main(String[] argv) {
        long start = System.nanoTime();
        String word = argv[1];
        String result = "";

        //Convert original word to char array
        char[] originalWord = word.toLowerCase().toCharArray();
        Arrays.sort(originalWord);

        try{
            //read file
            BufferedReader reader = new BufferedReader(new FileReader(new File(argv[0])));
            String line;
            while ((line = reader.readLine()) != null) {
                //convert line to char array
                char[] otherWord = line.trim().toLowerCase().toCharArray();
                //if lengths are not same = not anagrams
                if (originalWord.length == otherWord.length){
                    Arrays.sort(otherWord);
                    //if arrays equal = anagram
                    if(Arrays.equals(originalWord,otherWord)){
                        result = result.concat(", ".concat(line));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        long stop = (System.nanoTime() - start) / 1000;
        System.out.println(stop + result);
    }


}
