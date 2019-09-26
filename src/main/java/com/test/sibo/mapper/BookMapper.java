package com.test.sibo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.sibo.entity.Book;

@Mapper
public interface  BookMapper {
	public List<Book> getBook();
	
}
