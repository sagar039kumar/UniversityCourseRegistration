package spring.CourseApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.CourseApplication.dao.MasterDAO;
import spring.CourseApplication.dto.Master;

@Controller
public class CourseController {
	
	@Autowired
	private MasterDAO MasterDao; 
	
	
	  @RequestMapping(value="/list")
	    public ModelAndView list() {
	        List<Master> itemList = MasterDao.list();
	        ModelAndView model = new ModelAndView("MasterList");
	        model.addObject("itemList", itemList);
	        return model;
	    }

	  @RequestMapping(value="/loadAddForm")
	    public ModelAndView add() {
	       ModelAndView model = new ModelAndView("MasterAdd");
		   Master item=new Master();
           model.addObject("item", item);
	        List<Master> itemList = MasterDao.list();
	        model.addObject("itemList", itemList);
		  /*ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("index");*/
	        return model;
	    }
	  
	  @RequestMapping(value="/edit")
	    public ModelAndView edit(@RequestParam(value="id", required=true) Long id) {
		  System.out.println("Id= " + id);
	        ModelAndView model = new ModelAndView("MasterAdd");
		   Master item=  MasterDao.getItem(id);
           model.addObject("item", item);
	       List<Master> itemList = MasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	
	
	  @RequestMapping(value="/delete")
	    public ModelAndView delete(@RequestParam(value="id", required=true) Long id) {
	        ModelAndView model = new ModelAndView("MasterAdd");
	        MasterDao.delete(id);
	       List<Master> itemList = MasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	    }
	
	  

	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public ModelAndView save(@ModelAttribute("item") Master item) {
	        System.out.println(item.getuniversityName());
	        if(null != item ) 
	        	MasterDao.add(item);
	         
	        ModelAndView model = new ModelAndView("MasterAdd");
			item=new Master();
	        model.addObject("item", item);
	        List<Master> itemList = MasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }
	  
	  @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public ModelAndView update(@ModelAttribute("item") Master item) {
	        System.out.println(item.getuniversityName());
	        if(null != item ) 
	        	MasterDao.update(item);
	         
	        ModelAndView model = new ModelAndView("MasterAdd");
			item=new Master();
	        model.addObject("item", item);
	        List<Master> itemList = MasterDao.list();
	        model.addObject("itemList", itemList);
	        return model;
	  }
	  

}


