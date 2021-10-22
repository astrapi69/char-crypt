package io.github.astrapi69.charcrypt.service;

import org.springframework.stereotype.Service;

import io.github.astrapi69.charcrypt.jpa.entity.CharItems;
import io.github.astrapi69.charcrypt.jpa.repository.CharItemsRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CharItemsService
{
	CharItemsRepository repository;

	public CharItems save(CharItems charItems)
	{
		return repository.save(charItems);
	}

}
