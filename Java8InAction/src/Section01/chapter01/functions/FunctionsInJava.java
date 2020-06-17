package Section01.chapter01.functions;

import java.io.File;
import java.io.FileFilter;

/**
 * Java中的函数
 */
public class FunctionsInJava {
    public static void main(String[] args) {
        // 筛选一个目录中的所有隐藏文件
        File[] hiddenFiles = new File("C:\\Users\\anjun").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        System.out.println("隐藏文件有：" + hiddenFiles.length);

        // Java8
        File[] hiddenFiles1 =  new File("C:\\Users\\anjun").listFiles(File::isHidden);
        System.out.println("隐藏文件有：" + hiddenFiles1.length);
    }
}
