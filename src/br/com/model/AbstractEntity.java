package br.com.model;

public interface AbstractEntity {
	
	public Long getId();
	
	public void setId(Long id);
	
	public boolean hasValidId();
}
