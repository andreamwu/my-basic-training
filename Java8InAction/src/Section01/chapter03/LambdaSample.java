package Section01.chapter03;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lambda的使用
 */
public class LambdaSample {
    public static void main(String[] args) throws IOException {
        // 使用Lambda打印
        Runnable r1 = () -> System.out.println("Hello Lambda ♥");
        r1.run();

        // 直接传递Lambda打印
        process(() -> System.out.println("Hello Lambda!"));

        // 使用匿名内部类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Anonymous Function");
            }
        };
        r2.run();

        // Lambda表达式引用的局部变量必须式最终的 （不推荐使用）
        final int portNumber = 9527;
        Runnable r3 = () -> System.out.println(portNumber);
        r3.run();



        /**--------------------分割线------------------------*/
        // 步骤④ 传递Lambda
        // 读取一行
        String firstRow = processFile((BufferedReader br) -> br.readLine());
//        System.out.println(processFile(BufferedReader::readLine));
        // 读取两行
        String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        System.out.println(firstRow);
        System.out.println(twoLines);


    }

    public static void process(Runnable r) {
        r.run();
    }

    /**
     * 读取文件
     * <p> 资源处理时，常见的模式就是打开一个资源，做一些处理，然后关闭资源。
     * 环绕执行（execute around）模式:设置和清理阶段总是很类似，并且会围绕着执行处理的那些重要代码
     * <p/>
     *
     * @return
     * @throws IOException
     */
//    public static String processFile() throws IOException {
//        // Java 7中的带资源的 try 语句, 不需要显式地关闭资源
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader("D:\\Test\\hr_cre.sql"))) {
//            // 工作代码(处理代码)
//            return br.readLine(); // 只读取第一行,如果需要读取两行呢？
//        }
//    }
    // 步骤② 使用函数式接口来传递读取文件的行为
    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("D:\\Test\\hr_cre.sql"))) {
            // 步骤③ 执行一个行为
            return p.process(br); // 处理BufferedReader对象
        }
    }


}
