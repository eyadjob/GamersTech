package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.entity.CategoryEntity;
import gamersFun.com.example.gamersFun.entity.NewsPageEntity;
import gamersFun.com.example.gamersFun.entity.UserEntity;
import gamersFun.com.example.gamersFun.repository.NewsPageDao;
import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import gamersFun.com.example.gamersFun.utility.PropManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    NewsPageDao newsPageDao;

    @Autowired
    GenericDaoService genericDaoService;


    public ModelAndView populateAdminModelViewMessages(ModelAndView modelAndView, Map<String,String> newValuesMap) {
        modelAndView.getModel().put("categoryAdditionSuccessMessage","Category Added Successfully ...");
        ModelMap modelMap = new ModelMap();
        modelMap.putAll(PropManager.getInstance().getPropertiesAsStringMap());
        modelMap.putAll(newValuesMap);
        return modelAndView;
    }

    public ModelAndView populateAdminModelViewMessages(ModelAndView modelAndView) {
        modelAndView.getModel().put("categoryAdditionSuccessMessage","Category Added Successfully ...");
        modelAndView.getModel().put("categoryAdditionSuccessStatus","false");
        ModelMap modelMap = new ModelMap();
        modelMap.putAll(PropManager.getInstance().getPropertiesAsStringMap());
        return modelAndView;
    }

    public List<NewsPageEntity> getListOfNewsPageWithRecordsSizeAndSorting(int pageIndex, int recordsSize, String sortingType) {
        Pageable paginationSize;
        if ( sortingType.equals("descending")) {
             paginationSize = PageRequest.of(pageIndex, recordsSize, Sort.by("id").descending());
        } else  {
             paginationSize = PageRequest.of(pageIndex, recordsSize, Sort.by("id").ascending());
        }
        Iterable<NewsPageEntity> newsPageEntities = newsPageDao.findAll(paginationSize).getContent();
        return CollectionsConverter.getListFromIterator(newsPageEntities);
    }
  c

}
