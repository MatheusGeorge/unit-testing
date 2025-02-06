package br.com.estudos.unit_testing.data;

import br.com.estudos.unit_testing.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
