package io.github.astrapi69.charcrypt.controller;

import io.github.astrapi69.charcrypt.config.ApplicationConfiguration;
import io.github.astrapi69.charcrypt.jpa.entity.CharItems;
import io.github.astrapi69.charcrypt.mapper.CharItemsMapper;
import io.github.astrapi69.charcrypt.service.CharItemsService;
import io.github.astrapi69.charcrypt.viewmodel.CharItem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConfiguration.REST_VERSION + CharItemsController.REST_PATH)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CharItemsController
{
	public static final String REST_PATH = "/charitems";
	CharItemsService charItemsService;
	CharItemsMapper mapper;

	@RequestMapping(method = RequestMethod.POST)
	public CharItem newCharItem() {
		CharItems entity = charItemsService.save(CharItems.builder()
				.value('a')
				.charset("UTF-8")
			.build());
		return mapper.toDto(entity);
	}
}
