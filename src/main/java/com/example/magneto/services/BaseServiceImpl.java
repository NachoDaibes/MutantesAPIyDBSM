package com.example.magneto.services;

import com.example.magneto.Repositories.BaseRepository;
import com.example.magneto.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E,ID>{
    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository <E,ID> baseRepository){
        this.baseRepository = baseRepository;
    }

    @Override
    public E save(E entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
