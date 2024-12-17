package planteMedicinale.plante.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import planteMedicinale.plante.dto.ArticleDTO;
import planteMedicinale.plante.entity.Article;
import planteMedicinale.plante.repo.ArticleRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleDTO> getAllArticles() {
        // Convertir Iterable en Stream pour pouvoir utiliser la méthode stream()
        return StreamSupport.stream(articleRepository.findAll().spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ArticleDTO convertToDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitre(article.getTitre());
        dto.setContenu(article.getContenu());
        dto.setAuteur(article.getAuteur());
        dto.setDatePublication(article.getDatePublication());
        dto.setPlanteNom(article.getPlante() != null ? article.getPlante().getNom() : null);
        return dto;
    }
}
