package itcode.imp.util;

import cn.smallbun.screw.core.process.ProcessConfig;
import java.util.Arrays;
import java.util.List;

/**
 * @author imp
 * @date 2021/2/5
 */
public class ScrewUtil {


    /**
     * 配置想要生成的表+ 配置想要忽略的表
     *
     * @return 生成表配置
     */
    public static ProcessConfig getProcessConfig() {
        // 忽略表名
        List<String> ignoreTableName = Arrays.asList("aa", "test_group");
        // 忽略表前缀，如忽略a开头的数据库表
        List<String> ignorePrefix = Arrays.asList("a", "t");
        // 忽略表后缀
        List<String> ignoreSuffix = Arrays.asList("_test", "czb_");

        return ProcessConfig.builder()
            //根据名称指定表生成
            .designatedTableName(Arrays.asList("cfg_data"))
            .build();
    }
}
