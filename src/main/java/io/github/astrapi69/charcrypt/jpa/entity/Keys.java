package io.github.astrapi69.charcrypt.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import de.alpharogroup.db.entity.versionable.VersionableUUIDEntity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Table(name = Keys.TABLE_NAME)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@SuperBuilder @FieldDefaults(level = AccessLevel.PRIVATE)
@TypeDefs({
	@TypeDef(
		name = "int-array",
		typeClass = IntArrayType.class
	)
})
public class Keys
	extends VersionableUUIDEntity
{
	static final String SINGULAR_ENTITY_NAME = "key";
	static final String TABLE_NAME = SINGULAR_ENTITY_NAME + "s";

	/**
	 * The value of this character entity
	 */
	@Column(name = "natural_order") String naturalOrdered;

	/** The set order of this key entity  */
	@Type(type = "int-array")
	@Column(
		name = "set_order",
		columnDefinition = "integer[]"
	)
	Integer[] setOrder;

	/** The permissions of the role. */
	@Builder.Default
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "key_char_items", joinColumns = {
		@JoinColumn(name = "key_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_key_char_items_key_id")) }, inverseJoinColumns = {
		@JoinColumn(name = "char_item_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_key_char_items_char_item_id")) })
	List<CharItems> charItems = new ArrayList<>();

}
