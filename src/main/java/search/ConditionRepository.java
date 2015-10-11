package search;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ConditionRepository extends ElasticsearchRepository<Condition, String> {

    public Condition findByName(String name);
}
