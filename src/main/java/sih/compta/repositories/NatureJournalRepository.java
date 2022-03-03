package sih.compta.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import sih.compta.entities.NatureJournal;

public interface NatureJournalRepository extends JpaRepository<NatureJournal, Long> {
}
