package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDao;
	
	@Inject
	private ICategoryDAO categoryDao;
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDao.findByCategoryId(categoryId);
	}
	@Override
	public NewsModel save(NewsModel newsModel) {
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long newsId = newsDao.save(newsModel);
		System.out.println(newsId);
		return newsDao.findOne(newsId);
	}
	@Override
	public NewsModel update(NewsModel updateNews) {
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}
	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for (long id : ids) {
			newsDao.delete(id);
		}
	}
	@Override
	public List<NewsModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newsDao.findAll(pageble);
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return newsDao.getTotalItem();
	}
	@Override
	public NewsModel findOne(Long id) {
		// TODO Auto-generated method stub
		NewsModel newsModel = newsDao.findOne(id);
		CategoryModel categoryModel = categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
