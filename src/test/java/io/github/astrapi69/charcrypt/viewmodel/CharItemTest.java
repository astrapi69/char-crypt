package io.github.astrapi69.charcrypt.viewmodel;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharItemTest
{
	@Test
	public void test() {
		String foo = "foo bar";
		char[] chars = foo.toCharArray();
		List<CharItem> charItemList =new ArrayList<>();
		for(char c : chars) {
			charItemList.add(CharItem.builder()
				.value(c)
				.charset(StandardCharsets.UTF_8.name())
				.build());
		}

	}

}