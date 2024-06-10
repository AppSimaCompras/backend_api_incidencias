package com.lacomer.api.incidencias.models.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lacomer.api.incidencias.models.dao.ITicketDao;
import com.lacomer.api.incidencias.models.entity.Cliente;
import com.lacomer.api.incidencias.models.entity.Ticket;

@Service
public class TicketServiceImpl implements ITicketService{

	
	@Autowired
	private ITicketDao ticketDao;
	
	
	@Override
    @Transactional(readOnly = true)
    public Set<Ticket> findAll() {
        List<Ticket> allTickets = ticketDao.findAll();
        return new HashSet<>(allTickets); // Elimina duplicados al convertir a HashSet
    }
	
	
	@Override
	@Transactional(readOnly = true)
	public Page<Ticket> findAll(Pageable pageable) {
		return ticketDao.findAll(pageable);
	}
	
	
	
	@Override
    @Transactional(readOnly = true)
    public Set<Ticket> findByGroupedId(String id) {
        return ticketDao.findByGroupedId(id);
    }

	
}
