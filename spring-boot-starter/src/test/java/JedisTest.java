import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class JedisTest {

    private Jedis jedis;

    private RabbitTemplate rabbitTemplate;

    @Before
    public void testBefore(){
        jedis = new Jedis("47.98.181.113",6379);
    }

    @Test
    public void test(){
//        RedissonClient redissonClient = Redisson.create();
//        RLock redisLock = redissonClient.getLock("Lock");
//        try {
//            boolean tryLock = redisLock.tryLock(100000, 1000, TimeUnit.SECONDS);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000);
        bloomFilter.mightContain("");

        System.out.println(jedis.ping());
        String value = jedis.get("name");
        System.out.println(value);
        jedis.sort("aaa",new SortingParams());
    }

}
