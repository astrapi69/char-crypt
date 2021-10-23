package io.github.astrapi69.charcrypt.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.github.astrapi69.charcrypt.viewmodel.CharItem;
import io.github.astrapi69.charcrypt.viewmodel.CharKey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.array.IntArrayType;

import de.alpharogroup.db.entity.versionable.VersionableUUIDEntity;

@Entity @Table(name = SetOrders.TABLE_NAME)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@SuperBuilder @FieldDefaults(level = AccessLevel.PRIVATE)
public class SetOrders
	extends VersionableUUIDEntity
{
	static final String SINGULAR_ENTITY_NAME = "set_order";
	static final String TABLE_NAME = SINGULAR_ENTITY_NAME + "s";

	Integer index;

}
