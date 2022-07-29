package cvut.fel.service;

import cvut.fel.entity.AbstractEntity;

public interface AbstractService<E extends AbstractEntity> {

    E findById(Long id);
}
