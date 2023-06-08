package pl.wszib.pizzamarket.services;

        import jakarta.persistence.EntityNotFoundException;
        import jakarta.transaction.Transactional;
        import org.springframework.stereotype.Service;
        import pl.wszib.pizzamarket.data.entities.OpinionsEntity;
        import pl.wszib.pizzamarket.data.repositories.OpinionsRepository;
        import pl.wszib.pizzamarket.web.mappers.OpinionsMapper;
        import pl.wszib.pizzamarket.web.models.OpinionsModel;
        import java.util.List;

@Service
public class OpinionsService {

    private final OpinionsRepository opinionsRepository;
    private final OpinionsMapper opinionsMapper;


    public OpinionsService(OpinionsRepository opinionsRepository, OpinionsMapper opinionsMapper) {
        this.opinionsRepository = opinionsRepository;
        this.opinionsMapper = opinionsMapper;
    }


    public List<OpinionsModel> findAll(){
        List<OpinionsEntity>  entities = opinionsRepository.findAll();

        return entities.stream()
                .map(OpinionsMapper::toModel)
                .toList();
    }


    @Transactional
    public void addOpinion(OpinionsModel opinionsModel) {

        OpinionsEntity opinionsEntity = opinionsMapper.toEntity(opinionsModel);
        opinionsRepository.save(opinionsEntity);

    }

    public OpinionsModel getById(Long opinionId) {
        OpinionsEntity opinionsEntity = opinionsRepository.findById(opinionId).orElseThrow(EntityNotFoundException::new);
        return OpinionsMapper.toModel(opinionsEntity);
    }
}