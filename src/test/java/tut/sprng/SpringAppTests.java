package tut.sprng;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tut.sprng.beans.Hero;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class SpringAppTests {
	@Autowired
	private Hero hero;

	@Test
	public void testHero() {
		assertThat(hero.getName() + " " + hero.getNumber(), is("Batman 1"));
	}
}
