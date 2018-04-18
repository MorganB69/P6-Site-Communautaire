package fr.mb.projet.converter;

import java.util.Comparator;
import java.util.Date;

import fr.mb.projet.bean.comment.Comment;

public class DateComp implements Comparator<Comment>{

	public int compare(Comment com1, Comment com2) {
		Date date1=com1.getDate();
		Date date2=com2.getDate();
		return date2.compareTo(date1);
	}



}
