package project;

import java.io.Serializable;

public class News implements Serializable  {
	String article = "", content= "";
	Manager author;
	public News () {
		this.author = new Manager();
	}
	public void setAuthor(Manager c) {
		this.author = c;
	}
	public void setArticle (String a) {
		this.article = a;
	}
	public void setContent (String c) {
		this.content = c;
	}
	public String toString1() {
	    return this.author  + " " + this.article + " " + this.content;
	 }
}
