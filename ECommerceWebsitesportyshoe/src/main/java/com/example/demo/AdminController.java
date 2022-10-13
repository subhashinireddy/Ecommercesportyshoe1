package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	Logger log = Logger.getAnonymousLogger();
	String uName;
	@Autowired	ProductDAO dao;
	@Autowired UserRepo repo;
	@Autowired UserDAO udao;


	@RequestMapping("/")
	public ModelAndView loadfrontpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		log.info("in request mapping /");
		mv.setViewName("index.jsp");
		log.info("loaded index page");
		return mv;
	}

	@RequestMapping("/admin")
	public ModelAndView loadfadminpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		log.info("in request mapping /admin");
		List<Product> list = dao.getAll();
		mv.setViewName("displayproduct.jsp");
		mv.addObject("list", list);
		log.info("\"displayproduct.jsp");
		return mv;
	}

	@RequestMapping("/add")
	public ModelAndView loadfaddpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		log.info("in request mapping /add");
		mv.setViewName("insert.jsp");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		p.setName(request.getParameter("name"));
		p.setCost(Double.parseDouble(request.getParameter("cost")));
		Product ss = dao.insert(p);
		if (ss != null) {
			mv.setViewName("display.jsp");
		} else {
			mv.setViewName("fail");
		}
		return mv;
	}

	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Product> list = dao.getAll();
		mv.setViewName("displayproduct.jsp");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside edit");
		ModelAndView mv = new ModelAndView();
		Product s = new Product();
		s.setId(Integer.parseInt(request.getParameter("row")));
		s.setName(request.getParameter("name"));
		s.setCost(Double.parseDouble(request.getParameter("cost")));
		dao.updatebyname(s);
		List<Product> list = dao.getAll();
		mv.setViewName("displayproduct.jsp");
		mv.addObject("list", list);
		return mv;

	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		System.out.println("inside edit");
		Product p = new Product();
		int deleteId = Integer.parseInt(request.getParameter("id"));
		dao.delete(deleteId);
		List<Product> listAfterDelete = dao.getAll();
		mv.setViewName("displaysproduct.jsp");
		mv.addObject("list", listAfterDelete);
		return mv;
	}

	@RequestMapping("/user")
	public ModelAndView usergetall(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in user");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Userlogin.jsp");
		return mv;

	}
	@RequestMapping("/login")
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		log.info("inside the request mapping /login ");
		String user = request.getParameter("name");
		uName=user;
		log.info("uName: "+ uName);
		String password = request.getParameter("password");
		log.info("recieved the data of user and password" + user + ":" + password);
		if ((repo.findByUser(user) != null)&&(repo.findByPassword(password) != null)) {
			log.info(repo.findByUser(user) + " " + repo.findByPassword(password));
			Optional<User> obj1 = (repo.findByUser(user));
			Optional<User> obj2 = (repo.findByPassword(password));
			if (obj1.isPresent() && obj2.isPresent()) {
				if (obj1.equals(obj2)) { 
					log.info("login is success");
					mv.setViewName("userdisplay.jsp");
					List<Product>list= dao.getAll();
					mv.setViewName("userdisplay.jsp");
					mv.addObject("list", list);
					mv.addObject("uName", uName);
					log.info("control passed to display.jsp");
				} 
				else {
					mv.setViewName("fail.jsp");
					log.info("control passed to fail.jsp");
				}
			}
				else {
					mv.setViewName("fail.jsp");
					log.info("control passed to fail.jsp");
				}
		}
				else {
					mv.setViewName("fail.jsp");
					log.info("control passed to fail.jsp");
				}

		return mv;
	}@RequestMapping("/registerms")
	public ModelAndView registerms(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User user=new User();
		log.info("inside register map /registerms");
		String name=request.getParameter("user");
		String password=request.getParameter("password");
		log.info("Registration user and pwd is " + name + "and" + password); 
		user.setUser(name);
		user.setPassword(password);
		udao.updatebyname(user);
		List<Product> list = dao.getAll();
			mv.addObject("list", list);
		mv.setViewName("userdisplay.jsp");
		return mv; 
		}

	@RequestMapping("/buy")
public ModelAndView Additem(HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	User user=new User();
	String name=request.getParameter("name");
	String costval=request.getParameter("cost");
	Double cost=Double.parseDouble(costval);
	mv.setViewName("payment.jsp");
	mv.addObject("name", name);
	mv.addObject("cost", cost);
	return mv; 
	 
}	@RequestMapping("/pay")
public ModelAndView payforitem(HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	User user=new User();
	log.info("inside pay map ");
	String name=request.getParameter("name");
	String cost=request.getParameter("cost");
	mv.setViewName("confirmation.jsp");
	mv.addObject("name", name);
	mv.addObject("cost", cost);
	return mv; 
	
}@RequestMapping("/ordermore")
public ModelAndView ordermoreitems(HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mv = new ModelAndView();
	User user=new User();
	List<Product> list = dao.getAll();
	mv.setViewName("userdisplay.jsp");
	mv.addObject("list", list);
	mv.addObject("uName",uName);
	log.info("uName in ordermore: " +uName);
	return mv; 
}
}