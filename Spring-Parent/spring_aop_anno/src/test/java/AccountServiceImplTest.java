import com.lagou.config.SpringConfig;
import com.lagou.servlet.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class) //选择配置项
public class AccountServiceImplTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void doTransfer(){
        accountService.transfer();
    }

}
