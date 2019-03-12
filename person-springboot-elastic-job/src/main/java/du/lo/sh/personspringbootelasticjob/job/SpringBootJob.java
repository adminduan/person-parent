package du.lo.sh.personspringbootelasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @ClassName SpringBootJob
 * @Description springBoot job信息
 * @Author duanlsh
 * @Date 2019/3/12 17:54
 * @Version 1.0
 */
public class SpringBootJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(">>>>>>>>>>>>>>>>>>>" + shardingContext + "<<<<<<<<<<<<<<<<<<<<<<");
    }
}
