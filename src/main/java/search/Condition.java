package search;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "conditions", type = "condition", shards = 1, replicas = 0, refreshInterval = "-1", indexStoreType = "memory")
public class Condition {

    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
