package tut.sprng;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tut.sprng.beans.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringAppTests {
	@Autowired
	private Account account;

	@Test
	public void testSayHello() {
		Assert.assertEquals("Holder: Joe Test, number: 123", account.getInfo());
	}
}
