package sopra.formation.monRdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.monRdv.model.TodoItem;

public interface ITodoItem extends JpaRepository<TodoItem, Long> {

}
