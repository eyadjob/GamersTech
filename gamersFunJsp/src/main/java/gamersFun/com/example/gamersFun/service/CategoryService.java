package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    public void updateCategoryName(CategoryEntity newCategoryEntity) {
        categoryDao.save(newCategoryEntity);
    }
}
