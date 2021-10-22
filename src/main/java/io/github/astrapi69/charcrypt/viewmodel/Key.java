package io.github.astrapi69.charcrypt.viewmodel;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import io.github.astrapi69.charcrypt.jpa.entity.CharItems;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Key
{
	String naturalOrdered;
	Integer[] setOrder;
	List<CharItems> charItems;
}
