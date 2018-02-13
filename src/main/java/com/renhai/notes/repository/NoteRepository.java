package com.renhai.notes.repository;

import com.renhai.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hai on 2/12/18.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
}
