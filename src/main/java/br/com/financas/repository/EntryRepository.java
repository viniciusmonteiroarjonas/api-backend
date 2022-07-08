package br.com.financas.repository;

import br.com.financas.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

   List<Entry> findByPaid (boolean paid);
}
