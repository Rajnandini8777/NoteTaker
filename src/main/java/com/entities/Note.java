package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	@Id
private int id;
private String title;
@Column(length=1500)
private String content;
private Date addedDate;
public void setId(int id)
{
	this.id=id;
}
public int getId()
{
	return this.id;
}
public String getTitle()
{
	return this.title;
}
public void setTitle(String title)
{
	this.title=title;
}
public void setContent(String content)
{
	this.content=content;
}

public String getContent()
{
	return this.content;
}
public Date getAddedDate()
{
	return this.addedDate;
}
public void setAddedDate(Date addedDate)
{
	this.addedDate=addedDate;
}
public Note(String title,String content,Date addedDate)
{
	super();
	this.id=new Random().nextInt(100000);
	this.title=title;
	this.content=content;
	this.addedDate=addedDate;
}
public Note()
{
	super();
}
}
