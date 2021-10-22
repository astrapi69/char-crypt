package io.github.astrapi69.charcrypt.jpa.entity;

import de.alpharogroup.db.entity.versionable.VersionableUUIDEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = CharItems.TABLE_NAME)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@SuperBuilder @FieldDefaults(level = AccessLevel.PRIVATE)
public class CharItems
	extends VersionableUUIDEntity
{
	static final String SINGULAR_ENTITY_NAME = "char_item";
	static final String TABLE_NAME = SINGULAR_ENTITY_NAME + "s";

	/**
	 * The value of this character entity
	 */
	@Column(name = "value", length = 1)
	char value;

	/**
	 * The charset of the character
	 */
	@Column(name = "charset", length = 64)
	String charset;

}
