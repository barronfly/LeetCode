/**
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
*/

/**

1. 文件最后只剩下<4的时候，也就是需要读的char字数 >> 文件本身有的char数目，比如：n=50 readbyte=23. 最后读到<4的时候，read下一次就不读了。
然后赋值的时候，只赋值最后这<4的char 给buf。
(至于n = 50, readbyte = 20 的情况，也就是最后一个也是4，whileloop readbyte<n, 自动会跳出，不再继续读了。)

2. 文件char数目>>n,比如：文件有50个char，只要读23个char。read4会读满4个char，但是最后我们只需要这3个char。所以最后赋值的时候，只需要最后3个。
*/

/* The read4 API is defined in the parent class Reader4. 
      int read4(char[] buf); */  
  
public class Solution extends Reader4 {  
    /** 
     * @param buf Destination buffer 
     * @param n   Maximum number of characters to read 
     * @return    The number of characters read 
     */  
    public int read(char[] buf, int n) {  
        char[] buffer = new char[4];  
          
        boolean eof = false;  
        int Readsize = 0;  
        int count = 0;  
          
        while(!eof && Readsize<n){  
            int count = read4(buffer);  
            if(count<4){  
                eof = true;  
            }  
              
            count = Math.min(n-Readsize,count);  
            for(int i=0; i<count; i++){  
                buf[Readsize+i] = buffer[i];  
            }  
            Readsize += count;  
        }  
        return Readsize;  
    }  
}  
