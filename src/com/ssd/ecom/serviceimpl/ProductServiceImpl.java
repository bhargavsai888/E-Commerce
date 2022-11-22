package com.ssd.ecom.serviceimpl;

import java.util.List;

import com.ssd.ecom.Daoimpl.ProductDaoimpl;
import com.ssd.ecom.Dto.ProductDto;
import com.ssd.ecom.dao.ProductDaoInter;
import com.ssd.ecom.service.ProductServiceInter;

public class ProductServiceImpl implements ProductServiceInter {

private ProductDaoInter  productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoimpl();
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		
		return productDao.GetAllProducts();
	}



}
