package org.escapar.cms.business.domain.category;

import java.util.List;

import org.escapar.leyline.framework.domain.LeylineRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends LeylineRepo<Category> {
    public Category findByAliasIgnoreCase(String name);
    public List<Category> findByReferenceIsNotNull();
    public List<Category> findByReferenceIsNull();

}
