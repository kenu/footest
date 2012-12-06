package net.okjsp.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void test() throws NoSuchFooException {
		Foo foo1 = new Foo();
		Foo foo2 = new Foo();
		String other = "other";

		List<Object> list = new ArrayList<Object>();

		list.add(foo1);
		list.add(foo2);
		list.add(other);

		assertEquals(Foo.class, list.get(0).getClass());

		Foo result = getLastFoo(list);
		assertEquals(foo2, result);
	}

	@Test(expected = NoSuchFooException.class)
	public void testNoSuchFooException() throws NoSuchFooException {
		List<Object> list = new ArrayList<Object>();
		getLastFoo(list);
	}

	public Foo getLastFoo(List<Object> list) throws NoSuchFooException {
		int length = list.size();
		for (int i = length - 1; i >= 0; i--) {
			Object object = list.get(i);
			if (object instanceof Foo) {
				return (Foo) object;
			}
		}
		throw new NoSuchFooException();
	}

}
