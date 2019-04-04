package sopra.formation.monRdv.model;

import java.time.LocalDateTime;

//Classe POJO pour tester la Session

public class TodoItem {

	private String description;
	private LocalDateTime createDate;
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public TodoItem() {
		super();
	}
	public TodoItem(String description, LocalDateTime createDate) {
		super();
		this.description = description;
		this.createDate = createDate;
	}
	
}
