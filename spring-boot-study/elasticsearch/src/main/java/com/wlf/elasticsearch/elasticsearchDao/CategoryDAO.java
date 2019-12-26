package com.wlf.elasticsearch.elasticsearchDao;

import com.wlf.elasticsearch.entity.Category;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryDAO extends ElasticsearchRepository<Category,Integer> {
 
}