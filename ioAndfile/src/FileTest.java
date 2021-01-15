import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by fangsheng on 2021/1/7 4:25 下午
 */

/**
 * 1、路径分隔符
 */
public class FileTest {
    @Test
    public void test1() {
        String separator = File.separator;
        File file1 = new File("hello.txt");
        File file2 = new File("/Users/ss/Documents/test/1.txt");
        System.out.println(file1);
        System.out.println(file2);
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("/Users/ss/Documents/test/1.txt");
        File file3 = new File("/Users/ss/Documents/test/");

        String absolutePath = file2.getAbsolutePath();
        String path = file2.getPath();
        String name = file2.getName();
        String parent = file2.getParent();
        long length = file2.length();
        long l = file2.lastModified();
        Date date = new Date(l);
        System.out.println(absolutePath);
        System.out.println(date);

        // 列出当前文件夹下的文件
        String[] list = file3.list();
        File[] files = file3.listFiles();
        for (String s : list) {
            System.out.println(s);
        }
        for (File file : files) {
            System.out.println(file);
        }
    }

    @Test
    public void test3() {
        File file1 = new File("hello.txt");
        File file2 = new File("/Users/ss/Documents/test/1.txt");
        File file3 = new File("/Users/ss/Documents/test/");

        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        //先调用 exists
        System.out.println(file2.exists());
    }

    @Test
    public void test4() {
        File file1 = new File("hi.txt");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file1.delete();
            System.out.println("删除成功");
        }

    }

    @Test
    public void test5() throws IOException {
        File file = new File("/Users/ss/Documents/test/test1/hello.txt");
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        }
        boolean delete = destFile.delete();
        if (delete) {
            System.out.println("删除成功");
        }
    }

    @Test
    public void test6() throws IOException {
        File file = new File("/Users/ss/Documents/test/");
        String[] list = file.list();
        for (String fileName : list) {
            if (fileName.lastIndexOf('.') > 0) {
                String substring = fileName.substring(fileName.lastIndexOf('.'));
                if (substring.equals(".png")) {
                    System.out.println(fileName);
                }
            }
        }

    }

    @Test
    public void test7() {
        File file = new File("/Users/ss/Documents/test2/");
//        listFile(file, "");
        showFile(file);
//        System.out.println(getDirSize(file));
    }


    public static void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] list = file.listFiles();
            if (list == null || list.length == 0) {
                System.out.println("文件夹为空");
                return;
            } else {
                for (File f : list) {
                    if (f.isDirectory()) {
                        traverseFolder(f.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + f.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件夹不存在");
        }
    }

    public static void listFile(File dir, String spance) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(spance + "|--" + file.getName());
            } else {
                String substring = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("/") + 1);
                System.out.println(spance + "|--" + file.getName());
                listFile(file, spance + "|--" + substring);
            }
        }
    }

    /**
     * 递归遍历文件夹
     *
     * @param file
     */
    public static void showFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else {
                System.out.println(f.getName());
                showFile(f);
            }
        }
    }

    public static long getDirSize(File file) {
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                size += getDirSize(f);
            }
        }
        return size;
    }

    @Test
    public void test8() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1", "s");
        hashMap.put("2", "a");
        hashMap.put("3", "d");
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            Object key = next.getKey();
            Object value = next.getValue();
            System.out.println(key + ":" + value);
        }

        System.out.println();

        for (Map.Entry<Object, Object> objectObjectEntry : hashMap.entrySet()) {
            System.out.println(objectObjectEntry.getKey() + ":" + objectObjectEntry.getValue());
        }

        System.out.println();

        for (Object o : hashMap.keySet()) {
            System.out.println(o + ":" + hashMap.get(o));
        }

        Collection<Object> values = hashMap.values();
        Iterator<Object> objectIterator = values.iterator();
        while (objectIterator.hasNext()) {
            System.out.println(objectIterator.next());
        }

    }

    @Test
    public void test9() {

    }

}
