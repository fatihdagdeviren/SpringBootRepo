package Repository;

import com.haydikodlayalim.entity.Kisi;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableElasticsearchRepositories
public interface KisiRepository extends ElasticsearchRepository<Kisi, String> {

    @Query("{ \"bool\" : { \"must\" : { \"match\" : { \"ad\" : \"?0\" } } } }")
    List<Kisi> getByCustomQuery(String search);
}
