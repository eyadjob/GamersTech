package gamersFun.com.example.gamersFun.service;

import gamersFun.com.example.gamersFun.utility.CollectionsConverter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericDaoService<T> {



    public List<T> getListRecordsWithRecordsSizeAndSorting(int pageIndex, int recordsSize, String sortingType, PagingAndSortingRepository daoInterface) {
        Pageable paginationSize;
        if ( sortingType.equals("descending")) {
            paginationSize = PageRequest.of(pageIndex, recordsSize, Sort.by("id").descending());
        } else  {
            paginationSize = PageRequest.of(pageIndex, recordsSize, Sort.by("id").ascending());
        }
        Iterable<T> newsPageEntities = daoInterface.findAll(paginationSize).getContent();
        return CollectionsConverter.getListFromIterator(newsPageEntities);
    }
}
