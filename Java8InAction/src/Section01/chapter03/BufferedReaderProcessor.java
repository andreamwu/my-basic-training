package Section01.chapter03;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 步骤①  行为参数化
 * 需要创建一个能匹配 BufferedReader -> String ，还可以抛出 IOException 异常的接口
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
