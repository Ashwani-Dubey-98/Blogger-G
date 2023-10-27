package Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.text.blog.blog;

@Controller
public class AddContoller {

	@RequestMapping("/addblog")
	public ModelAndView addblog() {
		return new ModelAndView("addblog");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("home");
	}

	@RequestMapping("/searchblog")
	public ModelAndView searchblog(HttpServletRequest request, HttpServletResponse response) throws IOException {
   
		Session session1 = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        String s = request.getParameter("q");
		Criteria c = session1.createCriteria(blog.class);
		Criterion cq = Restrictions.like("blogtext", s, MatchMode.ANYWHERE);
        c.add(cq);
		
		List<blog> lst= c.list();
		if(lst.size()>=0)
		{
			return new ModelAndView("searchblog","key",lst);}
		else
		{ 	
			PrintWriter out= response.getWriter();
			out.println("No Blog Found");
			return new ModelAndView("searchblog");
		}
	}
	
	@RequestMapping("/addbloglogic")
	public ModelAndView addbloglogic(@RequestParam CommonsMultipartFile file, HttpServletRequest request, HttpSession session1) throws IOException {
			
		String path =session1.getServletContext().getRealPath("/")+"img";
		String filename =file.getOriginalFilename();
		byte bytes[]= file.getBytes();
		BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(path+"/"+filename)));
		stream.write(bytes);
		stream.flush();
		stream.close();
		 
		    Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
			Transaction tx = session.beginTransaction();

	        blog b= new blog();
			b.setTitle(request.getParameter("title"));
			b.setBlogtext(request.getParameter("blogtext"));
            b.setAddeddate(new Date());
            b.setPath(filename);
			
	        session.save(b);
			tx.commit();
			session.close();
			return new ModelAndView("addblog","blog_added","Successfully! Blog added.");		
		}
}