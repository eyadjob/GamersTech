package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.repository.CategoryDao;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    GenericDaoService genericDaoService;

    public void updateCategoryName(CategoryEntity newCategoryEntity) {
        categoryDao.save(newCategoryEntity);
    }

    public List getListOfCategoriesWithRecordsSizeAndSorting2(int pageIndex, int recordsSize, String sortingType) {
        return genericDaoService.getListRecordsWithRecordsSizeAndSorting(pageIndex,recordsSize,sortingType,categoryDao);
    }
}
