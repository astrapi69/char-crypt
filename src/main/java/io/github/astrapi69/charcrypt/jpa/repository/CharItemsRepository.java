package io.github.astrapi69.charcrypt.jpa.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.astrapi69.charcrypt.jpa.entity.CharItems;

public interface CharItemsRepository extends JpaRepository<CharItems, UUID>
{
}
