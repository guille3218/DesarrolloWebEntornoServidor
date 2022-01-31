package org.iesalixar.servidor.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ValuationID.class)
public class Valuation implements Serializable{

	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id",insertable = false, updatable = false)
	private User user;
	
	@Id
	@ManyToOne
	@JoinColumn(name="post_id",insertable = false, updatable = false)
	private Post post;
	
	
	private Double score;
	
	public Valuation() {
		// TODO Auto-generated constructor stub
	}

	public Valuation(User user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}

	public Valuation(User user, Post post, Double score) {
		super();
		this.user = user;
		this.post = post;
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, score, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuation other = (Valuation) obj;
		return Objects.equals(post, other.post) && Objects.equals(score, other.score)
				&& Objects.equals(user, other.user);
	}
	
	
}
