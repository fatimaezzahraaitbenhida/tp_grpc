package planteMedicinale.plante.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import planteMedicinale.plante.entity.Article;

import java.util.List;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();  // Récupérer tous les articles
}

