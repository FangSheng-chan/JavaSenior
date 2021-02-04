package t9;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fangsheng
 * @date 2021/1/21 11:11 上午
 */
public class t3 {
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/ss/Documents/test");
        byte[] ch = new byte[1024];
        int read = fileInputStream.read(ch);
        fileInputStream.close();
        FileReader fileReader = new FileReader("/Users/ss/Documents/test");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileWriter fileWriter = new FileWriter("/Users/ss/Documents/test", false);
    }

    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("ss.txt");
            char[] chars = new char[1024];
            int len;
            while ((len = fileReader.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        char[] chars = new char[1024];
        chars = new char[]{'a', 'b', 'c', 'd'};
        String s = new String(chars, 0, 3);
        System.out.println(s);
    }

    @Test
    public void test4() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("ss.txt", false);
            fileWriter.write("hello i am ss\n");
            fileWriter.write("hi i am good boy");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {

            fr = new FileReader("ss.txt");
            fw = new FileWriter("ss3.txt");

            char[] chars = new char[5];
            //记录每次读入到chars数组中的字符的个数
            int len;
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("1.jpeg");
            FileOutputStream fileOutputStream = new FileOutputStream("2.jpeg");
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test6() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("ss.txt");
            File destFile = new File("ss2.txt");

            //不能使用字符流来处理图片等字节数据
            //            File srcFile = new File("test.jpg");
            //            File destFile = new File("test1.jpg");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭流资源
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Test
    public void test8() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("ss.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("ss7.txt"));

            char[] chars = new char[1024];
            int len;
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 统计一个txt内各个单词的个数
     */
    @Test
    public void test9() {
        FileReader fileReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            Map<Character, Integer> map = new HashMap<>();
            fileReader = new FileReader("hello2.txt");
            int c = 0;
            while ((c = fileReader.read()) != -1) {
                char ch = (char) c;
                //判断 char 是否在map第一次出现
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            bufferedWriter = new BufferedWriter(new FileWriter("hello3.txt"));

            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bufferedWriter.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("tab键=" + entry.getValue());
                    case '\r':
                        bufferedWriter.write("回车=" + entry.getValue());
                    case '\n':
                        bufferedWriter.write("执行=" + entry.getValue());
                    default:
                        bufferedWriter.write(entry.getKey() + "=" + entry.getValue());
                        break;
                }
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test10() {
        HashMap<Object, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 1);
        if (hashMap.get("1") != null) {
            hashMap.put("1", hashMap.get("1") + 1);
        }
        System.out.println(hashMap.get("1"));
        System.out.println(hashMap.containsValue(2));
    }
}

