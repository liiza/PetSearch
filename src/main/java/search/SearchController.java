package search;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    ConditionRepository repository;


    @RequestMapping("/")
    public void saveCondition(){
        System.out.println("Saving condition");
        String documentId = "123456";
        Condition condition = new Condition();
        condition.setId(documentId);
        condition.setName("Ankle pain");

        repository.save(condition);
    }

    @RequestMapping("/search")
    public String searchByName(){
        Condition condition = repository.findByName("Ankle pain");
        System.out.println(condition.getName());
        return condition.getName();
    }
}
