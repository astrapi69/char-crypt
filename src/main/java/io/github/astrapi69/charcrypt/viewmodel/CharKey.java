package io.github.astrapi69.charcrypt.viewmodel;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"setOrder", "charItems"})
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CharKey
{
	String naturalOrdered;
	List<SetOrder> setOrder;
	List<CharItem> charItems;
}
