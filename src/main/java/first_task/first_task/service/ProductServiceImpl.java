package first_task.first_task.service;

import first_task.first_task.entity.Product;
import first_task.first_task.repository.BaseRepository;


public class ProductServiceImpl extends CRUDServiceImpl<ProductService,Product> implements ProductService {

    public ProductServiceImpl(BaseRepository<Product> baseRepository) {
        super(baseRepository);
    }


}
