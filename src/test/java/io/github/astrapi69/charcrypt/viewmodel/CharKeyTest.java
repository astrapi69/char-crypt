package io.github.astrapi69.charcrypt.viewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.astrapi69.crypto.simple.CharacterSetCrypt;
import org.junit.jupiter.api.Test;

import io.github.astrapi69.collections.list.ListFactory;
import io.github.astrapi69.collections.map.MapFactory;
import io.github.astrapi69.string.StringExtensions;

class CharKeyTest
{

	@Test
	public void test()
	{
		String foo = "foo bar";
		List<Character> uniqueCharacters = StringExtensions.getUniqueCharacters(foo);
		List<CharItem> charItemList = new ArrayList<>();
		for (char c : uniqueCharacters)
		{
			charItemList
				.add(CharItem.builder().value(c).charset(StandardCharsets.UTF_8.name()).build());
		}
		String naturalOrdered = toString(uniqueCharacters);
		List<Integer> setOrderIndexes = ListFactory.newArrayList(4, 3, 1, 2, 5, 0);

		List<Character> setNewOrders = ListFactory.newArrayList();
		Map<Integer, Character> integerCharacterMap = toIndexMap(uniqueCharacters);
		for (Integer newIndex : setOrderIndexes)
		{
			Character character = uniqueCharacters.get(newIndex);
			setNewOrders.add(character);
		}
		List<SetOrder> setOrders = ListFactory.newArrayList();
		CharKey charKey = CharKey.builder().naturalOrdered(naturalOrdered).charItems(charItemList)
			.setOrder(setOrders).build();
		for (char c : setNewOrders)
		{
			SetOrder setOrder = SetOrder.builder().index(setNewOrders.indexOf(c)).owner(charKey)
				.charItem(
					CharItem.builder().value(c).charset(StandardCharsets.UTF_8.name()).build())
				.build();
			setOrders.add(setOrder);
		}
		assertNotNull(charKey);
		List<SetOrder> keySetOrder = charKey.getSetOrder();

		List<Character> keyChars = new ArrayList<>();
		for(SetOrder setOrder : keySetOrder){
			keyChars.add(setOrder.getCharItem().getValue());
		}
		String text = "foo bar bar bar foo";
		List<Integer> blaFasel = CharacterSetCrypt.toIndexList(text, keyChars);

		String toText = CharacterSetCrypt.toText(blaFasel, keyChars);
		assertEquals(text, toText);
	}

	/**
	 * Generates an index map from the given list
	 *
	 * @param <T>
	 *            the generic type
	 * @param list
	 *            the list
	 * @return an index map from the given list
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<Integer, T> toIndexMap(final List<T> list)
	{
		Map<Integer, T> map = MapFactory.newLinkedHashMap(list.size());
		for (int i = 0; i < list.size(); i++)
		{

			map.put(i, list.get(i));
		}
		return map;
	}

	/**
	 * Converts the given character list to a String
	 *
	 * @param characterList
	 *            the list of characters to convert
	 * @return the new {@link String} from the given character list
	 */
	public static String toString(List<Character> characterList)
	{
		StringBuilder sb = new StringBuilder();
		for (char ac : characterList)
		{
			sb.append(ac);
		}
		return sb.toString();
	}
}