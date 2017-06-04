package spring.CourseApplication.dao;

import java.util.List;

import spring.CourseApplication.dto.Master;

public interface MasterDAO {

	public List<Master> list();
	public void add(Master item);
	public void  update(Master item);
	public Master  getItem(Long id);
	public void  delete(Long id);
	
}
