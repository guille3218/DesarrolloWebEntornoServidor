package org.iesalixar.servidor.hibernate;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.model.Comment;
import org.iesalixar.servidor.hibernate.model.Post;
import org.iesalixar.servidor.hibernate.model.User;
import org.iesalixar.servidor.hibernate.services.CommentService;
import org.iesalixar.servidor.hibernate.services.CommentServiceImpl;
import org.iesalixar.servidor.hibernate.services.PostService;
import org.iesalixar.servidor.hibernate.services.PostServiceImpl;
import org.iesalixar.servidor.hibernate.services.UserService;
import org.iesalixar.servidor.hibernate.services.UserServiceImpl;
import org.iesalixar.servidor.hibernate.utils.HibernateUtils;

public class Main {
public static void main(String[] args) {
	
	Calendar calendar = Calendar.getInstance();
	
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	CommentService commentService = new CommentServiceImpl(session);
	PostService postService = new PostServiceImpl(session);
	UserService userService = new UserServiceImpl(session);
	
	//Creacion de Usuarios
	
	User u1 = new User();
	u1.setFirstName("Guillermo");
	u1.setLastName("Moreno");
	u1.setPassword("1234");
	u1.setUsername("guille");
	u1.setEmail("guille@gmail.com");
	
	User u2 = new User();
	u2.setFirstName("Fernando");
	u2.setLastName("Moreno");
	u2.setPassword("1234");
	u2.setUsername("fer");
	u2.setEmail("fer@gmail.com");
	
	//Creacion posts
	
	calendar.set(Calendar.YEAR, 2022);
	calendar.set(Calendar.MONTH, 1);
	calendar.set(Calendar.DAY_OF_MONTH, 31);
	
	Post p1 = new Post();
	p1.setTitle("A");
	p1.setContent("a");
	p1.setDate(calendar.getTime());
	
	Post p2 = new Post();
	p2.setTitle("B");
	p2.setContent("b");
	p2.setDate(calendar.getTime());
	
	Post p3 = new Post();
	p3.setTitle("C");
	p3.setContent("c");
	p3.setDate(calendar.getTime());
	
	Post p4 = new Post();
	p4.setTitle("D");
	p4.setContent("d");
	p4.setDate(calendar.getTime());
	
	Post p5 = new Post();
	p5.setTitle("E");
	p5.setContent("e");
	p5.setDate(calendar.getTime());

	
	//Creacion comentarios
	
	Comment c1 = new Comment();
	c1.setTitle("Dislike");
	c1.setContent("No me ha gustado este post");
	
	Comment c2 = new Comment();
	c2.setTitle("Like");
	c2.setContent("Me ha encantado");
	
	Comment c3 = new Comment();
	c3.setTitle("Neutral");
	c3.setContent("No está mal pero tampoco es de lo mejor");
	
	//Insertar usuarios
	userService.insertNewUser(u1);
	userService.insertNewUser(u2);
	
	//Insertar Posts
	postService.insertNewPost(p1);
	postService.insertNewPost(p2);
	postService.insertNewPost(p3);
	postService.insertNewPost(p4);
	postService.insertNewPost(p5);

	//insertar comentarios
	commentService.insertNewComment(c1);
	commentService.insertNewComment(c2);
	commentService.insertNewComment(c3);
	
	//relaciones
	u1.addComment(c1);
	u2.addComment(c2);
	u2.addComment(c3);
	
	userService.updateUser(u1);
	userService.updateUser(u2);
	
	p2.addComment(c1);
	p1.addComment(c2);
	p1.addComment(c3);
	
	
	postService.updatePost(p1);
	postService.updatePost(p2);
	
	
	u1.addPost(p1);
	u1.addPost(p2);
	u1.addPost(p3);
	u2.addPost(p4);
	u2.addPost(p5);
	
	userService.updateUser(u1);
	userService.updateUser(u2);
	
	p1.addValuation(u1, 4.00);
	p1.addValuation(u2, 4.00);
	p2.addValuation(u1, 4.00);
	p2.addValuation(u2, 4.00);
	p3.addValuation(u1, 4.00);
	p3.addValuation(u2, 4.00);
	p4.addValuation(u1, 4.00);
	p4.addValuation(u2, 4.00);
	p5.addValuation(u1, 4.00);
	p5.addValuation(u2, 4.00);
	
	postService.updatePost(p1);
	postService.updatePost(p2);
	

	//cerrar sesion
	
	session.close();

	
	
}
}
