package du.lo.sh.personspringbootelasticjob.configurations;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import du.lo.sh.personspringbootelasticjob.job.SpringBootJob;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @ClassName SimpleJobConfig
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/3/12 17:58
 * @Version 1.0
 */
@Configuration
public class SimpleJobConfig {

    @Resource
    private ZookeeperRegistryCenter regCenter;

    @Bean
    public SpringBootJob simpleJob(){
        return new SpringBootJob();
    }


    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration("localhost:2181"," elastic-job-lite-springboot"));
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SpringBootJob simpleJob, @Value("${simpleJob.cron}") final String cron,
                                           @Value("${simpleJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${simpleJob.shardingItemParameters}") final String shardingItemParameters){

        return new SpringJobScheduler(simpleJob, regCenter, getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters));
    }

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass, final String cron, final int shardingTotalCount, final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(JobCoreConfiguration.newBuilder(
                jobClass.getName(), cron, shardingTotalCount).shardingItemParameters(shardingItemParameters).jobParameter(UUID.randomUUID().toString()).build(), jobClass.getCanonicalName())).overwrite(true).build();
    }
}
