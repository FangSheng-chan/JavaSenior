package test3;

import java.io.*;

/**
 * @author fangsheng
 * @date 2021/3/5 上午10:33
 */
public class ExternalizableTest implements Externalizable {

    private transient String content = "yes , i will Serializable";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableTest externalizableTest = new ExternalizableTest();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("/Users/ss/Documents/test/flyPig.txt")));
        out.writeObject(externalizableTest);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/Users/ss/Documents/test/flyPig.txt")));
        externalizableTest = (ExternalizableTest) objectInputStream.readObject();
        System.out.println(externalizableTest.content);

        out.close();
        objectInputStream.close();
    }
}
