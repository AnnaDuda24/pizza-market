package pl.wszib.pizzamarket.web.mappers;

        import org.springframework.stereotype.Component;
        import pl.wszib.pizzamarket.data.entities.OpinionsEntity;
        import pl.wszib.pizzamarket.web.models.OpinionsModel;

@Component
public class OpinionsMapper {

    public static OpinionsEntity toEntity(OpinionsModel opinionsModel) {
        OpinionsEntity opinionsEntity = new OpinionsEntity();
        opinionsEntity.setName(opinionsModel.getName());
        opinionsEntity.setContent(opinionsModel.getContent());
        return opinionsEntity;
    }


    public static OpinionsModel toModel(OpinionsEntity opinionsEntity) {
        OpinionsModel opinionsModel = new OpinionsModel();
        opinionsModel.setName(opinionsEntity.getName());
        opinionsModel.setContent(opinionsEntity.getContent());
        return opinionsModel;

    }

}
