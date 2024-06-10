package com.lacomer.api.incidencias.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.api.incidencias.models.dao.IArtiInvenDao;
import com.lacomer.api.incidencias.models.entity.ArtiInven;
import com.lacomer.api.incidencias.models.entity.Cliente;


@Service
public class ArtiInvenServiceImpl implements IArtiInvenService {

    @Autowired
    private IArtiInvenDao artiInvenDao;

    @Override
    public List<ArtiInven> findBySucursalId(Long sucursalId) {
        return artiInvenDao.findByIdSucursalId(sucursalId);
    }

    @Override
    public List<ArtiInven> findByArticuloId(Long articuloId) {
        return artiInvenDao.findByIdArticuloId(articuloId);
    }

    @Override
    public List<ArtiInven> findAll() {
        return artiInvenDao.findAll();
    }
    
    @Override
	@Transactional(readOnly = true)
	public Page<ArtiInven> findAll(Pageable pageable) {
		return artiInvenDao.findAll(pageable);
	}
}
